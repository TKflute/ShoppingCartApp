package com.cognixia.jumplus.model;

public class Item {

	private String name;
	private String code;
	private double price;
	
	// TODO: add an enum for different Item categories/departments
	// so when buying an item, customer can view Items by department or view all Items
	
	public Item(String name, String code, double price) {
		super();
		this.name = name;
		this.code = code;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return getName() + "\t" + getCode() + "\t\t" + getPrice();
	}
	
}
