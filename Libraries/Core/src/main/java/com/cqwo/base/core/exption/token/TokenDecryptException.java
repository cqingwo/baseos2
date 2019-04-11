package com.cqwo.base.core.exption.token;

/**
 * Token解析异常
 *
 * @Author: cqnews
 * @Date: 2018-09-30 16:46
 * @Version 1.0
 */
public class TokenDecryptException extends TokenException {

    private static final long serialVersionUID = -3065028809920131492L;

    public TokenDecryptException() {
        super();
    }

    public TokenDecryptException(String message) {
        super(message);
    }

    public TokenDecryptException(String message, Throwable cause) {
        super(message, cause);
    }

    public TokenDecryptException(Throwable cause) {
        super(cause);
    }

    public TokenDecryptException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
