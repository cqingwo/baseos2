package com.cqwo.base.core.exption.message;

import com.cqwo.base.core.exption.CWMException;
import com.cqwo.base.core.message.MessageInfo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageException extends CWMException {

    private static final long serialVersionUID = -1066022429566331817L;

    /**
     * 消息
     */
    private MessageInfo messageInfo;

    public MessageException() {
        super();
    }

    public MessageException(String message) {
        super(message);
    }

    public MessageException(MessageInfo messageInfo) {
        super(messageInfo.getMessage());
        this.messageInfo = messageInfo;
    }

    public MessageException(String message, Throwable cause) {
        super(message, cause);
    }

    public MessageException(Throwable cause) {
        super(cause);
    }

    public MessageException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
