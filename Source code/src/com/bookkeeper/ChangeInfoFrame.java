package com.bookkeeper;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Frame for user to modify user and system related settings

public class ChangeInfoFrame extends JDialog {
	//panel
	private JPanel mainPanel;
	private ChangeNamePanel ChangeNamePanel;
	private ChangePassPanel ChangePassPanel;
	private ChangeNumPanel ChangeNumPanel;
	private ChangeAddPanel ChangeAddPanel;
	private ChangeStatPanel ChangeStatPanel;
	private ChangeAccessPanel ChangeAccessPanel;
	//private ChangeBorowLimitPanel ChangeBorowLimitPanel;
	private ChangeReserveLimitPanel ChangeReserveLimitPanel;
	private ChangeOverduePenaltyPanel ChangeOverduePenaltyPanel;
	
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
	
    public ChangeInfoFrame(int show, User patron) {
    	setTitle("Book Keeper");
    	
    	// Set the Icon
    	icon = new ImageIcon("img/Logo_Original.png"); 
    	image = icon.getImage();
    	setIconImage(image);
    	
    	setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    	
    	// Remove window decorations (title bar, borders)
    	setUndecorated(false); 
    	
    	// Prevent resizing
    	setResizable(true); 

    	// Set the frame size based on the screen dimensions
    	environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
    	device = environment.getDefaultScreenDevice();
    	width = (int)(device.getDisplayMode().getWidth() * 0.238);    	
    	height = (int)(device.getDisplayMode().getHeight() * 0.5185 );    
    	setSize(width, height);
//        setSize(450, 560);

    	//print sizes( wala lng toh :> )
    	System.out.println("Device Width = " + device.getDisplayMode().getWidth());
    	System.out.println("Device Height = " + device.getDisplayMode().getHeight());
    	System.out.println("Frame Width = " + width);
    	System.out.println("Frame Height = " + height);
    	
        
        //Create panels
    	mainPanel = new JPanel();//panel to hold all panels
    	//ChangeNamePanel = new ChangeNamePanel(patron);
    	ChangePassPanel = new ChangePassPanel(patron);
    	ChangeNumPanel = new ChangeNumPanel(patron);
    	ChangeAddPanel = new ChangeAddPanel(patron);
//    	ChangeStatPanel = new ChangeStatPanel();
//    	ChangeAccessPanel = new ChangeAccessPanel();
//    	ChangeBorowLimitPanel = new ChangeBorowLimitPanel();
//    	ChangeReserveLimitPanel = new ChangeReserveLimitPanel();
//    	ChangeOverduePenaltyPanel = new ChangeOverduePenaltyPanel();

		// Set the layout of panels
		cardLayout = new CardLayout();
    	mainPanel.setLayout(cardLayout);

		// Add Panels to Main panel
    	mainPanel.add(ChangeNamePanel,"panel1");
		mainPanel.add(ChangePassPanel,"panel2");
		mainPanel.add(ChangeNumPanel,"panel3");
		mainPanel.add(ChangeAddPanel,"panel4");
//		mainPanel.add(ChangeStatPanel,"panel5");
//		mainPanel.add(ChangeAccessPanel,"panel6");
//		mainPanel.add(ChangeBorowLimitPanel,"panel7");
//		mainPanel.add(ChangeReserveLimitPanel,"panel8");
//		mainPanel.add(ChangeOverduePenaltyPanel,"panel9");
			
		
		
		// Set mainPanel as the content pane of the JFrame
		setContentPane(mainPanel);
		
		// Condition 
		if(show == 1) cardLayout.show(mainPanel, "panel1");
		else if(show == 2) cardLayout.show(mainPanel, "panel2");
		else if(show ==3) cardLayout.show(mainPanel, "panel3");
		else if(show == 4) cardLayout.show(mainPanel, "panel4");
	
		// Center the frame on the screen
		setLocationRelativeTo(null);
		
		// Make the frame visible
		setVisible(true);
		
		// Action Listeners
		ChangeNamePanel.getBtnBack().addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				ChangeInfoFrame frame = (ChangeInfoFrame) SwingUtilities.getWindowAncestor(ChangeNamePanel);
				frame.dispose();
        	}
        });
		ChangePassPanel.getBtnBack().addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				ChangeInfoFrame frame = (ChangeInfoFrame) SwingUtilities.getWindowAncestor(ChangePassPanel);
				frame.dispose();
        	}
        });
		ChangeNumPanel.getBtnBack().addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				ChangeInfoFrame frame = (ChangeInfoFrame) SwingUtilities.getWindowAncestor(ChangeNumPanel);
				frame.dispose();
        	}
        });
		ChangeAddPanel.getBtnBack().addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) { 
				ChangeInfoFrame frame = (ChangeInfoFrame) SwingUtilities.getWindowAncestor(ChangeAddPanel);
				frame.dispose();
        	}
        });
	}	
}
