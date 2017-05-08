package com.globant.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.globant.domain.Product;
import com.globant.domain.Stock;

@Service
public class ProductService {

	public List<Product> getAllProducts() {
		return Stock.getInstance().getStock();
	}

	public Product getProduct(Integer id) {
		return Stock.getInstance().getStock().stream().filter(p -> p.getId().equals(id)).findFirst().get();
	}
}
