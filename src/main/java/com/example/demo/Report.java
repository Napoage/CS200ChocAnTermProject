package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.PrePersist;

@Entity
public class Report {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq")
    @SequenceGenerator(name = "employee_seq", sequenceName = "custom_employee_seq", initialValue = 1, allocationSize = 1)
    private int id;

    @Id
    @Column(length = 9)
    private String reportID;

    private String patientId;
    private String providerId;
    private String operatorId;
    private String report;
    private String date;

    public Report(String patientId, String providerId, String operatorId, String report, String date) {
        this.patientId = patientId;
        this.providerId = providerId;
        this.operatorId = operatorId;
        this.report = report;
        this.date = date;
    }

    public Report() {
    }

    // public String getReportId() {
    //     return this.reportId;
    // }

    // public void setReportId(String reportId) {
    //     this.reportId = reportId;
    // }

    public String getPatientId() {
        return this.patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getProviderId() {
        return this.providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public String getOperatorId() {
        return this.operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getReport() {
        return this.report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @PrePersist
    public void generateReportID() {
        this.reportID = String.format("%09d", id);
    }
}
