package com.cqwo.base.core.exption;

public class AnalyzeException extends CWMException {



    private static final long serialVersionUID = -8070248599836446141L;

    public AnalyzeException() {
        super();
    }

    public AnalyzeException(String message) {
        super(message);
    }

    public AnalyzeException(String message, Throwable cause) {
        super(message, cause);
    }

    public AnalyzeException(Throwable cause) {
        super(cause);
    }

    protected AnalyzeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }


}
