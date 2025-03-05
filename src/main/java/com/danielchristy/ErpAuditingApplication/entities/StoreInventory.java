package com.danielchristy.ErpAuditingApplication.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "store_inventory")
public class StoreInventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "store_location_id")
    private Store store;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    private int quantity;

    public StoreInventory() {}

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Store getStore() {
        return store;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }


}
