package abs.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import abs.model.bookings.Availability;
import abs.model.bookings.Booking;
import abs.model.users.Customer;
import abs.model.users.Employee;
import abs.model.users.Owner;

public class AbsMaps {
	
	private HashMap<String, Owner> ownerMap = new HashMap<String, Owner>();
	private HashMap<String, Customer> customerMap = new HashMap<String, Customer>();
	private HashMap<String, Employee> employeeMap = new HashMap<String, Employee>();
	
	private HashMap<String, Booking> recordBookingMap = new HashMap<String, Booking>();
	private HashMap<String, Availability> employeeAvailabilityMap = new HashMap<String, Availability>();
	
	public HashMap<String, Availability> getEmployeeAvailabilityMap() {
		return employeeAvailabilityMap;
	}

	public void addCustomer(Customer customer) {
		customerMap.put(customer.getUserName(), customer);
	}
	
	public Customer getCustomer(String userName) {
		return customerMap.get(userName);
	}
	
	public void displayAllCustomers()
	{
		for (Customer customer : customerMap.values())
			System.out.println(customer);
	}
	
	public HashMap<String, Booking> getRecordBookingMap() {
		return recordBookingMap;
	}
	
	public HashMap<String, Employee> getEmployeeMap() {
		return employeeMap;
	}
	
	public HashMap<String, Owner> getOwnerMap() {
		return ownerMap;
	}
	
	public HashMap<String, Customer> getCustomerMap() {
		return customerMap;
	}
	
	public boolean customerValidation(String username, String password) {
		for (Customer customer : customerMap.values()) {
			if (customer.getUserName().equals(username)) {
				if (customer.getUserPassword().equals(password)) {
					System.out.println("Welcome, " + username + ".");
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean ownerValidation(String username, String password) {
		for (Owner owner : ownerMap.values()) {
			if (owner.getUserName().equals(username)) {
				if (owner.getUserPassword().equals(password)) {
					System.out.println("Welcome, Owner.");
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean userNameExists(String userName) {
		
		for(Customer customer : customerMap.values()) {
			if(customer.getUserName().equals(userName)) {
				return true;
			}
		}
		return false;
	}
	
	public void displayAllBookings() {
		for (Booking booking : recordBookingMap.values()) {
			System.out.println(booking.toString());
		}
	}
	
	private boolean validateBooking(String day, String time) {

		for (Booking booking : recordBookingMap.values()) {
			if (booking.getDay().equals(day) && booking.getTimeSlot().contains(time)) {
				return true;
			}
		}
		return false;
	}

	

	/* TODO: make booking with dentist name */
	
	/* TODO: remove bookings */
	
	
	
	/* TODO: break up this method */
	public void bookByTimeOfDay(String custUserName) {
		
		ArrayList<String> tempTimeSlot = new ArrayList<>();
		
		/* TODO: check for exceptions */
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Select a Day: ");
		String selectedDay = scan.nextLine();
		
		int index = 1;
		/* loops through map to display timeslots of the given day | ordered by index */
		for (Availability empAvailability : employeeAvailabilityMap.values()) {
			if (empAvailability.getDay().equals(selectedDay)) {
				for (int i = 0; i < empAvailability.getTimeSlot().size(); i++) {
					System.out.println(index++ + ". " + empAvailability.getTimeSlot().get(i));
					empAvailability.getEmployeeUserName();
					/* temp store for the times so that index matches to the time 
					 * NOTE: because each arraylist has different index */
					tempTimeSlot.add(empAvailability.getTimeSlot().get(i));
				}
			}
		}
		
		/* TODO: check for exceptions */
		
		System.out.println("Select a time: ");
		int selectTime = scan.nextInt();
		
		String time = tempTimeSlot.get(selectTime-1);
		
		int countDays = 0;
		int countEmp = 0;
		int countCust = 0;
		
		/* cross check between availabilities and bookings */
		for (Availability empAvailability : employeeAvailabilityMap.values()) {
			if (empAvailability.getDay().equals(selectedDay)) {
				if (empAvailability.getTimeSlot().contains(time)) {
					/* validates if given time of day is located in the booking map */
					if (validateBooking(selectedDay, time)) {
						System.out.println("Booking already exists!");
					} else {
						
						System.out.println("Creating booking!");
						
						for (Booking booking : recordBookingMap.values()) {
							if (booking.getCustomerUserName().equals(custUserName)) {
								if (booking.getEmployeeUserName().equals(empAvailability.getEmployeeUserName())) {
									if (booking.getDay().equals(empAvailability.getDay())) {
										System.out.println(empAvailability.getDay());
										booking.getTimeSlot().add(time);
									} else {
										/* if day does not exist in booking.txt */
										countDays++;
									}
								} else {
									/* if employee does not exist in booking.txt */
									countEmp++;
								}
							} else {
								/* if customer does not exist in booking.txt */
								countCust++;
							}
						}
						
						/*DELETE: checking counters */
						System.out.println("Customers: " + countCust 
								+ "\nEmployees: " + countEmp 
								+ "\nDays: " + countDays 
								+ "\nBookings: " + recordBookingMap.size());
					
						/* if total of cust+emp+days is equal to map size create a new booking */
						if ((countCust + countEmp + countDays) == recordBookingMap.size()) {
							ArrayList<String> timeSlot = new ArrayList<>();
							timeSlot.add(time);
							Booking recordBooking = new Booking(empAvailability.getEmployeeUserName(), custUserName, empAvailability.getDay(), timeSlot);
							recordBookingMap.put(recordBooking.getBookingId(), recordBooking);
						}
						
					}
				} 
			}
		}
	}
}
