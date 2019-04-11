package com.cqwo.base.core.exption.token;

import com.cqwo.base.core.exption.CWMException;

/**
 * token默认异常
 *
 * @Author: cqnews
 * @Date: 2018-09-30 16:44
 * @Version 1.0
 */
public class TokenException extends CWMException {

    private static final long serialVersionUID = -4460759925692095689L;

    public TokenException() {
        super();
    }

    public TokenException(String message) {
        super(message);
    }

    public TokenException(String message, Throwable cause) {
        super(message, cause);
    }

    public TokenException(Throwable cause) {
        super(cause);
    }

    public TokenException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
