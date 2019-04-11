package com.cqwo.base.core.exption;


/**
 * 数据重复
 */
public class ExistsException extends CWMException {

    private static final long serialVersionUID = -4707897371304550444L;

    public ExistsException(String message) {
        super( message );
    }
}
