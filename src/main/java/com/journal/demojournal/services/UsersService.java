package com.journal.demojournal.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.journal.demojournal.Models.User;
import com.journal.demojournal.repositories.UserRepository;
import com.journal.demojournal.util.UserNotFoundException;

@Service
@Transactional(readOnly = true)
public class UsersService {

    private final UserRepository userRepository;

    @Autowired
    public UsersService(UserRepository userRepository){
        this.userRepository = userRepository;
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


        userRepository.save(user);
    }

    @Transactional
    public void update(int id, User updatedUser){
        updatedUser.setId(id);
        userRepository.save(updatedUser);
    }

    @Transactional
    public void delete(int id){
        userRepository.deleteById(id);
    }
}
