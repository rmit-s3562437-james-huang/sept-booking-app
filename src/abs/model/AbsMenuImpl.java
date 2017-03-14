package abs.model;

import java.util.Scanner;

public class AbsMenuImpl {
	
	public void initialMenu() {
		printMainMenu();
		printChoice();
		Scanner scan = new Scanner(System.in);
		int selected;
		boolean exit = false;
		do {
			selected = scan.nextInt();
			switch(selected) {
			case 1:
				printLoginMenu();
				loginMenu();
				break;
			case 2:
				printRegisterMenu();
				registerMenu();
				break;
			case 3:
				printExit();
				exit = true;
				break;
			}
		} while (!exit);
	}
	
	public void registerMenu() {
		Scanner scan = new Scanner(System.in);
		int selected;
		boolean exit = false;
		do {
			selected = scan.nextInt();
			switch(selected) {
			case 1:
				initialMenu();
				break;
			case 2:
				printExit();
				exit = true;
				break;
			}
		} while (!exit);
	}
	
	public void loginMenu() {
		Scanner scan = new Scanner(System.in);
		int selected;
		boolean exit = false;
		do {
			selected = scan.nextInt();
			switch(selected) {
			case 1:
				printLoginMenu();
				loginMenu();
				break;
			case 2:
				printRegisterMenu();
				registerMenu();
				break;
			case 3:
				printExit();
				exit = true;
				break;
			}
		} while (!exit);
	}
	
	public void customerMenu() {
		
	}
	
	public void ownerMenu() {
		
	}
	
	public void printMainMenu() {
		System.out.println("Application Booking System");
		System.out.println("==========================");
		System.out.println("1. Login");
		System.out.println("2. Register");
		System.out.println("3. Exit");
		System.out.println("==========================");
	}
	
	public void printLoginMenu() {
		System.out.println("Login Menu");
		System.out.println("==========================");
		System.out.println("Username: ");
		System.out.println("Password: ");
		System.out.println("==========================");
	}
	
	public void printRegisterMenu() {
		System.out.println("Register Menu");
		System.out.println("==========================");
		System.out.println("1. Back");
		System.out.println("2. Exit");
		System.out.println("==========================");
		printChoice();

	}
	
	public void printCustomerMenu() {
		System.out.println("Client Menu");
		System.out.println("==========================");
		System.out.println("1. Back");
		System.out.println("2. Exit");
		System.out.println("==========================");
		printChoice();
	}
	
	public void printOwnerMenu() {
		System.out.println("Owner Menu");
		System.out.println("==========================");
		System.out.println("1. Display owner details");
		System.out.println("2. Back");
		System.out.println("3. Exit");
		System.out.println("==========================");
		printChoice();
	}
	
	public void printChoice() {
		System.out.print("Press a number to continue: ");
	}
	
	public void printExit() {
		System.out.println("Session closed");
	}
}
