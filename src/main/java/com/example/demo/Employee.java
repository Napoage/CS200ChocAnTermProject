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
import jakarta.persistence.Column;
import jakarta.persistence.Transient;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.PrePersist;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "employee_type", discriminatorType = DiscriminatorType.STRING)
public class Employee {
    
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq")
    @SequenceGenerator(name = "employee_seq", sequenceName = "custom_employee_seq", initialValue = 1, allocationSize = 1)
    @Transient
    private int id;

    @Id
    @Column(length = 9)
    private String employeeID;

    private String username;
    private String password;
    @Column(name = "employee_type", insertable = false, updatable = false)
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

    @PrePersist
    public void generateEmployeeID() {
        this.employeeID = String.format("%09d", id);
    }
}


    

