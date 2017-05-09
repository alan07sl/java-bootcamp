package com.globant.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globant.domain.Product;
import com.globant.notifications.ItemAddedEvent;
import com.globant.notifications.ObservableProduct;
import com.globant.notifications.PriceChangeEvent;
import com.globant.repository.ProductRepository;

@Service
public class ProductService extends Observable {

	private static ObservableProduct OBSERVABLE;

	static {
		OBSERVABLE = new ObservableProduct();
	}

	public static Observable getObservable() {
		return OBSERVABLE;
	}

	@Autowired
	private ProductRepository productRepository;

	public List<Product> getAllProducts() {
		List<Product> products = new ArrayList<Product>();
		productRepository.findAll().forEach(p -> products.add(p));
		return products;
	}

	public Product getProduct(Integer id) {
		return productRepository.findOne(id);
	}

	public void updateProduct(Product product) {
		if (productRepository.exists(product.getId())) {
			// Getting the old product for creating the event of price changing
			Product oldProduct = getProduct(product.getId());

			productRepository.save(product);

			// Asking if the product price changed

			if (!(oldProduct.getPrice().equals(product.getPrice()))) {

				// Create the event and notify observers
				PriceChangeEvent event = new PriceChangeEvent(oldProduct, oldProduct.getPrice(), product.getPrice());

				synchronized (OBSERVABLE) {
					OBSERVABLE.setChanged();
					OBSERVABLE.notifyObservers(event);
				}
			}
		} else {
			//TODO Return a page with a message and the correct httpStatus code
		}

	}

	public void deleteProduct(Integer id) {
		productRepository.delete(id);
	}

	public void addProduct(Product product) {

		productRepository.save(product);

		ItemAddedEvent event = new ItemAddedEvent(product);

		synchronized (OBSERVABLE) {
			OBSERVABLE.setChanged();
			OBSERVABLE.notifyObservers(event);
		}
	}

}
