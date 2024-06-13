package com.gaurav.microservices.currency_exchange_service;

import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Retry(name = "sample-api", fallbackMethod = "hardCodeResponse")
public class CircuitBreakerController {

    Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping("/api")
    public String getSampleApi(){
        logger.info("sample api called!");
        ResponseEntity<String> responseEntity = new RestTemplate()
                .getForEntity("http://localhost:8080/some-dummy", String.class);
        return responseEntity.getBody();
    }

    public String hardCodeResponse(Exception e){
        return "Some Error";
    }

}
