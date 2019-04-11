package com.cqwo.base.strategy.sms;


import com.cqwo.base.core.config.info.SMSConfigInfo;
import com.cqwo.base.core.domain.sms.SMSInfo;
import com.cqwo.base.core.helper.HttpHelper;
import com.cqwo.base.core.sms.ISMSStrategy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by cqnews on 2017/3/23.
 */
@Component(value = "SMSStrategy")
@Primary
public class SMSStrategy implements ISMSStrategy {



    private Lock lock = new ReentrantLock();

    /**
     * 编码
     */
    private String encoding = "utf-8";

    @Override
    public Boolean send(String to, String body) {

        lock.lock();
        try {

            SMSConfigInfo configInfo = new SMSConfigInfo();

            String url = String.format("%s?action=send&userid=%d&account=%s&password=%s&mobile=%s&content=%s&sendTime=&extno=", configInfo.getUrl(), configInfo.getUserid(), configInfo.getAccount(), configInfo.getPassword(), to, URLEncoder.encode(body, encoding));

            HttpHelper.doGet(url);

            System.out.println(url);
        } catch (UnsupportedEncodingException e) {

            return false;
        } finally {

            lock.unlock();
        }
        return true;

    }

    @Override
    public Boolean send(Integer uid, Integer type, String code, String to, String body) {
        return send(to, body);
    }

    @Override
    public Integer createSMS(SMSInfo smsInfo) {
        return 0;
    }
}

