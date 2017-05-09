package com.globant.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity(name = "offer")
@DiscriminatorValue("offer")
public class Offer extends Product {

	//Cascade is necessary
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Product> products = new ArrayList<Product>();

	public Offer() {
		super();
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Offer(Integer id, Double price, String name) {
		super(id, price, name);
	}

	public Offer(Integer id, Double price, String name, List<Product> products) {
		super(id, price, name);
		this.products = products;
	}

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
