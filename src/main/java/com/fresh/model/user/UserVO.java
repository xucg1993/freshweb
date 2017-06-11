package com.fresh.model.user;

import com.fresh.model.Pages;

/*
 * 用户分页VO
 */
public class UserVO extends Pages {

    private int userid;         // 主键id
    private String username;    // 姓名
    private int age;            // 年龄

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
