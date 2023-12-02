package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Manager {

    @Id
    private int managerID;
    private String managerName;
    private String managerUserName;
    private String managerPassword;
    
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
    
    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }
    
    public void setManagerUserName(String managerUserName) {
        this.managerUserName = managerUserName;
    }
    
    public void setManagerPassword(String managerPassword) {
        this.managerPassword = managerPassword;
    }
    
    public void setManagerID(int managerID) {
        this.managerID = managerID;
    }
}
// FILEPATH: /c:/Users/Zac-Desktop/Desktop/demo/src/main/java/com/example/demo/Manager.java
