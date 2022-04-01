package supemir.irm.tp4_spring_security.auth;

import org.springframework.security.core.userdetails.UserDetails;

public interface ApplicationUserDao {
    public ApplicationUser getUserByUsername(String username);
}
