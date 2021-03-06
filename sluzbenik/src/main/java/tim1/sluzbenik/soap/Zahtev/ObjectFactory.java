
package tim1.sluzbenik.soap.Zahtev;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the rs.ac.uns.ftn.zahtev package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _OpisZahtevaDodatneInformacijeOpisDodatneInformacije_QNAME = new QName("http://www.ftn.uns.ac.rs/zahtev", "opis_dodatne_informacije");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: rs.ac.uns.ftn.zahtev
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link InfoOrgana }
     * 
     */
    public InfoOrgana createInfoOrgana() {
        return new InfoOrgana();
    }

    /**
     * Create an instance of {@link OpisZahteva }
     * 
     */
    public OpisZahteva createOpisZahteva() {
        return new OpisZahteva();
    }

    /**
     * Create an instance of {@link Zahtev }
     * 
     */
    public Zahtev createZahtev() {
        return new Zahtev();
    }

    /**
     * Create an instance of {@link Trazilac }
     * 
     */
    public Trazilac createTrazilac() {
        return new Trazilac();
    }

    /**
     * Create an instance of {@link TipZahteva }
     * 
     */
    public TipZahteva createTipZahteva() {
        return new TipZahteva();
    }

    /**
     * Create an instance of {@link InfoOrgana.Naziv }
     * 
     */
    public InfoOrgana.Naziv createInfoOrganaNaziv() {
        return new InfoOrgana.Naziv();
    }

    /**
     * Create an instance of {@link InfoOrgana.Sediste }
     * 
     */
    public InfoOrgana.Sediste createInfoOrganaSediste() {
        return new InfoOrgana.Sediste();
    }

    /**
     * Create an instance of {@link OpisZahteva.TipoviZahteva }
     * 
     */
    public OpisZahteva.TipoviZahteva createOpisZahtevaTipoviZahteva() {
        return new OpisZahteva.TipoviZahteva();
    }

    /**
     * Create an instance of {@link OpisZahteva.DodatneInformacije }
     * 
     */
    public OpisZahteva.DodatneInformacije createOpisZahtevaDodatneInformacije() {
        return new OpisZahteva.DodatneInformacije();
    }

    /**
     * Create an instance of {@link Zahtev.Mesto }
     * 
     */
    public Zahtev.Mesto createZahtevMesto() {
        return new Zahtev.Mesto();
    }

    /**
     * Create an instance of {@link Zahtev.Datum }
     * 
     */
    public Zahtev.Datum createZahtevDatum() {
        return new Zahtev.Datum();
    }

    /**
     * Create an instance of {@link Trazilac.ImeIPrezime }
     * 
     */
    public Trazilac.ImeIPrezime createTrazilacImeIPrezime() {
        return new Trazilac.ImeIPrezime();
    }

    /**
     * Create an instance of {@link Trazilac.Adresa }
     * 
     */
    public Trazilac.Adresa createTrazilacAdresa() {
        return new Trazilac.Adresa();
    }

    /**
     * Create an instance of {@link TipZahteva.NaciniSlanja }
     * 
     */
    public TipZahteva.NaciniSlanja createTipZahtevaNaciniSlanja() {
        return new TipZahteva.NaciniSlanja();
    }

    /**
     * Create an instance of {@link NacinSlanja }
     * 
     */
    public NacinSlanja createNacinSlanja() {
        return new NacinSlanja();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/zahtev", name = "opis_dodatne_informacije", scope = OpisZahteva.DodatneInformacije.class)
    public JAXBElement<String> createOpisZahtevaDodatneInformacijeOpisDodatneInformacije(String value) {
        return new JAXBElement<String>(_OpisZahtevaDodatneInformacijeOpisDodatneInformacije_QNAME, String.class, OpisZahteva.DodatneInformacije.class, value);
    }

}
