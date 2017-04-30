package abs.controller.customer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import abs.model.AbsMaps;
import abs.view.dialog.customer.DisplayAllBookingDialog;
import abs.view.gui.MainCustomerFrame;

public class DisplayAllBookingButtonActionListener implements ActionListener {

	private MainCustomerFrame mainFrame;
	
	public DisplayAllBookingButtonActionListener(MainCustomerFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new DisplayAllBookingDialog(mainFrame);
	}

}
