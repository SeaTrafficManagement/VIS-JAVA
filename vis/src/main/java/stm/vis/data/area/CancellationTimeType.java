//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.09.03 at 12:29:04 PM GMT+01:00 
//


package stm.vis.data.area;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Describes a end date before that message is left in-force.
 * Remarks: Sub-attributes date end must have the calendar year encoded using 4 digits for the calendar year (CCYY). Month (MM) and day (DD) are optional.
 * (This definition merges the planned S-100 temporal model with the current S-101 DCEG definition of fixed date range.)
 * 
 * <p>Java class for cancellationTimeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="cancellationTimeType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="timeOfDayEnd" type="{http://www.w3.org/2001/XMLSchema}time" minOccurs="0"/>
 *         &lt;element name="dateEnd" type="{http://www.iho.int/S124/gml/1.0}S100_TruncatedDate" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cancellationTimeType", namespace = "http://www.iho.int/S124/gml/1.0", propOrder = {
    "timeOfDayEnd",
    "dateEnd"
})
public class CancellationTimeType {

    @XmlElement(namespace = "")
    @XmlSchemaType(name = "time")
    protected XMLGregorianCalendar timeOfDayEnd;
    @XmlElement(namespace = "")
    protected S100TruncatedDate dateEnd;

    /**
     * Gets the value of the timeOfDayEnd property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTimeOfDayEnd() {
        return timeOfDayEnd;
    }

    /**
     * Sets the value of the timeOfDayEnd property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTimeOfDayEnd(XMLGregorianCalendar value) {
        this.timeOfDayEnd = value;
    }

    /**
     * Gets the value of the dateEnd property.
     * 
     * @return
     *     possible object is
     *     {@link S100TruncatedDate }
     *     
     */
    public S100TruncatedDate getDateEnd() {
        return dateEnd;
    }

    /**
     * Sets the value of the dateEnd property.
     * 
     * @param value
     *     allowed object is
     *     {@link S100TruncatedDate }
     *     
     */
    public void setDateEnd(S100TruncatedDate value) {
        this.dateEnd = value;
    }

}
