package abs.model.users;

public class Customer extends Client{

	private String userRole = "Customer";
	
	public Customer(String userName, String userPassword, String userAddress, String userPhoneNumber)
	{
		super(userName, userPassword, userAddress, userPhoneNumber);
	}
	
}
