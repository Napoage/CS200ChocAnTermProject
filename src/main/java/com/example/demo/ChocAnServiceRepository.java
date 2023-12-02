package com.example.demo;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.ChocAnService;

public interface ChocAnServiceRepository extends CrudRepository<ChocAnService, String>{
    ChocAnService findByServiceID(String serviceID);
    void deleteByServiceID(String serviceID);

    ChocAnService findByServiceName(String serviceName);
    void deleteByServiceName(String serviceName);

    ChocAnService findByServiceFee(String serviceFee);
    void deleteByServiceFee(String serviceFee);

}
