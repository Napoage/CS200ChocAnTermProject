package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import java.beans.Transient;

import jakarta.persistence.Column;
import jakarta.persistence.PrePersist;

@Entity
public class Member {

    
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq")
    @SequenceGenerator(name = "employee_seq", sequenceName = "custom_employee_seq", initialValue = 1, allocationSize = 1)
    private int id;

    @Id
    @Column(length = 9)
    private String memberID;

    private String name;
    private String email;
    private String streetAddress;
    private String city;
    @Column(length = 2)
    private String state; // 2-letter state code
    @Column(length = 5)
    private String zipCode; // 5-digit ZIP code
    private boolean status; // Active or suspended

    // Constructor
    public Member(String memberName, String memberEmail, String memberStreetAddress, String memberCity,
            String memberState, String memberZipCode) {
        this.name = memberName;
        this.email = memberEmail;
        this.streetAddress = memberStreetAddress;
        this.city = memberCity;
        this.state = memberState;
        this.zipCode = memberZipCode;
        this.status = true; // Assuming new members are active by default
    }

    public boolean changeName(String newName) {
        name = newName;
        return true;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @PrePersist
    public void generateMemberID() {
        this.memberID = String.format("%09d", id);
    }
}