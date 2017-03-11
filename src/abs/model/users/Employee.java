package abs.model.users;

public class Employee extends Client{
	
	private String userRole = "Employee";
	private String employeeID;
	
	public Employee(String userName, String userPassword, String userAddress, String userPhoneNumber, String EmployeeID)
	{
		super(userName, userPassword, userAddress, userPhoneNumber);
		this.employeeID = employeeID;
	}
	
}
