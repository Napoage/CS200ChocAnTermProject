package com.example.demo;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.Operator;

public interface OperatorRepository extends CrudRepository<Employee, String>{
    
}