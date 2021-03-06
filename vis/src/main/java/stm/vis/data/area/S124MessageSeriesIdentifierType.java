//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.09.03 at 12:29:04 PM GMT+01:00 
//


package stm.vis.data.area;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 *  xxx 
 * 
 * <p>Java class for S124_messageSeriesIdentifierType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="S124_messageSeriesIdentifierType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NameOfSeries" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="typeOfWarning" type="{http://www.iho.int/S124/gml/1.0}S124_typeOfWarningType"/>
 *         &lt;element name="warningNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="year" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="productionAgency" type="{http://www.iho.int/S124/gml/1.0}S124_LocalizedTextType" maxOccurs="unbounded"/>
 *         &lt;element name="country" type="{http://www.iho.int/S124/gml/1.0}countryType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "S124_messageSeriesIdentifierType", namespace = "http://www.iho.int/S124/gml/1.0", propOrder = {
    "nameOfSeries",
    "typeOfWarning",
    "warningNumber",
    "year",
    "productionAgency",
    "country"
})
public class S124MessageSeriesIdentifierType {

    @XmlElement(name = "NameOfSeries", namespace = "", required = true)
    protected String nameOfSeries;
    @XmlElement(namespace = "", required = true)
    protected S124TypeOfWarningType typeOfWarning;
    @XmlElement(namespace = "")
    protected int warningNumber;
    @XmlElement(namespace = "")
    protected int year;
    @XmlElement(namespace = "", required = true)
    protected List<S124LocalizedTextType> productionAgency;
    @XmlElement(namespace = "", required = true)
    protected CountryType country;

    /**
     * Gets the value of the nameOfSeries property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameOfSeries() {
        return nameOfSeries;
    }

    /**
     * Sets the value of the nameOfSeries property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameOfSeries(String value) {
        this.nameOfSeries = value;
    }

    /**
     * Gets the value of the typeOfWarning property.
     * 
     * @return
     *     possible object is
     *     {@link S124TypeOfWarningType }
     *     
     */
    public S124TypeOfWarningType getTypeOfWarning() {
        return typeOfWarning;
    }

    /**
     * Sets the value of the typeOfWarning property.
     * 
     * @param value
     *     allowed object is
     *     {@link S124TypeOfWarningType }
     *     
     */
    public void setTypeOfWarning(S124TypeOfWarningType value) {
        this.typeOfWarning = value;
    }

    /**
     * Gets the value of the warningNumber property.
     * 
     */
    public int getWarningNumber() {
        return warningNumber;
    }

    /**
     * Sets the value of the warningNumber property.
     * 
     */
    public void setWarningNumber(int value) {
        this.warningNumber = value;
    }

    /**
     * Gets the value of the year property.
     * 
     */
    public int getYear() {
        return year;
    }

    /**
     * Sets the value of the year property.
     * 
     */
    public void setYear(int value) {
        this.year = value;
    }

    /**
     * Gets the value of the productionAgency property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the productionAgency property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProductionAgency().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link S124LocalizedTextType }
     * 
     * 
     */
    public List<S124LocalizedTextType> getProductionAgency() {
        if (productionAgency == null) {
            productionAgency = new ArrayList<S124LocalizedTextType>();
        }
        return this.productionAgency;
    }

    /**
     * Gets the value of the country property.
     * 
     * @return
     *     possible object is
     *     {@link CountryType }
     *     
     */
    public CountryType getCountry() {
        return country;
    }

    /**
     * Sets the value of the country property.
     * 
     * @param value
     *     allowed object is
     *     {@link CountryType }
     *     
     */
    public void setCountry(CountryType value) {
        this.country = value;
    }

}
