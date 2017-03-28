package abs.model;

import java.util.HashMap;
import java.util.Map;

import abs.model.users.Customer;
import abs.model.users.Owner;

public class AbsMaps {
	
	protected HashMap<String, Owner> ownerMap = new HashMap<String, Owner>();
	protected HashMap<String, Customer> customerMap = new HashMap<String, Customer>();
	
	public void addOwner(Owner owner) {
		ownerMap.put(owner.getUserName(), owner);
	}
	
	public Owner getOwner(String userName) {
		return ownerMap.get(userName);
	}
	
	public void addCustomer(Customer customer) {
		customerMap.put(customer.getUserName(), customer);
	}
	
	public Customer getCustomer(String userName) {
		return customerMap.get(userName);
	}
	
	public void displayAllCustomers()
	{
		for (Customer customer : customerMap.values())
			System.out.println(customer);
	}
	
	public HashMap<String, Owner> getOwnerMap() {
		return ownerMap;
	}
	
	public HashMap<String, Customer> getCustomerMap() {
		return customerMap;
	}
	
	public boolean customerValidation(String username, String password) {
		for (Customer customer : customerMap.values()) {
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
		for (Owner owner : ownerMap.values()) {
			if (owner.getUserName().equals(username)) {
				if (owner.getUserPassword().equals(password)) {
					System.out.println("Welcome, Owner.");
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean userNameExists(String userName) {
		
		for(Customer customer : customerMap.values()) {
			if(customer.getUserName().equals(userName)) {
				return true;
			}
		}
		return false;
	}

}
