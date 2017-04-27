package abs.view.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import abs.model.AbsClientSystemImpl;
import abs.model.AbsMaps;

public class RegisterFrame extends JFrame {

	private static final int WINDOW_WIDTH = 400;
	private static final int WINDOW_HEIGHT = 278;
	
	private JPanel mainPanel;
	private RegisterPanel registerPanel;
	
	private AbsClientSystemImpl absClientSystem;
	private AbsMaps absMaps;
	
	public RegisterFrame(AbsMaps absMaps, AbsClientSystemImpl absClientSystem) {
		super("Registration Form");
		
		this.absClientSystem = absClientSystem;
		this.absMaps = absMaps;
		
		registerPanel = new RegisterPanel(this, absMaps, absClientSystem);
		mainPanel = new JPanel();
		mainPanel.add(registerPanel);

		setLayout(new BorderLayout());
		
		add(mainPanel, BorderLayout.CENTER);
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}
	
}
