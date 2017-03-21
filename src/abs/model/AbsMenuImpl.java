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
				break;
		}
	}
	
	public void loginMenu() {
		System.out.println();
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter username: ");
		String username = scan.nextLine();
		System.out.print("Enter password: ");
		String password = scan.nextLine();
		if(data.validateUser(username, password) == true) {
			data.changeCustomerPassword(username);
		}
	}
	
	public void customerMenu() {
		
	}
	
	public void ownerMenu() {
		
	}
}
