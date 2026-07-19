/*package com.journal.demojournal.Security;

import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.journal.demojournal.services.UsersDetailsService;


@Component
public class AuthProviderImpl implements AuthenticationProvider{

   


    private final UsersDetailsService usersDetailsService;

    @Autowired
     public AuthProviderImpl(UsersDetailsService usersDetailsService) {
        this.usersDetailsService = usersDetailsService;}

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        //throw new UnsupportedOperationException("Not supported yet.");
        String userName = authentication.getName();

        UserDetails usersDetails = usersDetailsService.loadUserByUsername(userName);

        String password = authentication.getCredentials().toString();
        
      if  (!password.equals(usersDetails.getPassword())){
        throw new BadCredentialsException("Incorrect Password");
      }
        
        return new UsernamePasswordAuthenticationToken(usersDetails, password, 
            Collections.emptyList());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        //throw new UnsupportedOperationException("Not supported yet.");
        return true;
    }
    
}*/
