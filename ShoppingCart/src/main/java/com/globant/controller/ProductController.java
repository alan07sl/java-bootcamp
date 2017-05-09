package com.globant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.globant.domain.Product;
import com.globant.service.ProductService;

@RestController
public class ProductController {

	public static final String BASE_URL = "/products";
	
	@Autowired
	private ProductService productService;

	@GetMapping(BASE_URL)
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	@GetMapping(BASE_URL+"{id}")
	public Product getProduct(@PathVariable Integer id) {
		return productService.getProduct(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = BASE_URL)
	public void addProduct(@RequestBody Product product) {
		productService.addProduct(product);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = BASE_URL)
	public void updateProduct(@RequestBody Product product) {
		productService.updateProduct(product);
	}

}
