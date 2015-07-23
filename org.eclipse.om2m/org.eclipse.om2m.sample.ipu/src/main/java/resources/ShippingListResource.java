package resources;

import java.util.ArrayList;
import java.util.Iterator;


public class ShippingListResource extends Resource {

	public ArrayList<ShippingResource> shippingListResource = new ArrayList<ShippingResource>();

	public ArrayList<ShippingResource> getShippingListResource() {
		return shippingListResource;
	}

	public void setShippingListResource(
			ArrayList<ShippingResource> shippingListResource) {
		this.shippingListResource = shippingListResource;
	}

	public String toString() {
		Iterator i = shippingListResource.iterator();
		String result = "<table> <tr> <th> ID </th> <th> Type </th> <th> Quantity </th> <th> Priority </th></tr>";
		while (i.hasNext()) {
			ShippingResource shippingResource = (ShippingResource) i.next();
			result+=shippingResource.toString();
			if (!i.hasNext()) {
				result += " </table>";
			}
		}
		return result;
	}
	public Integer doesListContaintShippingResource(Long long1){
		for(int i = 0;i <this.shippingListResource.size();i++){
			ShippingResource shippingResource = shippingListResource.get(i);
			if(shippingResource.getCargoID() == long1) return i;
		}
		return null;
		
	}
}
