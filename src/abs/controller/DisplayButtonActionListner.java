package abs.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import abs.model.users.Customer;
import abs.view.gui.MainCustomerFrame;

public class DisplayButtonActionListner implements ActionListener {

	private MainCustomerFrame mainFrame;
	
	public DisplayButtonActionListner(MainCustomerFrame mainFrame) {
		this.mainFrame = mainFrame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, mainFrame.getCustomer().toString(), "Customer Information",
			    JOptionPane.PLAIN_MESSAGE);
	}
	
}
