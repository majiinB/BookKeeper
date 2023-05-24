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

public class BookInfoFrame extends JFrame {
	
	private pnlBookInfoDisplayUser pnlBookInfoDisplayUser;
	private pnlBookInfoEditAdmin pnlBookInfoEditAdmin;
	private pnlBookInfoDisplayAdmin pnlBookInfoDisplayAdmin;
	private CardLayout cardLayout;
	
	public BookInfoFrame(int toKnow, Book book) {
	    setTitle("Book Keeper");
	    setSize(587, 690);
	    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    setLocationRelativeTo(null);

	    cardLayout = new CardLayout();
	    getContentPane().setLayout(cardLayout);

	    pnlBookInfoDisplayAdmin = new pnlBookInfoDisplayAdmin(book);
	    getContentPane().add(pnlBookInfoDisplayAdmin, "panel2");

	    pnlBookInfoEditAdmin = new pnlBookInfoEditAdmin();
	    getContentPane().add(pnlBookInfoEditAdmin, "panel3");

	    if (toKnow == 2) {
	        cardLayout.show(getContentPane(), "panel2");
	    }

	    // Event
	    if (pnlBookInfoEditAdmin != null) {
	        pnlBookInfoEditAdmin.getCancel().addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                BookInfoFrame frame_1 = (BookInfoFrame) SwingUtilities.getWindowAncestor(pnlBookInfoEditAdmin);
	                frame_1.dispose();
	            }
	        });
	    }

	    setVisible(true);
	}

	public BookInfoFrame(int toKnow) {
	    setTitle("Book Keeper");
	    setSize(587, 690);
	    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    setLocationRelativeTo(null);
		
		cardLayout = new CardLayout();
		getContentPane().setLayout(cardLayout);
		
		pnlBookInfoDisplayUser = new pnlBookInfoDisplayUser();
		getContentPane().add(pnlBookInfoDisplayUser, "panel1");
		
		pnlBookInfoEditAdmin = new pnlBookInfoEditAdmin();
		getContentPane().add(pnlBookInfoEditAdmin, "panel3");
		
		if (toKnow == 1) {
			cardLayout.show(getContentPane(), "panel3");
		} 
		else if(toKnow == 3){
			cardLayout.show(getContentPane(), "panel1");
		}
		//Event
		pnlBookInfoEditAdmin.getCancel().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookInfoFrame frame_1 = (BookInfoFrame) SwingUtilities.getWindowAncestor(pnlBookInfoEditAdmin);
	    		frame_1.dispose();
			}
		});
		setVisible(true);
	}
}
