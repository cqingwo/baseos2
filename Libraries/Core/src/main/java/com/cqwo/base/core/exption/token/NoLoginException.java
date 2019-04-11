package com.cqwo.base.core.exption.token;

import com.cqwo.base.core.exption.CWMException;

/**
 * @Author: cqnews
 * @Date: 2018-09-30 16:33
 * @Version 1.0
 */

public class NoLoginException extends CWMException {

    private static final long serialVersionUID = -178401273147446213L;

    public NoLoginException() {
        super();
    }

    public NoLoginException(String message) {
        super(message);
    }

    public NoLoginException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoLoginException(Throwable cause) {
        super(cause);
    }

    public NoLoginException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
