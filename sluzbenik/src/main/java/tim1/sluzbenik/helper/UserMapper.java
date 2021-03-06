package tim1.sluzbenik.helper;


import tim1.sluzbenik.dto.UserDTO;
import tim1.sluzbenik.model.korisnici.*;

public class UserMapper implements MapperInterface<Korisnik, UserDTO> {

    @Override
    public Korisnik toEntity(UserDTO dto) {

        Korisnik korisnik = new Korisnik();

        korisnik.setKorisnickoIme(dto.getKorisnickoIme());
        korisnik.setSifra(dto.getSifra());

        return korisnik;
    }

    @Override
    public UserDTO toDto(Korisnik entity) {

        return new UserDTO(entity.getKorisnickoIme(), entity.getSifra());
    }
}
