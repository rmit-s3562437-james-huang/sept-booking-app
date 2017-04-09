package abs.model.interfaces;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import abs.model.users.Customer;
import abs.model.users.Owner;

public interface Data {
	
	public final static String PATHNAME = "D:\\Repositories\\SEPT2017\\SEPT2017\\";
	//public final static String PATHNAME = "/Users/James/git/SEPT2017/";
	public final static String CUSTOMERFILE = "customerInfo";
	public final static String OWNERFILE = "ownerInfo";
	public final static Path CUSTOMERFILEPATH = Paths.get(PATHNAME + CUSTOMERFILE + ".txt");
	public final static Path OWNERFILEPATH = Paths.get(PATHNAME + OWNERFILE + ".txt");
	public final static String CUSTOMERWRITEFILEPATH = PATHNAME + CUSTOMERFILE + ".txt";
	public final static String REGEX =  "\\,\\ ";
	
	public void addOwner(Owner owner);
	
	public Owner getOwner();
	
	public Map<String, Owner> getOwnerMap();
	
	public void addCustomer(Customer customer);
	
	public Customer getCustomer(String userName);
	
	public Map<String, Customer> getCustomerMap();
	
	public void readFromCustomer(Path path);
	
	public void readFromOwner(Path path);
	
	public boolean customerValidation(String username, String password);
	
	public boolean ownerValidation(String username, String password);
	
	public void registerCustomer();
	
	public void compileCustomerMapStrings();
	
	public void changeCustomerPassword(String userName);
	
	public void printCustomerMap();
	
	public void editCustomerInformation(String userName);
	
	public abstract Book getAvailability();
}
