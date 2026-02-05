package com.example.stms_multi_user.controllers;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.stms_multi_user.dto.AuthResponse;
import com.example.stms_multi_user.dto.LoginRequest;
import com.example.stms_multi_user.dto.UserRegistrationRequest;
import com.example.stms_multi_user.dto.VerifyOtpRequest;
import com.example.stms_multi_user.services.UserService;

@RestController
@RequestMapping("/api/auth")

public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService
    ) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> userRegistration(@RequestBody UserRegistrationRequest request) {
        userService.register(request);

        AuthResponse authResponse = userService.login(request.getEmail(), request.getPassword());
        authResponse.setMessage("An OTP has been sent to your email. Please verify it using the /api/auth/verify-user-email endpoint to activate your account");

        return ResponseEntity.ok(authResponse);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
       AuthResponse authResponse = userService.login(request.getEmail(), request.getPassword());
       return ResponseEntity.ok(authResponse);
    }

    @PostMapping("/verify-user-email")
    public ResponseEntity<?> verifyAndActiveUser(@RequestBody VerifyOtpRequest request) {
        userService.verifyEmailAndActivateUser(request);
        return ResponseEntity.ok(
            Map.of(
                "message", "Successfully Verified"
            )
        );
    }

}
