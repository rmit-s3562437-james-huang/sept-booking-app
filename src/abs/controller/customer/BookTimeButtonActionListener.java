package abs.controller.customer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import abs.view.dialog.customer.BookTimeDialog;
import abs.view.gui.MainCustomerFrame;

public class BookTimeButtonActionListener implements ActionListener {

	private MainCustomerFrame mainFrame;
	
	public BookTimeButtonActionListener(MainCustomerFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new BookTimeDialog(mainFrame);

	}

}
