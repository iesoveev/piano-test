package com.piano.test.exception;

public enum ErrorMessage {

    UNSUPPORTED_OPERATION("Запрещено входить"),
    USER_IS_NOT_FOUND("Пользователь не найден");

    private final String description;

    ErrorMessage(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
