package com.danielchristy.ErpAuditingApplication.services;

import com.danielchristy.ErpAuditingApplication.entities.StoreInventory;
import com.danielchristy.ErpAuditingApplication.repositories.StoreInventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreInventoryService {

    @Autowired
    private StoreInventoryRepository storeInventoryRepository;

    public List<StoreInventory> findAll() {
        return storeInventoryRepository.findAll();
    }

    public StoreInventory findById(Long id) {
        return storeInventoryRepository.findById(id).orElse(null);
    }

    public StoreInventory save(StoreInventory storeInventory) {
        return storeInventoryRepository.save(storeInventory);
    }

    public void deleteById(Long id) {
        storeInventoryRepository.deleteById(id);
    }
}

