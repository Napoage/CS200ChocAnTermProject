package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {

    @Id
    String username;
    String password;
	enum employeeType {
        OPERATOR,
        MANAGER,
        PROVIDER
    }

}