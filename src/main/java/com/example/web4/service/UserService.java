package com.example.web4.service;

import com.example.web4.jwt.JwtTokenProvider;
import com.example.web4.model.User;
import com.example.web4.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public ResponseEntity<?> registration (String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            user = User.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .build();
            userRepository.save(user);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    public ResponseEntity<?> authorization (String username, String password) {
        User user = userRepository.findByUsername(username);
        String accessToken = jwtTokenProvider.createToken(username, 600000);
       // String refreshToken = jwtTokenProvider.createToken(username, 1200000);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        if (passwordEncoder.matches(password,user.getPassword())) {
            return new ResponseEntity<>(accessToken, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}