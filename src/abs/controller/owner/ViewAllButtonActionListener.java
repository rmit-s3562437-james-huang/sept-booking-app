package abs.controller.owner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import abs.view.dialog.owner.ViewAllButtonDialog;
import abs.view.gui.MainOwnerFrame;

public class ViewAllButtonActionListener implements ActionListener {

	private MainOwnerFrame mainOwnerFrame;
	
	public ViewAllButtonActionListener(MainOwnerFrame mainOwnerFrame) {
		this.mainOwnerFrame = mainOwnerFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new ViewAllButtonDialog(mainOwnerFrame);
	}

}
