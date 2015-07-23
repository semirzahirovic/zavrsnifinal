package org.eclipse.om2m.sample.ipu;




import org.apache.log4j.Logger;

import com.rapplogic.xbee.api.AtCommand;
import com.rapplogic.xbee.api.XBee;
import com.rapplogic.xbee.api.XBeeException;
import com.rapplogic.xbee.examples.ApiAtExample;


public class XBeeTest {

//	TODO split class in to WPAN class
	 

	
	private XBee xbee = new XBee();
	private final static Logger log = Logger.getLogger(XBeeTest.class);
	public XBeeTest() throws XBeeException {
	}
	public void init(){
		try {	
			
			// replace with port and baud rate of your XBee
			xbee.open("COM3", 9600);
			
////			// set D1 analog input
//		    xbee.sendAtCommand(new AtCommand("D1", 2));
////			// set D2 digital input
//			xbee.sendAtCommand(new AtCommand("D2", 3));
////			// send sample every 5 seconds
//			xbee.sendAtCommand(new AtCommand("IR", new int[] {0x13, 0x88}));
			
			log.info("MY is " + xbee.sendAtCommand(new AtCommand("MY")));
			
		} catch (Exception e) {
		} finally {
			xbee.close();
		}
	}
	public String getSmth() throws XBeeException{
		return xbee.getResponse().toString();
		
	}
}
