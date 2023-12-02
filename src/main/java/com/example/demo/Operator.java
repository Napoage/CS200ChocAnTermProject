package com.example.demo;
public class Operator {
    private String operatorName;
    private String operatorUserName;
    private String operatorPassword;
    private int operatorID;
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
