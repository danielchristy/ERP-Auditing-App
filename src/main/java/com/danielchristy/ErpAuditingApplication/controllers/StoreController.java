package com.danielchristy.ErpAuditingApplication.controllers;

import com.danielchristy.ErpAuditingApplication.entities.Store;
import com.danielchristy.ErpAuditingApplication.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/store")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @GetMapping
    public List<Store> getAllStores() {
        return storeService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Store> getStoreById(@PathVariable Long id) {
        return storeService.findById(id)
                .map(ResponseEntity::ok).
                orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Store createStore(@RequestBody Store store) {
        return storeService.save(store);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Store> updateStore(@PathVariable Long id, @RequestBody Store store) {
        if (storeService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        store.setId(id);
        return ResponseEntity.ok(storeService.save(store));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStore(@PathVariable Long id) {
        storeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
