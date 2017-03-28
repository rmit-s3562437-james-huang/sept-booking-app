package abs.model.booking;

import java.util.Date;

import abs.model.AbsFileOperationImpl;
import abs.model.interfaces.Availability;
import abs.model.interfaces.Client;
import abs.model.interfaces.Data;
import abs.model.interfaces.FileOperation;

public class AbstractAvailability implements Availability {
	
	protected Client client;
	protected String userName;
	
	FileOperation fo = new AbsFileOperationImpl();
	
	
	public AbstractAvailability(Client client, String userName) {
		this.client = client;
		this.userName = userName;
	}
	
	public AbstractAvailability() {
		
	}
	
	@Override
	public void displayAllAvailabilities() {
		for (int i = 0; i < fo.readFromFile(EMPLOYEEFILEPATH).size(); i++) {
			System.out.println(fo.readFromFile(EMPLOYEEFILEPATH).get(i));
		}
	}

	@Override
	public void setAvailabilities(Date date) {
		// TODO Auto-generated method stub
		
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
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
	
}
