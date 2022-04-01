package supemir.irm.tp4_spring_security.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity @Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Authority {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String name;
    @ManyToMany
    @JoinTable(
            name = "userAuthority",
            joinColumns = @JoinColumn(name = "id_auth"),
            inverseJoinColumns = @JoinColumn(name = "id_user")
    )
    private List<User> users;
}
