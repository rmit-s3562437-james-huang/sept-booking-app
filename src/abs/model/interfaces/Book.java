package abs.model.interfaces;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

import abs.model.users.Customer;

public interface Book {
	
	public final static String PATHNAME = "/Users/James/git/SEPT2017/";
	public final static String CUSTOMERAVAIL = "customerAvailability";
	public final static String EMPLOYEEAVAIL = "employeeAvailability";
	public final static String CUSTOMERPATH = PATHNAME + CUSTOMERAVAIL + ".txt";
	public final static String EMPLOYEEPATH = PATHNAME + EMPLOYEEAVAIL + ".txt";
	public final static Path CUSTOMERFILEPATH = Paths.get(CUSTOMERPATH);
	public final static Path EMPLOYEEFILEPATH = Paths.get(EMPLOYEEPATH);
	
	public abstract void readCustomerAvailibilityFile();
	
	public abstract void readEmployeeAvailabilityFile();
	
	public abstract void setAvailabilities(Date date);
	
	public abstract boolean isAvailable (Data date);

	public abstract void displayAllAvailabilities();

	public abstract String getId();

	public abstract boolean scheduleBooking(Customer customer);
	
}
