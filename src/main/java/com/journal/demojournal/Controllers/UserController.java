package com.journal.demojournal.Controllers;


import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.journal.demojournal.Models.User;
import com.journal.demojournal.Security.UsersDetails;
import com.journal.demojournal.dto.UserDTO;
import com.journal.demojournal.services.UsersService;
import com.journal.demojournal.util.UserErrorResponse;
import com.journal.demojournal.util.UserNotAuthenticatedException;
import com.journal.demojournal.util.UserNotCreatedException;
import com.journal.demojournal.util.UserNotFoundException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;





@RestController
@RequestMapping("/api/auth")
public class UserController {


    private final UsersService usersService;
    private final ModelMapper modelMapper;


    public UserController(UsersService usersService, ModelMapper modelMapper){
        this.usersService = usersService;
        this.modelMapper = modelMapper;
    }
    

    @GetMapping("/usersInfo")
    public List<UserDTO> showUserInfo(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UsersDetails usersDetails = (UsersDetails)authentication.getPrincipal();
        System.out.println(usersDetails.getUser());
        return usersService.findAll().stream().map(this::convertToUserDTO).collect(Collectors.toList());
    }

    @GetMapping("/usersInfo/{id}")
    public UserDTO showOneUserInfo(@PathVariable("id") int id){

        return  convertToUserDTO(usersService.findOne(id));
    }
   
    

    @PostMapping("/login")
    public String login() {
        return "Login successful";
    }
    
    @PostMapping("/registration")

    public ResponseEntity<HttpStatus> registration(@RequestBody @Valid UserDTO userDTO, BindingResult bindingResult){
        

         if (bindingResult.hasErrors()){
            StringBuilder errorMessage = new StringBuilder();

            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors){
                errorMessage.append(error.getField()).append(" - ")
                .append(error.getDefaultMessage())
                .append(" ; ");
            }
            throw new UserNotCreatedException(errorMessage.toString());
        }

        usersService.save(convertToUser(userDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }


     @PatchMapping("/{id}")
     public ResponseEntity<HttpStatus> updateUserData(@RequestBody @Valid UserDTO userDTO, BindingResult bindingResult, @PathVariable("id") int id){
        

         if (bindingResult.hasErrors()){
            StringBuilder errorMessage = new StringBuilder();

            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors){
                errorMessage.append(error.getField()).append(" - ")
                .append(error.getDefaultMessage())
                .append(" ; ");
            }
            throw new UserNotFoundException(errorMessage.toString());
        }

        usersService.update(id, convertToUser(userDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }


     @PostMapping("/logout")
    public String logout(HttpServletRequest request,
                                         HttpServletResponse response,
                                         Authentication authentication) {

        if (authentication == null || !authentication.isAuthenticated()) {
    throw new UserNotAuthenticatedException("User not authorized");
}
        

        new SecurityContextLogoutHandler()
                .logout(request, response, authentication);

       // return ResponseEntity.ok("You succecfully log out system");
       return "You succecfully log out system";
    }


    @DeleteMapping("/{id}")
     public ResponseEntity<HttpStatus> deleteUser(@RequestBody @Valid UserDTO userDTO, BindingResult bindingResult, @PathVariable("id") int id){
        

         if (bindingResult.hasErrors()){
            StringBuilder errorMessage = new StringBuilder();

            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors){
                errorMessage.append(error.getField()).append(" - ")
                .append(error.getDefaultMessage())
                .append(" ; ");
            }
            throw new UserNotFoundException(errorMessage.toString());
        }

        usersService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }


    @ExceptionHandler
    public ResponseEntity<UserErrorResponse> handleException(UserNotAuthenticatedException e){

          UserErrorResponse response =  new UserErrorResponse(e.getMessage(), 
        System.currentTimeMillis());
        
        
        
        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }      

    @ExceptionHandler
    public ResponseEntity<UserErrorResponse> handleException(UserNotFoundException e){

        UserErrorResponse response =  new UserErrorResponse("User not found!", 
        System.currentTimeMillis());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);//404

    }

     @ExceptionHandler
    public ResponseEntity<UserErrorResponse> handleException(UserNotCreatedException e){

        UserErrorResponse response =  new UserErrorResponse(e.getMessage(), 
        System.currentTimeMillis());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);//400
    }

     private User convertToUser (UserDTO userDTO){
        

        User user = modelMapper.map(userDTO, User.class);


        return user;
    }


    private UserDTO convertToUserDTO(User user){

        return modelMapper.map(user, UserDTO.class);
    }
   
    
}
