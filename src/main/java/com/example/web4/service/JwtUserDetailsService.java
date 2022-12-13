package com.example.web4.service;

import com.example.web4.exceptions.IncorrectUserCredentialsException;
import com.example.web4.model.User;
import com.example.web4.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.util.Optional;
@RequiredArgsConstructor
@Component
public class JwtUserDetailsService implements UserDetailsService {

    private final UserRepository usersRepository;
    @Override
    public UserDetails loadUserByUsername(String username) {
        Optional<User> userOptional = usersRepository.findById(username);

        if (!userOptional.isPresent()) {
            throw new IncorrectUserCredentialsException("Данный пользователь не найден! (не передавай елки-палки токен)");
        }
        return usersRepository.findById(username).get();
    }
}