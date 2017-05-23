package abs.view.dialog.owner;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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

public class AddAvailabilityDialog extends JDialog implements ActionListener {

	private static final int WINDOW_WIDTH = 400;
	private static final int WINDOW_HEIGHT = 200;
	
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
		this.mainOwnerFrame = mainOwnerFrame;
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
		addButton.addActionListener(this);
		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(this);
		
		addTimePanel.add(cancelButton);
		addTimePanel.add(addButton);
		
		add(messageLabel, BorderLayout.NORTH);
		add(addTimePanel, BorderLayout.CENTER);
		
		setSize(this.WINDOW_WIDTH, this.WINDOW_HEIGHT);
		setLocationRelativeTo(null);
		//setResizable(false);
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(addButton)) {
			
			ArrayList<String> timeSlot = new ArrayList<String>();
			String startTime = startTimeField.getText();
			String finishTime = incrementHour(startTime);
			String time = startTime + "-" + finishTime;
			System.out.println(time);
			timeSlot.add(time);
			String day = appendDay((String) dayComboBox.getSelectedItem());
			String emp = (String) employeeComboBox.getSelectedItem();
			mainOwnerFrame.getAbsMaps().createAvailability(emp, day, timeSlot);
			mainOwnerFrame.getFileOps().compileAvailabilityMapStrings(AbsTest.AVAILABILITYWRITEFILEPATH, mainOwnerFrame.getAbsMaps().getAvailabilityMap());
		}
		if(e.getSource().equals(cancelButton)) {
			dispose();
		}
	}
	
	public String incrementHour(String startTime) {
		
		String ret;
		int x,y;
		String[] array = startTime.split("");
		
		if(array[1].equals('9')) {
			if(array[0].equals('2')) {
				ret = "";
				return ret;
			}
			else {
				x = Integer.parseInt(array[0]);
				x++;
				array[0] = Integer.toString(x);
				array[1] = "0";
			}
		}
		else {
			x = Integer.parseInt(array[1]);
			x++;
			array[1] = Integer.toString(x);
		}
		
		ret = array[0] + array[1] + array[2] + array[3] + array[4]; 
		
		System.out.println(ret);
		
		return ret;
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
