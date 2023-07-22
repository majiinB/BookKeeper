package com.bookkeeper;

import java.awt.*;

import javax.swing.border.EmptyBorder;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;


public class AdminLogInPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//object 
	private Employee employee;
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

	
public  AdminLogInPanel() {
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
    
    lblTitle = new JLabel("ADMIN LOGIN");
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
					String table = "admin";
					String colemail = "admin_email";
					String colpass = "admin_password";
					String colStatus ="admin_status";
					char[] pass = txtPassword.getPassword();
					String password = new String(pass);
					String status = "active";
					newUser = AuthenticationFrame.loginMethod(trimed, password, table, colemail, colpass, colStatus, status);
					if (newUser == null && numTries<=3) {
						// Shield
						if(numTries==3) {
							
							malfunction = new MalfunctionPanel("Limit Reached", "You have reached the limit for the number of login attempts.\nThe program will now close");
							JOptionPane.showOptionDialog(AdminLogInPanel.this, malfunction, "Error",
			                        JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE,
			                        null, new Object[]{"ok"}, null);
							System.exit(0);
						}
						
						// Show error message if login failed
						malfunction = new MalfunctionPanel("Login Error", "Invalid email or password\n"+"Remaining Attempts:" + remain);
						JOptionPane.showOptionDialog(AdminLogInPanel.this, malfunction, "Error",
		                        JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE,
		                        null, new Object[]{"ok"}, null);
						numTries++;
						
					} else {
						// Hide the login panel and show the main interface
						employee = (Employee) newUser;
						String title = "Login Success!";
					    String message = "Welcome " + employee.getFname() + " " + employee.getLname();

					    // Prompt
					    SuccessPanel success = new SuccessPanel(title, message);
					    JOptionPane.showOptionDialog(AdminLogInPanel.this, success, "Success",
		                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
		                        null, new Object[]{"Enter"}, null);
		            	
					    // Remove previous frame
		            	AuthenticationFrame frame = (AuthenticationFrame) SwingUtilities.getWindowAncestor(btnLogIn);
					    frame.dispose();
		            	
					    // Create and show the DashboardFrame
					    @SuppressWarnings("unused")
						DashboardFrame dashboardFrame = new DashboardFrame(employee);
		                
					}
				} catch (Exception e1) {
					malfunction = new MalfunctionPanel("Login Error", "An unknown error has occured!");
					JOptionPane.showOptionDialog(AdminLogInPanel.this, malfunction, "Error",
	                        JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE,
	                        null, new Object[]{"ok"}, null);
					e1.printStackTrace();
				}
			
		}
	});
	
	
}
	public JButton getBtnBack() {
		return btnBack;
	}
	public void clear() {
		txtEmailAddress.clearInputAndGetPlaceholder();
		txtPassword.clearInputAndGetPlaceholder();
	}
	@Override
	 protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    /*
		    * use super.paintComponent(g) for proper rendering 
		    * of components 
		*/
	    iconWidth = (int) (getWidth() * 0.025);
	    iconHeight = (int) (getHeight() * 0.04);
	    scaledImage = image.getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH);
	    lblHeading.setIcon(new ImageIcon(scaledImage));

	 }
}