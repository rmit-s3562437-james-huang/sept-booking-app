package abs.model;

public class AbsDisplayMenus {
	
	public void printMainMenu() {
		System.out.println("Application Booking System");
		System.out.println("==========================");
		System.out.println("1. Login");
		System.out.println("2. Register");
		System.out.println("3. Exit");
		System.out.println("==========================");
	}
	
	public void printLoginMenu() {
		System.out.println();
		System.out.println("Login Menu");
		System.out.println("==========================");
		System.out.println("Enter Username and Password");
		System.out.println("==========================");
	}
	
	public void printRegisterMenu() {
		System.out.println();
		System.out.println("Register Menu");
		System.out.println("==========================");
		System.out.println("1. Back");
		System.out.println("2. Register new Customer");
		System.out.println("3. Exit");
		System.out.println("==========================");
		printChoice();
	}
	
	public void printCustomerMenu() {
		System.out.println();
		System.out.println("Client Menu");
		System.out.println("==========================");
		System.out.println("1. Back");
		System.out.println("2. Exit");
		System.out.println("==========================");
		printChoice();
	}
	
	public void printVerifiedOwnerMenu() {
		System.out.println();
		System.out.println("Owner Menu");
		System.out.println("==========================");
		System.out.println("1. Display owner details");
		System.out.println("2. Print all customer details");
		System.out.println("3. Logout");
		System.out.println("==========================");
		printChoice();
	}
	
	public void printVerifiedCustomerMenu() {
		System.out.println();
		System.out.println("Customer Menu");
		System.out.println("==========================");
		System.out.println("1. Display your details");
		System.out.println("2. Change your password");
		System.out.println("3. Edit your information");
		System.out.println("4. Log Out");
		System.out.println("==========================");
		printChoice();
	}
	
	public void printEditCustomer() {
		System.out.println();
		System.out.println("Edit Customer information");
		System.out.println("==========================");
		System.out.println("1. Username");
		System.out.println("2. Name");
		System.out.println("3. Address");
		System.out.println("4. Phone number");
		System.out.println("5. Complete");
		System.out.println("==========================");
	}
	
	
	public void printChoice() {
		System.out.print("Choose an option: ");
	}
	
	public void printExit() {
		System.out.println("\n\nThank you for using this appointment booking system.");
	}
}
