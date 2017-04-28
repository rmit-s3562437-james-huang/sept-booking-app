package abs.view.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
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

public class EditCustomerPanel extends JPanel implements ActionListener {
	

	private JButton backButton;                        
	private JLabel nameLabel, usernameLabel, passwordLabel, addressLabel, phoneLabel;
	private JLabel badnameLabel, badusernameLabel, badpasswordLabel, badaddressLabel, badphoneLabel;
	private JTextField nameField, usernameField, passwordField, addressField, phoneField;
	
	private EditCustomerFrame editcustomerframe;
	private MainCustomerFrame maincustomerframe;
	private AbsMaps absmaps;
	private AbsClientSystemImpl absclientsystem;
	
	public EditCustomerPanel(EditCustomerFrame editcustomerframe, AbsMaps absmaps, AbsClientSystemImpl absclientsystem) {

			this.editcustomerframe = editcustomerframe;
			this.absmaps = absmaps;
			this.absclientsystem = absclientsystem;
			
			setLayout(new GridLayout(10,2,5,5));
			setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));
         
			backButton = new JButton("Back");
			backButton.addActionListener(this);
			
			nameLabel = new JLabel("Name: ");
			badnameLabel = new JLabel("  You name cannot be an empty string or contain numbers!");
			badnameLabel.setForeground(Color.RED);
			badnameLabel.setFont(new Font("Arial", Font.PLAIN, 9));
			badnameLabel.setVisible(false);
			
			usernameLabel = new JLabel("Username: ");
			badusernameLabel = new JLabel("  You username cannot be empty or currently exists!");
			badusernameLabel.setForeground(Color.RED);
			badusernameLabel.setFont(new Font("Arial", Font.PLAIN, 9));
			badusernameLabel.setVisible(false);
		
			passwordLabel = new JLabel("Password: ");
			badpasswordLabel = new JLabel("  Your password must be atleast 6 characters long!");
			badpasswordLabel.setForeground(Color.RED);
			badpasswordLabel.setFont(new Font("Arial", Font.PLAIN, 9));
			badpasswordLabel.setVisible(false);
			
			addressLabel = new JLabel("Address: ");
			badaddressLabel = new JLabel("  Your address cannot be an empty string!");
			badaddressLabel.setForeground(Color.RED);
			badaddressLabel.setFont(new Font("Arial", Font.PLAIN, 9));
			badaddressLabel.setVisible(false);
			
			phoneLabel = new JLabel("Phone Number: ");
			badphoneLabel = new JLabel("  Please enter a valid Australian phone number!");
			badphoneLabel.setForeground(Color.RED);
			badphoneLabel.setFont(new Font("Arial", Font.PLAIN, 9));
			badphoneLabel.setVisible(false);
			
			this.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));
				
			nameField = new JTextField(20);
			usernameField = new JTextField(20);
			passwordField = new JPasswordField(20);
			addressField = new JTextField(20);
			phoneField = new JTextField(20);
			
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
		    gbc.gridy = 3;
			add(badusernameLabel, gbc);
			
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
			add(badpasswordLabel, gbc);
			
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
			add(badaddressLabel, gbc);
			
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.gridx = 0;
		    gbc.gridy = 8;
			add(phoneLabel, gbc);
			
			gbc.gridx = 1;
		    gbc.gridy = 8;
			add(phoneField, gbc);
			
			gbc.gridx = 0;
		    gbc.gridy = 9;
			add(new JPanel(), gbc);
			
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.gridx = 1;
		    gbc.gridy = 9;
			add(badphoneLabel, gbc);

			gbc.insets = new Insets(4,0,0,0);
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.gridx = 0;
		    gbc.gridy = 10;
			add(backButton, gbc);
			
	
			
	}
	@Override
	public void actionPerformed(ActionEvent e){
		
		if(e.getSource().equals(backButton)){
			new MainCustomerFrame();
			editcustomerframe.dispose();
		}
	}
	
public boolean checkDetails() {
		
		String userName = usernameField.getText();
		String name = nameField.getText();
		String password = String.valueOf(((JPasswordField) passwordField).getPassword());
		String address = addressField.getText();
		String phoneNumber = phoneField.getText();
		
		boolean allGood = true;
		
		if(absclientsystem.validUserName(userName)) {
			badusernameLabel.setVisible(false);
		}
		else {
			allGood = false;
			badusernameLabel.setVisible(true);
		}
		
		if(absclientsystem.validName(name)) {
			badnameLabel.setVisible(false);
		}
		else {
			allGood = false;
			badnameLabel.setVisible(true);
		}
		
		if(absclientsystem.validPassword(password)){
			badpasswordLabel.setVisible(false);
		}
		else {
			allGood = false;
			badpasswordLabel.setVisible(true);
		}
		
		if(absclientsystem.validAddress(address)) {
			badaddressLabel.setVisible(false);
		}
		else {
			allGood = false;
			badaddressLabel.setVisible(true);
		}
		
		if(absclientsystem.validPhoneNumber(phoneNumber)) {
			badphoneLabel.setVisible(false);
		}
		else {
			allGood = false;
			badphoneLabel.setVisible(true);
		}
		
		if(allGood) {
			return true;
		}
		
		return false;
	}
}
