package com.bookkeeper;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Frame for displaying information about book or user

public class InfoDisplayFrame extends JFrame {
	//panel
	private JPanel mainPanel;
	private PatronBookInfoPanel PatronBookInfoPanel ;
	private AdminBookInfoPanel AdminBookInfoPanel;
	private AdminAddBookPanel AdminAddBookPanel;
	private AdminUpdateBookPanel AdminUpdateBookPanel;
	private AdminUserInfoPanel AdminUserInfoPanel;
	private AccountInfoPanel AccountInfoPanel;
	
	//layout
	private CardLayout cardLayout;
	
	//icon
	private ImageIcon icon;
	private Image image;
	
	//Graphics environment and screen dimensions
	private GraphicsEnvironment environment;	
	private GraphicsDevice device;
	private int width;
	private int height;
	
    public InfoDisplayFrame() {
    	setTitle("Book Keeper");
    	
    	// Set the Icon
    	icon = new ImageIcon("img/Logo_Original.png"); 
    	image = icon.getImage();
    	setIconImage(image);
    	
    	setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    	
    	// Remove window decorations (title bar, borders)
    	setUndecorated(true); 
    	
    	// Prevent resizing
    	setResizable(false); 

    	// Set the frame size based on the screen dimensions
    	environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
    	device = environment.getDefaultScreenDevice();
    	width = (int) (device.getDisplayMode().getWidth() * (2.1 / 4.0));    	
    	height = (int) (device.getDisplayMode().getHeight() * (3.0 / 4.1));  
    	setSize(width, height);

    	//print sizes( wala lng toh :> )
    	System.out.println("Device Width = " + device.getDisplayMode().getWidth());
    	System.out.println("Device Height = " + device.getDisplayMode().getHeight());
    	System.out.println("Frame Width = " + width);
    	System.out.println("Frame Height = " + height);
    	
        
        //Create panels
    	mainPanel = new JPanel();//panel to hold all panels
    	PatronBookInfoPanel = new PatronBookInfoPanel();//panel to display book information for patron 
    	AdminBookInfoPanel = new AdminBookInfoPanel();//panel to display book information for admin and employee
    	AdminAddBookPanel = new AdminAddBookPanel();
    	AdminUpdateBookPanel = new AdminUpdateBookPanel();
    	AdminUserInfoPanel = new AdminUserInfoPanel();
    	AccountInfoPanel = new AccountInfoPanel();
           

		// Set the layout of panels
		cardLayout = new CardLayout();
    	mainPanel.setLayout(cardLayout);

    	// Add all Panels to main panel
		mainPanel.add(PatronBookInfoPanel,"panel1");
		mainPanel.add(AdminBookInfoPanel,"panel2");
		mainPanel.add(AdminAddBookPanel,"panel3");
		mainPanel.add(AdminUpdateBookPanel,"panel4");
		mainPanel.add(AdminUserInfoPanel,"panel5");
		mainPanel.add(AccountInfoPanel,"panel6");
//		mainPanel.add();

		// Set mainPanel as the content pane of the JFrame
		setContentPane(mainPanel);
    	cardLayout.show(mainPanel, "panel2");

		
		// Center the frame on the screen
		setLocationRelativeTo(null);
		
		// Make the frame visible
		setVisible(true);
    }

}
