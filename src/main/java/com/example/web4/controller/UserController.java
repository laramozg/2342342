package com.example.web4.controller;

import com.example.web4.model.ResponseUser;
import com.example.web4.model.UserRequest;
import com.example.web4.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/reg")
    public ResponseUser registration(@RequestBody UserRequest userRequest) {
        return userService.registration(userRequest.getUsername(), userRequest.getPassword());
    }

    @PostMapping("/auth")
    public ResponseUser authorization(@RequestBody UserRequest userRequest) {
        return userService.authorization(userRequest.getUsername(), userRequest.getPassword());
    }


//    private void setRefreshTokenInCookies(HttpServletResponse httpServletResponse, String token) {
//        Cookie cookie = new Cookie("bearer", token);
//        cookie.setHttpOnly(true);
//        cookie.setPath("/");
//        httpServletResponse.addCookie(cookie);
//    }

//    private String getRefreshTokenFromCookies(HttpServletRequest httpServletRequest) {
//        return Arrays.stream(httpServletRequest.getCookies())
//                .filter(cookie -> cookie.getName().equals("bearer"))
//                .findFirst()
//                .orElseThrow(() -> {
//                    throw new NoTokenException("Отсутствует токен доступа!");
//                }).getValue();
//    }
//
//    private void removeRefreshTokenFromCookies(HttpServletResponse httpServletResponse) {
//        Cookie cookie = new Cookie("bearer", null);
//        cookie.setHttpOnly(true);
//        cookie.setMaxAge(0);
//        httpServletResponse.addCookie(cookie);
//    }
}