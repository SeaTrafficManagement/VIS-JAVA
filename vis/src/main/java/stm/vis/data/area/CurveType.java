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
import javax.xml.bind.annotation.XmlType;


/**
 * S-100 curve type adds an information association to the GML spatial type Curve
 * 
 * <p>Java class for CurveType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CurveType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengis.net/gml/3.2}CurveType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.iho.int/s100gml/1.0}informationAssociation" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CurveType", namespace = "http://www.iho.int/s100gml/1.0", propOrder = {
    "informationAssociation"
})
public class CurveType
    extends CurveType2
{

    protected List<InformationPropertyType> informationAssociation;

    /**
     * Gets the value of the informationAssociation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the informationAssociation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInformationAssociation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InformationPropertyType }
     * 
     * 
     */
    public List<InformationPropertyType> getInformationAssociation() {
        if (informationAssociation == null) {
            informationAssociation = new ArrayList<InformationPropertyType>();
        }
        return this.informationAssociation;
    }

}
