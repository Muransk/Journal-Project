package com.journal.demojournal.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.journal.demojournal.Models.User;
import com.journal.demojournal.Security.UsersDetails;
import com.journal.demojournal.repositories.UserRepository;

@Service
public class UsersDetailsService implements UserDetailsService {
    

    private final UserRepository userRepository;

    @Autowired
    public UsersDetailsService(UserRepository userRepository){this.userRepository = userRepository;}

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //throw new UnsupportedOperationException("Not supported yet.");
       Optional<User> user=  userRepository.findByUserName(username);

       if(user.isEmpty()){//здесь раньше было !user.ispresent()
        throw new UsernameNotFoundException("User not found");
       }
       return new UsersDetails(user.get());
    }
}
 