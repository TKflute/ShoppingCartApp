package com.cognixia.jumplus.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {

	private long id;
	private LocalDateTime ldt;
	private Customer customer;
	
	// will maybe choose a diff collection based on how I need to access the items
	private List<OrderItem> orderItems = new ArrayList<OrderItem>();
	
	
	public class OrderItem{
		
		private long id;
		private Item item;
		private int qty;
		
	}
	
	// could probably do this with a lambda or stream
	public double calculateSum() {
		double sum = 0;
		for(OrderItem orderItem : orderItems) {
			sum += orderItem.item.getPrice();
		}
		return sum;
	}
}
