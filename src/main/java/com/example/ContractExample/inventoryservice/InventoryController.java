package com.example.ContractExample.inventoryservice;

package com.example.inventoryservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InventoryController {

    @GetMapping("/inventory/{itemId}")
    public InventoryItem getInventoryItem(@PathVariable String itemId) {
        return new InventoryItem(itemId, "Item 1", 100);
    }
}

class InventoryItem {
    private String id;
    private String name;
    private int price;

    public InventoryItem(String id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Getters and Setters
}
