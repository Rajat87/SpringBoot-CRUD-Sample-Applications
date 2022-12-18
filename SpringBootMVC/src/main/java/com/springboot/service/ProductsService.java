package com.springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.springboot.model.Products;


@Service
public class ProductsService {
	private List<Products> products= new ArrayList<Products>();   // This is null right now . So when the framework creates the object of ProductsService this is still null And no where In my controller I am actually initializing 
	// The array List so it is common sense that we will get a null pointer exception
	// But when I initialize it, It should be blanks. So why I am getting it as blank
	

	public ProductsService() {
		super();
	}

	// This will return the list of the products
	public List<Products> giveAllProducts(){
		return products;
	}
	
	// This will add the product in the list
	public void addProduct(Products product ) {
		products.add(product);
	}
	
}
