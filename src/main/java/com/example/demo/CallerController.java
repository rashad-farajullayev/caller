package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.xml.bind.SchemaOutputResolver;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;

@RestController
public class CallerController {

    @Value("${endpoint.url}")
    private String endpointUrl;

    @GetMapping (value="/")
    public String callService ()
    {
        RestTemplate tpl = new RestTemplate();
        String response = tpl.getForObject(endpointUrl, String.class);

        return "the response is: " + response;
    }

    @GetMapping (value="/caller")
    public String callService2 ()
    {
        try {
            RestTemplate tpl = new RestTemplate();
            String response = tpl.getForObject(endpointUrl, String.class);

            return "By the \"/caller\" the response is: " + response;
        }
        catch (Exception ex){
            return "Exception occurred: " + ex.getMessage();
        }
    }

    @GetMapping (value="/caller/endpoint")
    public String callService3 () throws MalformedURLException {

        try {
            RestTemplate tpl = new RestTemplate();
            String url = endpointUrl;
            if (!url.endsWith("/"))
                url += "/";
            url += "endpoint";
            System.out.println(url);
            String response = tpl.getForObject(url, String.class);

            return "By the \"/caller\" the response is: " + response;
        }
        catch (Exception ex)
        {
            return "Exception occurred: " + ex.getMessage();
        }
    }
}
