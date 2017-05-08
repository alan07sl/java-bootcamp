package com.globant;

import java.util.Observer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.globant.domain.BasicProduct;
import com.globant.domain.Offer;
import com.globant.domain.Product;
import com.globant.domain.Stock;
import com.globant.notifications.ProductObserver;
import com.globant.payment.utils.Counter;

@SpringBootApplication
public class ShoppingCartApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingCartApplication.class, args);
		Observer o1 = new ProductObserver();
		Product.getObservable().addObserver(o1);
		Stock.getObservable().addObserver(o1);

		Stock stock = Stock.getInstance();

		Product papas = new BasicProduct(Counter.getNext(), 0.2, "Papas Lays");
		stock.addProduct(papas);
		System.out.println(papas);

		Product palitos = new BasicProduct(Counter.getNext(), 0.5, "Palitos Pep");
		stock.addProduct(palitos);
		System.out.println(palitos);

		Product combo = new Offer(Counter.getNext(), 0.4, "Combo papas + palitos");
		combo.add(papas);
		combo.add(palitos);
		stock.addProduct(combo);
		System.out.println(combo);
		System.out.print("Precio del combo = ");
		System.out.println(combo.getPrice());
		System.out.print("Precio producto por producto = ");
		System.out.println(combo.calculatePrice());

		palitos.setPrice(0.7);
	}
}
