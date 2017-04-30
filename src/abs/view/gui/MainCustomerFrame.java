package abs.view.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import abs.model.AbsClientSystemImpl;
import abs.model.AbsFileOperationImpl;
import abs.model.AbsMaps;
import abs.model.interfaces.FileOperation;
import abs.model.users.Customer;

public class MainCustomerFrame extends JFrame {

	private static final int WINDOW_WIDTH = 400;
	private static final int WINDOW_HEIGHT = 360;
	
	
	private JPanel mainPanel;
	private MainCustomerPanel maincustomerpanel;
	private AbsMaps absMaps;
	private Customer customer;
	private AbsFileOperationImpl fileOps;
	private AbsClientSystemImpl absClientSystem;
	
	public MainCustomerFrame(Customer customer, AbsFileOperationImpl fo, AbsMaps absMaps, AbsClientSystemImpl absClientSystem) {
		super("Customer - Main menu");
		this.absClientSystem = absClientSystem;
		this.absMaps = absMaps;
		this.customer = customer;
		this.fileOps = fo;
		
		maincustomerpanel = new MainCustomerPanel(this);
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
	
	public AbsClientSystemImpl getClientSystem() {
		return absClientSystem;
	}
	
	public AbsMaps getAbsMaps() {
		return absMaps;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public AbsFileOperationImpl getFileOps() {
		return fileOps;
	}
}
