package com.globant.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.globant.domain.BasicProduct;
import com.globant.domain.Offer;
import com.globant.domain.Product;
import com.globant.payment.utils.Counter;
import com.globant.service.ProductService;

public class ProductControllerTest {

	@Mock
	private ProductService productService;

	@InjectMocks
	private ProductController productController;

	private MockMvc mvc;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);

		mvc = MockMvcBuilders.standaloneSetup(productController).build();
	}

	@Test
	public void testList() throws Exception{
		
		List<Product> products = new ArrayList<Product>();
		
		Product papas = new BasicProduct(Counter.getNext(), 0.2, "Papas Lays");

		Product palitos = new BasicProduct(Counter.getNext(), 0.5, "Palitos Pep");

		Offer combo = new Offer(Counter.getNext(), 0.4, "Combo papas + palitos");
		combo.add(papas);
		combo.add(palitos);
		
		products.add(papas);
		products.add(palitos);
		products.add(combo);
		
		Mockito.when(productService.getAllProducts()).thenReturn(products);
		
		mvc.perform(MockMvcRequestBuilders.get(ProductController.BASE_URL)).andExpect(MockMvcResultMatchers.status().isOk())
		   .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(2));
		
	}
}
