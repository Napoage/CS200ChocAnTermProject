package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.MappedSuperclass;

import java.util.Random;

import jakarta.persistence.Column;
import jakarta.persistence.Transient;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.PrePersist;

//@Entity
@MappedSuperclass
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "employee_type", discriminatorType = DiscriminatorType.STRING)
public class Employee {
    
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq")
    @SequenceGenerator(name = "employee_seq", sequenceName = "custom_employee_seq", initialValue = 1, allocationSize = 1)
    @Transient
    private int id;

    @Id
    @Column(name = "employeeid", length = 9)
    private String employeeID;
    @Column(name = "username", length = 25)
    private String username;
    @Column(name = "password", length = 25)
    private String password;
    @Column(name = "employee_type", insertable = false, updatable = false)
    private EmployeeType employeeType;
    public Employee() {
        // Initialize any common fields if needed
    }
    public Employee(String username, String password, EmployeeType employeeType) {
        this.username = username;
        this.password = password;
        this.employeeType = employeeType;
        generateEmployeeID();
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

    public void setEmployeeID(String memberID) {
        this.employeeID = memberID;
    }
    @PrePersist
    public void beforePersist() {
        // Ensure memberID is set before persisting
        generateEmployeeID();
        //this.em = true; // Assuming new members are active by default
    }
    public void generateEmployeeID() {
        Random rand = new Random();
        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((999999999 - 100000000) + 1) + 100000000;
        String id = Integer.toString(randomNum);
        id = id.trim();
        this.employeeID = String.format("%09d", randomNum);
    }
    public String getEmployeeID() {
        return employeeID;
    }
}


    

