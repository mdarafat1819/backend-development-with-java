package com.example.task_management_system.security;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.example.task_management_system.dto.AuthResponse;
import com.example.task_management_system.entities.User;
import com.example.task_management_system.exceptions.ErrorResponse;
import com.example.task_management_system.repositories.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class OAuth2SuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    private final UserRepository userRepo;
    private final JwtUtil jwtService;
    private final ObjectMapper mapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {
        try {
            OAuth2AuthenticationToken token = (OAuth2AuthenticationToken) authentication;

            DefaultOAuth2User defaultOAuth2User = (DefaultOAuth2User) token.getPrincipal();

            Map<String, Object> attributes = defaultOAuth2User.getAttributes();
            String email = attributes.get("email").toString();

            User user = userRepo.findByEmail(email).orElse(null);

            if (user == null) { 
                User newUser = User
                        .builder() // have to add @Builder in UserEntity
                        .email(email)
                        .firstName(attributes.get("given_name").toString())
                        .lastName(attributes.get("family_name").toString())
                        .joinedAt(LocalDateTime.now())
                        .password("$2a$12$nPbC026M6m2IAOnJ32IiDOvghs.kEHVJgpQQhuhGPIgD6vvWjqY1e")
                        .role("USER")
                        .build();
                user = userRepo.save(newUser); 
            }

            String accessToken = jwtService.generateAccessToken(user.getUsername());
            String refreshToken = jwtService.generateRefreshToken(user.getUsername());

            Cookie cookie = new Cookie("refreshToken", refreshToken);
            cookie.setHttpOnly(true); // always add
            response.addCookie(cookie);

            AuthResponse authResponse = new AuthResponse(true, "Logged in successfully.", new AuthResponse.Token(accessToken, refreshToken));
            String json = mapper.writeValueAsString(authResponse);

            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().write(json);

        } catch (Exception ex) {

            ErrorResponse error = new ErrorResponse(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Internal Server Error",
                    ex.getMessage(),
                    request.getRequestURI());

            String json = mapper.writeValueAsString(error);
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write(json);
        }
    }
}
