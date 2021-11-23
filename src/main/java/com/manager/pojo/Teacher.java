package com.manager.pojo;

public class Teacher {
    private Integer tid;
    private String password;
    private String name;

    public Teacher(Integer tid, String password, String name) {
        this.tid = tid;
        this.password = password;
        this.name = name;
    }
    public Teacher(){}

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
