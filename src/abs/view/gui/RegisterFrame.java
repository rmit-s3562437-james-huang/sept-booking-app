package abs.view.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import abs.model.AbsClientSystemImpl;
import abs.model.AbsMaps;

public class RegisterFrame extends JFrame {

	private static final int WINDOW_WIDTH = 800;
	private static final int WINDOW_HEIGHT = 500;
	
	private JPanel mainPanel;
	private RegisterPanel registerPanel;
	
	private AbsClientSystemImpl absclientsystem;
	private AbsMaps absmaps;
	
	public RegisterFrame(AbsMaps absmaps, AbsClientSystemImpl absclientsystem) {
		super("Registration Form");
		
		this.absclientsystem = absclientsystem;
		this.absmaps = absmaps;
		
		registerPanel = new RegisterPanel(this, absmaps, absclientsystem);
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
