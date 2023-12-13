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
@RequestMapping("/api/inSummaryReport")
public class SummaryReport {
    @Autowired
    ProviderRepository providerRepository;
    @Autowired
    ServiceRecordRepository chocAnServiceRepository;
    @Autowired
    MemberRepository memberRepository;
    @PostMapping("/summaryReport")
    public ResponseEntity<Integer> createSummaryReport() {
        System.out.println("Creating summary report");
        List<Provider> listOfProviders = providerRepository.findAll();
        List<ServiceRecord> listOfServiceRecords = chocAnServiceRepository.findAll();
        List<Member> listOfMembers = memberRepository.findAll();
        int totalNumberOfProvidersProvidingService = 0;
        int totalNumberOfConsultations = 0;
        double totalFeeForWeek = 0;
        try(PrintWriter writer = new PrintWriter(new FileWriter("summary_report.txt"))) {
            for (Provider provider : listOfProviders) {
                if(provider.getTotalFeeToBePaid() > 0) {
                    writer.println("Provider Name: " + provider.getProviderName());
                    writer.println("Number Of Consultations: " + provider.getTotalNumberOfConsultations());
                    totalNumberOfProvidersProvidingService++;
                    totalNumberOfConsultations += provider.getTotalNumberOfConsultations();
                    totalFeeForWeek += provider.getTotalFeeToBePaid();
                }
            }
            writer.println("Total Number of Providers who provided services: " + totalNumberOfProvidersProvidingService);
            writer.println("Total Number of Consultations: " + totalNumberOfConsultations);
            writer.println("Total Fee for Week: " + totalFeeForWeek);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(1);
    }
    
}
