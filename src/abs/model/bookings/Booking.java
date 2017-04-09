package abs.model.bookings;

import java.util.ArrayList;

public class Booking {
	
	private static int maxID = 0;

	private String bookingId;
	private String employeeUserName;
	private String customerUserName;
	private String day;
	private ArrayList<String> timeSlot = new ArrayList<>();
	
	public Booking(String employeeUserName, String customerUserName, String day, ArrayList<String> timeSlot) {
		this.bookingId = Integer.toString(maxID++);
		this.employeeUserName = employeeUserName;
		this.customerUserName = customerUserName;
		this.day = day;
		this.timeSlot = timeSlot;
	}
	
	public String getBookingId() {
		return bookingId;
	}


	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}


	public String getEmployeeUserName() {
		return employeeUserName;
	}

	public void setEmployeeUserName(String employeeUserName) {
		this.employeeUserName = employeeUserName;
	}

	public String getCustomerUserName() {
		return customerUserName;
	}

	public void setCustomerUserName(String customerUserName) {
		this.customerUserName = customerUserName;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public ArrayList<String> getTimeSlot() {
		return timeSlot;
	}

	public void setTimeSlot(ArrayList<String> timeSlot) {
		this.timeSlot = timeSlot;
	}

	@Override
	public String toString() {
		return "RecordBooking bookingId=" + bookingId + "   " + "employeeUserName=" + employeeUserName
				+ "\tcustomerUserName=" + customerUserName + "\tday=" + day + "\ttimeSlot=" + timeSlot;
	}
	
}
