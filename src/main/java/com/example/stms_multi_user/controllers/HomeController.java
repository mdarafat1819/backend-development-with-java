package com.example.stms_multi_user.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.stms_multi_user.services.EmailOtpService;

@RestController
public class HomeController {
    private final EmailOtpService emailOtpService;
    public HomeController(EmailOtpService emailOtpService) {
        this.emailOtpService = emailOtpService;
    }
    @GetMapping("/")
    public String home() {
        emailOtpService.generateAndSendOtp("mdarafat1819@gmail.com");
        return "Well come to Stms_Multi_User Apps";
    }
}
