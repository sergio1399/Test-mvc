package ru.sergio.testmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"ru.sergio.testmvc"})
public class TestMvcApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestMvcApplication.class, args);
    }
}
