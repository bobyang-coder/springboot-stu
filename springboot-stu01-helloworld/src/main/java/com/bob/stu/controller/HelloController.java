package com.bob.stu.controller;

import com.bob.stu.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by bob on 2017/5/14.
 */
@RestController
public class HelloController {

    @Value("${name}")
    private String name;
    @Value("${age}")
    private int age;

    @Value("${content}")
    private String content;

    @Autowired
    private GirlProperties girlProperties;

    @RequestMapping("/")
    public String sayHello(@RequestParam(value = "user", defaultValue = "admin") String user) {

        return String.format("%s %s user=%s,content=%s", name, age, user, content);
    }

    //    @RequestMapping(value = "/girl", method = RequestMethod.POST)
    @PostMapping("hi")
    public String hiGirl() {

        return girlProperties.getName();
    }
}
