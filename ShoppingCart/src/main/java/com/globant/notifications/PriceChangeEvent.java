package com.globant.notifications;

import com.globant.domain.Product;

public class PriceChangeEvent {

	private Product product;
	private Double oldPrice;
	private Double newPrice;

	public PriceChangeEvent(Product product, Double oldPrice, Double newPrice) {
		this.product = product;
		this.oldPrice = oldPrice;
		this.newPrice = newPrice;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Double getOldPrice() {
		return oldPrice;
	}

	public void setOldPrice(Double oldPrice) {
		this.oldPrice = oldPrice;
	}

	public Double getNewPrice() {
		return newPrice;
	}

	public void setNewPrice(Double newPrice) {
		this.newPrice = newPrice;
	}
	
}
