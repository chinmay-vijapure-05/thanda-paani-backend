package com.example.inventory.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantity;
    private double amountReceived;
    private LocalDate saleDate;

    public Sale(Long id, int quantity, double amountReceived, LocalDate saleDate) {
        this.id = id;
        this.quantity = quantity;
        this.amountReceived = amountReceived;
        this.saleDate = saleDate;
    }

    public Sale() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getAmountReceived() {
        return amountReceived;
    }

    public void setAmountReceived(double amountReceived) {
        this.amountReceived = amountReceived;
    }

    public LocalDate getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDate saleDate) {
        this.saleDate = saleDate;
    }


}
