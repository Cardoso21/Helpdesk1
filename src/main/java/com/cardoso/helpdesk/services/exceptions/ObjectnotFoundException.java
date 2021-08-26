package com.cardoso.helpdesk.services.exceptions;

public class ObjectnotFoundException extends RuntimeException {
    private static final long serialVersiolnUID = 1L;

    public ObjectnotFoundException(String message) {
        super(message);
    }

    public ObjectnotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
