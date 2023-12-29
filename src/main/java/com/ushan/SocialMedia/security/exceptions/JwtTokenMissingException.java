package com.ushan.SocialMedia.security.exceptions;

public class JwtTokenMissingException extends RuntimeException{
    public JwtTokenMissingException(String message) {
        super(message);
    }
}
