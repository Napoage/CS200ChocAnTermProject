package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.transaction.annotation.Transactional;


@RestController
@RequestMapping("/api/operator")
public class OperatorController {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private ProviderRepository providerRepository;

    @PostMapping("/addMember")
    public ResponseEntity<Integer> addMemberCall(
    @RequestParam String name,
    @RequestParam String email,
    @RequestParam String address,
    @RequestParam String city,
    @RequestParam String state,
    @RequestParam String zipCode) {
        int success = 0;
        System.out.println(name + ", " + email + ", " + address + ", " + city + ", " + state + ", " + zipCode);
        Member member = new Member(name, email, address, city, state, zipCode);
        member.generateMemberID();
        member.setStatus(true);
        System.out.println(member.getMemberID() + ", " + member.getName() + ", " + member.getEmail() + ", " + member.getStreetAddress() + ", " + ", " + member.getMemberState() + ", " + member.getCity() + member.getZipCode() + ", " + member.isStatus());
        memberRepository.save(member);
        Member testMember = memberRepository.findMemberByMemberID(member.getMemberID());
        if (testMember != null) {
            success = Integer.parseInt(testMember.getMemberID());
            System.out.println("Member added successfully");
            System.out.println(memberRepository.findAll());
            
            return ResponseEntity.ok(success);
        }
        return ResponseEntity.ok(success);
    }
    @PostMapping("/removeMember")
    @Transactional
    public ResponseEntity<Integer> removeMemberCall(@RequestParam String memberID) {
        int success = 0;
        memberRepository.deleteMemberByMemberID(memberID);
        Member testMember = memberRepository.findMemberByMemberID(memberID);
        if (testMember == null) {
            success = 1;
            System.out.println("Member removed successfully");
            System.out.println(memberRepository.findAll());
            return ResponseEntity.ok(success);
        }
        return ResponseEntity.ok(success);
    }
 
    @PostMapping("/editMember")
    public ResponseEntity<Integer> editMemberCall(
    @RequestParam String memberID,
    @RequestParam String name,
    @RequestParam String email,
    @RequestParam String address,
    @RequestParam String city,
    @RequestParam String state,
    @RequestParam String zipCode) {
        int success = 0;
        Member member = memberRepository.findMemberByMemberID(memberID);
        if (member != null) {
            member.setName(name);
            member.setEmail(email);
            member.setStreetAddress(address);
            member.setCity(city);
            member.setMemberState(state);
            member.setZipCode(zipCode);
            memberRepository.save(member);
            success = 1;
            System.out.println("Member edited successfully");
            System.out.println(memberRepository.findAll());
            return ResponseEntity.ok(success);
        }
        return ResponseEntity.ok(success);
  }
    @PostMapping("/addProvider")
    public ResponseEntity<Integer> addProviderCall(@RequestBody Provider provider) { 
        provider.generateProviderID();
        provider.setProviderStatus(true);
        System.out.println(provider.getProviderID() + ", " + provider.getProviderName() + ", " + provider.getProviderAddress() + ", " + provider.getProviderCity() + ", " + provider.getProviderStateCode() + ", " + provider.getProviderZipCode() + ", " + provider.getProviderEmail() + ", " + provider.getUsername() + ", " + provider.getPassword());
        providerRepository.save(provider);
        Provider testProvider = providerRepository.findProviderByProviderID(provider.getProviderID());
        if (testProvider != null) {
            int success = Integer.parseInt(testProvider.getProviderID());
            System.out.println("Provider added successfully");
            System.out.println(providerRepository.findAll());
            return ResponseEntity.ok(success);
        }
        int success = 0;
        return ResponseEntity.ok(success);
    }

    @PostMapping("/removeProvider")
    public ResponseEntity<Integer> removeProviderCall(@RequestBody int providerID) {
        int success = 1;
        return ResponseEntity.ok(success);
    }
    @PostMapping("/editProvider")
    public ResponseEntity<Integer> editProviderCall(@RequestBody Provider provider) {
        int success = 1;
        return ResponseEntity.ok(success);
    }

    @PostMapping("/addOperator")
    public ResponseEntity<Integer> addOperatorCall(@RequestBody Operator operator) {
        int success = 1;
        return ResponseEntity.ok(success);
    }

    @PostMapping("/removeOperator")
    public ResponseEntity<Integer> removeOperatorCall(@RequestBody int operatorID) {
        int success = 1;
        return ResponseEntity.ok(success);
    }

    @PostMapping("/editOperator")
    public ResponseEntity<Integer> editOperatorCall(@RequestBody Operator operator) {
        int success = 1;
        return ResponseEntity.ok(success);
    }

    @PostMapping("/addManager")
    public ResponseEntity<Integer> addManagerCall(@RequestBody Manager manager) {
        int success = 1;
        return ResponseEntity.ok(success);
    }

    @PostMapping("/removeManager")
    public ResponseEntity<Integer> removeManagerCall(@RequestBody int managerID) {
        int success = 1;
        return ResponseEntity.ok(success);
    }
 
    @PostMapping("/editManager")
    public ResponseEntity<Integer> editManagerCall(@RequestBody Manager manager) {
        int success = 1;
        return ResponseEntity.ok(success);
    }
} 