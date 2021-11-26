package com.manager.pojo;

public class UserLog {
    String id;
    String lastLoginTime;

    public UserLog(String id, String lastLoginTime) {
        this.id = id;
        this.lastLoginTime = lastLoginTime;
    }

    public UserLog() {
    }

    @Override
    public String toString() {
        return "UserLog{" +
                "id='" + id + '\'' +
                ", lastLoginTime='" + lastLoginTime + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLogin) {
        this.lastLoginTime = lastLogin;
    }
}
