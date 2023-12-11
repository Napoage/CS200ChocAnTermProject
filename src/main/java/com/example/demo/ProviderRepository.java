package com.example.demo;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.Provider;
import java.util.List;

public interface ProviderRepository extends CrudRepository<Provider, String>{
    List<Provider> findAll();

    Provider findProviderByProviderID(String providerid);
    void deleteProviderByProviderID(String providerid);

    List<Provider> findProviderByProviderName(String providerName);
    void deleteProviderByProviderName(String providerName);

    List<Provider> findProviderByProviderAddress(String providerAddress);
    void deleteProviderByProviderAddress(String providerAddress);

    List<Provider> findProviderByProviderCity(String providerCity);
    void deleteProviderByProviderCity(String providerCity);

    List<Provider> findProviderByProviderStateCode(String providerStateCode);
    void deleteProviderByProviderStateCode(String providerStateCode);

    List<Provider> findProviderByProviderZipCode(String providerZipCode);
    void deleteProviderByProviderZipCode(String providerZipCode);

    List<Provider> findProviderByProviderEmail(String providerEmail);
    void deleteProviderByProviderEmail(String providerEmail);

    List<Provider> findProviderByProviderStatus(boolean providerStatus);
    void deleteProviderByProviderStatus(boolean providerStatus);

    List<Provider> findProviderByUsername(String username);
    void deleteProviderByUsername(String username);

    List<Provider> findProviderByPassword(String password);
    void deleteProviderByPassword(String password);
}