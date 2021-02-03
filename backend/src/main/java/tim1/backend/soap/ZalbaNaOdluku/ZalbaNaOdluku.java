
package tim1.backend.soap.ZalbaNaOdluku;

import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Zalba" type="{http://www.ftn.uns.ac.rs/zalba-na-odluku}TZalbaNaOdluku"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;anyAttribute processContents='lax'/&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "zalba"
})
@XmlRootElement(name = "zalba_na_odluku")
public class ZalbaNaOdluku {

    @XmlElement(name = "Zalba", required = true)
    protected TZalbaNaOdluku zalba;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * Gets the value of the zalba property.
     * 
     * @return
     *     possible object is
     *     {@link TZalbaNaOdluku }
     *     
     */
    public TZalbaNaOdluku getZalba() {
        return zalba;
    }

    /**
     * Sets the value of the zalba property.
     * 
     * @param value
     *     allowed object is
     *     {@link TZalbaNaOdluku }
     *     
     */
    public void setZalba(TZalbaNaOdluku value) {
        this.zalba = value;
    }

    /**
     * Gets a map that contains attributes that aren't bound to any typed property on this class.
     * 
     * <p>
     * the map is keyed by the name of the attribute and 
     * the value is the string value of the attribute.
     * 
     * the map returned by this method is live, and you can add new attribute
     * by updating the map directly. Because of this design, there's no setter.
     * 
     * 
     * @return
     *     always non-null
     */
    public Map<QName, String> getOtherAttributes() {
        return otherAttributes;
    }

}
