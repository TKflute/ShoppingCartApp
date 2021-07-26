package com.cognixia.jumplus.view;

import java.util.List;
import java.util.Scanner;

import com.cognixia.jump.service.CreateAccountService;
import com.cognixia.jumplus.controller.ShoppingAppController;
import com.cognixia.jumplus.model.Item;
import com.cognixia.jumplus.model.Store;
import com.dollarsbank.utility.ConsolePrinterUtility;

public class ConsolePrinter {

	// TODO: I may change this class from my approach for last project
	// Could use this class like a place to call render() for things that are more complicated to display
	// this would be for menus that aren't interactive w/ each line
	// could assemble these menus in a service layer, just to separate concerns a bit more
	// still use this class to print interactive menus, like creating account
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
			break;
		case "2":
			printLogin();
			break;
//		case "3":
//			consolePrinter.displayExitScreen();
//			closeConnection();
//			break;
//		default:
//			consolePrinter.displayInvalidChoice();
//			//determineNextInteraction();
//			break;
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
			}
		}
		
		System.out.println("Enter a password");
		String password = input.nextLine().trim();
		isValid = false;
		while(isValid == false) {
			if(createAccountService.validatePassword(password)) {
				isValid = true;
			}
		}
		input.close();
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
	
	public void printInvoice() {
		printHeader();
		// TODO: Do I want to do all sysouts in this class?
		// or should I prepare String data to be printed in a Service class, and then print out template here
		// sort of like making a component elsewhere and calling render() here
	}
	
	public void printHeader() {
		
		System.out.println("Standalone Ecommerce App");
		System.out.println("+=====================================+");
	}
}
