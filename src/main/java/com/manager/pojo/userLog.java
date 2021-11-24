package com.manager.pojo;

public class userLog {
    String id;
    String lastLogin;

    public userLog(String id, String lastLogin) {
        this.id = id;
        this.lastLogin = lastLogin;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }
}
