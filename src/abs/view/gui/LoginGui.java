package abs.view.gui;

import javax.swing.*;
import java.awt.*;

public class LoginGui extends JFrame {
	
	private static final int WINDOW_WIDTH = 400;
	private static final int WINDOW_HEIGHT = 150;
	
	public LoginGui() {
		super("Login");
	}
	
	public void build() {
		
		JPanel container = new JPanel();
		JPanel grid = new JPanel(new GridLayout(3,2,5,5));
		
		JButton loginButton = new JButton("Login");
		JButton registerButton = new JButton("Register");
		
		JLabel userNameLabel = new JLabel("Username: ");
		JLabel passWordLabel = new JLabel("Password: ");
		
		JTextField userNameField = new JTextField(15);
		JPasswordField passWordField = new JPasswordField(15);
		
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

}
