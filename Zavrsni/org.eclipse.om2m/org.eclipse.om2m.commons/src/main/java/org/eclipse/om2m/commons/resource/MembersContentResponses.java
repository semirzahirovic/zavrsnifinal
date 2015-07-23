//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2013.06.24 at 02:40:35 AM CEST
//


package org.eclipse.om2m.commons.resource;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;



/**
 * <p>Java Class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="status" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="statusCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="eTag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="lastModifiedTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                   &lt;element name="resultBody" type="{http://www.w3.org/2005/05/xmlmime}base64Binary" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "status"
})
@XmlRootElement(name = "membersContentResponses")
public class MembersContentResponses extends Resource{

    protected List<MembersContentResponses.Status> status;

    /**
     * Gets the value of the status property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the status property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStatus().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MembersContentResponses.Status }
     *
     *
     */
    public List<MembersContentResponses.Status> getStatus() {
        if (status == null) {
            status = new ArrayList<MembersContentResponses.Status>();
        }
        return this.status;
    }


    /**
     * <p>Java Class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="statusCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="eTag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="lastModifiedTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
     *         &lt;element name="resultBody" type="{http://www.w3.org/2005/05/xmlmime}base64Binary" minOccurs="0"/>
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
    @XmlType(name = "", propOrder = {
            "statusCode",
            "eTag",
            "lastModifiedTime",
            "resultBody"
    })
    public static class Status {

        @XmlElement(required = true)
        protected String statusCode;
        protected String eTag;
        @XmlSchemaType(name = "dateTime")
        protected String lastModifiedTime;
        protected Base64Binary resultBody;
        @XmlAttribute(name = "id")
        @XmlSchemaType(name = "anyURI")
        protected String id;

        /**
         * Gets the value of the property statusCode.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getStatusCode() {
            return statusCode;
        }

        /**
         * Sets the value of the property statusCode.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setStatusCode(String value) {
            this.statusCode = value;
        }

        /**
         * Gets the value of the property eTag.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getETag() {
            return eTag;
        }

        /**
         * Sets the value of the property eTag.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setETag(String value) {
            this.eTag = value;
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
         * Gets the value of the property resultBody.
         *
         * @return
         *     possible object is
         *     {@link Base64Binary }
         *
         */
        public Base64Binary getResultBody() {
            return resultBody;
        }

        /**
         * Sets the value of the property resultBody.
         *
         * @param value
         *     allowed object is
         *     {@link Base64Binary }
         *
         */
        public void setResultBody(Base64Binary value) {
            this.resultBody = value;
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

}
