package resources;

public class SensorResource extends Resource {
	private Integer sensorTypeID;
	private String sensorName;
	private Double value;
	private Integer sensorProfileId;

	public Integer getSensorProfileId() {
		return sensorProfileId;
	}

	public void setSensorProfileId(Integer sensorProfileId) {
		this.sensorProfileId = sensorProfileId;
	}

	public SensorResource() {
	}

	public SensorResource(Integer sensorTypeID, String sensorName, Double value) {
		this.sensorTypeID = sensorTypeID;
		this.sensorName = sensorName;
		this.value = value;
	}

	public Integer getSensorTypeID() {
		return sensorTypeID;
	}

	public void setSensorTypeID(Integer sensorTypeID) {
		this.sensorTypeID = sensorTypeID;
	}

	public String getSensorName() {
		return sensorName;
	}

	public void setSensorName(String sensorName) {
		this.sensorName = sensorName;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
}
