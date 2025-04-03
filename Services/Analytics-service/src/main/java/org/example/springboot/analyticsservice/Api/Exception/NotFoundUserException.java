package org.example.springboot.analyticsservice.Api.Exception;

public class NotFoundUserException extends RuntimeException {
    public NotFoundUserException(String s) {
        super(s);
    }
}
