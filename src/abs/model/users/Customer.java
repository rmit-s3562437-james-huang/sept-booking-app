package abs.model.users;

public class Customer extends AbstractClient {

	
	public Customer(String name, String userName, String userPassword, String userAddress, String userPhoneNumber) 
	{
		super(name, userName, userPassword, userAddress, userPhoneNumber, "Customer");
	}
	
	public String toString() {
		return  "Name: " + this.getName()
				+ "\nUsername: " + this.getUserName()
				+ "\nPassword: " + this.getUserPassword()
				+ "\nAddress: " + this.getUserAddress()
				+ "\nPhone number: " + this.getUserPhoneNumber()
				+ "\nUser role: " + this.getUserRole();
	}
}
