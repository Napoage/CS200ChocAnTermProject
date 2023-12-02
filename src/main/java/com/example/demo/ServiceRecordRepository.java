package com.example.demo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.ServiceRecord;

public interface ServiceRecordRepository extends CrudRepository<ServiceRecord, String>{
    
    ServiceRecord findByServiceId(String serviceId);
    void deleteByServiceId(String serviceId);

    List<ServiceRecord> findByMemberId(String memberId);
    void deleteByMemberId(String memberId);

    List<ServiceRecord> findByProviderId(String providerId);
    void deleteByProviderId(String providerId);

    List<ServiceRecord> findByDate(String date);
    void deleteByDate(String date);

    List<ServiceRecord> findByFee(String fee);
    void deleteByFee(String fee);

    List<ServiceRecord> findByComments(String comments);
    void deleteByComments(String comments);
    
}