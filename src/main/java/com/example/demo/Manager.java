package com.example.demo;

public class Manager {
    private String managerName;
    private String managerUserName;
    private String managerPassword;
    private int managerID;
    public Manager(String managerName, String managerUserName, String managerPassword, int managerID) {
        this.managerName = managerName;
        this.managerUserName = managerUserName;
        this.managerPassword = managerPassword;
        this.managerID = managerID;
    }
    public String getManagerName() {
        return managerName;
    }
    public String getManagerUserName() {
        return managerUserName;
    }
    public String getManagerPassword() {
        return managerPassword;
    }
    public int getManagerID() {
        return managerID;
    }
}
