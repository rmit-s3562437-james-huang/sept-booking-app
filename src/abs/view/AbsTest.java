package abs.view;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import abs.model.AbsClientSystemImpl;
import abs.model.AbsFileOperationImpl;
import abs.model.AbsMaps;
import abs.model.AbsMenuImpl;
import abs.model.bookings.Availability;
import abs.model.bookings.Booking;
import abs.model.users.Customer;
import abs.model.users.Employee;
import abs.model.users.Owner;

public class AbsTest {
	
	private static final Logger LOGGER = Logger.getLogger( AbsTest.class.getName() );
	
	public final static String PATHNAME = "/Users/James/git/SEPT2017/";
	public final static String CUSTOMERWRITEFILEPATH = PATHNAME + "customerInfo" + ".txt";
	public final static String BOOKINGWRITEFILEPATH = PATHNAME + "bookingTest" + ".txt";

	public final static Path CUSTOMERBOOKINGPATH = Paths.get(PATHNAME + "customerAvailability" + ".txt");
	public final static Path EMPLOYEEAVAILABILITYPATH = Paths.get(PATHNAME + "employeeAvailabilityTest" + ".txt");
	public final static Path CUSTOMERFILEPATH = Paths.get(PATHNAME + "customerInfo" + ".txt");
	public final static Path OWNERFILEPATH = Paths.get(PATHNAME + "ownerInfo" + ".txt");
	public final static Path BOOKINGTESTPATH = Paths.get(PATHNAME + "bookingTest" + ".txt");

	public static void main(String[] args)
	{		
		LOGGER.info("Logging an INFO-level message");
		
		/* create objects */
		AbsFileOperationImpl fo = new AbsFileOperationImpl();
		AbsMaps absMaps = new AbsMaps();
		AbsMenuImpl menu = new AbsMenuImpl();
		AbsClientSystemImpl cs = new AbsClientSystemImpl();
		
		/* initialize variables */
		Availability empAvailability = null;
		Booking recordBooking = null;
		Customer customer = null;
		Owner owner = null;
		Employee employee = null;
		
		/* read files */
		fo.readToCustomer(CUSTOMERFILEPATH, customer, absMaps.getCustomerMap());
		fo.readToOwner(OWNERFILEPATH, owner, absMaps.getOwnerMap());
		fo.readEmployeeAvailabilityTest(EMPLOYEEAVAILABILITYPATH, empAvailability, absMaps.getEmployeeAvailabilityMap());
		fo.readBookingTest(BOOKINGTESTPATH, recordBooking, absMaps.getRecordBookingMap());
		
		/* TESTING: TO DELETE */
		//absMaps.displayAllBookings();
		//absMaps.bookByTimeOfDay("Ness");
		//absMaps.removeBooking("Cass");
		//absMaps.bookByDentist("Cass");
		//fo.compileBookingMapStrings(BOOKINGWRITEFILEPATH, absMaps.getRecordBookingMap());
		//absMaps.displayAllBookings();

		/* run program */
		menu.initializeMenu(absMaps, cs, absMaps.getCustomerMap(), fo, CUSTOMERWRITEFILEPATH, 
				BOOKINGWRITEFILEPATH, absMaps.getRecordBookingMap());
		
	}

}
