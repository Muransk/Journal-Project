package com.journal.demojournal.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.journal.demojournal.Models.User;
import com.journal.demojournal.repositories.UserRepository;
import com.journal.demojournal.util.UserNotFoundException;

@Service
@Transactional(readOnly = true)
public class UsersService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UsersService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }    


    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findOne(int id){
        Optional<User> foundUser = userRepository.findById(id); 
        
        return foundUser.orElseThrow(UserNotFoundException::new);
    }
    

   
    
    @Transactional
    public void save(User user){

       user.setPassword(passwordEncoder.encode( user.getPassword()));


        userRepository.save(user);
    }

    @Transactional
    public void update(int id, User updatedUser){
        
        User user = findOne(id);
       
        //updatedUser.setId(id);

        user.setUserName(updatedUser.getUserName());
        //userRepository.save(updatedUser);
    }


    @Transactional
    public void changePassword(int id, String newPassword){
        User user = findOne(id);

        user.setPassword(passwordEncoder.encode(newPassword));
    }

    @Transactional
    public void delete(int id){
        userRepository.deleteById(id);
    }
}
