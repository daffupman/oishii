package io.daff.oishii.console.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 简单的redis的工具类
 *
 * @author daffupman
 * @since 2020/8/30
 */
@Component
public class SimpleRedisUtil {

    @Value("${spring.application.name}")
    private String KEY_PREFIX;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 设置string类型的值
     */
    public void set(String key, String value) {
        set(key, value, -1);
    }

    /**
     * 设置string类型的值，同时设置过期时间，单位s，时间为负数的则设置为永不过期
     */
    public void set(String key, String value, long ttl) {
        if (StringUtils.isEmpty(key) || StringUtils.isEmpty(value)) {
            return;
        }
        key = getKeyPrefix() + key;
        if (ttl > 0) {
            stringRedisTemplate.opsForValue().set(key, value, ttl, TimeUnit.SECONDS);
        } else {
            stringRedisTemplate.opsForValue().set(key, value);
        }
    }

    /**
     * 获取string类型的值
     */
    public String get(String key) {
        if (StringUtils.isEmpty(key)) {
            return null;
        }
        return stringRedisTemplate.opsForValue().get(getKeyPrefix() + key);
    }

    /**
     * 按key删除值
     */
    public void delete(List<String> keys) {
        if (StringUtils.isEmpty(keys)) { return; }
        stringRedisTemplate.delete(getKeyPrefix() + keys);
    }

    /**
     * 按key删除值
     */
    public void delete(String key) {
        if (StringUtils.isEmpty(getKeyPrefix() + key)) { return; }
        stringRedisTemplate.delete(key);
    }

    /**
     * 按key删除值
     */
    public Boolean exist(String key) {
        if (StringUtils.isEmpty(key)) { return false; }
        return stringRedisTemplate.hasKey(getKeyPrefix() + key);
    }

    /**
     * 设置hash类型的值，同时设置过期时间，单位s，时间为负数的则设置为永不过期
     */
    public void hset(String key, String subKey, String value, long ttl) {
        if (StringUtils.isEmpty(key) || StringUtils.isEmpty(subKey) || StringUtils.isEmpty(value)) {
            return;
        }
        key = getKeyPrefix() + key;
        stringRedisTemplate.opsForHash().put(key, subKey, value);
        if (ttl > 0) {
            stringRedisTemplate.expire(key, ttl, TimeUnit.SECONDS);
        }
    }

    /**
     * 获取string类型的值
     */
    public <T> T hget(String key, Object subKey, Class<?> clz) {
        if (StringUtils.isEmpty(key) || StringUtils.isEmpty(subKey)) {
            return null;
        }
        Object o = stringRedisTemplate.opsForHash().get(getKeyPrefix() + key, subKey);
        return (T) o;
    }

    /**
     * 按key删除值
     */
    public void hdel(String key, Object... subKeys) {
        if (StringUtils.isEmpty(key) || subKeys == null || subKeys.length == 0) { return; }
        stringRedisTemplate.opsForHash().delete(getKeyPrefix() + key, subKeys);
    }

    /**
     * 按key删除值
     */
    public Boolean hexist(String key, Object subKey) {
        if (StringUtils.isEmpty(key) || StringUtils.isEmpty(subKey)) { return false; }
        key = getKeyPrefix() + key;
        return Boolean.TRUE.equals(stringRedisTemplate.hasKey(key)) && stringRedisTemplate.opsForHash().hasKey(key, subKey);
    }

    private String getKeyPrefix() {
        return KEY_PREFIX + ":";
    }
}
