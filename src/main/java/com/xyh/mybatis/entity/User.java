package com.xyh.mybatis.entity;

import java.io.Serializable;

/**
 * @author xuyh
 * @date 2019/7/2
 */
public class User implements Serializable {
    private Integer id;
    private Integer age;
    private String nickName;

    public User() {
    }

    public User(Integer id, Integer age, String nickName) {
        this.id = id;
        this.age = age;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", nickName='" + nickName + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
