package abs.view;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import abs.model.AbsClientSystemImpl;
import abs.model.AbsFileOperationImpl;
import abs.model.AbsMaps;
import abs.model.AbsMenuImpl;
import abs.model.users.Customer;
import abs.model.users.Employee;
import abs.model.users.Owner;

public class AbsTest {
	
	public final static String PATHNAME = "/Users/James/git/SEPT2017/";
	public final static String CUSTOMERFILE = "customerInfo";
	public final static String OWNERFILE = "ownerInfo";
	public final static String CUSTOMERAVAIL = "customerAvailability";
	public final static String EMPLOYEEAVAIL = "employeeAvailability";
	public final static String CUSTOMERPATH = PATHNAME + CUSTOMERAVAIL + ".txt";
	public final static String EMPLOYEEPATH = PATHNAME + EMPLOYEEAVAIL + ".txt";
	public final static Path CUSTOMERBOOKINGPATH = Paths.get(CUSTOMERPATH);
	public final static Path EMPLOYEEAVAILABILITYPATH = Paths.get(EMPLOYEEPATH);
	public final static Path CUSTOMERFILEPATH = Paths.get(PATHNAME + CUSTOMERFILE + ".txt");
	public final static Path OWNERFILEPATH = Paths.get(PATHNAME + OWNERFILE + ".txt");
	public final static String CUSTOMERWRITEFILEPATH = PATHNAME + CUSTOMERFILE + ".txt";
	
	public static void main(String[] args)
	{		
		
		AbsFileOperationImpl fo = new AbsFileOperationImpl();
		AbsMaps absMaps = new AbsMaps();
		AbsMenuImpl menu = new AbsMenuImpl();
		AbsClientSystemImpl cs = new AbsClientSystemImpl();
		
		Customer customer = null;
		Owner owner = null;
		Employee employee = null;
		
		fo.readToCustomer(CUSTOMERFILEPATH, customer, absMaps.getCustomerMap());
		fo.readToOwner(OWNERFILEPATH, owner, absMaps.getOwnerMap());
		
		/* TESTING: DELETE AFTER*/
		fo.readToEmployeeAvailability(EMPLOYEEAVAILABILITYPATH, employee, absMaps.getEmployeeMap());
		absMaps.linkEmployeeDayTimeSlot();
		absMaps.makeBooking();
		
		//menu.initializeMenu(absMaps, cs, absMaps.getCustomerMap(), fo, CUSTOMERWRITEFILEPATH);
		
	}

}
