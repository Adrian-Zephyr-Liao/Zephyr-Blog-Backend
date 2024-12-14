package com.zephyr.constant;

import lombok.Getter;

@Getter
public enum ErrorCodes {
    AUTH_001("Invalid username or password"),
    AUTH_002("User registration failed"),
    AUTH_003("Internal server error");

    private final String message;

    ErrorCodes(String message) {
        this.message = message;
    }

}