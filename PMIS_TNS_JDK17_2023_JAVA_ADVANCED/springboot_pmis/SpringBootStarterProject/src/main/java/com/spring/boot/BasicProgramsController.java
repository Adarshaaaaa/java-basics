package com.spring.boot;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BasicProgramsController {
    private final printHello helloService;

    public BasicProgramsController(printHello helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/hello")
    public String hello() {
        return helloService.message();
    }

    @GetMapping("/person")
    public Person getPerson() {
        return new Person("Aravinthan", 22);
    }

    @PostMapping("/person")
    public Map<String, Object> createPerson(@RequestBody Person person) {
        return Map.of(
                "message", "Person received successfully",
                "name", person.getName() == null ? "" : person.getName(),
                "age", person.getAge()
        );
    }
}
