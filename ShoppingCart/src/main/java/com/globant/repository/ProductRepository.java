package com.globant.repository;

import org.springframework.data.repository.CrudRepository;

import com.globant.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{

}
