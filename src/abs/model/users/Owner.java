package abs.model.users;

import java.io.*;

public class Owner extends Client{
	

	private String businessName;
	private File ownerInfo = new File("ownerInfo.txt");
	
	public Owner(String name, String userName, String userPassword, String userAddress, 
			String userPhoneNumber, String userRole, String businessName)
	{
		super(name, userName, userPassword, userAddress, userPhoneNumber, userRole);
		this.businessName = businessName;
	}	
}
