package com.study2know.exceptions;

/**
 * Created by kurtesy on 7/8/15.
 */
public class InvalidTypeException extends Exception {
    private String message = null;

    public InvalidTypeException(IllegalArgumentException e) {
        this.initCause(e);
    }

    public InvalidTypeException(String message) {
        this.message = message;
    }

    public String getMessage() {
        if (message == null)
            return super.getMessage();
        return message;
    }

}
