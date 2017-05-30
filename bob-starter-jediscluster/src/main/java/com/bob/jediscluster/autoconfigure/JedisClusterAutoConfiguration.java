package com.bob.jediscluster.autoconfigure;

import com.bob.jediscluster.client.JedisClusterClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 自动装配JedisCluster
 *
 * @author bob   <bobyang_coder@163.com>
 * @since 2017/5/30
 */
@Configuration()
@EnableConfigurationProperties(JedisClusterProperties.class)
@ConditionalOnClass(JedisClusterClient.class)
public class JedisClusterAutoConfiguration {

    @Autowired
    private JedisClusterProperties jcp;

    @Bean("jedisCluster")
    public JedisCluster jedisCluster() {
        Map<Integer, String> nodesMap = jcp.getNodes();
        if (null == nodesMap || nodesMap.size() < 1) {
            throw new IllegalArgumentException("必要参数jedis.cluster.nodes为空");
        }
        Set<HostAndPort> nodes = new HashSet<>();
        for (int port : nodesMap.keySet()) {
            String host = nodesMap.get(port);
            HostAndPort hostAndPort = new HostAndPort(host, port);
            nodes.add(hostAndPort);
        }
        return new JedisCluster(nodes, jcp.getConnectTimeOut(), jcp.getJedisPoolConfig());
    }

    @Bean
    @ConditionalOnMissingBean(JedisClusterClient.class)//容器中如果没有JedisClusterClient这个类,那么自动配置这个JedisClusterClient
    public JedisClusterClient jedisClusterClient(@Qualifier("jedisCluster") JedisCluster jedisCluster) {
        JedisClusterClient jedisClusterClient = new JedisClusterClient();
        jedisClusterClient.setJedisCluster(jedisCluster);
        return jedisClusterClient;
    }

}
