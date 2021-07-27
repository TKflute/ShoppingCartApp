package com.cognixia.jump.service;

import com.cognixia.jumplus.model.Order;

public class InvoiceService {

	// this class will take an Order object w/ its items and create an invoice- 
	// (prepare a string template) to be printed to customer
	// Order and Invoice would be same data - invoice is printed version of Order, so no need for Invoice class
	// maybe the naming is too confusing but I prefer using "Order" 
	
	public String createInvoice(Order order){
		String invoice = "";
		// make formatted string starting from Customer Name
		// for order items, call orderItem.toString()
		return invoice; // no need to make an Invoice obj, but it is simulating that
	}
}
