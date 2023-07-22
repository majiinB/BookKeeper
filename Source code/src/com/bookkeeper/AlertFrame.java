package com.bookkeeper;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Frame for alert notifications

public class AlertFrame extends JDialog {
	//panel
	private JPanel mainPanel;
	private SuccessPanel successPanel;
	private MalfunctionPanel MalfunctionPanel;
	private ConfirmationPanel ConfirmationPanel;

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
	private Timer timer;
	
    public AlertFrame() {
    	setTitle("Book Keeper");
    	
    	// Set the Icon
    	icon = new ImageIcon("img/Logo_Original.png"); 
    	image = icon.getImage();
    	setIconImage(image);
    	
    	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	
    	// Remove window decorations (title bar, borders)
    	setUndecorated(true); 
    	
    	// Prevent resizing
    	setResizable(false); 

    	// Set the frame size based on the screen dimensions
    	environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
    	device = environment.getDefaultScreenDevice();
    	width = (int) (device.getDisplayMode().getWidth() * 0.4);    	
    	height = (int) (device.getDisplayMode().getHeight() * 0.25);    
    	setSize(width, height);

    	//print sizes( wala lng toh :> )
    	System.out.println("Device Width = " + device.getDisplayMode().getWidth());
    	System.out.println("Device Height = " + device.getDisplayMode().getHeight());
    	System.out.println("Frame Width = " + width);
    	System.out.println("Frame Height = " + height);
    	
        
        //Create panels
        //mainPanel = new JPanel();//panel to hold all panels
        //SuccessPanel = new SuccessPanel(); 
        //MalfunctionPanel = new MalfunctionPanel();
        //ConfirmationPanel = new ConfirmationPanel();
        
    	// Set the layout of main panel to switch between the panels
    	cardLayout = new CardLayout();
    	mainPanel.setLayout(cardLayout);
        
    	// Add all Panels to main panel
    	mainPanel.add(successPanel, "panel1");
    	mainPanel.add(MalfunctionPanel, "panel2");
    	mainPanel.add(ConfirmationPanel, "panel3");
    	
    	// Set mainPanel as the content pane of the JFrame
    	setContentPane(mainPanel);
    	cardLayout.show(mainPanel, "panel2");

    	
    	// Center the frame on the screen
    	setLocationRelativeTo(null);

    	// Make the frame visible
    	setVisible(true);

    }
    public AlertFrame(JFrame owner,String title, String message) {
    	setTitle("Book Keeper");
    	
    	// Set the Icon
    	icon = new ImageIcon("img/Logo_Original.png"); 
    	image = icon.getImage();
    	setIconImage(image);
    	
    	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	
    	// Remove window decorations (title bar, borders)
    	setUndecorated(true); 
    	
    	// Prevent resizing
    	setResizable(false); 

    	// Set the frame size based on the screen dimensions
    	environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
    	device = environment.getDefaultScreenDevice();
    	width = (int) (device.getDisplayMode().getWidth() * 0.4);    	
    	height = (int) (device.getDisplayMode().getHeight() * 0.25);    
    	setSize(width, height);

    	//print sizes( wala lng toh :> )
    	System.out.println("Device Width = " + device.getDisplayMode().getWidth());
    	System.out.println("Device Height = " + device.getDisplayMode().getHeight());
    	System.out.println("Frame Width = " + width);
    	System.out.println("Frame Height = " + height);
    	
        
        //Create panels
        mainPanel = new JPanel();//panel to hold all panels
        successPanel = new SuccessPanel(title, message); 
        
    	// Set the layout of main panel to switch between the panels
    	cardLayout = new CardLayout();
    	mainPanel.setLayout(cardLayout);
        
    	// Add Success Panels to main panel
    	mainPanel.add(successPanel, "panel1");
    	
    	// Set mainPanel as the content pane of the JFrame
    	setContentPane(mainPanel);
    	cardLayout.show(mainPanel, "panel1");

    	// Center the frame on the screen
    	setLocationRelativeTo(null);

    	// Make the frame visible
    	setAlwaysOnTop(true);
    	setVisible(true);
    	
    	//Action Listeners
    	System.out.println("Adding ActionListener to Confirm button");
    	successPanel.getBtnConfirm().addActionListener(new ActionListener() {
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			dispose();
    			System.out.println("Button clicked");
    		}
    	});
	}

}
