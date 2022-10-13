package com.example.taxmanager.taxdeductions;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TaxDeductionsConfig {
    @Bean
    CommandLineRunner commandLineRunner(TaxDeductionsRepository repository) {
        return args -> {
            TaxDeductions james = new TaxDeductions(

                    "James",
                    "james@gmail.com",
                    50000,
                    3000,
                    300,
                    5000,
                    750,
                    42450
            );
            TaxDeductions john = new TaxDeductions(

                    "John",
                    "john@gmail.com",
                    10000,
                    600,
                    300,
                    1000,
                    150,
                    8250
            );
            repository.saveAll(
                    List.of(james,john)
            );
        };
    }
}
