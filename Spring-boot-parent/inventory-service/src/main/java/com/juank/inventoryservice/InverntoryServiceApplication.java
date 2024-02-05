package com.juank.inventoryservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.juank.inventoryservice.model.Inventory;
import com.juank.inventoryservice.repository.InventoryRepository;

@SpringBootApplication
public class InverntoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InverntoryServiceApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
		return args -> {
			Inventory inventory = new Inventory();
			inventory.setSkuCode("iphone_13");
			inventory.setQuantity(1200);
			
			Inventory inventory1 = new Inventory();
			inventory1.setSkuCode("iphone_13_red");
			inventory1.setQuantity(30);
			
			inventoryRepository.save(inventory);
			inventoryRepository.save(inventory1);

		};
	}

}
