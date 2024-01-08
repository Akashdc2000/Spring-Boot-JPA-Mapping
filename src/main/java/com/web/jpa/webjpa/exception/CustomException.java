package com.web.jpa.webjpa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

public class CustomException extends RuntimeException {
    public CustomException() {
        super();
    }

    public CustomException(HttpClientErrorException e) {
        super(e);
    }

    public CustomException(HttpStatus status, String message) {
        super(new HttpClientErrorException(status, message));
    }
}
