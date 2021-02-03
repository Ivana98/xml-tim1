
package tim1.backend.soap.ZalbaNaOdluku;

import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;


/**
 * <p>Java class for TZalbaNaOdluku complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TZalbaNaOdluku"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="naslov" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/zalba-na-odluku}podaci_o_povereniku"/&gt;
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/zalba-na-odluku}zalba"/&gt;
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/zalba-na-odluku}napomene"/&gt;
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
@XmlType(name = "TZalbaNaOdluku", propOrder = {
    "naslov",
    "podaciOPovereniku",
    "zalba",
    "napomene"
})
public class TZalbaNaOdluku {

    @XmlElement(required = true)
    protected String naslov;
    @XmlElement(name = "podaci_o_povereniku", required = true)
    protected PodaciOPovereniku podaciOPovereniku;
    @XmlElement(required = true)
    protected Zalba zalba;
    @XmlElement(required = true)
    protected Napomene napomene;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * Gets the value of the naslov property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNaslov() {
        return naslov;
    }

    /**
     * Sets the value of the naslov property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNaslov(String value) {
        this.naslov = value;
    }

    /**
     * Gets the value of the podaciOPovereniku property.
     * 
     * @return
     *     possible object is
     *     {@link PodaciOPovereniku }
     *     
     */
    public PodaciOPovereniku getPodaciOPovereniku() {
        return podaciOPovereniku;
    }

    /**
     * Sets the value of the podaciOPovereniku property.
     * 
     * @param value
     *     allowed object is
     *     {@link PodaciOPovereniku }
     *     
     */
    public void setPodaciOPovereniku(PodaciOPovereniku value) {
        this.podaciOPovereniku = value;
    }

    /**
     * Gets the value of the zalba property.
     * 
     * @return
     *     possible object is
     *     {@link Zalba }
     *     
     */
    public Zalba getZalba() {
        return zalba;
    }

    /**
     * Sets the value of the zalba property.
     * 
     * @param value
     *     allowed object is
     *     {@link Zalba }
     *     
     */
    public void setZalba(Zalba value) {
        this.zalba = value;
    }

    /**
     * Gets the value of the napomene property.
     * 
     * @return
     *     possible object is
     *     {@link Napomene }
     *     
     */
    public Napomene getNapomene() {
        return napomene;
    }

    /**
     * Sets the value of the napomene property.
     * 
     * @param value
     *     allowed object is
     *     {@link Napomene }
     *     
     */
    public void setNapomene(Napomene value) {
        this.napomene = value;
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
