package org.example.springboot.pollsservice.Api.Exceptions;

public class NotFoundAnswerException extends RuntimeException {
    public NotFoundAnswerException(String answerNotFound) {
        super(answerNotFound);
    }
}
