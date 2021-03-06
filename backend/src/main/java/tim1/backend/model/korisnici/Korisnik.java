//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1-b171012.0423 
//         See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
//         Any modifications to this file will be lost upon recompilation of the source schema. 
//         Generated on: 2021.01.22 at 08:27:50 PM CET 
//


package tim1.backend.model.korisnici;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * <p>
 * Java class for anonymous complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="korisnicko_ime" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="sifra" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ime" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="prezime" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="uloga" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "korisnickoIme", "sifra", "ime", "prezime", "uloga" })
@XmlRootElement(name = "korisnik")
public class Korisnik implements UserDetails {

    @XmlElement(name = "korisnicko_ime", required = true)
    protected String korisnickoIme;
    @XmlElement(required = true)
    protected String sifra;
    @XmlElement(required = true)
    protected String ime;
    @XmlElement(required = true)
    protected String prezime;
    @XmlElement(required = true)
    protected String uloga;

    /**
     * Gets the value of the korisnickoIme property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    /**
     * Sets the value of the korisnickoIme property.
     * 
     * @param value allowed object is {@link String }
     * 
     */
    public void setKorisnickoIme(String value) {
        this.korisnickoIme = value;
    }

    /**
     * Gets the value of the sifra property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getSifra() {
        return sifra;
    }

    /**
     * Sets the value of the sifra property.
     * 
     * @param value allowed object is {@link String }
     * 
     */
    public void setSifra(String value) {
        this.sifra = value;
    }

    /**
     * Gets the value of the ime property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getIme() {
        return ime;
    }

    /**
     * Sets the value of the ime property.
     * 
     * @param value allowed object is {@link String }
     * 
     */
    public void setIme(String value) {
        this.ime = value;
    }

    /**
     * Gets the value of the prezime property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getPrezime() {
        return prezime;
    }

    /**
     * Sets the value of the prezime property.
     * 
     * @param value allowed object is {@link String }
     * 
     */
    public void setPrezime(String value) {
        this.prezime = value;
    }

    /**
     * Gets the value of the uloga property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getUloga() {
        return uloga;
    }

    /**
     * Sets the value of the uloga property.
     * 
     * @param value allowed object is {@link String }
     * 
     */
    public void setUloga(String value) {
        this.uloga = value;
    }

    @Override
    public String toString() {
        return "{" + " korisnickoIme='" + getKorisnickoIme() + "'" + ", sifra='" + getSifra() + "'" + ", ime='"
                + getIme() + "'" + ", prezime='" + getPrezime() + "'" + ", uloga='" + getUloga() + "'" + "}";
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        List<Authority> auths = new ArrayList();

        Authority auth = new Authority();
        auth.setId(UUID.randomUUID().toString());
        auth.setName(this.uloga);
        
        auths.add(auth);
        return auths;
    }

    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return this.sifra;
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return this.korisnickoIme;
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }

}
