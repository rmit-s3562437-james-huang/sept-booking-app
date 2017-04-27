package abs.view.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import abs.model.AbsClientSystemImpl;
import abs.model.AbsFileOperationImpl;
import abs.model.AbsMaps;
import abs.model.users.Customer;

public class LoginPanel extends JPanel implements ActionListener {

	private JButton loginButton;
	private JButton registerButton;
	private JTextField userNameField;
	private JPasswordField passWordField;
	private AbsMaps absMaps;
	private LoginFrame loginFrame;
	private AbsClientSystemImpl absClientSystem;
	private AbsFileOperationImpl absfileops;
	
	public LoginPanel(LoginFrame loginFrame, AbsMaps absMaps, AbsClientSystemImpl absClientSystem, AbsFileOperationImpl absfileops) {
		
		this.loginFrame = loginFrame;
		this.absMaps = absMaps;
		this.absClientSystem = absClientSystem;
		this.absfileops = absfileops;
		
		setLayout(new GridLayout(3,2,5,5));
		
		loginButton = new JButton("Login");
		registerButton = new JButton("Register");
		
		this.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		
		loginButton.addActionListener(this);
		registerButton.addActionListener(this);
		
		JLabel userNameLabel = new JLabel("Username: ");
		JLabel passWordLabel = new JLabel("Password: ");
		
		userNameField = new JTextField();
		passWordField = new JPasswordField();
		
		add(userNameLabel);
		add(userNameField);
		add(passWordLabel);
		add(passWordField);
		add(loginButton);
		add(registerButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(loginButton)) {
			
			String userName = userNameField.getText();
			String passWord = String.valueOf(passWordField.getPassword());
			
			if(absMaps.customerValidation(userName, passWord) == true) {
				System.out.println("successful login!");
				/* to get the customer from the map and revalidate */
				for (Customer customer : absMaps.getCustomerMap().values()) {
					if (customer.getUserName().equals(userName) && 
							customer.getUserPassword().equals(passWord)) {
						new MainCustomerFrame(customer);
					}
				}
				loginFrame.dispose();
			} else if (absMaps.ownerValidation(userName, passWord) == true) {
				/*
				 * TODO
				 */
				System.out.println("successful login!");
				
			} else {
				JOptionPane.showMessageDialog(loginButton, "Inccorect password or username");
			}
		}
		
		if(e.getSource().equals(registerButton)) {
			System.out.println("Proceed to register using register function.");
			new RegisterFrame(absMaps, absClientSystem, absfileops);
			loginFrame.dispose();
		}
	}
}
