
package tim1.backend.soap.ZalbaNaOdluku;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the rs.ac.uns.ftn.zalba_na_odluku package. 
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

    private final static QName _SadrzajDatum_QNAME = new QName("http://www.ftn.uns.ac.rs/zalba-na-odluku", "datum");
    private final static QName _SadrzajDeoOdluke_QNAME = new QName("http://www.ftn.uns.ac.rs/zalba-na-odluku", "deo_odluke");
    private final static QName _SadrzajZakon_QNAME = new QName("http://www.ftn.uns.ac.rs/zalba-na-odluku", "zakon");
    private final static QName _ZalbaZalilac_QNAME = new QName("http://www.ftn.uns.ac.rs/zalba-na-odluku", "zalilac");
    private final static QName _ZalbaNazivOrgana_QNAME = new QName("http://www.ftn.uns.ac.rs/zalba-na-odluku", "naziv_organa");
    private final static QName _ZalbaBrojZahteva_QNAME = new QName("http://www.ftn.uns.ac.rs/zalba-na-odluku", "broj_zahteva");
    private final static QName _ZalbaGodina_QNAME = new QName("http://www.ftn.uns.ac.rs/zalba-na-odluku", "godina");
    private final static QName _NapomeneNapomena_QNAME = new QName("http://www.ftn.uns.ac.rs/zalba-na-odluku", "napomena");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: rs.ac.uns.ftn.zalba_na_odluku
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Adresa }
     * 
     */
    public Adresa createAdresa() {
        return new Adresa();
    }

    /**
     * Create an instance of {@link Podnosilac }
     * 
     */
    public Podnosilac createPodnosilac() {
        return new Podnosilac();
    }

    /**
     * Create an instance of {@link VremeIMesto }
     * 
     */
    public VremeIMesto createVremeIMesto() {
        return new VremeIMesto();
    }

    /**
     * Create an instance of {@link Napomene }
     * 
     */
    public Napomene createNapomene() {
        return new Napomene();
    }

    /**
     * Create an instance of {@link TPravnoLice }
     * 
     */
    public TPravnoLice createTPravnoLice() {
        return new TPravnoLice();
    }

    /**
     * Create an instance of {@link TFizickoLice }
     * 
     */
    public TFizickoLice createTFizickoLice() {
        return new TFizickoLice();
    }

    /**
     * Create an instance of {@link ZalbaNaOdluku }
     * 
     */
    public ZalbaNaOdluku createZalbaNaOdluku() {
        return new ZalbaNaOdluku();
    }

    /**
     * Create an instance of {@link PodaciOPovereniku }
     * 
     */
    public PodaciOPovereniku createPodaciOPovereniku() {
        return new PodaciOPovereniku();
    }

    /**
     * Create an instance of {@link Adresa.Grad }
     * 
     */
    public Adresa.Grad createAdresaGrad() {
        return new Adresa.Grad();
    }

    /**
     * Create an instance of {@link Adresa.Ulica }
     * 
     */
    public Adresa.Ulica createAdresaUlica() {
        return new Adresa.Ulica();
    }

    /**
     * Create an instance of {@link Zalba }
     * 
     */
    public Zalba createZalba() {
        return new Zalba();
    }

    /**
     * Create an instance of {@link Sadrzaj }
     * 
     */
    public Sadrzaj createSadrzaj() {
        return new Sadrzaj();
    }

    /**
     * Create an instance of {@link Podnosilac.Ime }
     * 
     */
    public Podnosilac.Ime createPodnosilacIme() {
        return new Podnosilac.Ime();
    }

    /**
     * Create an instance of {@link Podnosilac.Prezime }
     * 
     */
    public Podnosilac.Prezime createPodnosilacPrezime() {
        return new Podnosilac.Prezime();
    }

    /**
     * Create an instance of {@link VremeIMesto.Grad }
     * 
     */
    public VremeIMesto.Grad createVremeIMestoGrad() {
        return new VremeIMesto.Grad();
    }

    /**
     * Create an instance of {@link VremeIMesto.Datum }
     * 
     */
    public VremeIMesto.Datum createVremeIMestoDatum() {
        return new VremeIMesto.Datum();
    }

    /**
     * Create an instance of {@link Napomene.Napomena }
     * 
     */
    public Napomene.Napomena createNapomeneNapomena() {
        return new Napomene.Napomena();
    }

    /**
     * Create an instance of {@link Zahtev }
     * 
     */
    public Zahtev createZahtev() {
        return new Zahtev();
    }

    /**
     * Create an instance of {@link TLice.Sediste }
     * 
     */
    public TLice.Sediste createTLiceSediste() {
        return new TLice.Sediste();
    }

    /**
     * Create an instance of {@link TPravnoLice.Naziv }
     * 
     */
    public TPravnoLice.Naziv createTPravnoLiceNaziv() {
        return new TPravnoLice.Naziv();
    }

    /**
     * Create an instance of {@link TFizickoLice.Ime }
     * 
     */
    public TFizickoLice.Ime createTFizickoLiceIme() {
        return new TFizickoLice.Ime();
    }

    /**
     * Create an instance of {@link TFizickoLice.Prezime }
     * 
     */
    public TFizickoLice.Prezime createTFizickoLicePrezime() {
        return new TFizickoLice.Prezime();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/zalba-na-odluku", name = "datum", scope = Sadrzaj.class)
    public JAXBElement<XMLGregorianCalendar> createSadrzajDatum(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_SadrzajDatum_QNAME, XMLGregorianCalendar.class, Sadrzaj.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/zalba-na-odluku", name = "deo_odluke", scope = Sadrzaj.class)
    public JAXBElement<String> createSadrzajDeoOdluke(String value) {
        return new JAXBElement<String>(_SadrzajDeoOdluke_QNAME, String.class, Sadrzaj.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/zalba-na-odluku", name = "zakon", scope = Sadrzaj.class)
    public JAXBElement<String> createSadrzajZakon(String value) {
        return new JAXBElement<String>(_SadrzajZakon_QNAME, String.class, Sadrzaj.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TLice }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/zalba-na-odluku", name = "zalilac", scope = Zalba.class)
    public JAXBElement<TLice> createZalbaZalilac(TLice value) {
        return new JAXBElement<TLice>(_ZalbaZalilac_QNAME, TLice.class, Zalba.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/zalba-na-odluku", name = "naziv_organa", scope = Zalba.class)
    public JAXBElement<String> createZalbaNazivOrgana(String value) {
        return new JAXBElement<String>(_ZalbaNazivOrgana_QNAME, String.class, Zalba.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/zalba-na-odluku", name = "broj_zahteva", scope = Zalba.class)
    public JAXBElement<Integer> createZalbaBrojZahteva(Integer value) {
        return new JAXBElement<Integer>(_ZalbaBrojZahteva_QNAME, Integer.class, Zalba.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/zalba-na-odluku", name = "godina", scope = Zalba.class)
    public JAXBElement<XMLGregorianCalendar> createZalbaGodina(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_ZalbaGodina_QNAME, XMLGregorianCalendar.class, Zalba.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Napomene.Napomena }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/zalba-na-odluku", name = "napomena", scope = Napomene.class)
    public JAXBElement<Napomene.Napomena> createNapomeneNapomena(Napomene.Napomena value) {
        return new JAXBElement<Napomene.Napomena>(_NapomeneNapomena_QNAME, Napomene.Napomena.class, Napomene.class, value);
    }

}
