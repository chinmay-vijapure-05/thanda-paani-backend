package com.example.inventory.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Inventory {

    @Id
    private Long id = 1L;
    private int totalBottles;
    private double balanceAmount;

    public Inventory(Long id, int totalBottles, double balanceAmount) {
        this.id = id;
        this.totalBottles = totalBottles;
        this.balanceAmount = balanceAmount;
    }

    public Inventory() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTotalBottles() {
        return totalBottles;
    }

    public void setTotalBottles(int totalBottles) {
        this.totalBottles = totalBottles;
    }

    public double getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(double balanceAmount) {
        this.balanceAmount = balanceAmount;
    }
}
