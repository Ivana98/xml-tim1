
package tim1.sluzbenik.soap.Zahtev;

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
 *         &lt;element name="detaljan_opis" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="rb" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
 *       &lt;attribute name="selektovan" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" /&gt;
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
    "detaljanOpis"
})
@XmlRootElement(name = "nacin_slanja")
public class NacinSlanja {

    @XmlElement(name = "detaljan_opis")
    protected String detaljanOpis;
    @XmlAttribute(name = "rb")
    protected Integer rb;
    @XmlAttribute(name = "selektovan")
    protected Boolean selektovan;
    @XmlAttribute(name = "tekst")
    protected String tekst;

    /**
     * Gets the value of the detaljanOpis property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDetaljanOpis() {
        return detaljanOpis;
    }

    /**
     * Sets the value of the detaljanOpis property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDetaljanOpis(String value) {
        this.detaljanOpis = value;
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
     * Gets the value of the selektovan property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isSelektovan() {
        if (selektovan == null) {
            return false;
        } else {
            return selektovan;
        }
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

}
