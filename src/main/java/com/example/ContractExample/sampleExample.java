package com.example.ContractExample;

//weather
@Pact(consumer ="MobileApp", provider ="WeatherService")
public RequestResponsePact sampleExample(PactDslWithProvider builder){
    return builder
            .given("Valid Location")
            .uponRecieving("Samsung 990 mobile requested for weather data")
            .path("/weather")
            .method("/GET")
            .willRespondWith()
            .status(200)
            .body("{\"location\":\"Delhi\}")
            .toPact();
}
