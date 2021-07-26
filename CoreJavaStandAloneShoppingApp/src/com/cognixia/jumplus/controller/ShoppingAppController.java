package com.cognixia.jumplus.controller;

import java.util.Scanner;

import com.cognixia.jumplus.view.ConsolePrinter;

//Take in all user input and map to appropriate service layer methods
public class ShoppingAppController {

	private Scanner input;
	
	public ShoppingAppController() {
		this.input = new Scanner(System.in);
	}
	
	public void mainMenuInteraction() {
		
		// using same approach as bank proj- use a switch case for main menu
		/* 1 Register -> display output that creates user account -> then display login
		 * 2 Login -> display login menu
		 * 3 Buy an Item -> display list of all items (Create a class called Store?)
		 * 4 Replace an Item in Order -> new interaction method that displays
		 * 	 a list of all customer Orders 
		 * 5 Exit -> Logout if logged in, print Goodbye message and close Scanner connection
		 *  */
		// switch case w/ sub menu interaction choices mapped to sub interaction methods
			ConsolePrinter consolePrinter = new ConsolePrinter();
			consolePrinter.printMainMenu();
			String choice = takeInput();
			
			switch(choice) {
			case "1":
				consolePrinter.printAccountCreation();
				//determineNextInteraction();
				break;
			case "2":
				consolePrinter.displayCustomerLogin();
				//determineNextInteraction();
				break;
			case "3":
				consolePrinter.displayExitScreen();
				closeConnection();
				break;
			default:
				consolePrinter.displayInvalidChoice();
				//determineNextInteraction();
				break;
			}
	}
	
	public String takeInput() {
		return input.nextLine().trim();
	}
	
	public void closeConnection() {
		input.close();
	}
	
}
