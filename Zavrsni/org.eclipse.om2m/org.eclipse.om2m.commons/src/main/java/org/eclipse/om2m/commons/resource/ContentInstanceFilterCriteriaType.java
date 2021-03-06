//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2014.01.25 at 05:56:27 PM CET
//


package org.eclipse.om2m.commons.resource;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;



/**
 * <p>Java class for ContentInstanceFilterCriteriaType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ContentInstanceFilterCriteriaType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://uri.etsi.org/m2m}FilterCriteriaType">
 *       &lt;sequence>
 *         &lt;element name="creator" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element name="searchString" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="createdSince" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="createdUntil" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="sizeFrom" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="sizeUntil" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="contentType" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="metaDataOnly" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="attributeAccessor" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ContentInstanceFilterCriteriaType", propOrder = {
        "creator",
        "searchString",
        "createdSince",
        "createdUntil",
        "sizeFrom",
        "sizeUntil",
        "contentType",
        "metaDataOnly",
        "attributeAccessor"
})
public class ContentInstanceFilterCriteriaType extends FilterCriteriaType {

    @XmlElement(namespace = "")
    @XmlSchemaType(name = "anyURI")
    protected String creator;
    @XmlElement(namespace = "")
    protected List<String> searchString;
    @XmlElement(namespace = "")
    @XmlSchemaType(name = "dateTime")
    protected String createdSince;
    @XmlElement(namespace = "")
    @XmlSchemaType(name = "dateTime")
    protected String createdUntil;
    @XmlElement(namespace = "")
    protected Integer sizeFrom;
    @XmlElement(namespace = "")
    protected Integer sizeUntil;
    @XmlElement(namespace = "")
    protected List<String> contentType;
    @XmlElement(namespace = "")
    protected Boolean metaDataOnly;
    @XmlElement(namespace = "")
    @XmlSchemaType(name = "anyURI")
    protected String attributeAccessor;

    /**
     * Gets the value of the creator property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCreator() {
        return creator;
    }

    /**
     * Sets the value of the creator property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCreator(String value) {
        this.creator = value;
    }

    /**
     * Gets the value of the searchString property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the searchString property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSearchString().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     *
     *
     */
    public List<String> getSearchString() {
        if (searchString == null) {
            searchString = new ArrayList<String>();
        }
        return this.searchString;
    }

    /**
     * Gets the value of the createdSince property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCreatedSince() {
        return createdSince;
    }

    /**
     * Sets the value of the createdSince property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCreatedSince(String value) {
        this.createdSince = value;
    }

    /**
     * Gets the value of the createdUntil property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCreatedUntil() {
        return createdUntil;
    }

    /**
     * Sets the value of the createdUntil property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCreatedUntil(String value) {
        this.createdUntil = value;
    }

    /**
     * Gets the value of the sizeFrom property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getSizeFrom() {
        return sizeFrom;
    }

    /**
     * Sets the value of the sizeFrom property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setSizeFrom(Integer value) {
        this.sizeFrom = value;
    }

    /**
     * Gets the value of the sizeUntil property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getSizeUntil() {
        return sizeUntil;
    }

    /**
     * Sets the value of the sizeUntil property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setSizeUntil(Integer value) {
        this.sizeUntil = value;
    }

    /**
     * Gets the value of the contentType property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contentType property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContentType().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     *
     *
     */
    public List<String> getContentType() {
        if (contentType == null) {
            contentType = new ArrayList<String>();
        }
        return this.contentType;
    }

    /**
     * Gets the value of the metaDataOnly property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean isMetaDataOnly() {
        return metaDataOnly;
    }

    /**
     * Sets the value of the metaDataOnly property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setMetaDataOnly(Boolean value) {
        this.metaDataOnly = value;
    }

    /**
     * Gets the value of the attributeAccessor property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getAttributeAccessor() {
        return attributeAccessor;
    }

    /**
     * Sets the value of the attributeAccessor property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAttributeAccessor(String value) {
        this.attributeAccessor = value;
    }

    public String toString() {
        return "ContentInstanceFilterCriteriaType [creator=" + creator
                + ", searchString=" + searchString + ", createdSince="
                + createdSince + ", createdUntil=" + createdUntil
                + ", sizeFrom=" + sizeFrom + ", sizeUntil=" + sizeUntil
                + ", contentType=" + contentType + ", metaDataOnly="
                + metaDataOnly + ", attributeAccessor=" + attributeAccessor
                + "]";
    }

}
