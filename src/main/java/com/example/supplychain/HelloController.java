package com.example.supplychain;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    // Health check
    @GetMapping("/api/ping")
    public String ping()
    {
        return "pong";
    }
}
