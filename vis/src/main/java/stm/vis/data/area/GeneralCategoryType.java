//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.09.03 at 12:29:04 PM GMT+01:00 
//


package stm.vis.data.area;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for generalCategoryType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="generalCategoryType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="aids to navigation"/>
 *     &lt;enumeration value="dangerous wreck"/>
 *     &lt;enumeration value="unwleldy tow"/>
 *     &lt;enumeration value="drifting hazard"/>
 *     &lt;enumeration value="SAR and anti pollution operations"/>
 *     &lt;enumeration value="newly discovered dangers"/>
 *     &lt;enumeration value="route alterations or suspensions"/>
 *     &lt;enumeration value="underwater operations"/>
 *     &lt;enumeration value="pipe or cable laying operations"/>
 *     &lt;enumeration value="seismic surveys"/>
 *     &lt;enumeration value="research or scientific operations"/>
 *     &lt;enumeration value="offshore structures"/>
 *     &lt;enumeration value="radio navigation services"/>
 *     &lt;enumeration value="special operations"/>
 *     &lt;enumeration value="operating anomalies identified within ECDIS including ENC issues"/>
 *     &lt;enumeration value="security-related requirements"/>
 *     &lt;enumeration value="piracy"/>
 *     &lt;enumeration value="tsunamis and other natural phenomena"/>
 *     &lt;enumeration value="World Health Organization (WHO) health advisory information"/>
 *     &lt;enumeration value="SailRaceEvent"/>
 *     &lt;enumeration value="military exersices"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "generalCategoryType", namespace = "http://www.iho.int/S124/gml/1.0")
@XmlEnum
public enum GeneralCategoryType {

    @XmlEnumValue("aids to navigation")
    AIDS_TO_NAVIGATION("aids to navigation"),
    @XmlEnumValue("dangerous wreck")
    DANGEROUS_WRECK("dangerous wreck"),
    @XmlEnumValue("unwleldy tow")
    UNWLELDY_TOW("unwleldy tow"),
    @XmlEnumValue("drifting hazard")
    DRIFTING_HAZARD("drifting hazard"),
    @XmlEnumValue("SAR and anti pollution operations")
    SAR_AND_ANTI_POLLUTION_OPERATIONS("SAR and anti pollution operations"),
    @XmlEnumValue("newly discovered dangers")
    NEWLY_DISCOVERED_DANGERS("newly discovered dangers"),
    @XmlEnumValue("route alterations or suspensions")
    ROUTE_ALTERATIONS_OR_SUSPENSIONS("route alterations or suspensions"),
    @XmlEnumValue("underwater operations")
    UNDERWATER_OPERATIONS("underwater operations"),
    @XmlEnumValue("pipe or cable laying operations")
    PIPE_OR_CABLE_LAYING_OPERATIONS("pipe or cable laying operations"),
    @XmlEnumValue("seismic surveys")
    SEISMIC_SURVEYS("seismic surveys"),
    @XmlEnumValue("research or scientific operations")
    RESEARCH_OR_SCIENTIFIC_OPERATIONS("research or scientific operations"),
    @XmlEnumValue("offshore structures")
    OFFSHORE_STRUCTURES("offshore structures"),
    @XmlEnumValue("radio navigation services")
    RADIO_NAVIGATION_SERVICES("radio navigation services"),
    @XmlEnumValue("special operations")
    SPECIAL_OPERATIONS("special operations"),
    @XmlEnumValue("operating anomalies identified within ECDIS including ENC issues")
    OPERATING_ANOMALIES_IDENTIFIED_WITHIN_ECDIS_INCLUDING_ENC_ISSUES("operating anomalies identified within ECDIS including ENC issues"),
    @XmlEnumValue("security-related requirements")
    SECURITY_RELATED_REQUIREMENTS("security-related requirements"),
    @XmlEnumValue("piracy")
    PIRACY("piracy"),
    @XmlEnumValue("tsunamis and other natural phenomena")
    TSUNAMIS_AND_OTHER_NATURAL_PHENOMENA("tsunamis and other natural phenomena"),
    @XmlEnumValue("World Health Organization (WHO) health advisory information")
    WORLD_HEALTH_ORGANIZATION_WHO_HEALTH_ADVISORY_INFORMATION("World Health Organization (WHO) health advisory information"),
    @XmlEnumValue("SailRaceEvent")
    SAIL_RACE_EVENT("SailRaceEvent"),
    @XmlEnumValue("military exersices")
    MILITARY_EXERSICES("military exersices");
    private final String value;

    GeneralCategoryType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static GeneralCategoryType fromValue(String v) {
        for (GeneralCategoryType c: GeneralCategoryType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}