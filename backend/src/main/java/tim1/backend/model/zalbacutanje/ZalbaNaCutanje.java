//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.12.07 at 11:15:56 AM CET 
//


package tim1.backend.model.zalbacutanje;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;



/**
 * &lt;p&gt;Java class for anonymous complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="Namena" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="Adresa_za_postu"&amp;gt;
 *           &amp;lt;complexType&amp;gt;
 *             &amp;lt;complexContent&amp;gt;
 *               &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *                 &amp;lt;sequence&amp;gt;
 *                   &amp;lt;element name="Mesto" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *                   &amp;lt;element name="Ulica" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *                   &amp;lt;element name="Broj" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *                 &amp;lt;/sequence&amp;gt;
 *               &amp;lt;/restriction&amp;gt;
 *             &amp;lt;/complexContent&amp;gt;
 *           &amp;lt;/complexType&amp;gt;
 *         &amp;lt;/element&amp;gt;
 *         &amp;lt;element name="Sadrzaj"&amp;gt;
 *           &amp;lt;complexType&amp;gt;
 *             &amp;lt;complexContent&amp;gt;
 *               &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *                 &amp;lt;sequence&amp;gt;
 *                   &amp;lt;element name="Naziv_organa"&amp;gt;
 *                     &amp;lt;simpleType&amp;gt;
 *                       &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
 *                         &amp;lt;maxLength value="50"/&amp;gt;
 *                       &amp;lt;/restriction&amp;gt;
 *                     &amp;lt;/simpleType&amp;gt;
 *                   &amp;lt;/element&amp;gt;
 *                   &amp;lt;element name="Razlozi_zalbe" type="{http://www.ftn.uns.ac.rs/zalba-na-cutanje}Select"/&amp;gt;
 *                   &amp;lt;element name="Datum_podnosenja_zahteva" type="{http://www.w3.org/2001/XMLSchema}date"/&amp;gt;
 *                   &amp;lt;element name="Podaci_o_zahtevu" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *                   &amp;lt;element name="Pasus" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/&amp;gt;
 *                   &amp;lt;element name="Napomena" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *                 &amp;lt;/sequence&amp;gt;
 *               &amp;lt;/restriction&amp;gt;
 *             &amp;lt;/complexContent&amp;gt;
 *           &amp;lt;/complexType&amp;gt;
 *         &amp;lt;/element&amp;gt;
 *         &amp;lt;element ref="{http://www.ftn.uns.ac.rs/zalba-na-cutanje}Podnosilac_zalbe"/&amp;gt;
 *         &amp;lt;element name="Vreme_i_mesto"&amp;gt;
 *           &amp;lt;complexType&amp;gt;
 *             &amp;lt;complexContent&amp;gt;
 *               &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *                 &amp;lt;sequence&amp;gt;
 *                   &amp;lt;element name="Mesto" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *                   &amp;lt;element name="Datum" type="{http://www.w3.org/2001/XMLSchema}date"/&amp;gt;
 *                 &amp;lt;/sequence&amp;gt;
 *               &amp;lt;/restriction&amp;gt;
 *             &amp;lt;/complexContent&amp;gt;
 *           &amp;lt;/complexType&amp;gt;
 *         &amp;lt;/element&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *       &amp;lt;attribute name="naslov" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "namena",
    "adresaZaPostu",
    "sadrzaj",
    "podnosilacZalbe",
    "vremeIMesto"
})
@XmlRootElement(name = "Zalba_na_cutanje")
public class ZalbaNaCutanje {

    @XmlElement(name = "Namena", required = true)
    protected String namena;
    @XmlElement(name = "Adresa_za_postu", required = true)
    protected ZalbaNaCutanje.AdresaZaPostu adresaZaPostu;
    @XmlElement(name = "Sadrzaj", required = true)
    protected ZalbaNaCutanje.Sadrzaj sadrzaj;
    @XmlElement(name = "Podnosilac_zalbe", required = true)
    protected PodnosilacZalbe podnosilacZalbe;
    @XmlElement(name = "Vreme_i_mesto", required = true)
    protected ZalbaNaCutanje.VremeIMesto vremeIMesto;
    @XmlAttribute(name = "naslov")
    protected String naslov;

    /**
     * Gets the value of the namena property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNamena() {
        return namena;
    }

    /**
     * Sets the value of the namena property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNamena(String value) {
        this.namena = value;
    }

    /**
     * Gets the value of the adresaZaPostu property.
     * 
     * @return
     *     possible object is
     *     {@link ZalbaNaCutanje.AdresaZaPostu }
     *     
     */
    public ZalbaNaCutanje.AdresaZaPostu getAdresaZaPostu() {
        return adresaZaPostu;
    }

    /**
     * Sets the value of the adresaZaPostu property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZalbaNaCutanje.AdresaZaPostu }
     *     
     */
    public void setAdresaZaPostu(ZalbaNaCutanje.AdresaZaPostu value) {
        this.adresaZaPostu = value;
    }

    /**
     * Gets the value of the sadrzaj property.
     * 
     * @return
     *     possible object is
     *     {@link ZalbaNaCutanje.Sadrzaj }
     *     
     */
    public ZalbaNaCutanje.Sadrzaj getSadrzaj() {
        return sadrzaj;
    }

    /**
     * Sets the value of the sadrzaj property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZalbaNaCutanje.Sadrzaj }
     *     
     */
    public void setSadrzaj(ZalbaNaCutanje.Sadrzaj value) {
        this.sadrzaj = value;
    }

    /**
     * Gets the value of the podnosilacZalbe property.
     * 
     * @return
     *     possible object is
     *     {@link PodnosilacZalbe }
     *     
     */
    public PodnosilacZalbe getPodnosilacZalbe() {
        return podnosilacZalbe;
    }

    /**
     * Sets the value of the podnosilacZalbe property.
     * 
     * @param value
     *     allowed object is
     *     {@link PodnosilacZalbe }
     *     
     */
    public void setPodnosilacZalbe(PodnosilacZalbe value) {
        this.podnosilacZalbe = value;
    }

    /**
     * Gets the value of the vremeIMesto property.
     * 
     * @return
     *     possible object is
     *     {@link ZalbaNaCutanje.VremeIMesto }
     *     
     */
    public ZalbaNaCutanje.VremeIMesto getVremeIMesto() {
        return vremeIMesto;
    }

    /**
     * Sets the value of the vremeIMesto property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZalbaNaCutanje.VremeIMesto }
     *     
     */
    public void setVremeIMesto(ZalbaNaCutanje.VremeIMesto value) {
        this.vremeIMesto = value;
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
     * &lt;p&gt;Java class for anonymous complex type.
     * 
     * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
     * 
     * &lt;pre&gt;
     * &amp;lt;complexType&amp;gt;
     *   &amp;lt;complexContent&amp;gt;
     *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
     *       &amp;lt;sequence&amp;gt;
     *         &amp;lt;element name="Mesto" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
     *         &amp;lt;element name="Ulica" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
     *         &amp;lt;element name="Broj" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
     *       &amp;lt;/sequence&amp;gt;
     *     &amp;lt;/restriction&amp;gt;
     *   &amp;lt;/complexContent&amp;gt;
     * &amp;lt;/complexType&amp;gt;
     * &lt;/pre&gt;
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "mesto",
        "ulica",
        "broj"
    })
    public static class AdresaZaPostu {

        @XmlElement(name = "Mesto", required = true)
        protected String mesto;
        @XmlElement(name = "Ulica", required = true)
        protected String ulica;
        @XmlElement(name = "Broj")
        protected int broj;

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
         * Gets the value of the ulica property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getUlica() {
            return ulica;
        }

        /**
         * Sets the value of the ulica property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setUlica(String value) {
            this.ulica = value;
        }

        /**
         * Gets the value of the broj property.
         * 
         */
        public int getBroj() {
            return broj;
        }

        /**
         * Sets the value of the broj property.
         * 
         */
        public void setBroj(int value) {
            this.broj = value;
        }

    }


    /**
     * &lt;p&gt;Java class for anonymous complex type.
     * 
     * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
     * 
     * &lt;pre&gt;
     * &amp;lt;complexType&amp;gt;
     *   &amp;lt;complexContent&amp;gt;
     *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
     *       &amp;lt;sequence&amp;gt;
     *         &amp;lt;element name="Naziv_organa"&amp;gt;
     *           &amp;lt;simpleType&amp;gt;
     *             &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
     *               &amp;lt;maxLength value="50"/&amp;gt;
     *             &amp;lt;/restriction&amp;gt;
     *           &amp;lt;/simpleType&amp;gt;
     *         &amp;lt;/element&amp;gt;
     *         &amp;lt;element name="Razlozi_zalbe" type="{http://www.ftn.uns.ac.rs/zalba-na-cutanje}Select"/&amp;gt;
     *         &amp;lt;element name="Datum_podnosenja_zahteva" type="{http://www.w3.org/2001/XMLSchema}date"/&amp;gt;
     *         &amp;lt;element name="Podaci_o_zahtevu" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
     *         &amp;lt;element name="Pasus" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/&amp;gt;
     *         &amp;lt;element name="Napomena" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
     *       &amp;lt;/sequence&amp;gt;
     *     &amp;lt;/restriction&amp;gt;
     *   &amp;lt;/complexContent&amp;gt;
     * &amp;lt;/complexType&amp;gt;
     * &lt;/pre&gt;
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "content"
    })
    public static class Sadrzaj {
    	/*@XmlElement(required = true)
	    protected String Naziv_organa;
		@XmlElement(required = true)
	    protected Select Razlozi_zalbe;
		@XmlElement(required = true)
	    protected Date Datum_podnosenja_zahteva;
		@XmlElement(required = true)
	    protected String Podaci_o_zahtevu;
		@XmlElement(required = true)
	    protected List<String> Pasus;
		@XmlElement(required = false)
	    protected String Napomena;
		*/

        @XmlElementRefs({
            @XmlElementRef(name = "Naziv_organa", namespace = "http://www.ftn.uns.ac.rs/zalba-na-cutanje", type = JAXBElement.class),
            @XmlElementRef(name = "Razlozi_zalbe", namespace = "http://www.ftn.uns.ac.rs/zalba-na-cutanje", type = JAXBElement.class),
            @XmlElementRef(name = "Datum_podnosenja_zahteva", namespace = "http://www.ftn.uns.ac.rs/zalba-na-cutanje", type = JAXBElement.class),
            @XmlElementRef(name = "Podaci_o_zahtevu", namespace = "http://www.ftn.uns.ac.rs/zalba-na-cutanje", type = JAXBElement.class),
            @XmlElementRef(name = "Pasus", namespace = "http://www.ftn.uns.ac.rs/zalba-na-cutanje", type = JAXBElement.class),
            @XmlElementRef(name = "Napomena", namespace = "http://www.ftn.uns.ac.rs/zalba-na-cutanje", type = JAXBElement.class)
        })
        @XmlMixed
        protected List<Serializable> content;

        /**
         * Gets the value of the content property.
         * 
         * &lt;p&gt;
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the content property.
         * 
         * &lt;p&gt;
         * For example, to add a new item, do as follows:
         * &lt;pre&gt;
         *    getContent().add(newItem);
         * &lt;/pre&gt;
         * 
         * 
         * &lt;p&gt;
         * Objects of the following type(s) are allowed in the list
         * {@link JAXBElement }{@code <}{@link String }{@code >}
         * {@link JAXBElement }{@code <}{@link Select }{@code >}
         * {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
         * {@link JAXBElement }{@code <}{@link String }{@code >}
         * {@link JAXBElement }{@code <}{@link String }{@code >}
         * {@link JAXBElement }{@code <}{@link String }{@code >}
         * {@link String }
         * 
         * 
         */
        public List<Serializable> getContent() {
            if (content == null) {
                content = new ArrayList<Serializable>();
            }
            return this.content;
        }

    }


    /**
     * &lt;p&gt;Java class for anonymous complex type.
     * 
     * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
     * 
     * &lt;pre&gt;
     * &amp;lt;complexType&amp;gt;
     *   &amp;lt;complexContent&amp;gt;
     *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
     *       &amp;lt;sequence&amp;gt;
     *         &amp;lt;element name="Mesto" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
     *         &amp;lt;element name="Datum" type="{http://www.w3.org/2001/XMLSchema}date"/&amp;gt;
     *       &amp;lt;/sequence&amp;gt;
     *     &amp;lt;/restriction&amp;gt;
     *   &amp;lt;/complexContent&amp;gt;
     * &amp;lt;/complexType&amp;gt;
     * &lt;/pre&gt;
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "mesto",
        "datum"
    })
    public static class VremeIMesto {

        @XmlElement(name = "Mesto", required = true)
        protected String mesto;
        @XmlElement(name = "Datum", required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar datum;

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

    }

}
