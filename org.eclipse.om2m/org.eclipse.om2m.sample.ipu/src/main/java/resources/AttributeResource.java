package resources;

import java.util.List;

public class AttributeResource extends Resource{
	
	private Long ownerID;
	private Long authorizedPersonnel;
	private Long deviceID;
	private Long transportElementBindingID;
	private Long parentID;
	private Long missionID;
	private Double alarmGenerationConditions;
	private List<Long> shippingListResource;
	
	public List<Long> getShippingListResource() {
		return shippingListResource;
	}
	public void setShippingListResource(List<Long> shippingListResource) {
		this.shippingListResource = shippingListResource;
	}
	public AttributeResource(){}
	public AttributeResource(long ownerID, long authorizedPersonnel,
			long deviceID, long transportElementBindingID, long parentID,
			long missionID, double alarmGenerationConditions) {
		super();
		this.ownerID = ownerID;
		this.authorizedPersonnel = authorizedPersonnel;
		this.deviceID = deviceID;
		this.transportElementBindingID = transportElementBindingID;
		this.parentID = parentID;
		this.missionID = missionID;
		this.alarmGenerationConditions = alarmGenerationConditions;
	}
	public Long getOwnerID() {
		return ownerID;
	}
	public void setOwnerID(long ownerID) {
		this.ownerID = ownerID;
	}
	public Long getAuthorizedPersonnel() {
		return authorizedPersonnel;
	}
	public void setAuthorizedPersonnel(long authorizedPersonnel) {
		this.authorizedPersonnel = authorizedPersonnel;
	}
	public Long getDeviceID() {
		return deviceID;
	}
	public void setDeviceID(long deviceID) {
		this.deviceID = deviceID;
	}
	public Long getTransportElementBindingID() {
		return transportElementBindingID;
	}
	public void setTransportElementBindingID(long transportElementBindingID) {
		this.transportElementBindingID = transportElementBindingID;
	}
	public Long getParentID() {
		return parentID;
	}
	public void setParentID(long parentID) {
		this.parentID = parentID;
	}
	public Long getMissionID() {
		return missionID;
	}
	public void setMissionID(long missionID) {
		this.missionID = missionID;
	}
	public Double getAlarmGenerationConditions() {
		return alarmGenerationConditions;
	}
	public void setAlarmGenerationConditions(double alarmGenerationConditions) {
		this.alarmGenerationConditions = alarmGenerationConditions;
	}
	

}
