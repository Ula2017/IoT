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
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2013.06.24 at 02:43:33 AM CEST
//


package org.eclipse.om2m.commons.resource;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;



/**
 * <p>Java Class for Subscription complex type.
 *
 * <p>Subscription resource is used to keep track of status of active subscription
 * to its parent resource. A subscription represents a request from the Issuer to be
 * notified about modifications on the parent resource.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Subscription">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://uri.etsi.org/m2m}expirationTime" minOccurs="0"/>
 *         &lt;choice minOccurs="0">
 *           &lt;element ref="{http://uri.etsi.org/m2m}minimalTimeBetweenNotifications"/>
 *           &lt;element ref="{http://uri.etsi.org/m2m}delayTolerance"/>
 *         &lt;/choice>
 *         &lt;element ref="{http://uri.etsi.org/m2m}creationTime" minOccurs="0"/>
 *         &lt;element ref="{http://uri.etsi.org/m2m}lastModifiedTime" minOccurs="0"/>
 *         &lt;element ref="{http://uri.etsi.org/m2m}filterCriteria" minOccurs="0"/>
 *         &lt;element ref="{http://uri.etsi.org/m2m}subscriptionType" minOccurs="0"/>
 *         &lt;element ref="{http://uri.etsi.org/m2m}contact" minOccurs="0"/>
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
@XmlType(name = "Subscription")
@XmlRootElement
@Entity(name=DBEntities.SUBSCRIPTION_ENTITY)
public class Subscription extends Resource {

    @XmlSchemaType(name = "dateTime")
    protected String expirationTime;
    protected Long minimalTimeBetweenNotifications;
    @XmlSchemaType(name = "dateTime")
    protected String delayTolerance;
    @XmlSchemaType(name = "dateTime")
    protected String creationTime;
    @XmlSchemaType(name = "dateTime")
    protected String lastModifiedTime;
    @Embedded
    protected FilterCriteriaType filterCriteria;
    @Enumerated(EnumType.STRING)
    protected SubscriptionType subscriptionType;
    @XmlSchemaType(name = "anyURI")
    protected String contact;
    @XmlAttribute(name = "id", namespace = "http://uri.etsi.org/m2m")
    @XmlSchemaType(name = "anyURI")
    protected String id;


    /**
     * Subscription Constructor
     */
    public Subscription() {
    }

    /**
     * Subscription Constructor
     * @param id - The id of the subscription
     */
    public Subscription(String id) {
        super();
        this.id = id;
    }

    /**
     * Subscription Constructor
     * @param id - The id of the subscription
     * @param contact - The contact uri of the subscriber
     */
    public Subscription(String id, String contact) {
        super();
        this.id = id;
        this.contact = contact;
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
     * Gets the value of the property minimalTimeBetweenNotifications.
     *
     * @return
     *     possible object is
     *     {@link Long }
     *
     */
    public Long getMinimalTimeBetweenNotifications() {
        return minimalTimeBetweenNotifications;
    }

    /**
     * Sets the value of the property minimalTimeBetweenNotifications.
     *
     * @param value
     *     allowed object is
     *     {@link Long }
     *
     */
    public void setMinimalTimeBetweenNotifications(Long value) {
        this.minimalTimeBetweenNotifications = value;
    }

    /**
     * Gets the value of the property delayTolerance.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDelayTolerance() {
        return delayTolerance;
    }

    /**
     * Sets the value of the property delayTolerance.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDelayTolerance(String value) {
        this.delayTolerance = value;
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
     * Gets the value of the property filterCriteria.
     *
     * @return
     *     possible object is
     *     {@link FilterCriteriaType }
     *
     */
    public FilterCriteriaType getFilterCriteria() {
        return filterCriteria;
    }

    /**
     * Sets the value of the property filterCriteria.
     *
     * @param value
     *     allowed object is
     *     {@link FilterCriteriaType }
     *
     */
    public void setFilterCriteria(FilterCriteriaType value) {
        this.filterCriteria = value;
    }

    /**
     * Gets the value of the property subscriptionType.
     *
     * @return
     *     possible object is
     *     {@link SubscriptionType }
     *
     */
    public SubscriptionType getSubscriptionType() {
        return subscriptionType;
    }

    /**
     * Sets the value of the property subscriptionType.
     *
     * @param value
     *     allowed object is
     *     {@link SubscriptionType }
     *
     */
    public void setSubscriptionType(SubscriptionType value) {
        this.subscriptionType = value;
    }

    /**
     * Gets the value of the property contact.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getContact() {
        return contact;
    }

    /**
     * Sets the value of the property contact.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setContact(String value) {
        this.contact = value;
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