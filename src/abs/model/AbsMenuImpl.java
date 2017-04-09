package abs.model;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import abs.model.bookings.Booking;
import abs.model.users.Customer;

public class AbsMenuImpl {
	
	AbsDisplayMenus dm = new AbsDisplayMenus();
	
	/* TODO: add booking implementations 
	 * call methods to read create and write bookings */
	
	public void initializeMenu(AbsMaps absMaps, AbsClientSystemImpl cs, HashMap<String, Customer> map, 
			AbsFileOperationImpl fo, String writePath, String writeBookingPath, HashMap<String, Booking> bookingMap) {
		
		Scanner scan = new Scanner(System.in);
		int selected;
		String input;
		boolean exit = false;
		do {
			dm.printMainMenu();
			dm.printChoice();
			input = scan.nextLine();
			selected = checkChoice(input);
			switch(selected) {
			case 1:
				loginMenu(absMaps, cs, map, fo, writePath, writeBookingPath, bookingMap);
				break;
			case 2:
				dm.printRegisterMenu();
				registerMenu(absMaps, cs, map, fo, writePath, writeBookingPath, bookingMap);
				break;
			case 3:
				dm.printExit();
				exit = true;
				break;
			default:
				System.out.println("Please choose a valid option.");	
			}
			
		} while (!exit);
	}
	
	public void loginMenu(AbsMaps absMaps, AbsClientSystemImpl cs, HashMap<String, Customer> map,
			AbsFileOperationImpl fo, String writePath, String writeBookingPath, HashMap<String, Booking> bookingMap) {
		System.out.println();
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter username: ");
		String username = scan.nextLine();
		System.out.print("Enter password: ");
		String password = scan.nextLine();
		if(absMaps.ownerValidation(username, password) == true) {
			ownerMenu(username, absMaps, cs, map);
		}
		else if(absMaps.customerValidation(username, password) == true) {
			customerMenu(username, absMaps, cs, map, fo, writePath, writeBookingPath, bookingMap);
		}
		else {
			System.out.println("Sorry, those credentials are invalid.");
		}
		System.out.println();

	}

	public void registerMenu(AbsMaps absMaps, AbsClientSystemImpl cs, HashMap<String, Customer> map, 
			AbsFileOperationImpl fo, String writePath, String writeBookingPath, HashMap<String, Booking> bookingMap) {
		Scanner scan = new Scanner(System.in);
		int selected;
		String input;
		input = scan.nextLine();
		selected = checkChoice(input);
		switch(selected) {
			case 1:
				initializeMenu(absMaps, cs, map, fo, writePath, writeBookingPath, bookingMap);
				break;
			case 2:
				cs.registerCustomer(map);
				fo.compileCustomerMapStrings(writePath, map);
				break;
			case 3:
				System.out.println();
				break;
			default:
				System.out.println("Please choose a valid option.");
		}
	}
	
	public void customerMenu(String username, AbsMaps absMaps, AbsClientSystemImpl cs, HashMap<String, Customer> map,
			AbsFileOperationImpl fo, String writePath, String writeBookingPath, HashMap<String, Booking> bookingMap) {
		Scanner scan = new Scanner(System.in);
		String input;
		int selected;
		boolean logout = false;
		do {
			dm.printVerifiedCustomerMenu();
			input = scan.nextLine();
			selected = checkChoice(input);
			
			switch(selected) {
				case 1:
					System.out.println();
					System.out.println(absMaps.getCustomerMap().get(username).toString());
					break;
				case 2:
					//change password
					cs.changeCustomerPassword(username, map);
					fo.compileCustomerMapStrings(writePath, map);
					break;
				case 3:
					dm.printEditCustomer();
					dm.printChoice();
					cs.editCustomerInformation(username, map);
					fo.compileCustomerMapStrings(writePath, map);
					break;
				case 4:
					absMaps.displayUserBookings(username);
					break;
				case 5:
					absMaps.displayAllBookings();
					break;
				case 6:
					absMaps.bookByTimeOfDay(username);
					fo.compileBookingMapStrings(writeBookingPath, bookingMap);
					break;
				case 7:
					absMaps.bookByDentist(username);
					fo.compileBookingMapStrings(writeBookingPath, bookingMap);
					break;
				case 8: 	
					absMaps.removeBooking(username);
					fo.compileBookingMapStrings(writeBookingPath, bookingMap);
					break;
				case 9:
					System.out.println();
					logout = true;
					break;
				default:
					System.out.println("Please choose a valid option.");
			} 
		} while (logout == false);
	}
	
	public void ownerMenu(String username, AbsMaps absMaps, AbsClientSystemImpl cs, HashMap<String, Customer> map) {
		Scanner scan = new Scanner(System.in);
		int selected;
		String input;
		boolean logout = false;
		do {
			dm.printVerifiedOwnerMenu();
			input = scan.nextLine();
			selected = checkChoice(input);
			switch(selected) {
				case 1:
					System.out.println(absMaps.getOwnerMap().get(username).toString());
					break;
				case 2:
					cs.printCustomerMap(map);
					break;
				case 3:
					logout = true;
					break;
				default:
					System.out.println("Please choose a valid option.");
			} 
		} while (logout == false);
	}
	
	public int checkChoice(String choice){
		
		int ret;
		
		if (choice.matches("[0-9]+")){
			ret = Integer.parseInt(choice);
		}
		else {
			ret = 0;
		}
		
		return ret;
	}
	
}
