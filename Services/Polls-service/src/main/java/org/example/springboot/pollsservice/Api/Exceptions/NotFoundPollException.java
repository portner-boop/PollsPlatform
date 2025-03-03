package org.example.springboot.pollsservice.Api.Exceptions;

public class NotFoundPollException extends RuntimeException {
    public NotFoundPollException(String titleName) {
        super(titleName);
    }
}
