package abs.view.dialog.owner;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import abs.model.bookings.Availability;
import abs.model.bookings.Booking;
import abs.model.users.Customer;
import abs.model.users.Employee;
import abs.view.AbsTest;
import abs.view.dialog.customer.BookTimeDialog;
import abs.view.gui.MainOwnerFrame;

public class MakeCustomerBookDialog extends JDialog implements ActionListener {

	private MainOwnerFrame mainOwnerFrame;
	
	private JComboBox cbCustomer;
	private JComboBox cbDentist;
	private JComboBox cbDay;
	private JComboBox cbTime;
	
	private JPanel bookPanel;
	private JPanel buttonPanel;
	
	private JButton okButton;
	private JButton cancelButton;

	public MakeCustomerBookDialog(MainOwnerFrame mainOwnerFrame) {
		this.mainOwnerFrame = mainOwnerFrame;
	
		setTitle("Make booking for Customer");
		setIconImage(new ImageIcon(AbsTest.ICONPATH).getImage());
		setLayout(new BorderLayout());
		
		bookPanel = new JPanel();
		buttonPanel = new JPanel();
		
		cbCustomer = new JComboBox();
		cbDentist = new JComboBox();
		cbDay = new JComboBox();
		cbTime = new JComboBox();
		
		for (Customer customer : mainOwnerFrame.getAbsMaps().getCustomerMap().values()) 
			cbCustomer.addItem(customer.getUserName());
		
		for (Employee employee : mainOwnerFrame.getAbsMaps().getEmployeeMap().values()) 
			cbDentist.addItem(employee.getName());
		
		
		for (int i = 0; i < BookTimeDialog.DAYS_OF_WEEK.length; i++) {
			cbDay.addItem(BookTimeDialog.DAYS_OF_WEEK[i]);
		}
		
		cbDentist.addActionListener(this);
		cbDay.addActionListener(this);
		cbTime.addActionListener(this);
		
		JLabel selectCustomerLabel = new JLabel("Select customer: ");
		JLabel selectDentistLabel = new JLabel("Select employee: ");
		JLabel selectDayLabel = new JLabel("Select day: ");
		JLabel selectTimeLabel = new JLabel("Select time: ");

		bookPanel.setLayout(new GridLayout(0,2));
		bookPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		bookPanel.add(selectCustomerLabel);
		bookPanel.add(cbCustomer);
		cbCustomer.addActionListener(this);
		
		bookPanel.add(selectDentistLabel);
		bookPanel.add(cbDentist);
		cbDentist.addActionListener(this);
		
		bookPanel.add(selectDayLabel);
		bookPanel.add(cbDay);
		cbDay.addActionListener(this);
		
		bookPanel.add(selectTimeLabel);
		bookPanel.add(cbTime);
		
		okButton = new JButton("OK");
		cancelButton = new JButton("Cancel");
		
		buttonPanel.add(okButton);
		okButton.addActionListener(this);
		buttonPanel.add(cancelButton);
		cancelButton.addActionListener(this);
		
		
		
		add(bookPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
		
		setSize(300, 200);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	
	/* code dupe 
	 * should be created in mainCustFrame
	 * need to refactor later */
	public String appendDay(String day) {
		String appendDay;
		appendDay = day.substring(0, (day.length()-(day.length()-3)));
		return appendDay;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
		if (e.getSource().equals(cancelButton)) {
			dispose();
		}
		
		cbTime.removeAllItems();
		for (Availability empAvailability : mainOwnerFrame.getAbsMaps().getEmployeeAvailabilityMap().values()) {
			if (empAvailability.getEmployeeUserName().equals(cbDentist.getSelectedItem()) ) {
				if (empAvailability.getDay().equals(appendDay((String) cbDay.getSelectedItem()))) {
					for (int i = 0; i < empAvailability.getTimeSlot().size(); i++ ) 
						cbTime.addItem(empAvailability.getTimeSlot().get(i));		
				}
			}		
		}
		
		if(e.getSource().equals(okButton)) {
			System.out.println("pass1");
			
			/* create function for this in absMaps
			 * TODO : notify the user
			 * 
			 * ERROR : times are not being deleted after having booked the slot
			 */
			
			for (Availability empAvailability : mainOwnerFrame.getAbsMaps().getEmployeeAvailabilityMap().values()) {
				if (empAvailability.getEmployeeUserName().equals(cbDentist.getSelectedItem()) ) {
					if (empAvailability.getDay().equals(appendDay((String) cbDay.getSelectedItem()))) {
						if (empAvailability.getTimeSlot().contains(cbTime.getSelectedItem())) {
							
							
							for (Booking book : mainOwnerFrame.getAbsMaps().getBookingMap().values()) {
								System.out.println("pass1");
								if (book.getEmployeeUserName().equals(cbDentist.getSelectedItem())) {
									System.out.println("pass2");
									if (book.getDay().equals(appendDay((String) cbDay.getSelectedItem()))) {
										System.out.println("pass3");
										if (!book.getTimeSlot().contains(cbTime.getSelectedItem())) {
											System.out.println("pass4");
											book.getTimeSlot().add((String)cbTime.getSelectedItem());
											mainOwnerFrame.getFileOps().compileBookingMapStrings(AbsTest.BOOKINGWRITEFILEPATH, mainOwnerFrame.getAbsMaps().getBookingMap());
										}
									}
								}
							}
							
							
							mainOwnerFrame.getAbsMaps().createBooking(appendDay((String) cbDay.getSelectedItem()), 
									(String) cbTime.getSelectedItem(), (String) cbCustomer.getSelectedItem(), 
									(String) cbDentist.getSelectedItem());
							System.out.println(mainOwnerFrame.getAbsMaps().getBookingMap());
							mainOwnerFrame.getFileOps().compileBookingMapStrings(AbsTest.BOOKINGWRITEFILEPATH, mainOwnerFrame.getAbsMaps().getBookingMap());
							JOptionPane.showMessageDialog(null, "You've successfully book an appointment on: \n" + (String) cbDay.getSelectedItem() + " at " + (String) cbTime.getSelectedItem().toString() + 
									" with " + (String) cbDentist.getSelectedItem() + ".");
						}
					}	
				}
			}
			dispose();
		}
	}

}
