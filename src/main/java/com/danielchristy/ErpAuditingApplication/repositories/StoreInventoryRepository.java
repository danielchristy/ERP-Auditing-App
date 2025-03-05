package com.danielchristy.ErpAuditingApplication.repositories;

import com.danielchristy.ErpAuditingApplication.entities.StoreInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreInventoryRepository extends JpaRepository<StoreInventory, Long> {
}
