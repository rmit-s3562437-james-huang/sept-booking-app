package abs.controller.owner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import abs.view.dialog.owner.MakeCustomerBookDialog;
import abs.view.gui.MainOwnerFrame;

public class MakeCustomerBookActionListener implements ActionListener {

	private MainOwnerFrame mainOwnerFrame;
	
	public MakeCustomerBookActionListener(MainOwnerFrame mainOwnerFrame) {
		this.mainOwnerFrame = mainOwnerFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new MakeCustomerBookDialog(mainOwnerFrame);
	}

}
