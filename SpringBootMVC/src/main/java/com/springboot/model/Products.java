package com.springboot.model;

public class Products {
	private String name;
	private String price;
	public Products() {
		super();
	}
	public Products(String name, String price) {
		super();
		this.name = name;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Products [name=" + name + ", price=" + price + "]";
	}
	
}
