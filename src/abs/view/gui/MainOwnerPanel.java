package abs.view.gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import abs.controller.owner.AddEmpAvailabilityButtonActionListener;
import abs.controller.owner.AddEmpButtonActionListener;
import abs.controller.owner.DeleteEmpButtonActionListner;
import abs.controller.owner.MakeCustomerBookActionListener;
import abs.controller.owner.ViewAllButtonActionListener;
import abs.controller.owner.ViewEmpButtonActionListener;

public class MainOwnerPanel extends JPanel implements ActionListener {
	
	private MainOwnerFrame mainOwnerFrame;
	
	private JButton viewAllBookButton, viewEmpDetailsButton, 
		addEmpButton, deleteEmpButton, makeCustomerBookingButton, logOutButton, addEmpAvailabilityButton;

	public MainOwnerPanel(MainOwnerFrame mainOwnerFrame) {
		
		this.mainOwnerFrame = mainOwnerFrame;
		
		addEmpAvailabilityButton = new JButton("Add Employee Availability");
		viewAllBookButton = new JButton("View all bookings");
		viewEmpDetailsButton = new JButton("View Employee Details");
		addEmpButton = new JButton("Add Employees");
		deleteEmpButton = new JButton("Delete Employees");
		makeCustomerBookingButton = new JButton("Make Customer Booking");
		logOutButton = new JButton("Log Out");
		logOutButton.setForeground(Color.RED);
		
		add(viewAllBookButton);
		viewAllBookButton.addActionListener(new ViewAllButtonActionListener(mainOwnerFrame));
		add(viewEmpDetailsButton);
		viewEmpDetailsButton.addActionListener(new ViewEmpButtonActionListener(mainOwnerFrame));
		add(addEmpButton);
		addEmpButton.addActionListener(new AddEmpButtonActionListener(mainOwnerFrame));
		add(addEmpAvailabilityButton);
		addEmpAvailabilityButton.addActionListener(new AddEmpAvailabilityButtonActionListener(mainOwnerFrame));
		add(deleteEmpButton);
		deleteEmpButton.addActionListener(new DeleteEmpButtonActionListner(mainOwnerFrame));
		add(makeCustomerBookingButton);
		makeCustomerBookingButton.addActionListener(new MakeCustomerBookActionListener(mainOwnerFrame));
		add(logOutButton);
		logOutButton.addActionListener(this);
		
		setLayout(new GridLayout(10,2,5,5));
		setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(logOutButton)) {
			mainOwnerFrame.dispose();
			new LoginFrame(mainOwnerFrame.getAbsMaps(), mainOwnerFrame.getClientSystem(), mainOwnerFrame.getFileOps());
		}
	}

}
