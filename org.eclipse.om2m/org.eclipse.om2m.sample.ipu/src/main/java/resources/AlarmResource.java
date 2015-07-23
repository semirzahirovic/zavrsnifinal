package resources;

public class AlarmResource extends Resource {

	private long packetID;
	private Integer packetType;
	private Integer packetPriority;
	private boolean sensorReadingIndicator;
	private SensorResource sensorResource;
	private Integer deviceId;
	
	public AlarmResource(){}

	public Integer getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(Integer deviceId) {
		this.deviceId = deviceId;
	}

	public SensorResource getSensorResource() {
		return sensorResource;
	}

	public void setSensorResource(SensorResource sensorResource) {
		this.sensorResource = sensorResource;
	}

	public AlarmResource(Long packetID, Integer packetType, Integer packetPriority,
			boolean sensorReadingIndicator) {
		super();
		this.packetID = packetID;
		this.packetType = packetType;
		this.packetPriority = packetPriority;
		this.sensorReadingIndicator = sensorReadingIndicator;
	}

	public long getPacketID() {
		return packetID;
	}

	public void setPacketID(long packetID) {
		this.packetID = packetID;
	}

	public Integer getPacketType() {
		return packetType;
	}

	public void setPacketType(Integer packetType) {
		this.packetType = packetType;
	}

	public Integer getPacketPriority() {
		return packetPriority;
	}

	public void setPacketPriority(Integer packetPriority) {
		this.packetPriority = packetPriority;
	}

	public boolean isSensorReadingIndicator() {
		return sensorReadingIndicator;
	}

	public void setSensorReadingIndicator(boolean sensorReadingIndicator) {
		this.sensorReadingIndicator = sensorReadingIndicator;
	}

}
