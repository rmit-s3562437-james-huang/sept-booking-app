package abs.model.interfaces;

import java.util.HashMap;

import abs.model.users.Customer;

public interface ClientSystem {

	public abstract void registerCustomer(HashMap<String, Customer> map);

	public abstract void changeCustomerPassword(String userName, HashMap<String, Customer> map);

	public abstract void printCustomerMap(HashMap<String, Customer> map);

	public abstract void editCustomerInformation(String userName, HashMap<String, Customer> map);

	public abstract boolean validUserName(String userName);

	public abstract boolean validPassword(String password);

	public abstract boolean validName(String name);

	public abstract boolean validAddress(String address);

	public abstract boolean validPhoneNumber(String phoneNumber);

}
