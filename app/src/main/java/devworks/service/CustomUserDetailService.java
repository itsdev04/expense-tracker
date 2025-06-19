package devworks.service;

import devworks.entity.UserInfo;
import devworks.entity.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomUserDetailService extends UserInfo implements UserDetails {

    private String username;

    private String password;

    public CustomUserDetailService(UserInfo byUsername){
        this.username = byUsername.getUsername();
        this.password = byUsername.getPassword();
        List<GrantedAuthority> auths = new ArrayList<>();

        for(UserRole role: byUsername.getRoles()){
            auths.add(new SimpleGrantedAuthority(role.getRoleName().toUpperCase()));
        }
        this.authorities = auths;
    }


    Collection<? extends GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
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
