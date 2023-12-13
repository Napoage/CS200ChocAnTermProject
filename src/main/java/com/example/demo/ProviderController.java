package com.example.demo;

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
        ChocAnService service; 
        service = serviceRepository.findChocAnServiceByServiceID(bill.getServiceCode());
        serviceRecordRepository.save(bill);
        //TODO add fee for the week and number of consultations with members to provider class and update them here 
        Provider provider = providerRepository.findProviderByProviderID(bill.getProviderNumber());
        provider.setTotalFeeToBePaid(provider.getTotalFeeToBePaid() + service.getFee());
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
    
}
