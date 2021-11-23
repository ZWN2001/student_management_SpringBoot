package com.manager.pojo;

public class Student {
    private  Integer sid;
    private  String name;
    private Integer clazz;
    private String mail;
    private String phone;
    private String address;
    private String other;

    public Student(Integer sid, String name, Integer clazz, String mail, String phone, String address, String other) {
        this.sid = sid;
        this.name = name;
        this.clazz = clazz;
        this.mail = mail;
        this.phone = phone;
        this.address = address;
        this.other = other;
    }

    public Student(){}

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", name='" + name + '\'' +
                ", clazz=" + clazz +
                ", mail='" + mail + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", other='" + other + '\'' +
                '}';
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getClazz() {
        return clazz;
    }

    public void setClazz(Integer clazz) {
        this.clazz = clazz;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
}
