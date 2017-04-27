package abs.view.gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import abs.controller.ChangePassButtonActionListener;
import abs.controller.DisplayButtonActionListner;
import abs.model.AbsClientSystemImpl;
import abs.model.AbsMaps;
import abs.model.users.Customer;

public class MainCustomerPanel extends JPanel implements ActionListener {
		
	private JButton dispDetailButton, passButton, editButton, disyBookButton, disaBookButton, 
		bookTimeButton, bookDentButton, removeButton, logOutButton;
	private MainCustomerFrame  mainCustomerFrame;
	
	public MainCustomerPanel(MainCustomerFrame maincustomerframe, Customer customer) {
		
		this.mainCustomerFrame = maincustomerframe;
		//this.absmaps = absmaps;
		//this.loginFrame = loginFrame;
		
		setLayout(new GridLayout(10,2,5,5));
		setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));
		
		
		dispDetailButton = new JButton("Display your details");
		passButton = new JButton("Change your password");
		editButton = new JButton("Edit your information");
		disyBookButton = new JButton("Display your bookings");
		disaBookButton = new JButton("Display all bookings");
		bookTimeButton = new JButton("Book by time");
		bookDentButton = new JButton("Book by dentist");
		removeButton = new JButton("Remove a booking");
		logOutButton = new JButton("Log Out");
		logOutButton.setForeground(Color.RED);
		
		
		add(dispDetailButton);
		dispDetailButton.addActionListener(new DisplayButtonActionListner(customer));
		add(passButton);
		passButton.addActionListener(new ChangePassButtonActionListener(customer));
		add(editButton);
		add(disyBookButton);
		add(disaBookButton);
		add(bookTimeButton);
		add(bookTimeButton);
		add(removeButton);
		add(logOutButton);
	}
	
	
	/* ATM: not required */
	@Override
	public void actionPerformed(ActionEvent e){
		
		if(e.getSource().equals(dispDetailButton)) {
			//new displayDetails();
			mainCustomerFrame.dispose();
		}
		
		if(e.getSource().equals(passButton)) {
			//new changePass();
			mainCustomerFrame.dispose();
		}
		
		if(e.getSource().equals(editButton)) {
			//new editInfo();
			mainCustomerFrame.dispose();
		}
		
		if(e.getSource().equals(disyBookButton)) {
			//new displayYourBookings();
			mainCustomerFrame.dispose();
		}
		
		if(e.getSource().equals(disaBookButton)) {
			//new displayAllBookings();
			mainCustomerFrame.dispose();
		}
		
		if(e.getSource().equals(bookTimeButton)) {
			//new bookTime();
			mainCustomerFrame.dispose();
		}
		
		if(e.getSource().equals(bookDentButton)) {
			//new bookDentist();
			mainCustomerFrame.dispose();
		}
		
		if(e.getSource().equals(removeButton)) {
			//new removeBooking();
			mainCustomerFrame.dispose();
		}
		
		if(e.getSource().equals(logOutButton)) {
			//new LoginFrame(absmaps, absclientsystem);
			mainCustomerFrame.dispose();
		}
		
	}
}
