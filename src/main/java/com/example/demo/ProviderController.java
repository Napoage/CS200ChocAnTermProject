package com.example.demo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
        double feeToBePaid = 0;
        System.out.println(bill.getMemberNumber() + ", " + bill.getProviderNumber() + ", " + bill.getServiceCode() + ", " + bill.getComments() + ", " + bill.getDateRecorded() + ", " + bill.getDateRecorded()); 
        ChocAnService service = new ChocAnService(); 
        Member member = memberRepository.findMemberByMemberID(bill.getMemberNumber());
        if (member == null) {
            System.out.println("Member not found");
            return ResponseEntity.ok(success);
        }
        service = serviceRepository.findChocAnServiceByServiceID(bill.getServiceCode());
        serviceRecordRepository.save(bill);
        Provider provider = providerRepository.findProviderByProviderID(bill.getProviderNumber());
        if (provider == null) {
            System.out.println("Provider not found");
            return ResponseEntity.ok(success);
        }
        feeToBePaid = service.getFee() + provider.getTotalFeeToBePaid();
        provider.setTotalFeeToBePaid(feeToBePaid);
        providerRepository.save(provider);
        List<ServiceRecord> testService = serviceRecordRepository.findServiceRecordByTime(bill.getTime());
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
            for (ChocAnService service : serviceRepository.findAll()) {
                writer.println("Service Name: " + service.getName());
                writer.println("Service Fee: " + service.getFee());
                writer.println("Service Code: " + service.getServiceID());
                writer.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.ok(success);
        }
        //TODO add provider directory
        return ResponseEntity.ok(1);
    } 
}
