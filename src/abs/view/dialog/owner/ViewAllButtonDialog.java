package abs.view.dialog.owner;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import abs.model.bookings.Booking;
import abs.view.AbsTest;
import abs.view.gui.MainOwnerFrame;

public class ViewAllButtonDialog extends JDialog {
	
	private JPanel bookPanel;

	public ViewAllButtonDialog(MainOwnerFrame mainOwnerFrame) {
		setTitle("Timetable - all bookings");
		setIconImage(new ImageIcon(AbsTest.ICONPATH).getImage());
		
		bookPanel = new JPanel();
		
		bookPanel.setLayout(new GridLayout(0, 4));
		
		//int bookingGridHeight = mainFrame.getAbsMaps().getBookingMap().size();
		
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
		
		for (Booking book : mainOwnerFrame.getAbsMaps().getBookingMap().values()) {
			JLabel empUserLabel = new JLabel(book.getEmployeeUserName());
			empUserLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			JLabel custUserLabel = new JLabel(book.getCustomerUserName());
			custUserLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			JLabel getDayLabel = new JLabel(book.getDay());
			getDayLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			JLabel getTimeLabel = new JLabel(book.getTimeSlot().toString());
			getTimeLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			
			bookPanel.add(empUserLabel);
			bookPanel.add(custUserLabel);
			bookPanel.add(getDayLabel);
			bookPanel.add(getTimeLabel);
		}
		
		bookPanel.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
		
		add(bookPanel);
		
		
		setSize(800, 300);
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
