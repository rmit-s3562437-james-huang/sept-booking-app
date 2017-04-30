package abs.controller.owner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import abs.view.dialog.owner.AddEmpDialog;
import abs.view.gui.MainOwnerFrame;

public class AddEmpButtonActionListener implements ActionListener {

	public MainOwnerFrame mainOwnerFrame;
	
	public AddEmpButtonActionListener(MainOwnerFrame mainOwnerFrame) {
		this.mainOwnerFrame = mainOwnerFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new AddEmpDialog(mainOwnerFrame);
	}

}
