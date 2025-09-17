package com.emil.portfolio;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingTest {
    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }
}
