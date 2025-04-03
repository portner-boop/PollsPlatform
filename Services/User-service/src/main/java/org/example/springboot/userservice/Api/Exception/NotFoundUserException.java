package org.example.springboot.userservice.Api.Exception;

public class NotFoundUserException extends RuntimeException {
    public NotFoundUserException(String s) {
        super(s);
    }
}
