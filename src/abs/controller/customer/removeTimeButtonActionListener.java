package abs.controller.customer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import abs.view.dialog.customer.RemoveTimeDialog;
import abs.view.gui.MainCustomerFrame;

public class removeTimeButtonActionListener implements ActionListener {

	private MainCustomerFrame mainFrame; 
	
	public removeTimeButtonActionListener(MainCustomerFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new RemoveTimeDialog(mainFrame);
	}

}
