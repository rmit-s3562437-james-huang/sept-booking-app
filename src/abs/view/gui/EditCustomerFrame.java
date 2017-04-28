package abs.view.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import abs.model.AbsClientSystemImpl;
import abs.model.AbsMaps;

public class EditCustomerFrame extends JFrame {
	
	private static final int WINDOW_WIDTH = 600;
	private static final int WINDOW_HEIGHT = 425;

	private JPanel mainPanel;
	private EditCustomerPanel editcustomerpanel;
	private AbsMaps absMaps;
	private AbsClientSystemImpl absclientsystem;
	
	public EditCustomerFrame() {
		super("Customer - Edit Information");
		
		this.absMaps = absMaps;
		this.absclientsystem = absclientsystem;
		 

		editcustomerpanel = new EditCustomerPanel(this, absMaps, absclientsystem);
		mainPanel = new JPanel();
		mainPanel.add(editcustomerpanel);

		setLayout(new BorderLayout());
		
		add(mainPanel, BorderLayout.CENTER);
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}

}
