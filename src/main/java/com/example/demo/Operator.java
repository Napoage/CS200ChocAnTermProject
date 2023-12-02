package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Table;

@Entity
@Table(name = "Operators")
public class Operator extends Employee {

    private String operatorName;
    private String operatorUserName;
    private String operatorPassword;
    
    public Operator(String operatorName, String operatorUserName, String operatorPassword, int operatorID) {
        super(operatorUserName, operatorPassword, EmployeeType.OPERATOR);
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
