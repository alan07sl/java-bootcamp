package com.globant.notifications;

import com.globant.domain.Product;

public class ItemAddedEvent {
	
	private Product product;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public ItemAddedEvent(Product product) {
		super();
		this.product = product;
	}

}
