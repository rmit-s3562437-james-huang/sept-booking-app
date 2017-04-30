package abs.controller.customer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import abs.view.dialog.customer.ChangePasswordDialog;
import abs.view.gui.MainCustomerFrame;

public class ChangePassButtonActionListener implements ActionListener {

	private MainCustomerFrame mainFrame;
	
	public ChangePassButtonActionListener(MainCustomerFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new ChangePasswordDialog(mainFrame);
	}

}
