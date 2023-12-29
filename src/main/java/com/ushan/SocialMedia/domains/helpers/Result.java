package com.ushan.SocialMedia.domains.helpers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
public class Result {
    private boolean flag;
    private HttpStatus httpStatus;
    private String message;
    private Object data;

    public Result(boolean flag, HttpStatus httpStatus, String message) {
        this.flag = flag;
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public Result(boolean flag, HttpStatus httpStatus, String message, Object data) {
        this.flag = flag;
        this.httpStatus = httpStatus;
        this.message = message;
        this.data = data;
    }
}
