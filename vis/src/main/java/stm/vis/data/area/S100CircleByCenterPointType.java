//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.09.03 at 12:29:04 PM GMT+01:00 
//


package stm.vis.data.area;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for S100_CircleByCenterPointType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="S100_CircleByCenterPointType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.iho.int/s100gml/1.0}S100_ArcByCenterPointType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element ref="{http://www.opengis.net/gml/3.2}pos"/>
 *           &lt;element ref="{http://www.opengis.net/gml/3.2}pointProperty"/>
 *         &lt;/choice>
 *         &lt;element name="radius" type="{http://www.opengis.net/gml/3.2}LengthType"/>
 *         &lt;element name="startAngle" type="{http://www.iho.int/s100gml/1.0}BearingType"/>
 *         &lt;element name="angularDistance">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.iho.int/s100gml/1.0}PlusOrMinus360Degrees">
 *               &lt;enumeration value="360.0"/>
 *               &lt;enumeration value="-360.0"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "S100_CircleByCenterPointType", namespace = "http://www.iho.int/s100gml/1.0")
public class S100CircleByCenterPointType
    extends S100ArcByCenterPointType
{


}