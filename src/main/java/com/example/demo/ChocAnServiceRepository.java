package com.example.demo;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ChocAnServiceRepository extends CrudRepository<ChocAnService, String>{
    List<ChocAnService> findAll();
    
    ChocAnService findChocAnServiceByServiceID(String serviceID);
    void deleteChocAnServiceByServiceID(String serviceID);

    List<ChocAnService> findChocAnServiceByName(String serviceName);
    void deleteChocAnServiceByName(String serviceName);

    List<ChocAnService> findChocAnServiceByFee(double serviceFee);
    void deleteChocAnServiceByFee(double serviceFee);
}
