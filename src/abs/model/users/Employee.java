package abs.model.users;

import java.time.LocalDateTime;

public class Employee extends AbstractClient {
	
	private String availability;
	
	public Employee(String name, String userName, String userPassword, String userAddress, 
			String userPhoneNumber, String userRole, String EmployeeID, String availability) 
	{
		super(name, userName, userPassword, userAddress, userPhoneNumber, userRole);
		this.availability = availability;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	
}
