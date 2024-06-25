package com.backend_senac.healthcare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class HealthcareApplication {

    public static void main(String[] args) {
        SpringApplication.run(HealthcareApplication.class, args);
    }

}
