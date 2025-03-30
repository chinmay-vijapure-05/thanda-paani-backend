package com.example.inventory.controller;

import com.example.inventory.model.Inventory;
import com.example.inventory.model.Purchase;
import com.example.inventory.model.Sale;
import com.example.inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
@CrossOrigin(origins = "http://localhost:8080")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @PostMapping("/purchase")
    public Purchase purchase(@RequestBody Purchase purchase) {
        return inventoryService.addPurchase(purchase.getQuantity(), purchase.getAmountSpent());
    }

    @PostMapping("/sale")
    public Sale sale(@RequestBody Sale sale) {
        return inventoryService.addSale(sale.getQuantity(), sale.getAmountReceived());
    }

    @GetMapping
    public Inventory getInventory() {
        return inventoryService.getInventory();
    }
}
