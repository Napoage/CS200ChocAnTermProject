package com.example.demo;

import javax.annotation.processing.Generated;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Table;

@Entity
@Table(name = "Managers")
public class Manager {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq")
    @SequenceGenerator(name = "employee_seq", sequenceName = "custom_employee_seq", initialValue = 1, allocationSize = 1)
    //@Transient
    private int id;

    @Id
    @Column(name = "managerid", length = 9)
    private String managerID;
    private String managerName;
    private String managerUserName;
    private String managerPassword;
    
    public Manager(String managerName, String managerUserName, String managerPassword, int managerID) {
        this.managerName = managerName;
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
    
    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }
    
    public void setManagerUserName(String managerUserName) {
        this.managerUserName = managerUserName;
    }
    
    public void setManagerPassword(String managerPassword) {
        this.managerPassword = managerPassword;
    }
}
// FILEPATH: /c:/Users/Zac-Desktop/Desktop/demo/src/main/java/com/example/demo/Manager.java
