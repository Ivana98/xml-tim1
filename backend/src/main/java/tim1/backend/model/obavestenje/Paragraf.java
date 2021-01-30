//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.01.30 at 06:46:47 PM CET 
//


package tim1.backend.model.obavestenje;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlRootElement;
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
 *         &amp;lt;element name="Godina" type="{http://www.w3.org/2001/XMLSchema}gYear"/&amp;gt;
 *         &amp;lt;element name="Opis_informacije" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="Datum_uvida"&amp;gt;
 *           &amp;lt;simpleType&amp;gt;
 *             &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}date"&amp;gt;
 *             &amp;lt;/restriction&amp;gt;
 *           &amp;lt;/simpleType&amp;gt;
 *         &amp;lt;/element&amp;gt;
 *         &amp;lt;element name="Vreme_uvida" type="{http://www.w3.org/2001/XMLSchema}time"/&amp;gt;
 *         &amp;lt;element name="Pocetak_cas" type="{http://www.w3.org/2001/XMLSchema}time"/&amp;gt;
 *         &amp;lt;element name="Kraj_cas" type="{http://www.w3.org/2001/XMLSchema}time"/&amp;gt;
 *         &amp;lt;element name="Grad_organa" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="Ulica_organa" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="Broj_organa" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="Broj_kancelarije" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="Iznos_troskova"&amp;gt;
 *           &amp;lt;simpleType&amp;gt;
 *             &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}double"&amp;gt;
 *               &amp;lt;minInclusive value="0"/&amp;gt;
 *             &amp;lt;/restriction&amp;gt;
 *           &amp;lt;/simpleType&amp;gt;
 *         &amp;lt;/element&amp;gt;
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
@XmlRootElement(name = "Paragraf")
public class Paragraf {

    @XmlElementRefs({
        @XmlElementRef(name = "Godina", namespace = "http://www.ftn.uns.ac.rs/obavestenjecir", type = JAXBElement.class),
        @XmlElementRef(name = "Opis_informacije", namespace = "http://www.ftn.uns.ac.rs/obavestenjecir", type = JAXBElement.class),
        @XmlElementRef(name = "Datum_uvida", namespace = "http://www.ftn.uns.ac.rs/obavestenjecir", type = JAXBElement.class),
        @XmlElementRef(name = "Vreme_uvida", namespace = "http://www.ftn.uns.ac.rs/obavestenjecir", type = JAXBElement.class),
        @XmlElementRef(name = "Pocetak_cas", namespace = "http://www.ftn.uns.ac.rs/obavestenjecir", type = JAXBElement.class),
        @XmlElementRef(name = "Kraj_cas", namespace = "http://www.ftn.uns.ac.rs/obavestenjecir", type = JAXBElement.class),
        @XmlElementRef(name = "Grad_organa", namespace = "http://www.ftn.uns.ac.rs/obavestenjecir", type = JAXBElement.class),
        @XmlElementRef(name = "Ulica_organa", namespace = "http://www.ftn.uns.ac.rs/obavestenjecir", type = JAXBElement.class),
        @XmlElementRef(name = "Broj_organa", namespace = "http://www.ftn.uns.ac.rs/obavestenjecir", type = JAXBElement.class),
        @XmlElementRef(name = "Broj_kancelarije", namespace = "http://www.ftn.uns.ac.rs/obavestenjecir", type = JAXBElement.class),
        @XmlElementRef(name = "Iznos_troskova", namespace = "http://www.ftn.uns.ac.rs/obavestenjecir", type = JAXBElement.class)
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
     * {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     * {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     * {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     * {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Double }{@code >}
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
