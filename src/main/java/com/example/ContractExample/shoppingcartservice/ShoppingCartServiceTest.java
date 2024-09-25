package com.example.ContractExample.shoppingcartservice;

package com.example.shoppingcartservice;

import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(PactConsumerTestExt.class)
@PactTestFor(providerName = "InventoryService", port = "8080")
public class ShoppingCartServiceTest {

    @Pact(consumer = "ShoppingCartService")
    public RequestResponsePact createPact(PactDslWithProvider builder) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");

        return builder
                .given("Item exists")
                .uponReceiving("A request to get item details")
                .path("/inventory/12345")
                .method("GET")
                .willRespondWith()
                .status(200)
                .headers(headers)
                .body("{\"id\": \"12345\", \"name\": \"Item 1\", \"price\": 100}")
                .toPact();
    }

    @Test
    public void testGetInventoryItem(MockServer mockServer) {
        RestTemplate restTemplate = new RestTemplate();
        String url = mockServer.getUrl() + "/inventory/12345";

        String response = restTemplate.getForObject(url, String.class);
        assertThat(response).contains("Item 1");
    }
}
