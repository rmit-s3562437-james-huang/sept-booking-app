package abs.model.booking;

import java.util.Date;

import abs.model.AbsFileOperationImpl;
import abs.model.interfaces.Book;
import abs.model.interfaces.Client;
import abs.model.interfaces.Data;
import abs.model.interfaces.FileOperation;
import abs.model.users.Customer;

public class Booking implements Book {

	protected Date date;
	
	FileOperation fo = new AbsFileOperationImpl();
	
	private String id;
	private static int maxID = 0;
	
	public Booking(Date date) {
		this.id = Integer.toString(maxID++);
		this.date = date;
	}
	
	@Override
	public void displayAllAvailabilities() {
		for (int i = 0; i < fo.readFromFile(EMPLOYEEFILEPATH).size(); i++) {
			System.out.println(fo.readFromFile(EMPLOYEEFILEPATH).get(i));
		}
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	public void setAvailabilities(Date date) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readCustomerAvailibilityFile() {

	}
	
	@Override 
	public void readEmployeeAvailabilityFile() {

	}

	@Override
	public boolean isAvailable(Data date) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean scheduleBooking(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
