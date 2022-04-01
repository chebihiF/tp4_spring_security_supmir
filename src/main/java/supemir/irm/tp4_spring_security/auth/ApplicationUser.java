package supemir.irm.tp4_spring_security.auth;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class ApplicationUser implements UserDetails {

    private final Collection<? extends GrantedAuthority> authorities;
    private final String password ;
    private final String username ;
    private final boolean accountNonExpired;
    private final boolean accountNonLocked;
    private final boolean credentialsNonExpired;
    private final boolean enable;

    public ApplicationUser(Collection<? extends GrantedAuthority> authorities, String password, String username) {
        this.authorities = authorities;
        this.password = password;
        this.username = username;
        accountNonExpired = true;
        accountNonLocked = true;
        credentialsNonExpired = true;
        enable = true;

    }

    public ApplicationUser(Collection<? extends GrantedAuthority> authorities, String password, String username, boolean accountNonExpired, boolean accountNonLocked, boolean credentialsNonExpired, boolean enable) {
        this.authorities = authorities;
        this.password = password;
        this.username = username;
        this.accountNonExpired = accountNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.credentialsNonExpired = credentialsNonExpired;
        this.enable = enable;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
