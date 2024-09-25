package com.example.ContractExample.booking;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final NotificationService notificationService;

    @Autowired
    public BookingController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping
    public ResponseEntity<String> createBooking(@RequestBody BookingRequest bookingRequest) {
        // Logic to process the booking
        // (e.g., save booking details to the database)

        // Sending notification to user
        notificationService.sendNotification(bookingRequest.getEmail(), bookingRequest.getEvent());

        return ResponseEntity.ok("Booking created successfully and notification sent.");
    }
}

class BookingRequest {
    private String email;
    private String event;

    // Getters and Setters
}
