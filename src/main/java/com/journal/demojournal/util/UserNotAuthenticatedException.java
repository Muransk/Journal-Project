package com.journal.demojournal.util;

public class UserNotAuthenticatedException extends  RuntimeException {

     public UserNotAuthenticatedException(String message) {
        super(message);
    }
    
}
