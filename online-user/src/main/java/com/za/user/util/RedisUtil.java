package com.za.user.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author lvweichen 🛺 ☁ ☁ ☁ …… ️🏃
 * @date 2022/8/18 下午3:02
 */
@Component
@Slf4j
public class RedisUtil<T> {
    
    @Resource
    private RedisTemplate<String,T> redisTemplate;

    /**
     * 默认半小时的过期时间
     */
    private final static Long EXPIRE_DEFAULT_TIME = 60 * 30L;

    /**
     * 设置缓存 并设置过期时间
     * @param key key
     * @param value value
     */
    public void setCache(String key,T value) {
        redisTemplate.opsForValue().set(key, value);
        redisTemplate.expire(key, EXPIRE_DEFAULT_TIME , TimeUnit.SECONDS);
    }

    /**
     * 获取缓存
     * @param key key
     * @return value
     */
    public T getCache(String key) {
        return redisTemplate.opsForValue().get(key);
    }


    /**
     * 判断key是否存在
     * @param key key
     * @return result
     */
    public boolean containsKey(String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 删除某个key
     * @param key key
     * @return result
     */
    public boolean delKey(String key) {
        return redisTemplate.delete(key);
    }

    /**
     * 添加缓存之前如果key存在先删除key
     * @param key key
     * @param value value
     */
    public void setCacheBeforeDel(String key, T value) {
        if (containsKey(key)) {
            delKey(key);
        }
        setCache(key, value);
    }
    
}
