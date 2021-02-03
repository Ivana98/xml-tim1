
package tim1.backend.soap.ZalbaNaCutanje;

import java.io.Serializable;
import java.util.ArrayList;
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
import javax.xml.bind.annotation.XmlValue;
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
 *         &lt;element name="Namena" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Adresa_za_postu"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Mesto"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;simpleContent&gt;
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *                           &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                           &lt;attribute name="datatype" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                         &lt;/extension&gt;
 *                       &lt;/simpleContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="Ulica"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;simpleContent&gt;
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *                           &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                           &lt;attribute name="datatype" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                         &lt;/extension&gt;
 *                       &lt;/simpleContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="Broj" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *                 &lt;/sequence&gt;
 *                 &lt;attribute name="about" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Sadrzaj"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Naziv_organa"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                         &lt;maxLength value="50"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="Razlozi_zalbe"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;extension base="{http://www.ftn.uns.ac.rs/zalba-na-cutanje}Select"&gt;
 *                           &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                           &lt;attribute name="datatype" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                         &lt;/extension&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="Datum_podnosenja_zahteva"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;simpleContent&gt;
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;date"&gt;
 *                           &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                           &lt;attribute name="datatype" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                         &lt;/extension&gt;
 *                       &lt;/simpleContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="Podaci_o_zahtevu" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="Pasus" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/&gt;
 *                   &lt;element name="Napomena" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *                 &lt;attribute name="about" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/zalba-na-cutanje}Podnosilac_zalbe"/&gt;
 *         &lt;element name="Vreme_i_mesto"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Mesto" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="Datum" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="naslov" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
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
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="Mesto"&gt;
     *           &lt;complexType&gt;
     *             &lt;simpleContent&gt;
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
     *                 &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *                 &lt;attribute name="datatype" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *               &lt;/extension&gt;
     *             &lt;/simpleContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="Ulica"&gt;
     *           &lt;complexType&gt;
     *             &lt;simpleContent&gt;
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
     *                 &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *                 &lt;attribute name="datatype" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *               &lt;/extension&gt;
     *             &lt;/simpleContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="Broj" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
     *       &lt;/sequence&gt;
     *       &lt;attribute name="about" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
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
        protected ZalbaNaCutanje.AdresaZaPostu.Mesto mesto;
        @XmlElement(name = "Ulica", required = true)
        protected ZalbaNaCutanje.AdresaZaPostu.Ulica ulica;
        @XmlElement(name = "Broj")
        protected int broj;
        @XmlAttribute(name = "about")
        protected String about;

        /**
         * Gets the value of the mesto property.
         * 
         * @return
         *     possible object is
         *     {@link ZalbaNaCutanje.AdresaZaPostu.Mesto }
         *     
         */
        public ZalbaNaCutanje.AdresaZaPostu.Mesto getMesto() {
            return mesto;
        }

        /**
         * Sets the value of the mesto property.
         * 
         * @param value
         *     allowed object is
         *     {@link ZalbaNaCutanje.AdresaZaPostu.Mesto }
         *     
         */
        public void setMesto(ZalbaNaCutanje.AdresaZaPostu.Mesto value) {
            this.mesto = value;
        }

        /**
         * Gets the value of the ulica property.
         * 
         * @return
         *     possible object is
         *     {@link ZalbaNaCutanje.AdresaZaPostu.Ulica }
         *     
         */
        public ZalbaNaCutanje.AdresaZaPostu.Ulica getUlica() {
            return ulica;
        }

        /**
         * Sets the value of the ulica property.
         * 
         * @param value
         *     allowed object is
         *     {@link ZalbaNaCutanje.AdresaZaPostu.Ulica }
         *     
         */
        public void setUlica(ZalbaNaCutanje.AdresaZaPostu.Ulica value) {
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

        /**
         * Gets the value of the about property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAbout() {
            return about;
        }

        /**
         * Sets the value of the about property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAbout(String value) {
            this.about = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;simpleContent&gt;
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
         *       &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *       &lt;attribute name="datatype" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *     &lt;/extension&gt;
         *   &lt;/simpleContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class Mesto {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "property")
            protected String property;
            @XmlAttribute(name = "datatype")
            protected String datatype;

            /**
             * Gets the value of the value property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * Gets the value of the property property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getProperty() {
                return property;
            }

            /**
             * Sets the value of the property property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setProperty(String value) {
                this.property = value;
            }

            /**
             * Gets the value of the datatype property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDatatype() {
                return datatype;
            }

            /**
             * Sets the value of the datatype property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDatatype(String value) {
                this.datatype = value;
            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;simpleContent&gt;
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
         *       &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *       &lt;attribute name="datatype" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *     &lt;/extension&gt;
         *   &lt;/simpleContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class Ulica {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "property")
            protected String property;
            @XmlAttribute(name = "datatype")
            protected String datatype;

            /**
             * Gets the value of the value property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * Gets the value of the property property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getProperty() {
                return property;
            }

            /**
             * Sets the value of the property property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setProperty(String value) {
                this.property = value;
            }

            /**
             * Gets the value of the datatype property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDatatype() {
                return datatype;
            }

            /**
             * Sets the value of the datatype property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDatatype(String value) {
                this.datatype = value;
            }

        }

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
     *         &lt;element name="Naziv_organa"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;maxLength value="50"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="Razlozi_zalbe"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;extension base="{http://www.ftn.uns.ac.rs/zalba-na-cutanje}Select"&gt;
     *                 &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *                 &lt;attribute name="datatype" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *               &lt;/extension&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="Datum_podnosenja_zahteva"&gt;
     *           &lt;complexType&gt;
     *             &lt;simpleContent&gt;
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;date"&gt;
     *                 &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *                 &lt;attribute name="datatype" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *               &lt;/extension&gt;
     *             &lt;/simpleContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="Podaci_o_zahtevu" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="Pasus" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/&gt;
     *         &lt;element name="Napomena" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *       &lt;/sequence&gt;
     *       &lt;attribute name="about" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "content"
    })
    public static class Sadrzaj {

        @XmlElementRefs({
            @XmlElementRef(name = "Podaci_o_zahtevu", namespace = "http://www.ftn.uns.ac.rs/zalba-na-cutanje", type = JAXBElement.class),
            @XmlElementRef(name = "Pasus", namespace = "http://www.ftn.uns.ac.rs/zalba-na-cutanje", type = JAXBElement.class),
            @XmlElementRef(name = "Razlozi_zalbe", namespace = "http://www.ftn.uns.ac.rs/zalba-na-cutanje", type = JAXBElement.class),
            @XmlElementRef(name = "Napomena", namespace = "http://www.ftn.uns.ac.rs/zalba-na-cutanje", type = JAXBElement.class),
            @XmlElementRef(name = "Datum_podnosenja_zahteva", namespace = "http://www.ftn.uns.ac.rs/zalba-na-cutanje", type = JAXBElement.class),
            @XmlElementRef(name = "Naziv_organa", namespace = "http://www.ftn.uns.ac.rs/zalba-na-cutanje", type = JAXBElement.class)
        })
        @XmlMixed
        protected List<Serializable> content;
        @XmlAttribute(name = "about")
        protected String about;

        /**
         * Gets the value of the content property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the content property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getContent().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link JAXBElement }{@code <}{@link String }{@code >}
         * {@link JAXBElement }{@code <}{@link String }{@code >}
         * {@link JAXBElement }{@code <}{@link ZalbaNaCutanje.Sadrzaj.RazloziZalbe }{@code >}
         * {@link JAXBElement }{@code <}{@link String }{@code >}
         * {@link String }
         * {@link JAXBElement }{@code <}{@link ZalbaNaCutanje.Sadrzaj.DatumPodnosenjaZahteva }{@code >}
         * {@link JAXBElement }{@code <}{@link String }{@code >}
         * 
         * 
         */
        public List<Serializable> getContent() {
            if (content == null) {
                content = new ArrayList<Serializable>();
            }
            return this.content;
        }

        /**
         * Gets the value of the about property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAbout() {
            return about;
        }

        /**
         * Sets the value of the about property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAbout(String value) {
            this.about = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;simpleContent&gt;
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;date"&gt;
         *       &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *       &lt;attribute name="datatype" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *     &lt;/extension&gt;
         *   &lt;/simpleContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class DatumPodnosenjaZahteva {

            @XmlValue
            @XmlSchemaType(name = "date")
            protected XMLGregorianCalendar value;
            @XmlAttribute(name = "property")
            protected String property;
            @XmlAttribute(name = "datatype")
            protected String datatype;

            /**
             * Gets the value of the value property.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setValue(XMLGregorianCalendar value) {
                this.value = value;
            }

            /**
             * Gets the value of the property property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getProperty() {
                return property;
            }

            /**
             * Sets the value of the property property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setProperty(String value) {
                this.property = value;
            }

            /**
             * Gets the value of the datatype property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDatatype() {
                return datatype;
            }

            /**
             * Sets the value of the datatype property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDatatype(String value) {
                this.datatype = value;
            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;extension base="{http://www.ftn.uns.ac.rs/zalba-na-cutanje}Select"&gt;
         *       &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *       &lt;attribute name="datatype" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *     &lt;/extension&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class RazloziZalbe
            extends Select
        {

            @XmlAttribute(name = "property")
            protected String property;
            @XmlAttribute(name = "datatype")
            protected String datatype;

            /**
             * Gets the value of the property property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getProperty() {
                return property;
            }

            /**
             * Sets the value of the property property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setProperty(String value) {
                this.property = value;
            }

            /**
             * Gets the value of the datatype property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDatatype() {
                return datatype;
            }

            /**
             * Sets the value of the datatype property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDatatype(String value) {
                this.datatype = value;
            }

        }

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
     *         &lt;element name="Mesto" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="Datum" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
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
