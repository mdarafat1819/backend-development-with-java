package com.example.task_management_system.services;

import java.util.Arrays;

import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.task_management_system.dto.AuthResponse;
import com.example.task_management_system.dto.UserRegistrationRequest;
import com.example.task_management_system.dto.VerifyOtpRequest;
import com.example.task_management_system.entities.TempUser;
import com.example.task_management_system.entities.User;
import com.example.task_management_system.exceptions.UserAlreadyExistsException;
import com.example.task_management_system.exceptions.UserNotFoundException;
import com.example.task_management_system.repositories.TempUserRepository;
import com.example.task_management_system.repositories.UserRepository;
import com.example.task_management_system.security.JwtUtil;
import com.example.task_management_system.services.email.EmailOtpService;

import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final TempUserRepository tempUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final EmailOtpService emailOtpService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final ModelMapper modelMapper;

    public UserService(
        TempUserRepository tempUserRepository,
        UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            AuthenticationManager authenticationManager,
            EmailOtpService emailOtpService,
            JwtUtil jwtUtil,
            ModelMapper modelMapper
        ) {
        this.tempUserRepository = tempUserRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.emailOtpService = emailOtpService;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.modelMapper = modelMapper;
    }

    public void register(UserRegistrationRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new UserAlreadyExistsException(request.getEmail());
        }

        TempUser tempUser = modelMapper.map(request, TempUser.class);
        tempUser.setPassword(passwordEncoder.encode(request.getPassword()));

        tempUserRepository.save(tempUser);
        emailOtpService.generateAndSendOtp(request.getEmail(), "USER_REGISTRATION");
    }

    public AuthResponse login(String email, String password) {

        if(userRepository.findByEmail(email).isEmpty()) {
            throw new UserNotFoundException(email);
        }

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password));

        String accessToken = jwtUtil.generateAccessToken(email);
        String refreshToken = jwtUtil.generateRefreshToken(email);

        return new AuthResponse(true, "Logged in successfully.", new AuthResponse.Token(accessToken, refreshToken));
    }

    public AuthResponse refreshToken(HttpServletRequest request) {
        String refreshToken = Arrays.stream(request.getCookies())
                .filter(cookie -> "refreshToken".equals(cookie.getName()))
                .findFirst()
                .map(cookie -> cookie.getValue())
                .orElseThrow(() -> new AuthenticationServiceException("RefreshToken not found"));
        Claims claims = jwtUtil.validateAndExtractClaims(refreshToken);

        if (!"refresh".equals(claims.get("type"))) throw new AuthenticationServiceException("The given token is not a refresh token."
        );
        
        String accessToken = jwtUtil.generateAccessToken(claims.getSubject());

        return new AuthResponse(true, "The access token has been successfully generated.", new AuthResponse.Token(accessToken, refreshToken));
    }

    @Transactional
    public void verifyEmailAndActivateUser(VerifyOtpRequest request) {

        TempUser tempUser = tempUserRepository.findByEmail(request.getEmail()).orElseThrow(
                () -> new RuntimeException("User not found with email: " + request.getEmail()));

        boolean status = false;
        status = emailOtpService.validateOtp(request.getEmail(), request.getOtp());

        if (status) {
            User user = modelMapper.map(tempUser, User.class);
            userRepository.save(user);
            emailOtpService.deleteOtp(request.getEmail());
            tempUserRepository.delete(tempUser);
        } else {
            throw new RuntimeException("Invalid OTP for email `" + request.getEmail() + "`");
        }
    }

}
