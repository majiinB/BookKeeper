package com.bookkeeper;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//DATING MAINFRAME

public class AuthenticationFrame extends JFrame  implements KeyListener{
	private JPanel mainPanel;
	private RoleSelectionPanel RoleSelectionPanel;
	private AdminLogInPanel AdminLogInPanel;
	private PatronLogInPanel PatronLogInPanel;
	private signUpPanel SignUpPanel;
	private StartUpPanel StartUpPanel;
	private CardLayout cardLayout;
	private ImageIcon icon;
	private Image image;
	
	public static void main(String[] args) {
		/*updateOverdueBooks();*/
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AuthenticationFrame frame = new AuthenticationFrame();					
				} catch (Exception e) {
					e.printStackTrace(); 
				}
			}
		});
	}
	
    public AuthenticationFrame() {
    	GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = environment.getDefaultScreenDevice();
        setTitle("Book Keeper");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
        //setSize(1352, 900);
        setUndecorated(true); // Remove window decorations (title bar, borders)
        setResizable(false); // Prevent resizing
        device.setFullScreenWindow(this); 
	    setVisible(true);
	    cardLayout = new CardLayout();
        getContentPane().setLayout(cardLayout);

        //Set the Icon
        icon = new ImageIcon("../img/Logo_Original.png");//LAGAY MO UNG PATH!!
        image = icon.getImage();
        setIconImage(image); 
        
        //Create panels
        mainPanel = new JPanel();
        
//        RoleSelectionPanel = new RoleSelectionPanel(); //panel to select whether you are a patron or a staff
//        AdminLogInPanel = new AdminLogInPanel(); //panel for admin to log in 
//        PatronLogInPanel = new PatronLogInPanel(); //panel for patron to log in 
//        SignUpPanel = new SignUpPanel(); //panel for admin to register a user
        StartUpPanel = new StartUpPanel(); //panel for admin to register a user
//        
        // set the layout of main panel to switch between the panels 
        mainPanel.setLayout(cardLayout);
//        
//        //Add all Panels to main panel
        mainPanel.add(StartUpPanel, "panel1");
//        mainPanel.add(RoleSelectionPanel, "panel2");
//        mainPanel.add(AdminLogInPanel, "panel3");
//        mainPanel.add(PatronLogInPanel,"panel4");
//        mainPanel.add(SignUpPanel, "panel5");
        
//        
        cardLayout = (CardLayout) mainPanel.getLayout();
        add(mainPanel, BorderLayout.CENTER);
        cardLayout.show(mainPanel, "panel5");   
    
        //Listener to exit the app upon pressing esc in keyboard
        // Add key listener to the frame
        addKeyListener(this);
        // Request focus for the JFrame to capture key events
        requestFocusInWindow();
    }
    // Implement KeyListener methods
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            // Close the application
            dispose();
            System.exit(0);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    //Methods 
}
