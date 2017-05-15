package com.bob.stu.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by bob on 2017/5/14.
 *
 * @author bob
 * @since 2017/5/14
 */
@Component
@ConfigurationProperties(prefix = "girl")
public class GirlProperties {

    private String name;

    private int age;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
