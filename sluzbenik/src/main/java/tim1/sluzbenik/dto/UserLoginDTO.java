package tim1.sluzbenik.dto;

// DTO za login
public class UserLoginDTO {

    private String korisnickoIme;
    private String sifra;

    public UserLoginDTO() {}

    public UserLoginDTO(String korisnickoIme, String sifra) {
        this.korisnickoIme = korisnickoIme;
        this.sifra = sifra;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String email) {
        this.korisnickoIme = email;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }
}
