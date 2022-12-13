package com.example.web4.controller;

import com.example.web4.model.UserRequest;
import com.example.web4.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/reg")
    public ResponseEntity<?> registration(@RequestBody UserRequest userRequest) {
        return userService.registration(userRequest.getUsername(), userRequest.getPassword());
    }

    @PostMapping("/auth")
    public ResponseEntity<?> authorization(@RequestBody UserRequest userRequest) {
        return userService.authorization(userRequest.getUsername(), userRequest.getPassword());
    }

}