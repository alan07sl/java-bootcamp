package com.globant.domain;

import java.util.ArrayList;
import java.util.List;

public class Offer extends Product {

	public Offer(Integer id, Double price, String name) {
		super(id,price, name);
	}

	private List<Product> products = new ArrayList<Product>();

	@Override
	public Double calculatePrice() {
		Double price = 0.0;
		for (Product p : products) {
			price = price + p.calculatePrice();
		}
		return price;
	}

	// adding product to the offer
	public void add(Product p) {
		this.products.add(p);
	}

	// removing a product from the offer
	public void remove(Product p) {
		products.remove(p);
	}

	// removing all the products from the offer pack
	public void clear() {
		System.out.println("Clearing products");
		this.products.clear();
	}

}
