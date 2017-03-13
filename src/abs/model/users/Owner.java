package abs.model.users;

public class Owner extends AbstractClient{

	private String businessName;
	
	public Owner(String name, String userName, String userPassword, String userAddress, 
			String userPhoneNumber, String userRole, String businessName) {
		super(name, userName, userPassword, userAddress, userPhoneNumber, userRole);
		this.businessName = businessName;
	}
	
	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String toString() {
		return  "Name: " + this.getName()
				+ "\nUsername: " + this.getUserName()
				+ "\nPassword: " + this.getUserPassword()
				+ "\nPhone number: " + this.getUserPhoneNumber()
				+ "\nUser role: " + this.getUserRole()
				+ "\nBusiness: " + this.getBusinessName();
	}

	
}
