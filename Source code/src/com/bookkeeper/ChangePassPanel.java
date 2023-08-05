package com.bookkeeper;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ChangePassPanel extends JPanel{
	//panel
	private JPanel mainPanel;
	private JPanel headingPanel;
	private JPanel titlePanel;
	private JPanel inputPanel;
	private JPanel buttonPanel;
	

	//label
	private JLabel lblHeading;
	private JTextArea txtTitle;//title of panel "Book Information"
	private JTextArea txtDescription;

	private JLabel lblCurrentPass;	
	private JLabel lblNewPass;		
	private JLabel lblConfirmPass;



	//textfield
	private PlaceholderPassword txtCurrentPass;	
	private PlaceholderPassword txtNewPass;		
	private PlaceholderPassword txtConfirmPass;


	//button
	private JButton btnUpdate;
	private JButton btnCancel;

	//layout
	private GridBagLayout gbl_mainPanel; 
	private GridBagConstraints gbc_headingPanel;
	private GridBagConstraints gbc_titlePanel;
	private GridBagConstraints gbc_inputPanel;
	private GridBagConstraints gbc_buttonPanel;
	private GridBagLayout gbl_titlePanel; 
    private GridBagConstraints gbc_txtTitle;
    private GridBagConstraints gbc_txtDescription;

	private GridBagLayout gbl_inputPanel;
    private GridBagConstraints gbc_lblCurrentPass;
    private GridBagConstraints gbc_txtCurrentPass;
    private GridBagConstraints gbc_lblNewPass;
    private GridBagConstraints gbc_txtNewPass;
    private GridBagConstraints gbc_lblConfirmPass;
    private GridBagConstraints gbc_txtConfirmPass;
    
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
	private  Color headerColor = new Color(23, 21, 147);//blue
	private  Color darkplainColor = new Color(14, 14, 15);//black
	private  Color lightplainColor = new Color(250, 251, 255);//white
	private  Color middleplainColor = new Color(243, 243, 247);//dirty white

	public ChangePassPanel(User patron) {
		setBackground(new Color(250, 251, 255));
	    setBorder(new EmptyBorder(10, 10, 10, 10));
	    setLayout(new BorderLayout(0, 0));
		
	    //create panels
		mainPanel = new JPanel();//panel to hold all panels
	    headingPanel = new JPanel();
	    titlePanel = new JPanel();
	    inputPanel = new JPanel();
	    buttonPanel = new JPanel();

		// Set panel properties
	    mainPanel.setBorder(null);
	    mainPanel.setOpaque(false);
	    headingPanel.setOpaque(false);
	    titlePanel.setOpaque(false);
	    inputPanel.setOpaque(false);
	    buttonPanel.setOpaque(false);
	    

	    lblHeading = new JLabel();
	    lblHeading.setIconTextGap(20);
	    lblHeading.setFocusable(false);
	    lblHeading.setForeground(headerColor);
	    lblHeading.setText("User Details");
	    lblHeading.setHorizontalAlignment(SwingConstants.CENTER);
	  
	    btnCancel = new JButton("Cancel");
	    btnCancel.setFocusPainted(false);
	    btnCancel.setForeground(new Color(23, 21, 147));
	    btnCancel.setBorderPainted(false);
	    btnCancel.setBorder(new EmptyBorder(5, 5, 5, 5));
	    btnCancel.setOpaque(false);

	    txtTitle = new JTextArea();
	    txtTitle.setForeground(headerColor);
	    txtTitle.setLineWrap(true);
	    txtTitle.setOpaque(false);
	    txtTitle.setWrapStyleWord(true);
	    txtTitle.setFocusable(false);
	    txtTitle.setEditable(false);
	    txtTitle.setDragEnabled(false);
	    txtTitle.setAutoscrolls(false);
	    txtTitle.setText("Password");
	    
	    txtDescription = new JTextArea();
	    txtDescription.setForeground(darkplainColor);
		txtDescription.setLineWrap(true);
		txtDescription.setOpaque(false);
		txtDescription.setWrapStyleWord(true);
		txtDescription.setFocusable(false);
		txtDescription.setEditable(false);
		txtDescription.setDragEnabled(false);
		txtDescription.setAutoscrolls(false);
	    txtDescription.setText("In changing your password, please select a strong and unique password.");

	    
	    lblCurrentPass = new JLabel("Current Password");
	    lblCurrentPass.setBorder(new EmptyBorder(0, 0, 0, 0));
		
	    txtCurrentPass = new PlaceholderPassword("Password");
	    txtCurrentPass.setBackground(middleplainColor);
	    txtCurrentPass.setBorder(new EmptyBorder(10, 10, 10, 10));
	    txtCurrentPass.setOpaque(true);
	    txtCurrentPass.setFocusable(true);
	    txtCurrentPass.setEditable(true);
	    txtCurrentPass.setDragEnabled(false);
	    
	    lblNewPass = new JLabel("New Password");
	    lblNewPass.setHorizontalAlignment(SwingConstants.LEFT);
	    lblNewPass.setBorder(null);
	    lblNewPass.setForeground(darkplainColor);
	    
	    txtNewPass = new PlaceholderPassword("Password");
	    txtNewPass.setBackground(middleplainColor);
	    txtNewPass.setBorder(new EmptyBorder(10, 10, 10, 10));
	    txtNewPass.setOpaque(true);
	    txtNewPass.setFocusable(true);
	    txtNewPass.setEditable(true);
	    txtNewPass.setDragEnabled(false);
	    
	    lblConfirmPass = new JLabel("Re-type New Password");
	    lblConfirmPass.setHorizontalAlignment(SwingConstants.LEFT);
	    lblConfirmPass.setBorder(null);
	    lblConfirmPass.setForeground(darkplainColor);
	    
	    txtConfirmPass = new PlaceholderPassword("Password");
	    txtConfirmPass.setBackground(middleplainColor);
	    txtConfirmPass.setBorder(new EmptyBorder(10, 10, 10, 10));
	    txtConfirmPass.setOpaque(true);
	    txtConfirmPass.setFocusable(true);
	    txtConfirmPass.setEditable(true);
	    txtConfirmPass.setDragEnabled(false);
	    
	    btnUpdate = new JButton();
	    btnUpdate.setText("Update");
	    btnUpdate.setMnemonic(KeyEvent.VK_ENTER);
	    btnUpdate.setForeground(lightplainColor);
	    btnUpdate.setBorder(new EmptyBorder(10, 10, 10, 10));
	    btnUpdate.setOpaque(true);
	    btnUpdate.setFocusPainted(false);
	    btnUpdate.setBorderPainted(false);
	    btnUpdate.setBackground(headerColor);
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
	    gbl_mainPanel.columnWidths = new int[]{865};
	    gbl_mainPanel.rowHeights = new int[]{35, 0, 0, 0};
	    gbl_mainPanel.columnWeights = new double[]{1.0};
	    gbl_mainPanel.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0};
	    
	    gbc_headingPanel = new GridBagConstraints();
	    gbc_headingPanel.fill = GridBagConstraints.BOTH;	    
	    gbc_headingPanel.insets = new Insets(20, 20, 10, 20);
	    gbc_headingPanel.gridx = 0;
	    gbc_headingPanel.gridy = 0;
	    
	    gbc_titlePanel = new GridBagConstraints();
	    gbc_titlePanel.anchor = GridBagConstraints.SOUTH;
	    gbc_titlePanel.fill = GridBagConstraints.BOTH;	    
	    gbc_titlePanel.insets = new Insets(10, 20, 20, 20);
	    gbc_titlePanel.gridx = 0;
	    gbc_titlePanel.gridy = 1;
	    
	    gbc_inputPanel = new GridBagConstraints();
	    gbc_inputPanel.fill = GridBagConstraints.HORIZONTAL;	    
	    gbc_inputPanel.insets = new Insets(10, 20, 20, 20);
	    gbc_inputPanel.gridx = 0;
	    gbc_inputPanel.gridy = 2;	 
	    
	    gbc_buttonPanel = new GridBagConstraints();
	    gbc_buttonPanel.fill = GridBagConstraints.HORIZONTAL;	    
	    gbc_buttonPanel.anchor = GridBagConstraints.NORTH;
	    gbc_buttonPanel.insets = new Insets(20, 20, 20, 20);
	    gbc_buttonPanel.gridx = 0;
	    gbc_buttonPanel.gridy = 3;
	    
	    gbl_titlePanel = new GridBagLayout();
        gbl_titlePanel.columnWidths = new int[]{865};
        gbl_titlePanel.rowHeights = new int[]{35, 0};
        gbl_titlePanel.columnWeights = new double[]{1.0};
        gbl_titlePanel.rowWeights = new double[]{0.0, 1.0,};

        gbc_txtTitle = new GridBagConstraints();
        gbc_txtTitle.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtTitle.insets = new Insets(0, 0, 0, 0);
        gbc_txtTitle.gridx = 0;
        gbc_txtTitle.gridy = 0;

        gbc_txtDescription = new GridBagConstraints();
        gbc_txtDescription.fill = GridBagConstraints.BOTH;
        gbc_txtDescription.insets = new Insets(0, 0, 0, 0);
        gbc_txtDescription.gridx = 0;
        gbc_txtDescription.gridy = 1;
	    
	    gbl_inputPanel = new GridBagLayout();
        gbl_inputPanel.columnWidths = new int[]{865};
        gbl_inputPanel.rowHeights = new int[]{0, 0, 0, 0};
        gbl_inputPanel.columnWeights = new double[]{1.0};
        gbl_inputPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0,0.0};
        
//        CURRENT PASS
        gbc_lblCurrentPass = new GridBagConstraints();
        gbc_lblCurrentPass.fill = GridBagConstraints.BOTH;
        gbc_lblCurrentPass.insets = new Insets(0, 0, 0, 0);
        gbc_lblCurrentPass.gridx = 0;
        gbc_lblCurrentPass.gridy = 0;
        
        gbc_txtCurrentPass = new GridBagConstraints();
        gbc_txtCurrentPass.fill = GridBagConstraints.BOTH;
        gbc_txtCurrentPass.insets = new Insets(5, 0, 0, 0);
        gbc_txtCurrentPass.gridx = 0;
        gbc_txtCurrentPass.gridy = 1;
        
//        NEW PASS
        gbc_lblNewPass = new GridBagConstraints();
        gbc_lblNewPass.fill = GridBagConstraints.BOTH;
        gbc_lblNewPass.insets = new Insets(20, 0, 0, 0);
        gbc_lblNewPass.gridx = 0;
        gbc_lblNewPass.gridy = 2;
        
        gbc_txtNewPass = new GridBagConstraints();
        gbc_txtNewPass.fill = GridBagConstraints.BOTH;
        gbc_txtNewPass.insets = new Insets(5, 0, 0, 0);
        gbc_txtNewPass.gridx = 0;
        gbc_txtNewPass.gridy = 3;
        
//        CONFIRM PASS
        gbc_lblConfirmPass = new GridBagConstraints();
        gbc_lblConfirmPass.fill = GridBagConstraints.BOTH;
        gbc_lblConfirmPass.insets = new Insets(20, 0, 0, 0);
        gbc_lblConfirmPass.gridx = 0;
        gbc_lblConfirmPass.gridy = 4;
        
        gbc_txtConfirmPass = new GridBagConstraints();
        gbc_txtConfirmPass.fill = GridBagConstraints.BOTH;
        gbc_txtConfirmPass.insets = new Insets(5, 0, 0, 0);
        gbc_txtConfirmPass.gridx = 0;
        gbc_txtConfirmPass.gridy = 5;
	    
	    // Set panel layout
	    mainPanel.setLayout(gbl_mainPanel);
	    headingPanel.setLayout(new BorderLayout(0,0));
	    titlePanel.setLayout(gbl_titlePanel);
	    inputPanel.setLayout(gbl_inputPanel);
	    buttonPanel.setLayout(new BorderLayout(0, 0));

	    //Add all to main panel
	    headingPanel.add(lblHeading, BorderLayout.WEST);
	    headingPanel.add(btnCancel, BorderLayout.EAST);

	    titlePanel.add(txtTitle, gbc_txtTitle);
	    titlePanel.add(txtDescription, gbc_txtDescription);
//	    inputPanel.add(=);
	    inputPanel.add(lblCurrentPass, gbc_lblCurrentPass);
	    inputPanel.add(txtCurrentPass, gbc_txtCurrentPass);
	    inputPanel.add(lblNewPass, gbc_lblNewPass);
	    inputPanel.add(txtNewPass, gbc_txtNewPass);
	    inputPanel.add(lblConfirmPass, gbc_lblConfirmPass);
	    inputPanel.add(txtConfirmPass, gbc_txtConfirmPass);
	    
	    buttonPanel.add(btnUpdate);
	    mainPanel.add(headingPanel, gbc_headingPanel);
	    mainPanel.add(titlePanel, gbc_titlePanel);
	    mainPanel.add(inputPanel, gbc_inputPanel);
	    mainPanel.add(buttonPanel,gbc_buttonPanel);
	    
	    add(mainPanel);
	    
	    addComponentListener(new ComponentAdapter() {
	    @Override
	    public void componentResized(ComponentEvent e) {
	    	titleTextSize = Math.min(getHeight() / 7, getWidth()/ 10) ;
	    	subtitleTextSize =  Math.min(getHeight() / 20, getWidth()/ 25);
	    	buttonTextSize =  Math.min(getHeight() / 30, getWidth()/ 30);
	    	headerTextSize =   Math.min(getHeight() / 20, getWidth()/ 30);
	    	plainTextsize =   Math.min(getHeight() / 25, getWidth()/ 25);
	    	titleFont = new Font("Montserrat", Font.BOLD, titleTextSize);
	    	subtitleFont = new Font("Montserrat", Font.ITALIC, subtitleTextSize);
	    	buttonFont = new Font("Montserrat", Font.BOLD, buttonTextSize);
	    	headerFont = new Font("Montserrat", Font.PLAIN, headerTextSize);
	    	plainFont = new Font("Montserrat", Font.ITALIC | Font.BOLD, plainTextsize);
	    	
	    	txtTitle.setFont(titleFont);
	    	txtDescription.setFont(subtitleFont);
	    	btnUpdate.setFont(buttonFont);	  	            
	    	btnCancel.setFont(headerFont);
	    	lblHeading.setFont(headerFont);	  	            
	    	lblCurrentPass.setFont(plainFont);  	          
	    	lblNewPass.setFont(plainFont);  	 
	    	lblConfirmPass.setFont(plainFont);  	 
	          }
	      });
	 // Action listeners
	    btnUpdate.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	
	    	// DATABASE VARIABLES
	    	String DB_URL = "jdbc:mysql://localhost:3306/book_keeper";
	        String DB_USERNAME = "root";
	        String DB_PASSWORD = "";
	        
	        // PASSWORD
	        char[] currentPass = txtCurrentPass.getPassword();
	        char[] newPass = txtNewPass.getPassword();
	        char[] confirmPass = txtConfirmPass.getPassword();
	        
	        String CURRENTPASS = new String(currentPass);
	        String NEWPASS = new String(newPass).trim();
	        String CONFIRMPASS = new String(confirmPass).trim();
	        
			String EncryptedCurrent = null;
			String ENCRYPT_NEWPASS = null;
			
			String formattedID = patron.getUser_id();
	    	String patronPass = patron.getUser_pass();
	    	
	    	// Encrypt currentPass entered
			try {
				EncryptedCurrent = AuthenticationFrame.encryption(CURRENTPASS);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
	    	// Shield
	    	if (CURRENTPASS.isBlank() || CURRENTPASS.equals("Password") || NEWPASS.isBlank() || NEWPASS.equals("Password") ||
	    			CONFIRMPASS.isBlank() || CONFIRMPASS.equals("Password")) {
	    		MalfunctionPanel mal = new MalfunctionPanel("Info Change", "Cannot update with blank values");
	            showDialog(mal);
	    		return;
	    	}
	    	if (!EncryptedCurrent.equals(patronPass)) {
	    		MalfunctionPanel mal = new MalfunctionPanel("Info Change", "Wrong current password");
	            showDialog(mal);
	    		return;
	    	}
	    	if(!NEWPASS.equals(CONFIRMPASS)) {
	    		MalfunctionPanel mal = new MalfunctionPanel("Info Change", "Passwords did not match\nPlease try again");
	            showDialog(mal);
	    		return;
	    	}
	    
	    	// Encrypt new password
	    	try {
				ENCRYPT_NEWPASS = AuthenticationFrame.encryption(NEWPASS);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	
	    	// Execute update
	    	Connection conn = null;
	        PreparedStatement stmt = null;

	        try {
	            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
	            
	            //Prepare query
	            String sql = "UPDATE patron SET patron_password = ? WHERE formatted_id = ?";
	            
	            //Execute update
	            stmt = conn.prepareStatement(sql);
	            stmt.setString(1, ENCRYPT_NEWPASS);
	            stmt.setString(2, formattedID);
	            stmt.executeUpdate();
	            //Update Object
	            patron.setUser_pass(ENCRYPT_NEWPASS);
	            
	            //Prompt successful update
	            SuccessPanel success = new SuccessPanel("Info Change", "Password Change Successful");
	            showDialog(success);
	            
	            //Close Frame after update
	            ChangeInfoFrame frame = (ChangeInfoFrame) SwingUtilities.getWindowAncestor(btnUpdate);
				frame.dispose();
	        } catch (SQLException e1) {
	            e1.printStackTrace();
	        } finally {
	            try {
	                if (stmt != null) {
	                    stmt.close();
	                }
	                if (conn != null) {
	                    conn.close();
	                }
	            } catch (SQLException e2) {
	                e2.printStackTrace();
	            }
	        }
	    }
	 });
	}
	@Override
	 protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    /*
		    * use super.paintComponent(g) for proper rendering 
		    * of components 
		*/

	 }
	public JButton getBtnBack() {
		return btnCancel;
	}
	// OVERLOADED METHOD -> showDialog()
		//Method to show alert panel (Success Panel)
		public void showDialog(SuccessPanel panel) {
			
			panel.getBtnConfirm().addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		            closeDialog(e);
		    	}
		    });
		    
			JDialog dialog = new JDialog((Frame) SwingUtilities.getWindowAncestor(this), "Success", true);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.getContentPane().add(panel);
			dialog.pack();
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
		    
			JDialog dialog = new JDialog((Frame) SwingUtilities.getWindowAncestor(this),"Error", true);
	        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	        dialog.getContentPane().add(panel);
	        dialog.pack();
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
}