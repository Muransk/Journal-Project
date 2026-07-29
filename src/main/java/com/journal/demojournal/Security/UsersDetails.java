package com.journal.demojournal.Security;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.journal.demojournal.Models.User;

public class UsersDetails implements UserDetails
{

    private final User user;  

    public UsersDetails ( User user){this.user = user;}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //throw new UnsupportedOperationException("Not supported yet.");
        return Collections.emptyList(); //раньше было нулл
    }

    @Override
    public String getPassword() {
        //throw new UnsupportedOperationException("Not supported yet.");
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        //throw new UnsupportedOperationException("Not supported yet.");
        return this.user.getUserName();    
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    // Чтобы получить данные аутентифицированных пользователей
    public User getUser(){return this.user;}

 
}
