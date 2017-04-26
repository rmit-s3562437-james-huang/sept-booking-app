package abs.view.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

import abs.model.AbsMaps;
import abs.model.AbsClientSystemImpl;

import abs.model.users.Customer;

public class RegisterPanel extends JPanel implements ActionListener {

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
	
	private RegisterFrame registerFrame;
	private AbsMaps absmaps;
	private AbsClientSystemImpl absclientsystem;
	
	public RegisterPanel(RegisterFrame registerFrame, AbsMaps absmaps, AbsClientSystemImpl absclientsystem) {
		
		this.registerFrame = registerFrame;
		this.absmaps = absmaps;
		this.absclientsystem = absclientsystem;
		
		setLayout(new GridLayout(11,2,5,5));
		
		confirmButton = new JButton("Confirm");
		backButton = new JButton("Back");
		
		confirmButton.addActionListener(this);
		backButton.addActionListener(this);
		
		JLabel nameLabel = new JLabel("First Name:");
		badNameLabel = new JLabel("You name cannot be an empty string or contain numbers!");
		badNameLabel.setForeground(Color.RED);
		badNameLabel.setVisible(false);
		
		JLabel userNameLabel = new JLabel("Username:");
		badUserNameLabel = new JLabel("You username cannot be an empty string or is currently in use!");
		badUserNameLabel.setForeground(Color.RED);
		badUserNameLabel.setVisible(false);
		
		JLabel passwordLabel = new JLabel("Password:");
		badPasswordLabel = new JLabel("Your password must be atleast 6 characters long!");
		badPasswordLabel.setForeground(Color.RED);
		badPasswordLabel.setVisible(false);
		
		JLabel addressLabel = new JLabel("Address:");
		badAddressLabel = new JLabel("Your address cannot be an empty string!");
		badAddressLabel.setForeground(Color.RED);
		badAddressLabel.setVisible(false);
		
		JLabel phoneNumberLabel = new JLabel("Phone Number:");
		badPhoneNumberLabel = new JLabel("Please enter a valid Australian phone number!");
		badPhoneNumberLabel.setForeground(Color.RED);
		badPhoneNumberLabel.setVisible(false);
		
		this.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 0));
		
		nameField = new JTextField("");
		userNameField = new JTextField("");
		addressField = new JTextField("");
		phoneNumberField = new JTextField("");
		
		passwordField = new JPasswordField("");
		
		add(nameLabel);
		add(nameField);
		add(new JPanel());
		add(badNameLabel);
		
		add(userNameLabel);
		add(userNameField);
		add(new JPanel());
		add(badUserNameLabel);
		
		add(passwordLabel);
		add(passwordField);
		add(new JPanel());
		add(badPasswordLabel);
		
		add(addressLabel);
		add(addressField);
		add(new JPanel());
		add(badAddressLabel);
		
		add(phoneNumberLabel);
		add(phoneNumberField);
		add(new JPanel());
		add(badPhoneNumberLabel);
		
		add(backButton);
		add(confirmButton);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(confirmButton)) {
			boolean legit = checkDetails();
			
			if(legit) {
				//Customer newCustomer = new Customer();
				//absmaps.addCustomer(customer);
			}
		}
		
		if(e.getSource().equals(backButton)) {
			new LoginFrame(absmaps, absclientsystem);
			registerFrame.dispose();
		}
	}
	
	public boolean checkDetails() {
		
		String userName = userNameField.getText();
		String name = nameField.getText();
		String password = String.valueOf(passwordField.getPassword());
		String address = addressField.getText();
		String phoneNumber = phoneNumberField.getText();
		
		boolean allGood = true;
		
		if(absclientsystem.validUserName(userName)) {
			badUserNameLabel.setVisible(false);
		}
		else {
			allGood = false;
			badUserNameLabel.setVisible(true);
		}
		
		if(absclientsystem.validName(name)) {
			badNameLabel.setVisible(false);
		}
		else {
			allGood = false;
			badNameLabel.setVisible(true);
		}
		
		if(absclientsystem.validPassword(password)){
			badPasswordLabel.setVisible(false);
		}
		else {
			allGood = false;
			badPasswordLabel.setVisible(true);
		}
		
		if(absclientsystem.validAddress(address)) {
			badAddressLabel.setVisible(false);
		}
		else {
			allGood = false;
			badAddressLabel.setVisible(true);
		}
		
		if(absclientsystem.validPhoneNumber(phoneNumber)) {
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
