package org.eclipse.om2m.sample.ipu;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.om2m.comm.http.RestHttpServlet;
import org.eclipse.om2m.commons.utils.XmlMapper;

import obix.Bool;
import obix.Contract;
import obix.Int;
import obix.List;
import obix.Obj;
import obix.Op;
import obix.Real;
import obix.Str;
import obix.Uri;
import obix.io.ObixDecoder;
import obix.io.ObixEncoder;
import resources.AlarmResource;
import resources.AttributeResource;
import resources.CommandResource;
import resources.CommandResourceList;
import resources.PeriodicReportResource;
import resources.SensorResource;
import resources.ShippingListResource;
import resources.ShippingResource;

public class Mapper {
	static AttributeResource attributeResource = new AttributeResource();
	static ShippingListResource shippingResourceList = new ShippingListResource();
	static CommandResourceList commandResourceList = new CommandResourceList();

	public static void decodeStream() {
		Obj obj = ObixDecoder.fromString(RestHttpServlet.obixRepresentation);
		Obj temp = null;
		if (obj.has("ownerID")) {
			temp = obj.get("ownerID");
			attributeResource.setOwnerID(temp.getInt());
		}
		if (obj.has("authorizedPersonnel")) {
			temp = obj.get("authorizedPersonnel");
			attributeResource.setAuthorizedPersonnel(temp.getInt());
		}
		if (obj.has("deviceID")) {
			temp = obj.get("deviceID");
			attributeResource.setDeviceID(temp.getInt());
		}
		if (obj.has("transportElementBindingID")) {
			temp = obj.get("transportElementBindingID");
			attributeResource.setTransportElementBindingID(temp.getInt());
		}
		if (obj.has("parentID")) {
			temp = obj.get("parentID");
			attributeResource.setParentID(temp.getInt());
		}
		if (obj.has("missionID")) {
			temp = obj.get("missionID");
			attributeResource.setMissionID(temp.getInt());
		}
		if (obj.has("alarmGenerationConditions")) {
			temp = obj.get("alarmGenerationConditions");
			attributeResource.setAlarmGenerationConditions(temp.getReal());
		}
		if (obj.has("shippingList")) {
			temp = obj.get("shippingList");
			Obj[] lista = temp.list();
			for (int i = 0; i < lista.length; i++) {
				ShippingResource shippingResource = decodeCargoResource(lista[i]);
				if (shippingResourceList
						.doesListContaintShippingResource(shippingResource
								.getCargoID()) != null) {
					shippingResourceList
							.getShippingListResource()
							.get(i)
							.setCargoPriority(
									shippingResource.getCargoPriority());
					shippingResourceList.getShippingListResource().get(i)
							.setCargoType(shippingResource.getCargoType());
					shippingResourceList
							.getShippingListResource()
							.get(i)
							.setCargoQuantity(
									shippingResource.getCargoQuantity());
				} else {
					shippingResourceList.getShippingListResource().add(
							decodeCargoResource(lista[i]));
				}
			}

		}
		if (obj.has("commandList")) {
			temp = obj.get("commandList");
			Obj[] lista = temp.list();
			for (int i = 0; i < lista.length; i++) {
				CommandResource commandResource = decodeCommandResource(lista[i]);
				if (commandResourceList
						.doesListContainsCommandResource(commandResource
								.getEventID()) != null) {
					commandResourceList.getCommandListResource().get(i)
							.setEventType(commandResource.getEventType());
					commandResourceList.getCommandListResource().get(i)
							.setEventTime(commandResource.getEventTime());

				} else {
					commandResourceList.getCommandListResource().add(
							decodeCommandResource(lista[i]));
				}
			}
		}
	}

	private static ShippingResource decodeCargoResource(Obj obj) {
		ShippingResource shippingResource = new ShippingResource();
		if (obj.has("cargoID"))
			shippingResource.setCargoID(obj.get("cargoID").getInt());
		if (obj.has("cargoType"))
			shippingResource.setCargoType(obj.get("cargoType").getInt());
		if (obj.has("cargoQuantity"))
			shippingResource
					.setCargoQuantity(obj.get("cargoQuantity").getInt());
		if (obj.has("cargoPriority"))
			shippingResource.setCargoPriority((int) obj.get("cargoPriority")
					.getInt());
		return shippingResource;
	}

	private static Obj encodeCargoResource(ShippingResource shippingResource) {
		Obj obj = new Obj();
		if (shippingResource.getCargoID() != null)
			obj.add("cargoID", new Int(shippingResource.getCargoID()));
		if (shippingResource.getCargoType() != null)
			obj.add("cargoType", new Int(shippingResource.getCargoType()));
		if (shippingResource.getCargoPriority() != null)
			obj.add("cargoPriority",
					new Int(shippingResource.getCargoPriority()));
		if (shippingResource.getCargoQuantity() != null)
			obj.add("cargoQuantity",
					new Int(shippingResource.getCargoQuantity()));

		return obj;
	}

	private static Obj encodeCommandResource(CommandResource commandResource) {
		Obj obj = new Obj();
		if (commandResource.getEventID() != null)
			obj.add("eventID", new Int(commandResource.getEventID()));
		if (commandResource.getEventType() != null)
			obj.add("eventType", new Int(commandResource.getEventType()));
		if (commandResource.getEventTime() != null)
			obj.add("eventTime", new Real(commandResource.getEventTime()));

		return obj;
	}

	private static CommandResource decodeCommandResource(Obj obj) {
		CommandResource commandResource = new CommandResource();
		if (obj.has("eventID"))
			commandResource.setEventID((obj.get("eventID").getInt()));
		if (obj.has("eventType"))
			commandResource.setEventType(obj.get("eventType").getInt());
		if (obj.has("eventTime"))
			commandResource.setEventTime(obj.get("eventTime").getReal());
		return commandResource;
	}

	public static String getStrackUResourcesDataRep(
			AttributeResource attributeResource) {
		Obj attribute = new Obj();
		if (attributeResource.getOwnerID() != null) {
			attribute.add(new Int("ownerID", attributeResource.getOwnerID()));
		} else {
			attribute.add(setDefaultValue("ownerID"));
		}
		if (attributeResource.getAuthorizedPersonnel() != null) {
			attribute.add(new Int("authorizedPersonnel", attributeResource
					.getAuthorizedPersonnel()));
		} else {
			attribute.add(setDefaultValue("authorizedPersonnel"));
		}
		if (attributeResource.getDeviceID() != null) {
			attribute.add(new Int("deviceID", attributeResource.getDeviceID()));
		} else {
			attribute.add(setDefaultValue("deviceID"));
		}
		if (attributeResource.getTransportElementBindingID() != null) {
			attribute.add(new Int("transportElementBinding", attributeResource
					.getTransportElementBindingID()));
		} else {
			attribute.add(setDefaultValue("transportElementBinding"));
		}
		if (attributeResource.getParentID() != null) {
			attribute.add(new Int("parentID", attributeResource.getParentID()));
		} else {
			attribute.add(setDefaultValue("parentID"));
		}
		if (attributeResource.getMissionID() != null) {
			attribute
					.add(new Int("missionID", attributeResource.getMissionID()));
		} else {
			attribute.add(setDefaultValue("missionID"));
		}
		if (attributeResource.getAlarmGenerationConditions() != null) {
			attribute.add(new Real("alarmGenerationConditions",
					attributeResource.getAlarmGenerationConditions()));
		} else {
			attribute.add(setDefaultValue("alarmGenerationConditions"));
		}
		List cargoList = new List("cargoList");
		for (int i = 0; i < shippingResourceList.getShippingListResource()
				.size(); i++) {
			cargoList.add(encodeCargoResource(shippingResourceList
					.getShippingListResource().get(i)));
		}
		attribute.add(cargoList);
		List commandList = new List("commandList");
		for (int i = 0; i < commandResourceList.getCommandListResource().size(); i++) {
			commandList.add(encodeCommandResource(commandResourceList
					.getCommandListResource().get(i)));
		}
		attribute.add(commandList);
		
		return ObixEncoder.toString(attribute);
	}

	public static String getResourcesDataRep(
			PeriodicReportResource periodicReportResource) {
		Obj resources = new Obj();
		resources.add("sequenceNumber", new Int(periodicReportResource.getPacketID()));
		resources.add("timestamp", new Int(System.currentTimeMillis()));
		if (periodicReportResource.getPacketPriority() != null)
			resources.add("priority",
					new Int(periodicReportResource.getPacketPriority()));
		if (periodicReportResource.getNMEAMessage() != null) {
			List nmeaList = new List("NMEA");
			nmeaList.add("RMC", new Str(periodicReportResource.getNMEAMessage().get(0)));
			nmeaList.add("GGA", new Str(periodicReportResource.getNMEAMessage().get(1)));
			nmeaList.add("GST", new Str(periodicReportResource.getNMEAMessage().get(2)));
			nmeaList.add("PRDID", new Str(periodicReportResource.getNMEAMessage().get(3)));
			resources.add(nmeaList);
		}
		if (periodicReportResource.getSensorResource() != null) {
			List sensorList = new List("sensorReadings");
			sensorList.add(encodeSensorResource(periodicReportResource
					.getSensorResource()));
			resources.add(sensorList);
		}
		//resources.add("deviceId", new Int(periodicReportResource.getDeviceID()));

		return ObixEncoder.toString(resources);
	}
	
	public static String getAlarmResource(
			AlarmResource alarmResource) {
		Obj resources = new Obj();
		resources.add("sequenceNumber", new Int(alarmResource.getPacketID()));
		resources.add("timestamp", new Int(System.currentTimeMillis()));
		if (alarmResource.getPacketPriority() != null)
			resources.add("priority",
					new Int(alarmResource.getPacketPriority()));
		if (alarmResource.getSensorResource() != null) {
			List sensorList = new List("sensorReadings");
			sensorList.add(encodeSensorResource(alarmResource
					.getSensorResource()));
			resources.add(sensorList);
		}
		//resources.add("deviceId", new Int(periodicReportResource.getDeviceID()));

		return ObixEncoder.toString(resources);
	}

	private static Obj encodeSensorResource(SensorResource sensorResource) {
		Obj obj = new Obj();
		if (sensorResource.getSensorName() != null)
			obj.add("sensorName", new Str(sensorResource.getSensorName()));
		if (sensorResource.getSensorTypeID() != null)
			obj.add("sensorType", new Int(sensorResource.getSensorTypeID()));
		if (sensorResource.getValue() != null)
			obj.add("sensorValue", new Real(sensorResource.getValue()));
		if (sensorResource.getSensorProfileId() != null)
			obj.add("sensorProfileId", new Int(sensorResource.getSensorProfileId()));
		return obj;
	}



	public static String getAlarmDataDescriptorRep(String sclId, String appId,
			String ipuId) {
		Obj obj = new Obj();
		Op opGet = new Op();
		opGet.setName("GET");
		opGet.setHref(new Uri(
				sclId
						+ "/applications/"
						+ appId
						+ "/containers/AlarmDataContainer/contentInstances/latest/content"));
		opGet.setIs(new Contract("retrieve"));
		opGet.setIn(new Contract("obix:Nil"));
		opGet.setOut(new Contract("obix:Nil"));
		obj.add(opGet);

		Op opGetDirect = new Op();
		opGetDirect.setName("GET(Direct)");
		opGetDirect.setHref(new Uri(sclId + "/applications/" + appId + "/"
				+ ipuId));
		opGetDirect.setIs(new Contract("retrieve"));
		obj.add(opGetDirect);

		return ObixEncoder.toString(obj);
	}

	public static String getStrackUDescriptorRep(String sclId, String appId,
			String ipuId) {
		Obj obj = new Obj();
		Op opGet = new Op();
		opGet.setName("GET");
		opGet.setHref(new Uri(
				sclId
						+ "/applications/"
						+ appId
						+ "/containers/STrackUContainer/contentInstances/latest/content"));
		opGet.setIs(new Contract("retrieve"));
		opGet.setIn(new Contract("obix:Nil"));
		opGet.setOut(new Contract("obix:Nil"));
		obj.add(opGet);

		Op opGetDirect = new Op();
		opGetDirect.setName("GET(Direct)");
		opGetDirect.setHref(new Uri(sclId + "/applications/" + appId + "/"
				+ ipuId + "/STU"));
		opGetDirect.setIs(new Contract("retrieve"));
		obj.add(opGetDirect);

		return ObixEncoder.toString(obj);
	}

	
	public static String getResourcesRep(String sclId, String appId,
			String ipuId) {
		Obj obj = new Obj();
		Op opGet = new Op();
		opGet.setName("GET");
		opGet.setHref(new Uri(
				sclId
						+ "/applications/"
						+ appId
						+ "/containers/ReportDataContainer/contentInstances/latest/content"));
		opGet.setIs(new Contract("retrieve"));
		opGet.setIn(new Contract("obix:Nil"));
		opGet.setOut(new Contract("obix:Nil"));
		obj.add(opGet);

		Op opGetDirect = new Op();
		opGetDirect.setName("GET(Direct)");
		opGetDirect.setHref(new Uri(sclId + "/applications/" + appId + "/"
				+ ipuId));
		opGetDirect.setIs(new Contract("retrieve"));
		obj.add(opGetDirect);

		return ObixEncoder.toString(obj);
	}

	public static Str setDefaultValue(String name) {
		return new Str(name, "undefined");
	}
}