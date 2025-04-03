package org.example.springboot.analyticsservice.Api.Exception;

public class NotFoundPollInRequest extends RuntimeException {
    public NotFoundPollInRequest(String typeOfPollCannotBeNull) {
        super(typeOfPollCannotBeNull);
    }
}
