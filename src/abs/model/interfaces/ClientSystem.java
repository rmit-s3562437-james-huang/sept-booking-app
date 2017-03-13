package abs.model.interfaces;

import abs.model.users.Customer;
import abs.model.users.Owner;

public interface ClientSystem {
	
	public abstract void addCustomer(Customer customer);
	
	public abstract void displayOwnerInfo(Owner owner);
	
	public abstract void addOwner(Owner owner);
}
