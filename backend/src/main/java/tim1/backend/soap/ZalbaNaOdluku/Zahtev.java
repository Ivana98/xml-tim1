
package tim1.backend.soap.ZalbaNaOdluku;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element name="broj_zahteva" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="godina" type="{http://www.w3.org/2001/XMLSchema}gYear"/&gt;
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
    "brojZahteva",
    "godina"
})
@XmlRootElement(name = "zahtev")
public class Zahtev {

    @XmlElement(name = "broj_zahteva")
    protected int brojZahteva;
    @XmlElement(required = true)
    @XmlSchemaType(name = "gYear")
    protected XMLGregorianCalendar godina;

    /**
     * Gets the value of the brojZahteva property.
     * 
     */
    public int getBrojZahteva() {
        return brojZahteva;
    }

    /**
     * Sets the value of the brojZahteva property.
     * 
     */
    public void setBrojZahteva(int value) {
        this.brojZahteva = value;
    }

    /**
     * Gets the value of the godina property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getGodina() {
        return godina;
    }

    /**
     * Sets the value of the godina property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setGodina(XMLGregorianCalendar value) {
        this.godina = value;
    }

}
