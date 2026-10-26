package com.students;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DisplayDetails {
           @Test
            void display() {
        StudentsDetails sd = new StudentsDetails("adarsh", "kinaruvila");
        System.out.println(sd.getName());
        System.out.println(sd.getAddress());
    }
}
