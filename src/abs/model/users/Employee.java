package abs.model.users;

public class Employee extends Client{
	
	private String userRole = "Employee";
	private String employeeID;
	
	public Employee(String name, String userName, String userPassword, String userAddress, 
			String userPhoneNumber, String EmployeeID)
	{
		super(name, userName, userPassword, userAddress, userPhoneNumber, "Employee");
		this.employeeID = employeeID;
	}
	
}
