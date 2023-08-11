package com.bookkeeper;

import java.awt.*;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PatronLogInPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//object 
	private User user;
	public Object newUser;
	
	//panel
	private JPanel mainPanel;
	private JPanel headingPanel;
	private JPanel titlePanel;
	private JPanel inputPanel;
	private JPanel emailPanel;
	private JPanel passwordPanel;
	private JPanel buttonPanel;
	private JPanel subtitlePanel;
	
	//label
	private JLabel lblSubTitle;
	private JLabel lblTitle;
	private JLabel lblHeading;
	private JLabel lblEmailAddress;
	private JLabel lblPassword;
	
	//textfield
	private PlaceholderTextField txtEmailAddress;
	private PlaceholderPassword txtPassword;
	
	//icon
	private ImageIcon icon;
	private Image image;
	private Image scaledImage;
	private int iconHeight; 
	private int iconWidth;
	
	//button
	private JButton btnLogIn;
	private JButton btnBack;
	//layout
	private GridBagLayout gbl_mainPanel;
	private GridBagConstraints gbc_headingPanel;
	private GridBagConstraints gbc_titlePanel;
	private GridBagConstraints gbc_inputPanel;
	private GridBagConstraints gbc_subtitlePanel;
	private GridBagConstraints gbc_buttonPanel;

	
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
	private  Color middleplainColor = new Color(243, 243, 247);

	
	private GraphicsEnvironment environment;	
	private GraphicsDevice device;
	private int width;
	private int height;
	
public  PatronLogInPanel() {
	setBackground(new Color(250, 251, 255));
    setBorder(new EmptyBorder(10, 10, 10, 10));
    setLayout(new BorderLayout(0, 0));

    //create panels
    mainPanel = new JPanel();//panel to hold all panels
    headingPanel = new JPanel();
    titlePanel = new JPanel();
    inputPanel = new JPanel();
    emailPanel = new JPanel();
    passwordPanel = new JPanel();
    subtitlePanel = new JPanel();
    buttonPanel = new JPanel();
    
    // Set panel properties
    mainPanel.setBorder(null);
    passwordPanel.setBorder(new EmptyBorder(10, 0, 10, 0));
    titlePanel.setBorder(new EmptyBorder(50, 120, 0, 120));
    subtitlePanel.setBorder(new EmptyBorder(0, 120, 10, 120));
    inputPanel.setBorder(new EmptyBorder(20, 120, 0, 120));
    buttonPanel.setBorder(new EmptyBorder(25, 200, 25, 200));
    
    mainPanel.setOpaque(false);
    subtitlePanel.setOpaque(false);
    headingPanel.setOpaque(false);
    titlePanel.setOpaque(false);
    passwordPanel.setOpaque(false);
    inputPanel.setOpaque(false);
    emailPanel.setOpaque(false);
    buttonPanel.setOpaque(false);


    icon = new ImageIcon("img/Logo_Blue.png");
    image = icon.getImage();
    
    lblHeading = new JLabel();
    lblHeading.setIconTextGap(20);
    lblHeading.setFocusable(false);
    lblHeading.setForeground(headerColor);
    lblHeading.setText("Book Keeper");
    lblHeading.setHorizontalAlignment(SwingConstants.CENTER);

  
    btnBack = new JButton("Back");
    btnBack.setFocusPainted(false);
    btnBack.setForeground(new Color(23, 21, 147));
    btnBack.setBorderPainted(false);
    btnBack.setBorder(new EmptyBorder(5, 5, 5, 5));
    btnBack.setOpaque(false);

    lblTitle = new JLabel("PATRON LOGIN");
    lblTitle.setHorizontalAlignment(SwingConstants.LEFT);
    lblTitle.setBorder(null);
    lblTitle.setForeground(headerColor);
    
    lblSubTitle = new JLabel("Welcome back! Please log in to your account to continue.");
    lblSubTitle.setHorizontalAlignment(SwingConstants.LEFT);
    lblSubTitle.setBorder(null);
    lblSubTitle.setForeground(darkplainColor);

    
    lblEmailAddress = new JLabel("Email Address:");   
    lblEmailAddress.setForeground(darkplainColor);

    txtEmailAddress = new PlaceholderTextField("sample@email.com");
    txtEmailAddress.setBorder(new CompoundBorder(new LineBorder(null, 0, true), new EmptyBorder(10, 10, 10, 10)));
    txtEmailAddress.setBackground(new Color(243, 243, 247));
    
    lblPassword = new JLabel("Password:");
    lblPassword.setForeground(darkplainColor);

    txtPassword  = new PlaceholderPassword("password");
    txtPassword.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0), 0, true), new EmptyBorder(10, 10, 10, 10)));
    txtPassword.setBackground(middleplainColor);
    
    btnLogIn = new JButton("Log In");
    btnLogIn.setMnemonic(KeyEvent.VK_ENTER);
    btnLogIn.setForeground(lightplainColor);
    btnLogIn.setBorder(new EmptyBorder(10, 10, 10, 10));
    btnLogIn.setOpaque(true);
    btnLogIn.setFocusPainted(false);
    btnLogIn.setBorderPainted(false);
    btnLogIn.setBackground(headerColor);
    /*
     * gamit ka ng gridbag layout for more control sa placement ng components  sa panel
     * ung gbc or grid bag constraints is para madetermine mo ung positioning ng mga components sa gridbag layout
     * x = column
     * y = row
     * gridheight/gridwidth = no. of cells occupied
     * anchor = alignment
     * insets = padding
     */
    
    //gridbag layouts
    gbl_mainPanel = new GridBagLayout();
    gbl_mainPanel.columnWidths = new int[]{865, 0};
    gbl_mainPanel.rowHeights = new int[]{35, 203, 0, 0};
    gbl_mainPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
    gbl_mainPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0};
    
    
    gbc_headingPanel = new GridBagConstraints();
    gbc_headingPanel.anchor = GridBagConstraints.NORTH;
    gbc_headingPanel.fill = GridBagConstraints.HORIZONTAL;
    gbc_headingPanel.insets = new Insets(5, 5, 5, 0);
    gbc_headingPanel.gridx = 0;
    gbc_headingPanel.gridy = 0;
    
    
    gbc_titlePanel = new GridBagConstraints();
    gbc_titlePanel.insets = new Insets(0, 0, 5, 0);
    gbc_titlePanel.anchor = GridBagConstraints.SOUTHWEST;
    gbc_titlePanel.gridx = 0;
    gbc_titlePanel.gridy = 1;
    
    gbc_inputPanel = new GridBagConstraints();
    gbc_inputPanel.fill = GridBagConstraints.HORIZONTAL;
    gbc_inputPanel.anchor = GridBagConstraints.NORTH;
    gbc_inputPanel.gridx = 0;
    gbc_inputPanel.gridy = 3;

    gbc_subtitlePanel = new GridBagConstraints();
    gbc_subtitlePanel.insets = new Insets(0, 0, 5, 0);
    gbc_subtitlePanel.fill = GridBagConstraints.BOTH;
    gbc_subtitlePanel.gridx = 0;
    gbc_subtitlePanel.gridy = 2;

    gbc_buttonPanel = new GridBagConstraints();
    gbc_buttonPanel.insets = new Insets(0, 0, 5, 0);
    gbc_buttonPanel.fill = GridBagConstraints.BOTH;
    gbc_buttonPanel.gridx = 0;
    gbc_buttonPanel.gridy = 4;
    
    // Set panel layouts
    mainPanel.setLayout(gbl_mainPanel);
    headingPanel.setLayout(new BorderLayout(0,0));
    titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
    subtitlePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
    emailPanel.setLayout(new GridLayout(2, 1, 0, 0));
    passwordPanel.setLayout(new GridLayout(2, 1, 0, 0));
    inputPanel.setLayout(new GridLayout(3, 1, 5, 25));
    buttonPanel.setLayout(new BorderLayout(0, 0));

    //Add all to main panel
    headingPanel.add(lblHeading, BorderLayout.WEST);
    headingPanel.add(btnBack, BorderLayout.EAST);
    titlePanel.add(lblTitle);
    subtitlePanel.add(lblSubTitle);
    emailPanel.add(lblEmailAddress);
    emailPanel.add(txtEmailAddress);
    passwordPanel.add(lblPassword);
    passwordPanel.add(txtPassword);
    inputPanel.add(emailPanel);
    inputPanel.add(passwordPanel);
    inputPanel.add(buttonPanel);   
    buttonPanel.add(btnLogIn);  
    mainPanel.add(headingPanel, gbc_headingPanel);
    mainPanel.add(titlePanel, gbc_titlePanel);
    mainPanel.add(subtitlePanel, gbc_subtitlePanel);
    mainPanel.add(inputPanel, gbc_inputPanel);

    
    add(mainPanel);
    addComponentListener(new ComponentAdapter() {
  	  @Override
        public void componentResized(ComponentEvent e) {
	  		titleTextSize = Math.min(getHeight() / 7, getWidth()/ 10) ;
	        subtitleTextSize =  Math.min(getHeight() / 20, getWidth()/ 45);
	        buttonTextSize =  Math.min(getHeight() / 40, getWidth()/ 58);
	       	headerTextSize =   Math.min(getHeight() / 50, getWidth()/ 65);
	       	plainTextsize=   Math.min(getHeight() / 20, getWidth()/ 60);
        
	       	titleFont = new Font("Montserrat", Font.BOLD, titleTextSize);
	       	lblTitle.setFont(titleFont);
	            
	       	subtitleFont = new Font("Montserrat", Font.ITALIC, subtitleTextSize);
	       	lblSubTitle.setFont(subtitleFont);
	            
	       	buttonFont = new Font("Montserrat", Font.ITALIC, buttonTextSize);
	       	btnLogIn.setFont(buttonFont);
	            
	            headerFont = new Font("Montserrat", Font.PLAIN, headerTextSize);
	            btnBack.setFont(headerFont);
	            lblHeading.setFont(headerFont);
	            plainFont = new Font("Montserrat", Font.ITALIC | Font.BOLD, plainTextsize);
	            lblPassword.setFont(plainFont);
	            lblEmailAddress.setFont(plainFont);
        }
    });
    //Action Listeners
    btnLogIn.addActionListener(new ActionListener() {
		private int numTries = 1;
		public void actionPerformed(ActionEvent e) {
			int remain = 3 - numTries;
			MalfunctionPanel malfunction;
			
				try {
					
					String email = "";
					email = txtEmailAddress.getText();
					String trimed = email.trim();
					String table = "patron";
					String colemail = "patron_email";
					String colpass = "patron_password";
					String colStatus ="patron_status";
					char[] pass = txtPassword.getPassword();
					String password = new String(pass);
					String status = "Active";
					newUser = AuthenticationFrame.loginMethod(trimed, password, table, colemail, colpass, colStatus, status);
					if (newUser == null && numTries<=3) {
						// Shield
						if(numTries==3) {
							
							malfunction = new MalfunctionPanel("Limit Reached", "You have reached the limit for the number of login attempts.\nThe program will now close");
							showDialog(malfunction);
							System.exit(0);
						}
						
						// Show error message if login failed
						malfunction = new MalfunctionPanel("Failed to Log In!", 
								"Oops! It seems like an error occurred. Please check the \n"
								+ "information you provided and try again. Ensure that \n"
								+ "all fields are correctly filled. Only " + remain + " tries left.");
						showDialog(malfunction);
						numTries++;
						
					} else {
						
						// Cast newUser to User object
					    user = (User) newUser;
					    String title = "Log In Successful!";
					    String message = "Welcome Back, " + user.getUser_fname() + " " + user.getUser_lname() + "! Happy Browsing!";

					    // Prompt
					    SuccessPanel success = new SuccessPanel(title, message);
					    showDialog(success);
		            	
					    // Remove previous frame
		            	AuthenticationFrame frame = (AuthenticationFrame) SwingUtilities.getWindowAncestor(btnLogIn);
					    frame.dispose();
		            	
					    // Create and show the DashboardFrame
					    Setting set = retrieveSettingFromDatabase();
					    @SuppressWarnings("unused")
						DashboardFrame dashboardFrame = new DashboardFrame(user, set);
					   
					}
				} catch (Exception e1) {
					malfunction = new MalfunctionPanel("An Error Occurred!", 
							"Oops! It seems like an error occurred. Please try again.");
					showDialog(malfunction);
					e1.printStackTrace();
				}
			
		}
	});
	
}
	//Method to get Back button
	public JButton getBtnBack() {
		return btnBack;
	}
	public void clear() {
		txtEmailAddress.clearInputAndGetPlaceholder();
		txtPassword.clearInputAndGetPlaceholder();
	}
	
	// Method for GUI
	@Override
	 protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    /*
		    * use super.paintComponent(g) for proper rendering 
            * of the components 
		*/
	    iconWidth = (int) (getWidth() * 0.025);
	    iconHeight = (int) (getHeight() * 0.04);
	    scaledImage = image.getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH);
	    lblHeading.setIcon(new ImageIcon(scaledImage));

	 }
	
	// OVERLOADED METHOD -> showDialog()
	//Method to show alert panel (Success Panel)
	public void showDialog(SuccessPanel panel) {
		
		panel.getBtnConfirm().addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	            closeDialog(e);
	    	}
	    });
		environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
    	device = environment.getDefaultScreenDevice();
       	width = (int) (device.getDisplayMode().getWidth() * 0.4);    	
    	height = (int) (device.getDisplayMode().getHeight() * 0.23); 
    	
		JDialog dialog = new JDialog((Frame) SwingUtilities.getWindowAncestor(this), "Book Keeper", true);
		dialog.setUndecorated(true);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.getContentPane().add(panel);
		dialog.setSize(width, height);
		dialog.setLocationRelativeTo(null);
		dialog.setVisible(true);
	}
	
	//Method to show alert panel (Malfunction Panel)
    public void showDialog(MalfunctionPanel panel) {
		
		panel.getBtnConfirm().addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	            closeDialog(e);
	    	}
	    });
		environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
    	device = environment.getDefaultScreenDevice();
       	width = (int) (device.getDisplayMode().getWidth() * 0.4);    	
    	height = (int) (device.getDisplayMode().getHeight() * 0.23); 
    	
		JDialog dialog = new JDialog((Frame) SwingUtilities.getWindowAncestor(this), "Book Keeper", true);
		dialog.setUndecorated(true);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.getContentPane().add(panel);
		dialog.setSize(width, height);
		dialog.setLocationRelativeTo(null);
		dialog.setVisible(true);
	}
    
    //Method used by showDialog to close the JDialog containing the alert panels
	private void closeDialog(ActionEvent e) {
        Component component = (Component) e.getSource();
        Window window = SwingUtilities.getWindowAncestor(component);
        if (window != null) {
            window.dispose();
        }
    }
	public Setting retrieveSettingFromDatabase() {
        Setting setting = null;
        String DB_URL = "jdbc:mysql://localhost/book_keeper";
        String DB_USER = "root";
        String DB_PASSWORD = "";
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM setting");
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int setting_id = resultSet.getInt("setting_id");
                int borrow_limit = resultSet.getInt("borrow_limit");
                int reserve_limit = resultSet.getInt("reserve_limit");
                int borrow_duration = resultSet.getInt("borrow_duration");
                int penalty_limit = resultSet.getInt("penalty_limit");

                setting = new Setting(setting_id, borrow_limit, reserve_limit, borrow_duration, penalty_limit);
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately (e.g., log, throw, or return a default Setting object)
        }

        return setting;
    }
}