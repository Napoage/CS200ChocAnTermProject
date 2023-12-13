package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/login")
public class AccountingProcedure {
    @Autowired
    private MemberReport memberReport;
    @Autowired
    private ProviderReport providerReport;
    @Autowired
    private SummaryReport summaryReport;

    @GetMapping("/runMainAccountingProcedure")
    public void runMainAccountingProcedure() {
        System.out.println("Running main accounting procedure");
        memberReport.createMemberReport();
        providerReport.createProviderReport();
        summaryReport.createSummaryReport();
    }
    
    
}
