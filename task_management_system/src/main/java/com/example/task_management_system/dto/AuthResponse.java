package com.example.task_management_system.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class AuthResponse {
    private boolean success;
    private String message;
    private Token token;

    public AuthResponse(boolean success, String message, Token token) {
        this.success = success;
        this.message = message;
        this.token = token;
    }

    @Getter
    @Setter
    public static class Token {
        private final String accessToken;
        private final String refreshToken;
        public Token(String accessToken, String refreshToken) {
            this.accessToken = accessToken;
            this.refreshToken = refreshToken;
        }
    }
}
