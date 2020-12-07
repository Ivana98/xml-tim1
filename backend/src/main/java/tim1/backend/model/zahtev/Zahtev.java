//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.12.07 at 12:36:58 PM CET 
//


package tim1.backend.model.zahtev;

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
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/zahtev}info_organa"/>
 *         &lt;element name="naslov" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="svrha_zahteva" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/zahtev}opis_zahteva"/>
 *         &lt;element name="mesto" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="datum" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/zahtev}trazilac"/>
 *         &lt;element name="footer" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "infoOrgana",
    "naslov",
    "svrhaZahteva",
    "opisZahteva",
    "mesto",
    "datum",
    "trazilac",
    "footer"
})
@XmlRootElement(name = "zahtev")
public class Zahtev {

    @XmlElement(name = "info_organa", required = true)
    protected InfoOrgana infoOrgana;
    @XmlElement(required = true)
    protected String naslov;
    @XmlElement(name = "svrha_zahteva", required = true)
    protected String svrhaZahteva;
    @XmlElement(name = "opis_zahteva", required = true)
    protected OpisZahteva opisZahteva;
    @XmlElement(required = true)
    protected String mesto;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datum;
    @XmlElement(required = true)
    protected Trazilac trazilac;
    @XmlElement(required = true)
    protected String footer;

    /**
     * Gets the value of the infoOrgana property.
     * 
     * @return
     *     possible object is
     *     {@link InfoOrgana }
     *     
     */
    public InfoOrgana getInfoOrgana() {
        return infoOrgana;
    }

    /**
     * Sets the value of the infoOrgana property.
     * 
     * @param value
     *     allowed object is
     *     {@link InfoOrgana }
     *     
     */
    public void setInfoOrgana(InfoOrgana value) {
        this.infoOrgana = value;
    }

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
     * Gets the value of the svrhaZahteva property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSvrhaZahteva() {
        return svrhaZahteva;
    }

    /**
     * Sets the value of the svrhaZahteva property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSvrhaZahteva(String value) {
        this.svrhaZahteva = value;
    }

    /**
     * Gets the value of the opisZahteva property.
     * 
     * @return
     *     possible object is
     *     {@link OpisZahteva }
     *     
     */
    public OpisZahteva getOpisZahteva() {
        return opisZahteva;
    }

    /**
     * Sets the value of the opisZahteva property.
     * 
     * @param value
     *     allowed object is
     *     {@link OpisZahteva }
     *     
     */
    public void setOpisZahteva(OpisZahteva value) {
        this.opisZahteva = value;
    }

    /**
     * Gets the value of the mesto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMesto() {
        return mesto;
    }

    /**
     * Sets the value of the mesto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMesto(String value) {
        this.mesto = value;
    }

    /**
     * Gets the value of the datum property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatum() {
        return datum;
    }

    /**
     * Sets the value of the datum property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatum(XMLGregorianCalendar value) {
        this.datum = value;
    }

    /**
     * Gets the value of the trazilac property.
     * 
     * @return
     *     possible object is
     *     {@link Trazilac }
     *     
     */
    public Trazilac getTrazilac() {
        return trazilac;
    }

    /**
     * Sets the value of the trazilac property.
     * 
     * @param value
     *     allowed object is
     *     {@link Trazilac }
     *     
     */
    public void setTrazilac(Trazilac value) {
        this.trazilac = value;
    }

    /**
     * Gets the value of the footer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFooter() {
        return footer;
    }

    /**
     * Sets the value of the footer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFooter(String value) {
        this.footer = value;
    }

}
