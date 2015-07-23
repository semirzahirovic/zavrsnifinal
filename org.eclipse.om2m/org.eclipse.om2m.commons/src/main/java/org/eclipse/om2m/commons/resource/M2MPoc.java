//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2013.06.24 at 02:39:58 AM CEST
//


package org.eclipse.om2m.commons.resource;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;



/**
 * <p>Java Class for M2MPoc complex type.
 *
 * <p> M2MPoc resource represents information maintained in the NSCL on how
 * to reach a DSCL or GSCL via a specific access network. The device or gateway
 * maintains this information in the NSCL by creating, updating, or deleting
 * this resource when their point of attachment changes.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="M2MPoc">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://uri.etsi.org/m2m}contactInfo" minOccurs="0"/>
 *         &lt;element ref="{http://uri.etsi.org/m2m}expirationTime" minOccurs="0"/>
 *         &lt;element ref="{http://uri.etsi.org/m2m}onlineStatus" minOccurs="0"/>
 *         &lt;element ref="{http://uri.etsi.org/m2m}creationTime" minOccurs="0"/>
 *         &lt;element ref="{http://uri.etsi.org/m2m}lastModifiedTime" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute ref="{http://uri.etsi.org/m2m}id"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "M2MPoc", propOrder = {
        "contactInfo",
        "expirationTime",
        "onlineStatus",
        "creationTime",
        "lastModifiedTime"
})
@XmlRootElement
public class M2MPoc extends Resource {

    protected ContactInfo contactInfo;
    @XmlSchemaType(name = "dateTime")
    protected String expirationTime;
    protected OnlineStatus onlineStatus;
    @XmlSchemaType(name = "dateTime")
    protected String creationTime;
    @XmlSchemaType(name = "dateTime")
    protected String lastModifiedTime;
    @XmlAttribute(name = "id", namespace = "http://uri.etsi.org/m2m")
    @XmlSchemaType(name = "anyURI")
    protected String id;

    /**
     * Gets the value of the property contactInfo.
     *
     * @return
     *     possible object is
     *     {@link ContactInfo }
     *
     */
    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    /**
     * Sets the value of the property contactInfo.
     *
     * @param value
     *     allowed object is
     *     {@link ContactInfo }
     *
     */
    public void setContactInfo(ContactInfo value) {
        this.contactInfo = value;
    }

    /**
     * Gets the value of the property expirationTime.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getExpirationTime() {
        return expirationTime;
    }

    /**
     * Sets the value of the property expirationTime.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setExpirationTime(String value) {
        this.expirationTime = value;
    }

    /**
     * Gets the value of the property onlineStatus.
     *
     * @return
     *     possible object is
     *     {@link OnlineStatus }
     *
     */
    public OnlineStatus getOnlineStatus() {
        return onlineStatus;
    }

    /**
     * Sets the value of the property onlineStatus.
     *
     * @param value
     *     allowed object is
     *     {@link OnlineStatus }
     *
     */
    public void setOnlineStatus(OnlineStatus value) {
        this.onlineStatus = value;
    }

    /**
     * Gets the value of the property creationTime.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCreationTime() {
        return creationTime;
    }

    /**
     * Sets the value of the property creationTime.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCreationTime(String value) {
        this.creationTime = value;
    }

    /**
     * Gets the value of the property lastModifiedTime.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getLastModifiedTime() {
        return lastModifiedTime;
    }

    /**
     * Sets the value of the property lastModifiedTime.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setLastModifiedTime(String value) {
        this.lastModifiedTime = value;
    }

    /**
     * Gets the value of the property id.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the property id.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setId(String value) {
        this.id = value;
    }


}