package com.zephyr.constant;

public enum ErrorCodes {
    AUTH_001("Invalid username or password"),
    AUTH_002("User registration failed"),
    AUTH_003("Internal server error");

    private final String message;

    ErrorCodes(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}