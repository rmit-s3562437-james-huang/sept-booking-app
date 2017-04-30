package abs.view.dialog.customer;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map.Entry;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import abs.model.bookings.Booking;
import abs.view.AbsTest;
import abs.view.gui.MainCustomerFrame;

public class RemoveTimeDialog extends JDialog implements ActionListener {

	private MainCustomerFrame mainFrame;
	
	private JLabel selectDayLabel;
	private JLabel selectTimeLabel;
	
	private JButton okButton;
	private JButton cancelButton;
	
	private JPanel buttonPanel;
	private JPanel removePanel;
	
	private JComboBox cbDay;
	private JComboBox cbTime;
	
	
	public RemoveTimeDialog(MainCustomerFrame mainFrame) {
		setTitle("Remove booking");
		this.mainFrame = mainFrame;
		setLayout(new BorderLayout());
		
		buttonPanel = new JPanel();
		removePanel = new JPanel();
		removePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		removePanel.setLayout(new GridLayout(0,2));
		
		cbDay = new JComboBox();
		cbTime = new JComboBox();
		
		for (int i = 0; i < BookTimeDialog.DAYS_OF_WEEK.length; i++) {
			cbDay.addItem(BookTimeDialog.DAYS_OF_WEEK[i]);
		}
		
		cbDay.addActionListener(this);
		
		selectDayLabel = new JLabel("Select day: ");
		selectTimeLabel = new JLabel("Select time: ");
		
		removePanel.add(selectDayLabel);
		removePanel.add(cbDay);
		removePanel.add(selectTimeLabel);
		removePanel.add(cbTime);
		
		okButton = new JButton("Delete");
		okButton.addActionListener(this);
		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(this);
		
		buttonPanel.add(okButton);
		buttonPanel.add(cancelButton);
		
		add(removePanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
		
		setSize(300, 150);
		setLocationRelativeTo(null);
		setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(cancelButton)) {
			dispose();
		}
		
		cbTime.removeAllItems();
		for (Booking book : mainFrame.getAbsMaps().getBookingMap().values()) {
			if (book.getDay().equals(appendDay((String) cbDay.getSelectedItem()))) {
				if(book.getCustomerUserName().equals(mainFrame.getCustomer().getUserName())) {
					for(int i = 0; i < book.getTimeSlot().size(); i++) {
						cbTime.addItem(book.getTimeSlot().get(i));
					}
				}
			}
		}
		
		if (e.getSource().equals(okButton)) {
			for (Booking book : mainFrame.getAbsMaps().getBookingMap().values()) {
				for(int i = 0; i < book.getTimeSlot().size(); i++) {
					if (book.getTimeSlot().get(i).equals(cbTime.getSelectedItem())) {
						if(book.getDay().equals(appendDay((String) cbDay.getSelectedItem()))) {
							if (book.getCustomerUserName().equals(mainFrame.getCustomer().getUserName())) {
								book.getTimeSlot().remove(cbTime.getSelectedItem());
								mainFrame.getFileOps().compileBookingMapStrings(AbsTest.BOOKINGWRITEFILEPATH, 
										mainFrame.getAbsMaps().getBookingMap());
							}
						}
					}
				}
			}
			dispose();
		}
		
		java.util.Iterator<Entry<String, Booking>> iter = mainFrame.getAbsMaps().getBookingMap().entrySet().iterator();
		while (iter.hasNext()) {
		    Entry<String, Booking> entry = iter.next();
		    if(mainFrame.getAbsMaps().getBookingMap().get(entry.getKey()).getTimeSlot().isEmpty()){
		        iter.remove();
		    }
		    mainFrame.getFileOps().compileBookingMapStrings(AbsTest.BOOKINGWRITEFILEPATH, 
					mainFrame.getAbsMaps().getBookingMap());
		}
		
	}
	
	/* need to remove after refactor */
	public String appendDay(String day) {
		String appendDay;
		appendDay = day.substring(0, (day.length()-(day.length()-3)));
		return appendDay;
	}
}
