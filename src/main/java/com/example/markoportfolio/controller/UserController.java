package com.example.markoportfolio.controller;

import com.example.markoportfolio.dto.LoginRequest;
import com.example.markoportfolio.dto.RegisterRequest;
import com.example.markoportfolio.dto.UserResponse;
import com.example.markoportfolio.repository.UserRepository;
import com.example.markoportfolio.service.JwtService;
import com.example.markoportfolio.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/api/auth")
public class UserController {

    private final UserService userService;
    private final JwtService jwtService;

    public UserController(UserService userService, JwtService jwtService) {
        this.userService = userService;
        this.jwtService = jwtService;
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register(@RequestBody RegisterRequest registerRequest) {
        return ResponseEntity
                .status(201)
                .body(userService.register(registerRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity
                .status(200)
                .body(userService.login(loginRequest));
    }
}
