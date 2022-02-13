package org.home.ecomapp;

import org.home.ecomapp.dao.ProductRepository;
import org.home.ecomapp.entities.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EcomAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcomAppApplication.class, args);
	}


	@Bean
	CommandLineRunner start(ProductRepository productRepository) {
		return args -> {
			productRepository.save(new Product(null, "Ord HP 564", 8000.0));
			productRepository.save(new Product(null, "Ord Dell", 5000.0));
			productRepository.save(new Product(null, "MAC Pro", 10000.0));
			productRepository.findAll().forEach(p -> {
				System.out.println(p.getName());
			});
		};
	}
}
