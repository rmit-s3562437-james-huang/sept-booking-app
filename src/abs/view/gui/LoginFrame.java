package abs.view.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import abs.model.AbsMaps;

public class LoginFrame extends JFrame {
	
	private static final int WINDOW_WIDTH = 400;
	private static final int WINDOW_HEIGHT = 150;

	private JPanel mainPanel;
	private LoginPanel loginPanel;
	private AbsMaps absMaps;
	
	public LoginFrame(AbsMaps absMaps) {
		super("Dentist Booking System - Login");
		this.absMaps = absMaps;
		 
		/* store login panel to a main panel 
		 * without set border required */
		loginPanel = new LoginPanel(this, absMaps);
		mainPanel = new JPanel();
		mainPanel.add(loginPanel);

		setLayout(new BorderLayout());
		
		add(mainPanel, BorderLayout.CENTER);
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}

}
