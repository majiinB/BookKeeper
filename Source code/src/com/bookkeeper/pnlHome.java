package com.bookkeeper;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class pnlHome extends JPanel {
	private JTextField txtSearchBar;
	
	public pnlHome() {
		setLayout(null);
		//logo
		JLabel lblLogo = new JLabel(" ");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setBounds(85, 52, 678, 322);
		add(lblLogo);
		ImageIcon icnLogo = new ImageIcon("D:\\documents\\Final_Project\\img\\bookKeeperLogo.png");//files are in desktop
		Image imgLogos = icnLogo.getImage();
		Image rsdImgLogo = imgLogos.getScaledInstance(320, 320, Image.SCALE_SMOOTH);
		lblLogo.setIcon(new ImageIcon(rsdImgLogo));
		
		
		JLabel lblBookKeeper = new JLabel("Book Keeper");
		lblBookKeeper.setOpaque(true);
		lblBookKeeper.setHorizontalTextPosition(SwingConstants.CENTER);
		lblBookKeeper.setHorizontalAlignment(SwingConstants.CENTER);
		lblBookKeeper.setForeground(new Color(232, 246, 239));
		lblBookKeeper.setBorder(new LineBorder(new Color(26, 24, 87), 1, true));
		lblBookKeeper.setBackground(new Color(26, 24, 87));
		lblBookKeeper.setBounds(85, 396, 125, 38);
		add(lblBookKeeper);
		

		txtSearchBar = new JTextField();
		txtSearchBar.setColumns(10);
		txtSearchBar.setBorder(new LineBorder(new Color(26, 24, 87), 1, true));
		txtSearchBar.setBackground(Color.WHITE);
		txtSearchBar.setBounds(222, 396, 501, 38);
		add(txtSearchBar);
		
		JPanel pnlSearchBtn = new JPanel();
		pnlSearchBtn.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlSearchBtn.setBackground(Color.WHITE);
		pnlSearchBtn.setBounds(722, 396, 41, 38);
		add(pnlSearchBtn);
		
		JButton btnSearch = new JButton("");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//redirect to library panel of user
			}
		});
		btnSearch.setOpaque(false);
		btnSearch.setContentAreaFilled(false);
		btnSearch.setBorderPainted(false);
        ImageIcon icnSearch = new ImageIcon("D:\\documents\\Final_Project\\img\\searchIcon.png");
        Image imgSearch = icnSearch.getImage();
        Image rsdImgSearch = imgSearch.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        btnSearch.setIcon(new ImageIcon(rsdImgSearch));
		pnlSearchBtn.add(btnSearch);
		

}
}

