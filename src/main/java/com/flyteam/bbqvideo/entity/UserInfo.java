package com.flyteam.bbqvideo.entity;

public class UserInfo {
    private Integer userId;
    private String userName;
    private String nickName;

    public UserInfo(Integer userId,String userName, String nickName){
        this.userId = userId;
        this.userName = userName;
        this.nickName = nickName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append(", userId=").append(userId);
        sb.append(", userName=").append(userName);
        sb.append(", nickName=").append(nickName);
        sb.append(", nickName=").append(nickName);
        sb.append("]");
        return sb.toString();
    }
}
