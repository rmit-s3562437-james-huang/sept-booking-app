package abs.view.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import abs.model.AbsClientSystemImpl;
import abs.model.AbsMaps;

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
		
		this.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));
		
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
