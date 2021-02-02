package tim1.sluzbenik.model.korisnici;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority {

    String id;

    String name;

    @Override
    public String getAuthority() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
