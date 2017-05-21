package abs.view.dialog.customer;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import abs.model.bookings.Availability;
import abs.model.users.Employee;
import abs.view.AbsTest;
import abs.view.gui.MainCustomerFrame;

public class BookDentistDialog extends JDialog implements ActionListener {

	private MainCustomerFrame mainFrame;
	
	private JComboBox cbDentist;
	private JComboBox cbDay;
	private JComboBox cbTime;
	
	private JPanel bookPanel;
	private JPanel buttonPanel;
	
	private JButton okButton;
	private JButton cancelButton;
	
	public BookDentistDialog(MainCustomerFrame mainFrame) {
		setTitle("Book by Name");
		this.mainFrame = mainFrame;
		setLayout(new BorderLayout());
		
		setIconImage(new ImageIcon(AbsTest.ICONPATH).getImage());
		
		bookPanel = new JPanel();
		buttonPanel = new JPanel();
		
		cbDentist = new JComboBox();
		cbDay = new JComboBox();
		cbTime = new JComboBox();
		
		List<String> tempNameList = new ArrayList<>();
		
		for (Employee employee : mainFrame.getAbsMaps().getEmployeeMap().values()) {
			if (!tempNameList.contains(employee.getName())) {
				tempNameList.add(employee.getName());
				cbDentist.addItem(employee.getName());
			}
		}
		
		for (int i = 0; i < BookTimeDialog.DAYS_OF_WEEK.length; i++) {
			cbDay.addItem(BookTimeDialog.DAYS_OF_WEEK[i]);
		}
		
		JLabel selectDentistLabel = new JLabel("Select employee: ");
		JLabel selectDayLabel = new JLabel("Select day: ");
		JLabel selectTimeLabel = new JLabel("Select time: ");

		bookPanel.setLayout(new GridLayout(0,2));
		bookPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
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
		
		setSize(300, 150);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource().equals(cancelButton)) {
			dispose();
		}
		
		cbTime.removeAllItems();
		for (Availability empAvailability : mainFrame.getAbsMaps().getEmployeeAvailabilityMap().values()) {
			if (empAvailability.getEmployeeUserName().equals(cbDentist.getSelectedItem()) ) {
				if (empAvailability.getDay().equals(appendDay((String) cbDay.getSelectedItem()))) {
					for (int i = 0; i < empAvailability.getTimeSlot().size(); i++ ) {
						if (!mainFrame.getAbsMaps().validateBooking(empAvailability.getDay(), 
								empAvailability.getTimeSlot().get(i))) {
							cbTime.addItem(empAvailability.getTimeSlot().get(i));
						}		
					}
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
			
			for (Availability empAvailability : mainFrame.getAbsMaps().getEmployeeAvailabilityMap().values()) {
				if (empAvailability.getEmployeeUserName().equals(cbDentist.getSelectedItem()) ) {
					if (empAvailability.getDay().equals(appendDay((String) cbDay.getSelectedItem()))) {
						if (empAvailability.getTimeSlot().contains(cbTime.getSelectedItem())) {
							mainFrame.getAbsMaps().createBooking(appendDay((String) cbDay.getSelectedItem()), 
									(String) cbTime.getSelectedItem(), mainFrame.getCustomer().getUserName(), 
									(String) cbDentist.getSelectedItem());
							System.out.println(mainFrame.getAbsMaps().getBookingMap());
							mainFrame.getFileOps().compileBookingMapStrings(AbsTest.BOOKINGWRITEFILEPATH, mainFrame.getAbsMaps().getBookingMap());
							
							JOptionPane.showMessageDialog(null, "You've successfully book an appointment on: \n" + (String) cbDay.getSelectedItem() + " at " + (String) cbTime.getSelectedItem().toString() + 
									" with " + (String) cbDentist.getSelectedItem() + ".");
						}
					}	
				}
			}
			dispose();
		}
	}
	
	/* code dupe 
	 * should be created in mainCustFrame
	 * need to refactor later */
	public String appendDay(String day) {
		String appendDay;
		appendDay = day.substring(0, (day.length()-(day.length()-3)));
		return appendDay;
	}

}
