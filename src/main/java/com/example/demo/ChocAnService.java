package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.PrePersist;


@Entity
public class ChocAnService {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq")
    @SequenceGenerator(name = "employee_seq", sequenceName = "custom_employee_seq", initialValue = 1, allocationSize = 1)
    private int id;

    @Id
    @Column(length = 6)
    private String serviceID;

    private String name;
    private double fee;

    public ChocAnService(String name, double fee) {
        this.name = name;
        this.fee = fee;
    }

    public ChocAnService() {
    }

    public String getName() {
        return name;
    }

    public double getFee() {
        return fee;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    @PrePersist
    public void generateServiceID() {
        this.serviceID = String.format("%06d", id);
    }    
}
