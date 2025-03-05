package com.danielchristy.ErpAuditingApplication.controllers;

import com.danielchristy.ErpAuditingApplication.entities.StoreInventory;
import com.danielchristy.ErpAuditingApplication.services.StoreInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/store-inventory")
public class StoreInventoryController {

    @Autowired
    private StoreInventoryService storeInventoryService;

    @GetMapping
    public List<StoreInventory> getAllStoreInventory() {
        return storeInventoryService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StoreInventory> getStoreInventoryById(@PathVariable Long id) {
        StoreInventory storeInventory = storeInventoryService.findById(id);
        return storeInventory != null ? ResponseEntity.ok(storeInventory) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public StoreInventory createStoreInventory(@RequestBody StoreInventory storeInventory) {
        return storeInventoryService.save(storeInventory);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StoreInventory> updateStoreInventory(@PathVariable Long id, @RequestBody StoreInventory storeInventory) {
        if (storeInventoryService.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        storeInventory.setId(id);
        return ResponseEntity.ok(storeInventoryService.save(storeInventory));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStoreInventory(@PathVariable Long id) {
        storeInventoryService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
