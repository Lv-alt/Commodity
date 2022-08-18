package com.za.user.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

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
     * 设置缓存
     * @param key key
     * @param value value
     */
    public void setCache(String key,T value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 获取缓存
     * @param key key
     * @return value
     */
    public T getCache(String key) {
        return redisTemplate.opsForValue().get(key);
    }
    
}
