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
 *  xxx 
 * 
 * <p>Java class for S124_ReferencesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="S124_ReferencesType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.iho.int/S124/gml/1.0}S124_InformationTypeType">
 *       &lt;sequence>
 *         &lt;element name="referenceType" type="{http://www.iho.int/S124/gml/1.0}S124_referenceTypeType"/>
 *         &lt;element name="messageReference" type="{http://www.iho.int/S124/gml/1.0}S124_messageSeriesIdentifierType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="cancellationTime" type="{http://www.iho.int/S124/gml/1.0}cancellationTimeType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="header" type="{http://www.opengis.net/gml/3.2}ReferenceType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "S124_ReferencesType", namespace = "http://www.iho.int/S124/gml/1.0")
public class S124ReferencesType
    extends S124InformationTypeType
{


}
