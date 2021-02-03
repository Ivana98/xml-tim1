
package tim1.sluzbenik.soap.Zahtev;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
 *         &lt;element name="nacini_slanja" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{http://www.ftn.uns.ac.rs/zahtev}nacin_slanja" maxOccurs="unbounded"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="selektovan" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="rb" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
 *       &lt;attribute name="tekst" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "naciniSlanja"
})
@XmlRootElement(name = "tip_zahteva")
public class TipZahteva {

    @XmlElement(name = "nacini_slanja")
    protected TipZahteva.NaciniSlanja naciniSlanja;
    @XmlAttribute(name = "selektovan")
    protected Boolean selektovan;
    @XmlAttribute(name = "rb")
    protected Integer rb;
    @XmlAttribute(name = "tekst")
    protected String tekst;

    /**
     * Gets the value of the naciniSlanja property.
     * 
     * @return
     *     possible object is
     *     {@link TipZahteva.NaciniSlanja }
     *     
     */
    public TipZahteva.NaciniSlanja getNaciniSlanja() {
        return naciniSlanja;
    }

    /**
     * Sets the value of the naciniSlanja property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipZahteva.NaciniSlanja }
     *     
     */
    public void setNaciniSlanja(TipZahteva.NaciniSlanja value) {
        this.naciniSlanja = value;
    }

    /**
     * Gets the value of the selektovan property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSelektovan() {
        return selektovan;
    }

    /**
     * Sets the value of the selektovan property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSelektovan(Boolean value) {
        this.selektovan = value;
    }

    /**
     * Gets the value of the rb property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRb() {
        return rb;
    }

    /**
     * Sets the value of the rb property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRb(Integer value) {
        this.rb = value;
    }

    /**
     * Gets the value of the tekst property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTekst() {
        return tekst;
    }

    /**
     * Sets the value of the tekst property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTekst(String value) {
        this.tekst = value;
    }


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
     *         &lt;element ref="{http://www.ftn.uns.ac.rs/zahtev}nacin_slanja" maxOccurs="unbounded"/&gt;
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
        "nacinSlanja"
    })
    public static class NaciniSlanja {

        @XmlElement(name = "nacin_slanja", required = true)
        protected List<NacinSlanja> nacinSlanja;

        /**
         * Gets the value of the nacinSlanja property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the nacinSlanja property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getNacinSlanja().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link NacinSlanja }
         * 
         * 
         */
        public List<NacinSlanja> getNacinSlanja() {
            if (nacinSlanja == null) {
                nacinSlanja = new ArrayList<NacinSlanja>();
            }
            return this.nacinSlanja;
        }

    }

}
