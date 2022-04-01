package supemir.irm.tp4_spring_security.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
public class AuthConfig {

    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthConfig(UserRepository userRepository, AuthorityRepository authorityRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    CommandLineRunner initUser(){
        return args -> {
            User user = userRepository.save(new User("admin",passwordEncoder.encode("admin"),"mohamed","mohamed@gmail.com",null));
            Authority authority_read = authorityRepository.save(new Authority(null,"customer:read",null));
            Authority authority_write = authorityRepository.save(new Authority(null,"customer:write",null));
            Authority authority_delete = authorityRepository.save(new Authority(null,"customer:delete",null));
            user.setAuthorities(List.of(authority_read,authority_write,authority_delete));
            userRepository.save(user);
        };
    }
}
