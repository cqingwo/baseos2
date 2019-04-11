package com.cqwo.base.strategy.push;

import com.cqwo.base.core.push.IPushStrategy;
import com.cqwo.base.core.message.MessageInfo;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component(value = "PushStrategy")
public class PushStrategy implements IPushStrategy {
    @Override
    public boolean send(String deviceToken, String title, String text, MessageInfo messageInfo) throws IOException {
        return false;
    }

    @Override
    public boolean send(String title, String text, MessageInfo messageInfo) throws IOException {
        return false;
    }
}
