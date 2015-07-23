package resources;

public class CommandResource {

	private Long eventID;
	private Long eventType;
	private Double eventTime;

	public CommandResource() {
	}

	public CommandResource(long eventID, long eventType, double eventTime) {
		this.eventID = eventID;
		this.eventType = eventType;
		this.eventTime = eventTime;
	}

	public Long getEventID() {
		return eventID;
	}

	public void setEventID(Long eventID) {
		this.eventID = eventID;
	}

	public Long getEventType() {
		return eventType;
	}

	public void setEventType(Long eventType) {
		this.eventType = eventType;
	}

	public Double getEventTime() {
		return eventTime;
	}

	public void setEventTime(Double eventTime) {
		this.eventTime = eventTime;
	}

	public String toString() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("<tr> <td>" + eventID + "</td>" + "<td>" + eventType
				+ "</td>" + "<td>" + eventTime + "</td>" + "</td>" + "</tr>");
		return strBuilder.toString();
	}
}
