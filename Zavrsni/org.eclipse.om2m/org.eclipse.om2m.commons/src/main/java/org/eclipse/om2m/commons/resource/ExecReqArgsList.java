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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ExecReqArgsList complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ExecReqArgsList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="execReqArg" type="{http://uri.etsi.org/m2m}ExecReqArg" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExecReqArgsList", propOrder = {
        "execReqArg"
})
public class ExecReqArgsList {

    @XmlElement(namespace = "")
    protected List<ExecReqArg> execReqArg;

    /**
     * Gets the value of the execReqArg property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the execReqArg property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExecReqArg().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExecReqArg }
     *
     *
     */
    public List<ExecReqArg> getExecReqArg() {
        if (execReqArg == null) {
            execReqArg = new ArrayList<ExecReqArg>();
        }
        return this.execReqArg;
    }

    public String toString() {
        return "ExecReqArgsList [execReqArg=" + execReqArg + "]";
    }

}
