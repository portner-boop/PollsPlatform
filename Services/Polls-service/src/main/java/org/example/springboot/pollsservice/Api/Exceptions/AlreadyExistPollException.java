package org.example.springboot.pollsservice.Api.Exceptions;

public class AlreadyExistPollException extends RuntimeException {
    public AlreadyExistPollException(String s) {
        super(s);
    }
}
