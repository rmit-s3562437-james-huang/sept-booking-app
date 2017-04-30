package abs.view.dialog.customer;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import abs.model.bookings.Booking;
import abs.view.gui.MainCustomerFrame;

public class DisplayBookingDialog extends JDialog {

	private JPanel bookPanel;
	
	public DisplayBookingDialog(MainCustomerFrame mainFrame) {
		
		setTitle("Customer Timetable");
		
		bookPanel = new JPanel();
		
		bookPanel.setLayout(new GridLayout(0, 4));
		
		bookPanel.add(new JLabel("Customer"));
		bookPanel.add(new JLabel("Employee"));
		bookPanel.add(new JLabel("Day"));
		bookPanel.add(new JLabel("Times"));
		
		for (Booking book : mainFrame.getAbsMaps().getBookingMap().values()) {
			System.out.println(mainFrame.getCustomer().getUserName());
			System.out.println(book.getCustomerUserName());
			if (book.getCustomerUserName().equals(mainFrame.getCustomer().getUserName())) {
				
				bookPanel.add(new JLabel(book.getEmployeeUserName()));
				bookPanel.add(new JLabel(book.getCustomerUserName()));
				bookPanel.add(new JLabel(book.getDay()));
				bookPanel.add(new JLabel(book.getTimeSlot().toString()));
			}
		}
		
		bookPanel.setBorder(BorderFactory.createEmptyBorder(2, 50, 2, 10));
		
		add(bookPanel);
		
		
		setSize(800, 300);
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
