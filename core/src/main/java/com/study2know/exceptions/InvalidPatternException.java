package com.study2know.exceptions;

/**
 * Created by kurtesy on 16/8/15.
 */
public class InvalidPatternException extends Exception {
    public InvalidPatternException(String s) {
        this.initCause(new RuntimeException(s));
    }

    public InvalidPatternException(Throwable s) {
        this.initCause(s);
    }
}
