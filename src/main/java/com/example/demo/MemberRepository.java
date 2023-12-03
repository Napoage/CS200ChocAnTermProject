package com.example.demo;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.Member;

public interface MemberRepository extends CrudRepository<Member, String>{
    
}