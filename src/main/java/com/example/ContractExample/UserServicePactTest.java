package com.example.ContractExample;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;


public class UserServicePactTest {

    @Pact(consumer ="UserService", provider ="ProfileService")
    public RequestResponsePact sampleExample(PactDslWithProvider builder){
        return builder
                .given("User profile exist for user id")
                .uponRecieving("User with user name request with Id 100")
                .path("/profiles/100")
                .method("/GET")
                .willRespondWith()
                .status(200)
                .body("{\"id\":\100\,\"name\":\"Arun\"}")
                .toPact();
    }

    @Test
    @PactTestFor(providerName ="ProfileService", port ="8080")
    void testGetUserProfile(){
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/profiles/100"))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request. HttpResponse.BodyHandler.ofString());

        assertEquals(200,response.statusCode());
        assertEqual("{\"id\":\100\,\"name\":\"Arun\"}", response.body());
    }
}
