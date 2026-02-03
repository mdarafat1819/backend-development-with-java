package com.example.stms_multi_user.services;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.stms_multi_user.dto.AuthResponse;
import com.example.stms_multi_user.dto.UserRegistrationRequest;
import com.example.stms_multi_user.dto.VerifyOtpRequest;
import com.example.stms_multi_user.entities.User;
import com.example.stms_multi_user.repositories.UserRepository;
import com.example.stms_multi_user.security.JwtUtil;

import jakarta.transaction.Transactional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final EmailOtpService emailOtpService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public UserService(UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            AuthenticationManager authenticationManager,
            EmailOtpService emailOtpService,
            JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.emailOtpService = emailOtpService;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    public void register(UserRegistrationRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("User already exist with this email");
        }

        User user = new User();

        user.setEmail(request.getEmail());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole("PENDING");

        userRepository.save(user);

        emailOtpService.generateAndSendOtp(request.getEmail());
    }

    public AuthResponse login(String email, String password) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password));
        String token = jwtUtil.generateToken(email);

        return new AuthResponse(true, "Login Successfully", token);
    }

    @Transactional
    public void verifyEmailAndActiveUser(VerifyOtpRequest request) {

        User user = userRepository.findByEmail(request.getEmail()).orElseThrow(
                () -> new RuntimeException("User not found with email: " + request.getEmail()));

        boolean status = false;
        status = emailOtpService.validateOtp(request.getEmail(), request.getOtp());

        if (status) {
            user.setRole("USER");
            userRepository.save(user);
            emailOtpService.deleteOtp(request.getEmail());
        } else {
            throw new RuntimeException("Invalid OTP for email: " + request.getEmail());
        }
    }

}
