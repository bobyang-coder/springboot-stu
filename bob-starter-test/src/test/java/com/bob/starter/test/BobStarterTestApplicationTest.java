package com.bob.starter.test;

import com.bob.jediscluster.client.RedisClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by bob on 2017/5/30.
 *
 * @author bob   <bobyang_coder@163.com>
 * @since 2017/5/30
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BobStarterTestApplicationTest {

    @Autowired
    private RedisClient redisClient;


    @Test
    public void test() throws Exception {
        redisClient.set("name", "bob");
        System.out.println("res=========" + redisClient.get("name"));
    }
}