package com.piano.test.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException() {
        super(ErrorMessage.USER_IS_NOT_FOUND.getDescription());
    }
}
