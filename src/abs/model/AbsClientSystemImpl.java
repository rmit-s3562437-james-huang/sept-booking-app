package abs.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import abs.model.interfaces.ClientSystem;
import abs.model.users.Customer;
import abs.model.users.Owner;

public class AbsClientSystemImpl implements ClientSystem {
	
	public void displayOwnerInfo(Owner owner) {
		System.out.println("Business Owner Information");
		System.out.println("==========================");
		System.out.println(owner.toString());
		System.out.println("==========================");
	}
	

}
