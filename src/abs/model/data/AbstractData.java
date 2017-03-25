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

	public final static String PATH = "/Users/James/git/SEPT2017/";
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
	
	/* Add another AbstractData constructor */
	
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
	
	public boolean validateUser(String username, String password) {

		for (Owner owner : getOwnerMap().values()) {
			if (owner.getUserName().equals(username)) {
				System.out.println("username valid!");
				if (owner.getUserPassword().equals(password)) {
					System.out.println("password valid!");
					return true;
				}
			}
		}
		
		for (Customer customer : getCustomerMap().values()) {
			if (customer.getUserName().equals(username)) {
				System.out.println("username valid!");
				if (customer.getUserPassword().equals(password)) {
					System.out.println("password valid!");
					return true;
				}
			}
		}
		
		System.out.println("ERROR: username or password invalid!");
		return false;
	}

}
