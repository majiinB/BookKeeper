package com.bookkeeper;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class choosePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	private JButton PatronButton;
	private JButton adminButton;
	
	public choosePanel() {
		setBackground(new Color(18, 57, 150));
		setBorder(new EmptyBorder(0, 0, 0, 0));

		setLayout(null);
		
		JLabel RoleLabel = new JLabel("Choose Role");
		RoleLabel.setFont(new Font("Verdana", Font.BOLD, 24));
		RoleLabel.setForeground(Color.WHITE);
		RoleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		RoleLabel.setBounds(208, 76, 374, 56);
		add(RoleLabel);
		
		PatronButton = new JButton("");
		
		PatronButton.setSelected(false);
		ImageIcon icon = new ImageIcon("D:\\documents\\Final_Project\\img\\patronIcon.png");
		Image image = icon.getImage();
		Image resizedImage = image.getScaledInstance(115, 100, Image.SCALE_SMOOTH);
		PatronButton.setIcon(new ImageIcon(resizedImage));
		PatronButton.setSelectedIcon(new ImageIcon(resizedImage));

		PatronButton.setBounds(208, 143, 161, 140);
		add(PatronButton);
		
		adminButton = new JButton("");
		adminButton.setSelected(false);
		ImageIcon icon1 = new ImageIcon("D:\\documents\\Final_Project\\img\\adminIcon.png");
		Image image1 = icon1.getImage();
		Image resizedImage1 = image1.getScaledInstance(105, 105, Image.SCALE_SMOOTH);
		adminButton.setIcon(new ImageIcon(resizedImage1));
		adminButton.setSelectedIcon(new ImageIcon(resizedImage1));
		adminButton.setBounds(421, 143, 161, 140);
		add(adminButton);
		
		JLabel patronLabel = new JLabel("Patron");
		patronLabel.setLabelFor(PatronButton);
		patronLabel.setHorizontalAlignment(SwingConstants.CENTER);
		patronLabel.setForeground(Color.WHITE);
		patronLabel.setFont(new Font("Verdana", Font.BOLD, 20));
		patronLabel.setBounds(208, 283, 161, 33);
		add(patronLabel);
		
		JLabel adminLabel = new JLabel("Admin");
		adminLabel.setLabelFor(adminButton);
		adminLabel.setHorizontalAlignment(SwingConstants.CENTER);
		adminLabel.setForeground(Color.WHITE);
		adminLabel.setFont(new Font("Verdana", Font.BOLD, 20));
		adminLabel.setBounds(421, 283, 161, 33);
		add(adminLabel);
		
	}
	public JButton getButtonPatron() {
		return PatronButton;
	}
	public JButton getButtonAdmin() {
		return adminButton;
	}
}
