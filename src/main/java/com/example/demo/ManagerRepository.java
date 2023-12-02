package com.example.demo;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.Manager;

public interface ManagerRepository extends CrudRepository<Manager, String>{
    
}
