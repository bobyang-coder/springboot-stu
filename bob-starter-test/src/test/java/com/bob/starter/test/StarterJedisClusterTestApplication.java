package com.bob.starter.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.JedisCluster;

/**
 * Created by bob on 2017/5/30.
 *
 * @author bob   <bobyang_coder@163.com>
 * @since 2017/5/30
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StarterJedisClusterTestApplication {


    @Autowired
    private JedisCluster jedisCluster;

    @Test
    public void test() throws Exception {

        System.out.println("res=========");
    }
}