package com.bob.jediscluster.client;

import redis.clients.jedis.JedisCluster;

/**
 * JedisCluster客户端
 *
 * @author bob   <bobyang_coder@163.com>
 * @since 2017/5/30
 */
public class JedisClusterClient {
    private JedisCluster jedisCluster;

    /**
     * set方法
     *
     * @param key
     * @param value
     * @return
     */
    public String set(final String key, final String value) {
        return jedisCluster.set(key, value);
    }

    /**
     * 保存数据到redis中，并且设置过期时间
     *
     * @param key
     * @param value
     * @param expire
     * @return
     */
    public String set(final String key, final String value, final Integer expire) {
        String str = jedisCluster.set(key, value);// 设置数据
        jedisCluster.expire(key, expire);
        return str;
    }

    /**
     * 设置过期时间
     *
     * @param key
     * @param expire
     * @return
     */
    public Long expire(final String key, final Integer expire) {
        return jedisCluster.expire(key, expire);
    }

    /**
     * get 方法
     *
     * @param key
     * @return
     */
    public String get(final String key) {
        return jedisCluster.get(key);
    }

    /**
     * 根据key删除redis中的数据
     *
     * @param key
     * @return
     */
    public Long del(final String key) {
        return jedisCluster.del(key);
    }

    public void setJedisCluster(JedisCluster jedisCluster) {
        this.jedisCluster = jedisCluster;
    }
}
