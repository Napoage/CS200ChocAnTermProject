package com.example.demo;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/inProviderReport")
public class ProviderReport {
    @Autowired
    ProviderRepository providerRepository;
    @Autowired
    ServiceRecordRepository serviceRecordRepository;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    ChocAnServiceRepository serviceRepository;
    @PostMapping("/providerReport")
    public ResponseEntity<Integer> createProviderReport() {
        System.out.println("Creating provider report");
        List<Provider> listOfProviders = providerRepository.findAll();
        List<ServiceRecord> listOfServiceRecords = serviceRecordRepository.findAll();

        try (PrintWriter writer = new PrintWriter(new FileWriter("provider_report.txt"))) {
            for (Provider provider : listOfProviders) {
                writer.println("Provider Name: " + provider.getProviderName());
                writer.println("Provider ID: " + provider.getProviderID());
                writer.println("Provider Address: " + provider.getProviderAddress());
                writer.println("Provider City: " + provider.getProviderCity());
                writer.println("Provider State: " + provider.getProviderStateCode());
                writer.println("Provider ZIP: " + provider.getProviderZipCode());
                writer.println("Provider Email: " + provider.getProviderEmail());
                //TODO add provider services provided
                for(ServiceRecord serviceRecord : listOfServiceRecords) {
                    if(serviceRecord.getProviderNumber().equals(provider.getProviderID())) {
                        writer.println("Service Date: " + serviceRecord.getDate());
                        writer.println("Date and Time Received By Computer: " + serviceRecord.getTime());
                        Member member = memberRepository.findMemberByMemberID(serviceRecord.getMemberNumber());
                        writer.println("Member Name:" + member.getName());
                        writer.println("Member ID: " + member.getMemberID());
                        writer.println("Service Code: " + serviceRecord.getServiceCode());
                        ChocAnService service = serviceRepository.findChocAnServiceByServiceID(serviceRecord.getServiceCode());
                        writer.println("Fee to be paid: " + service.getFee());
                    }
                }
                writer.println("Total Number of Consultations with Members: " + provider.getTotalNumberOfConsultations());
                writer.println("Total Fee for Week: " + provider.getTotalFeeToBePaid());
                writer.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok(1);
    }
    
}
