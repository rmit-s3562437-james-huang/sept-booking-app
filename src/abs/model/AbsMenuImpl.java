package abs.model;

import java.util.Scanner;

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
				dm.printLoginMenu();
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
		Scanner scan = new Scanner(System.in);
		int selected;
		boolean exit = false;
		do {
			selected = scan.nextInt();
			switch(selected) {
			case 1:
				dm.printLoginMenu();
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
	
	public void customerMenu() {
		
	}
	
	public void ownerMenu() {
		
	}
}
