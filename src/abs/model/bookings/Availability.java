package abs.model.bookings;

import java.util.ArrayList;

public class Availability {
	
	private static int maxID = 0;
	
	private String availabilityId;
	private String employeeUserName;
	private String day;
	private ArrayList<String> timeSlot = new ArrayList<>();
	
	public Availability(String employeeUserName, String day, ArrayList<String> timeSlot) {
		super();
		this.availabilityId = Integer.toString(maxID++);
		this.employeeUserName = employeeUserName;
		this.day = day;
		this.timeSlot = timeSlot;
	}

	public String getEmployeeUserName() {
		return employeeUserName;
	}

	public void setEmployeeUserName(String employeeUserName) {
		this.employeeUserName = employeeUserName;
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

	public String getAvailabilityId() {
		return availabilityId;
	}

	public void setAvailabilityId(String availabilityId) {
		this.availabilityId = availabilityId;
	}

	
}
