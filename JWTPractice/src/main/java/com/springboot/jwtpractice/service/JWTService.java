package com.springboot.jwtpractice.service;


import com.springboot.jwtpractice.repository.UserRepository;
import com.springboot.jwtpractice.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JWTService {

    public final JwtUtil jwtUtil;

    private AuthenticationManager authManager;

    private UserDetailsService userDetailsService;

    public String authenticate(String username, String password) {
        authManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        return jwtUtil.generateToken(userDetails.getUsername());
    }


}
