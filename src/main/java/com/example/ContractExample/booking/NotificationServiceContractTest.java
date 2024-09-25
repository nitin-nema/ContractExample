package com.example.ContractExample.booking;

package com.example.notificationservice;

import au.com.dius.pact.provider.junit5.PactVerificationContext;
import au.com.dius.pact.provider.junit5.PactVerifyProvider;
import au.com.dius.pact.provider.junit5.PactVerificationInvocationContextProvider;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(PactVerificationInvocationContextProvider.class)
public class NotificationServiceContractTest {

    @TestTemplate
    @ExtendWith(PactVerificationContext.class)
    void verifyPacts(PactVerificationContext context) {
        context.verifyInteraction();
    }

    @PactVerifyProvider("A request to send a booking confirmation")
    public String verifySendNotification() {
        // Mock the behavior of the notification sending
        return "{\"message\": \"Booking confirmation sent successfully.\"}";
    }
}
