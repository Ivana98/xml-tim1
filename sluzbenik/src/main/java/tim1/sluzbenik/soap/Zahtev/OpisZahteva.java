
package tim1.sluzbenik.soap.Zahtev;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlMixed;
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
 *         &lt;element name="tekst_zahteva" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="tipovi_zahteva"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{http://www.ftn.uns.ac.rs/zahtev}tip_zahteva" maxOccurs="unbounded"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="dodatne_informacije"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="opis_dodatne_informacije" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
    "tekstZahteva",
    "tipoviZahteva",
    "dodatneInformacije"
})
@XmlRootElement(name = "opis_zahteva")
public class OpisZahteva {

    @XmlElement(name = "tekst_zahteva", required = true)
    protected String tekstZahteva;
    @XmlElement(name = "tipovi_zahteva", required = true)
    protected OpisZahteva.TipoviZahteva tipoviZahteva;
    @XmlElement(name = "dodatne_informacije", required = true)
    protected OpisZahteva.DodatneInformacije dodatneInformacije;

    /**
     * Gets the value of the tekstZahteva property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTekstZahteva() {
        return tekstZahteva;
    }

    /**
     * Sets the value of the tekstZahteva property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTekstZahteva(String value) {
        this.tekstZahteva = value;
    }

    /**
     * Gets the value of the tipoviZahteva property.
     * 
     * @return
     *     possible object is
     *     {@link OpisZahteva.TipoviZahteva }
     *     
     */
    public OpisZahteva.TipoviZahteva getTipoviZahteva() {
        return tipoviZahteva;
    }

    /**
     * Sets the value of the tipoviZahteva property.
     * 
     * @param value
     *     allowed object is
     *     {@link OpisZahteva.TipoviZahteva }
     *     
     */
    public void setTipoviZahteva(OpisZahteva.TipoviZahteva value) {
        this.tipoviZahteva = value;
    }

    /**
     * Gets the value of the dodatneInformacije property.
     * 
     * @return
     *     possible object is
     *     {@link OpisZahteva.DodatneInformacije }
     *     
     */
    public OpisZahteva.DodatneInformacije getDodatneInformacije() {
        return dodatneInformacije;
    }

    /**
     * Sets the value of the dodatneInformacije property.
     * 
     * @param value
     *     allowed object is
     *     {@link OpisZahteva.DodatneInformacije }
     *     
     */
    public void setDodatneInformacije(OpisZahteva.DodatneInformacije value) {
        this.dodatneInformacije = value;
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
     *         &lt;element name="opis_dodatne_informacije" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
        "content"
    })
    public static class DodatneInformacije {

        @XmlElementRef(name = "opis_dodatne_informacije", namespace = "http://www.ftn.uns.ac.rs/zahtev", type = JAXBElement.class)
        @XmlMixed
        protected List<Serializable> content;

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
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element ref="{http://www.ftn.uns.ac.rs/zahtev}tip_zahteva" maxOccurs="unbounded"/&gt;
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
        "tipZahteva"
    })
    public static class TipoviZahteva {

        @XmlElement(name = "tip_zahteva", required = true)
        protected List<TipZahteva> tipZahteva;

        /**
         * Gets the value of the tipZahteva property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the tipZahteva property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getTipZahteva().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link TipZahteva }
         * 
         * 
         */
        public List<TipZahteva> getTipZahteva() {
            if (tipZahteva == null) {
                tipZahteva = new ArrayList<TipZahteva>();
            }
            return this.tipZahteva;
        }

    }

}
