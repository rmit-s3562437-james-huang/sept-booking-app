package abs.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import abs.model.users.Customer;
import abs.model.users.Owner;

public class AbsCustomerDataImpl {
	
	public final static String PATH = "/Users/James/git/SEPT2017/";
	public final static String CUSTOMERFILE = "customerInfo";
	
	private Map<String, Customer> customerMap;
	
	private AbsFileOperationImpl fo = new AbsFileOperationImpl(PATH, CUSTOMERFILE);
	private Customer customer;
	
	
	public AbsCustomerDataImpl() {
		customerMap = new HashMap<String, Customer>();
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
	
	public void addCustomer(Customer customer) {
		customerMap.put(customer.getUserName(), customer);
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public Map<String, Customer> getCustomerMap() {
		return customerMap;
	}
	
	public void readUsername() {
		Scanner scan = new Scanner(System.in);
		String username = scan.nextLine();
		validateUsername(username);
	}
	
	public void readPassword() {
		Scanner scan = new Scanner(System.in);
		String password = scan.nextLine();
		validatePassword(password);
	}
	
	public boolean validateUsername(String username) {

		for (Customer customer : getCustomerMap().values()) {
			if (customer.getUserName().equals(username)) {
				System.out.println("username valid!");
				return true;
			}
		}
		
		System.out.println("ERROR: username invalid!");
		return false;
	}
	
	public boolean validatePassword(String password) {
		
		for (Customer customer : getCustomerMap().values()) {
			if (customer.getUserPassword().equals(password)) {
				System.out.println("password valid!");
				return true;
			}
		}
		
		System.out.println("ERROR: password invalid!");
		return false;
	}
}
