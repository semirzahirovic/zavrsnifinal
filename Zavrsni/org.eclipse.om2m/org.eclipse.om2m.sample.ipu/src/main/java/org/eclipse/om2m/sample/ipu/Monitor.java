package org.eclipse.om2m.sample.ipu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.eclipse.om2m.commons.resource.Application;
import org.eclipse.om2m.commons.resource.Container;
import org.eclipse.om2m.commons.resource.ContentInstance;
import org.eclipse.om2m.commons.resource.StatusCode;
import org.eclipse.om2m.commons.rest.RequestIndication;
import org.eclipse.om2m.commons.rest.ResponseConfirm;
import org.eclipse.om2m.core.service.SclService;

import com.rapplogic.xbee.api.XBeeException;

public class Monitor {
	static SclService core;
	static String sclId = System.getProperty("org.eclipse.om2m.sclBaseId", "");
	static String reqEntity = System.getProperty(
			"org.eclipse.om2m.adminRequestingEntity", "");
	static String ipuId = "sample";
	// static String actuatorId = "MY_ACTUATOR";
	static String xbeeId = "MY_XBEE";
	static int xbeeValue = 0;
	// static boolean actuatorValue = false;
	// static int sensorValue = 0;
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/test";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "admin";
	Connection conn = null;
	Statement stmt = null;
	int lastId=0;

	public Monitor(SclService sclService){
		core = sclService;
		// STEP 2: Register JDBC driver

	}

	public void start() throws XBeeException, ClassNotFoundException, SQLException {
		// // Create required resources for the Sensor
		// createSensorResources();
		// // Listen for the Sensor data
		// listenToSensor();
		//
		// // Create required resources for the Actuator
		// createActuatorResources();
		// // Listen for the Actuator data
		// listenToActuator();
		// STEP 2: Register JDBC driver
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(DB_URL, USER, PASS);
		stmt = conn.createStatement();
		createXBeeResources();
		listenToXBee();
	}

	public void createXBeeResources() throws XBeeException {

		String targetId, content;
		targetId = sclId + "/applications";
		ResponseConfirm responseConfirm = core.doRequest(new RequestIndication(
				"CREATE", targetId, reqEntity, new Application(xbeeId, ipuId)));
		if (responseConfirm.getStatusCode().equals(StatusCode.STATUS_CREATED)) {
			targetId = sclId + "/applications/" + xbeeId + "/containers";
			core.doRequest(new RequestIndication("CREATE", targetId, reqEntity,
					new Container("DESCRIPTOR")));
			core.doRequest(new RequestIndication("CREATE", targetId, reqEntity,
					new Container("DATA")));
			// Create the description contentInstance
			content = Mapper.getXBeeDescriptorRep(sclId, xbeeId, ipuId);
			targetId = sclId + "/applications/" + xbeeId
					+ "/containers/DESCRIPTOR/contentInstances";
			core.doRequest(new RequestIndication("CREATE", targetId, reqEntity,
					new ContentInstance(content.getBytes())));
			content = Mapper.getXbeeDataRep(xbeeValue);
			targetId = sclId + "/applications/" + xbeeId
					+ "/containers/DATA/contentInstances";
			core.doRequest(new RequestIndication("CREATE", targetId, reqEntity,
					new ContentInstance(content.getBytes())));

		}
	}

	public void listenToXBee() {
		String sql;
		sql = "SELECT idpeople FROM people ORDER BY idpeople DESC LIMIT 1";
		ResultSet rs;
		try {
			rs = stmt.executeQuery(sql);
			// STEP 5: Extract data from result set
			while (rs.next()) {
		    lastId = rs.getInt("idpeople");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread() {
			public void run() {
				while (true) {
					String sql;
					sql = "SELECT idpeople FROM people ORDER BY idpeople DESC LIMIT 1";
					ResultSet rs;
					int id = 0;
					try {
						rs = stmt.executeQuery(sql);
						// STEP 5: Extract data from result set
						while (rs.next()) {
					   id = rs.getInt("idpeople");
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
			
					// Retrieve by column name
					 // Create a data contentInstance
					if(id>lastId){
						xbeeValue = id;
					String content = Mapper.getXbeeDataRep(xbeeValue);
					 String targetID = sclId + "/applications/" + xbeeId
					 + "/containers/DATA/contentInstances";
					 core.doRequest(new RequestIndication("CREATE", targetID,reqEntity,
					 content));
					 lastId= id;
				}
			}
			}
		}.start();
	}
	// public void createSensorResources() {
	// String targetId, content;
	//
	// // Create the MY_SENSOR application
	// targetId = sclId + "/applications";
	// ResponseConfirm response = core
	// .doRequest(new RequestIndication("CREATE", targetId, reqEntity,
	// new Application(sensorId, ipuId)));
	//
	// if (response.getStatusCode().equals(StatusCode.STATUS_CREATED)) {
	// // Create the "DESCRIPTOR" container
	// targetId = sclId + "/applications/" + sensorId + "/containers";
	// core.doRequest(new RequestIndication("CREATE", targetId, reqEntity,
	// new Container("DESCRIPTOR")));
	//
	// // Create the "DATA" container
	// core.doRequest(new RequestIndication("CREATE", targetId, reqEntity,
	// new Container("DATA")));
	//
	// // Create the description contentInstance
	// content = Mapper.getSensorDescriptorRep(sclId, sensorId, ipuId);
	// targetId = sclId + "/applications/" + sensorId
	// + "/containers/DESCRIPTOR/contentInstances";
	// core.doRequest(new RequestIndication("CREATE", targetId, reqEntity,
	// new ContentInstance(content.getBytes())));
	//
	// // Create the data contentInstance
	// content = Mapper.getSensorDataRep(sensorValue);
	// targetId = sclId + "/applications/" + sensorId
	// + "/containers/DATA/contentInstances";
	// core.doRequest(new RequestIndication("CREATE", targetId, reqEntity,
	// new ContentInstance(content.getBytes())));
	// }
	// }
	//
	// public void createActuatorResources() {
	// String targetId, content;
	//
	// // Create the "MY_ACTUATOR" application
	// targetId = sclId + "/applications";
	// ResponseConfirm response = core.doRequest(new RequestIndication(
	// "CREATE", targetId, reqEntity, new Application(actuatorId,ipuId)));
	//
	// if (response.getStatusCode().equals(StatusCode.STATUS_CREATED)) {
	// // Create the "DESCRIPTOR" container
	// targetId = sclId + "/applications/" + actuatorId + "/containers";
	// core.doRequest(new RequestIndication("CREATE", targetId, reqEntity,
	// new Container("DESCRIPTOR")));
	//
	// // Create the "DATA" container
	// core.doRequest(new RequestIndication("CREATE", targetId, reqEntity,
	// new Container("DATA")));
	//
	// // Create the description contentInstance
	// content = Mapper.getActutaorDescriptorRep(sclId, actuatorId, ipuId);
	// targetId = sclId + "/applications/" + actuatorId
	// + "/containers/DESCRIPTOR/contentInstances";
	// core.doRequest(new RequestIndication("CREATE", targetId, reqEntity,
	// content));
	//
	// // Create the data contentInstance
	// content = Mapper.getActuatorDataRep(actuatorValue);
	// targetId = sclId + "/applications/" + actuatorId
	// + "/containers/DATA/contentInstances";
	// core.doRequest(new RequestIndication("CREATE", targetId, reqEntity,
	// content));
	// }
	// }
	//
	// public void listenToSensor() {
	// new Thread() {
	// public void run() {
	// while (true) {
	// // Simualte a random measurement of the sensor
	// sensorValue = 10 + (int) (Math.random() * 100);
	//
	// // Create a data contentInstance
	// String content = Mapper.getSensorDataRep(sensorValue);
	// String targetID = sclId + "/applications/" + sensorId
	// + "/containers/DATA/contentInstances";
	// core.doRequest(new RequestIndication("CREATE", targetID,reqEntity,
	// content));
	//
	// // Wait for 2 seconds then loop
	// try {
	// Thread.sleep(2000);
	// } catch (InterruptedException e) {
	// e.printStackTrace();
	// }
	// }
	// }
	// }.start();
	// }
	//
	// public void listenToActuator() {
	// new Thread() {
	// public void run() {
	//
	// boolean memorizedActuatorValue = false;
	// while (true) {
	// // If the Actuator state has changed
	// if (memorizedActuatorValue != actuatorValue) {
	// // Memorize the new Actuator state
	// memorizedActuatorValue = actuatorValue;
	//
	// // Create a data contentInstance
	// String content = Mapper.getActuatorDataRep(actuatorValue);
	// String targetID = sclId + "/applications/" + actuatorId
	// + "/containers/DATA/contentInstances";
	// core.doRequest(new RequestIndication("CREATE",targetID, reqEntity,
	// content));
	// }
	//
	// // Wait for 2 seconds then loop
	// try {
	// Thread.sleep(2000);
	// } catch (InterruptedException e) {
	// e.printStackTrace();
	// }
	// }
	// }
	// }.start();
	// }
}