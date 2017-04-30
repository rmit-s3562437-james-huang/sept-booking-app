package abs.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;

import abs.model.bookings.Availability;
import abs.model.bookings.Booking;
import abs.model.interfaces.Maps;
import abs.model.users.Customer;
import abs.model.users.Employee;
import abs.model.users.Owner;
import abs.view.AbsTest;

public class AbsMaps implements Maps {
	
	Logger LOGGER = Logger.getLogger(AbsMaps.class.getName());
	
	private HashMap<String, Owner> ownerMap = new HashMap<String, Owner>();
	private HashMap<String, Customer> customerMap = new HashMap<String, Customer>();
	private HashMap<String, Employee> employeeMap = new HashMap<String, Employee>();
	private HashMap<String, Booking> bookingMap = new HashMap<String, Booking>();
	private HashMap<String, Availability> availabilityMap = new HashMap<String, Availability>();
	
	@Override
	public void addCustomer(Customer customer) {
		customerMap.put(customer.getUserName(), customer);
	}
	
	@Override
	public Customer getCustomer(String userName) {
		return customerMap.get(userName);
	}
	
	@Override
	public void displayAllCustomers()
	{
		for (Customer customer : customerMap.values())
			System.out.println(customer);
	}
	
	@Override
	public HashMap<String, Availability> getEmployeeAvailabilityMap() {
		return availabilityMap;
	}
	
	@Override
	public HashMap<String, Booking> getBookingMap() {
		return bookingMap;
	}
	
	@Override
	public HashMap<String, Employee> getEmployeeMap() {
		return employeeMap;
	}
	
	@Override
	public HashMap<String, Owner> getOwnerMap() {
		return ownerMap;
	}
	
	@Override
	public HashMap<String, Customer> getCustomerMap() {
		return customerMap;
	}
	
	@Override
	public boolean customerValidation(String username, String password) {
		for (Customer customer : customerMap.values()) {
			LOGGER.log(Level.INFO, customer.getUserName() + " " + customer.getUserPassword());
			if (customer.getUserName().equals(username)) {
				if (customer.getUserPassword().equals(password)) {
					System.out.println("Welcome, " + username + ".");
					return true;
				}
			}
		}
		return false;
	}
	
	@Override
	public boolean ownerValidation(String username, String password) {
		for (Owner owner : ownerMap.values()) {
			LOGGER.log(Level.INFO, owner.getUserName() + " " + owner.getUserPassword());
			if (owner.getUserName().equals(username)) {
				if (owner.getUserPassword().equals(password)) {
					System.out.println("Welcome, Owner.");
					return true;
				}
			}
		}
		return false;
	}
	
	@Override
	public boolean userNameExists(String userName) {
		
		for(Customer customer : customerMap.values()) {
			LOGGER.log(Level.INFO, customer.getUserName());
			if(customer.getUserName().equals(userName)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void displayAllBookings() {
		System.out.println();
		for (Booking booking : bookingMap.values()) {
			System.out.println(booking.toString());
		}
	}
	
	@Override
	public void displayUserBookings(String custUserName) {
		System.out.println();
		for (Booking booking : bookingMap.values()) {
			if (booking.getCustomerUserName().equals(custUserName)) {
				System.out.println(booking.toString());
			}
		}
	}
	
	@Override
	public boolean validateBooking(String day, String time) {

		for (Booking booking : bookingMap.values()) {
			LOGGER.log(Level.INFO, booking.getDay() + " " + booking.getTimeSlot());
			if (booking.getDay().equals(day) && booking.getTimeSlot().contains(time)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void bookByDentist(String custUserName) {
		
		Scanner scan = new Scanner(System.in);
		String selectedDentist = null;
		String selectedBook;
		String selected;
		String empUserName = null;
		String day = null;
		String timeSlot = null;
		boolean check =  true; 
		int ret = 0;
		
		ArrayList<String> tempStoreEmp = new ArrayList<>();
		ArrayList<String> tempStoreBook = new ArrayList<>();
		
		/* display all employees */
		for (Availability availability : availabilityMap.values()) {
			if (!tempStoreEmp.contains(availability.getEmployeeUserName())) {
				tempStoreEmp.add(availability.getEmployeeUserName());
			} 
		}

		while (check) {
			
			System.out.println("\nSelect Dentist");
			System.out.println("==========================");
			for (int i = 0; i < tempStoreEmp.size(); i++) {
				System.out.println(i+1 + ". " + tempStoreEmp.get(i));
			}
			System.out.println("==========================");
			System.out.print("Choose an option: ");
			
			try {
				selected = scan.nextLine();
				if(selected.matches("[1-9]+")){
					ret = Integer.parseInt(selected);
					if (ret > tempStoreEmp.size()) throw new IllegalArgumentException();
				    check = false;
					selectedDentist = tempStoreEmp.get(ret-1);
				} else {
					System.out.println("\nInvalid option");
				}
			} catch (IllegalArgumentException e) {
				System.out.println("\nInvalid option");
				check = true;
			}
		}
		check = true;
		while (check) {
			int index = 1;
			System.out.println("\nSelect Booking");
			System.out.println("==========================");
			for (Availability availability : availabilityMap.values()) {
				if (availability.getEmployeeUserName().equals(selectedDentist)) {
					System.out.println(index++ + ". " + availability.getDay() + ": " + availability.getTimeSlot());
					
					tempStoreBook.add(availability.getEmployeeUserName() + " " + availability.getDay() + ": " + availability.getTimeSlot());
				}
			}
			System.out.println("==========================");
			System.out.print("Choose an option: ");
			
			try {
			selected = scan.nextLine();
			
			if(selected.matches("[1-9]+")){
			    ret = Integer.parseInt(selected);
			    if (ret > index) throw new IllegalArgumentException();

			    check = false;
			    
			    selectedBook = tempStoreBook.get(ret-1);
				String[] splitSelected = selectedBook.split(": ");
				String[] info = splitSelected[0].split(" ");
				empUserName = info[0];
				day = info[1];
				timeSlot = splitSelected[1];
				System.out.println(timeSlot);
				if (timeSlot.equals("[]")) throw new IllegalArgumentException();
				
			} else {
				System.out.println("\nInvalid option");
			}
			
			} catch (IllegalArgumentException e) {
				System.out.println("\nInvalid option");
				check = true;
			} 
		}

		for (Availability availability : availabilityMap.values()) {
			if (availability.getEmployeeUserName().equals(empUserName) 
					&& availability.getDay().equals(day) 
					&& availability.getTimeSlot().toString().equals(timeSlot)) {
				
				check = true;
				
				while (check) {
					System.out.println("\nSelect time");
					System.out.println("==========================");
					for (int j = 0; j < availability.getTimeSlot().size(); j++) {
						System.out.println((j+1) + ". " + availability.getTimeSlot().get(j));
					}
					System.out.println("==========================");
					System.out.print("Choose an option: ");
					
					try {
						selected = scan.nextLine();
						if(selected.matches("[1-9]+")){
						    ret = Integer.parseInt(selected);
						    if (ret > availability.getTimeSlot().size()) throw new IllegalArgumentException();
						    check = false;
						    createBooking(availability.getDay(), availability.getTimeSlot().get(ret - 1), custUserName, availability.getEmployeeUserName());
						} else {
							System.out.println("\nInvalid option");
						}
						
					} catch (IllegalArgumentException e) {
						check = true;
					} 
				}
			}
		}
	}
	
	@Override
	public void createBooking(String day, String time, String customerUserName, String employeeUserName) {
		
		int countDays = 0;
		int countEmp = 0;
		int countCust = 0;
		
		System.out.println();
		if (validateBooking(day, time)) {
			System.out.println("Booking already exists!");
		} else {
			
			System.out.println("Creating booking!");
			
			for (Booking booking : bookingMap.values()) {
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
			
			/* if total of cust+emp+days is equal to map size create a new booking */
			if ((countCust + countEmp + countDays) == bookingMap.size()) {
				ArrayList<String> newTimeSlot = new ArrayList<>();
				newTimeSlot.add(time);
				Booking recordBooking = new Booking(employeeUserName, 
						customerUserName, day, newTimeSlot);
				bookingMap.put(recordBooking.getBookingId(), recordBooking);
			}	
		}
	}
	
	@Override
	public void removeBooking(String custUserName) {
		
		ArrayList<String> tempStore = new ArrayList<>();
		Scanner scan = new Scanner(System.in);
	
		int index = 1;
		int ret = 0;
		String selected; 
		String empUserName = null;
		String timeSlot = null;
		String day = null;
		boolean check = true;
		
		while (check) {
			index = 1;
			/* display bookings by index */
			System.out.println("\nSelect booking to delete");
			System.out.println("==========================");
			for (Booking booking : bookingMap.values()) {
				if (booking.getCustomerUserName().equals(custUserName)) {
					System.out.println(index++ + ". " + booking.getEmployeeUserName() 
					+ " " + booking.getDay() + ": " + booking.getTimeSlot());
					
					tempStore.add(booking.getEmployeeUserName() 
							+ " " + booking.getDay() + ": " + booking.getTimeSlot());
				}
			}
			System.out.println("==========================");
			
			/* split data accodringly */
			System.out.print("Choose an option: ");
			
			
			try {
				selected = scan.nextLine();
				if(selected.matches("[1-9]+")){
				    ret = Integer.parseInt(selected);
				    System.out.println(index);
				    if (ret > index-1) throw new IllegalArgumentException();
				    check = false;
				    selected = tempStore.get(ret-1);
					String[] splitSelected = selected.split(": ");
					
					String[] info = splitSelected[0].split(" ");
					timeSlot = splitSelected[1];
					
					empUserName = info[0];
					day = info[1];
				}
			} catch (IllegalArgumentException e) {
				System.out.println("\nInvalid option");
				check = true;
			}
		}
		check = true;
	
		/* reset index */
	
		for (Booking booking : bookingMap.values()) {
			if (booking.getEmployeeUserName().equals(empUserName) 
					&& booking.getDay().equals(day)
					&& booking.getTimeSlot().toString().equals(timeSlot)) {
				while (check) {
					index = 1;
					System.out.println("\nSelect time");
					System.out.println("==========================");
					for (int i = 0; i < booking.getTimeSlot().size(); i++) {
						System.out.println(index++ + " " + booking.getTimeSlot().get(i));
					}
					System.out.println("==========================");
					System.out.print("Choose an option: ");
					
					try {
						selected = scan.nextLine();
						if(selected.matches("[1-9]+")){
						    ret = Integer.parseInt(selected);
						    if (ret > booking.getTimeSlot().size()) throw new IllegalArgumentException();
						    check = false;
						
						    booking.getTimeSlot().remove(ret-1);
						}
					} catch (IllegalArgumentException e) {
						System.out.println("\nInvalid option");
						check = true;
					}
				}
			}
		
		}
		
		
		/* Removes bookings which do not contain a timeslot */
		java.util.Iterator<Entry<String, Booking>> iter = bookingMap.entrySet().iterator();
		while (iter.hasNext()) {
		    Entry<String, Booking> entry = iter.next();
		    if(bookingMap.get(entry.getKey()).getTimeSlot().isEmpty()){
		        iter.remove();
		    }
		}
	}
	
	@Override
	public void bookByTimeOfDay(String custUserName) {
		
		ArrayList<String> tempTimeSlot = new ArrayList<>();
		ArrayList<String> tempDays = new ArrayList<>();
		
		Scanner scan = new Scanner(System.in);
		String selected;
		String day = null;
		String time = null;
		int ret;
		boolean check = true;
		boolean exit = false;
		
		while (check && !exit) {
			System.out.println("\nSelect day");
			System.out.println("==========================");
			String[] daysOfWeek = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
			for (int k = 0; k < daysOfWeek.length; k++) {
				System.out.println((k+1) + ". " + daysOfWeek[k]);
				tempDays.add(daysOfWeek[k]);
			}
			System.out.println("==========================");
			System.out.print("Choose an option or type 'exit' to return to menu: ");
			
			try {
				selected = scan.nextLine();
				if(selected.matches("[1-9]+")){
				    ret = Integer.parseInt(selected);
				    if (ret > daysOfWeek.length) throw new IllegalArgumentException();
				    check = false;
				
					day = tempDays.get(ret-1);
					/* match to booking.txt days */
					day = day.substring(0, (day.length()-(day.length()-3)));
				}
				else if(selected.equals("exit")) {
					exit = true;
					break;
				}
			} catch (IllegalArgumentException e) {
				System.out.println("\nInvalid option");
				check = true;
			}
		}
		check = true;
		
		while (check && !exit) {
			
			int index = 1;
			System.out.println();
			System.out.println("Select time");
			System.out.println("==========================");
			/* loops through map to display timeslots of the given day | ordered by index */
			for (Availability empAvailability : availabilityMap.values()) {
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
			System.out.println("==========================");
			System.out.print("Choose an option or type 'exit' to return to menu: ");
			
			try {
				
				selected = scan.nextLine();
				if(selected.matches("[1-9]+")){
				    ret = Integer.parseInt(selected);
				    if (ret > index-1) throw new IllegalArgumentException();
				    check = false;
				
					time = tempTimeSlot.get(ret-1);
				}
				else if(selected.equals("exit")) {
					exit = true;
				}
			} catch (IllegalArgumentException e) {
				System.out.println("\nInvalid option");
				check = true;
			}
	
		}
		
		if(!exit) {
			/* cross check between availabilities and bookings */
			for (Availability empAvailability : availabilityMap.values()) {
				if (empAvailability.getDay().equals(day)) {
					if (empAvailability.getTimeSlot().contains(time)) {
						/* validates if given time of day is located in the booking map */
						LOGGER.log(Level.INFO, empAvailability.getDay() + " " + empAvailability.getTimeSlot());
						createBooking(day, time, custUserName, empAvailability.getEmployeeUserName());
						System.out.println("You have successfully made a booking at: " + time + " on " + day + " with " + empAvailability.getEmployeeUserName() + ".");
					}
				} 
			}
		}
		else {
			System.out.println("No booking has been made as you've elected to cancle mid-way.");
		}
	}

	public void addEmployee(Employee employee) {
		employeeMap.put(employee.getUserName(), employee);
	}
	
	public Employee getEmployee(String userName) {
		return employeeMap.get(userName);
	}
}