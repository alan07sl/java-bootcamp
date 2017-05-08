package com.globant.domain;

import java.util.Observable;

import com.globant.notifications.ObservableProduct;
import com.globant.notifications.PriceChangeEvent;

public abstract class Product extends Observable implements IProduct {

	private Integer id;
	private Double price;
	private String name;
	private static ObservableProduct OBSERVABLE;
	
	static {
		OBSERVABLE = new ObservableProduct();
	}

	public static Observable getObservable() {
		return OBSERVABLE;
	}

	public Product(Integer id, Double price, String name) {
		super();
		this.price = price;
		this.name = name;
		this.id = id;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + "]";
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		PriceChangeEvent event = new PriceChangeEvent(this, this.price, price);
		this.price = price;

		synchronized (OBSERVABLE) {
			OBSERVABLE.setChanged();
			OBSERVABLE.notifyObservers(event);
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
