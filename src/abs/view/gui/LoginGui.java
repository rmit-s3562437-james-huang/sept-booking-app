package abs.view.gui;

import javax.swing.*;
import java.awt.*;

public class LoginGui implements GuiInterface {
	
	private static final int WINDOW_WIDTH = 350;
	private static final int WINDOW_HEIGHT = 250;
	
	public LoginGui() {
		
	}
	
	public void build() {
		JFrame window = new JFrame("Login");
		
		window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setVisible(true);
	}
	

}
