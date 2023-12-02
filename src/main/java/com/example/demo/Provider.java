package com.example.demo;

public class Provider {
    // Define fields for providerName, providerAddress, etc.
    private String providerName;
    private String providerAddress;
    private String providerCity;
    private String providerStateCode;
    private String providerZipCode;
    private String providerEmail;

    // Constructor to initialize the fields
    public Provider(String providerName, String providerAddress, String providerCity, String providerStateCode, String providerZipCode, String providerEmail, int providerID, String providerUserName, String providerPassword) {
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
}
