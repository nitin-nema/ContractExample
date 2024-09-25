package com.example.ContractExample.booking;

package com.example.bookingservice;

import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.web.client.RestTemplate.postForObject;

@ExtendWith(PactConsumerTestExt.class)
@PactTestFor(providerName = "NotificationService", port = "8081")
public class BookingServiceTest {

    @Pact(consumer = "BookingService")
    public RequestResponsePact createPact(PactDslWithProvider builder) {
        return builder
                .given("Booking is successful")
                .uponReceiving("A request to send a booking confirmation")
                .method("POST")
                .path("/notify")
                .body("{\"email\": \"user@example.com\", \"event\": \"Concert\"}")
                .willRespondWith()
                .status(200)
                .body("{\"message\": \"Booking confirmation sent successfully.\"}")
                .toPact();
    }

    @Test
    public void testSendBookingConfirmation() {
        String url = "http://localhost:8081/notify";
        String response = postForObject(url, "{\"email\": \"user@example.com\", \"event\": \"Concert\"}", String.class);
        assertThat(response).contains("Booking confirmation sent successfully.");
    }
}
