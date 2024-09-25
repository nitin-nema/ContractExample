package com.example.ContractExample.shoppingcartservice;


import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ShoppingCartService {
    private final RestTemplate restTemplate = new RestTemplate();

    public String getInventoryItem(String itemId) {
        // This calls the provider (inventory service)
        String url = "http://localhost:8080/inventory/" + itemId;
        return restTemplate.getForObject(url, String.class);
    }
}
