package com.pluralsight.NorthwindTradersSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import java.util.List;

@SpringBootApplication
public class NorthwindTradersSpringBootApp {
	public static void main(String[] args) {
		// Create the Spring application context
		ApplicationContext context = SpringApplication.run(NorthwindTradersSpringBootApp.class, args);

		// Retrieve the SimpleProductDao bean using dependency injection
		ProductDao productDao = context.getBean(SimpleProductDao.class);

		// Clear the list before adding sample products
		((SimpleProductDao) productDao).clear();

		// Add sample products without duplicates
		if (((SimpleProductDao) productDao).getById(1) == null) {
			productDao.add(new Product(1, "Laptop", "Electronics", 999.99));
		}
		if (((SimpleProductDao) productDao).getById(2) == null) {
			productDao.add(new Product(2, "Book", "Literature", 19.99));
		}

		// List all products
		List<Product> productList = productDao.getAll();
		System.out.println("List of Products: " + productList);
	}
}
