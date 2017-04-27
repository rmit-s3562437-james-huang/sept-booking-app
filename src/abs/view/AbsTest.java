package abs.view;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

import abs.model.AbsClientSystemImpl;
import abs.model.AbsFileOperationImpl;
import abs.model.AbsMaps;
import abs.model.AbsMenuImpl;
import abs.model.bookings.Availability;
import abs.model.bookings.Booking;
import abs.model.users.Customer;
import abs.model.users.Owner;
import abs.view.gui.*;

/* 
 * HOW TO RUN CODE:
 * Place the path of this package in PATHNAME 
 * To run the code; right click AbsTest.java and run as Java Application
 */

public class AbsTest {
	
	static Logger LOGGER = Logger.getLogger(AbsTest.class.getName());
	
	/* DEFUALT STATIC PATH */
	public final static String PATHNAME = "../SEPT2017/";
	//public final static String PATHNAME = "/Users/James/git/SEPT2017/";
	//public final static String PATHNAME = "D:\\Repositories\\SEPT2017\\SEPT2017\\";
	
	public final static String CUSTOMERWRITEFILEPATH = PATHNAME + "customerInfo" + ".txt";
	public final static String BOOKINGWRITEFILEPATH = PATHNAME + "bookingTest" + ".txt";

	public final static Path CUSTOMERBOOKINGPATH = Paths.get(PATHNAME + "customerAvailability" + ".txt");
	public final static Path EMPLOYEEAVAILABILITYPATH = Paths.get(PATHNAME + "employeeAvailabilityTest" + ".txt");
	public final static Path CUSTOMERFILEPATH = Paths.get(PATHNAME + "customerInfo" + ".txt");
	public final static Path OWNERFILEPATH = Paths.get(PATHNAME + "ownerInfo" + ".txt");
	public final static Path BOOKINGTESTPATH = Paths.get(PATHNAME + "bookingTest" + ".txt");

	public static void main(String[] args)
	{		

		LOGGER.log(Level.INFO, "Creating objects");
		AbsFileOperationImpl fo = new AbsFileOperationImpl();
		AbsMaps absMaps = new AbsMaps();
		AbsMenuImpl menu = new AbsMenuImpl();
		AbsClientSystemImpl cs = new AbsClientSystemImpl();
		
		LOGGER.log(Level.INFO, "Initializing variables");
		Availability empAvailability = null;
		Booking recordBooking = null;
		Customer customer = null;
		Owner owner = null;
		
		LOGGER.log(Level.INFO, "Reading all files");
		fo.readToCustomer(CUSTOMERFILEPATH, customer, absMaps.getCustomerMap());
		fo.readToOwner(OWNERFILEPATH, owner, absMaps.getOwnerMap());
		fo.readEmployeeAvailabilityTest(EMPLOYEEAVAILABILITYPATH, empAvailability, absMaps.getEmployeeAvailabilityMap());
		fo.readBookingTest(BOOKINGTESTPATH, recordBooking, absMaps.getRecordBookingMap());

		LOGGER.log(Level.INFO, "Run program");
		/*menu.initializeMenu(absMaps, cs, absMaps.getCustomerMap(), fo, CUSTOMERWRITEFILEPATH, 
				BOOKINGWRITEFILEPATH, absMaps.getRecordBookingMap());*/
		
		new LoginFrame(absMaps, cs, fo);
		
	}
}