package abs.view.gui;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import abs.model.AbsClientSystemImpl;
import abs.model.AbsMaps;

public class MainCustomerFrame extends JFrame{

	private static final int WINDOW_WIDTH = 400;
	private static final int WINDOW_HEIGHT = 325;
	
	
	private JPanel mainPanel;
	private MainCustomerPanel maincustomerpanel;
	//private AbsMaps absMaps;
	//private AbsClientSystemImpl absclientsystem;	
	
	public MainCustomerFrame() {
		super("Customer - Main menu");
		
		//this.absMaps = absMaps;
		//this.absclientsystem = absclientsystem;
		
		maincustomerpanel = new MainCustomerPanel(this);
		mainPanel = new JPanel();
		mainPanel.add(maincustomerpanel);
		
		setLayout(new BorderLayout());
		//setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));
		
		add(mainPanel, BorderLayout.CENTER);
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}
}
