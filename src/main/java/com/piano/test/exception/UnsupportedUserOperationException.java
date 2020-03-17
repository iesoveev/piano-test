package com.piano.test.exception;

public class UnsupportedUserOperationException extends RuntimeException {

    public UnsupportedUserOperationException(ErrorMessage errorMessage) {
        super(errorMessage.getDescription());
    }
}
