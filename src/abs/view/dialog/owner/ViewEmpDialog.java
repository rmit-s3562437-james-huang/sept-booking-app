package abs.view.dialog.owner;

import javax.swing.JDialog;
import javax.swing.JPanel;

import abs.model.users.Employee;
import abs.view.gui.MainOwnerFrame;

public class ViewEmpDialog extends JDialog {

	private JPanel bookPanel;
	
	public ViewEmpDialog(MainOwnerFrame mainOwnerFrame) {
		setTitle("Employee Details");
		
		for (Employee employee : mainOwnerFrame.getAbsMaps().getEmployeeMap().values()) {
			System.out.println(employee);
		}
		
		
		setSize(800, 300);
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
