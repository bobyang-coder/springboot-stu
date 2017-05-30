package com.bob.jediscluster.client;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Redis客户端
 *
 * @author bob   <bobyang_coder@163.com>
 * @since 2017/5/30
 */
public class RedisClient {
    private JedisPool jedisPool;

    public void set(String key, String value) {
        Jedis jedis = null;
        jedis = jedisPool.getResource();
        jedis.set(key, value);
        jedis.close();//返还到连接池
    }

    public String get(String key) {
        Jedis jedis = jedisPool.getResource();
        String val = jedis.get(key);
        jedis.close();//返还到连接池
        return val;
    }

    public JedisPool getJedisPool() {
        return jedisPool;
    }

    public void setJedisPool(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }
}
