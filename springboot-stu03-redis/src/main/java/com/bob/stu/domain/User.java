package com.bob.stu.domain;

import java.io.Serializable;

/**
 * User实体
 *
 * @author bob   <bobyang_coder@163.com>
 * @since 2017/5/21
 */
public class User implements Serializable {
    private static final long serialVersionUID = 5367512857474976036L;
    private String username;
    private Integer age;

    public User(String username, Integer age) {
        this.username = username;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
