package com.example.taxmanager.billmanager;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class BillManagerConfig {
    @Bean(name = "billmanager")
    CommandLineRunner commandLineRunner(BillManagerRepository repository) {
        return args -> {
            BillManager food = new BillManager(
                    "Food",
                    "All the food I have bought this week",
                    1000,
                    LocalDate.of(2022, JANUARY, 5)
            );
            BillManager rent = new BillManager(
                     "Rent",
                     "Rent for the month of January",
                    20000, LocalDate.of(2022, JANUARY, 1));
            BillManager shopping = new BillManager(
                     "Shopping",
                    "All the shopping I have done this week",
                    5000,
                    LocalDate.of(2022, JANUARY, 5)
            );
            repository.saveAll(
                    List.of(food,rent,shopping)
            );
        };
    }
}

