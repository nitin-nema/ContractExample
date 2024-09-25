package com.example.ContractExample;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    private final RestTemplate restTemplate;

    @Autowired
    public ConsumerController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<String> getOrderDetails(@PathVariable("id") String id) {
        String providerUrl = "http://localhost:8081/provider/order/" + id;
        ResponseEntity<String> response = restTemplate.getForEntity(providerUrl, String.class);
        return ResponseEntity.ok(response.getBody());
    }
}
