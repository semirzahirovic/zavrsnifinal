package resources;

import java.util.ArrayList;

public class PeriodicReportResource extends Resource {
	private Long packetID;
	private Integer packetType;
	private Integer packetPriority;
	private ArrayList<String> NMEAMessage;
	private boolean sensorReadingIndicator;
	private Long deviceID;
	private SensorResource sensorResource;

	
	public SensorResource getSensorResource() {
		return sensorResource;
	}
	public void setSensorResource(SensorResource sensorResource) {
		this.sensorResource = sensorResource;
	}
	public void setPacketID(Long packetID) {
		this.packetID = packetID;
	}
	public void setPacketType(Integer packetType) {
		this.packetType = packetType;
	}
	public void setPacketPriority(Integer packetPriority) {
		this.packetPriority = packetPriority;
	}
	public PeriodicReportResource(){}
	public  ArrayList<String> getNMEAMessage() {
		return NMEAMessage;
	}

	public void setNMEAMessage( ArrayList<String> nMEAMessage) {
		NMEAMessage = nMEAMessage;
	}

	public boolean isSensorReadingIndicator() {
		return sensorReadingIndicator;
	}

	public void setSensorReadingIndicator(boolean sensorReadingIndicator) {
		this.sensorReadingIndicator = sensorReadingIndicator;
	}

	public Long getDeviceID() {
		return deviceID;
	}
	public PeriodicReportResource(long packetID, int packetType,
			int packetPriority, boolean sensorReadingIndicator, long deviceID) {
		this.packetID = packetID;
		this.packetType = packetType;
		this.packetPriority = packetPriority;
		this.sensorReadingIndicator = sensorReadingIndicator;
		this.deviceID = deviceID;
	}

	public Long getPacketID() {
		return packetID;
	}

	public void setPacketID(long packetID) {
		this.packetID = packetID;
	}

	public Integer getPacketType() {
		return packetType;
	}

	public void setPacketType(int packetType) {
		this.packetType = packetType;
	}

	public Integer getPacketPriority() {
		return packetPriority;
	}

	public void setPacketPriority(int packetPriority) {
		this.packetPriority = packetPriority;
	}


	public void setDeviceID(long deviceID) {
		this.deviceID = deviceID;
	}
	
	public void setSensorReadingsIndicator(boolean sensorReadingIndicator){
		this.sensorReadingIndicator = sensorReadingIndicator;
	}
	public boolean getSensorReadingsIndicator(){
		return sensorReadingIndicator;
	}
}
