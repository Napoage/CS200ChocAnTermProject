package com.example.demo;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.Provider;

public interface ProviderRepository extends CrudRepository<Employee, String>{
    
}