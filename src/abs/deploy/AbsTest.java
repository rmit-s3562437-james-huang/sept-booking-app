package abs.deploy;

import abs.model.AbsLoginImpl;
import abs.model.AbsMenuImpl;
import abs.model.AbsOwnerDataImpl;
import abs.model.AbsRegisterImpl;
import abs.model.users.Customer;
import abs.model.users.Owner;
import abs.model.AbsClientSystemImpl;
import abs.model.AbsCustomerDataImpl;

public class AbsTest {
	
	public static void main(String[] args)
	{
		//AbsOwnerDataImpl od = new AbsOwnerDataImpl();
		AbsCustomerDataImpl cd = new AbsCustomerDataImpl();
		//AbsClientSystemImpl cs = new AbsClientSystemImpl();
		
		//Owner initOwner = od.getOwner();
		//od.addOwner(initOwner);
		
		//cs.displayOwnerInfo(initOwner);
		
		System.out.println(cd.getCustomerMap().get("sandra1").getName());
		
		
//		System.out.print("Enter owner username: ");
//		od.readUsername();
//		System.out.print("Enter owner password: ");
//		od.readPassword();
		
		
		
	}

}
