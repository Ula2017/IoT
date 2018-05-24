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
// Generated on: 2014.01.25 at 05:56:27 PM CET
//


package org.eclipse.om2m.commons.resource;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;



/**
 * <p>Java class for ContentInstance complex type.
 *
 * <p>ContentInstance resource represents a data instance in the container.
 * The content of the instance is opaque to the M2M platform and it might even
 * be encrypted. However, there is meta-data associated with an instance which
 * shall be accessible.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ContentInstance">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://uri.etsi.org/m2m}creationTime" minOccurs="0"/>
 *         &lt;element ref="{http://uri.etsi.org/m2m}lastModifiedTime" minOccurs="0"/>
 *         &lt;element ref="{http://uri.etsi.org/m2m}delayTolerance" minOccurs="0"/>
 *         &lt;element ref="{http://uri.etsi.org/m2m}contentTypes" minOccurs="0"/>
 *         &lt;element ref="{http://uri.etsi.org/m2m}contentSize" minOccurs="0"/>
 *         &lt;element ref="{http://uri.etsi.org/m2m}content" minOccurs="0"/>
 *       &lt;s/sequence>
 *       &lt;attribute ref="{http://uri.etsi.org/m2m}id"/>
 *       &lt;attribute name="href" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@Entity(name=DBEntities.CONTENT_INSTANCE_ENTITY)
public class ContentInstance extends Resource {

    @XmlSchemaType(name = "dateTime")
    protected String creationTime;
    @XmlSchemaType(name = "dateTime")
    protected String lastModifiedTime;
    @XmlSchemaType(name = "dateTime")
    protected String delayTolerance;
    @Embedded
    protected ContentTypes contentTypes;
    protected Long contentSize;
    @Embedded
    protected Base64Binary content;
    @XmlAttribute(name = "id", namespace = "http://uri.etsi.org/m2m")
    @XmlSchemaType(name = "anyURI")
    protected String id;
    @XmlAttribute(name = "href")
    @XmlSchemaType(name = "anyURI")
    protected String href;

    /**
     * ContentInstance Constructor
     */
    public ContentInstance(){
        super();
        this.content = new Base64Binary();
    }

    /**
     * ContentInstance Constructor
     * @param id - The id of the contentInstance
     */
    public ContentInstance(String id) {
        super();
        this.id = id;
        this.content = new Base64Binary();
    }

    /**
     * ContentInstance Constructor
     * @param value - The value of the contentInstance content
     */
    public ContentInstance(byte[] value) {
        super();
        this.content = new Base64Binary();
        this.content.setValue(value);
    }

    /**
     * ContentInstance Constructor
     * @param id - The id of the ContentInstance
     * @param value - The value of the contentInstance content
     */
    public ContentInstance(String id, byte[] value) {
        super();
        this.id = id;
        this.content = new Base64Binary();
        this.content.setValue(value);
    }

    /**
     * Gets the value of the creationTime property.
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
     * Sets the value of the creationTime property.
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
     * Gets the value of the lastModifiedTime property.
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
     * Sets the value of the lastModifiedTime property.
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
     * Gets the value of the delayTolerance property.
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
     * Sets the value of the delayTolerance property.
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
     * Gets the value of the contentTypes property.
     *
     * @return
     *     possible object is
     *     {@link ContentTypes }
     *
     */
    public ContentTypes getContentTypes() {
        return contentTypes;
    }

    /**
     * Sets the value of the contentTypes property.
     *
     * @param value
     *     allowed object is
     *     {@link ContentTypes }
     *
     */
    public void setContentTypes(ContentTypes value) {
        this.contentTypes = value;
    }

    /**
     * Gets the value of the contentSize property.
     *
     * @return
     *     possible object is
     *     {@link Long }
     *
     */
    public Long getContentSize() {
        return contentSize;
    }

    /**
     * Sets the value of the contentSize property.
     *
     * @param value
     *     allowed object is
     *     {@link Long }
     *
     */
    public void setContentSize(Long value) {
        this.contentSize = value;
    }

    /**
     * Gets the value of the content property.
     *
     * @return
     *     possible object is
     *     {@link Base64Binary }
     *
     */
    public Base64Binary getContent() {
        return content;
    }

    /**
     * Sets the value of the content property.
     *
     * @param value
     *     allowed object is
     *     {@link Base64Binary }
     *
     */
    public void setContent(Base64Binary value) {
        this.content = value;
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

    /**
     * Gets the value of the href property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getHref() {
        return href;
    }

    /**
     * Sets the value of the href property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setHref(String value) {
        this.href = value;
    }

    public String toString() {
        return "ContentInstance [creationTime=" + creationTime
                + ", lastModifiedTime=" + lastModifiedTime
                + ", delayTolerance=" + delayTolerance + ", contentTypes="
                + contentTypes + ", contentSize=" + contentSize + ", content="
                + content + ", id=" + id + ", href=" + href + "]";
    }

}
