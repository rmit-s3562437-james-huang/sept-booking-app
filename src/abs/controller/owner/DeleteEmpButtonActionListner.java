package abs.controller.owner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import abs.view.dialog.owner.DeleteEmpDialog;
import abs.view.gui.MainOwnerFrame;

public class DeleteEmpButtonActionListner implements ActionListener {

	private MainOwnerFrame mainOwnerFrame;
	
	public DeleteEmpButtonActionListner(MainOwnerFrame mainOwnerFrame) {
		this.mainOwnerFrame = mainOwnerFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new DeleteEmpDialog(mainOwnerFrame);
	}

}
