//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.09.03 at 12:29:04 PM GMT+01:00 
//


package stm.vis.data.area;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ISO-3166-1-alpha2.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ISO-3166-1-alpha2">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="KR"/>
 *     &lt;enumeration value="US"/>
 *     &lt;enumeration value="JS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ISO-3166-1-alpha2", namespace = "http://www.iho.int/s100gml/1.0")
@XmlEnum
public enum ISO31661Alpha2 {

    KR,
    US,

    /**
     * Jussland - Not ISO 3166, but needed for sample datasets
     * 
     */
    JS;

    public String value() {
        return name();
    }

    public static ISO31661Alpha2 fromValue(String v) {
        return valueOf(v);
    }

}
