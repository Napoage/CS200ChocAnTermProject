package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Table;

import java.util.Random;

import jakarta.persistence.Column;

@Entity
//@Table(name = "Providers")
public class Provider {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq")
    @SequenceGenerator(name = "employee_seq", sequenceName = "custom_employee_seq", initialValue = 1, allocationSize = 1)
    //@Transient
    private int id;
    // Define fields for providerName, providerAddress, etc.
    @Id
    @Column(name = "providerid", length = 9)
    private String providerID;
    @Column(name ="provider_name",length = 25)
    private String providerName;
    @Column(name = "provider_address",length = 25)
    private String providerAddress;
    @Column(name = "provider_city",length = 14)
    private String providerCity;
    @Column(name = "provider_state_code",length = 2)
    private String providerStateCode;
    @Column(name = "provider_zip_code",length = 5)
    private String providerZipCode;
    @Column(name = "provider_email")
    private String providerEmail;
    @Column(name = "provider_status")
    private boolean providerStatus;
    @Column(name = "username", length = 25)
    private String username;
    @Column(name = "password", length = 25)
    private String password;
    @Column(name = "total_fee_to_be_paid")
    private double totalFeeToBePaid = 0.0;
    @Column(name = "total_number_of_consultations")
    private int totalNumberOfConsultations = 0;
    
    public Provider() {
        // Initialize any default values if needed
    }
    // Constructor to initialize the fields
    public Provider(String providerName, String providerAddress, String providerCity, String providerStateCode, String providerZipCode, String providerEmail, String providerUserName, String providerPassword) {
        this.providerName = providerName;
        this.providerAddress = providerAddress;
        this.providerCity = providerCity;
        this.providerStateCode = providerStateCode;
        this.providerZipCode = providerZipCode;
        this.providerEmail = providerEmail;
        this.username = providerUserName;
        this.password = providerPassword;
        generateProviderID();
        this.providerStatus = true;
        this.totalFeeToBePaid = 0;

    }

    public String getProviderName() {
        return providerName;
    }
    public String getProviderAddress() {
        return providerAddress;
    }
    public String getProviderCity() {
        return providerCity;
    }
    public String getProviderStateCode() {
        return providerStateCode;
    }
    public String getProviderZipCode() {
        return providerZipCode;
    }
    public String getProviderEmail() {
        return providerEmail;
    }
    public boolean getProviderStatus() {
        return providerStatus;
    }

    // Setters for the fields
    public void setProviderStatus(boolean providerStatus) {
        this.providerStatus = providerStatus;
    }
    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }
    public void setProviderAddress(String providerAddress) {
        this.providerAddress = providerAddress;
    }
    public void setProviderCity(String providerCity) {
        this.providerCity = providerCity;
    }
    public void setProviderStateCode(String providerStateCode) {
        this.providerStateCode = providerStateCode;
    }
    public void setProviderZipCode(String providerZipCode) {
        this.providerZipCode = providerZipCode;
    }
    public void setProviderEmail(String providerEmail) {
        this.providerEmail = providerEmail;
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
    public String getProviderID() {
        return providerID;
    }
    public void setProviderID(String providerID) {
        this.providerID = providerID;
    }
    @PrePersist
    public void beforePersist() {
        // Ensure providerID is set before persisting
        generateProviderID();
        this.providerStatus = true;
        //this.em = true; // Assuming new members are active by default
    }
    public void generateProviderID() {
        Random rand = new Random();
        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((999999999 - 100000000) + 1) + 100000000;
        this.providerID = Integer.toString(randomNum);
    }
    public double getTotalFeeToBePaid() {
        return totalFeeToBePaid;
    }
    public void setTotalFeeToBePaid(double totalFeeToBePaid) {
        this.totalFeeToBePaid =  totalFeeToBePaid;
    }
    public int getTotalNumberOfConsultations() {
        return totalNumberOfConsultations;
    }
    public void setTotalNumberOfConsultations(int totalNumberOfConsultations) {
        this.totalNumberOfConsultations = totalNumberOfConsultations;
    }

    
}
