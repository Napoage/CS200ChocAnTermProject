package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Table;

@Entity
@Table(name = "Operators")
public class Operator {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq")
    @SequenceGenerator(name = "employee_seq", sequenceName = "custom_employee_seq", initialValue = 1, allocationSize = 1)
    //@Transient
    private int id;

    @Id
    @Column(name = "operatorid", length = 9)
    private String operatorID;
    private String operatorName;
    private String operatorUserName;
    private String operatorPassword;
    
    public Operator(String operatorName, String operatorUserName, String operatorPassword, int operatorID) {
        this.operatorName = operatorName;
    }
    public String getOperatorName() {
        return operatorName;
    }
    public String getOperatorUserName() {
        return operatorUserName;
    }
    public String getOperatorPassword() {
        return operatorPassword;
    }
}
