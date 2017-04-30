package abs.view.dialog.customer;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import abs.model.bookings.Availability;
import abs.view.AbsTest;
import abs.view.gui.MainCustomerFrame;

public class BookTimeDialog extends JDialog implements ActionListener {
	
	public final static String[] DAYS_OF_WEEK = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
	
	private MainCustomerFrame mainFrame;
	
	private JLabel selectDayLabel;
	private JLabel selectTimeLabel;
	
	@SuppressWarnings("rawtypes")
	private JComboBox cbDay;
	@SuppressWarnings("rawtypes")
	private JComboBox cbTime;
	
	private JPanel bookPanel;
	private JPanel buttonPanel;
	
	private JButton okButton;
	private JButton cancelButton;
	

	@SuppressWarnings("unchecked")
	public BookTimeDialog(MainCustomerFrame mainFrame) {
		setTitle("Book by time");
		this.mainFrame = mainFrame;
		
		//user selects a day and time
		//search days and times
		//output which dentists are available
		
		setLayout(new BorderLayout());
		
		bookPanel = new JPanel();
		buttonPanel = new JPanel();
		
		selectDayLabel = new JLabel("Select day: ");
		selectTimeLabel = new JLabel("Select time: ");
		
		bookPanel.setLayout(new GridLayout(0, 2));
		
		cbDay = new JComboBox<String>();
		cbTime = new JComboBox<String>();
		
		for (int i = 0; i < DAYS_OF_WEEK.length; i++) {
			cbDay.addItem(DAYS_OF_WEEK[i]);
		}
		
		bookPanel.add(selectDayLabel);
		bookPanel.add(cbDay);
		bookPanel.add(selectTimeLabel);
		bookPanel.add(cbTime);
		
		bookPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		cbDay.addActionListener(this);
		cbTime.addActionListener(this);
		
		okButton = new JButton("OK");
		okButton.addActionListener(this);
		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(this);
		buttonPanel.add(okButton);
		buttonPanel.add(cancelButton);
		
		add(bookPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
		
		setSize(300, 150);
		setLocationRelativeTo(null);
		setVisible(true);
	}


	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(cancelButton)) {
			dispose();
		}
		
		cbTime.removeAllItems();
			/* create function for this in absMaps */
		for (Availability empAvailability : mainFrame.getAbsMaps().getEmployeeAvailabilityMap().values()) {
			if (empAvailability.getDay().equals(appendDay((String) cbDay.getSelectedItem()))) {
				for (int i = 0; i < empAvailability.getTimeSlot().size(); i++) {
					if (!mainFrame.getAbsMaps().validateBooking(empAvailability.getDay(), 
							empAvailability.getTimeSlot().get(i))) {
						cbTime.addItem(empAvailability.getTimeSlot().get(i));
					}
				}
			}
		}
		
		if(e.getSource().equals(okButton)) {
			System.out.println("pass1");
			
			/* create function for this in absMaps
			 * TODO : notify the user
			 */
			
			for (Availability empAvailability : mainFrame.getAbsMaps().getEmployeeAvailabilityMap().values()) {
				System.out.println("pass2");
				if (empAvailability.getDay().equals(appendDay((String) cbDay.getSelectedItem()))) {
					System.out.println(cbDay.getSelectedItem());
					System.out.println(empAvailability.getTimeSlot().toString() + " " + cbTime.getSelectedItem());
					if (empAvailability.getTimeSlot().contains(cbTime.getSelectedItem())) {
						System.out.println("pass4");
						System.out.println(mainFrame.getAbsMaps().getBookingMap().toString());
						mainFrame.getAbsMaps().createBooking(appendDay((String) cbDay.getSelectedItem()), (String) cbTime.getSelectedItem(),
								mainFrame.getCustomer().getUserName(), empAvailability.getEmployeeUserName());
						mainFrame.getFileOps().compileBookingMapStrings(AbsTest.BOOKINGWRITEFILEPATH, mainFrame.getAbsMaps().getBookingMap());
						
						//Notification Dialog has been added
						JOptionPane.showMessageDialog(null, "You've successfully book an appointment on: \n" + (String) cbDay.getSelectedItem() + " at " + (String) cbTime.getSelectedItem().toString() + 
								" with " + empAvailability.getEmployeeUserName() + ".");
					}
					
				}
			}
			dispose();
		}
	}

	public String appendDay(String day) {
		String appendDay;
		appendDay = day.substring(0, (day.length()-(day.length()-3)));
		return appendDay;
	}
}
