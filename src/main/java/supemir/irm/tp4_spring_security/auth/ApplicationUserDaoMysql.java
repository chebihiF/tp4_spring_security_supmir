package supemir.irm.tp4_spring_security.auth;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Repository;
import supemir.irm.tp4_spring_security.user.Authority;
import supemir.irm.tp4_spring_security.user.AuthorityRepository;
import supemir.irm.tp4_spring_security.user.User;
import supemir.irm.tp4_spring_security.user.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class ApplicationUserDaoMysql implements ApplicationUserDao{

    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;

    public ApplicationUserDaoMysql(UserRepository userRepository, AuthorityRepository authorityRepository) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
    }

    @Override
    public ApplicationUser getUserByUsername(String username) {
        User user = userRepository.findById(username).get();
        List<Authority> authorities = authorityRepository.findAuthoritiesByUsersIn(List.of(user));
        Set<SimpleGrantedAuthority> grantedAuthorities = authorities
                .stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getName()))
                .collect(Collectors.toSet());

        ApplicationUser applicationUser = new ApplicationUser(
                grantedAuthorities,
                user.getPassword(),
                user.getUsername(),
                true,
                true,
                true,
                true
        );
        return applicationUser;
    }
}
