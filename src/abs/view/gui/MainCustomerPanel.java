package abs.view.gui;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import abs.controller.ChangePassButtonActionListener;
import abs.controller.DisplayBookingButtonActionListener;
import abs.controller.DisplayButtonActionListner;
import abs.controller.EditButtonActionListener;

public class MainCustomerPanel extends JPanel {
		
	private JButton dispDetailButton, passButton, editButton, disyBookButton, disaBookButton, 
		bookTimeButton, bookDentButton, removeButton, logOutButton;
	
	private MainCustomerFrame  mainCustomerFrame;
	
	public MainCustomerPanel(MainCustomerFrame maincustomerframe) {
		
		this.mainCustomerFrame = maincustomerframe;
		
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
		dispDetailButton.addActionListener(new DisplayButtonActionListner(mainCustomerFrame));
		add(passButton);
		passButton.addActionListener(new ChangePassButtonActionListener(mainCustomerFrame));
		add(editButton);
		editButton.addActionListener(new EditButtonActionListener(mainCustomerFrame));
		add(disyBookButton);
		disyBookButton.addActionListener(new DisplayBookingButtonActionListener(mainCustomerFrame));
		add(disaBookButton);
		add(bookTimeButton);
		add(bookDentButton);
		add(removeButton);
		add(logOutButton);
	}

}
