package abs.model.bookings;

import abs.model.users.Customer;
import abs.model.users.Employee;

public class Booking {

	private String bookingId;
	private String day;
	private String time;
	private Customer customer;
	private Employee employee;
	
	/* date is the reference key */
	public Booking (String bookingId, String day, String time, Customer customer, Employee employee) {
		this.bookingId = bookingId;
		this.day = day;
		this.time = time; 
		this.customer = customer;
		this.employee = employee;
	}

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}
	
	public String getTime() {
		return this.time;
	}
	
	public void setTime(String time) {
		this.time = time;
	}

	public String getDay() {
		return this.day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
	
	
	
}
