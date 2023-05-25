package com.bookkeeper;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;

public class choosePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	private JButton btnPatron;
	private JButton btnAdmin;
	private JLabel lblWelcome;
	private JLabel lblRole;
	private JPanel pnlPatron;
	private JPanel pnlAdmin;
	private JPanel pnlHeader;
	private JPanel pnlChooseButtons;
	
	public choosePanel() {
		setBackground(new Color(26, 25, 87));
        setBorder(new EmptyBorder(0, 0, 0, 0));
        setLayout(new FlowLayout(FlowLayout.CENTER, 30, 30));
        
        // Create panels of frame
        pnlPatron = new JPanel();
        pnlAdmin = new JPanel();
        pnlAdmin.setBackground(new Color(26, 25, 87));
        pnlHeader = new JPanel();
        pnlChooseButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 10));

        
        //Header Panel
        lblWelcome = new JLabel("Welcome to Book Keeper");
        lblWelcome.setFont(new Font("Verdana", Font.BOLD, 45));
        lblWelcome.setForeground(Color.WHITE);
        lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
        
        lblRole = new JLabel("Choose Role");
	        lblRole.setFont(new Font("Verdana", Font.BOLD, 20));
	        lblRole.setForeground(Color.WHITE);
	        lblRole.setHorizontalAlignment(SwingConstants.CENTER);
		
		//Patron Panel
		btnPatron = new JButton("");
			btnPatron.setSelected(false);
			ImageIcon icon = new ImageIcon("D:\\documents\\Final_Project\\img\\patronIcon.png");//files are in desktop
			Image image = icon.getImage();
			Image resizedImage = image.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
			btnPatron.setIcon(new ImageIcon(resizedImage));
			btnPatron.setSelectedIcon(new ImageIcon(resizedImage));
			btnPatron.setBounds(208, 143, 161, 140);
			btnPatron.setContentAreaFilled(false);
			btnPatron.setOpaque(false);
			btnPatron.setBorderPainted(false);
			btnPatron.setFocusPainted(false);


		
	    //Admin Panel
		btnAdmin = new JButton("");
		btnAdmin.setBackground(new Color(0, 0, 160));
		btnAdmin.setOpaque(false);
			btnAdmin.setSelected(false);
			ImageIcon icon1 = new ImageIcon("D:\\documents\\Final_Project\\img\\AdminIcon.png"); //files are in desktop
			Image image1 = icon1.getImage();
			Image resizedImage1 = image1.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
			btnAdmin.setIcon(new ImageIcon(resizedImage1));
			btnAdmin.setSelectedIcon(new ImageIcon(resizedImage1));
			btnAdmin.setBorderPainted(false);
			btnAdmin.setFocusPainted(false);
	        
	        

		 
		 
 	     pnlChooseButtons.setOpaque(false);
	     pnlPatron.setOpaque(false);
	     pnlHeader.setOpaque(false);
	     
	     pnlHeader.setLayout(new GridLayout(0, 1, 0, 0));
	     pnlPatron.setLayout(new BoxLayout(pnlPatron, BoxLayout.Y_AXIS));
	     pnlAdmin.setLayout(new BoxLayout(pnlAdmin, BoxLayout.Y_AXIS));


	     //add components to panels
		 pnlPatron.add(btnPatron);
		 pnlAdmin.add(btnAdmin);
	     pnlHeader.add(lblWelcome);
	     pnlHeader.add(lblRole);
	     pnlChooseButtons.add(pnlPatron);
	     pnlChooseButtons.add(pnlAdmin);
	        

	     //add panels to frame
	     add(pnlHeader);
	     add(pnlChooseButtons);
		
 }
	public JButton getButtonPatron() {
		return btnPatron;
	}
	public JButton getButtonAdmin() {
		return btnAdmin;
	}
}