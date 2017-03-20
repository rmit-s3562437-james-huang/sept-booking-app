package abs.model;

import java.util.Scanner;

import abs.model.data.AbstractData;
import abs.model.data.CustomerData;
import abs.model.users.Owner;

public class AbsMenuImpl {

	AbsDisplayMenuImpl dm = new AbsDisplayMenuImpl();
	
	public void initialMenu() {
		dm.printMainMenu();
		dm.printChoice();

		Scanner scan = new Scanner(System.in);
		int selected;
		boolean exit = false;
		do {
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
		boolean exit = false;
		do {
			selected = scan.nextInt();
			switch(selected) {
			case 1:
				initialMenu();
				break;
			case 2:
				dm.printExit();
				exit = true;
				break;
			}
		} while (!exit);
	}
	
	public void loginMenu() {
		AbstractData data = new CustomerData();
		System.out.println();
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter username: ");
		String username = scan.nextLine();
		System.out.print("Enter password: ");
		String password = scan.nextLine();
		data.validateUser(username, password);
	}
	
	public void customerMenu() {
		
	}
	
	public void ownerMenu() {
		
	}
}
