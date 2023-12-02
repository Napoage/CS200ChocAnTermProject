package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {
    @Id
    private String username;
    private String password;
    private EmployeeType employeeType;

    public Employee(String username, String password, EmployeeType employeeType) {
        this.username = username;
        this.password = password;
        this.employeeType = employeeType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

    public enum EmployeeType {
        OPERATOR,
        MANAGER,
        PROVIDER
    }
}


    

