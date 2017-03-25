package abs.model.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import abs.model.AbsFileOperationImpl;
import abs.model.users.Customer;
import abs.model.users.Owner;

public abstract class AbstractData {

	//public final static String PATH = "D:\\Repositories\\SEPT2017\\SEPT2017\\";
	public final static String PATH = "/Users/James/git/SEPT2017/";
	//public final static String PATH = "C:\\Users\\Sotoam Bak\\Documents\\Repositories\\SEPT2017\\SEPT2017\\";
	public final static String CUSTOMERFILE = "customerInfo";
	public final static String OWNERFILE = "ownerInfo";
	
	protected Map<String, Owner> ownerMap;
	protected Map<String, Customer> customerMap;
	
	protected Owner owner;
	protected Customer customer;
	
	private AbsFileOperationImpl ownerfo = new AbsFileOperationImpl(PATH, OWNERFILE);
	private AbsFileOperationImpl customerfo = new AbsFileOperationImpl(PATH, CUSTOMERFILE);
	
	public AbstractData() {
		ownerMap = new HashMap<String, Owner>();
		customerMap = new HashMap<String, Customer>();
		addOwner(owner = ownerfo.readFromOwner());
		readFromCustomer();
	}
	
	public void readFromCustomer() {
		
		Customer customer = null;
		String path = PATH + CUSTOMERFILE + ".txt";
		Path file = Paths.get(path);
		
		try (BufferedReader reader = Files.newBufferedReader(file)) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] data = line.split("\\,\\ "); 
				customer = new Customer(data[0].toString(), data[1].toString(), data[2].toString(),
						data[3].toString(), data[4].toString());
				addCustomer(customer);
			}
			
		} catch(IOException e) {
			System.err.println("HAH IT FUCKED UP!");
		}
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
	
	public Customer getCustomer() {
		return customer;
	}
	
	public Map<String, Customer> getCustomerMap() {
		return customerMap;
	}
	
	/*public boolean validateUser(String username, String password) {

		for (Owner owner : getOwnerMap().values()) {
			if (owner.getUserName().equals(username)) {
				//System.out.println("username valid!");
				if (owner.getUserPassword().equals(password)) {
					//System.out.println("password valid!");
					System.out.println("Welcome, Owner.");
					return true;
				}
			}
		}
		
		for (Customer customer : getCustomerMap().values()) {
			if (customer.getUserName().equals(username)) {
				//System.out.println("username valid!");
				if (customer.getUserPassword().equals(password)) {
					//System.out.println("password valid!");
					System.out.println("Welcome, " + username + ".");
					return true;
				}
			}
		}
		
		System.out.println("ERROR: username or password invalid!");
		return false;
	}*/
	
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
		
		customerfo.primeCustomerFile();
		
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
				customerfo.writeToCustomerFile(customerString, true);
			}
			else {
				customerfo.writeToCustomerFile(customerString, false);
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
	
	public void printMapKeys() {
		for(Customer customer : getCustomerMap().values()) {
			System.out.println("==========================");
			System.out.println(customer.toString());
			System.out.println("==========================");
		}
	}
	
	public void changeCustomerPassword(String userName) {
		String newPassword;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please enter a new passord:");
		newPassword = scan.nextLine();
		
		//customerMap.get(userName);
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

}
