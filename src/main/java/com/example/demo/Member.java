package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import java.beans.Transient;
import java.util.Random;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.PrePersist;

@Entity
public class Member {

    
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq")
    @SequenceGenerator(name = "employee_seq", sequenceName = "custom_employee_seq", initialValue = 1, allocationSize = 1)
    private int id;

    @Id
    @Column(name = "memberid", length = 9)
    private String memberID;
    @Column(name = "name", length = 25)
    private String memberName;
    @Column(name = "email", length = 50)
    private String memberEmail;
    @Column(name = "street_address", length = 25)
    private String memberAddress;
    @Column(name = "city", length = 14)
    private String memberCity;
    @Column(name = "state", length = 2)
    private String memberState; // 2-letter state code
    @Column(name = "zip_code", length = 5)
    private String memberZip; // 5-digit ZIP code
    @Column(name = "status")
    private boolean memberStatus; // Active or suspended
    /*@Column(name = "fee_to_pay")
    private int feeToPay;*/

    // Constructor
    public Member() {
    }
    public Member(String memberName, String memberEmail, String memberAddress, String memberCity,
            String memberState, String memberZipCode) {
        this.memberName = memberName;
        this.memberEmail = memberEmail;
        this.memberAddress = memberAddress;
        this.memberCity = memberCity;
        this.memberState = memberState;
        this.memberZip = memberZipCode;
        generateMemberID();
        this.memberStatus = true; // Assuming new members are active by default
        //this.feeToPay = 0;
    }

    public boolean changeName(String newName) {
        memberName = newName;
        return true;
    }

    // Getters and Setters
    public String getName() {
        return memberName;
    }

    public void setName(String name) {
        this.memberName = name;
    }

    public String getEmail() {
        return memberEmail;
    }

    public void setEmail(String email) {
        this.memberEmail = email;
    }

    public String getStreetAddress() {
        return memberAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.memberAddress = streetAddress;
    }

    public String getCity() {
        return memberCity;
    }

    public void setCity(String city) {
        this.memberCity = city;
    }

    public String getMemberState() {
        return memberState;
    }

    public void setMemberState(String state) {
        this.memberState = state;
    }

    public String getZipCode() {
        return memberZip;
    }

    public void setZipCode(String zipCode) {
        this.memberZip = zipCode;
    }

    public boolean isStatus() {
        return memberStatus;
    }

    public void setStatus(boolean status) {
        this.memberStatus = status;
    }
    public String getMemberID() {
        return memberID;
    }
    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }
    @PrePersist
    public void beforePersist() {
        // Ensure memberID is set before persisting
        generateMemberID();
        this.memberStatus = true; // Assuming new members are active by default
    }
    public void generateMemberID() {
        Random rand = new Random();
        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((999999999 - 100000000) + 1) + 100000000;
        this.memberID = Integer.toString(randomNum);
    }
    /*public int getFeeToPay() {
        return feeToPay;
    }
    public void setFeeToPay(int feeToPay) {
        this.feeToPay = feeToPay;
    } */
}