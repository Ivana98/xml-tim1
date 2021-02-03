
package tim1.backend.soap.ZalbaNaOdluku;

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
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="zalilac" type="{http://www.ftn.uns.ac.rs/zalba-na-odluku}TLice"/&gt;
 *         &lt;element name="naziv_organa" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="broj_zahteva" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="godina" type="{http://www.w3.org/2001/XMLSchema}gYear"/&gt;
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/zalba-na-odluku}sadrzaj"/&gt;
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/zalba-na-odluku}podnosilac"/&gt;
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/zalba-na-odluku}vreme_i_mesto"/&gt;
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
@XmlRootElement(name = "zalba")
public class Zalba {

    @XmlElementRefs({
        @XmlElementRef(name = "podnosilac", namespace = "http://www.ftn.uns.ac.rs/zalba-na-odluku", type = Podnosilac.class),
        @XmlElementRef(name = "zalilac", namespace = "http://www.ftn.uns.ac.rs/zalba-na-odluku", type = JAXBElement.class),
        @XmlElementRef(name = "godina", namespace = "http://www.ftn.uns.ac.rs/zalba-na-odluku", type = JAXBElement.class),
        @XmlElementRef(name = "naziv_organa", namespace = "http://www.ftn.uns.ac.rs/zalba-na-odluku", type = JAXBElement.class),
        @XmlElementRef(name = "broj_zahteva", namespace = "http://www.ftn.uns.ac.rs/zalba-na-odluku", type = JAXBElement.class),
        @XmlElementRef(name = "sadrzaj", namespace = "http://www.ftn.uns.ac.rs/zalba-na-odluku", type = Sadrzaj.class),
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
     * {@link Podnosilac }
     * {@link JAXBElement }{@code <}{@link TLice }{@code >}
     * {@link String }
     * {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link Sadrzaj }
     * {@link VremeIMesto }
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
