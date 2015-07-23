package org.eclipse.om2m.sample.ipu;

import java.sql.Timestamp;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.om2m.commons.resource.StatusCode;
import org.eclipse.om2m.commons.rest.RequestIndication;
import org.eclipse.om2m.commons.rest.ResponseConfirm;
import org.eclipse.om2m.ipu.service.IpuService;

public class Controller implements IpuService {
	private static Log LOGGER = LogFactory.getLog(Controller.class);

	public ResponseConfirm doExecute(RequestIndication requestIndication) {
		String[] parts = requestIndication.getTargetID().split("/");
		LOGGER.info("MY INFOoooooooooooooooooooooooooo1" + parts.toString());
		String appId = parts[2];
		String value = parts[4];
		String time = parts[5];

		/*
		 * if (appId.equals(Monitor.actuatorId)) { Monitor.actuatorValue =
		 * Boolean.parseBoolean(value); return new
		 * ResponseConfirm(StatusCode.STATUS_OK); } else { return new
		 * ResponseConfirm(StatusCode.STATUS_NOT_FOUND, appId + " not found"); }
		 */

		if (appId.equals(Monitor.appID)) {
			return new ResponseConfirm(StatusCode.STATUS_OK);
		} else {
			return new ResponseConfirm(StatusCode.STATUS_NOT_FOUND, appId
					+ " not found");
		}
	}

	public ResponseConfirm doRetrieve(RequestIndication requestIndication) {
		String[] parts = requestIndication.getTargetID().split("/");
		LOGGER.info("MY INFO2" + parts.toString());
		String appId = parts[2];
		String containerID = null;

		String content;
		if (appId.equals(Monitor.appID)) {
			content = Mapper.getResourcesDataRep(Monitor.periodicReportResource);
			return new ResponseConfirm(StatusCode.STATUS_OK, content);
		} else if (appId.equals(Monitor.appID2)) {
			content = Mapper.getAlarmResource(Monitor.alarmResource);
			return new ResponseConfirm(StatusCode.STATUS_OK, content);
		} else {
			return new ResponseConfirm(StatusCode.STATUS_NOT_FOUND, appId
					+ " not found");

		}
	}

	public ResponseConfirm doUpdate(RequestIndication requestIndication) {
		return new ResponseConfirm(StatusCode.STATUS_NOT_IMPLEMENTED,
				requestIndication.getMethod() + " not Implemented");
	}

	public ResponseConfirm doDelete(RequestIndication requestIndication) {
		return new ResponseConfirm(StatusCode.STATUS_NOT_IMPLEMENTED,
				requestIndication.getMethod() + " not Implemented");
	}

	public ResponseConfirm doCreate(RequestIndication requestIndication) {
		return new ResponseConfirm(StatusCode.STATUS_NOT_IMPLEMENTED,
				requestIndication.getMethod() + " not Implemented");
	}

	public String getAPOCPath() {
		return Monitor.ipuId;
	}
}