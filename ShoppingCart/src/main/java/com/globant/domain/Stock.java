package com.globant.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import com.globant.notifications.ItemAddedEvent;
import com.globant.notifications.ObservableProduct;

public class Stock extends Observable {

	private static final ObservableProduct OBSERVABLE;
	private List<Product> stockList = new ArrayList<Product>();

	private static Stock instance = null;

	protected Stock() {
	      // Exists only to defeat instantiation.
	   }

	public static Stock getInstance() {
		if (instance == null) {
			instance = new Stock();
		}
		return instance;
	}

	public List<Product> getStock() {
		return stockList;
	}

	public void addProduct(Product p) {
		stockList.add(p);
		ItemAddedEvent event = new ItemAddedEvent(p);

		synchronized (OBSERVABLE) {
			OBSERVABLE.setChanged();
			OBSERVABLE.notifyObservers(event);
		}
	}

	static {
		OBSERVABLE = new ObservableProduct();
	}

	public static Observable getObservable() {
		return OBSERVABLE;
	}

}
