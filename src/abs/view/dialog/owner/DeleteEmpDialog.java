package abs.view.dialog.owner;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import abs.model.users.Employee;
import abs.view.AbsTest;
import abs.view.gui.MainOwnerFrame;

public class DeleteEmpDialog extends JDialog implements ActionListener {
	
	private JLabel selectEmployeeLabel;
	private JComboBox cbEmployee;
	
	private JButton okButton;
	private JButton cancelButton;
	
	private JPanel buttonPanel;
	private JPanel deletePanel;
	
	private MainOwnerFrame mainOwnerFrame;

	public DeleteEmpDialog(MainOwnerFrame mainOwnerFrame) {
		setTitle("Delete Employee");
		setLayout(new BorderLayout());
		this.mainOwnerFrame = mainOwnerFrame;
		
		deletePanel = new JPanel();
		deletePanel.setLayout(new GridLayout(0, 2));
		deletePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		buttonPanel = new JPanel();
		
		cbEmployee = new JComboBox();
		
		for(Employee employee : mainOwnerFrame.getAbsMaps().getEmployeeMap().values()) {
			cbEmployee.addItem(employee.getUserName());
		}
		
		cbEmployee.addActionListener(this);
		
		okButton = new JButton("Delete");
		okButton.addActionListener(this);
		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(this);
		
		buttonPanel.add(okButton);
		buttonPanel.add(cancelButton);
		
		selectEmployeeLabel = new JLabel("Select employee: ");
		deletePanel.add(selectEmployeeLabel);
		deletePanel.add(cbEmployee);
		
		add(deletePanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
		
		setSize(260, 120);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(cancelButton)) {
			dispose();
		}
		
		if (e.getSource().equals(okButton)) {
			for(Employee employee : mainOwnerFrame.getAbsMaps().getEmployeeMap().values()) {
				if (employee.getUserName().equals(cbEmployee.getSelectedItem())) {
					System.out.println(employee.getUserName());
					mainOwnerFrame.getAbsMaps().getEmployeeMap().remove(employee.getUserName());
					mainOwnerFrame.getFileOps().compileEmployeeMapStrings(AbsTest.EMPLOYEEWRITEFILEPATH, 
							mainOwnerFrame.getAbsMaps().getEmployeeMap());
					JOptionPane.showMessageDialog(null, "Employee successfully removed.");
				}
			}
			dispose();
		}
	}

}
