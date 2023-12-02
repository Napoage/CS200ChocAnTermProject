package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.beans.Transient;

import jakarta.persistence.Column;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.PrePersist;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "report_type", discriminatorType = DiscriminatorType.STRING)
public class Report {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "report_seq")
    @SequenceGenerator(name = "report_seq", sequenceName = "custom_report_seq", initialValue = 1, allocationSize = 1)
    @Transient
    private int id;

    @Id
    @Column(length = 9)
    private String reportID;

    private String patientId;
    private String providerId;
    @Column(name = "report_type", insertable = false, updatable = false)
    private ReportType reportType;
    private String date;

    public Report(String patientId, String providerId, String date, ReportType reportType) {
        this.patientId = patientId;
        this.providerId = providerId;
        this.date = date;
        this.reportType = reportType;
    }

    public Report() {
    }

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

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ReportType getReportType() {
        return this.reportType;
    }

    public void setReportType(ReportType reportType) {
        this.reportType = reportType;
    }

    public enum ReportType {
        SUMMARY,
        PROVIDER,
        MEMBER,
        MANAGER
    }

    @PrePersist
    public void generateReportID() {
        this.reportID = String.format("%09d", id);
    }
}
