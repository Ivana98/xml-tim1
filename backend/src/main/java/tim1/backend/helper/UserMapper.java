package tim1.backend.helper;


import tim1.backend.dto.UserDTO;
import tim1.backend.model.korisnici.*;

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
