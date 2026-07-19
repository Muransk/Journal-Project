package com.journal.demojournal.Controllers;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.journal.demojournal.Security.UsersDetails;



@RestController
@RequestMapping("/api/auth")
public class UserController {
    

    @GetMapping("/usersInfo")
    public String showUserInfo(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UsersDetails usersDetails = (UsersDetails)authentication.getPrincipal();
        System.out.println(usersDetails.getUser());
        return "Hello!";
    }
    @PostMapping("/login")
    public String login() {
        return "Login successful";
    }
    
}
