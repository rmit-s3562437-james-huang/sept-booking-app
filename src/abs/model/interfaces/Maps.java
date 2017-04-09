package abs.model.interfaces;

import java.util.HashMap;

import abs.model.bookings.Availability;
import abs.model.bookings.Booking;
import abs.model.users.Customer;
import abs.model.users.Employee;
import abs.model.users.Owner;

public interface Maps {

	public abstract void addCustomer(Customer customer);

	public abstract Customer getCustomer(String userName);

	public abstract void displayAllCustomers();

	public abstract HashMap<String, Availability> getEmployeeAvailabilityMap();

	public abstract HashMap<String, Booking> getRecordBookingMap();

	public abstract HashMap<String, Employee> getEmployeeMap();

	public abstract HashMap<String, Owner> getOwnerMap();

	public abstract HashMap<String, Customer> getCustomerMap();

	public abstract boolean customerValidation(String username, String password);

	public abstract boolean ownerValidation(String username, String password);

	public abstract boolean userNameExists(String userName);

	public abstract void displayAllBookings();

	public abstract void displayUserBookings(String custUserName);

	public abstract void bookByDentist(String custUserName);

	public abstract void createBooking(String day, String time, String customerUserName, String employeeUserName);

	public abstract void removeBooking(String custUserName);

	public abstract void bookByTimeOfDay(String custUserName);
	
	public abstract boolean validateBooking(String day, String time);
	
	
}
