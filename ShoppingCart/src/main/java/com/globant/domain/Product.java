package com.globant.domain;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

//Json specs to map a list of objects of product inherited types.
@JsonTypeInfo(use = com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME, include = As.PROPERTY, property = "type")
@JsonSubTypes({ @JsonSubTypes.Type(value = Offer.class, name = "offer"),
		@JsonSubTypes.Type(value = BasicProduct.class, name = "basicprod") })
@Entity
@Table(name = "product")
@Inheritance
@DiscriminatorColumn(name = "type")
public abstract class Product implements IProduct {

	@Id
	@GeneratedValue
	private Integer id;
	private Double price;
	private String name;

	public Product(Integer id, Double price, String name) {
		super();
		this.price = price;
		this.name = name;
		this.id = id;
	}

	public Product() {
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + "]";
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
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
