package com.example.demo;

import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String home() {
        return "Spring Boot 4.0.3  is running in Docker successfully     ✅";
    }

    @GetMapping("/health")
    public String health() {
        return "OK";
    }@GetMapping("/api/hello")
public Map<String, String> apiHello() {
    return Map.of("message", "Hello from Spring Boot API WORKING ✅");
}
}


