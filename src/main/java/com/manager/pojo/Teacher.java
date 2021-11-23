package com.manager.pojo;

public class Teacher {
    private Integer tid;

    private String name;

    public Teacher(Integer tid,  String name) {
        this.tid = tid;
        this.name = name;
    }
    public Teacher(){}

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
