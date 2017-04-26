package abs.view.gui;

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

public class RegisterPanel extends JPanel implements ActionListener {

	private JButton confirmButton;
	private JButton backButton;
	private JTextField nameField;
	private JTextField userNameField;
	private JTextField addressField;
	private JTextField phoneNumberField;
	private JPasswordField passwordField;
	
	private RegisterFrame registerFrame;
	private AbsMaps absmaps;
	private AbsClientSystemImpl absclientsystem;
	
	public RegisterPanel(RegisterFrame registerFrame) {
		
		this.registerFrame = registerFrame;
		//this.absmaps = absmaps;
		//this.absclientsystem = absclientsystem;
		
		setLayout(new GridLayout(6,2,5,5));
		
		confirmButton = new JButton("Confirm");
		backButton = new JButton("Back");
		
		confirmButton.addActionListener(this);
		backButton.addActionListener(this);
		
		JLabel nameLabel = new JLabel("First Name:");
		JLabel userNameLabel = new JLabel("Username:");
		JLabel passwordLabel = new JLabel("Password:");
		JLabel addressLabel = new JLabel("Address:");
		JLabel phoneNumberLabel = new JLabel("Phone Number:");
		
		this.setBorder(BorderFactory.createEmptyBorder(75, 0, 0, 0));
		
		nameField = new JTextField();
		userNameField = new JTextField();
		addressField = new JTextField();
		phoneNumberField = new JTextField();
		
		passwordField = new JPasswordField();
		
		add(nameLabel);
		add(nameField);
		add(userNameLabel);
		add(userNameField);
		add(passwordLabel);
		add(passwordField);
		add(addressLabel);
		add(addressField);
		add(phoneNumberLabel);
		add(phoneNumberField);
		add(backButton);
		add(confirmButton);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(confirmButton)) {
			
		}
		
		if(e.getSource().equals(backButton)) {
			new LoginFrame(this.absmaps);
			registerFrame.dispose();
		}
	}
	
}
