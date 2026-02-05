package com.example.stms_multi_user.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String email) {
        super("No user found with the email address `" + email + "`");
    }
}