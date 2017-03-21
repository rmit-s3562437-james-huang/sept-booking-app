package abs.model.users;

public class Customer extends AbstractClient{

	
	public Customer(String name, String userName, String userPassword, String userAddress, String userPhoneNumber) 
	{
		super(name, userName, userPassword, userAddress, userPhoneNumber, "Customer");
	}
	
	public String toString() {
		return  "\nName: " + this.getName()
				+ "\nUsername: " + this.getUserName()
				+ "\nPassword: " + this.getUserPassword()
				+ "\nPhone number: " + this.getUserPhoneNumber()
				+ "\nUser role: " + this.getUserRole();
	}
}
