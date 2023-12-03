package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "Providers")
public class Provider extends Employee{
    // Define fields for providerName, providerAddress, etc.
    @Column(length = 25)
    private String providerName;
    @Column(length = 25)
    private String providerAddress;
    @Column(length = 14)
    private String providerCity;
    @Column(length = 2)
    private String providerStateCode;
    @Column(length = 5)
    private String providerZipCode;
    private String providerEmail;

    // Constructor to initialize the fields
    public Provider(String providerName, String providerAddress, String providerCity, String providerStateCode, String providerZipCode, String providerEmail, int providerID, String providerUserName, String providerPassword) {
        super(providerUserName, providerPassword, EmployeeType.PROVIDER);
        this.providerName = providerName;
        this.providerAddress = providerAddress;
        this.providerCity = providerCity;
        this.providerStateCode = providerStateCode;
        this.providerZipCode = providerZipCode;
        this.providerEmail = providerEmail;
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

    // Setters for the fields
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

    
}
