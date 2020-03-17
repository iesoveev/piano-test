package com.piano.test.exception;

public enum ErrorMessage {

    UNSUPPORTED_OPERATION("Запрещено входить");

    private final String description;

    ErrorMessage(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
