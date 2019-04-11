package com.cqwo.base.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.servlet.config.annotation.*;

import java.nio.charset.Charset;
import java.util.List;


@Configuration
public class WebAppConfig extends WebMvcConfigurationSupport {




    /**
     * 拦截器管理
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //registry.addInterceptor(new AdminInterceptor()).addPathPatterns("/admin/*").excludePathPatterns("/admin/2.*");
       // registry.addInterceptor(new APIInterceptor()).addPathPatterns("/api/*");
        super.addInterceptors(registry);
    }


    /**
     * 处理跨域访问方案
     *
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**").allowedHeaders("*")
                .allowedMethods("*")
                .allowedOrigins("*");// 允许 8088 端口访问
    }


    @Bean
    public RequestContextListener requestContextListener() {
        return new RequestContextListener();
    }


    /**
     * 配置静态访问资源
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/components/**").addResourceLocations("classpath:/components/");
        super.addResourceHandlers(registry);
    }

    @Bean
    public HttpMessageConverter<String> responseBodyConverter() {
        StringHttpMessageConverter converter = new StringHttpMessageConverter(
                Charset.forName("UTF-8"));
        return converter;
    }

    @Override
    public void configureMessageConverters(
            List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
        converters.add(responseBodyConverter());
    }

    @Override
    public void configureContentNegotiation(
            ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(false);
    }


}
