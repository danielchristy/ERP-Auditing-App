package com.danielchristy.ErpAuditingApplication.controllers;

import com.danielchristy.ErpAuditingApplication.entities.Item;
import com.danielchristy.ErpAuditingApplication.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping
    public List<Item> getAllItems() {
        return itemService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable Long id) {
        Item item = itemService.findById(id);
        return item != null ? ResponseEntity.ok(item) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Item createItem(@RequestBody Item item) {
        return itemService.save(item);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable Long id, @RequestBody Item item) {
        if (itemService.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        item.setId(id);
        return ResponseEntity.ok(itemService.save(item));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        itemService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
