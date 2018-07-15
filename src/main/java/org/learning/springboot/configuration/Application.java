package org.learning.springboot.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "org.learning.springboot")
public class Application {

    public static void main(String[] args) throws Exception {
        System.out.println("Starting the app..");
        SpringApplication.run(Application.class, args);
    }
}
