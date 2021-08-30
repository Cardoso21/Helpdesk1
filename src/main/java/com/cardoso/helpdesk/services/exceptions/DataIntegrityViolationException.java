package com.cardoso.helpdesk.services.exceptions;

public class DataIntegrityViolationException extends RuntimeException {
    private static final long serialVersiolnUID = 1L;

    public DataIntegrityViolationException(String message) {
        super(message);
    }

    public DataIntegrityViolationException(String message, Throwable cause) {
        super(message, cause);
    }
}
