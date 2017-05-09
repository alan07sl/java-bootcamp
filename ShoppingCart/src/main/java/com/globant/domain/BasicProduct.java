package com.globant.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "basicproduct")
@DiscriminatorValue("basicproduct")
public class BasicProduct extends Product {

	public BasicProduct() {
		super();
	}

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
