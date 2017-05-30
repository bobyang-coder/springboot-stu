package com.bob.jediscluster.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Map;

/**
 * JedisCluster配置对象
 *
 * @author bob   <bobyang_coder@163.com>
 * @since 2017/5/30
 */
@ConfigurationProperties(prefix = "jedis.cluster")
public class JedisClusterProperties {

    private int expireSeconds;

    private String clusterNodes;//集群节点

    private int connectTimeOut;//连接超时时间

    private Map<Integer, String> nodes;//集群节点

    private JedisPoolConfig jedisPoolConfig;

    public int getExpireSeconds() {
        return expireSeconds;
    }

    public void setExpireSeconds(int expireSeconds) {
        this.expireSeconds = expireSeconds;
    }

    public String getClusterNodes() {
        return clusterNodes;
    }

    public void setClusterNodes(String clusterNodes) {
        this.clusterNodes = clusterNodes;
    }

    public int getConnectTimeOut() {
        return connectTimeOut;
    }

    public void setConnectTimeOut(int connectTimeOut) {
        this.connectTimeOut = connectTimeOut;
    }

    public Map<Integer, String> getNodes() {
        return nodes;
    }

    public void setNodes(Map<Integer, String> nodes) {
        this.nodes = nodes;
    }

    public JedisPoolConfig getJedisPoolConfig() {
        return jedisPoolConfig;
    }

    public void setJedisPoolConfig(JedisPoolConfig jedisPoolConfig) {
        this.jedisPoolConfig = jedisPoolConfig;
    }
}
