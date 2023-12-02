package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class ChocAnService {

    private String name;
    @Id
    private String code;
    private double fee;

    public ChocAnService(String name, String code, double fee) {
        this.name = name;
        this.code = code;
        this.fee = fee;
    }

    public ChocAnService() {
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public double getFee() {
        return fee;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        if (code.length() != 6) {
            throw new IllegalArgumentException("Code must be 6 digits");
        }
        this.code = code;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }
    
}
