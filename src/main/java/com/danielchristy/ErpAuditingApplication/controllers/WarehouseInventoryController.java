package com.danielchristy.ErpAuditingApplication.controllers;

import com.danielchristy.ErpAuditingApplication.entities.WarehouseInventory;
import com.danielchristy.ErpAuditingApplication.services.WarehouseInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/warehouse-inventory")
public class WarehouseInventoryController {

    @Autowired
    private WarehouseInventoryService warehouseInventoryService;

    @GetMapping
    public List<WarehouseInventory> getAllWarehouseInventory() {
        return warehouseInventoryService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<WarehouseInventory> getWarehouseInventoryById(@PathVariable Long id) {
        WarehouseInventory warehouseInventory = warehouseInventoryService.findById(id);
        return warehouseInventory != null ? ResponseEntity.ok(warehouseInventory) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public WarehouseInventory createWarehouseInventory(@RequestBody WarehouseInventory warehouseInventory) {
        return warehouseInventoryService.save(warehouseInventory);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WarehouseInventory> updateWarehouseInventory(@PathVariable Long id, @RequestBody WarehouseInventory warehouseInventory) {
        if (warehouseInventoryService.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        warehouseInventory.setId(id);
        return ResponseEntity.ok(warehouseInventoryService.save(warehouseInventory));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWarehouseInventory(@PathVariable Long id) {
        warehouseInventoryService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

