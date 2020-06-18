package com.flyteam.bbqvideo.dao;

import javax.persistence.*;

@Entity
@Table(name="user") //指定表名
public class UserDao {
    @Id //主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;

    @Column(name="username")
    private String userName;

    @Column(name="password")
    private String password;

    @Column(name="nickname")
    private String nickName;

    public Integer getUserId() {
        return uid;
    }
    public void setUserId(Integer uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String userPassword) {
        this.password = userPassword;
    }

    public String getNickName() {
        return nickName;
    }
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
