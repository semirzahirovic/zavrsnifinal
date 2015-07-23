package resources;

import java.util.ArrayList;
import java.util.Iterator;

public class CommandResourceList {

	private ArrayList<CommandResource> commandListResource = new ArrayList<CommandResource>();

	public ArrayList<CommandResource> getCommandListResource() {
		return commandListResource;
	}

	public void setCommandListResource(
			ArrayList<CommandResource> commandListResource) {
		this.commandListResource = commandListResource;
	}


	public Integer doesListContainsCommandResource(Long b) {
		for (int i = 0; i < this.commandListResource.size(); i++) {
			CommandResource shippingResource = commandListResource.get(i);
			if (shippingResource.getEventID() == b)
				return i;
		}
		return null;
	}
}