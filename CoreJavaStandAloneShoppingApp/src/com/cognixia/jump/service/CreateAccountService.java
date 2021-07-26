package com.cognixia.jump.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreateAccountService {

	// this may take the code that is currently in LoginService
	// validating that email and password are valid formats
	// then processing customer information into a customer object
	// store a collection of valid customer objects in the LoginService?
	
	// 1) When creating an account, check for valid email and password format w/ regex
	private String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
	private Pattern emailPattern = Pattern.compile(emailRegex);
	private String passwordRegex = "[A-Za-z0-9]{6,}";
	private Pattern passwordPattern = Pattern.compile(passwordRegex);
	
	// TODO: way to make one validateField method?
	public boolean validateEmail(String email) {
		
		 Matcher matcher = emailPattern.matcher(email);
		 if(!matcher.matches()) {
			 System.out.println("Invalid email address.");
			 return false;
		 }
		 return true;
	}
	
	public boolean validatePassword(String password) {
		
		 Matcher matcher = passwordPattern.matcher(password);
		 if(!matcher.matches()) {
			 System.out.println("Invalid password format.");
			 return false;
		 }
		 return true;
	}
	
}
