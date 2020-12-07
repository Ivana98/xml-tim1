//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1-b171012.0423 
//         See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
//         Any modifications to this file will be lost upon recompilation of the source schema. 
//         Generated on: 2020.12.07 at 11:10:35 AM CET 
//


package tim1.backend.model.obavestenje;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected         content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Osnovni_podaci"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{http://www.ftn.uns.ac.rs/obavestenjecir}Organ"/&gt;
 *                   &lt;element name="Broj_predmeta"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
 *                         &lt;minInclusive value="0"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="Datum"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}date"&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element ref="{http://www.ftn.uns.ac.rs/obavestenjecir}Podnosioc_zahteva"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Sadrzaj"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Naslov" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="Podnaslov" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element ref="{http://www.ftn.uns.ac.rs/obavestenjecir}Paragraf"/&gt;
 *                   &lt;element ref="{http://www.ftn.uns.ac.rs/obavestenjecir}Dostavljeno"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
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
    "osnovniPodaci",
    "sadrzaj"
})
@XmlRootElement(name = "Obavestenje")
public class Obavestenje {

    @XmlElement(name = "Osnovni_podaci", required = true)
    protected Obavestenje.OsnovniPodaci osnovniPodaci;
    @XmlElement(name = "Sadrzaj", required = true)
    protected Obavestenje.Sadrzaj sadrzaj;

    /**
     * Gets the value of the osnovniPodaci property.
     * 
     * @return
     *     possible object is
     *     {@link Obavestenje.OsnovniPodaci }
     *     
     */
    public Obavestenje.OsnovniPodaci getOsnovniPodaci() {
        return osnovniPodaci;
    }

    /**
     * Sets the value of the osnovniPodaci property.
     * 
     * @param value
     *     allowed object is
     *     {@link Obavestenje.OsnovniPodaci }
     *     
     */
    public void setOsnovniPodaci(Obavestenje.OsnovniPodaci value) {
        this.osnovniPodaci = value;
    }

    /**
     * Gets the value of the sadrzaj property.
     * 
     * @return
     *     possible object is
     *     {@link Obavestenje.Sadrzaj }
     *     
     */
    public Obavestenje.Sadrzaj getSadrzaj() {
        return sadrzaj;
    }

    /**
     * Sets the value of the sadrzaj property.
     * 
     * @param value
     *     allowed object is
     *     {@link Obavestenje.Sadrzaj }
     *     
     */
    public void setSadrzaj(Obavestenje.Sadrzaj value) {
        this.sadrzaj = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected         content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element ref="{http://www.ftn.uns.ac.rs/obavestenjecir}Organ"/&gt;
     *         &lt;element name="Broj_predmeta"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
     *               &lt;minInclusive value="0"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="Datum"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}date"&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element ref="{http://www.ftn.uns.ac.rs/obavestenjecir}Podnosioc_zahteva"/&gt;
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
        "organ",
        "brojPredmeta",
        "datum",
        "podnosiocZahteva"
    })
    public static class OsnovniPodaci {

        @XmlElement(name = "Organ", required = true)
        protected Organ organ;
        @XmlElement(name = "Broj_predmeta")
        protected int brojPredmeta;
        @XmlElement(name = "Datum", required = true)
        protected XMLGregorianCalendar datum;
        @XmlElement(name = "Podnosioc_zahteva", required = true)
        protected PodnosiocZahteva podnosiocZahteva;

        /**
         * Gets the value of the organ property.
         * 
         * @return
         *     possible object is
         *     {@link Organ }
         *     
         */
        public Organ getOrgan() {
            return organ;
        }

        /**
         * Sets the value of the organ property.
         * 
         * @param value
         *     allowed object is
         *     {@link Organ }
         *     
         */
        public void setOrgan(Organ value) {
            this.organ = value;
        }

        /**
         * Gets the value of the brojPredmeta property.
         * 
         */
        public int getBrojPredmeta() {
            return brojPredmeta;
        }

        /**
         * Sets the value of the brojPredmeta property.
         * 
         */
        public void setBrojPredmeta(int value) {
            this.brojPredmeta = value;
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
         * Gets the value of the podnosiocZahteva property.
         * 
         * @return
         *     possible object is
         *     {@link PodnosiocZahteva }
         *     
         */
        public PodnosiocZahteva getPodnosiocZahteva() {
            return podnosiocZahteva;
        }

        /**
         * Sets the value of the podnosiocZahteva property.
         * 
         * @param value
         *     allowed object is
         *     {@link PodnosiocZahteva }
         *     
         */
        public void setPodnosiocZahteva(PodnosiocZahteva value) {
            this.podnosiocZahteva = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected         content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="Naslov" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="Podnaslov" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element ref="{http://www.ftn.uns.ac.rs/obavestenjecir}Paragraf"/&gt;
     *         &lt;element ref="{http://www.ftn.uns.ac.rs/obavestenjecir}Dostavljeno"/&gt;
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
        "podnaslov",
        "paragraf",
        "dostavljeno"
    })
    public static class Sadrzaj {

        @XmlElement(name = "Naslov", required = true)
        protected String naslov;
        @XmlElement(name = "Podnaslov", required = true)
        protected String podnaslov;
        @XmlElement(name = "Paragraf", required = true)
        protected Paragraf paragraf;
        @XmlElement(name = "Dostavljeno", required = true)
        protected Select dostavljeno;

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
         * Gets the value of the podnaslov property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPodnaslov() {
            return podnaslov;
        }

        /**
         * Sets the value of the podnaslov property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPodnaslov(String value) {
            this.podnaslov = value;
        }

        /**
         * Gets the value of the paragraf property.
         * 
         * @return
         *     possible object is
         *     {@link Paragraf }
         *     
         */
        public Paragraf getParagraf() {
            return paragraf;
        }

        /**
         * Sets the value of the paragraf property.
         * 
         * @param value
         *     allowed object is
         *     {@link Paragraf }
         *     
         */
        public void setParagraf(Paragraf value) {
            this.paragraf = value;
        }

        /**
         * Gets the value of the dostavljeno property.
         * 
         * @return
         *     possible object is
         *     {@link Select }
         *     
         */
        public Select getDostavljeno() {
            return dostavljeno;
        }

        /**
         * Sets the value of the dostavljeno property.
         * 
         * @param value
         *     allowed object is
         *     {@link Select }
         *     
         */
        public void setDostavljeno(Select value) {
            this.dostavljeno = value;
        }

    }

}
