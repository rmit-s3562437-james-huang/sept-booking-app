package abs.view.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import abs.model.AbsClientSystemImpl;
import abs.model.AbsMaps;

public class LoginFrame extends JFrame {
	
	private static final int WINDOW_WIDTH = 400;
	private static final int WINDOW_HEIGHT = 150;

	private JPanel mainPanel;
	private LoginPanel loginPanel;
	private AbsMaps absMaps;
	private AbsClientSystemImpl absclientsystem;
	
	public LoginFrame(AbsMaps absMaps, AbsClientSystemImpl absclientsystem) {
		super("Dentist Booking System - Login");
		this.absMaps = absMaps;
		this.absclientsystem = absclientsystem;
		 
		/* store login panel to a main panel 
		 * without set border required */
		loginPanel = new LoginPanel(this, absMaps, absclientsystem);
		mainPanel = new JPanel();
		mainPanel.add(loginPanel);

		setLayout(new BorderLayout());
		
		add(mainPanel, BorderLayout.CENTER);
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}

}
