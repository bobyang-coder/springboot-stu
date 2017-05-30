package com.bob.jediscluster.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Jedis配置对象
 *
 * @author bob   <bobyang_coder@163.com>
 * @since 2017/5/30
 */
@ConfigurationProperties(prefix = "jedis")
public class JedisProperties {

    private String host;//Redis服务器地址

    private int port = 6379;//Redis服务器连接端口

    private String password;//Redis服务器连接密码

    private int maxTotal;//连接池最大连接数（使用负值表示没有限制）

    private int maxIdle;//连接池中的最大空闲连接

    private int maxWaitMillis;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getMaxTotal() {
        return maxTotal;
    }

    public void setMaxTotal(int maxTotal) {
        this.maxTotal = maxTotal;
    }

    public int getMaxIdle() {
        return maxIdle;
    }

    public void setMaxIdle(int maxIdle) {
        this.maxIdle = maxIdle;
    }

    public int getMaxWaitMillis() {
        return maxWaitMillis;
    }

    public void setMaxWaitMillis(int maxWaitMillis) {
        this.maxWaitMillis = maxWaitMillis;
    }
}
