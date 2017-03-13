package abs.model.users;

public class Employee extends Client {
	
	private String employeeID;
	
	public Employee(String name, String userName, String userPassword, String userAddress, 
			String userPhoneNumber, String userRole, String EmployeeID)
	{
		super(name, userName, userPassword, userAddress, userPhoneNumber, userRole);
		this.employeeID = employeeID;
	}
	
}
