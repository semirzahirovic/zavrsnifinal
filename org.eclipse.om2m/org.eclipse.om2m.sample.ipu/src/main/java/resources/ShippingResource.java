package resources;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class ShippingResource {

	private Long cargoID;
	private Long cargoType;
	private Long cargoQuantity;
	private Integer cargoPriority;

	public ShippingResource() {
	}

	public ShippingResource(long cargoID, long cargoType, long cargoQuantity,
			int cargoPriority) {
		super();
		this.cargoID = cargoID;
		this.cargoType = cargoType;
		this.cargoQuantity = cargoQuantity;
		this.cargoPriority = cargoPriority;
	}

	public Long getCargoID() {
		return cargoID;
	}

	public void setCargoID(long cargoID) {
		this.cargoID = cargoID;
	}

	public Long getCargoType() {
		return cargoType;
	}

	public void setCargoType(long cargoType) {
		this.cargoType = cargoType;
	}

	public Long getCargoQuantity() {
		return cargoQuantity;
	}

	public void setCargoQuantity(long cargoQuantity) {
		this.cargoQuantity = cargoQuantity;
	}

	public Integer getCargoPriority() {
		return cargoPriority;
	}

	public void setCargoPriority(int cargoPriority) {
		this.cargoPriority = cargoPriority;
	}

	public String toString() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("<tr> <td>" + cargoID + "</td>" + "<td>" + cargoType
				+ "</td>" + "<td>" + cargoQuantity + "</td>" + "<td>"
				+ cargoPriority + "</td>" + "</tr>");
		return strBuilder.toString();
	}

}
