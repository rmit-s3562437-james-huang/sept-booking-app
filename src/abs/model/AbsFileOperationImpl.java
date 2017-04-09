package abs.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.nio.file.*;
import java.io.*;

import abs.model.bookings.Availability;
import abs.model.bookings.Booking;
import abs.model.interfaces.*;
import abs.model.users.Customer;
import abs.model.users.Employee;
import abs.model.users.Owner;

public class AbsFileOperationImpl implements FileOperation {

	private static final String REGEX = "\\,\\ ";
	private static final String EMPREGEX = " \\|\\ ";

	public void createFile(Path path) {

		System.out.println("A file is about to be created!");

		try (BufferedWriter writer = Files.newBufferedWriter(path)) {
			writer.write("");
		} catch (IOException x) {
			System.err.println("ERROR: failed to create file");
		}
	}

	public ArrayList<String> readFromFile(Path path) {

		ArrayList<String> storeLines = new ArrayList<>();

		try (BufferedReader reader = Files.newBufferedReader(path)) {
			String line;
			while ((line = reader.readLine()) != null) {
				storeLines.add(line);
			}

		} catch (IOException e) {
			System.err.println("ERROR: invalid file");
		}

		return storeLines;
	}
	
	public void readEmployeeAvailabilityTest(Path path, Availability employeeAvailability, HashMap<String, Availability> map) {
		
		String[] splitRecord = null;
		String[] record;
		String empUserName, day;
		
		for (int i = 0; i < readFromFile(path).size(); i++) {
			
			ArrayList<String> timeSlot = new ArrayList<>();
			record = readFromFile(path).get(i).split(": ");
			
			splitRecord = record[0].split(" ");
			empUserName = splitRecord[0];
			day = splitRecord[1];
			record[1] = record[1].replaceAll("\\[", "").replaceAll("\\]","");
		
			String[] storeBookingRecord = record[1].split(", ");
			for (int j = 0; j < storeBookingRecord.length; j++) {
				storeBookingRecord[j] = storeBookingRecord[j].replaceAll(" ", "");
				if (storeBookingRecord[j].equals("empty")) {
					break;
				} else {
					timeSlot.add(storeBookingRecord[j]);
				}
			}
			
			employeeAvailability = new Availability(empUserName, day, timeSlot);
			map.put(employeeAvailability.getAvailabilityId(), employeeAvailability);
		}
	}

	
	public void readBookingTest (Path path, Booking recordBooking, HashMap<String, Booking> map) {
		
		String[] splitRecord = null;
		String[] record;
		String custUserName, empUserName, day;
		
		for (int i = 0; i < readFromFile(path).size(); i++) {
			
			ArrayList<String> timeSlot = new ArrayList<>();
			record = readFromFile(path).get(i).split(": ");
			
			splitRecord = record[0].split(" ");
			custUserName = splitRecord[0];
			empUserName = splitRecord[1];
			day = splitRecord[2];
			
			record[1] = record[1].replaceAll("\\[", "").replaceAll("\\]","");
			String[] storeBookingRecord = record[1].split(",");
			
			for (int j = 0; j < storeBookingRecord.length; j++) {
				storeBookingRecord[j] = storeBookingRecord[j].replaceAll(" ", "");
				timeSlot.add(storeBookingRecord[j]);
			}
			
			recordBooking = new Booking(empUserName, custUserName, day, timeSlot);
			map.put(recordBooking.getBookingId(), recordBooking);
		}
	}
	
	
	
	public void primeCustomerFile(String FileWritePath) {

		try (FileWriter writer = new FileWriter(FileWritePath, false)) {
			// priming file
		} catch (IOException e) {
			System.out.println("ERROR: failed to prime");
		}
	}

	public void writeToCustomerFile(String FileWritePath, String toWrite, boolean newLine) {
		
		if (newLine == true) {
			try (FileWriter writer = new FileWriter(FileWritePath, true)) {
				writer.write(toWrite + System.lineSeparator());
			} catch (IOException e) {
				System.out.println("ERROR: failed to write");
			}
		} else {
			try (FileWriter writer = new FileWriter(FileWritePath, true)) {
				writer.write(toWrite);
			} catch (IOException e) {
				System.out.println("ERROR: failed to write");
			}
		}
	}
	
	public void readToCustomer(Path path, Customer customer, HashMap<String, Customer> map) {
		String[] data; 
		for (int i = 0; i < readFromFile(path).size() ; i++) {
			data = readFromFile(path).get(i).split(REGEX);
			customer = new Customer(data[0].toString(), data[1].toString(), data[2].toString(),
					data[3].toString(), data[4].toString());
			map.put(customer.getUserName(), customer);
		}
	}
	
	public void readToOwner(Path path, Owner owner, HashMap<String, Owner> map) {
		String[] data; 
		for (int i = 0; i < readFromFile(path).size() ; i++) {
			data = readFromFile(path).get(i).split(REGEX);
			owner = new Owner(data[0].toString(), data[1].toString(), data[2].toString(), data[3].toString(),
					data[4].toString(), data[5].toString(), data[6].toString());
			map.put(owner.getUserName(), owner);
		}
	}
	
    public void compileCustomerMapStrings(String writePath, HashMap<String, Customer> map) {
		
		String name, userName, password, address, phoneNumber;
		String delim = ", ";
		String customerString;
		int count = 0;
		
		primeCustomerFile(writePath);
		
		for(Customer customer : map.values()) {
			name = customer.getName();
			userName = customer.getUserName();
			password = customer.getUserPassword();
			address = customer.getUserAddress();
			phoneNumber = customer.getUserPhoneNumber();
			
			count++;
			customerString = name + delim + userName + delim + 
					password + delim + address + 
					delim + phoneNumber;
			
			if(count < map.size()) {
				writeToCustomerFile(writePath, customerString, true);
			}
			else {
				writeToCustomerFile(writePath, customerString, false);
			}
		}
	}
    
    public void compileBookingMapStrings(String writePath, HashMap<String, Booking> map) {
    	
    	String custUserName, empUserName, day, timeSlot;
		String delim1 = " ";
		String delim2 = ": ";
		String bookingString;
		int count = 0;
		
		primeCustomerFile(writePath);
		
		for (Booking booking : map.values()) {
			custUserName = booking.getCustomerUserName();
			empUserName = booking.getEmployeeUserName();
			day = booking.getDay();
			timeSlot = booking.getTimeSlot().toString();
			
			count++;
			bookingString = custUserName + delim1 + empUserName 
					+ delim1 + day + delim2 + timeSlot;
			
			if(count < map.size()) {
				writeToCustomerFile(writePath, bookingString, true);
			}
			else {
				writeToCustomerFile(writePath, bookingString, false);
			}
		}
    }
    
    


}
