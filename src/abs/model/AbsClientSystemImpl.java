package abs.model;

import java.util.HashMap;
import java.util.Map;

import abs.model.interfaces.ClientSystem;
import abs.model.users.Customer;
import abs.model.users.Owner;

public class AbsClientSystemImpl implements ClientSystem {
	
	private Map<String, Owner> ownerMap = new HashMap<String, Owner>();
	private Map<String, Customer> custMap = new HashMap<String, Customer>();
	
	public void addOwner(Owner owner) {
		ownerMap.put(owner.getUserName(), owner);
	}
	
	public void addCustomer(Customer customer) {
		custMap.put(customer.getUserName(), customer);
	}
	
	public void displayOwnerInfo(Owner owner) {
		System.out.println(owner.toString());
	}
	
	
}
