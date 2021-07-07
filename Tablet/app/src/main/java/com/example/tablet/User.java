package com.example.tablet;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = -5075160458386243593L;

    String id;
    String nickName;
    String msg;

    public User() {

    }

    public User(String id, String nickName, String msg) {
        this.id = id;
        this.nickName = nickName;
        this.msg = msg;
    }

    public String getId() {
        return id;
    }

    public String getNickName() {
        return nickName;
    }

    public String getMsg() {
        return msg;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", nickName='" + nickName + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}