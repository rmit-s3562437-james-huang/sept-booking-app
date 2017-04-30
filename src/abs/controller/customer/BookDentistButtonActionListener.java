package abs.controller.customer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import abs.view.dialog.customer.BookDentistDialog;
import abs.view.gui.MainCustomerFrame;

public class BookDentistButtonActionListener implements ActionListener {

	private MainCustomerFrame mainFrame;
	
	public BookDentistButtonActionListener(MainCustomerFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new BookDentistDialog(mainFrame);

	}

}
