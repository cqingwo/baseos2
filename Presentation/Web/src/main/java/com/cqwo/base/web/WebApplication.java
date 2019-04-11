package com.cqwo.base.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;


@SpringBootApplication
@ComponentScan(value = "com.cqwo.base")
@EntityScan(value = {"com.cqwo.base.core.domain"})
@EnableJpaRepositories(value = {"com.cqwo.base.core.data.rdbs.repository"})
@EnableTransactionManagement
@EnableRedisHttpSession
@EnableConfigurationProperties
@EnableAsync
@EnableAspectJAutoProxy(exposeProxy = true)
@EnableScheduling
public class WebApplication extends SpringBootServletInitializer {


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WebApplication.class);
    }


    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {

        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();

        factory.setReadTimeout(30000);
        factory.setConnectTimeout(15000);

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        restTemplate.setRequestFactory(factory);

        return restTemplate;
    }

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }
}
