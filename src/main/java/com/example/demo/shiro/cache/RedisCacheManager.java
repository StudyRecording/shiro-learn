package com.example.demo.shiro.cache;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;

/**
 * 实现Redis缓存
 */
public class RedisCacheManager implements CacheManager {

    @Override
    public <K, V> Cache<K, V> getCache(String s) throws CacheException {
        System.out.println("redisCacheManager:" + s);
        return new RedisCache<K, V>(s);
    }
}
