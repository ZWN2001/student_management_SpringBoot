package com.manager.pojo;

public class Validator {
    String passwordData;

    public Validator(String passwordData) {
        this.passwordData = passwordData;
    }

    public Validator() {
    }

    @Override
    public String toString() {
        return "Validator{" +
                "passwordData='" + passwordData + '\'' +
                '}';
    }

    public String getPasswordData() {
        return passwordData;
    }

    public void setPasswordData(String passwordData) {
        this.passwordData = passwordData;
    }


}

