package com.journal.demojournal.util;

public class UserNotFoundException extends  RuntimeException {
    
     public UserNotFoundException(String message) {
       super(message);
    }

     public UserNotFoundException(){}//чтобы сервис работал!
}
