package com.danielchristy.ErpAuditingApplication.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ein;
    private String name;
    private BigDecimal totalAssets;


    public Company() {}

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setEin(String ein) {
        this.ein = ein;
    }

    public String getEin() {
        return ein;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setTotalAssets(BigDecimal totalAssets) {
        this.totalAssets = totalAssets;
    }

    public BigDecimal getTotalAssets() {
        return totalAssets;
    }

}
