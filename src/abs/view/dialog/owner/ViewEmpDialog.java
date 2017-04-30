package abs.view.dialog.owner;

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
		
		viewPanel.setBorder(BorderFactory.createEmptyBorder(2, 40, 2, 10));
		
		viewPanel.add(new JLabel("Name"));
		viewPanel.add(new JLabel("Username"));
		viewPanel.add(new JLabel("Password"));
		viewPanel.add(new JLabel("Address"));
		viewPanel.add(new JLabel("Phone Number"));
		
		
		for (Employee employee : mainOwnerFrame.getAbsMaps().getEmployeeMap().values()) {
			System.out.println(employee);
			
			viewPanel.add(new JLabel(employee.getName()));
			viewPanel.add(new JLabel(employee.getUserName()));
			viewPanel.add(new JLabel(employee.getUserPassword()));
			viewPanel.add(new JLabel(employee.getUserAddress()));
			viewPanel.add(new JLabel(employee.getUserPhoneNumber()));
		}
		
		add(viewPanel);
		
		setSize(700, 200);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
