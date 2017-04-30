package abs.model.users;

public class Employee extends AbstractClient {
	
	public Employee(String name, String userName, String userPassword, String userAddress, 
			String userPhoneNumber) 
	{
		super(name, userName, userPassword, userAddress, userPhoneNumber, "Employee");
	}
	
}
