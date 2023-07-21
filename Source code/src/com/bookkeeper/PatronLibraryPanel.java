package com.bookkeeper;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class PatronLibraryPanel extends JPanel {
	//panel
	private JPanel mainPanel;
	private BackgroundPanel triangleBackground;

	//label
	private JLabel lblMenuTitle;
	//textfield
	private PlaceholderTextField txtSearchBar;
	//icon
	private ImageIcon searchIcon;
	private Image searchImage;

	//button
	private JButton btnSearch;
	//layout

	//text
	private  Font titleFont;
	private  Font subtitleFont;
	private  Font buttonFont;
	private  Font headerFont;
	private  Font plainFont;
	
	private  int buttonTextSize;
	private  int titleTextSize;
	private  int subtitleTextSize;
	private  int headerTextSize;
	private  int plainTextsize;
	private  Color headerColor = new Color(23, 21, 147);
	private  Color darkplainColor = new Color(14, 14, 15);
	private  Color lightplainColor = new Color(250, 251, 255);
 public PatronLibraryPanel() {
	setBackground(new Color(250, 251, 255));
	setBorder(new EmptyBorder(10, 10, 10, 10));
	setLayout(new BorderLayout(0, 0));
	 
	//create panels
	mainPanel = new JPanel();
	 triangleBackground = new BackgroundPanel();
	 
	 JComboBox comboBox = new JComboBox();
	 add(comboBox, BorderLayout.NORTH);
	 
	 
	 mainPanel.add(triangleBackground);
	 add(mainPanel);
 }
	
public class BackgroundPanel extends JPanel {
	//background
	private Image backgroundImage;
	
	
	public BackgroundPanel() {
		backgroundImage = new ImageIcon("img/DashboardFrame/Triangles_Library.png").getImage();
	}
	
//put image over panel
	 @Override
	 protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    /*
	    * use super.paintComponent(g) for proper rendering 
	    * ng mga components sa taas ng bg image 
	    * ng d nasisira ni custom drawing 
	    */
	    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this); 
	    /* dis ^^ da custom drawing, s-start nya ilagay si bg from coordinate 0,0 
	    * hanggang sa ma-cover nya  buong panel
	    */
	 }
	    
}  
}
