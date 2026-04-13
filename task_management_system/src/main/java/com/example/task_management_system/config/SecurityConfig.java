package com.example.task_management_system.config;

import com.example.task_management_system.security.CustomAuthEntryPoint;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.task_management_system.security.JwtAuthenticationFilter;
import com.example.task_management_system.security.OAuth2SuccessHandler;
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final CustomAuthEntryPoint customAuthEntryPoint;
    private final OAuth2SuccessHandler oAuth2SuccessHandler;
    SecurityConfig(CustomAuthEntryPoint customAuthEntryPoint, OAuth2SuccessHandler oAuth2SuccessHandler) {
        this.customAuthEntryPoint = customAuthEntryPoint;
        this.oAuth2SuccessHandler = oAuth2SuccessHandler;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, 
        JwtAuthenticationFilter jwtAuthenticationFilter
    ) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .sessionManagement(session ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )
            .exceptionHandling(ex -> ex.authenticationEntryPoint(customAuthEntryPoint))
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/", "/api/auth/register","/api/auth/verify-user-email","/api/auth/login", "/api/auth/refresh-token",
                        "/swagger-ui/**", "/v3/api-docs/**", "/oauth2/authorization/google").permitAll()
                .anyRequest().permitAll()
            )
            .oauth2Login(oauthConfig -> oauthConfig
                .failureUrl("/login?error=true")
                .successHandler(oAuth2SuccessHandler)
            )
             .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
