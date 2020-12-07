//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1-b171012.0423 
//         See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
//         Any modifications to this file will be lost upon recompilation of the source schema. 
//         Generated on: 2020.12.07 at 10:50:09 PM CET 
//


package tim1.backend.model.zalbaodluka;

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
    private final static QName _ZalbaPodnaslov_QNAME = new QName("http://www.ftn.uns.ac.rs/zalba-na-odluku", "podnaslov");
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
     * Create an instance of {@link Napomene }
     * 
     */
    public Napomene createNapomene() {
        return new Napomene();
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
     * Create an instance of {@link Adresa }
     * 
     */
    public Adresa createAdresa() {
        return new Adresa();
    }

    /**
     * Create an instance of {@link Zalba }
     * 
     */
    public Zalba createZalba() {
        return new Zalba();
    }

    /**
     * Create an instance of {@link Zalilac }
     * 
     */
    public Zalilac createZalilac() {
        return new Zalilac();
    }

    /**
     * Create an instance of {@link Sadrzaj }
     * 
     */
    public Sadrzaj createSadrzaj() {
        return new Sadrzaj();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/zalba-na-odluku", name = "datum", scope = Sadrzaj.class)
    public JAXBElement<XMLGregorianCalendar> createSadrzajDatum(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_SadrzajDatum_QNAME, XMLGregorianCalendar.class, Sadrzaj.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/zalba-na-odluku", name = "deo_odluke", scope = Sadrzaj.class)
    public JAXBElement<String> createSadrzajDeoOdluke(String value) {
        return new JAXBElement<String>(_SadrzajDeoOdluke_QNAME, String.class, Sadrzaj.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/zalba-na-odluku", name = "zakon", scope = Sadrzaj.class)
    public JAXBElement<String> createSadrzajZakon(String value) {
        return new JAXBElement<String>(_SadrzajZakon_QNAME, String.class, Sadrzaj.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/zalba-na-odluku", name = "podnaslov", scope = Zalba.class)
    public JAXBElement<String> createZalbaPodnaslov(String value) {
        return new JAXBElement<String>(_ZalbaPodnaslov_QNAME, String.class, Zalba.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/zalba-na-odluku", name = "naziv_organa", scope = Zalba.class)
    public JAXBElement<String> createZalbaNazivOrgana(String value) {
        return new JAXBElement<String>(_ZalbaNazivOrgana_QNAME, String.class, Zalba.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/zalba-na-odluku", name = "broj_zahteva", scope = Zalba.class)
    public JAXBElement<Integer> createZalbaBrojZahteva(Integer value) {
        return new JAXBElement<Integer>(_ZalbaBrojZahteva_QNAME, Integer.class, Zalba.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/zalba-na-odluku", name = "godina", scope = Zalba.class)
    public JAXBElement<XMLGregorianCalendar> createZalbaGodina(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_ZalbaGodina_QNAME, XMLGregorianCalendar.class, Zalba.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Napomene.Napomena }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Napomene.Napomena }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/zalba-na-odluku", name = "napomena", scope = Napomene.class)
    public JAXBElement<Napomene.Napomena> createNapomeneNapomena(Napomene.Napomena value) {
        return new JAXBElement<Napomene.Napomena>(_NapomeneNapomena_QNAME, Napomene.Napomena.class, Napomene.class, value);
    }

}
