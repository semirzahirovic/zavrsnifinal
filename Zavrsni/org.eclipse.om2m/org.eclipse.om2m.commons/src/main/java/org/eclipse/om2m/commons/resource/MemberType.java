//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2013.06.24 at 02:38:33 AM CEST
//


package org.eclipse.om2m.commons.resource;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java Class for MemberType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="MemberType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="APPLICATION"/>
 *     &lt;enumeration value="CONTAINER"/>
 *     &lt;enumeration value="ACCESS_RIGHT"/>
 *     &lt;enumeration value="SERVER_CAPABILITY_LAYER"/>
 *     &lt;enumeration value="SCL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 *
 */
@XmlType(name = "MemberType")
@XmlEnum
public enum MemberType {

    APPLICATION,
    CONTAINER,
    ACCESS_RIGHT,
    SERVER_CAPABILITY_LAYER,
    SCL;

    public String value() {
        return name();
    }

    public static MemberType fromValue(String v) {
        return valueOf(v);
    }

}
