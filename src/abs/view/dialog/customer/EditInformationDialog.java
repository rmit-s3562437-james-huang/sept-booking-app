package abs.view.dialog.customer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import abs.view.AbsTest;
import abs.view.gui.MainCustomerFrame;

public class EditInformationDialog extends JDialog implements ActionListener {
	
	private JPanel buttonPanel;
	private JPanel dialogPanel;
	
	private JLabel nameLabel, addressLabel, phoneLabel;
	private JLabel badNameLabel, badAddressLabel, badPhoneLabel;
	private JTextField nameField, addressField, phoneField;
	
	private JButton okButton;
	private JButton cancelButton;
	
	private MainCustomerFrame mainCustomerFrame;

	public EditInformationDialog(MainCustomerFrame mainCustomerFrame) {
		
		this.mainCustomerFrame = mainCustomerFrame;
		
		setTitle("Edit Information");
		
		setIconImage(new ImageIcon(AbsTest.ICONPATH).getImage());
		
		setLayout(new BorderLayout());
		
		dialogPanel = new JPanel();
		dialogPanel.setLayout(new GridBagLayout());
		
		buttonPanel = new JPanel();
		
		nameLabel = new JLabel("Name: ");
		badNameLabel = new JLabel("  You name cannot be an empty string or contain numbers!");
		badNameLabel.setForeground(Color.RED);
		badNameLabel.setFont(new Font("Arial", Font.PLAIN, 9));
		badNameLabel.setVisible(false);
		
		addressLabel = new JLabel("Address: ");
		badAddressLabel = new JLabel("  Your address cannot be an empty string!");
		badAddressLabel.setForeground(Color.RED);
		badAddressLabel.setFont(new Font("Arial", Font.PLAIN, 9));
		badAddressLabel.setVisible(false);
		
		phoneLabel = new JLabel("Phone Number: ");
		badPhoneLabel = new JLabel("  Please enter a valid Australian phone number!");
		badPhoneLabel.setForeground(Color.RED);
		badPhoneLabel.setFont(new Font("Arial", Font.PLAIN, 9));
		badPhoneLabel.setVisible(false);
		
		nameField = new JTextField(20);
		addressField = new JTextField(20);
		phoneField = new JTextField(20);
		
		okButton = new JButton("OK");
		cancelButton = new JButton("Cancel");
		
		okButton.addActionListener(this);
		cancelButton.addActionListener(this);
		
		GridBagConstraints gbc = new GridBagConstraints();
		 
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		dialogPanel.add(nameLabel, gbc);
		
		gbc.gridx = 1;
	    gbc.gridy = 0;
		dialogPanel.add(nameField, gbc);
		
		gbc.gridx = 0;
	    gbc.gridy = 1;
		dialogPanel.add(new JPanel(), gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 1;
	    gbc.gridy = 1;
		dialogPanel.add(badNameLabel, gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
	    gbc.gridy = 2;
	    dialogPanel.add(addressLabel, gbc);
		
	    gbc.gridx = 1;
	    gbc.gridy = 2;
		dialogPanel.add(addressField, gbc);
		
		gbc.gridx = 0;
	    gbc.gridy = 3;
		dialogPanel.add(new JPanel(), gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 1;
	    gbc.gridy = 3;
		dialogPanel.add(badAddressLabel, gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
	    gbc.gridy = 4;
		dialogPanel.add(phoneLabel, gbc);
		
		gbc.gridx = 1;
	    gbc.gridy = 4;
		dialogPanel.add(phoneField, gbc);
		
		gbc.gridx = 0;
	    gbc.gridy = 5;
		dialogPanel.add(new JPanel(), gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 1;
	    gbc.gridy = 5;
		dialogPanel.add(badPhoneLabel, gbc);

		buttonPanel.add(okButton);
		buttonPanel.add(cancelButton);
		
		dialogPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
		
		add(dialogPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);

		setSize(400, 200);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(okButton)) {
			
			boolean legit = true;
			
			String name = nameField.getText();
			String address = addressField.getText();
			String phone = phoneField.getText();
			
			if(!mainCustomerFrame.getClientSystem().validName(name)) {
				badNameLabel.setVisible(true);
				legit = false;
			}
			else {
				badNameLabel.setVisible(false);
			}
			
			if(!mainCustomerFrame.getClientSystem().validAddress(address)) {
				badAddressLabel.setVisible(true);
				legit = false;
			}
			else {
				badAddressLabel.setVisible(false);
			}
			
			if(!mainCustomerFrame.getClientSystem().validPhoneNumber(phone)) {
				badAddressLabel.setVisible(true);
				legit = false;
			}
			else {
				badPhoneLabel.setVisible(false);
			}
			
			if(legit) {
				mainCustomerFrame.getCustomer().setName(name);
				mainCustomerFrame.getCustomer().setUserAddress(address);
				mainCustomerFrame.getCustomer().setUserPhoneNumber(phone);
				mainCustomerFrame.getFileOps().compileCustomerMapStrings(AbsTest.CUSTOMERWRITEFILEPATH, mainCustomerFrame.getAbsMaps().getCustomerMap());
				
				JOptionPane.showMessageDialog(null, "Youve successfully changed your details!\nName: " + name 
						+ "\nAddress: " + address + "\nPhone Number: " + phone);
				
				dispose();
			}
		}
		
		if(e.getSource().equals(cancelButton)) {
			dispose();
		}
		
	}
}
