package com.example.taxmanager;

import com.example.taxmanager.taxdeductions.TaxDeductions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication

public class TaxmanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaxmanagerApplication.class, args);
	}

}
