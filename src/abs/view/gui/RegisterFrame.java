package abs.view.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class RegisterFrame extends JFrame {

	private static final int WINDOW_WIDTH = 600;
	private static final int WINDOW_HEIGHT = 450;
	
	private JPanel mainPanel;
	private RegisterPanel registerPanel;
	
	
	public RegisterFrame() {
		super("Registration Form");
		
		registerPanel = new RegisterPanel(this);
		mainPanel = new JPanel();
		mainPanel.add(registerPanel);

		setLayout(new BorderLayout());
		
		add(mainPanel, BorderLayout.CENTER);
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
	
}
