package com.spring.boot;

import org.springframework.stereotype.Component;

@Component
public class printHello {
    public String message() {
        return "Hello from Spring Boot!";
    }
}
