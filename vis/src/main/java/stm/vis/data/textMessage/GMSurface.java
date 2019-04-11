//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.09.03 at 10:34:56 AM GMT+01:00 
//


package stm.vis.data.textMessage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GM_Surface complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GM_Surface">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Polygon" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="posList" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="count" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" />
 *                 &lt;attribute name="srsDimension" type="{http://www.w3.org/2001/XMLSchema}unsignedShort" default="2" />
 *                 &lt;attribute name="srsName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Circle" type="{http://stmvalidation.eu/schemas/textMessageSchema_1_3.xsd}S100_CircleByCenterPointType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GM_Surface", propOrder = {
    "polygon",
    "circle"
})
public class GMSurface {

    @XmlElement(name = "Polygon")
    protected GMSurface.Polygon polygon;
    @XmlElement(name = "Circle")
    protected S100CircleByCenterPointType circle;

    /**
     * Gets the value of the polygon property.
     * 
     * @return
     *     possible object is
     *     {@link GMSurface.Polygon }
     *     
     */
    public GMSurface.Polygon getPolygon() {
        return polygon;
    }

    /**
     * Sets the value of the polygon property.
     * 
     * @param value
     *     allowed object is
     *     {@link GMSurface.Polygon }
     *     
     */
    public void setPolygon(GMSurface.Polygon value) {
        this.polygon = value;
    }

    /**
     * Gets the value of the circle property.
     * 
     * @return
     *     possible object is
     *     {@link S100CircleByCenterPointType }
     *     
     */
    public S100CircleByCenterPointType getCircle() {
        return circle;
    }

    /**
     * Sets the value of the circle property.
     * 
     * @param value
     *     allowed object is
     *     {@link S100CircleByCenterPointType }
     *     
     */
    public void setCircle(S100CircleByCenterPointType value) {
        this.circle = value;
    }


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
     *         &lt;element name="posList" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/sequence>
     *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="count" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" />
     *       &lt;attribute name="srsDimension" type="{http://www.w3.org/2001/XMLSchema}unsignedShort" default="2" />
     *       &lt;attribute name="srsName" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "posList"
    })
    public static class Polygon {

        @XmlElement(required = true)
        protected String posList;
        @XmlAttribute(name = "id")
        protected String id;
        @XmlAttribute(name = "count")
        @XmlSchemaType(name = "unsignedInt")
        protected Long count;
        @XmlAttribute(name = "srsDimension")
        @XmlSchemaType(name = "unsignedShort")
        protected Integer srsDimension;
        @XmlAttribute(name = "srsName")
        protected String srsName;

        /**
         * Gets the value of the posList property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPosList() {
            return posList;
        }

        /**
         * Sets the value of the posList property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPosList(String value) {
            this.posList = value;
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
         * Gets the value of the count property.
         * 
         * @return
         *     possible object is
         *     {@link Long }
         *     
         */
        public Long getCount() {
            return count;
        }

        /**
         * Sets the value of the count property.
         * 
         * @param value
         *     allowed object is
         *     {@link Long }
         *     
         */
        public void setCount(Long value) {
            this.count = value;
        }

        /**
         * Gets the value of the srsDimension property.
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public int getSrsDimension() {
            if (srsDimension == null) {
                return  2;
            } else {
                return srsDimension;
            }
        }

        /**
         * Sets the value of the srsDimension property.
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setSrsDimension(Integer value) {
            this.srsDimension = value;
        }

        /**
         * Gets the value of the srsName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSrsName() {
            return srsName;
        }

        /**
         * Sets the value of the srsName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSrsName(String value) {
            this.srsName = value;
        }

    }

}