package com.ushan.SocialMedia.config;

import com.ushan.SocialMedia.security.exceptions.JwtTokenMissingException;
import com.ushan.SocialMedia.services.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private  final JwtService jwtService;
    private  final UserDetailsService userDetailsService;
    private final HandlerExceptionResolver exceptionResolver;
    @Autowired
    public JwtAuthenticationFilter(JwtService jwtService, UserDetailsService userDetailsService, @Qualifier("handlerExceptionResolver") HandlerExceptionResolver exceptionResolver) {
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
        this.exceptionResolver = exceptionResolver;
    }

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) throws ServletException, IOException {
        try{
            final String authHeader = request.getHeader("Authorization");
            final String jwt;
            final String userName;
            if (shouldSkipAuthentication(request)) {
                filterChain.doFilter(request, response);
                return;
            }
            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                throw new JwtTokenMissingException("JWT token is missing");
            }
            jwt = authHeader.substring(7);
            userName = jwtService.extractUsername(jwt);

            if(userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = this.userDetailsService.loadUserByUsername(userName);
                if(jwtService.isTokenValid(jwt, userDetails)){
                    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                            userDetails,
                            null,
                            userDetails.getAuthorities()
                    );
                    authToken.setDetails(
                            new WebAuthenticationDetailsSource().buildDetails(request)
                    );
                    SecurityContextHolder.getContext().setAuthentication(authToken);
                }
            }
            filterChain.doFilter(request, response);

        }catch (Exception ex) {
            exceptionResolver.resolveException(request,response,null,ex);
        }
    }
    private boolean shouldSkipAuthentication(HttpServletRequest request) {
        return request.getRequestURI().startsWith("/api/v1/auth/");
    }
}