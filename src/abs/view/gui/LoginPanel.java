package abs.view.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import abs.model.AbsClientSystemImpl;
import abs.model.AbsMaps;

public class LoginPanel extends JPanel implements ActionListener {

	private JButton loginButton;
	private JButton registerButton;
	private JTextField userNameField;
	private JPasswordField passWordField;
	private AbsMaps absmaps;
	private LoginFrame loginFrame;
	private AbsClientSystemImpl absclientsystem;
	
	public LoginPanel(LoginFrame loginFrame, AbsMaps absmaps, AbsClientSystemImpl absclientsystem) {
		
		this.loginFrame = loginFrame;
		this.absmaps = absmaps;
		this.absclientsystem = absclientsystem;
		
		setLayout(new GridLayout(3,2,5,5));
		
		loginButton = new JButton("Login");
		registerButton = new JButton("Register");
		
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
			
			if(absmaps.customerValidation(userName, passWord) == true) {
				System.out.println("successful login!");
				new MainCustomerFrame();
				loginFrame.dispose();
			} else if (absmaps.ownerValidation(userName, passWord) == true) {
				System.out.println("successful login!");
				
			} else {
				JOptionPane.showMessageDialog(loginButton, "Inccorect password or username");
			}
		}
		
		if(e.getSource().equals(registerButton)) {
			System.out.println("Proceed to register using register function.");
			new RegisterFrame(absmaps, absclientsystem);
			loginFrame.dispose();
		}
	}
}
