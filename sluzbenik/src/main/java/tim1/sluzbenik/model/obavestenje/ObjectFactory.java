//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.01.30 at 06:46:47 PM CET 
//


package tim1.sluzbenik.model.obavestenje;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the tim1.sluzbenik.model.obavestenje2 package. 
 * &lt;p&gt;An ObjectFactory allows you to programatically 
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

    private final static QName _Dostavljeno_QNAME = new QName("http://www.ftn.uns.ac.rs/obavestenjecir", "Dostavljeno");
    private final static QName _ParagrafGodina_QNAME = new QName("http://www.ftn.uns.ac.rs/obavestenjecir", "Godina");
    private final static QName _ParagrafOpisInformacije_QNAME = new QName("http://www.ftn.uns.ac.rs/obavestenjecir", "Opis_informacije");
    private final static QName _ParagrafDatumUvida_QNAME = new QName("http://www.ftn.uns.ac.rs/obavestenjecir", "Datum_uvida");
    private final static QName _ParagrafVremeUvida_QNAME = new QName("http://www.ftn.uns.ac.rs/obavestenjecir", "Vreme_uvida");
    private final static QName _ParagrafPocetakCas_QNAME = new QName("http://www.ftn.uns.ac.rs/obavestenjecir", "Pocetak_cas");
    private final static QName _ParagrafKrajCas_QNAME = new QName("http://www.ftn.uns.ac.rs/obavestenjecir", "Kraj_cas");
    private final static QName _ParagrafGradOrgana_QNAME = new QName("http://www.ftn.uns.ac.rs/obavestenjecir", "Grad_organa");
    private final static QName _ParagrafUlicaOrgana_QNAME = new QName("http://www.ftn.uns.ac.rs/obavestenjecir", "Ulica_organa");
    private final static QName _ParagrafBrojOrgana_QNAME = new QName("http://www.ftn.uns.ac.rs/obavestenjecir", "Broj_organa");
    private final static QName _ParagrafBrojKancelarije_QNAME = new QName("http://www.ftn.uns.ac.rs/obavestenjecir", "Broj_kancelarije");
    private final static QName _ParagrafIznosTroskova_QNAME = new QName("http://www.ftn.uns.ac.rs/obavestenjecir", "Iznos_troskova");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: tim1.sluzbenik.model.obavestenje2
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Obavestenje }
     * 
     */
    public Obavestenje createObavestenje() {
        return new Obavestenje();
    }

    /**
     * Create an instance of {@link Organ }
     * 
     */
    public Organ createOrgan() {
        return new Organ();
    }

    /**
     * Create an instance of {@link PodnosiocZahteva }
     * 
     */
    public PodnosiocZahteva createPodnosiocZahteva() {
        return new PodnosiocZahteva();
    }

    /**
     * Create an instance of {@link Select }
     * 
     */
    public Select createSelect() {
        return new Select();
    }

    /**
     * Create an instance of {@link Obavestenje.OsnovniPodaci }
     * 
     */
    public Obavestenje.OsnovniPodaci createObavestenjeOsnovniPodaci() {
        return new Obavestenje.OsnovniPodaci();
    }

    /**
     * Create an instance of {@link Obavestenje.Sadrzaj }
     * 
     */
    public Obavestenje.Sadrzaj createObavestenjeSadrzaj() {
        return new Obavestenje.Sadrzaj();
    }

    /**
     * Create an instance of {@link Organ.Naziv }
     * 
     */
    public Organ.Naziv createOrganNaziv() {
        return new Organ.Naziv();
    }

    /**
     * Create an instance of {@link Organ.Sediste }
     * 
     */
    public Organ.Sediste createOrganSediste() {
        return new Organ.Sediste();
    }

    /**
     * Create an instance of {@link PodnosiocZahteva.Ime }
     * 
     */
    public PodnosiocZahteva.Ime createPodnosiocZahtevaIme() {
        return new PodnosiocZahteva.Ime();
    }

    /**
     * Create an instance of {@link PodnosiocZahteva.Prezime }
     * 
     */
    public PodnosiocZahteva.Prezime createPodnosiocZahtevaPrezime() {
        return new PodnosiocZahteva.Prezime();
    }

    /**
     * Create an instance of {@link PodnosiocZahteva.Adresa }
     * 
     */
    public PodnosiocZahteva.Adresa createPodnosiocZahtevaAdresa() {
        return new PodnosiocZahteva.Adresa();
    }

    /**
     * Create an instance of {@link Paragraf }
     * 
     */
    public Paragraf createParagraf() {
        return new Paragraf();
    }

    /**
     * Create an instance of {@link Select.Primer }
     * 
     */
    public Select.Primer createSelectPrimer() {
        return new Select.Primer();
    }

    /**
     * Create an instance of {@link Obavestenje.OsnovniPodaci.Datum }
     * 
     */
    public Obavestenje.OsnovniPodaci.Datum createObavestenjeOsnovniPodaciDatum() {
        return new Obavestenje.OsnovniPodaci.Datum();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Select }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Select }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/obavestenjecir", name = "Dostavljeno")
    public JAXBElement<Select> createDostavljeno(Select value) {
        return new JAXBElement<Select>(_Dostavljeno_QNAME, Select.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/obavestenjecir", name = "Godina", scope = Paragraf.class)
    public JAXBElement<XMLGregorianCalendar> createParagrafGodina(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_ParagrafGodina_QNAME, XMLGregorianCalendar.class, Paragraf.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/obavestenjecir", name = "Opis_informacije", scope = Paragraf.class)
    public JAXBElement<String> createParagrafOpisInformacije(String value) {
        return new JAXBElement<String>(_ParagrafOpisInformacije_QNAME, String.class, Paragraf.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/obavestenjecir", name = "Datum_uvida", scope = Paragraf.class)
    public JAXBElement<XMLGregorianCalendar> createParagrafDatumUvida(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_ParagrafDatumUvida_QNAME, XMLGregorianCalendar.class, Paragraf.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/obavestenjecir", name = "Vreme_uvida", scope = Paragraf.class)
    public JAXBElement<XMLGregorianCalendar> createParagrafVremeUvida(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_ParagrafVremeUvida_QNAME, XMLGregorianCalendar.class, Paragraf.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/obavestenjecir", name = "Pocetak_cas", scope = Paragraf.class)
    public JAXBElement<XMLGregorianCalendar> createParagrafPocetakCas(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_ParagrafPocetakCas_QNAME, XMLGregorianCalendar.class, Paragraf.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/obavestenjecir", name = "Kraj_cas", scope = Paragraf.class)
    public JAXBElement<XMLGregorianCalendar> createParagrafKrajCas(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_ParagrafKrajCas_QNAME, XMLGregorianCalendar.class, Paragraf.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/obavestenjecir", name = "Grad_organa", scope = Paragraf.class)
    public JAXBElement<String> createParagrafGradOrgana(String value) {
        return new JAXBElement<String>(_ParagrafGradOrgana_QNAME, String.class, Paragraf.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/obavestenjecir", name = "Ulica_organa", scope = Paragraf.class)
    public JAXBElement<String> createParagrafUlicaOrgana(String value) {
        return new JAXBElement<String>(_ParagrafUlicaOrgana_QNAME, String.class, Paragraf.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/obavestenjecir", name = "Broj_organa", scope = Paragraf.class)
    public JAXBElement<String> createParagrafBrojOrgana(String value) {
        return new JAXBElement<String>(_ParagrafBrojOrgana_QNAME, String.class, Paragraf.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/obavestenjecir", name = "Broj_kancelarije", scope = Paragraf.class)
    public JAXBElement<String> createParagrafBrojKancelarije(String value) {
        return new JAXBElement<String>(_ParagrafBrojKancelarije_QNAME, String.class, Paragraf.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Double }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/obavestenjecir", name = "Iznos_troskova", scope = Paragraf.class)
    public JAXBElement<Double> createParagrafIznosTroskova(Double value) {
        return new JAXBElement<Double>(_ParagrafIznosTroskova_QNAME, Double.class, Paragraf.class, value);
    }

}
