package com.springboot.jwtpractice.controller;


import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {


    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");

        if ("user".equals(username) && "password".equals(password)) {
            return "Login successful!";
        } else {
            return "Invalid credentials!";
        }
    }

    @GetMapping("/secure")
    public String secureEndpoint() {
        return "Access to secure endpoint granted!";
    }

    @GetMapping("/public")
    public String publicEndpoint() {
        return "This is a public endpoint.";
    }
}

