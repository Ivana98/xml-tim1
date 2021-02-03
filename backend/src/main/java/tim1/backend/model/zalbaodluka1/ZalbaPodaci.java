//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.02.03 at 03:37:29 PM CET 
//


package tim1.backend.model.zalbaodluka1;

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
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="zalilac" type="{http://www.ftn.uns.ac.rs/zalba-na-odluku}TLice"/>
 *         &lt;element name="naziv_organa" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="broj_zahteva" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="godina" type="{http://www.w3.org/2001/XMLSchema}gYear"/>
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/zalba-na-odluku}sadrzaj"/>
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/zalba-na-odluku}podnosilac"/>
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/zalba-na-odluku}vreme_i_mesto"/>
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
    "content"
})
@XmlRootElement(name = "zalba_podaci")
public class ZalbaPodaci {

    @XmlElementRefs({
        @XmlElementRef(name = "naziv_organa", namespace = "http://www.ftn.uns.ac.rs/zalba-na-odluku", type = JAXBElement.class),
        @XmlElementRef(name = "zalilac", namespace = "http://www.ftn.uns.ac.rs/zalba-na-odluku", type = JAXBElement.class),
        @XmlElementRef(name = "broj_zahteva", namespace = "http://www.ftn.uns.ac.rs/zalba-na-odluku", type = JAXBElement.class),
        @XmlElementRef(name = "sadrzaj", namespace = "http://www.ftn.uns.ac.rs/zalba-na-odluku", type = Sadrzaj.class),
        @XmlElementRef(name = "podnosilac", namespace = "http://www.ftn.uns.ac.rs/zalba-na-odluku", type = Podnosilac.class),
        @XmlElementRef(name = "godina", namespace = "http://www.ftn.uns.ac.rs/zalba-na-odluku", type = JAXBElement.class),
        @XmlElementRef(name = "vreme_i_mesto", namespace = "http://www.ftn.uns.ac.rs/zalba-na-odluku", type = VremeIMesto.class)
    })
    @XmlMixed
    protected List<Object> content;

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
     * {@link JAXBElement }{@code <}{@link TLice }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link Sadrzaj }
     * {@link Podnosilac }
     * {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     * {@link VremeIMesto }
     * {@link String }
     * 
     * 
     */
    public List<Object> getContent() {
        if (content == null) {
            content = new ArrayList<Object>();
        }
        return this.content;
    }

}
