package abs.model.users;

import java.io.*;

public class Owner extends Client{
	

	private String businessName;
	private File ownerInfo = new File("ownerInfo.txt");
	
	///public Owner()
	{
		///Open ownerInfo.txt
		///Extract businessName, name, userName, userPassword,
		///userAddress, userPhoneNumber
		
		///super(name, userName, userPassword, userAddress, userPhoneNumber, "Owner");
		///this.businessName = businessName;
	}
	
	///public void addEmployee(String userName, String userPassword, String userAddress, 
							///String userPhoneNumber, String employeeID)
	{
		///Employee newEmployee = new Employee(userName, userPassword, userAddress, 
							///userPhoneNumber, employeeID);
		
		///Write new employee information into employees.txt?
	}
	
	///public void removeEmployee(String EmployeeID)
	{
		///Open employees.txt?
		///Find employee information based of employeeID?
		///Remove employee information?
		///Close employees.txt?
	}
}
