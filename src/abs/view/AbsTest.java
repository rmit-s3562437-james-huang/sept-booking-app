package abs.view;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import abs.model.AbsFileOperationImpl;
import abs.model.AbsMenuImpl;
import abs.model.booking.Booking;
import abs.model.data.AbstractData;
import abs.model.data.CustomerData;
import abs.model.interfaces.Book;
import abs.model.interfaces.FileOperation;
import abs.model.users.Customer;
import abs.model.users.Owner;

public class AbsTest {
	
	public static void main(String[] args)
	{
		AbsMenuImpl menu = new AbsMenuImpl();
		menu.initialMenu();	
		
		
		//Date dNow = new Date( );
	    //SimpleDateFormat ft = 
	    //new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");

 	    //System.out.println("Current Date: " + ft.format(dNow));
		
		
		
		
		//Class nesting needs work
		
		//AbstractData data = new CustomerData();
		//data.getAvailability().displayAllAvailabilities();
	}

}
