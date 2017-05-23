package abs.view.dialog.customer;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import abs.model.bookings.Booking;
import abs.view.AbsTest;
import abs.view.gui.MainCustomerFrame;

public class DisplayBookingDialog extends JDialog {

	private JPanel bookPanel;
	
	public DisplayBookingDialog(MainCustomerFrame mainFrame) {
		
		setTitle("Customer Timetable");
		
		setIconImage(new ImageIcon(AbsTest.ICONPATH).getImage());
		
		bookPanel = new JPanel();
		
		bookPanel.setLayout(new GridLayout(0, 4));
		
		
		JLabel customerLabel = new JLabel("Customer");
		customerLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		JLabel employeeLabel = new JLabel("Employee");
		employeeLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		JLabel dayLabel = new JLabel("Day");
		dayLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		JLabel timesLabel = new JLabel("Times");
		timesLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		bookPanel.add(customerLabel);
		bookPanel.add(employeeLabel);
		bookPanel.add(dayLabel);
		bookPanel.add(timesLabel);
		
		for (Booking book : mainFrame.getAbsMaps().getBookingMap().values()) {

			System.out.println(mainFrame.getCustomer().getUserName());
			System.out.println(book.getCustomerUserName());
			if (book.getCustomerUserName().equals(mainFrame.getCustomer().getUserName())) {
				

				JLabel custUserLabel = new JLabel(book.getCustomerUserName());
				custUserLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				JLabel empUserLabel = new JLabel(book.getEmployeeUserName());
				empUserLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				JLabel getDayLabel = new JLabel(book.getDay());
				getDayLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				JLabel getTimeLabel = new JLabel(book.getTimeSlot().toString());
				getTimeLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				
				
				bookPanel.add(custUserLabel);
				bookPanel.add(empUserLabel);
				bookPanel.add(getDayLabel);
				bookPanel.add(getTimeLabel);
				
				
			}
		}
		
		bookPanel.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
		
		add(bookPanel);
		
		
		setSize(800, 300);
		setLocationRelativeTo(null);
		setVisible(true);
	}

}