package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class ServiceRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.DATE)
    private String date;
    @Temporal(TemporalType.TIME)
    private String time;
    @Column(length = 8)
    private String dateProvided;
    @Column(length = 9)
    private String providerId;
    @Column(length = 9)
    private String memberId;
    @Column(length = 6)
    private String serviceCode;
    @Column(length = 100)
    private String comments;

    public ServiceRecord(String date, String time, String dateProvided, String providerId, String memberId, String serviceCode, String comments) {
        this.date = date;
        this.time = time;
        this.dateProvided = dateProvided;
        this.providerId = providerId;
        this.memberId = memberId;
        this.serviceCode = serviceCode;
        this.comments = comments;
    }
    
    public Long getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
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
    
    public void setTime(String time) {
        this.time = time;
    }
    
    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
    
}
