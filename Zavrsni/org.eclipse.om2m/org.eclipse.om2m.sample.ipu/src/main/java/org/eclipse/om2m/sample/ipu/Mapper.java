package org.eclipse.om2m.sample.ipu;

import obix.Bool;
import obix.Str;
import obix.Contract;
import obix.Int;
import obix.Obj;
import obix.Op;
import obix.Uri;
import obix.io.ObixEncoder;

public class Mapper {
	 
	public static String getSensorDescriptorRep(String sclId, String appId, String ipuId) {
		Obj obj = new Obj();
 
		Op opGet = new Op();
		opGet.setName("GET");
		opGet.setHref(new Uri(sclId + "/applications/" + appId
				+ "/containers/DATA/contentInstances/latest/content"));
		opGet.setIs(new Contract("retrieve"));
		obj.add(opGet);
 
		Op opGetDirect = new Op();
		opGetDirect.setName("GET(Direct)");
		opGetDirect.setHref(new Uri(sclId + "/applications/" + appId + "/" + ipuId));
		opGetDirect.setIs(new Contract("retrieve"));
		obj.add(opGetDirect);
 
		return ObixEncoder.toString(obj);
	}
 
	public static String getActutaorDescriptorRep(String sclId, String appId, String ipuId) {
		Obj obj = new Obj();
 
		Op opGet = new Op();
		opGet.setName("GET");
		opGet.setHref(new Uri(sclId + "/applications/" + appId
				+ "/containers/DATA/contentInstances/latest/content"));
		opGet.setIs(new Contract("retrieve"));
		obj.add(opGet);
 
		Op opGetDirect = new Op();
		opGetDirect.setName("GET(Direct)");
		opGetDirect.setHref(new Uri(sclId + "/applications/" + appId + "/" + ipuId));
		opGetDirect.setIs(new Contract("retrieve"));

		obj.add(opGetDirect);
 
		Op opON = new Op();
		opON.setName("ON");
		opON.setHref(new Uri(sclId + "/applications/" + appId + "/" + ipuId + "/true"));
		opON.setIs(new Contract("execute"));
		obj.add(opON);
 
		Op opOFF = new Op();
		opOFF.setName("OFF");
		opOFF.setHref(new Uri(sclId + "/applications/" + appId + "/" + ipuId + "/false"));
		opOFF.setIs(new Contract("execute"));
		obj.add(opOFF);
 
		return ObixEncoder.toString(obj);
	}
 
	public static String getActuatorDataRep(boolean value) {
		Obj obj = new Obj();
		obj.add(new Bool("data", value));
		return ObixEncoder.toString(obj);
	}
 
	public static String getSensorDataRep(int value) {
		Obj obj = new Obj();
		obj.add(new Int("data", value));
		return ObixEncoder.toString(obj);
	}
	public static String getXbeeDataRep(int value) {
		Obj obj = new Obj();
		obj.add(new Int("data", value));
		return ObixEncoder.toString(obj);
	}
	public static String getXBeeDescriptorRep(String sclId, String appId, String ipuId) {
		Obj obj = new Obj();
 
		Op opGet = new Op();
		opGet.setName("GET");
		opGet.setHref(new Uri(sclId + "/applications/" + appId
				+ "/containers/DATA/contentInstances/latest/content"));
		opGet.setIs(new Contract("retrieve"));
		opGet.setIn(new Contract("obix:Nil"));
        opGet.setOut(new Contract("obix:Nil"));
		obj.add(opGet);
 
		Op opGetDirect = new Op();
		opGetDirect.setName("GET(Direct)");
		opGetDirect.setHref(new Uri(sclId + "/applications/" + appId + "/" + ipuId));
		opGetDirect.setIs(new Contract("retrieve"));
		obj.add(opGetDirect);
 
		return ObixEncoder.toString(obj);
	}
}