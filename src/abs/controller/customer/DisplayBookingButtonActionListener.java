package abs.controller.customer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import abs.view.dialog.customer.DisplayBookingDialog;
import abs.view.gui.MainCustomerFrame;

public class DisplayBookingButtonActionListener implements ActionListener {
	
	private MainCustomerFrame mainCustomerFrame;

	public DisplayBookingButtonActionListener(MainCustomerFrame mainCustomerFrame) {
		this.mainCustomerFrame = mainCustomerFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new DisplayBookingDialog(mainCustomerFrame);
	}

}
