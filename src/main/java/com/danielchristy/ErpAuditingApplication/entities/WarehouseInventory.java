package com.danielchristy.ErpAuditingApplication.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "warehouse_inventory")
public class WarehouseInventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "warehouse_location_id")
    private Warehouse warehouse;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    private int quantity;

    public WarehouseInventory() {}

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public Warehouse getWarehouse() {
        return warehouse;
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
