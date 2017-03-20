package abs.deploy;

import abs.model.AbsLoginImpl;
import abs.model.AbsMenuImpl;
import abs.model.AbsRegisterImpl;
import abs.model.data.AbstractData;
import abs.model.data.CustomerData;
import abs.model.interfaces.Client;
import abs.model.interfaces.Data;
import abs.model.users.AbstractClient;
import abs.model.users.Customer;
import abs.model.users.Owner;
import abs.model.AbsClientSystemImpl;

public class AbsTest {
	
	public static void main(String[] args)
	{
		AbstractData data = new CustomerData();
		AbsMenuImpl menu = new AbsMenuImpl();
		
		menu.initialMenu();
		
	}

}
