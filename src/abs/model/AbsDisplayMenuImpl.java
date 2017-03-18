package abs.model;

public class AbsDisplayMenuImpl extends AbsMenuImpl {
	
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
		System.out.println("1. Login as owner");
		System.out.println("2. Login as customer");
		System.out.println("==========================");
	}
	
	public void printRegisterMenu() {
		System.out.println();
		System.out.println("Register Menu");
		System.out.println("==========================");
		System.out.println("1. Back");
		System.out.println("2. Exit");
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
	
	public void printOwnerMenu() {
		System.out.println();
		System.out.println("Owner Menu");
		System.out.println("==========================");
		System.out.println("1. Display owner details");
		System.out.println("2. Back");
		System.out.println("3. Exit");
		System.out.println("==========================");
		printChoice();
	}
	
	public void printChoice() {
		System.out.print("Press a number: ");
	}
	
	public void printExit() {
		System.out.println("Session closed");
	}
}
