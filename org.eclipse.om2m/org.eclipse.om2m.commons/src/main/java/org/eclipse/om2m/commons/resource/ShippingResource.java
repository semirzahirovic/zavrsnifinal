package org.eclipse.om2m.commons.resource;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
	public class ShippingResource extends Resource{

		private long cargoID;
		private long cargoType;
		private long cargoQuantity;
		private int cargoPriority;
		
		public ShippingResource(){}
		
		public ShippingResource(long cargoID, long cargoType,
				long cargoQuantity, int cargoPriority) {
			super();
			this.cargoID = cargoID;
			this.cargoType = cargoType;
			this.cargoQuantity = cargoQuantity;
			this.cargoPriority = cargoPriority;
		}
		public long getCargoID() {
			return cargoID;
		}

		public void setCargoID(long cargoID) {
			this.cargoID = cargoID;
		}
		public long getCargoType() {
			return cargoType;
		}

		public void setCargoType(long cargoType) {
			this.cargoType = cargoType;
		}
		public long getCargoQuantity() {
			return cargoQuantity;
		}

		public void setCargoQuantity(long cargoQuantity) {
			this.cargoQuantity = cargoQuantity;
		}
		public int getCargoPriority() {
			return cargoPriority;
		}

		public void setCargoPriority(int cargoPriority) {
			this.cargoPriority = cargoPriority;
		}
		
		   public String toString() {
		        return "cargoID=" + cargoID + " [ cargoType=" + cargoType+ " ]";
		    }
}
