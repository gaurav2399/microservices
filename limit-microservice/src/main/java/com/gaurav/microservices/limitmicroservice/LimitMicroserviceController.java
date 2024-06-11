package com.gaurav.microservices.limitmicroservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitMicroserviceController {

    @Autowired
    Configuration configuration;

    @GetMapping("/limits")
    public Limits getLimits(){
//        return new Limits(1, 1000);
        return new Limits(configuration.getMinimum(), configuration.getMaximum());
    }

}
