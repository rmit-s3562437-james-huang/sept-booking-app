package abs.view.dialog;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import abs.model.users.Customer;
import abs.view.AbsTest;
import abs.view.gui.MainCustomerFrame;

public class ChangePasswordDialog extends JDialog implements ActionListener {
	
	private JPanel panel;
	
	private JLabel enterPass1;
	private JLabel enterPass2;
	
	private JPasswordField passField1;
	private JPasswordField passField2;
	
	private JButton okButton;
	private JButton cancelButton;
	private MainCustomerFrame mainFrame;
	
	public ChangePasswordDialog(MainCustomerFrame mainFrame) {
		setTitle("Change Password");
		this.mainFrame = mainFrame;
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(3,2,5,5));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
		
		enterPass1 = new JLabel("Enter new password: ");
		passField1 = new JPasswordField();
		enterPass2 = new JLabel("Re-enter password: ");
		passField2 = new JPasswordField();
		
		okButton = new JButton("OK");
		okButton.addActionListener(this);
		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(this);
		
		panel.add(enterPass1);
		panel.add(passField1);
		panel.add(enterPass2);
		panel.add(passField2);
		panel.add(okButton);
		panel.add(cancelButton);
		
		add(panel);
		setSize(400, 150);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(cancelButton)) {
			dispose();
		}
		/* deprecation is warned because of not 
		 * calling getPassword() which returns chars
		 * our setMethod uses Strings
		 */
		if (e.getSource().equals(okButton)) {
			if (passField1.getText().equals(passField2.getText())) {
				if(passField2.getText().length() > 5) {
					mainFrame.getCustomer().setUserPassword(passField2.getText());
					mainFrame.getFileOps().compileCustomerMapStrings(AbsTest.CUSTOMERWRITEFILEPATH, 
							mainFrame.getAbsMaps().getCustomerMap());
					System.out.println(mainFrame.getCustomer().getUserPassword());
					
					JOptionPane.showMessageDialog(this, "Password changed");
					dispose();
				} else {
					JOptionPane.showMessageDialog(this, "Passwords must be greater than 5 characters",
							"Invalid Passwords", JOptionPane.WARNING_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(this, "Passwords do not match, please try again",
						"Invalid Passwords", JOptionPane.WARNING_MESSAGE);
			}
		}
	}
}
