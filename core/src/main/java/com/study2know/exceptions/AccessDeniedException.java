package com.study2know.exceptions;

/**
 * Created by anuj on 5/11/15.
 */
public class AccessDeniedException extends Exception {
    public String userId;
    public String resource;
    public int code = 403;

    public AccessDeniedException(String userId, String resource) {
        this.userId = userId;
        this.resource = resource;
    }

    public AccessDeniedException(String userId, int code) {
        this.userId = userId;
        this.code = code;
    }
}
