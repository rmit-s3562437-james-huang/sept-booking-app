package abs.view.gui;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import abs.model.AbsClientSystemImpl;
import abs.model.AbsFileOperationImpl;
import abs.model.AbsMaps;
import abs.model.users.Owner;
import abs.view.AbsTest;

public class MainOwnerFrame extends JFrame {

	private static final int WINDOW_WIDTH = 400;
	private static final int WINDOW_HEIGHT = 279;
	
	private JPanel mainPanel;
	private MainOwnerPanel mainOwnerPanel;
	private AbsMaps absMaps;
	private Owner owner;
	private AbsFileOperationImpl fileOps;
	private AbsClientSystemImpl absClientSystem;
	
	public MainOwnerFrame(Owner owner, AbsFileOperationImpl fo, AbsMaps absMaps, AbsClientSystemImpl absClientSystem) {
		super("Owner - Main menu");
		this.absClientSystem = absClientSystem;
		this.absMaps = absMaps;
		this.owner = owner;
		this.fileOps = fo;
		
		setIconImage(new ImageIcon(AbsTest.ICONPATH).getImage());
		
		mainOwnerPanel = new MainOwnerPanel(this);
		mainPanel = new JPanel();
		mainPanel.add(mainOwnerPanel);
		
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
	
	public AbsFileOperationImpl getFileOps() {
		return fileOps;
	}
	
	public Owner getBusinessOwner() {
		return owner;
	}
}
