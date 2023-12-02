package com.example.demo;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, String>{
    
}
