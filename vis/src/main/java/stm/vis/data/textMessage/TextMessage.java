//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.09.03 at 10:34:56 AM GMT+01:00 
//


package stm.vis.data.textMessage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="textMessageId" type="{http://stmvalidation.eu/schemas/textMessageSchema_1_3.xsd}textMessageURN"/>
 *         &lt;element name="informationObjectReferenceId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="informationObjectReferenceType" type="{http://stmvalidation.eu/schemas/textMessageSchema_1_3.xsd}informationObjectTypeEnum" minOccurs="0"/>
 *         &lt;element name="validityPeriodStart" type="{http://stmvalidation.eu/schemas/textMessageSchema_1_3.xsd}DateTimeUTC" minOccurs="0"/>
 *         &lt;element name="validityPeriodStop" type="{http://stmvalidation.eu/schemas/textMessageSchema_1_3.xsd}DateTimeUTC" minOccurs="0"/>
 *         &lt;element name="author" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="from" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="serviceType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="createdAt" type="{http://stmvalidation.eu/schemas/textMessageSchema_1_3.xsd}DateTimeUTC"/>
 *         &lt;element name="subject" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="body" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="position" type="{http://stmvalidation.eu/schemas/textMessageSchema_1_3.xsd}GM_Point" minOccurs="0"/>
 *         &lt;element name="area" type="{http://stmvalidation.eu/schemas/textMessageSchema_1_3.xsd}GM_Surface" minOccurs="0"/>
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
    "textMessageId",
    "informationObjectReferenceId",
    "informationObjectReferenceType",
    "validityPeriodStart",
    "validityPeriodStop",
    "author",
    "from",
    "serviceType",
    "createdAt",
    "subject",
    "body",
    "position",
    "area"
})
@XmlRootElement(name = "textMessage")
public class TextMessage {

    @XmlElement(required = true)
    protected String textMessageId;
    protected String informationObjectReferenceId;
    protected InformationObjectTypeEnum informationObjectReferenceType;
    protected XMLGregorianCalendar validityPeriodStart;
    protected XMLGregorianCalendar validityPeriodStop;
    @XmlElement(required = true)
    protected String author;
    @XmlElement(required = true)
    protected String from;
    protected String serviceType;
    @XmlElement(required = true)
    protected XMLGregorianCalendar createdAt;
    @XmlElement(required = true)
    protected String subject;
    @XmlElement(required = true)
    protected String body;
    protected GMPoint position;
    protected GMSurface area;

    /**
     * Gets the value of the textMessageId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTextMessageId() {
        return textMessageId;
    }

    /**
     * Sets the value of the textMessageId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTextMessageId(String value) {
        this.textMessageId = value;
    }

    /**
     * Gets the value of the informationObjectReferenceId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInformationObjectReferenceId() {
        return informationObjectReferenceId;
    }

    /**
     * Sets the value of the informationObjectReferenceId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInformationObjectReferenceId(String value) {
        this.informationObjectReferenceId = value;
    }

    /**
     * Gets the value of the informationObjectReferenceType property.
     * 
     * @return
     *     possible object is
     *     {@link InformationObjectTypeEnum }
     *     
     */
    public InformationObjectTypeEnum getInformationObjectReferenceType() {
        return informationObjectReferenceType;
    }

    /**
     * Sets the value of the informationObjectReferenceType property.
     * 
     * @param value
     *     allowed object is
     *     {@link InformationObjectTypeEnum }
     *     
     */
    public void setInformationObjectReferenceType(InformationObjectTypeEnum value) {
        this.informationObjectReferenceType = value;
    }

    /**
     * Gets the value of the validityPeriodStart property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getValidityPeriodStart() {
        return validityPeriodStart;
    }

    /**
     * Sets the value of the validityPeriodStart property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setValidityPeriodStart(XMLGregorianCalendar value) {
        this.validityPeriodStart = value;
    }

    /**
     * Gets the value of the validityPeriodStop property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getValidityPeriodStop() {
        return validityPeriodStop;
    }

    /**
     * Sets the value of the validityPeriodStop property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setValidityPeriodStop(XMLGregorianCalendar value) {
        this.validityPeriodStop = value;
    }

    /**
     * Gets the value of the author property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets the value of the author property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthor(String value) {
        this.author = value;
    }

    /**
     * Gets the value of the from property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFrom() {
        return from;
    }

    /**
     * Sets the value of the from property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFrom(String value) {
        this.from = value;
    }

    /**
     * Gets the value of the serviceType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceType() {
        return serviceType;
    }

    /**
     * Sets the value of the serviceType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceType(String value) {
        this.serviceType = value;
    }

    /**
     * Gets the value of the createdAt property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets the value of the createdAt property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreatedAt(XMLGregorianCalendar value) {
        this.createdAt = value;
    }

    /**
     * Gets the value of the subject property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Sets the value of the subject property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubject(String value) {
        this.subject = value;
    }

    /**
     * Gets the value of the body property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBody() {
        return body;
    }

    /**
     * Sets the value of the body property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBody(String value) {
        this.body = value;
    }

    /**
     * Gets the value of the position property.
     * 
     * @return
     *     possible object is
     *     {@link GMPoint }
     *     
     */
    public GMPoint getPosition() {
        return position;
    }

    /**
     * Sets the value of the position property.
     * 
     * @param value
     *     allowed object is
     *     {@link GMPoint }
     *     
     */
    public void setPosition(GMPoint value) {
        this.position = value;
    }

    /**
     * Gets the value of the area property.
     * 
     * @return
     *     possible object is
     *     {@link GMSurface }
     *     
     */
    public GMSurface getArea() {
        return area;
    }

    /**
     * Sets the value of the area property.
     * 
     * @param value
     *     allowed object is
     *     {@link GMSurface }
     *     
     */
    public void setArea(GMSurface value) {
        this.area = value;
    }

}
