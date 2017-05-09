package com.globant;

import java.util.Observer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.globant.notifications.ProductObserver;
import com.globant.service.ProductService;

@SpringBootApplication
public class ShoppingCartApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingCartApplication.class, args);
		
		//Create observer
		Observer o1 = new ProductObserver();
		ProductService.getObservable().addObserver(o1);		
		
	}
}
