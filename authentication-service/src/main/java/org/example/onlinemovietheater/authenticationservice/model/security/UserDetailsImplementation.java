package org.example.onlinemovietheater.authenticationservice.model.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UserDetailsImplementation implements UserDetails {
    private String email;
    private String password;
    private List<String> role;

    public UserDetailsImplementation(String email, String password, List<String> role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public UserDetailsImplementation() {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role
                .stream()
                .map(SimpleGrantedAuthority::new)
                .toList();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }
}
