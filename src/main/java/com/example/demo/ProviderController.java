package com.example.demo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/provider")
public class ProviderController {
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private ProviderRepository providerRepository;
    @Autowired
    private ChocAnServiceRepository serviceRepository;
    @Autowired
    private ServiceRecordRepository serviceRecordRepository;

    @PostMapping("/billChocAn") 
    public ResponseEntity<Integer> billChocAn (@RequestBody ServiceRecord bill) {
        int success = 0;
        System.out.println(bill.getMemberNumber() + ", " + bill.getProviderNumber() + ", " + bill.getServiceCode() + ", " + bill.getComments() + ", " + bill.getDateRecorded() + ", " + bill.getDateRecorded()); 
        ChocAnService service = new ChocAnService(); 
        service.setFee(10.0);
        service.setName("Test Service");
        service.setServiceID("123456");
        serviceRecordRepository.save(bill);
        //TODO add member validation
        Provider provider = providerRepository.findProviderByProviderID(bill.getProviderNumber());
        provider.setTotalFeeToBePaid(provider.getTotalFeeToBePaid() + /*service.getFee()*/ 10.0);
        providerRepository.save(provider);
        ServiceRecord testService = serviceRecordRepository.findServiceRecordByid(1);
        if (testService != null) {
            success = 1;
            System.out.println("Service added successfully");
            System.out.println(serviceRepository.findAll());
            return ResponseEntity.ok(success);
        }
        return ResponseEntity.ok(success);
    }

    @PostMapping("/requestProviderDirectory")
    public ResponseEntity<Integer> requestProviderDirectoryCall() {
        int success = 0;
        System.out.println("Requesting provider directory");
        try (PrintWriter writer = new PrintWriter(new FileWriter("provider_directory.txt"))) {
            writer.println("Provider Directory");
            writer.println("Service Code: 123456");
            writer.println("Service Name: Test Service");
            writer.println("Service Fee: $10.00");
            writer.println();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        //TODO add provider directory
        return ResponseEntity.ok(1);
    }

   /*  public ResponseEntity<Integer> editProviderCall(@RequestBody Provider provider1) {
        int success = 0;
        System.out.println(provider1.getProviderID() + ", " + provider1.getProviderName() + ", " + provider1.getProviderAddress() + ", " + provider1.getProviderCity() + ", " + provider1.getProviderStateCode() + ", " + provider1.getProviderZipCode() + ", " + provider1.getProviderEmail() + ", " + provider1.getUsername() + ", " + provider1.getPassword());
        Provider provider2 = providerRepository.findProviderByProviderID(provider1.getProviderID());
        if (provider2 != null) {
            providerRepository.save(provider1);
            success = 1;
            System.out.println("Member edited successfully");
            System.out.println(memberRepository.findAll());
            return ResponseEntity.ok(success);
        }
        return ResponseEntity.ok(success);
    }*/
    
}
