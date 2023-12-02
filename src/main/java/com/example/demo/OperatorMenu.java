package com.example.demo;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/operator")
public class OperatorMenu {

    //final level methods call updateMember() and updateEmployee();
    //once member is added prompt to add another member or return to first menu
    /*@Autowired
    private UpdateMember updateMemberService;
    @Autowired
    private UpdateProvider updateProviderServices;
    @Autowired
    private UpdateManager updateManagerServices;
    @Autowired
    private UpdateOperator updateOperatorServices;*/

    @PostMapping("/addMember")
    public ResponseEntity<Integer> addMemberCall(@RequestBody Member member) {
        int success = 0;
        return ResponseEntity.ok(success);
    }
/*
    @PostMapping("/removeMember")
    public ResponseEntity<Integer> removeMemberCall(@RequestBody int memberID) {
        int success = updateMemberService.removeMember(memberID);
        return ResponseEntity.ok(success);
    }

    @PostMapping("/editMember")
    public ResponseEntity<Integer> editMemberCall(@RequestBody Member member) {
        int success = updateMemberService.editMember(member);
        return ResponseEntity.ok(success);
    }

    @PostMapping("/addProvider")
    public ResponseEntity<Integer> addProviderCall(@RequestBody Provider provider) {
        int success = updateProviderServices.addProvider(provider);
        return ResponseEntity.ok(success);
    }

    @PostMapping("/removeProvider")
    public ResponseEntity<Integer> removeProviderCall(@RequestBody int providerID) {
        int success = updateProviderServices.removeProvider(providerID);
        return ResponseEntity.ok(success);
    }

    @PostMapping("/editProvider")
    public ResponseEntity<Integer> editProviderCall(@RequestBody Provider provider) {
        int success = updateProviderServices.editProvider(provider);
        return ResponseEntity.ok(success);
    }*/

    @PostMapping("/addOperator")
    public ResponseEntity<Integer> addOperatorCall(@RequestBody Operator operator) {
        int success = 1;
        return ResponseEntity.ok(success);
    }

    /*@PostMapping("/removeOperator")
    public ResponseEntity<Integer> removeOperatorCall(@RequestBody int operatorID) {
        int success = updateOperatorServices.removeOperator(operatorID);
        return ResponseEntity.ok(success);
    }

    @PostMapping("/editOperator")
    public ResponseEntity<Integer> editOperatorCall(@RequestBody Operator operator) {
        int success = updateOperatorServices.editOperator(operator);
        return ResponseEntity.ok(success);
    }*/

    @PostMapping("/addManager")
    public ResponseEntity<Integer> addManagerCall(@RequestBody Manager manager) {
        int success = 1;
        return ResponseEntity.ok(success);
    }
/* 
    @PostMapping("/removeManager")
    public ResponseEntity<Integer> removeManagerCall(@RequestBody int managerID) {
        int success = updateManagerServices.removeManager(managerID);
        return ResponseEntity.ok(success);
    }

    @PostMapping("/editManager")
    public ResponseEntity<Integer> editManagerCall(@RequestBody Manager manager) {
        int success = updateManagerServices.editManager(manager);
        return ResponseEntity.ok(success);
    }*/
} 