package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.DiscriminatorValue;

@Entity
@DiscriminatorValue("OPERATOR")
public class Operator extends Employee {

    private int operatorID;
    private String operatorName;
    private String operatorUserName;
    private String operatorPassword;
    
    public Operator(String operatorName, String operatorUserName, String operatorPassword, int operatorID) {
        super(operatorUserName, operatorPassword, EmployeeType.OPERATOR);
        this.operatorName = operatorName;
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
