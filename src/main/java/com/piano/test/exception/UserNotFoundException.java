package com.piano.test.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException() {
        super("123456");
    }
}
