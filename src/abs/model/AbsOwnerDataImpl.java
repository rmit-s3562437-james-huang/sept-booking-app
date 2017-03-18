package abs.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import abs.model.users.Customer;
import abs.model.users.Owner;

public class AbsOwnerDataImpl {

	public final static String PATH = "/Users/James/git/SEPT2017/";
	public final static String OWNERFILE = "ownerInfo";
	
	private Map<String, Owner> ownerMap;
	
	private AbsFileOperationImpl fo = new AbsFileOperationImpl(PATH, OWNERFILE);
	private Owner owner;
	
	
	public AbsOwnerDataImpl() {
		ownerMap = new HashMap<String, Owner>();
		owner = fo.readFromOwner();
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
				
		for (Owner owner : getOwnerMap().values()) {
			if (owner.getUserName().equals(username)) {
				System.out.println("username valid!");
				return true;
			}
		}
		
		System.out.println("ERROR: username invalid!");
		return false;
	}
	
	public boolean validatePassword(String password) {
				
		for (Owner owner : getOwnerMap().values()) {
			if (owner.getUserPassword().equals(password)) {
				System.out.println("password valid!");
				return true;
			}
		}
		
		System.out.println("ERROR: password invalid!");
		return false;
	}
}
