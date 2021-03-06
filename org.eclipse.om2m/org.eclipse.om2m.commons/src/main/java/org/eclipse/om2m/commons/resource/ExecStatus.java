//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2014.01.25 at 05:56:27 PM CET
//


package org.eclipse.om2m.commons.resource;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ExecStatus.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ExecStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="INITIATED"/>
 *     &lt;enumeration value="STARTED"/>
 *     &lt;enumeration value="FINISHED"/>
 *     &lt;enumeration value="CANCELLING"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 *
 */
@XmlType(name = "ExecStatus")
@XmlEnum
public enum ExecStatus {

    INITIATED,
    STARTED,
    FINISHED,
    CANCELLING;

    public String value() {
        return name();
    }

    public static ExecStatus fromValue(String v) {
        return valueOf(v);
    }

}
