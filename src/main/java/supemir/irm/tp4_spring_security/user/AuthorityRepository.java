package supemir.irm.tp4_spring_security.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface AuthorityRepository extends JpaRepository<Authority,Long> {
    List<Authority> findAuthoritiesByUsersIn(List<User> users);
}
