package com.bookkeeper;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChangeNamePanel extends JPanel{
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

	private JLabel lblFirstName;
	private JLabel lblLastName;
	
	
	//textfield
	private PlaceholderTextField txtFirstName;
	private PlaceholderTextField txtLastName;


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
    private GridBagConstraints gbc_lblFirstName;
    private GridBagConstraints gbc_txtFirstName;
    private GridBagConstraints gbc_lblLastName;
    private GridBagConstraints gbc_txtLastName;

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

	public ChangeNamePanel(User patron) {
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
	    txtTitle.setText("Name");
	    
	    txtDescription = new JTextArea();
	    txtDescription.setForeground(darkplainColor);
		txtDescription.setLineWrap(true);
		txtDescription.setOpaque(false);
		txtDescription.setWrapStyleWord(true);
		txtDescription.setFocusable(false);
		txtDescription.setEditable(false);
		txtDescription.setDragEnabled(false);
		txtDescription.setAutoscrolls(false);
	    txtDescription.setText("In changing you name, please ensure your name follows standard formatting. Avoid using unusual capitalization, punctuation, characters, or random words in your name.");

	    
	    lblFirstName = new JLabel("First Name");
	    lblFirstName.setHorizontalAlignment(SwingConstants.LEFT);
	    lblFirstName.setBorder(null);
	    lblFirstName.setForeground(darkplainColor);	
	    
	    txtFirstName = new PlaceholderTextField("Enter First Name");
	    txtFirstName.setBackground(middleplainColor);
	    txtFirstName.setBorder(new EmptyBorder(10, 10, 10, 10));
	    txtFirstName.setOpaque(true);
	    txtFirstName.setFocusable(true);
	    txtFirstName.setEditable(true);
	    txtFirstName.setDragEnabled(false);
	    
	    lblLastName = new JLabel("Last Name");
	    lblLastName.setHorizontalAlignment(SwingConstants.LEFT);
	    lblLastName.setBorder(null);
	    lblLastName.setForeground(darkplainColor);
	    
	    txtLastName = new PlaceholderTextField("Enter Last Name");
	    txtLastName.setBackground(middleplainColor);
	    txtLastName.setBorder(new EmptyBorder(10, 10, 10, 10));
	    txtLastName.setOpaque(true);
	    txtLastName.setFocusable(true);
	    txtLastName.setEditable(true);
	    txtLastName.setDragEnabled(false);
	    
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
        gbl_inputPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
        
//        FIRST NAME
        gbc_lblFirstName = new GridBagConstraints();
        gbc_lblFirstName.fill = GridBagConstraints.BOTH;
        gbc_lblFirstName.insets = new Insets(0, 0, 0, 0);
        gbc_lblFirstName.gridx = 0;
        gbc_lblFirstName.gridy = 0;
        
        gbc_txtFirstName = new GridBagConstraints();
        gbc_txtFirstName.fill = GridBagConstraints.BOTH;
        gbc_txtFirstName.insets = new Insets(5, 0, 0, 0);
        gbc_txtFirstName.gridx = 0;
        gbc_txtFirstName.gridy = 1;
        
//        LAST NAME
        gbc_lblLastName = new GridBagConstraints();
        gbc_lblLastName.fill = GridBagConstraints.BOTH;
        gbc_lblLastName.insets = new Insets(20, 0, 0, 0);
        gbc_lblLastName.gridx = 0;
        gbc_lblLastName.gridy = 2;
        
        gbc_txtLastName = new GridBagConstraints();
        gbc_txtLastName.fill = GridBagConstraints.BOTH;
        gbc_txtLastName.insets = new Insets(5, 0, 0, 0);
        gbc_txtLastName.gridx = 0;
        gbc_txtLastName.gridy = 3;
	    
	    // Set panel layout
	    mainPanel.setLayout(gbl_mainPanel);
	    headingPanel.setLayout(new BorderLayout(0, 0));
	    titlePanel.setLayout(gbl_titlePanel);
	    inputPanel.setLayout(gbl_inputPanel);
	    buttonPanel.setLayout(new BorderLayout(0, 0));
	    
	    //Add all to main panel
	    headingPanel.add(lblHeading, BorderLayout.WEST);
	    headingPanel.add(btnCancel, BorderLayout.EAST);

	    titlePanel.add(txtTitle, gbc_txtTitle);
	    titlePanel.add(txtDescription, gbc_txtDescription);
//	    inputPanel.add(=);
	    inputPanel.add(lblFirstName, gbc_lblFirstName);
	    inputPanel.add(txtFirstName, gbc_txtFirstName);
	    inputPanel.add(lblLastName, gbc_lblLastName);
	    inputPanel.add(txtLastName, gbc_txtLastName);
	    
	    buttonPanel.add(btnUpdate, BorderLayout.CENTER);
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
	  	           	plainTextsize=   Math.min(getHeight() / 25, getWidth()/ 25);
	  	          
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
	  	          	lblFirstName.setFont(plainFont);  	          
	  	          	lblLastName.setFont(plainFont);  	          
	  	        

	          }
	      });
	    // Action Listener
	    btnUpdate.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	
	    	String DB_URL = "jdbc:mysql://localhost:3306/book_keeper";
	        String DB_USERNAME = "root";
	        String DB_PASSWORD = "";
	    	String firstName = txtFirstName.getText();
	    	String lastName = txtLastName.getText();
	    	String formattedID = patron.getUser_id();
	    	
	    	// Shield
	    	if (firstName.isBlank() || lastName.isBlank() || firstName.equals("Enter First Name") || lastName.equals("Enter Last Name")) {
	    		MalfunctionPanel mal = new MalfunctionPanel("Info Change", "Cannot update with blank values");
	            showDialog(mal);
	    		return;
	    	}
	    	if(firstName.equals(patron.getUser_fname()) && lastName.equals(patron.getUser_lname())){
	    		MalfunctionPanel mal = new MalfunctionPanel("Info Change", "This is already your current\nfirst name and last name");
	            showDialog(mal);
	    		return;
	    	}
	    	
	    	Connection conn = null;
	        PreparedStatement stmt = null;

	        try {
	            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
	            
	            //Prepare query
	            String sql = "UPDATE patron SET patron_fname = ?, patron_lname = ? WHERE formatted_id = ?";
	            
	            //Execute update
	            stmt = conn.prepareStatement(sql);
	            stmt.setString(1, firstName);
	            stmt.setString(2, lastName);
				stmt.setString(3, formattedID);
	            stmt.executeUpdate();
	            //Update Object
	            patron.setUser_fname(firstName);
	            patron.setUser_lname(lastName);
	            
	            //Prompt successful update
	            SuccessPanel success = new SuccessPanel("Info Change", "Name Change Successful");
	            showDialog(success);
	            
	            //Close Frame after update
	            closeDialog(e);
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
		    
			JDialog dialog = new JDialog((JDialog) SwingUtilities.getWindowAncestor(this), "Success", true);
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
		    
			JDialog dialog = new JDialog((JDialog) SwingUtilities.getWindowAncestor(this),"Error", true);
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