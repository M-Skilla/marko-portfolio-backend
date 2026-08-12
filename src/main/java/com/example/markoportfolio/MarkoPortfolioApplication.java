package com.example.markoportfolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MarkoPortfolioApplication {

    public static void main(String[] args) {
        SpringApplication.run(MarkoPortfolioApplication.class, args);
    }

}
