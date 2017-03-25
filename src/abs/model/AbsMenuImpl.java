package abs.model;

import java.util.Scanner;

import abs.model.data.AbstractData;
import abs.model.data.CustomerData;
import abs.model.users.Owner;

public class AbsMenuImpl {

	AbsDisplayMenuImpl dm = new AbsDisplayMenuImpl();
	AbstractData data = new CustomerData();
	
	public void initialMenu() {
		
		Scanner scan = new Scanner(System.in);
		int selected;
		boolean exit = false;
		do {
			dm.printMainMenu();
			dm.printChoice();
			selected = scan.nextInt();
			switch(selected) {
			case 1:
				loginMenu();
				break;
			case 2:
				dm.printRegisterMenu();
				registerMenu();
				break;
			case 3:
				dm.printExit();
				exit = true;
				break;
			}
		} while (!exit);
	}
	
	public void loginMenu() {
		System.out.println();
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter username: ");
		String username = scan.nextLine();
		System.out.print("Enter password: ");
		String password = scan.nextLine();
		if(data.ownerValidation(username, password) == true) {
			ownerMenu(username);
		}
		else if(data.customerValidation(username, password) == true) {
			customerMenu(username);
		}
		else {
			System.out.println("Sorry, those credentials are invalid.");
		}
		System.out.println();

	}

	public void registerMenu() {
		Scanner scan = new Scanner(System.in);
		int selected;
		selected = scan.nextInt();
		switch(selected) {
			case 1:
				initialMenu();
				break;
			case 2:
				data.registerCustomer();
				break;
			case 3:
				System.out.println();
				break;
		}
	}
	
	public void customerMenu(String username) {
		Scanner scan = new Scanner(System.in);
		int selected;
		boolean logout = false;
		do {
			dm.printVerifiedCustomerMenu();
			selected = scan.nextInt();
			switch(selected) {
				case 1:
					System.out.println();
					System.out.println(data.getCustomerMap().get(username).toString());
					break;
				case 2:
					//change password
					data.changeCustomerPassword(username);
					break;
				case 3:
					dm.printEditCustomer();
					dm.printChoice();
					data.editCustomerInformation(username);
					break;
				case 4:
					System.out.println();
					logout = true;
					break;
			} 
		} while (logout == false);
	}
	
	public void ownerMenu(String username) {
		Scanner scan = new Scanner(System.in);
		int selected;
		boolean logout = false;
		do {
			dm.printVerifiedOwnerMenu();
			selected = scan.nextInt();
			switch(selected) {
				case 1:
					System.out.println(data.getOwnerMap().get(username).toString());
					break;
				case 2:
					data.printCustomerMap();
					break;
				case 3:
					logout = true;
					break;
			} 
		} while (logout == false);
	}
	
	
}
