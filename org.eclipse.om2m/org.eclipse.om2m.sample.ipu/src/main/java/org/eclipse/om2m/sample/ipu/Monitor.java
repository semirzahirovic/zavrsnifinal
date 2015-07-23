package org.eclipse.om2m.sample.ipu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;

import obix.Obj;
import obix.io.ObixDecoder;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.om2m.comm.http.RestHttpServlet;
import org.eclipse.om2m.commons.resource.Application;
import org.eclipse.om2m.commons.resource.Container;
import org.eclipse.om2m.commons.resource.ContentInstance;
import org.eclipse.om2m.commons.resource.StatusCode;
import org.eclipse.om2m.commons.rest.RequestIndication;
import org.eclipse.om2m.commons.rest.ResponseConfirm;
import org.eclipse.om2m.core.controller.ContentController;
import org.eclipse.om2m.core.service.SclService;

import resources.AlarmResource;
import resources.PeriodicReportResource;
import resources.SensorResource;

import com.rapplogic.xbee.api.XBeeException;

public class Monitor {
	static SclService core;
	static String sclId = System.getProperty("org.eclipse.om2m.sclBaseId", "");
	static String reqEntity = System.getProperty(
			"org.eclipse.om2m.adminRequestingEntity", "");
	static String ipuId = "sample";
	static String appID = "Report", appID2 = "Alarm";
	static Integer type;
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/spartacus";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "admin";
	Connection conn = null;
	Statement stmt = null;
	int lastReportsID = 1,reportsID = 0;;

	static SensorResource sensorResource;
	static PeriodicReportResource periodicReportResource;
	static AlarmResource alarmResource;
	private ArrayList<Integer> reportIds;

	public Monitor(SclService sclService) {
		core = sclService;
		// STEP 2: Register JDBC driver

	}

	public void start() throws XBeeException, ClassNotFoundException,
			SQLException {
		// STEP 2: Register JDBC driver
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(DB_URL, USER, PASS);
		stmt = conn.createStatement();
		createResources();
		listenToDatabase();
	}

	public void createResources() throws XBeeException {
		sensorResource = new SensorResource();
		periodicReportResource = new PeriodicReportResource();
		alarmResource = new AlarmResource();

		String targetId, content;
		targetId = sclId + "/applications";
		ResponseConfirm responseConfirm = core.doRequest(new RequestIndication(
				"CREATE", targetId, reqEntity, new Application(appID, ipuId)));
		if (responseConfirm.getStatusCode().equals(StatusCode.STATUS_CREATED)) {
			targetId = sclId + "/applications/" + appID + "/containers";
			// create resources container
			core.doRequest(new RequestIndication("CREATE", targetId, reqEntity,
					new Container("ReportDataContainer")));

			// create descriptors containter
			core.doRequest(new RequestIndication("CREATE", targetId, reqEntity,
					new Container("ReportDataDescriptor")));

			// create resources container
			content = Mapper.getResourcesRep(sclId, appID, ipuId);
			targetId = sclId + "/applications/" + appID
					+ "/containers/ReportDataDescriptor/contentInstances";
			core.doRequest(new RequestIndication("CREATE", targetId, reqEntity,
					new ContentInstance(content.getBytes())));
		}

		targetId = sclId + "/applications";
		ResponseConfirm responseConfirm1 = core
				.doRequest(new RequestIndication("CREATE", targetId, reqEntity,
						new Application(appID2, ipuId)));
		if (responseConfirm1.getStatusCode().equals(StatusCode.STATUS_CREATED)) {
			targetId = sclId + "/applications/" + appID2 + "/containers";
			// create resources container
			core.doRequest(new RequestIndication("CREATE", targetId, reqEntity,
					new Container("AlarmDataContainer")));

			// create descriptors containter
			core.doRequest(new RequestIndication("CREATE", targetId, reqEntity,
					new Container("AlarmDataDescriptor")));

			targetId = sclId + "/applications/" + appID2
					+ "/containers/AlarmDataDescriptor/contentInstances";
			content = Mapper.getAlarmDataDescriptorRep(sclId, appID2, ipuId);
			core.doRequest(new RequestIndication("CREATE", targetId, reqEntity,
					new ContentInstance(content.getBytes())));
		}
	}

	public void listenToDatabase() throws SQLException {
		new Thread() {
			public void run() {
				while (true) {
					String sql;
					ResultSet rs = null;

					if (!RestHttpServlet.addedFromWeb) {

						sql = "SELECT id FROM reports order by id desc Limit 1";

						try {
							rs = stmt.executeQuery(sql);
							// STEP 5: Extract data from result set
							while (rs.next()) {
								reportsID = rs.getInt("id");
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						try {
							rs.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						sql = "SELECT id FROM reports Limit "
								+ String.valueOf(lastReportsID-1)+"," + String.valueOf(reportsID - lastReportsID);
						reportIds = new ArrayList<Integer>();
						try {
							rs = stmt.executeQuery(sql);
							// STEP 5: Extract data from result set
							while (rs.next()) {
								reportIds.add(rs.getInt("id"));
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						try {
							rs.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						Iterator it = reportIds.iterator();
						while (it.hasNext()) {
							int tempRreportsId = (int) it.next();
							if (tempRreportsId > lastReportsID) {
								// sql upit ka bazi reports
								sql = "SELECT * FROM reports WHERE id="
										+ tempRreportsId;
								try {
									rs = stmt.executeQuery(sql);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								;
								try {
									while (rs.next()) {
										type = rs.getInt("priority");
										if (type <= 3) {
											periodicReportResource
													.setPacketID(rs
															.getInt("id"));
											periodicReportResource
													.setPacketType(rs
															.getInt("report_type"));
											periodicReportResource
													.setPacketPriority(rs
															.getInt("priority"));
											periodicReportResource
													.setDeviceID(rs
															.getInt("device_id"));
										} else {
											alarmResource.setPacketID(rs
													.getInt("id"));
											alarmResource.setPacketType(rs
													.getInt("report_type"));
											alarmResource.setPacketPriority(rs
													.getInt("priority"));
											alarmResource.setDeviceId(rs
													.getInt("device_id"));
										}
									}
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								try {
									rs.close();
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								// upit ka sensor_readings tabeli

								Integer sensorProfileFK = null;
								sql = "SELECT * FROM sensor_readings WHERE report_id="
										+ tempRreportsId;
								try {
									rs = stmt.executeQuery(sql);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								;
								try {
									while (rs.next()) {
										sensorResource.setValue(rs
												.getDouble("sensor_value"));
										sensorProfileFK = rs
												.getInt("sensor_profile_id");
										sensorResource
												.setSensorProfileId(sensorProfileFK);

									}
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								try {
									rs.close();
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								if (sensorProfileFK != null) {
									sql = "SELECT * FROM sensor_profiles WHERE id="
											+ sensorProfileFK.intValue();
									try {
										rs = stmt.executeQuery(sql);
									} catch (SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									;
									try {
										while (rs.next()) {
											sensorResource.setSensorName(rs
													.getString("sensor_name"));
											sensorResource.setSensorTypeID(rs
													.getInt("sensor_type"));

										}
									} catch (SQLException e) {
										// TODO Auto-generaioted catch block
										e.printStackTrace();
									}

								}
								try {
									rs.close();
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

								sql = "SELECT * FROM spartacus.positioning WHERE report_id="
										+ tempRreportsId;
								try {
									rs = stmt.executeQuery(sql);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								;
								try {
									while (rs.next()) {
										if (type <= 3) {
											ArrayList<String> nmeaMessages = new ArrayList<String>();
											nmeaMessages.add(rs
													.getString("NMEARMC"));
											nmeaMessages.add(rs
													.getString("NMEAGGA"));
											nmeaMessages.add(rs
													.getString("NMEAGST"));
											nmeaMessages.add(rs
													.getString("NMEAPRDID"));
											periodicReportResource
													.setNMEAMessage(nmeaMessages);
										}
									}
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								try {
									rs.close();
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								String content;
								if (type <= 3) {
									periodicReportResource
											.setSensorResource(sensorResource);
									content = Mapper
											.getResourcesDataRep(periodicReportResource);
								} else {
									alarmResource
											.setSensorResource(sensorResource);
									content = Mapper
											.getAlarmResource(alarmResource);
								}
								String targetID;
								if (type < 3) {
									targetID = sclId
											+ "/applications/"
											+ appID
											+ "/containers/ReportDataContainer/contentInstances";
								} else {
									targetID = sclId
											+ "/applications/"
											+ appID2
											+ "/containers/AlarmDataContainer/contentInstances";
								}
								core.doRequest(new RequestIndication("CREATE",
										targetID, reqEntity, content));
								lastReportsID = tempRreportsId;
							}
						}
					}
					if (RestHttpServlet.addedFromWeb) {
						try {
							Mapper.decodeStream();

						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

						RestHttpServlet.addedFromWeb = false;
					}
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}.start();
	}

	public void stop() throws SQLException {
		if (stmt != null)
			stmt.close();
		if (conn != null)
			conn.close();
	}
}