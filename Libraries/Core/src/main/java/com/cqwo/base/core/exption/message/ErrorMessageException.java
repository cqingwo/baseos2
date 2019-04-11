package com.cqwo.base.core.exption.message;


public class ErrorMessageException extends Exception {

    private static final long serialVersionUID = 3333922318739914325L;

    public ErrorMessageException() {
        super();
    }


    public ErrorMessageException(Exception ex, String message) {
        super(message);
    }

    public ErrorMessageException(String message) {
        super(message);
    }

    public ErrorMessageException(String message, Throwable cause) {
        super(message, cause);
    }

    public ErrorMessageException(Throwable cause) {
        super(cause);
    }

    protected ErrorMessageException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
