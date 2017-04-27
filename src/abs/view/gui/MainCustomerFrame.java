package abs.view.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import abs.model.users.Customer;

public class MainCustomerFrame extends JFrame{

	private static final int WINDOW_WIDTH = 400;
	private static final int WINDOW_HEIGHT = 325;
	
	
	private JPanel mainPanel;
	private MainCustomerPanel maincustomerpanel;
	
	public MainCustomerFrame(Customer customer) {
		super("Customer - Main menu");
		
		
		maincustomerpanel = new MainCustomerPanel(this, customer);
		mainPanel = new JPanel();
		mainPanel.add(maincustomerpanel);
		
		setLayout(new BorderLayout());
		
		add(mainPanel, BorderLayout.CENTER);
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}
}
