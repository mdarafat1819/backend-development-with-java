package com.example.stms_multi_user.exceptions;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(String email) {
        super("Email \'" +email+ "\' is already registered.");
    }
}
