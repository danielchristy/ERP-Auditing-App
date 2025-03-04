package com.danielchristy.ErpAuditingApplication.repositories;

import com.danielchristy.ErpAuditingApplication.entities.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
}
