package org.example.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class fishNotFoundException extends RuntimeException {

    public fishNotFoundException(String message) {
        super(message);
    }
}