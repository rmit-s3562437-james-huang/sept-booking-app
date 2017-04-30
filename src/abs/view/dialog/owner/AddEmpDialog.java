package abs.view.dialog.owner;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import abs.model.users.Customer;
import abs.model.users.Employee;
import abs.view.AbsTest;
import abs.view.gui.LoginFrame;
import abs.view.gui.MainOwnerFrame;

public class AddEmpDialog extends JDialog implements ActionListener {

	private static final int WINDOW_WIDTH = 400;
	private static final int WINDOW_HEIGHT = 278;
	
	private JButton confirmButton;
	private JButton backButton;
	private JTextField nameField;
	private JLabel badNameLabel;
	private JTextField userNameField;
	private JLabel badUserNameLabel;
	private JTextField addressField;
	private JLabel badAddressLabel;
	private JTextField phoneNumberField;
	private JLabel badPhoneNumberLabel;
	private JPasswordField passwordField;
	private JLabel badPasswordLabel;
	
	private MainOwnerFrame mainOwnerFrame;
	
	public AddEmpDialog(MainOwnerFrame mainOwnerFrame) {
		setTitle("Register Employee");
		
		this.mainOwnerFrame = mainOwnerFrame;
		setLayout(new GridBagLayout());
		
		confirmButton = new JButton("Confirm");
		backButton = new JButton("Back");
		
		confirmButton.addActionListener(this);
		backButton.addActionListener(this);
		
		JLabel nameLabel = new JLabel("First Name:");
		badNameLabel = new JLabel("  You name cannot be an empty string or contain numbers!");
		badNameLabel.setForeground(Color.RED);
		badNameLabel.setFont(new Font("Arial", Font.PLAIN, 9));
		badNameLabel.setVisible(false);
		
		JLabel userNameLabel = new JLabel("Username:");
		badUserNameLabel = new JLabel("  You username cannot be empty or currently exists!");
		badUserNameLabel.setForeground(Color.RED);
		badUserNameLabel.setFont(new Font("Arial", Font.PLAIN, 9));
		badUserNameLabel.setVisible(false);
		
		JLabel passwordLabel = new JLabel("Password:");
		badPasswordLabel = new JLabel("  Your password must be atleast 6 characters long!");
		badPasswordLabel.setForeground(Color.RED);
		badPasswordLabel.setFont(new Font("Arial", Font.PLAIN, 9));
		badPasswordLabel.setVisible(false);
		
		JLabel addressLabel = new JLabel("Address:");
		badAddressLabel = new JLabel("  Your address cannot be an empty string!");
		badAddressLabel.setForeground(Color.RED);
		badAddressLabel.setFont(new Font("Arial", Font.PLAIN, 9));
		badAddressLabel.setVisible(false);
		
		JLabel phoneNumberLabel = new JLabel("Phone Number:");
		badPhoneNumberLabel = new JLabel("  Please enter a valid Australian phone number!");
		badPhoneNumberLabel.setForeground(Color.RED);
		badPhoneNumberLabel.setFont(new Font("Arial", Font.PLAIN, 9));
		badPhoneNumberLabel.setVisible(false);
		
		//this.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));
		
		nameField = new JTextField(20);
		userNameField = new JTextField(20);
		addressField = new JTextField(20);
		phoneNumberField = new JTextField(20);
		passwordField = new JPasswordField(20);
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
	    gbc.gridy = 0;
		add(nameLabel, gbc);
		
		gbc.gridx = 1;
	    gbc.gridy = 0;
		add(nameField, gbc);
		
		gbc.gridx = 0;
	    gbc.gridy = 1;
		add(new JPanel(), gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 1;
	    gbc.gridy = 1;
		add(badNameLabel, gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
	    gbc.gridy = 2;
		add(userNameLabel, gbc);
		
		gbc.gridx = 1;
	    gbc.gridy = 2;
		add(userNameField, gbc);
		
		gbc.gridx = 0;
	    gbc.gridy = 3;
		add(new JPanel(), gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 1;
	    gbc.gridy = 3;
		add(badUserNameLabel, gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
	    gbc.gridy = 4;
		add(passwordLabel, gbc);
		
		gbc.gridx = 1;
	    gbc.gridy = 4;
		add(passwordField, gbc);
		
		gbc.gridx = 0;
	    gbc.gridy = 5;
		add(new JPanel(), gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 1;
	    gbc.gridy = 5;
		add(badPasswordLabel, gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
	    gbc.gridy = 6;
	    add(addressLabel, gbc);
		
	    gbc.gridx = 1;
	    gbc.gridy = 6;
		add(addressField, gbc);
		
		gbc.gridx = 0;
	    gbc.gridy = 7;
		add(new JPanel(), gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 1;
	    gbc.gridy = 7;
		add(badAddressLabel, gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
	    gbc.gridy = 8;
		add(phoneNumberLabel, gbc);
		
		gbc.gridx = 1;
	    gbc.gridy = 8;
		add(phoneNumberField, gbc);
		
		gbc.gridx = 0;
	    gbc.gridy = 9;
		add(new JPanel(), gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 1;
	    gbc.gridy = 9;
		add(badPhoneNumberLabel, gbc);

		gbc.insets = new Insets(4,0,0,0);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
	    gbc.gridy = 10;
		add(backButton, gbc);
		
		gbc.insets = new Insets(4,0,0,0);
		gbc.gridx = 1;
	    gbc.gridy = 10;
		add(confirmButton, gbc);
	
		
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String newName;
		String newUserName;
		String newPassword;
		String newAddress;
		String newPhoneNumber;
		Employee newEmployee;
		
		// I feel that this isn't the intended purpose of adding an Employee
		// rather, it should be to add the availabilities for bookings.
		if(e.getSource().equals(confirmButton)) {
			boolean legit = checkDetails();
			
			if(legit) {
				newName = nameField.getText();
				newUserName = userNameField.getText();
				newPassword = String.valueOf(passwordField.getPassword());
				newAddress = addressField.getText();
				newPhoneNumber = phoneNumberField.getText();
				newEmployee = new Employee(newName, newUserName, newPassword, newAddress, newPhoneNumber);
				mainOwnerFrame.getAbsMaps().addEmployee(newEmployee);
				mainOwnerFrame.getFileOps().compileEmployeeMapStrings(AbsTest.EMPLOYEEWRITEFILEPATH, mainOwnerFrame.getAbsMaps().getEmployeeMap());
				
				// Doesn't make sense to return to the menu for an employee to login
				// Employees have no functional menu and don't do anything since the
				// Owner does everything. They don't even need a password.
				
				JOptionPane.showMessageDialog(null, "You've successfully registered!\n Your username is: '" + newUserName + "'.\n Your password is: '" + 
					newPassword + "'.\n\n Press OK to go back to the Login Screen."); 
				new LoginFrame(mainOwnerFrame.getAbsMaps(), mainOwnerFrame.getClientSystem(), mainOwnerFrame.getFileOps());
				dispose();
			}
		}
		
		if(e.getSource().equals(backButton)) {
			dispose();
		}
	}
	
	/* code dupe */
	public boolean checkDetails() {
		
		String userName = userNameField.getText();
		String name = nameField.getText();
		String password = String.valueOf(passwordField.getPassword());
		String address = addressField.getText();
		String phoneNumber = phoneNumberField.getText();
		
		boolean allGood = true;
		
		if(mainOwnerFrame.getClientSystem().validUserName(userName)) {
			badUserNameLabel.setVisible(false);
		}
		else {
			allGood = false;
			badUserNameLabel.setVisible(true);
		}
		
		if(mainOwnerFrame.getClientSystem().validName(name)) {
			badNameLabel.setVisible(false);
		}
		else {
			allGood = false;
			badNameLabel.setVisible(true);
		}
		
		if(mainOwnerFrame.getClientSystem().validPassword(password)){
			badPasswordLabel.setVisible(false);
		}
		else {
			allGood = false;
			badPasswordLabel.setVisible(true);
		}
		
		if(mainOwnerFrame.getClientSystem().validAddress(address)) {
			badAddressLabel.setVisible(false);
		}
		else {
			allGood = false;
			badAddressLabel.setVisible(true);
		}
		
		if(mainOwnerFrame.getClientSystem().validPhoneNumber(phoneNumber)) {
			badPhoneNumberLabel.setVisible(false);
		}
		else {
			allGood = false;
			badPhoneNumberLabel.setVisible(true);
		}
		
		if(allGood) {
			return true;
		}
		
		return false;
	}

}
