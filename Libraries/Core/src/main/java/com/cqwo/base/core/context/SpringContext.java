package com.cqwo.base.core.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;


@Component(value = "SpringContext")
public class SpringContext implements ApplicationContextAware {

    private static ApplicationContext ctx;


    public static ApplicationContext getApplicationContext() {
        return ctx;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (SpringContext.ctx == null) {
            SpringContext.ctx = applicationContext;
            System.out.println(
                    "========ApplicationContext配置成功,在普通类可以通过调用ToolSpring.getAppContext()获取applicationContext对象,applicationContext="
                            + applicationContext + "========");
        }
    }

    public static Object getBean(String name) {
        return getApplicationContext().getBean(name);
    }

    public static <T> T getBean(Class<T> clazz) {
        return getApplicationContext().getBean(clazz);
    }

    public static <T> T getBean(String name, Class<T> clazz) {
        return getApplicationContext().getBean(name, clazz);
    }


}
