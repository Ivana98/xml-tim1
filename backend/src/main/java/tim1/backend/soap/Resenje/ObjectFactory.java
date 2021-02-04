
package tim1.backend.soap.Resenje;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the rs.ac.uns.ftn.resenje package. 
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

    private final static QName _ResenjePasus_QNAME = new QName("http://www.ftn.uns.ac.rs/resenje", "Pasus");
    private final static QName _ObrazlozenjeSadrzajObrazlozenja_QNAME = new QName("http://www.ftn.uns.ac.rs/resenje", "Sadrzaj_obrazlozenja");
    private final static QName _ObrazlozenjeSadrzajObrazlozenjaCena_QNAME = new QName("http://www.ftn.uns.ac.rs/resenje", "Cena");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: rs.ac.uns.ftn.resenje
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ResenjeObrazac }
     * 
     */
    public ResenjeObrazac createResenjeObrazac() {
        return new ResenjeObrazac();
    }

    /**
     * Create an instance of {@link Poverenik }
     * 
     */
    public Poverenik createPoverenik() {
        return new Poverenik();
    }

    /**
     * Create an instance of {@link Obrazlozenje }
     * 
     */
    public Obrazlozenje createObrazlozenje() {
        return new Obrazlozenje();
    }

    /**
     * Create an instance of {@link ResenjeObrazac.Datum }
     * 
     */
    public ResenjeObrazac.Datum createResenjeObrazacDatum() {
        return new ResenjeObrazac.Datum();
    }

    /**
     * Create an instance of {@link ResenjeObrazac.Sadrzaj }
     * 
     */
    public ResenjeObrazac.Sadrzaj createResenjeObrazacSadrzaj() {
        return new ResenjeObrazac.Sadrzaj();
    }

    /**
     * Create an instance of {@link Poverenik.Ime }
     * 
     */
    public Poverenik.Ime createPoverenikIme() {
        return new Poverenik.Ime();
    }

    /**
     * Create an instance of {@link Poverenik.Prezime }
     * 
     */
    public Poverenik.Prezime createPoverenikPrezime() {
        return new Poverenik.Prezime();
    }

    /**
     * Create an instance of {@link Resenje }
     * 
     */
    public Resenje createResenje() {
        return new Resenje();
    }

    /**
     * Create an instance of {@link Obrazlozenje.SadrzajObrazlozenja }
     * 
     */
    public Obrazlozenje.SadrzajObrazlozenja createObrazlozenjeSadrzajObrazlozenja() {
        return new Obrazlozenje.SadrzajObrazlozenja();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/resenje", name = "Pasus", scope = Resenje.class)
    public JAXBElement<String> createResenjePasus(String value) {
        return new JAXBElement<String>(_ResenjePasus_QNAME, String.class, Resenje.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Obrazlozenje.SadrzajObrazlozenja }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/resenje", name = "Sadrzaj_obrazlozenja", scope = Obrazlozenje.class)
    public JAXBElement<Obrazlozenje.SadrzajObrazlozenja> createObrazlozenjeSadrzajObrazlozenja(Obrazlozenje.SadrzajObrazlozenja value) {
        return new JAXBElement<Obrazlozenje.SadrzajObrazlozenja>(_ObrazlozenjeSadrzajObrazlozenja_QNAME, Obrazlozenje.SadrzajObrazlozenja.class, Obrazlozenje.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/resenje", name = "Cena", scope = Obrazlozenje.SadrzajObrazlozenja.class)
    public JAXBElement<Double> createObrazlozenjeSadrzajObrazlozenjaCena(Double value) {
        return new JAXBElement<Double>(_ObrazlozenjeSadrzajObrazlozenjaCena_QNAME, Double.class, Obrazlozenje.SadrzajObrazlozenja.class, value);
    }

}
