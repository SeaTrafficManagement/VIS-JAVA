//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.09.03 at 12:29:04 PM GMT+01:00 
//


package stm.vis.data.area;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Data Set Structure information
 * 
 * <p>Java class for DataSetStructureInformationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DataSetStructureInformationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="datasetCoordOriginX" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="datasetCoordOriginY" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="datasetCoordOriginZ" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="coordMultFactorX" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" minOccurs="0"/>
 *         &lt;element name="coordMultFactorY" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" minOccurs="0"/>
 *         &lt;element name="coordMultFactorZ" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" minOccurs="0"/>
 *         &lt;element name="nInfoRec" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
 *         &lt;element name="nPointRec" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
 *         &lt;element name="nMultiPointRec" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
 *         &lt;element name="nCurveRec" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
 *         &lt;element name="nCompositeCurveRec" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
 *         &lt;element name="nSurfaceRec" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
 *         &lt;element name="nFeatureRec" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataSetStructureInformationType", namespace = "http://www.iho.int/s100gml/1.0", propOrder = {
    "datasetCoordOriginX",
    "datasetCoordOriginY",
    "datasetCoordOriginZ",
    "coordMultFactorX",
    "coordMultFactorY",
    "coordMultFactorZ",
    "nInfoRec",
    "nPointRec",
    "nMultiPointRec",
    "nCurveRec",
    "nCompositeCurveRec",
    "nSurfaceRec",
    "nFeatureRec"
})
public class DataSetStructureInformationType {

    protected Double datasetCoordOriginX;
    protected Double datasetCoordOriginY;
    protected Double datasetCoordOriginZ;
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger coordMultFactorX;
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger coordMultFactorY;
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger coordMultFactorZ;
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger nInfoRec;
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger nPointRec;
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger nMultiPointRec;
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger nCurveRec;
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger nCompositeCurveRec;
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger nSurfaceRec;
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger nFeatureRec;

    /**
     * Gets the value of the datasetCoordOriginX property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getDatasetCoordOriginX() {
        return datasetCoordOriginX;
    }

    /**
     * Sets the value of the datasetCoordOriginX property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setDatasetCoordOriginX(Double value) {
        this.datasetCoordOriginX = value;
    }

    /**
     * Gets the value of the datasetCoordOriginY property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getDatasetCoordOriginY() {
        return datasetCoordOriginY;
    }

    /**
     * Sets the value of the datasetCoordOriginY property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setDatasetCoordOriginY(Double value) {
        this.datasetCoordOriginY = value;
    }

    /**
     * Gets the value of the datasetCoordOriginZ property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getDatasetCoordOriginZ() {
        return datasetCoordOriginZ;
    }

    /**
     * Sets the value of the datasetCoordOriginZ property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setDatasetCoordOriginZ(Double value) {
        this.datasetCoordOriginZ = value;
    }

    /**
     * Gets the value of the coordMultFactorX property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCoordMultFactorX() {
        return coordMultFactorX;
    }

    /**
     * Sets the value of the coordMultFactorX property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCoordMultFactorX(BigInteger value) {
        this.coordMultFactorX = value;
    }

    /**
     * Gets the value of the coordMultFactorY property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCoordMultFactorY() {
        return coordMultFactorY;
    }

    /**
     * Sets the value of the coordMultFactorY property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCoordMultFactorY(BigInteger value) {
        this.coordMultFactorY = value;
    }

    /**
     * Gets the value of the coordMultFactorZ property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCoordMultFactorZ() {
        return coordMultFactorZ;
    }

    /**
     * Sets the value of the coordMultFactorZ property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCoordMultFactorZ(BigInteger value) {
        this.coordMultFactorZ = value;
    }

    /**
     * Gets the value of the nInfoRec property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNInfoRec() {
        return nInfoRec;
    }

    /**
     * Sets the value of the nInfoRec property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNInfoRec(BigInteger value) {
        this.nInfoRec = value;
    }

    /**
     * Gets the value of the nPointRec property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNPointRec() {
        return nPointRec;
    }

    /**
     * Sets the value of the nPointRec property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNPointRec(BigInteger value) {
        this.nPointRec = value;
    }

    /**
     * Gets the value of the nMultiPointRec property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNMultiPointRec() {
        return nMultiPointRec;
    }

    /**
     * Sets the value of the nMultiPointRec property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNMultiPointRec(BigInteger value) {
        this.nMultiPointRec = value;
    }

    /**
     * Gets the value of the nCurveRec property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNCurveRec() {
        return nCurveRec;
    }

    /**
     * Sets the value of the nCurveRec property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNCurveRec(BigInteger value) {
        this.nCurveRec = value;
    }

    /**
     * Gets the value of the nCompositeCurveRec property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNCompositeCurveRec() {
        return nCompositeCurveRec;
    }

    /**
     * Sets the value of the nCompositeCurveRec property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNCompositeCurveRec(BigInteger value) {
        this.nCompositeCurveRec = value;
    }

    /**
     * Gets the value of the nSurfaceRec property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNSurfaceRec() {
        return nSurfaceRec;
    }

    /**
     * Sets the value of the nSurfaceRec property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNSurfaceRec(BigInteger value) {
        this.nSurfaceRec = value;
    }

    /**
     * Gets the value of the nFeatureRec property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNFeatureRec() {
        return nFeatureRec;
    }

    /**
     * Sets the value of the nFeatureRec property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNFeatureRec(BigInteger value) {
        this.nFeatureRec = value;
    }

}
