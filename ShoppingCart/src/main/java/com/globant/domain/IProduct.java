package com.globant.domain;

public interface IProduct {

	public Double calculatePrice();

	public void add(Product p);

	public void remove(Product p);

	public void clear();
}
