package com.manager.pojo;

public class UserLog {
    String lastLoginTime;

    public UserLog( String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    @Override
    public String toString() {
        return "UserLog{" +
                "lastLoginTime='" + lastLoginTime + '\'' +
                '}';
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLogin) {
        this.lastLoginTime = lastLogin;
    }
}
