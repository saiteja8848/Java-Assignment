package com.centime.demorestapi.service;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.centime.demorestapi.aspects.LogMethodParam;
import com.centime.demorestapi.entity.RequestWSO;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@Service
@EnableCircuitBreaker
public class DemoServiceImpl implements DemoService {

    private final RestTemplate restTemplate;
    private final String serviceBUrl;
    private final String serviceCUrl;
    
  
    public DemoServiceImpl(RestTemplate restTemplate,
                           @Value("${service_b_url}") String serviceBUrl,
                           @Value("${service_c_url}") String serviceCUrl) {
        this.restTemplate = restTemplate;
        this.serviceBUrl = serviceBUrl;
        this.serviceCUrl = serviceCUrl;
    }
 
    @HystrixCommand(fallbackMethod = "fallbackForPost")
    @LogMethodParam
    @Override
    public Optional<String> getConcatedStrings(RequestWSO requestWso) {
        HttpHeaders headers = new HttpHeaders();
 
        ResponseEntity<Map> responseGet = restTemplate.exchange(
                String.format("%s/hello", serviceBUrl),
                HttpMethod.GET,
                new HttpEntity<>(headers),
                Map.class);

        ResponseEntity<String> responsePost = restTemplate.exchange(
                String.format("%s/concat", serviceCUrl),
                HttpMethod.POST,
                new HttpEntity<>(requestWso, headers),
                String.class);
        
        if (Objects.nonNull(responseGet) && Objects.nonNull(responseGet.getBody()) &&
        	    Objects.nonNull(responsePost) && Objects.nonNull(responsePost.getBody()) &&
        	    Objects.nonNull(responseGet.getBody().get("message"))) {
        	    return Optional.ofNullable(responseGet.getBody().get("message")+" "+responsePost.getBody());
        	}

        return Optional.empty();
      }
    
 

    @HystrixCommand(fallbackMethod = "fallbackForPost")
    public Optional<String> fallbackForPost(RequestWSO requestWso, Throwable throwable) {
        return Optional.of("Not able to process the request, service might be down");
    }
}
