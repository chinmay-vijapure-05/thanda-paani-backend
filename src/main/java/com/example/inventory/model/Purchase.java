package com.example.inventory.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantity;
    private double amountSpent;
    private LocalDate purchaseDate;

    public Purchase(Long id, int quantity, double amountSpent, LocalDate purchaseDate) {
        this.id = id;
        this.quantity = quantity;
        this.amountSpent = amountSpent;
        this.purchaseDate = purchaseDate;
    }

    public Purchase() {
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

    public double getAmountSpent() {
        return amountSpent;
    }

    public void setAmountSpent(double amountSpent) {
        this.amountSpent = amountSpent;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
}
