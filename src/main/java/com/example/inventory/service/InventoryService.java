package com.example.inventory.service;

import com.example.inventory.model.Inventory;
import com.example.inventory.model.Purchase;
import com.example.inventory.model.Sale;
import com.example.inventory.repository.InventoryRepository;
import com.example.inventory.repository.PurchaseRepository;
import com.example.inventory.repository.SaleRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@Slf4j
public class InventoryService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    @Transactional
    public Purchase addPurchase(int quantity, double amountSpent) {
        Purchase purchase = new Purchase(null, quantity, amountSpent, LocalDate.now());
        purchaseRepository.save(purchase);

        Inventory inventory = inventoryRepository.findById(1L).orElse(new Inventory());
        inventory.setTotalBottles(inventory.getTotalBottles() + quantity);
        inventory.setBalanceAmount(inventory.getBalanceAmount() - amountSpent);
        inventoryRepository.save(inventory);

        return purchase;
    }

    @Transactional
    public Sale addSale(int quantity, double amountReceived) {
        Sale sale = new Sale(null, quantity, amountReceived, LocalDate.now());
        saleRepository.save(sale);

        Inventory inventory = inventoryRepository.findById(1L).orElseThrow();
        inventory.setTotalBottles(inventory.getTotalBottles() - quantity);
        inventory.setBalanceAmount(inventory.getBalanceAmount() + amountReceived);
        inventoryRepository.save(inventory);

        return sale;
    }

    public Inventory getInventory() {
        return inventoryRepository.findById(1L).orElse(new Inventory(1L, 0, 0));
    }
}
