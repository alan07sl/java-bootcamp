package com.globant.domain;

public class BasicProduct extends Product {

	public BasicProduct(Integer id, Double price, String name) {
		super(id, price, name);
	}

	@Override
	public Double calculatePrice() {
		return getPrice();
	}

	@Override
	public void add(Product p) {
	}

	@Override
	public void remove(Product p) {
	}

	@Override
	public void clear() {
	}

}
