package com.danielchristy.ErpAuditingApplication.controllers;

import com.danielchristy.ErpAuditingApplication.entities.Warehouse;
import com.danielchristy.ErpAuditingApplication.services.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {

    @Autowired
    private WarehouseService warehouseService;

    @GetMapping
    public List<Warehouse> getAllWarehouses() {
        return warehouseService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Warehouse> getWarehouseById(@PathVariable Long id) {
        Warehouse warehouse = warehouseService.findById(id);
        return warehouse != null ? ResponseEntity.ok(warehouse) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Warehouse createWarehouse(@RequestBody Warehouse warehouse) {
        return warehouseService.save(warehouse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Warehouse> updateWarehouse(@PathVariable Long id, @RequestBody Warehouse warehouse) {
        if (warehouseService.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        warehouse.setId(id);
        return ResponseEntity.ok(warehouseService.save(warehouse));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWarehouse(@PathVariable Long id) {
        warehouseService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
