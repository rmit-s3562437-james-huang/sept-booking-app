package abs.model.data;

import java.nio.file.Path;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import abs.model.AbsFileOperationImpl;
import abs.model.booking.Booking;
import abs.model.interfaces.Book;
import abs.model.interfaces.Data;
import abs.model.interfaces.FileOperation;
import abs.model.users.Customer;
import abs.model.users.Owner;

public abstract class AbstractData implements Data {
	
	private static Logger logger = Logger.getLogger("absLogging");
	
	protected Map<String, Owner> ownerMap;
	protected Map<String, Customer> customerMap;
	protected Map<String, Booking> bookingMap;
	
	protected Owner owner;
	protected Customer customer;
	
	private Book availability;
	
	FileOperation fo = new AbsFileOperationImpl();
	
	public AbstractData() {
		ownerMap = new HashMap<String, Owner>();
		customerMap = new HashMap<String, Customer>();
		readFromCustomer(CUSTOMERFILEPATH);
		readFromOwner(OWNERFILEPATH);
	}
	
	public void addOwner(Owner owner) {
		ownerMap.put(owner.getUserName(), owner);
	}
	
	public Owner getOwner() {
		return owner;
	}
	
	public Map<String, Owner> getOwnerMap() {
		return ownerMap;
	}
	
	public void addCustomer(Customer customer) {
		customerMap.put(customer.getUserName(), customer);
	}
	
	public Customer getCustomer(String userName) {
		if (customer.getName() == userName) {
			return customer;
		}
		return customer;
	}
	
	public Map<String, Customer> getCustomerMap() {
		return customerMap;
	}
	
	public void readFromCustomer(Path path) {
		String[] data; 
		for (int i = 0; i < fo.readFromFile(path).size() ; i++) {
			data = fo.readFromFile(path).get(i).split(REGEX);
			customer = new Customer(data[0].toString(), data[1].toString(), data[2].toString(),
					data[3].toString(), data[4].toString());
			addCustomer(customer);
			logger.log(Level.INFO, customer.toString());
		}
	}
	
	public void readFromOwner(Path path) {
		String[] data; 
		for (int i = 0; i < fo.readFromFile(path).size() ; i++) {
			data = fo.readFromFile(path).get(i).split(REGEX);
			owner = new Owner(data[0].toString(), data[1].toString(), data[2].toString(), data[3].toString(),
					data[4].toString(), data[5].toString(), data[6].toString());
			addOwner(owner);
			logger.log(Level.INFO, owner.toString());
		}
	}
	
	public boolean customerValidation(String username, String password) {
		for (Customer customer : getCustomerMap().values()) {
			if (customer.getUserName().equals(username)) {
				if (customer.getUserPassword().equals(password)) {
					System.out.println("Welcome, " + username + ".");
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean ownerValidation(String username, String password) {
		for (Owner owner : getOwnerMap().values()) {
			if (owner.getUserName().equals(username)) {
				if (owner.getUserPassword().equals(password)) {
					System.out.println("Welcome, Owner.");
					return true;
				}
			}
		}
		return false;
	}
	
	public void registerCustomer() {
		
		Scanner scan = new Scanner(System.in);
		String name, userName, password, address, phoneNumber;
		
		boolean valid = false;
		
		do {
			System.out.println("Please enter your desired username:");
			userName = scan.nextLine();
			if(userNameExists(userName) == true || userName.equals("")) {
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
		
		addCustomer(newCustomer);
		compileCustomerMapStrings();
	}
	
	public void compileCustomerMapStrings() {
		
		String name, userName, password, address, phoneNumber;
		String delim = ", ";
		String customerString;
		int count = 0;
		
		fo.primeCustomerFile(CUSTOMERWRITEFILEPATH);
		
		for(Customer customer : getCustomerMap().values()) {
			name = customer.getName();
			userName = customer.getUserName();
			password = customer.getUserPassword();
			address = customer.getUserAddress();
			phoneNumber = customer.getUserPhoneNumber();
			
			count++;
			customerString = name + delim + userName + delim + 
					password + delim + address + 
					delim + phoneNumber;
			
			if(count < getCustomerMap().size()) {
				fo.writeToCustomerFile(CUSTOMERWRITEFILEPATH, customerString, true);
			}
			else {
				fo.writeToCustomerFile(CUSTOMERWRITEFILEPATH, customerString, false);
			}
		}
	}
	
	public boolean userNameExists(String userName) {
		
		for(Customer customer : getCustomerMap().values()) {
			if(customer.getUserName().equals(userName)) {
				return true;
			}
		}
		
		return false;
	}

	
	public void changeCustomerPassword(String userName) {
		String newPassword;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please enter a new passord:");
		newPassword = scan.nextLine();
		
		customerMap.get(userName).setUserPassword(newPassword);
		compileCustomerMapStrings();
	}
	
	public void printCustomerMap() {
		for(Customer customer : getCustomerMap().values()) {
			System.out.println("\n==========================");
			System.out.println(customer.toString());
			System.out.println("==========================\n");
		}
	}

	public void editCustomerInformation(String userName) {
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
					customerMap.get(userName).setUserName(newUser);
					System.out.print("Choose an option: ");
					break;
				case 2:
					System.out.print("\nEnter new Name: ");
					newName = scan.next();
					customerMap.get(userName).setName(newName);
					System.out.print("Choose an option: ");
					break;
				case 3:
					System.out.print("\nEnter new Address: ");
					newAddress = scan.next();
					customerMap.get(userName).setUserAddress(newAddress);
					System.out.print("Choose an option: ");
					break;
				case 4:
					System.out.print("\nEnter new Phone number: ");
					newPhoneNumber = scan.next();
					customerMap.get(userName).setUserPhoneNumber(newPhoneNumber);
					System.out.print("Choose an option: ");
					break;
				case 5:
					back = true;
					break;
			}
		} while (!back);
		compileCustomerMapStrings();
	}
	
	public boolean scheduleBooking(Date date, String userName) {
		Booking book = new Booking(date);
		bookingMap.put(book.getId(), book);
		
		return book.scheduleBooking(getCustomer(userName));
	}
	
	@Override
	public Book getAvailability() {
		return availability;
	}
	
}
