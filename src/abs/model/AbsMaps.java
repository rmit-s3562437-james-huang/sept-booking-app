package abs.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.Iterator;

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
	
	public void displayAllBookings(String custUserName) {
		for (Booking booking : recordBookingMap.values()) {
			if (booking.getCustomerUserName().equals(custUserName)) {
				System.out.println(booking.toString());
			}
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
	public void bookByDentist(String custUserName) {
		
		ArrayList<String> tempStoreEmp = new ArrayList<>();
		ArrayList<String> tempStoreBook = new ArrayList<>();
		
		System.out.println("Enter the Dentist you wish to make a booking with: ");
		
		for (Availability availability : employeeAvailabilityMap.values()) {
			if (!tempStoreEmp.contains(availability.getEmployeeUserName())) {
				tempStoreEmp.add(availability.getEmployeeUserName());
			} 
		}

		for (int i = 0; i < tempStoreEmp.size(); i++) {
			System.out.println(i+1 + ". " + tempStoreEmp.get(i));
		}
	
		Scanner scan = new Scanner(System.in);
		int selected = scan.nextInt();
		
		String selectedDentist = tempStoreEmp.get(selected-1);
		
		int index = 1;
		for (Availability availability : employeeAvailabilityMap.values()) {
			if (availability.getEmployeeUserName().equals(selectedDentist)) {
				System.out.println(index++ + ". " + availability.getDay() + ": " + availability.getTimeSlot());
				
				tempStoreBook.add(availability.getEmployeeUserName() + " " + availability.getDay() + ": " + availability.getTimeSlot());
			}
		}
		
		System.out.println("Selected a day: ");
		selected = scan.nextInt();
		
		String selectedBook = tempStoreBook.get(selected-1);
		String[] splitSelected = selectedBook.split(": ");
		
		String[] info = splitSelected[0].split(" ");
		String empUserName = info[0];
		String day = info[1];
		String timeSlot = splitSelected[1];
		
		for (Availability availability : employeeAvailabilityMap.values()) {
			if (availability.getEmployeeUserName().equals(empUserName) 
					&& availability.getDay().equals(day) 
					&& availability.getTimeSlot().toString().equals(timeSlot)) {
				System.out.println(availability.getEmployeeUserName() + " " + availability.getDay() + ": " + availability.getTimeSlot());
				
				for (int j = 0; j < availability.getTimeSlot().size(); j++) {
					System.out.println((j+1) + ". " + availability.getTimeSlot().get(j));
				}
				
				System.out.println("Select a time: ");
				selected = scan.nextInt();
				createBooking(availability.getDay(), availability.getTimeSlot().get(selected - 1), custUserName, availability.getEmployeeUserName());
			}
		}
	}
	
	public void createBooking(String day, String time, String customerUserName, String employeeUserName) {
		int countDays = 0;
		int countEmp = 0;
		int countCust = 0;
		
		if (validateBooking(day, time)) {
			System.out.println("Booking already exists!");
		} else {
			System.out.println("Creating booking!");
			
			for (Booking booking : recordBookingMap.values()) {
				if (booking.getCustomerUserName().equals(customerUserName)) {
					if (booking.getEmployeeUserName().equals(employeeUserName)) {
						if (booking.getDay().equals(day)) {
							System.out.println(day);
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
				ArrayList<String> newTimeSlot = new ArrayList<>();
				newTimeSlot.add(time);
				Booking recordBooking = new Booking(employeeUserName, 
						customerUserName, day, newTimeSlot);
				recordBookingMap.put(recordBooking.getBookingId(), recordBooking);
			}	
		}
	}
	
	/* TODO: remove bookings */
	public void removeBooking(String custUserName) {
		
		ArrayList<String> tempStore = new ArrayList<>();
		
		int index = 1;
		
		for (Booking booking : recordBookingMap.values()) {
			if (booking.getCustomerUserName().equals(custUserName)) {
				System.out.println(index++ + ". " + booking.getEmployeeUserName() 
				+ " " + booking.getDay() + ": " + booking.getTimeSlot());
				
				tempStore.add(booking.getEmployeeUserName() 
						+ " " + booking.getDay() + ": " + booking.getTimeSlot());
			}
		}
		
		System.out.println("Select a booking to delete: ");
		Scanner scan = new Scanner(System.in);
		int toDelete = scan.nextInt();
		
		String selected = tempStore.get(toDelete-1);
		String[] splitSelected = selected.split(": ");
		
		String[] info = splitSelected[0].split(" ");
		String timeSlot = splitSelected[1];
		
		String empUserName = info[0];
		System.out.println(empUserName);
		String day = info[1];
		
		/* reset index */
		index = 1;
		
		for (Booking booking : recordBookingMap.values()) {
			if (booking.getEmployeeUserName().equals(empUserName) 
					&& booking.getDay().equals(day)
					&& booking.getTimeSlot().toString().equals(timeSlot)) {
				
				System.out.println("Select a time you wish to delete: ");
				
				for (int i = 0; i < booking.getTimeSlot().size(); i++) {
					System.out.println(index++ + " " + booking.getTimeSlot().get(i));
				}
				toDelete = scan.nextInt();
				booking.getTimeSlot().remove(toDelete-1);
			}
		}
		
		/* Removes bookings which do not contain a timeslot */
		java.util.Iterator<Entry<String, Booking>> iter = recordBookingMap.entrySet().iterator();
		while (iter.hasNext()) {
		    Entry<String, Booking> entry = iter.next();
		    if(recordBookingMap.get(entry.getKey()).getTimeSlot().isEmpty()){
		        iter.remove();
		    }
		}
	}
	
	
	/* TODO: break up this method */
	public void bookByTimeOfDay(String custUserName) {
		
		ArrayList<String> tempTimeSlot = new ArrayList<>();
		ArrayList<String> tempDays = new ArrayList<>();
		
		System.out.println();
		
		
		String[] daysOfWeek = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
		for (int k = 0; k < daysOfWeek.length; k++){
			System.out.println((k+1) + ". " + daysOfWeek[k]);
			tempDays.add(daysOfWeek[k]);
		}
		
		System.out.println("Select a Day: ");
		
		Scanner scan = new Scanner(System.in);
		int scanDay = scan.nextInt();
		String day = tempDays.get(scanDay-1);
		/* match to booking.txt days */
		day = day.substring(0, (day.length()-(day.length()-3)));
		
		int index = 1;
		/* loops through map to display timeslots of the given day | ordered by index */
		for (Availability empAvailability : employeeAvailabilityMap.values()) {
			if (empAvailability.getDay().equals(day)) {
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
		
		/* cross check between availabilities and bookings */
		for (Availability empAvailability : employeeAvailabilityMap.values()) {
			if (empAvailability.getDay().equals(day)) {
				if (empAvailability.getTimeSlot().contains(time)) {
					/* validates if given time of day is located in the booking map */
					
					createBooking(day, time, custUserName, empAvailability.getEmployeeUserName());
					
				} 
			}
		}
	}
}
