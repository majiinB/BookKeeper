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
	private pnlBookAddAdmin pnlBookAddAdmin;
	private pnlBookInfoDisplayAdmin pnlBookInfoDisplayAdmin;
	private CardLayout cardLayout;
	private pnlEditBookInfo editBook;
	private pnlBookBorrowAdmin pnlBorrow;
	
	/**
	 * @wbp.parser.constructor
	 */
	public BookInfoFrame(int toKnow, Book book) {
	    setTitle("Book Keeper");
	    setSize(590, 690);
	    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    setLocationRelativeTo(null);

	    cardLayout = new CardLayout();
	    getContentPane().setLayout(cardLayout);

	    pnlBookInfoDisplayAdmin = new pnlBookInfoDisplayAdmin(book);
	    getContentPane().add(pnlBookInfoDisplayAdmin, "panel2");

	    pnlBookAddAdmin = new pnlBookAddAdmin();
	    getContentPane().add(pnlBookAddAdmin, "panel3");
	    
	    editBook = new pnlEditBookInfo(book);
	    getContentPane().add( editBook, "panel4");
	    
	    pnlBorrow = new pnlBookBorrowAdmin(book);
	    getContentPane().add(pnlBorrow, "panel5");

	    if (toKnow == 2) {
	        cardLayout.show(getContentPane(), "panel2");
	    }

	    // Event
	    if (pnlBookAddAdmin != null) {
	        pnlBookAddAdmin.getCancel().addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                BookInfoFrame frame_1 = (BookInfoFrame) SwingUtilities.getWindowAncestor(pnlBookAddAdmin);
	                frame_1.dispose();
	            }
	        });
	   }
	        pnlBookInfoDisplayAdmin.getEditbtn().addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent e) {
	    			 cardLayout.show(getContentPane(), "panel4");
	    		}
	    	});
	        editBook.getCancelBtn().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					BookInfoFrame frame_1 = (BookInfoFrame) SwingUtilities.getWindowAncestor(pnlBookAddAdmin);
	                frame_1.dispose();
				}
			});
	        pnlBookInfoDisplayAdmin.getCancel().addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent e) {
	    			BookInfoFrame frame_1 = (BookInfoFrame) SwingUtilities.getWindowAncestor(pnlBookAddAdmin);
	                frame_1.dispose();
	    		}
	    	});
	        pnlBookInfoDisplayAdmin.getBorrowbtn().addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                cardLayout.show(getContentPane(), "panel5");
	            }
	        });
	        pnlBorrow.getCancelBorrow().addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	BookInfoFrame frame_1 = (BookInfoFrame) SwingUtilities.getWindowAncestor(pnlBookInfoDisplayAdmin);
	                frame_1.dispose();
	            }
	        });


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
		
		//Add panel that shows where you input book info
		pnlBookAddAdmin = new pnlBookAddAdmin();
		getContentPane().add(pnlBookAddAdmin, "panel3");
		
		//condition for initial show
		if (toKnow == 1) {
			cardLayout.show(getContentPane(), "panel3");
		} 
		else if(toKnow == 3){
			cardLayout.show(getContentPane(), "panel1");
		}
		//Event
		pnlBookAddAdmin.getCancel().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookInfoFrame frame_1 = (BookInfoFrame) SwingUtilities.getWindowAncestor(pnlBookAddAdmin);
	    		frame_1.dispose();
			}
		});
		
		setVisible(true);
	}
	
}
