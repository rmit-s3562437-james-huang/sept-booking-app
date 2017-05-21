package abs.view.gui;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import abs.model.AbsClientSystemImpl;
import abs.model.AbsFileOperationImpl;
import abs.model.AbsMaps;
import abs.model.users.Customer;
import abs.view.AbsTest;

public class LoginFrame extends JFrame {
	
	private static final int WINDOW_WIDTH = 400;
	private static final int WINDOW_HEIGHT = 150;

	private JPanel mainPanel;
	private LoginPanel loginPanel;
	private AbsMaps absMaps;
	private AbsClientSystemImpl absclientsystem;
	private Customer customer;
	private AbsFileOperationImpl absfileops;
	
	public LoginFrame(AbsMaps absMaps, AbsClientSystemImpl absclientsystem, AbsFileOperationImpl absfileops) {
		super("Dentist Booking System - Login");
		this.absMaps = absMaps;
		this.absclientsystem = absclientsystem;
		this.absfileops = absfileops;
		
		setIconImage(new ImageIcon(AbsTest.ICONPATH).getImage());
		
		/* store login panel to a main panel 
		 * without set border required */
		loginPanel = new LoginPanel(this, absMaps, absclientsystem, absfileops);
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
