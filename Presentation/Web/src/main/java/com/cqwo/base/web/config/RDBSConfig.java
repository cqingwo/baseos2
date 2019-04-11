package com.cqwo.base.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.sql.DataSource;

@ConfigurationProperties
public class RDBSConfig {


    @Autowired
    private DataSource dataSource;


}
