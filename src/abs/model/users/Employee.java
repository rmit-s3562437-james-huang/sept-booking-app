package abs.model.users;

import java.util.Date;

public class Employee extends AbstractClient {
	
	private String employeeID;
	private Date availability;
	
	
	public Employee(String name, String userName, String userPassword, String userAddress, 
			String userPhoneNumber, String userRole, String EmployeeID, Date availability) 
	{
		super(name, userName, userPassword, userAddress, userPhoneNumber, userRole);
		this.employeeID = employeeID;
		this.availability = availability;
	}


	public Date getAvailability() {
		return availability;
	}


	public void setAvailability(Date availability) {
		this.availability = availability;
	}
	
}
