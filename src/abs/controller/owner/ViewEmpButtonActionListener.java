package abs.controller.owner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import abs.view.dialog.owner.ViewEmpDialog;
import abs.view.gui.MainOwnerFrame;

public class ViewEmpButtonActionListener implements ActionListener {

	private MainOwnerFrame mainOwnerFrame;
	
	public ViewEmpButtonActionListener(MainOwnerFrame mainOwnerFrame) {
		this.mainOwnerFrame = mainOwnerFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new ViewEmpDialog(mainOwnerFrame);
	}

}
