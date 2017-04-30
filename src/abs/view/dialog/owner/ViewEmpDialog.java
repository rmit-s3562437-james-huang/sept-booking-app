package abs.view.dialog.owner;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import abs.model.users.Employee;
import abs.view.gui.MainOwnerFrame;

public class ViewEmpDialog extends JDialog {

	private JPanel viewPanel;
	
	public ViewEmpDialog(MainOwnerFrame mainOwnerFrame) {
		setTitle("Employee Details");
		
		viewPanel = new JPanel();
		
		viewPanel.setLayout(new GridLayout(0, 5));
		
		viewPanel.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
		
		JLabel nameLabel = new JLabel("Name");
		nameLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		JLabel userLabel = new JLabel("UserName");
		userLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		JLabel passLabel = new JLabel("Password");
		passLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		JLabel addrLabel = new JLabel("Address");
		addrLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		JLabel phonLabel = new JLabel("Phone Number");
		phonLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		viewPanel.add(nameLabel);
		viewPanel.add(userLabel);
		viewPanel.add(passLabel);
		viewPanel.add(addrLabel);
		viewPanel.add(phonLabel);
		
		
		for (Employee employee : mainOwnerFrame.getAbsMaps().getEmployeeMap().values()) {
			System.out.println(employee);
			
			JLabel empNameLabel = new JLabel(employee.getName());
			empNameLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			JLabel empUserLabel = new JLabel(employee.getUserName());
			empUserLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			JLabel empPassLabel = new JLabel(employee.getUserPassword());
			empPassLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			JLabel empAddrLabel = new JLabel(employee.getUserAddress());
			empAddrLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			JLabel empPhonLabel = new JLabel(employee.getUserPhoneNumber());
			empPhonLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			
			viewPanel.add(empNameLabel);
			viewPanel.add(empUserLabel);
			viewPanel.add(empPassLabel);
			viewPanel.add(empAddrLabel);
			viewPanel.add(empPhonLabel);
		}
		
		add(viewPanel);
		
		setSize(700, 200);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
