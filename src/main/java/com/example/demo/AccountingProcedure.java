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

    MemberReport memberReport = new MemberReport();
    ProviderReport providerReport = new ProviderReport();
    SummaryReport summaryReport = new SummaryReport();

    @GetMapping("/runMainAccountingProcedure")
    public void runMainAccountingProcedure() {
        //TODO: Implement this run main accounting procedure when finish other report methods
    }
    
    
}
