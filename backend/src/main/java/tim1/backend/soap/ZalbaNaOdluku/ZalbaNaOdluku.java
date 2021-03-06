
package tim1.backend.soap.ZalbaNaOdluku;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="naslov" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/zalba-na-odluku}podaci_o_povereniku"/&gt;
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/zalba-na-odluku}zalba"/&gt;
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/zalba-na-odluku}napomene"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "naslov",
    "podaciOPovereniku",
    "zalba",
    "napomene"
})
@XmlRootElement(name = "zalba_na_odluku")
public class ZalbaNaOdluku {

    @XmlElement(required = true)
    protected String naslov;
    @XmlElement(name = "podaci_o_povereniku", required = true)
    protected PodaciOPovereniku podaciOPovereniku;
    @XmlElement(required = true)
    protected Zalba zalba;
    @XmlElement(required = true)
    protected Napomene napomene;

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

}
