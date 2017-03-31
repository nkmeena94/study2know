package com.study2know.exceptions;

import java.io.IOException;

/**
 * Created by anuj on 12/8/15.
 */
public class NotificationFailureException extends Throwable {
    public NotificationFailureException(IOException e) {
        this.initCause(e);
    }
}
