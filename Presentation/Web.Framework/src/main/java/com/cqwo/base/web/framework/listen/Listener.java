package com.cqwo.base.web.framework.listen;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextListener;

/**
 * @author cqnews
 */
@Configuration
public class Listener {


    @Bean
    public RequestContextListener requestContextListener() {
        return new RequestContextListener();
    }


}