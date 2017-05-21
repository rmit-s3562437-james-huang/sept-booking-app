package abs.view.gui;

import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import abs.model.AbsClientSystemImpl;
import abs.model.AbsFileOperationImpl;
import abs.model.AbsMaps;
import abs.model.users.Customer;
import abs.view.AbsTest;

public class LoginFrame extends JFrame {
	
	private static final int WINDOW_WIDTH = 400;
	private static final int WINDOW_HEIGHT = 225;

	private JPanel mainPanel;
	private LoginPanel loginPanel;
	private AbsMaps absMaps;
	private AbsClientSystemImpl absclientsystem;
	private Customer customer;
	private AbsFileOperationImpl absfileops;
	
	public LoginFrame(AbsMaps absMaps, AbsClientSystemImpl absclientsystem, AbsFileOperationImpl absfileops) {
		super("Appointment Booking System - Login");
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
		
		try {
			BufferedImage bannerImage = ImageIO.read(new File(AbsTest.BANNERPATH));
			JLabel bannerPanel = new JLabel(new ImageIcon(bannerImage));
			add(bannerPanel, BorderLayout.NORTH);
		}
		catch (IOException e) {
			System.out.println("Banner Image not found in " + AbsTest.PATHNAME + "!");
		}
		
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}

}
