package abs.model;

import java.util.HashMap;
import java.util.Scanner;

import abs.model.users.Customer;

public class AbsClientSystemImpl {
	
	public void registerCustomer(HashMap<String, Customer> map) {
		
		Scanner scan = new Scanner(System.in);
		String name, userName, password, address, phoneNumber;
		
		boolean valid = false;
		
		do {
			System.out.println("Please enter your desired username:");
			userName = scan.nextLine();
			if(map.containsKey(userName) || userName.equals("")) {
				System.out.println("That username has already been taken by another user.");
				System.out.println("Please enter another one");
				userName = "";
			}
			else {
				valid = true;
			}
		} while(valid == false);
		
		valid = false;
		
		do {
			System.out.println("Please your desired password:");
			password = scan.nextLine();
			if(password.equals(""))
			{
				System.out.println("Your password cannot be an empty string.");
				System.out.println("Please enter a non-empty string.");
			}
			else {
				valid = true;
			}
		} while (valid == false);
		
		valid = false;
		
		do {
			System.out.println("Please enter your first name:");
			name = scan.nextLine();
			
			if(name.equals("")) {
				System.out.println("Your name cannot be an empty string.");
			}
			else {
				valid = true;
			}
		} while (valid == false);
		
		valid = false;
		
		do {
			System.out.println("Please enter your address:");
			address = scan.nextLine();
			
			if(address.equals("")) {
				System.out.println("Your address cannot be an empty string.");
			}
			else {
				valid = true;
			}
		} while(valid == false);
		
		valid = false;
		
		do {
			System.out.println("Please enter your phone number:");
			phoneNumber = scan.nextLine();
			
			if(phoneNumber.equals("")) {
				System.out.println("You phone number cannot be an empty string.");
			}
			else {
				valid = true;
			}
		} while(valid == false);
		
		Customer newCustomer = new Customer(name, userName, password, address, phoneNumber);
		
		map.put(newCustomer.getUserName(), newCustomer);
	}
	
	public void changeCustomerPassword(String userName, HashMap<String, Customer> map) {
		String newPassword;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please enter a new passord:");
		newPassword = scan.nextLine();
		
		map.get(userName).setUserPassword(newPassword);
	}
	
	public void printCustomerMap(HashMap<String, Customer> map) {
		for(Customer customer : map.values()) {
			System.out.println("\n==========================");
			System.out.println(customer.toString());
			System.out.println("==========================\n");
		}
	}
	
	public void editCustomerInformation(String userName, HashMap<String, Customer> map) {
		String newName, newUser, newPass, newAddress, newPhoneNumber;
		Scanner scan = new Scanner(System.in);
		
		boolean back = false;
		int opt;
		
		do {
			opt = scan.nextInt();
			switch(opt) {
				case 1:
					System.out.print("\nEnter new Username: ");
					newUser = scan.next();
					map.get(userName).setUserName(newUser);
					System.out.print("Choose an option: ");
					break;
				case 2:
					System.out.print("\nEnter new Name: ");
					newName = scan.next();
					map.get(userName).setName(newName);
					System.out.print("Choose an option: ");
					break;
				case 3:
					System.out.print("\nEnter new Address: ");
					newAddress = scan.next();
					map.get(userName).setUserAddress(newAddress);
					System.out.print("Choose an option: ");
					break;
				case 4:
					System.out.print("\nEnter new Phone number: ");
					newPhoneNumber = scan.next();
					map.get(userName).setUserPhoneNumber(newPhoneNumber);
					System.out.print("Choose an option: ");
					break;
				case 5:
					back = true;
					break;
			}
		} while (!back);
	}
}
