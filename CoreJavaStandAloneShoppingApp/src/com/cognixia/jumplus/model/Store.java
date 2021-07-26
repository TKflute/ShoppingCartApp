package com.cognixia.jumplus.model;

import java.util.ArrayList;
import java.util.List;

public class Store {

	// in memory Collection of all items available 
	private List<Item> items; 

	public Store() {
		
		items = new ArrayList<Item>();
		populateItems();
	}
	
	public void populateItems() {
		
		items.add(new Item("Ladies Shirt", "LS1", 25.00));
		items.add(new Item("Ladies Pants", "LP1", 40.00));
		items.add(new Item("Ladies Shoes", "LSh1", 50.00));
		items.add(new Item("Mens Shirt", "MS1", 30.00));
		items.add(new Item("Mens Pants", "MP1", 45.00));
		items.add(new Item("Mens Shoes", "MSh1", 55.00));
	}

	public List<Item> getItems() {
		return items;
	}
	
}
