package supemir.irm.tp4_spring_security.sec;

import org.hibernate.engine.internal.StatefulPersistenceContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
//                .authenticationManager()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/","/index.html","/css/**","/js/**")
                .permitAll()
                .antMatchers(HttpMethod.GET,"/customers/**").hasAuthority("customer:read")
                .antMatchers(HttpMethod.DELETE,"/customers/**").hasAuthority("customer:delete")
                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override @Bean
    protected UserDetailsService userDetailsService() {

        UserDetails user_admin = User
                .builder()
                .username("admin")
                .password(passwordEncoder.encode("admin"))
//                .roles("ADMIN")
                .authorities("customer:read","customer:write","customer:delete")
                .build();

        UserDetails user_manager = User
                .builder()
                .username("manager")
                .password(passwordEncoder.encode("1234"))
                .authorities("customer:read")
//                .roles("MANAGER")
                .build();

        return new InMemoryUserDetailsManager(
                user_admin,user_manager
        );

    }
}
