package abs.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import abs.model.users.Customer;

public class DisplayButtonActionListner implements ActionListener {

	private Customer customer;
	
	public DisplayButtonActionListner(Customer customer) {
		this.customer = customer;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, customer.toString(), "Customer Information",
			    JOptionPane.PLAIN_MESSAGE);
	}
	
}
