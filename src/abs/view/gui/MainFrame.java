package abs.view.gui;

import javax.swing.JFrame;

public class MainFrame extends JFrame {

	private static final int WINDOW_WIDTH = 600;
	private static final int WINDOW_HEIGHT = 450;
	
	public MainFrame() {
		super("Customer - Main menu");
		
		
		
		
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
}
