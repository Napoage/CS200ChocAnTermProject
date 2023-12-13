package com.example.demo;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Member;
import com.example.demo.MemberRepository;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/api/manager")
public class MemberReport {
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    ServiceRecordRepository chocAnServiceRepository;
    @Autowired
    ProviderRepository providerRepository;
    
    @PostMapping("/reader")   
    public ResponseEntity<Integer> createMemberReport() {
        System.out.println("Creating member report");
        List<Member> listOfMembers = memberRepository.findAll();
        List<ServiceRecord> listOfServiceRecords = chocAnServiceRepository.findAll();
        
        try (PrintWriter writer = new PrintWriter(new FileWriter("member_report.txt"))) {
            for (Member member : listOfMembers) {
                writer.println("Member Name: " + member.getName());
                writer.println("Member ID: " + member.getMemberID());
                writer.println("Member Address: " + member.getStreetAddress());
                writer.println("Member City: " + member.getCity());
                writer.println("Member State: " + member.getMemberState());
                writer.println("Member ZIP: " + member.getZipCode());
                writer.println("Member Email: " + member.getEmail());
                //TODO add member services recieved
                for(ServiceRecord serviceRecord : listOfServiceRecords) {
                    if(serviceRecord.getMemberNumber().equals(member.getMemberID())) {
                        writer.println("Service Date: " + serviceRecord.getDate());
                        Provider provider = providerRepository.findProviderByProviderID(serviceRecord.getProviderNumber());
                        writer.println("Provider Name: " + provider.getProviderName());
                        writer.println("Service Name: Test Service");
                    }
                }
                writer.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(1);
    }
}
