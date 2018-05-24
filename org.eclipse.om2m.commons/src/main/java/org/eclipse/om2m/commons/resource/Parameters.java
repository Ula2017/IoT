/*******************************************************************************
 * Copyright (c) 2013-2015 LAAS-CNRS (www.laas.fr)
 * 7 Colonel Roche 31077 Toulouse - France
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Thierry Monteil (Project co-founder) - Management and initial specification,
 *         conception and documentation.
 *     Mahdi Ben Alaya (Project co-founder) - Management and initial specification,
 *         conception, implementation, test and documentation.
 *     Christophe Chassot - Management and initial specification.
 *     Khalil Drira - Management and initial specification.
 *     Yassine Banouar - Initial specification, conception, implementation, test
 *         and documentation.
 *     Guillaume Garzone - Conception, implementation, test and documentation.
 *     Francois Aissaoui - Conception, implementation, test and documentation.
 ******************************************************************************/

// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2013.06.24 at 02:42:33 AM CEST
//


package org.eclipse.om2m.commons.resource;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;

import org.w3c.dom.Element;


/**
 * <p>Java Class for Parameters complex type.
 *
 * <p>Parameters resource collects multiple parameters or attributes for management purpose.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Parameters">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://uri.etsi.org/m2m}accessRightID" minOccurs="0"/>
 *         &lt;element ref="{http://uri.etsi.org/m2m}creationTime" minOccurs="0"/>
 *         &lt;element ref="{http://uri.etsi.org/m2m}lastModifiedTime" minOccurs="0"/>
 *         &lt;element ref="{http://uri.etsi.org/m2m}originalMO" minOccurs="0"/>
 *         &lt;element ref="{http://uri.etsi.org/m2m}parametersCollection"/>
 *         &lt;element ref="{http://uri.etsi.org/m2m}subscriptionsReference" minOccurs="0"/>
 *         &lt;any processContents='lax' namespace='##other' maxOccurs="unbounded" minOccurs="0"/>
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
@XmlRootElement
@Entity(name=DBEntities.PARAMETERS_ENTITY)
public class Parameters extends Resource{

    @XmlSchemaType(name = "dateTime")
    protected String creationTime;
    @XmlSchemaType(name = "dateTime")
    protected String lastModifiedTime;
    protected String originalMO;
    @XmlElement(required = true)
    @Embedded
    protected NamedReferenceCollection parametersCollection;
    @XmlSchemaType(name = "anyURI")
    protected String subscriptionsReference;
    @XmlAnyElement(lax = true)
    @Transient
    protected List<Object> any;
    @XmlAttribute(name = "id", namespace = "http://uri.etsi.org/m2m")
    @XmlSchemaType(name = "anyURI")
    protected String id;

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
     * Gets the value of the property originalMO.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getOriginalMO() {
        return originalMO;
    }

    /**
     * Sets the value of the property originalMO.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setOriginalMO(String value) {
        this.originalMO = value;
    }

    /**
     * Gets the value of the property parametersCollection.
     *
     * @return
     *     possible object is
     *     {@link NamedReferenceCollection }
     *
     */
    public NamedReferenceCollection getParametersCollection() {
        if (parametersCollection == null){
            parametersCollection = new NamedReferenceCollection();
        }
        return parametersCollection;
    }

    /**
     * Sets the value of the property parametersCollection.
     *
     * @param value
     *     allowed object is
     *     {@link NamedReferenceCollection }
     *
     */
    public void setParametersCollection(NamedReferenceCollection value) {
        this.parametersCollection = value;
    }

    /**
     * Gets the value of the property subscriptionsReference.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSubscriptionsReference() {
    	if (subscriptionsReference == null && uri != null) {
    		return uri+Refs.SUBSCRIPTIONS_REF;
    	} else {
			return subscriptionsReference;
    	}
    }

    /**
     * Sets the value of the property subscriptionsReference.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSubscriptionsReference(String value) {
        this.subscriptionsReference = value;
    }

    /**
     * Gets the value of the any property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the any property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAny().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * {@link Element }
     *
     *
     */
    public List<Object> getAny() {
        if (any == null) {
            any = new ArrayList<Object>();
        }
        return this.any;
    }

    public  void setAny(List<Object> any) {
        this.any = any;
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
