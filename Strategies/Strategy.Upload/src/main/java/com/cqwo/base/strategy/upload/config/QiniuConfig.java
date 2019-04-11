package com.cqwo.base.strategy.upload.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "qiniu.config")
@PropertySource("classpath:qiniuconfig.properties")
public class QiniuConfig {

    /**
     * accessKey key
     */
    private String accessKey = "";

    /**
     * secretKey 密钥
     */
    private String secretKey = "";

    /**
     * 空间名称
     */
    private String bucket = "imgcdn";

    /**
     * 配置访问域名
     */
    private String url = "";

    public QiniuConfig() {
    }

    public QiniuConfig(String accessKey, String secretKey, String bucket, String url) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
        this.bucket = bucket;
        this.url = url;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "QiniuConfig{" +
                "accessKey='" + accessKey + '\'' +
                ", secretKey='" + secretKey + '\'' +
                ", bucket='" + bucket + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
