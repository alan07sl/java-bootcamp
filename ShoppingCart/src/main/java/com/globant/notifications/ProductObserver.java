package com.globant.notifications;

import java.util.Observable;
import java.util.Observer;

public class ProductObserver implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		if (arg instanceof PriceChangeEvent) {
			PriceChangeEvent event = (PriceChangeEvent) arg;
			System.out.println("Mando mail a market manager: Cambio el precio del producto " + event.getProduct().getName() + " de "
					+ event.getOldPrice() + " a " + event.getNewPrice());
		} else if (arg instanceof ItemAddedEvent) {
			ItemAddedEvent event = (ItemAddedEvent) arg;
			System.out.println("Mando mail a market manager: Hay un nuevo producto: " + event.getProduct().getName());
		}

	}

}
