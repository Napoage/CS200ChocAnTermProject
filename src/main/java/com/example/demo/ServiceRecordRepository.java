package com.example.demo;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ServiceRecordRepository extends CrudRepository<ServiceRecord, Integer> {
    List<ServiceRecord> findAll();

    ServiceRecord findServiceRecordByid(int recordID);
    void deleteServiceRecordByid(int recordID);

    List<ServiceRecord> findServiceRecordByMemberNumber(String memberID);
    void deleteServiceRecordByMemberNumber(String memberID);

    List<ServiceRecord> findServiceRecordByProviderNumber(String providerID);
    void deleteServiceRecordByProviderNumber(String providerID);

    List<ServiceRecord> findServiceRecordByServiceCode(String serviceID);
    void deleteServiceRecordByServiceCode(String serviceID);

    List<ServiceRecord> findServiceRecordByDate(String serviceDate);
    void deleteServiceRecordByDate(String serviceDate);

    List<ServiceRecord> findServiceRecordByComments(String serviceComments);
    void deleteServiceRecordByComments(String serviceComments);
}
