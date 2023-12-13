package com.example.demo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter; 

@Entity
public class ServiceRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "service_seq")
    @SequenceGenerator(name = "service_seq", sequenceName = "custom_service_seq", initialValue = 1, allocationSize = 1)
    private int id;

    @Column(name = "date_provided", length = 10)
    private String date;
    @Column(name = "date", length = 10)
    private String dateRecorded;
    @Column(name = "provider_number", length = 9)
    private String providerNumber;
    @Column(name = "member_number", length = 9)
    private String memberNumber;
    @Column(name = "service_code", length = 6)
    private String serviceCode;
    @Column(name = "comments", length = 100)
    private String comments;
     @Column(name = "time", length = 20)
    private String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

    public ServiceRecord() {
    }
    public ServiceRecord(String date, String dateRecorded, String providerNumber, String memberNumber, String serviceCode, String comments) {
        this.date = date;
        this.dateRecorded = dateRecorded;
        this.providerNumber = providerNumber;
        this.memberNumber = memberNumber;
        this.serviceCode = serviceCode;
        this.comments = comments;
    }
    public String getDate() {
        return date;
    }
    public String getDateRecorded() {
        return dateRecorded;
    }
    public String getProviderNumber() {
        return providerNumber;
    }
    public String getMemberNumber() {
        return memberNumber;
    }
    public String getServiceCode() {
        return serviceCode;
    }
    public String getComments() {
        return comments;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public void setDateRecorded(String dateRecorded) {
        this.dateRecorded = dateRecorded;
    }
    public void setProviderNumber(String providerNumber) {
        this.providerNumber = providerNumber;
    }
    public void setMemberNumber(String memberNumber) {
        this.memberNumber = memberNumber;
    }
    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }
    public void setComments(String comments) {
        this.comments = comments;
    }
}
