package com.danielchristy.ErpAuditingApplication.services;

import com.danielchristy.ErpAuditingApplication.entities.WarehouseInventory;
import com.danielchristy.ErpAuditingApplication.repositories.WarehouseInventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseInventoryService {

    @Autowired
    private WarehouseInventoryRepository warehouseInventoryRepository;

    public List<WarehouseInventory> findAll() {
        return warehouseInventoryRepository.findAll();
    }

    public WarehouseInventory findById(Long id) {
        return warehouseInventoryRepository.findById(id).orElse(null);
    }

    public WarehouseInventory save(WarehouseInventory warehouseInventory) {
        return warehouseInventoryRepository.save(warehouseInventory);
    }

    public void deleteById(Long id) {
        warehouseInventoryRepository.deleteById(id);
    }
}
