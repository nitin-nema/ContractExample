package com.example.ContractExample.Provider;

@RestController
@RequestMapping("/provider")
public class ProviderController {

    @GetMapping("/order/{id}")
    public ResponseEntity<Map<String, String>> getOrder(@PathVariable("id") String id) {
        Map<String, String> response = new HashMap<>();
        response.put("id", id);
        response.put("status", "confirmed");
        return ResponseEntity.ok(response);
    }
}

