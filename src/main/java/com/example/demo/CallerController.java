package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CallerController {

    @Value("${endpoint.url}")
    private String endpointUrl;

    @GetMapping (value="/")
    public String callService ()
    {
        RestTemplate tpl = new RestTemplate();
        String response = tpl.getForObject(endpointUrl, String.class);

        return "the response is " + response;
    }
}
