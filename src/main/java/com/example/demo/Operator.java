package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Operator {

    @Id
    private int operatorID;
    private String operatorName;
    private String operatorUserName;
    private String operatorPassword;
    
    public Operator(String operatorName, String operatorUserName, String operatorPassword, int operatorID) {
        this.operatorName = operatorName;
        this.operatorUserName = operatorUserName;
        this.operatorPassword = operatorPassword;
        this.operatorID = operatorID;
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
    public int getOperatorID() {
        return operatorID;
    }
}
