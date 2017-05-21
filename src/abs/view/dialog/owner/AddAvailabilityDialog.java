package abs.view.dialog.owner;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import abs.model.users.Employee;
import abs.view.AbsTest;
import abs.view.dialog.customer.BookTimeDialog;
import abs.view.gui.MainOwnerFrame;

public class AddAvailabilityDialog extends JDialog {

	private static final int WINDOW_WIDTH = 400;
	private static final int WINDOW_HEIGHT = 250;
	
	private MainOwnerFrame mainOwnerFrame;
	
	private JLabel messageLabel;
	private JLabel employeeLabel;
	private JLabel dayLabel;
	private JLabel startTimeLabel;
	
	private JComboBox employeeComboBox;
	private JComboBox dayComboBox;
	private JTextField startTimeField;
	private JButton cancelButton;
	private JButton addButton;
	
	private JPanel addTimePanel;
	private JPanel buttonPanel;
	
	public AddAvailabilityDialog(MainOwnerFrame mainOwnerFrame) {
		
		setTitle("Add Employee Availabilities");
		setIconImage(new ImageIcon(AbsTest.ICONPATH).getImage());
		
		setLayout(new BorderLayout());
		
		addTimePanel = new JPanel();
		buttonPanel = new JPanel();
		
		employeeComboBox = new JComboBox();
		dayComboBox = new JComboBox();
		
		startTimeField = new JTextField();
		
		for (Employee employee : mainOwnerFrame.getAbsMaps().getEmployeeMap().values()) 
			employeeComboBox.addItem(employee.getName());
		
		for (int i = 0; i < BookTimeDialog.DAYS_OF_WEEK.length; i++) {
			dayComboBox.addItem(BookTimeDialog.DAYS_OF_WEEK[i]);
		}
		
		messageLabel = new JLabel("Adds a one hour shift from the starting time for selected employee.");
		employeeLabel = new JLabel("Employee: ");
		dayLabel = new JLabel("Day: ");
		startTimeLabel = new JLabel("Starting Time: ");
		
		addTimePanel.setLayout(new GridLayout(4,2,10,10));
		addTimePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		addTimePanel.add(employeeLabel);
		addTimePanel.add(employeeComboBox);
		
		addTimePanel.add(dayLabel);
		addTimePanel.add(dayComboBox);
		
		addTimePanel.add(startTimeLabel);
		addTimePanel.add(startTimeField);
		
		addButton = new JButton("Confirm");
		cancelButton = new JButton("Cancel");
		
		addTimePanel.add(cancelButton);
		addTimePanel.add(addButton);
		
		add(messageLabel, BorderLayout.NORTH);
		add(addTimePanel, BorderLayout.CENTER);
		
		setSize(this.WINDOW_WIDTH, this.WINDOW_HEIGHT);
		setResizable(false);
		setVisible(true);
		
	}

}
