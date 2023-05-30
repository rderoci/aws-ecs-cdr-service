package com.telecom.exceptions;

public class CDRNotFoundException extends RuntimeException {

    public CDRNotFoundException(final String message) {
        super(message);
    }
}
