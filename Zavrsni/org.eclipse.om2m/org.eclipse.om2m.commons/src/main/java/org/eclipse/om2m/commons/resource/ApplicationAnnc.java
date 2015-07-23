//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2014.01.25 at 05:56:27 PM CET
//


package org.eclipse.om2m.commons.resource;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;



/**
 * <p>Java class for ApplicationAnnc complex type.
 *
 * <p>The ApplicationAnnc resource represents an active announcement of a registered
 * application in an other SCL. ApplicationAnnc resource keeps a link to the original
 * resource. That will be the reference returned
 * during discovery.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ApplicationAnnc">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://uri.etsi.org/m2m}link"/>
 *         &lt;element ref="{http://uri.etsi.org/m2m}accessRightID" minOccurs="0"/>
 *         &lt;element ref="{http://uri.etsi.org/m2m}searchStrings" minOccurs="0"/>
 *         &lt;element ref="{http://uri.etsi.org/m2m}expirationTime" minOccurs="0"/>
 *         &lt;element ref="{http://uri.etsi.org/m2m}containersReference" minOccurs="0"/>
 *         &lt;element ref="{http://uri.etsi.org/m2m}groupsReference" minOccurs="0"/>
 *         &lt;element ref="{http://uri.etsi.org/m2m}accessRightsReference" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class ApplicationAnnc extends Resource {

    @XmlElement(required = true)
    @XmlSchemaType(name = "anyURI")
    protected String link;
    @XmlSchemaType(name = "dateTime")
    protected String expirationTime;
    @XmlSchemaType(name = "anyURI")
    protected String containersReference;
    @XmlSchemaType(name = "anyURI")
    protected String groupsReference;
    @XmlSchemaType(name = "anyURI")
    protected String accessRightsReference;
    @XmlAttribute(name = "id")
    @XmlSchemaType(name = "anyURI")
    protected String id;

    /**
     * Gets the value of the property link.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getLink() {
        return link;
    }

    /**
     * Sets the value of the property link.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setLink(String value) {
        this.link = value;
    }

    /**
     * Gets the value of the expirationTime property.
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
     * Sets the value of the expirationTime property.
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
     * Gets the value of the containersReference property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getContainersReference() {
        return containersReference;
    }

    /**
     * Sets the value of the containersReference property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setContainersReference(String value) {
        this.containersReference = value;
    }

    /**
     * Gets the value of the groupsReference property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getGroupsReference() {
        return groupsReference;
    }

    /**
     * Sets the value of the groupsReference property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setGroupsReference(String value) {
        this.groupsReference = value;
    }

    /**
     * Gets the value of the accessRightsReference property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getAccessRightsReference() {
        return accessRightsReference;
    }

    /**
     * Sets the value of the accessRightsReference property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAccessRightsReference(String value) {
        this.accessRightsReference = value;
    }

    /**
     * Gets the value of the id property.
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
     * Sets the value of the id property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setId(String value) {
        this.id = value;
    }

    public String toString() {
        return "ApplicationAnnc [link=" + link + ", accessRightID="
                + accessRightID + ", searchStrings=" + searchStrings
                + ", expirationTime=" + expirationTime
                + ", containersReference=" + containersReference
                + ", groupsReference=" + groupsReference
                + ", accessRightsReference=" + accessRightsReference + ", id="
                + id + ", uri=" + uri + "]";
    }

}