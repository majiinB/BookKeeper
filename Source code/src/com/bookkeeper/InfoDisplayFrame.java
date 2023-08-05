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
	private SystemInfoPanel SystemInfoPanel;

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
	
    public InfoDisplayFrame(Book selectedBook, int show, User patron) {
    	setTitle("Book Keeper");
    	
    	// Set the Icon
    	icon = new ImageIcon("img/Logo_Original.png"); 
    	image = icon.getImage();
    	setIconImage(image);
    	
//    	setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	
    	// Remove window decorations (title bar, borders)
    	setUndecorated(false); 
    	
    	// Prevent resizing
    	setResizable(true); 

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
    	PatronBookInfoPanel = new PatronBookInfoPanel(selectedBook, patron);//panel to display book information for patron 
    	AdminBookInfoPanel = new AdminBookInfoPanel(selectedBook);//panel to display book information for admin and employee
    	AdminAddBookPanel = new AdminAddBookPanel();
    	AdminUpdateBookPanel = new AdminUpdateBookPanel();

		// Set the layout of panels
		cardLayout = new CardLayout();
    	mainPanel.setLayout(cardLayout);

    	// Add all Panels to main panel
		mainPanel.add(PatronBookInfoPanel,"panel1");
		mainPanel.add(AdminBookInfoPanel,"panel2");
		mainPanel.add(AdminAddBookPanel,"panel3");
		mainPanel.add(AdminUpdateBookPanel,"panel4");
//		mainPanel.add();

		// Set mainPanel as the content pane of the JFrame
		setContentPane(mainPanel);
		
		// Set what will be shown base on a condition
		if(show == 1) cardLayout.show(mainPanel, "panel1");
		else if(show == 2) cardLayout.show(mainPanel, "panel2");
		else if(show == 3) cardLayout.show(mainPanel, "panel3");
		else if(show == 4) cardLayout.show(mainPanel, "panel4");
		
		// Center the frame on the screen
		setLocationRelativeTo(null);
		
		// Make the frame visible
		setVisible(true);
		
		// Action Listeners
		PatronBookInfoPanel.getBtnBack().addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		InfoDisplayFrame frame = (InfoDisplayFrame) SwingUtilities.getWindowAncestor(PatronBookInfoPanel);
				frame.dispose();
	    	}
	    });
    }
    public InfoDisplayFrame(int show, User patron) {
    	setTitle("Book Keeper");
    	
    	// Set the Icon
    	icon = new ImageIcon("img/Logo_Original.png"); 
    	image = icon.getImage();
    	setIconImage(image);
    	
//    	setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	
    	// Remove window decorations (title bar, borders)
    	setUndecorated(false); 
    	
    	// Prevent resizing
    	setResizable(true); 

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
    	AdminUserInfoPanel = new AdminUserInfoPanel();
    	AccountInfoPanel = new AccountInfoPanel(patron);
    	SystemInfoPanel = new SystemInfoPanel();

		// Set the layout of panels
		cardLayout = new CardLayout();
    	mainPanel.setLayout(cardLayout);

    	// Add all Panels to main panel
		mainPanel.add(AdminUserInfoPanel,"panel5");
		mainPanel.add(AccountInfoPanel,"panel6");
		mainPanel.add(SystemInfoPanel,"panel7");
//		mainPanel.add();

		// Set mainPanel as the content pane of the JFrame
		setContentPane(mainPanel);
		
		// Set what will be shown base on a condition
		if(show == 5) cardLayout.show(mainPanel, "panel5");
		else if(show == 6) cardLayout.show(mainPanel, "panel6");
		else if(show == 7) cardLayout.show(mainPanel, "panel7");
		
		// Center the frame on the screen
		setLocationRelativeTo(null);
		
		// Make the frame visible
		setVisible(true);
		
		// Action Listeners
		AccountInfoPanel.getBtnSave().addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		InfoDisplayFrame frame = (InfoDisplayFrame) SwingUtilities.getWindowAncestor(AccountInfoPanel);
				frame.dispose();
	    	}
	    });
    }

}