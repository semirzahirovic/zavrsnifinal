//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2014.01.25 at 05:56:27 PM CET
//

package org.eclipse.om2m.commons.resource;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Discovery complex type.
 *
 * <p> Discovery resource is used to perform a discovery of resource matching
 * specified filterCriteria under the {@link SclBase} and provide the list of URIs
 * back to the issuer.
 *<br>
 * It does not represent a real resource in the sense that its representation
 * does not have an e-tag.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Discovery">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://uri.etsi.org/m2m}matchSize" minOccurs="0"/>
 *         &lt;element ref="{http://uri.etsi.org/m2m}truncated" minOccurs="0"/>
 *         &lt;element ref="{http://uri.etsi.org/m2m}discoveryURI" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Discovery", propOrder = {
        "matchSize",
        "truncated",
        "discoveryURI"
})
@XmlRootElement
public class Discovery extends Resource{

    protected Long matchSize;
    protected Boolean truncated;
    protected AnyURIList discoveryURI;

    /**
     * Gets the value of the matchSize property.
     *
     * @return
     *     possible object is
     *     {@link Long }
     *
     */
    public Long getMatchSize() {
        return matchSize;
    }

    /**
     * Sets the value of the matchSize property.
     *
     * @param value
     *     allowed object is
     *     {@link Long }
     *
     */
    public void setMatchSize(Long value) {
        this.matchSize = value;
    }

    /**
     * Gets the value of the truncated property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean isTruncated() {
        return truncated;
    }

    /**
     * Sets the value of the truncated property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setTruncated(Boolean value) {
        this.truncated = value;
    }

    /**
     * Gets the value of the discoveryURI property.
     *
     * @return
     *     possible object is
     *     {@link AnyURIList }
     *
     */
    public AnyURIList getDiscoveryURI() {
        if(discoveryURI == null){
            discoveryURI = new AnyURIList();
        }
        return discoveryURI;
    }

    /**
     * Sets the value of the discoveryURI property.
     *
     * @param value
     *     allowed object is
     *     {@link AnyURIList }
     *
     */
    public void setDiscoveryURI(AnyURIList value) {
        this.discoveryURI = value;
    }

    public String toString() {
        return "Discovery [matchSize=" + matchSize + ", truncated=" + truncated
                + ", discoveryURI=" + discoveryURI + "]";
    }
}
