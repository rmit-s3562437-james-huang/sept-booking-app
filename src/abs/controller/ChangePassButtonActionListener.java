package abs.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import abs.model.users.Customer;
import abs.view.dialog.ChangePasswordDialog;

public class ChangePassButtonActionListener implements ActionListener {

	private ChangePasswordDialog changeDialog;
	private Customer customer;
	
	public ChangePassButtonActionListener(Customer customer) {
		this.customer = customer;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		changeDialog = new ChangePasswordDialog(customer);
	}

}
