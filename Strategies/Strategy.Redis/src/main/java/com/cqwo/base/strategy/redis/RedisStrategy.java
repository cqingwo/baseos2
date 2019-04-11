package com.cqwo.base.strategy.redis;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cqwo.base.core.cache.ICacheStrategy;
import com.cqwo.base.core.helper.StringHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component(value = "RedisStrategy")
public class RedisStrategy implements ICacheStrategy {

    /**
     * 日志记录
     */
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    protected RedisTemplate redisTemplate;

    protected int timeout = 60;

    protected TimeUnit timeUnit = TimeUnit.MINUTES;


    @Autowired(required = false)
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        RedisSerializer stringSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setValueSerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
        redisTemplate.setHashValueSerializer(stringSerializer);
        this.redisTemplate = redisTemplate;
    }


    /**
     * 获取缓存键值
     *
     * @param key 关键值
     * @return 值
     */
    @Override
    public Object getValue(String key) {
        try {

            ValueOperations<String, String> valueops = redisTemplate.opsForValue();


            String s = valueops.get(key);

            if (s.isEmpty()) {
                return null;
            }

            return JSON.parseObject(s, String.class);

        } catch (Exception ex) {

            logger.error(ex.getMessage());
        }

        return null;
    }

    /**
     * 获取缓存键值
     *
     * @param key 关键值
     * @return 值
     */
    @Override
    public <T> T getValue(String key, Class<T> clz) {

        try {

            ValueOperations<String, String> valueops = redisTemplate.opsForValue();

            String s = valueops.get(key);

            if (s.isEmpty()) {
                return null;
            }

            return JSON.parseObject(s, clz);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }

        return null;
    }


    /**
     * 设置缓存键值
     *
     * @param key    关键值
     * @param object 值
     */
    @Override
    public void setValue(String key, Object object) {
        setValue(key, object, 60, TimeUnit.MINUTES);
    }


    /**
     * 设置缓存键值
     *
     * @param key    关键值
     * @param object 值
     */
    @Override
    public void setValue(String key, Object object, Integer timeout, TimeUnit timeUnit) {

        try {
            object = object == null ? new Object() : object;


            ValueOperations<String, Object> valueops = redisTemplate.opsForValue();

            String s = JSON.toJSONString(object);

            valueops.set(key, s, timeout, timeUnit);
        } catch (Exception ex) {
            logger.error("设置缓存键值失败:" + ex.getMessage());
        }
    }

    /**
     * 获取缓存键值列表
     *
     * @param key 关键值
     * @return 值
     */
    @Override
    public <T> List<T> getListValue(String key, Class<T> clz) {


        ValueOperations<String, String> valueops = redisTemplate.opsForValue();

        String s = valueops.get(key);

        if (StringHelper.isEmpty(s)) {
            return null;
        }


        return JSONArray.parseArray(s, clz);
    }

    /**
     * 设置缓存键值列表
     *
     * @param key  关键值
     * @param list 值
     */
    @Override
    public void setListValue(String key, List<?> list) {
        setListValue(key, list, 60, TimeUnit.MINUTES);
    }


    /**
     * 设置缓存键值列表
     *
     * @param key  关键值
     * @param list 值
     */
    @Override
    public void setListValue(String key, List<?> list, Integer timeout, TimeUnit timeUnit) {

        list = list == null ? new ArrayList<>() : list;

        String s = JSONObject.toJSONString(list);

        ValueOperations<String, Object> valueops = redisTemplate.opsForValue();

        valueops.set(key, s, timeout, timeUnit);
    }

    /**
     * 删除缓存键值key
     *
     * @param key
     */
    @Override
    public boolean delete(String key) {

        return redisTemplate.delete(key);

    }


}
