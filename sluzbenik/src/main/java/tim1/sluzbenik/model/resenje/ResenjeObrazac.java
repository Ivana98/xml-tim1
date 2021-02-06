//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.01.30 at 01:32:26 PM CET 
//


package tim1.sluzbenik.model.resenje;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
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
 *         &amp;lt;element name="Datum" form="qualified"&amp;gt;
 *           &amp;lt;complexType&amp;gt;
 *             &amp;lt;simpleContent&amp;gt;
 *               &amp;lt;extension base="&amp;lt;http://www.w3.org/2001/XMLSchema&amp;gt;date"&amp;gt;
 *                 &amp;lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
 *                 &amp;lt;attribute name="datatype" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
 *               &amp;lt;/extension&amp;gt;
 *             &amp;lt;/simpleContent&amp;gt;
 *           &amp;lt;/complexType&amp;gt;
 *         &amp;lt;/element&amp;gt;
 *         &amp;lt;element name="Uvod" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="Sadrzaj"&amp;gt;
 *           &amp;lt;complexType&amp;gt;
 *             &amp;lt;complexContent&amp;gt;
 *               &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *                 &amp;lt;sequence&amp;gt;
 *                   &amp;lt;element ref="{http://www.ftn.uns.ac.rs/resenje}Resenje"/&amp;gt;
 *                   &amp;lt;element ref="{http://www.ftn.uns.ac.rs/resenje}Obrazlozenje"/&amp;gt;
 *                 &amp;lt;/sequence&amp;gt;
 *               &amp;lt;/restriction&amp;gt;
 *             &amp;lt;/complexContent&amp;gt;
 *           &amp;lt;/complexType&amp;gt;
 *         &amp;lt;/element&amp;gt;
 *         &amp;lt;element ref="{http://www.ftn.uns.ac.rs/resenje}Poverenik"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *       &amp;lt;attribute name="naslov"&amp;gt;
 *         &amp;lt;simpleType&amp;gt;
 *           &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
 *             &amp;lt;maxLength value="50"/&amp;gt;
 *           &amp;lt;/restriction&amp;gt;
 *         &amp;lt;/simpleType&amp;gt;
 *       &amp;lt;/attribute&amp;gt;
 *       &amp;lt;attribute name="broj"&amp;gt;
 *         &amp;lt;simpleType&amp;gt;
 *           &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
 *             &amp;lt;pattern value="[0-9]{3}-[0-9]{2}-[0-9]{4}/[0-9]{4}-[0-9]{2}"/&amp;gt;
 *           &amp;lt;/restriction&amp;gt;
 *         &amp;lt;/simpleType&amp;gt;
 *       &amp;lt;/attribute&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "datum",
    "uvod",
    "sadrzaj",
    "poverenik"
})
@XmlRootElement(name = "Resenje_obrazac")
public class ResenjeObrazac {

    @XmlElement(name = "Datum", required = true)
    protected ResenjeObrazac.Datum datum;
    @XmlElement(name = "Uvod", required = true)
    protected String uvod;
    @XmlElement(name = "Sadrzaj", required = true)
    protected ResenjeObrazac.Sadrzaj sadrzaj;
    @XmlElement(name = "Poverenik", required = true)
    protected Poverenik poverenik;
    @XmlAttribute(name = "naslov")
    protected String naslov;
    @XmlAttribute(name = "broj")
    protected String broj;
    @XmlAttribute(name = "id")
    protected String id;
    @XmlAttribute(name = "idZalbe")
    protected String idZalbe;

    /**
     * Gets the value of the datum property.
     * 
     * @return
     *     possible object is
     *     {@link ResenjeObrazac.Datum }
     *     
     */
    public ResenjeObrazac.Datum getDatum() {
        return datum;
    }

    /**
     * Sets the value of the datum property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResenjeObrazac.Datum }
     *     
     */
    public void setDatum(ResenjeObrazac.Datum value) {
        this.datum = value;
    }

    /**
     * Gets the value of the uvod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUvod() {
        return uvod;
    }

    /**
     * Sets the value of the uvod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUvod(String value) {
        this.uvod = value;
    }

    /**
     * Gets the value of the sadrzaj property.
     * 
     * @return
     *     possible object is
     *     {@link ResenjeObrazac.Sadrzaj }
     *     
     */
    public ResenjeObrazac.Sadrzaj getSadrzaj() {
        return sadrzaj;
    }

    /**
     * Sets the value of the sadrzaj property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResenjeObrazac.Sadrzaj }
     *     
     */
    public void setSadrzaj(ResenjeObrazac.Sadrzaj value) {
        this.sadrzaj = value;
    }

    /**
     * Gets the value of the poverenik property.
     * 
     * @return
     *     possible object is
     *     {@link Poverenik }
     *     
     */
    public Poverenik getPoverenik() {
        return poverenik;
    }

    /**
     * Sets the value of the poverenik property.
     * 
     * @param value
     *     allowed object is
     *     {@link Poverenik }
     *     
     */
    public void setPoverenik(Poverenik value) {
        this.poverenik = value;
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
     * Gets the value of the broj property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBroj() {
        return broj;
    }

    /**
     * Sets the value of the broj property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBroj(String value) {
        this.broj = value;
    }

        /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the idZalbe property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdZalbe() {
        return idZalbe;
    }

    /**
     * Sets the value of the idZalbe property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdZalbe(String value) {
        this.idZalbe = value;
    }


    /**
     * &lt;p&gt;Java class for anonymous complex type.
     * 
     * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
     * 
     * &lt;pre&gt;
     * &amp;lt;complexType&amp;gt;
     *   &amp;lt;simpleContent&amp;gt;
     *     &amp;lt;extension base="&amp;lt;http://www.w3.org/2001/XMLSchema&amp;gt;date"&amp;gt;
     *       &amp;lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
     *       &amp;lt;attribute name="datatype" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
     *     &amp;lt;/extension&amp;gt;
     *   &amp;lt;/simpleContent&amp;gt;
     * &amp;lt;/complexType&amp;gt;
     * &lt;/pre&gt;
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class Datum {

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
     * &lt;p&gt;Java class for anonymous complex type.
     * 
     * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
     * 
     * &lt;pre&gt;
     * &amp;lt;complexType&amp;gt;
     *   &amp;lt;complexContent&amp;gt;
     *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
     *       &amp;lt;sequence&amp;gt;
     *         &amp;lt;element ref="{http://www.ftn.uns.ac.rs/resenje}Resenje"/&amp;gt;
     *         &amp;lt;element ref="{http://www.ftn.uns.ac.rs/resenje}Obrazlozenje"/&amp;gt;
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
        "resenje",
        "obrazlozenje"
    })
    public static class Sadrzaj {

        @XmlElement(name = "Resenje", required = true)
        protected Resenje resenje;
        @XmlElement(name = "Obrazlozenje", required = true)
        protected Obrazlozenje obrazlozenje;

        /**
         * Gets the value of the resenje property.
         * 
         * @return
         *     possible object is
         *     {@link Resenje }
         *     
         */
        public Resenje getResenje() {
            return resenje;
        }

        /**
         * Sets the value of the resenje property.
         * 
         * @param value
         *     allowed object is
         *     {@link Resenje }
         *     
         */
        public void setResenje(Resenje value) {
            this.resenje = value;
        }

        /**
         * Gets the value of the obrazlozenje property.
         * 
         * @return
         *     possible object is
         *     {@link Obrazlozenje }
         *     
         */
        public Obrazlozenje getObrazlozenje() {
            return obrazlozenje;
        }

        /**
         * Sets the value of the obrazlozenje property.
         * 
         * @param value
         *     allowed object is
         *     {@link Obrazlozenje }
         *     
         */
        public void setObrazlozenje(Obrazlozenje value) {
            this.obrazlozenje = value;
        }

    }

}
