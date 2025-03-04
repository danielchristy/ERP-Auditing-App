package com.danielchristy.ErpAuditingApplication.services;

import com.danielchristy.ErpAuditingApplication.entities.Store;
import com.danielchristy.ErpAuditingApplication.repositories.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;

    public List<Store> findAll() {
        return storeRepository.findAll();
    }

    public Store findById(Long id) {
        return storeRepository.findById(id).orElse(null);
    }

    public Store save(Store store) {
        return storeRepository.save(store);
    }

    public void deleteById(Long id) {
        storeRepository.deleteById(id);
    }
}
