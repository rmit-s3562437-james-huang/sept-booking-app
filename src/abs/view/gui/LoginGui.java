package abs.view.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGui extends JFrame {
	
	private static final int WINDOW_WIDTH = 400;
	private static final int WINDOW_HEIGHT = 150;
	private JButton loginButton;
	private JButton registerButton;
	private JTextField userNameField;
	private JPasswordField passWordField;
	
	public LoginGui() {
		super("Login");
		build();
	}
	
	public void build() {
		
		JPanel container = new JPanel();
		JPanel grid = new JPanel(new GridLayout(3,2,5,5));
		LoginHandler loginHandler = new LoginHandler();
		
		loginButton = new JButton("Login");
		registerButton = new JButton("Register");
		
		loginButton.addActionListener(loginHandler);
		registerButton.addActionListener(loginHandler);
		
		JLabel userNameLabel = new JLabel("Username: ");
		JLabel passWordLabel = new JLabel("Password: ");
		
		userNameField = new JTextField();
		passWordField = new JPasswordField();
		
		userNameField.addActionListener(loginHandler);
		passWordField.addActionListener(loginHandler);
		
		grid.add(userNameLabel);
		grid.add(userNameField);
		grid.add(passWordLabel);
		grid.add(passWordField);
		grid.add(loginButton);
		grid.add(registerButton);
		
		container.add(grid);
		
		setLayout(new BorderLayout());
		
		add(container, BorderLayout.NORTH);
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
	
	private class LoginHandler implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource().equals(loginButton) || e.getSource().equals(userNameField) 
					|| e.getSource().equals(passWordField)) {
				
				String userName = userNameField.getText();
				String passWord = passWordField.getText();
				
				System.out.println("Attempt Login using Controler Function:");
				System.out.println("userName: " + userName);
				System.out.println("passWord: " + passWord);
			}
			else if(e.getSource().equals(registerButton)) {
				System.out.println("Proceed to register using register function.");
			}
			
		}
		
	}

}
