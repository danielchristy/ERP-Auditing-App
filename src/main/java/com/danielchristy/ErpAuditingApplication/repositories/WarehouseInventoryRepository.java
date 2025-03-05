package com.danielchristy.ErpAuditingApplication.repositories;

import com.danielchristy.ErpAuditingApplication.entities.WarehouseInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseInventoryRepository extends JpaRepository<WarehouseInventory, Long> {
}

