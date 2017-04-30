package abs.view.dialog.customer;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import abs.view.gui.MainCustomerFrame;

public class RemoveTimeDialog extends JDialog {

	private MainCustomerFrame mainFrame;
	
	private JLabel selectDayLabel;
	private JLabel selectTimeLabel;
	
	private JButton okButton;
	private JButton cancelButton;
	
	private JPanel buttonPanel;
	private JPanel removePanel;
	
	private JComboBox cbDay;
	private JComboBox cbTime;
	
	
	public RemoveTimeDialog(MainCustomerFrame mainFrame) {
		setTitle("Remove booking");
		this.mainFrame = mainFrame;
		setLayout(new BorderLayout());
		
		buttonPanel = new JPanel();
		removePanel = new JPanel();
		removePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		removePanel.setLayout(new GridLayout(0,2));
		
		cbDay = new JComboBox();
		cbTime = new JComboBox();
		
		selectDayLabel = new JLabel("Select day: ");
		selectTimeLabel = new JLabel("Select time: ");
		
		removePanel.add(selectDayLabel);
		removePanel.add(cbDay);
		removePanel.add(selectTimeLabel);
		removePanel.add(cbTime);
		
		okButton = new JButton("OK");
		cancelButton = new JButton("Cancel");
		
		buttonPanel.add(okButton);
		buttonPanel.add(cancelButton);
		
		add(removePanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
		
		setSize(300, 150);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	
}
