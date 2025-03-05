package com.danielchristy.ErpAuditingApplication.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "invoice")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String invoiceNumber;
    private String invoicePurchaseDate;

    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;

    private BigDecimal tax;
    private BigDecimal deliveryFee;
    private BigDecimal invoiceTotal;
    private String paymentStatus;


    public Invoice() {}

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoicePurchaseDate(String invoicePurchaseDate) {
        this.invoicePurchaseDate = invoicePurchaseDate;
    }

    public String getInvoicePurchaseDate() {
        return invoicePurchaseDate;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setDeliveryFee(BigDecimal deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public BigDecimal getDeliveryFee() {
        return deliveryFee;
    }

    public void setInvoiceTotal(BigDecimal invoiceTotal) {
        this.invoiceTotal = invoiceTotal;
    }

    public BigDecimal getInvoiceTotal() {
        return invoiceTotal;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

}
