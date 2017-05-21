package abs.controller.owner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import abs.view.dialog.owner.AddAvailabilityDialog;
import abs.view.gui.MainOwnerFrame;

public class AddEmpAvailabilityButtonActionListener implements ActionListener {

	public MainOwnerFrame mainOwnerFrame;
	
	public AddEmpAvailabilityButtonActionListener(MainOwnerFrame mainOwnerFrame) {
		this.mainOwnerFrame = mainOwnerFrame;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		new AddAvailabilityDialog(mainOwnerFrame);
	}

}
