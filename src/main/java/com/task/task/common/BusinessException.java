package com.task.task.common;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class BusinessException extends RuntimeException{
    public BusinessException(String message) {
        super(message);
    }
}
