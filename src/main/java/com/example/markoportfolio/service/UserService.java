package com.example.markoportfolio.service;

import com.example.markoportfolio.dto.LoginRequest;
import com.example.markoportfolio.dto.RegisterRequest;
import com.example.markoportfolio.dto.UserResponse;
import com.example.markoportfolio.model.User;
import com.example.markoportfolio.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final CustomUserDetailsService customUserDetailsService;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JwtService jwtService, CustomUserDetailsService customUserDetailsService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.customUserDetailsService = customUserDetailsService;
    }

    public Map<String, String> register(RegisterRequest registerRequest) {
        User user = userRepository.save(
                User.builder()
                        .username(registerRequest.getUsername())
                        .password(passwordEncoder.encode(registerRequest.getPassword()))
                        .roles(Set.of("ADMIN"))
                        .build()
        );

       Authentication authentication = authenticationManager.authenticate(
               new UsernamePasswordAuthenticationToken(
                       registerRequest.getUsername(),
                       registerRequest.getPassword()
        )
       );

       UserDetails userDetails = (UserDetails) authentication.getPrincipal();
       String token = jwtService.generateToken(userDetails);

        return Map.of(
                "token", token,
                "username", userDetails.getUsername()
        );
    }

    public Map<String, String> login(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String token = jwtService.generateToken(userDetails);
        return Map.of("token", token, "username", userDetails.getUsername());
    }
}
