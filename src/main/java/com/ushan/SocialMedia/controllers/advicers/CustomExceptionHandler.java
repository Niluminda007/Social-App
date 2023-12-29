package com.ushan.SocialMedia.controllers.advicers;

import com.ushan.SocialMedia.domains.helpers.Result;
import com.ushan.SocialMedia.security.exceptions.JwtTokenMissingException;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.security.SignatureException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.nio.file.AccessDeniedException;


@RestControllerAdvice
@Slf4j
public class CustomExceptionHandler {

    @ExceptionHandler({UsernameNotFoundException.class, BadCredentialsException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    Result handleAuthenticationException(Exception ex){
        return new Result(false, HttpStatus.UNAUTHORIZED, ex.getMessage(), "Authentication Failure");
    }
    @ExceptionHandler(JwtTokenMissingException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    Result handleJwtTokenMissingException(JwtTokenMissingException ex) {
        return new Result(false, HttpStatus.UNAUTHORIZED, ex.getMessage(), "JWT token is missing.");
    }
    @ExceptionHandler(InsufficientAuthenticationException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    Result handleInsufficientAuthenticationException(Exception ex){
        return new Result(false , HttpStatus.UNAUTHORIZED, ex.getMessage(), "Login credentials are missing.");
    }

    @ExceptionHandler(SignatureException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    Result handleInvalidBearerTokenException(Exception ex){
        return new Result(false, HttpStatus.UNAUTHORIZED, ex.getMessage(), "JWT Signature not valid!!!!");
    }
    @ExceptionHandler(MalformedJwtException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    Result handleMalformedTokenException(Exception ex){
        return new Result(false, HttpStatus.UNAUTHORIZED, ex.getMessage(), "JWT Signature is not malformed!!!!");
    }
    @ExceptionHandler(ExpiredJwtException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    Result handleExpiredTokenException(Exception ex){
        return new Result(false, HttpStatus.UNAUTHORIZED, ex.getMessage(), "JWT token already expired");
    }

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    Result handleUnAuthorizedException(Exception ex){
        return new Result(false, HttpStatus.FORBIDDEN, ex.getMessage(), "You are not Authorized to access the content!!!");
    }

    @ExceptionHandler(NoResourceFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    Result handleAccessDeniedException(Exception ex) {
        return new Result(false, HttpStatus.NOT_FOUND, ex.getMessage(), "The resource or the endpoint you are looking for doesn't exist");
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    Result handleOtherException(Exception ex) {
        log.error("An unexpected error occurred", ex);
        return new Result(false, HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), "A server internal error occurs.");
    }


}
