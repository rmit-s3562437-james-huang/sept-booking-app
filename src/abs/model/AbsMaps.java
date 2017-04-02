package abs.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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
	
	/* username, map(days, timeslots) */
	private HashMap<String, Availability> employeeLinkedTimesMap = new HashMap<String, Availability>();
	
	public void linkEmployeeDayTimeSlot() {
		/* days, timeslots */
		HashMap<String, String[]> daysTimesMap = null;
		Availability availability = null;
		// loop employees
		// no need to clear()
		for (Employee employee : employeeMap.values()) {
			System.out.println(employee.getUserName());
			System.out.println("####################");
			String[] allAvailabilities = employee.getAvailability().split(", ");
			daysTimesMap = new HashMap<String, String[]>();
			// split data
			for (int i = 0; i < allAvailabilities.length ; i++) {
				String[] availabilitiesOnDay = allAvailabilities[i].split(" ");
				String day = availabilitiesOnDay[0];
				System.out.println(day);
				String[] timeSlot = availabilitiesOnDay[1].split("\\+");
	
				for (int j = 0; j < timeSlot.length ; j++) {
					System.out.println(timeSlot[j]);
				}
				System.out.println("====================");
				// store new day/time
				daysTimesMap.put(day, timeSlot);
				
			}
			
			availability = new Availability(daysTimesMap);
			// problem is that the daysTimesMap is being rewritten
			// instead of creating a map (have a contructor which stores the day/available time
			employeeLinkedTimesMap.put(employee.getUserName(), availability);
		}
		/* test user to day to time slot*/
		// arrays incorrect by 1 
		// works fine for Jess
		System.out.println("========Test========");
		System.out.println(employeeLinkedTimesMap.get("Tess").getDaysTimesMap().get("Tue")[1]);
	}
	
	// jesus wtf am i doing
	//hard code atm
	public void makeBooking() {
		Booking booking = null; 
		Scanner scan = new Scanner(System.in);
		
		
		
		System.out.println("Select a Doctor: ");
		String employeeName = scan.nextLine();
		
		System.out.println("Select a Day: ");
		String selectedDay = scan.nextLine();
		if (employeeLinkedTimesMap.get(employeeName).getDaysTimesMap().containsKey(selectedDay)) {
			for (int i = 0 ; i <employeeLinkedTimesMap.get(employeeName).getDaysTimesMap().get(selectedDay).length; i++) {
				System.out.println(i+1 + ". " + employeeLinkedTimesMap.get(employeeName).getDaysTimesMap().get(selectedDay)[i]);
			}
			int selectedTime = scan.nextInt();
			System.out.println(employeeLinkedTimesMap.get(employeeName).getDaysTimesMap().get(selectedDay)[selectedTime-1]);
			
			// before making a booking you must cross check the booking.txt file for customers 
			
			// if not booked then continue else loop (checking) 
			
			// create a new booking, username followed by day and time
			
			// create booking object to store this
			
			// finally write to file
		}
		
	}
	
	public void addOwner(Owner owner) {
		ownerMap.put(owner.getUserName(), owner);
	}
	
	public Owner getOwner(String userName) {
		return ownerMap.get(userName);
	}
	
	public void addCustomer(Customer customer) {
		customerMap.put(customer.getUserName(), customer);
	}
	
	public Customer getCustomer(String userName) {
		return customerMap.get(userName);
	}
	
	public void addEmployee(Employee employee) {
		employeeMap.put(employee.getUserName(), employee);
	}
	
	public Employee getEmployee(String username) {
		return employeeMap.get(username);
	}
	
	public void displayAllCustomers()
	{
		for (Customer customer : customerMap.values())
			System.out.println(customer);
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

}
