package abs.model.users;

public class Customer extends AbstractClient{

	
	public Customer(String name, String userName, String userPassword, String userAddress, String userPhoneNumber) 
	{
		super(name, userName, userPassword, userAddress, userPhoneNumber, "Customer");
	}
	
}
