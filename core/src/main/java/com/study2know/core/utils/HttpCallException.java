package com.study2know.core.utils;

import org.apache.commons.httpclient.HttpException;

/**
 * Created by anuj on 11/11/15.
 */
public class HttpCallException extends HttpException {
    public final String msg;
    public int status;

    public HttpCallException(int status, String msg) {
        super(msg);
        this.msg = msg;
        this.status = status;
    }
}
