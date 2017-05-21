package abs.view.dialog.owner;

import javax.swing.JDialog;

import abs.view.gui.MainOwnerFrame;

public class AddAvailabilityDialog extends JDialog {

	private static final int WINDOW_WIDTH = 400;
	private static final int WINDOW_HEIGHT = 278;
	
	private MainOwnerFrame mainOwnerFrame;
	
	public AddAvailabilityDialog(MainOwnerFrame mainOwnerFrame) {
		setTitle("Add Employee Availabilities");
	}

}
