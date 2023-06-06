package com.bookkeeper;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;
import javax.swing.JComboBox;

public class UserInfoFrame extends JFrame {
	
	private pnlEditInfoUser pnlEditInfoUser;
	private pnlEditInfoPassword pnlEditInfoPassword;
	private CardLayout cardLayout;


	public UserInfoFrame(User user) {
	    setTitle("Book Keeper");
	    setSize(590, 690);
	    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    setLocationRelativeTo(null);
	    
	    cardLayout = new CardLayout();
	    getContentPane().setLayout(cardLayout);
	    pnlEditInfoUser = new pnlEditInfoUser(user);
	    pnlEditInfoPassword = new pnlEditInfoPassword(user);
	    
		getContentPane().add(pnlEditInfoUser, "panel1");
		getContentPane().add(pnlEditInfoPassword, "panel2");
		
		// Action Listeners
		pnlEditInfoUser.getEditPassbtn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(getContentPane(), "panel2");
			}
		});
		pnlEditInfoPassword.getCancelPass().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(getContentPane(), "panel1");
			}
		});
		pnlEditInfoUser.getCancelEdit().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserInfoFrame frame_1 = (UserInfoFrame) SwingUtilities.getWindowAncestor(pnlEditInfoUser);
                frame_1.dispose();
			}
		});
	    setVisible(true);

	}
	
}
