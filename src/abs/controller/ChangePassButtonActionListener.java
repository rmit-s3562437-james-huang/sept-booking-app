package abs.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import abs.view.dialog.ChangePasswordDialog;
import abs.view.gui.MainCustomerFrame;

public class ChangePassButtonActionListener implements ActionListener {

	private MainCustomerFrame mainFrame;
	private ChangePasswordDialog changeDialog;
	
	public ChangePassButtonActionListener(MainCustomerFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		changeDialog = new ChangePasswordDialog(mainFrame);
	}

}
