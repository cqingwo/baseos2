package com.cqwo.base.core.cache;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by cqnews on 2017/4/10.
 */
public interface ICacheStrategy {


    /**
     * 获取
     *
     * @param key 关键值
     * @return 值
     */
    Object getValue(String key);

    /**
     * 获取缓存键值
     *
     * @param key 关键值
     * @return 值
     */
    <T> T getValue(String key, Class<T> clz);


    /**
     * 设置缓存键值
     *
     * @param key
     * @param object
     */
    void setValue(String key, Object object);

    /**
     * 设置缓存键值
     *
     * @param key
     * @param object
     */
    void setValue(String key, Object object, Integer timeout, TimeUnit timeUnit);

    /**
     * 获取缓存键值列表
     *
     * @param key 关键值
     * @return 值
     */
    <T> List<T> getListValue(String key, Class<T> clz);

    /**
     * 设置缓存键值列表
     *
     * @param key
     * @param list
     */
    void setListValue(String key, List<?> list);

    /**
     * 设置缓存键值列表
     *
     * @param key
     * @param list
     */
    void setListValue(String key, List<?> list, Integer timeout, TimeUnit timeUnit);


    /**
     * 删除缓存键值key
     *
     * @param key
     */
    boolean delete(String key);
}
