package com.example.ContractExample.booking;

package com.example.notificationservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {

    @PostMapping("/notify")
    public ResponseEntity<NotificationResponse> sendNotification(@RequestBody NotificationRequest request) {
        // Logic to send notification (e.g., email, SMS)
        return ResponseEntity.ok(new NotificationResponse("Booking confirmation sent successfully."));
    }
}

class NotificationRequest {
    private String email;
    private String event;

    // Getters and Setters
}

class NotificationResponse {
    private String message;

    public NotificationResponse(String message) {
        this.message = message;
    }

    // Getters and Setters
}
