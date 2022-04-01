package supemir.irm.tp4_spring_security.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class User {
    @Id @Column(length =20)
    private String username;
    private String password;
    private String name ;
    private String email;
    @ManyToMany(mappedBy = "users")
    private List<Authority> authorities;
}
