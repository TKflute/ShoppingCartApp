package com.cognixia.jumplus.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cognixia.jump.service.CreateAccountService;
import com.cognixia.jumplus.controller.ShoppingAppController;
import com.cognixia.jumplus.model.Item;
import com.cognixia.jumplus.model.Store;

public class ConsolePrinter {

	private Store store;
	private ShoppingAppController controller;
	private CreateAccountService accountService;
	
	public ConsolePrinter() {
		store = new Store();
		controller = new ShoppingAppController();
	}
	
	public void mainMenuInteraction() {
		
		// switch case w/ sub menu interaction choices mapped to sub interaction methods
		printMainMenu();
		Scanner input = new Scanner(System.in);
		System.out.println("Please choose a menu option");
		String choice = input.nextLine().trim();
		
		
		switch(choice) {
		case "1":
			printAccountCreation();
			printLogin();
			buyOrReplace();
			break;
		case "2":
			printLogin();
			buyOrReplace();
			break;
		case "3":
			printBuyItem();
			break;
		case "4":
			printReplaceItem();
		case "5":
			System.out.println("Goodbye.");
			break;
		}
		input.close();
		
	}
	
	public void printMainMenu() {
		
		printHeader();
		System.out.println("|   1.REGISTER			|");
		System.out.println("|   2.LOGIN			|");
		System.out.println("|   3.BUY AN ITEM		|");
		System.out.println("|   4.REPLACE AN ITEM	        |");
		System.out.println("|   5.EXIT			|");
		System.out.println("+=====================================+");
	}
	
	public void printAccountCreation() {
		
		CreateAccountService createAccountService = new CreateAccountService();
		
		System.out.println("+---------------------------\n| Enter Details For New Account |\n+---------------------------\n");
		System.out.println("Customer Name:\n");
		String name = controller.takeInput();
		
		System.out.println("Customer Address:\n");
		String address = controller.takeInput();
		
		System.out.println("Customer Phone Number:\n");
		String phoneNumber = controller.takeInput();
		
		boolean isValid = false;
		
		System.out.println("Enter an email address");
		String email = controller.takeInput();
		
		while(isValid == false) {
			if(createAccountService.validateEmail(email)) {
				isValid = true;
			}else {
				System.out.println("Please reenter a valid email.");
				email = controller.takeInput();
			}
		}
	
		System.out.println("Choose a password (6 or more characters:\n");
		String password = controller.takeInput();
		isValid = false;
		while(isValid == false) {
			if(createAccountService.validatePassword(password)) {
				isValid = true;
			}else {
				System.out.println("Please reenter a valid password.");
				password = controller.takeInput();
			}
		}
	}
	
	public void printLogin() {
		
		CreateAccountService createAccountService = new CreateAccountService();
		Scanner input = new Scanner(System.in);
		System.out.println("Enter an email address");
		String email = input.nextLine().trim();
		// put these if statements inside a loop
		boolean isValid = false;
		while(isValid == false) {
			if(createAccountService.validateEmail(email)) {
				isValid = true;
			}else {
				System.out.println("Please reenter a valid email.");
				email = controller.takeInput();
			}
		}
		
		System.out.println("Enter a password");
		String password = input.nextLine().trim();
		isValid = false;
		while(isValid == false) {
			if(createAccountService.validatePassword(password)) {
				isValid = true;
			}else {
				System.out.println("Please reenter a valid password.");
				password = controller.takeInput();
			}
		}
	}
	
	public void printAfterLogin() {
		
		printHeader();
		System.out.println("|  Items\tItem Code\tPrice\t|\n");
		
		int itemCount = 1;
		List<Item> items = store.getItems();
		for(Item item : items) {
			System.out.println(itemCount++ + ". " + item.getName() + "\t" + item.getCode() + "\t\t" + item.getPrice());
		}
	}
	
	
	public void printHeader() {
		
		System.out.println("Standalone Ecommerce App");
		System.out.println("+=====================================+");
	}
	
	public void buyOrReplace() {
		
		System.out.println("Would you like to buy or replace an item?");
		Scanner input = new Scanner(System.in);
		String choice = input.nextLine().trim();
		if(choice == "buy") {
			printBuyItem();
		}else if(choice == "replace") {
			printReplaceItem();
		}else {
			buyOrReplace();
		}
	}
	
	public void printBuyItem() {
		List<Item> items = store.getItems();
		List<Item> itemsToBuy = new ArrayList<Item>();
		
		boolean shopping = true;
		System.out.println("Enter the code of the item you wish to purchase");
		while(shopping) {
			for(Item i : items) {
				System.out.println("Items    Item Code    Price");
				System.out.println(i.getName() + "   " + i.getCode() + "   " + i.getPrice());
			}	
			Scanner input = new Scanner(System.in);
			String code = input.nextLine().trim();
			Item purchase = new Item(code);
			for(Item i : items) {
				if(code == i.getCode()) {
					purchase.setName(i.getName());
					purchase.setPrice(i.getPrice());
				}
			}
			
			itemsToBuy.add(purchase);
			System.out.println("Would you like to buy another item? Y or N");
			String keepShopping = input.nextLine().trim();
			if(keepShopping == "N") {
				shopping = false;
			}
		}
		
		printInvoice(itemsToBuy);	
	}
	
	public void printInvoice(List<Item> itemsToBuy) {
		printHeader();
		System.out.println("Invoice with total purchases: ");
		System.out.println("Items    Item Code    Price");
		int total = 0;
		
		for(Item i : itemsToBuy) {
			System.out.println(i.getName() + "   " + i.getCode() + "   " + i.getPrice());
			total += i.getPrice();
		}
		System.out.println("Total: " + total);
	}
	
	public void printReplaceItem() {
		System.out.println("Which item would you like to replace? Enter code.");
		printBuyItem();
		Scanner input = new Scanner(System.in);
		String oldItem = input.nextLine().trim();
		System.out.println("And what would you like to replace it with? Enter code.");
		printBuyItem();
		String newItem = input.nextLine().trim();
		System.out.println("You have replaced " + oldItem + " with " + newItem + ". Thank you.");
		input.close();
	}
}
