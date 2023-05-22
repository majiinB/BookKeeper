package com.bookkeeper;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
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
		RoleLabel.setBounds(79, 52, 374, 56);
		add(RoleLabel);
		
		PatronButton = new JButton("");
		ImageIcon originalIcon = new ImageIcon("D:\\documents\\Final_Project\\img\\patronIcon.png");
		Image originalImage = originalIcon.getImage();
		Image resizedImage = originalImage.getScaledInstance(115, 100, Image.SCALE_SMOOTH);
		ImageIcon resizedIcon = new ImageIcon(resizedImage);
		PatronButton.setIcon(resizedIcon);

		PatronButton.setSelected(false);
		PatronButton.setOpaque(false);
		PatronButton.setContentAreaFilled(false);
		PatronButton.setBorderPainted(false);
		PatronButton.setBounds(79, 119, 161, 140);
		add(PatronButton);
		
		adminButton = new JButton("");
		ImageIcon originalIcon2 = new ImageIcon("D:\\documents\\Final_Project\\img\\adminIcon.png");
		Image originalImage2 = originalIcon2.getImage();
		Image resizedImage2 = originalImage2.getScaledInstance(105, 105, Image.SCALE_SMOOTH);
		ImageIcon resizedIcon2 = new ImageIcon(resizedImage2);
		adminButton.setIcon(resizedIcon2);

		
		adminButton.setSelected(false);
		adminButton.setOpaque(false);
		adminButton.setContentAreaFilled(false);
		adminButton.setBorderPainted(false);
		adminButton.setBounds(292, 119, 161, 140);
		add(adminButton);
		
		JLabel patronLabel = new JLabel("Patron");
		patronLabel.setLabelFor(PatronButton);
		patronLabel.setHorizontalAlignment(SwingConstants.CENTER);
		patronLabel.setForeground(Color.WHITE);
		patronLabel.setFont(new Font("Verdana", Font.BOLD, 20));
		patronLabel.setBounds(79, 259, 161, 33);
		add(patronLabel);
		
		JLabel adminLabel = new JLabel("Admin");
		adminLabel.setLabelFor(adminButton);
		adminLabel.setHorizontalAlignment(SwingConstants.CENTER);
		adminLabel.setForeground(Color.WHITE);
		adminLabel.setFont(new Font("Verdana", Font.BOLD, 20));
		adminLabel.setBounds(292, 259, 161, 33);
		add(adminLabel);
		
 }
	public JButton getButtonPatron() {
		return PatronButton;
	}
	public JButton getButtonAdmin() {
		return adminButton;
	}
}