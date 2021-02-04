
package tim1.backend.soap.ZalbaNaCutanje;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the rs.ac.uns.ftn.zalba_na_cutanje package. 
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

    private final static QName _ZalbaNaCutanjeSadrzajNazivOrgana_QNAME = new QName("http://www.ftn.uns.ac.rs/zalba-na-cutanje", "Naziv_organa");
    private final static QName _ZalbaNaCutanjeSadrzajRazloziZalbe_QNAME = new QName("http://www.ftn.uns.ac.rs/zalba-na-cutanje", "Razlozi_zalbe");
    private final static QName _ZalbaNaCutanjeSadrzajDatumPodnosenjaZahteva_QNAME = new QName("http://www.ftn.uns.ac.rs/zalba-na-cutanje", "Datum_podnosenja_zahteva");
    private final static QName _ZalbaNaCutanjeSadrzajPodaciOZahtevu_QNAME = new QName("http://www.ftn.uns.ac.rs/zalba-na-cutanje", "Podaci_o_zahtevu");
    private final static QName _ZalbaNaCutanjeSadrzajPasus_QNAME = new QName("http://www.ftn.uns.ac.rs/zalba-na-cutanje", "Pasus");
    private final static QName _ZalbaNaCutanjeSadrzajNapomena_QNAME = new QName("http://www.ftn.uns.ac.rs/zalba-na-cutanje", "Napomena");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: rs.ac.uns.ftn.zalba_na_cutanje
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ZalbaNaCutanje }
     * 
     */
    public ZalbaNaCutanje createZalbaNaCutanje() {
        return new ZalbaNaCutanje();
    }

    /**
     * Create an instance of {@link PodnosilacZalbe }
     * 
     */
    public PodnosilacZalbe createPodnosilacZalbe() {
        return new PodnosilacZalbe();
    }

    /**
     * Create an instance of {@link Select }
     * 
     */
    public Select createSelect() {
        return new Select();
    }

    /**
     * Create an instance of {@link ZalbaNaCutanje.Sadrzaj }
     * 
     */
    public ZalbaNaCutanje.Sadrzaj createZalbaNaCutanjeSadrzaj() {
        return new ZalbaNaCutanje.Sadrzaj();
    }

    /**
     * Create an instance of {@link ZalbaNaCutanje.AdresaZaPostu }
     * 
     */
    public ZalbaNaCutanje.AdresaZaPostu createZalbaNaCutanjeAdresaZaPostu() {
        return new ZalbaNaCutanje.AdresaZaPostu();
    }

    /**
     * Create an instance of {@link PodnosilacZalbe.Ime }
     * 
     */
    public PodnosilacZalbe.Ime createPodnosilacZalbeIme() {
        return new PodnosilacZalbe.Ime();
    }

    /**
     * Create an instance of {@link PodnosilacZalbe.Prezime }
     * 
     */
    public PodnosilacZalbe.Prezime createPodnosilacZalbePrezime() {
        return new PodnosilacZalbe.Prezime();
    }

    /**
     * Create an instance of {@link PodnosilacZalbe.Adresa }
     * 
     */
    public PodnosilacZalbe.Adresa createPodnosilacZalbeAdresa() {
        return new PodnosilacZalbe.Adresa();
    }

    /**
     * Create an instance of {@link PodnosilacZalbe.KontaktPodaci }
     * 
     */
    public PodnosilacZalbe.KontaktPodaci createPodnosilacZalbeKontaktPodaci() {
        return new PodnosilacZalbe.KontaktPodaci();
    }

    /**
     * Create an instance of {@link ZalbaNaCutanje.VremeIMesto }
     * 
     */
    public ZalbaNaCutanje.VremeIMesto createZalbaNaCutanjeVremeIMesto() {
        return new ZalbaNaCutanje.VremeIMesto();
    }

    /**
     * Create an instance of {@link Select.Option }
     * 
     */
    public Select.Option createSelectOption() {
        return new Select.Option();
    }

    /**
     * Create an instance of {@link ZalbaNaCutanje.Sadrzaj.RazloziZalbe }
     * 
     */
    public ZalbaNaCutanje.Sadrzaj.RazloziZalbe createZalbaNaCutanjeSadrzajRazloziZalbe() {
        return new ZalbaNaCutanje.Sadrzaj.RazloziZalbe();
    }

    /**
     * Create an instance of {@link ZalbaNaCutanje.Sadrzaj.DatumPodnosenjaZahteva }
     * 
     */
    public ZalbaNaCutanje.Sadrzaj.DatumPodnosenjaZahteva createZalbaNaCutanjeSadrzajDatumPodnosenjaZahteva() {
        return new ZalbaNaCutanje.Sadrzaj.DatumPodnosenjaZahteva();
    }

    /**
     * Create an instance of {@link ZalbaNaCutanje.AdresaZaPostu.Mesto }
     * 
     */
    public ZalbaNaCutanje.AdresaZaPostu.Mesto createZalbaNaCutanjeAdresaZaPostuMesto() {
        return new ZalbaNaCutanje.AdresaZaPostu.Mesto();
    }

    /**
     * Create an instance of {@link ZalbaNaCutanje.AdresaZaPostu.Ulica }
     * 
     */
    public ZalbaNaCutanje.AdresaZaPostu.Ulica createZalbaNaCutanjeAdresaZaPostuUlica() {
        return new ZalbaNaCutanje.AdresaZaPostu.Ulica();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/zalba-na-cutanje", name = "Naziv_organa", scope = ZalbaNaCutanje.Sadrzaj.class)
    public JAXBElement<String> createZalbaNaCutanjeSadrzajNazivOrgana(String value) {
        return new JAXBElement<String>(_ZalbaNaCutanjeSadrzajNazivOrgana_QNAME, String.class, ZalbaNaCutanje.Sadrzaj.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ZalbaNaCutanje.Sadrzaj.RazloziZalbe }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/zalba-na-cutanje", name = "Razlozi_zalbe", scope = ZalbaNaCutanje.Sadrzaj.class)
    public JAXBElement<ZalbaNaCutanje.Sadrzaj.RazloziZalbe> createZalbaNaCutanjeSadrzajRazloziZalbe(ZalbaNaCutanje.Sadrzaj.RazloziZalbe value) {
        return new JAXBElement<ZalbaNaCutanje.Sadrzaj.RazloziZalbe>(_ZalbaNaCutanjeSadrzajRazloziZalbe_QNAME, ZalbaNaCutanje.Sadrzaj.RazloziZalbe.class, ZalbaNaCutanje.Sadrzaj.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ZalbaNaCutanje.Sadrzaj.DatumPodnosenjaZahteva }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/zalba-na-cutanje", name = "Datum_podnosenja_zahteva", scope = ZalbaNaCutanje.Sadrzaj.class)
    public JAXBElement<ZalbaNaCutanje.Sadrzaj.DatumPodnosenjaZahteva> createZalbaNaCutanjeSadrzajDatumPodnosenjaZahteva(ZalbaNaCutanje.Sadrzaj.DatumPodnosenjaZahteva value) {
        return new JAXBElement<ZalbaNaCutanje.Sadrzaj.DatumPodnosenjaZahteva>(_ZalbaNaCutanjeSadrzajDatumPodnosenjaZahteva_QNAME, ZalbaNaCutanje.Sadrzaj.DatumPodnosenjaZahteva.class, ZalbaNaCutanje.Sadrzaj.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/zalba-na-cutanje", name = "Podaci_o_zahtevu", scope = ZalbaNaCutanje.Sadrzaj.class)
    public JAXBElement<String> createZalbaNaCutanjeSadrzajPodaciOZahtevu(String value) {
        return new JAXBElement<String>(_ZalbaNaCutanjeSadrzajPodaciOZahtevu_QNAME, String.class, ZalbaNaCutanje.Sadrzaj.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/zalba-na-cutanje", name = "Pasus", scope = ZalbaNaCutanje.Sadrzaj.class)
    public JAXBElement<String> createZalbaNaCutanjeSadrzajPasus(String value) {
        return new JAXBElement<String>(_ZalbaNaCutanjeSadrzajPasus_QNAME, String.class, ZalbaNaCutanje.Sadrzaj.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/zalba-na-cutanje", name = "Napomena", scope = ZalbaNaCutanje.Sadrzaj.class)
    public JAXBElement<String> createZalbaNaCutanjeSadrzajNapomena(String value) {
        return new JAXBElement<String>(_ZalbaNaCutanjeSadrzajNapomena_QNAME, String.class, ZalbaNaCutanje.Sadrzaj.class, value);
    }

}
