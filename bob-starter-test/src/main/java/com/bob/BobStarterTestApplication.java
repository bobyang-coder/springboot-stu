package com.bob;

import com.bob.jediscluster.client.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BobStarterTestApplication {

    @Autowired
    private RedisClient redisClient;


    public static void main(String[] args) {
        SpringApplication.run(BobStarterTestApplication.class, args);
    }

    @RequestMapping("/set/{key}/{value}")
    public String set(@PathVariable("key") String key, @PathVariable("value") String value) throws Exception {
        redisClient.set(key, value);
        return "success";
    }

    @RequestMapping("/get/{key}")
    public String get(@PathVariable("key") String key) throws Exception {
        return redisClient.get(key);
    }
}
