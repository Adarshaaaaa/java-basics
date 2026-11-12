package com.spring.boot.coupling;

import org.springframework.stereotype.Component;

@Component
public class CouplingExample {
    public String demonstrate() {
        return "This component is managed by Spring through component scanning.";
    }
}
