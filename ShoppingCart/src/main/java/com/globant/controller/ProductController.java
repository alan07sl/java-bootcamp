package com.globant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.globant.domain.Product;
import com.globant.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	 @GetMapping("/")
	    public String index() {
	        return "Greetings from Spring Boot1!";
	    }
	 
	 @GetMapping("/products")
	    public List<Product> getAllProducts() {
	        return productService.getAllProducts();
	    }
	 
	 @GetMapping("/products/{id}")
	    public Product getProduct(@PathVariable Integer id) {
	        return productService.getProduct(id);
	    }

}
