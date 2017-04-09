package abs.model.interfaces;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;

import abs.model.bookings.Availability;
import abs.model.bookings.Booking;
import abs.model.users.Customer;
import abs.model.users.Owner;

public interface FileOperation {
	
	public abstract void createFile(Path path);
	
	public abstract void primeCustomerFile(String FileWritePath);
	
	public abstract void writeToCustomerFile(String FileWritePath, String toWrite, boolean newLine);

	public abstract ArrayList<String> readFromFile(Path path);

	public abstract void compileCustomerMapStrings(String writePath, HashMap<String, Customer> map);

	public abstract void readToOwner(Path path, Owner owner, HashMap<String, Owner> map);

	public abstract void readToCustomer(Path path, Customer customer, HashMap<String, Customer> map);

	public abstract void readBookingTest(Path path, Booking recordBooking, HashMap<String, Booking> map);

	public abstract void readEmployeeAvailabilityTest(Path path, Availability employeeAvailability, HashMap<String, Availability> map);

	void compileBookingMapStrings(String writePath, HashMap<String, Booking> map);
	
}
