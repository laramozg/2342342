package com.example.web4.service;

import com.example.web4.exceptions.IncorrectUserCredentialsException;
import com.example.web4.jwt.JwtTokenProvider;
import com.example.web4.exceptions.UsernameExistException;
import com.example.web4.model.ResponseDTO;
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

    public ResponseDTO registration (String username, String password) {
        userCredentialsValidation(username,password);
        User user = User.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .build();
        if (userRepository.findById(user.getUsername()).isPresent()) {
            throw new UsernameExistException("Данное имя пользователя занято!");
        }
        userRepository.save(user);
        return new ResponseDTO(HttpStatus.CREATED.value(),"Регистрация прошла успешно" );
    }

    public ResponseDTO authorization (String username, String password) {
        User user = userRepository.findByUsername(username);
        String token = jwtTokenProvider.createToken(username);
        if (user == null) {
            throw new IncorrectUserCredentialsException("Неправильный логин или пароль!");
        }
        if (passwordEncoder.matches(password,user.getPassword())) {
            return new ResponseDTO(HttpStatus.OK.value(), token);
        } else {
            throw new IncorrectUserCredentialsException("Неправильный логин или пароль!");

        }
    }
    private void userCredentialsValidation(String username, String password) {
        if (!(password.length() <= 20 && 6 <= password.length())) {
            throw new IncorrectUserCredentialsException("Длина логина минимум 6 и максимум 20!");
        }

        if (!(username.length() <= 20 && 6 <= username.length())) {
            throw new IncorrectUserCredentialsException("Длина пароля минимум 6 и максимум 20!");
        }
    }
}