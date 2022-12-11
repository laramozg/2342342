package com.example.web4.jwt;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

public class WebFilter extends OncePerRequestFilter {
    private final JwtTokenProvider jwtTokenProvider;

    public WebFilter(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        String accessToken = jwtTokenProvider.resolveAccessToken(httpServletRequest);
        String refreshToken = jwtTokenProvider.resolveRefreshToken(httpServletRequest);
        try {
            if ((accessToken != null && jwtTokenProvider.validateToken(accessToken)) || (refreshToken != null && jwtTokenProvider.validateToken(refreshToken))) {
                Authentication authentication = new UsernamePasswordAuthenticationToken(jwtTokenProvider.getUsername(accessToken),"", Collections.singleton((GrantedAuthority) () -> "USER"));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (JwtAuthenticationException e) {
            throw new RuntimeException(e);
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}


