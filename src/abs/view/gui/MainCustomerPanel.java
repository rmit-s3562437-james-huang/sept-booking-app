package abs.view.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

import abs.model.AbsMaps;
import abs.model.AbsClientSystemImpl;

public class MainCustomerPanel extends JPanel implements ActionListener {
		
	private JLabel dispdetLabel, passLabel, editLabel, disyBookLabel, disaBookLabel, bookTimeLabel, bookDentLabel, removeLabel, logOutLabel;

	private LoginFrame loginFrame;
	private AbsMaps absmaps;
	private MainCustomerFrame  maincustomerframe;
	private AbsClientSystemImpl absclientsystem;

	public MainCustomerPanel(MainCustomerFrame maincustomerframe) {
		
		this.maincustomerframe = maincustomerframe;
		this.absmaps = absmaps;
		this.loginFrame = loginFrame;
		
		setLayout(new GridLayout(10,2,5,5));
		setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));
		
		dispdetLabel = new JLabel("1. Display your details");
		passLabel = new JLabel("2. Change your password");
		editLabel = new JLabel("3. Edit your information");
		disyBookLabel = new JLabel("4. Display your bookings");
		disaBookLabel = new JLabel("5. Display all bookings");
		bookTimeLabel = new JLabel("6. Book by time");
		bookDentLabel = new JLabel("7. Book by dentist");
		removeLabel = new JLabel("8. Remove a booking");
		logOutLabel = new JLabel("9. Log Out");
		
		
		add(dispdetLabel);
		add(passLabel);
		add(editLabel);
		add(disyBookLabel);
		add(disaBookLabel);
		add(bookTimeLabel);
		add(bookTimeLabel);
		add(removeLabel);
		add(logOutLabel);
	}
	
	
	public void actionPerformed(ActionEvent e){
		
		if(e.getSource().equals(dispdetLabel)) {
			//new displayDetails();
			maincustomerframe.dispose();
		}
		
		if(e.getSource().equals(passLabel)) {
			//new changePass();
			maincustomerframe.dispose();
		}
		
		if(e.getSource().equals(editLabel)) {
			//new editInfo();
			maincustomerframe.dispose();
		}
		
		if(e.getSource().equals(disyBookLabel)) {
			//new displayYourBookings();
			maincustomerframe.dispose();
		}
		
		if(e.getSource().equals(disaBookLabel)) {
			//new displayAllBookings();
			maincustomerframe.dispose();
		}
		
		if(e.getSource().equals(bookTimeLabel)) {
			//new bookTime();
			maincustomerframe.dispose();
		}
		
		if(e.getSource().equals(bookDentLabel)) {
			//new bookDentist();
			maincustomerframe.dispose();
		}
		
		if(e.getSource().equals(removeLabel)) {
			//new removeBooking();
			maincustomerframe.dispose();
		}
		
		if(e.getSource().equals(logOutLabel)) {
			new LoginFrame(absmaps, absclientsystem);
			maincustomerframe.dispose();
		}
		
	}
}
