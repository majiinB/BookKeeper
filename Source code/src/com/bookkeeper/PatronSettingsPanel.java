package com.bookkeeper;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import com.bookkeeper.PatronLibraryPanel.headerRenderer;

import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class PatronSettingsPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//panel
	private JPanel mainPanel;
	private JPanel headingPanel;
	
	private RoundedPanel accDetailPanel;
	private RoundedPanel reserveBookPanel;
	private RoundedPanel activeLoanPanel;
	private RoundedPanel historyLoanPanel;
	
	private JPanel firstNamePanel;
	private JPanel lastNamePanel;
	private JPanel userIDPanel;
	private JPanel emailPanel;
	private JPanel homeAddressPanel;
	private JPanel contactNumberPanel;
	
	//label
	private JLabel lblHeading1;
	private JLabel lblHeading2;
	
	private JLabel lblaccDetail;
	
	private JLabel lblFirstName;
	private JLabel lblLastName;
	private JLabel lblHomeAddress;
	private JLabel lblContactNumber;	
	private JLabel lblUserID;	
	private JLabel lblEmailAddress;	
	private JLabel lblreserveBook;
	private JLabel lblOverdue;
	private JLabel lblactiveLoan;
	private JLabel lblhistoryLoan;
	
	//textfield
	private PlaceholderTextField txtFirstName;
	private PlaceholderTextField txtLastName;
	private PlaceholderTextField txtHomeAddress;
	private PlaceholderTextField txtContactNumber;	
	private PlaceholderTextField txtUserID;
	private PlaceholderTextField txtEmailAddress;
	//icon

	private ImageIcon optionIcon;
	private Image optionImage;
	private ImageIcon overdueIcon;

	private int iconHeight; 
	private int iconWidth;
	//button
	private JButton btnOptionDetail;
	
	//pop up menu
//	private PlaceholderPopupMenu detailPopupMenu;
	private JPopupMenu detailPopupMenu;
	private JMenuItem option1;
	private JMenuItem option2;
	private JMenuItem option3;
	//scroll
	private JScrollPane  settingScrollPane;
	private JScrollPane  reserveScrollPane;
	private JScrollPane  historyLoanScrollPane;
	private JScrollPane  activeLoanScrollPane;

	//table
	private JTable reserveTable;
	private JTable activeLoanTable;
	private JTable historyLoanTable;
	private DefaultTableModel reserveTableModel;
	private DefaultTableModel activeLoanTableModel;
	private DefaultTableModel historyLoanTableModel;
	
	//layout
	private GridBagLayout gbl_mainPanel;
	private GridBagConstraints gbc_accDetailPanel;
	private GridBagConstraints gbc_reserveBookPanel;
	private GridBagConstraints gbc_activeLoanPanel;
	private GridBagConstraints gbc_historyLoanPanel;
	
	private GridBagLayout gbl_accDetailPanel;
	private GridBagConstraints gbc_lblaccDetail;
	private GridBagConstraints gbc_firstNamePanel;
	private GridBagConstraints gbc_lastNamePanel;
	private GridBagConstraints gbc_userIDPanel;
	private GridBagConstraints gbc_contactNumberPanel;
	private GridBagConstraints gbc_homeAddressPanel;
	private GridBagConstraints gbc_emailPanel;
	private GridBagConstraints gbc_btnOptionDetail;

	private GridBagLayout gbl_firstNamePanel;
	private GridBagConstraints gbc_lblFirstName;
	private GridBagConstraints gbc_txtFirstName;
	
	private GridBagLayout gbl_lastNamePanel;
	private GridBagConstraints gbc_lblLastName;
	private GridBagConstraints gbc_txtLastName;
	
	private GridBagLayout gbl_userIDPanel;
	private GridBagConstraints gbc_lblUserID;
	private GridBagConstraints gbc_txtUserID;
	
	private GridBagLayout gbl_contactNumberPanel;
	private GridBagConstraints gbc_lblContactNumber;
	private GridBagConstraints gbc_txtContactNumber;
	
	private GridBagLayout gbl_homeAddressPanel;
	private GridBagConstraints gbc_lblHomeAddress;
	private GridBagConstraints gbc_txtHomeAddress;
	
	private GridBagLayout gbl_emailPanel;
	private GridBagConstraints gbc_lblEmailAddress;
	private GridBagConstraints gbc_txtEmailAddress;
	
	private GridBagLayout gbl_reserveBookPanel;
	private GridBagConstraints gbc_reserveTable;
	private GridBagConstraints gbc_lblreserveBook;

	private GridBagLayout gbl_activeLoanPanel;
	private GridBagConstraints gbc_lblactiveLoan;
	private GridBagConstraints gbc_activeLoanScrollPane;	

	private GridBagLayout gbl_historyLoanPanel;
	private GridBagConstraints gbc_lblhistoryLoan;
	private GridBagConstraints gbc_historyLoanScrollPane;
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

 public PatronSettingsPanel(User user) {
	setBackground(lightplainColor);
	setBorder(new EmptyBorder(10, 20, 10, 0));
	setLayout(new BorderLayout(0, 0));
	 
	//create panels
	mainPanel = new JPanel();

	headingPanel = new JPanel();
	
    accDetailPanel =  new RoundedPanel(20);
    reserveBookPanel =  new RoundedPanel(20);
    activeLoanPanel =  new RoundedPanel(20);
    historyLoanPanel =  new RoundedPanel(20);

    firstNamePanel = new JPanel();
	lastNamePanel = new JPanel();
	lastNamePanel.setFocusable(false);
	userIDPanel = new JPanel();
	contactNumberPanel = new JPanel();
	homeAddressPanel = new JPanel();
	emailPanel = new JPanel();
	
    // Set panel properties
    headingPanel.setOpaque(false);
    mainPanel.setOpaque(false);
    accDetailPanel.setOpaque(false);
    reserveBookPanel.setOpaque(false);
    historyLoanPanel.setOpaque(false);
    activeLoanPanel.setOpaque(false);
    firstNamePanel.setOpaque(false);
	lastNamePanel.setOpaque(false);
	userIDPanel.setOpaque(false);
	contactNumberPanel.setOpaque(false);
	homeAddressPanel.setOpaque(false);
	emailPanel.setOpaque(false);
	
	mainPanel.setBorder(new EmptyBorder(0, 0, 0, 30));
    accDetailPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
    reserveBookPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
    activeLoanPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
    historyLoanPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
	headingPanel.setBorder(new EmptyBorder(10, 25, 10, 25));

    accDetailPanel.setBorderWidth(2);
    activeLoanPanel.setBorderWidth(2);
    reserveBookPanel.setBorderWidth(2);
    historyLoanPanel.setBorderWidth(2);

    settingScrollPane  = new JScrollPane(mainPanel);
    settingScrollPane.setOpaque(false);
    settingScrollPane.getViewport().setOpaque(false);
    settingScrollPane.setBackground(new Color(255, 255, 255));
    settingScrollPane.setBorder(new EmptyBorder(0, 25, 0, 0));
    settingScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    settingScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    
	lblHeading1 = new JLabel("Dashboard ");
	lblHeading1.setOpaque(false);
	lblHeading1.setForeground(darkplainColor);

	lblHeading2 = new JLabel("/ Settings");
    lblHeading2.setOpaque(false);
    lblHeading2.setForeground(darkplainColor);


	lblaccDetail = new JLabel("My Details");
	lblaccDetail.setOpaque(false);
	lblaccDetail.setForeground(darkplainColor);
	
	btnOptionDetail = new JButton();
	btnOptionDetail.setFocusPainted(false);
	btnOptionDetail.setBorderPainted(false);
	btnOptionDetail.setContentAreaFilled(false);
	btnOptionDetail.setOpaque(false);
	btnOptionDetail.setPreferredSize(new Dimension(5, 20));

	option1 = new JMenuItem("Edit Information");

    detailPopupMenu = new JPopupMenu();
	
	detailPopupMenu.add(option1);

	optionIcon = new ImageIcon("img/DashboardFrame/Option.png");    
	iconHeight = (int) (btnOptionDetail.getPreferredSize().getHeight());
    iconWidth = (int) (btnOptionDetail.getPreferredSize().getHeight());
    
    optionIcon = new ImageIcon(optionIcon.getImage().getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH));
    btnOptionDetail.setIcon(optionIcon);
    btnOptionDetail.setOpaque(false);
    
	lblFirstName = new JLabel("First Name");
	lblFirstName.setOpaque(false);
	lblFirstName.setForeground(darkplainColor);
	
	txtFirstName = new PlaceholderTextField(user.getUser_fname());
	txtFirstName.setFocusable(false);
	txtFirstName.setEditable(false);
	txtFirstName.setBorder(null);
	txtFirstName.setOpaque(false);
	txtFirstName.setForeground(darkplainColor);
	
	lblLastName = new JLabel("Last Name");
	lblLastName.setBorder(null);
	lblLastName.setOpaque(false);
	lblLastName.setForeground(darkplainColor);
	
	txtLastName = new PlaceholderTextField(user.getUser_lname());
	txtLastName.setFocusable(false);
	txtLastName.setEditable(false);
	txtLastName.setOpaque(false);
	txtLastName.setBorder(null);
	txtLastName.setForeground(darkplainColor);
	
	lblUserID = new JLabel("User ID");
	lblUserID.setOpaque(false);
	lblUserID.setForeground(darkplainColor);
	
	txtUserID = new PlaceholderTextField(user.getUser_id());
	txtUserID.setFocusable(false);
	txtUserID.setBorder(null);
	txtUserID.setEditable(false);
	txtUserID.setOpaque(false);
	txtUserID.setForeground(darkplainColor);
	
	lblHomeAddress = new JLabel("Home Address");
	lblHomeAddress.setOpaque(false);
	lblHomeAddress.setForeground(darkplainColor);
	
	txtHomeAddress = new PlaceholderTextField(user.getUser_address());
	txtHomeAddress.setFocusable(false);
	txtHomeAddress.setBorder(null);
	txtHomeAddress.setEditable(false);
	txtHomeAddress.setOpaque(false);
	txtHomeAddress.setForeground(darkplainColor);
	
	lblContactNumber = new JLabel("Contact Number");
	lblContactNumber.setOpaque(false);
	lblContactNumber.setForeground(darkplainColor);
	
	txtContactNumber= new PlaceholderTextField(user.getUser_contact());
	txtContactNumber.setFocusable(false);
	txtContactNumber.setBorder(null);
	txtContactNumber.setEditable(false);
	txtContactNumber.setOpaque(false);
	txtContactNumber.setForeground(darkplainColor);
	
	lblEmailAddress = new JLabel("Email Address");
	lblEmailAddress.setOpaque(false);
	lblEmailAddress.setForeground(darkplainColor);
	
	txtEmailAddress = new PlaceholderTextField(user.getUser_email());
	txtEmailAddress.setFocusable(false);
	txtEmailAddress.setEditable(false);
	txtEmailAddress.setBorder(null);
	txtEmailAddress.setOpaque(false);
	txtEmailAddress.setForeground(darkplainColor);


	lblreserveBook = new JLabel("Reserved Books");
	lblreserveBook.setBorder(new EmptyBorder(20, 20, 0, 0));
	lblreserveBook.setOpaque(false);
	lblreserveBook.setForeground(darkplainColor);
	

	// Setting up reserved books table
	reserveTableModel = new DefaultTableModel();
	reserveTable = new JTable(reserveTableModel) {
    	/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		// Override isCellEditable method to make cells not editable
		@Override
		public boolean isCellEditable(int row, int column) {
		      return false;
		}
    };
	reserveTable.setBackground(lightplainColor);;
	reserveTable.setFillsViewportHeight(true);
	reserveTable.setOpaque(false);
	reserveTable.setShowVerticalLines(false);
	reserveTable.setRowHeight(45);
	reserveTable.getTableHeader().setOpaque(false);
	reserveTable.setGridColor(darkplainColor);
    reserveTable.getTableHeader().setDefaultRenderer(new headerRenderer());
    reserveTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

	reserveScrollPane  = new JScrollPane();
	reserveScrollPane.setOpaque(false);
	reserveScrollPane.getViewport().setOpaque(false);
	reserveScrollPane.setBackground(new Color(255, 255, 255));
	reserveScrollPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	reserveScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	reserveScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    reserveScrollPane.setViewportView(reserveTable);
    
	lblactiveLoan = new JLabel("Active Book Loans");
	lblactiveLoan.setBorder(new EmptyBorder(20, 20, 0, 0));
	lblactiveLoan.setOpaque(false);
	lblactiveLoan.setForeground(darkplainColor);
	

	// Setting up active loan table
	activeLoanTableModel = new DefaultTableModel();
	activeLoanTable = new JTable(activeLoanTableModel) {
    	/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		// Override isCellEditable method to make cells not editable
		@Override
		public boolean isCellEditable(int row, int column) {
		      return false;
		}
    };
    activeLoanTable.setBackground(lightplainColor);;
    activeLoanTable.setFillsViewportHeight(true);
    activeLoanTable.setOpaque(false);
    activeLoanTable.setShowVerticalLines(false);
    activeLoanTable.setRowHeight(45);
    activeLoanTable.getTableHeader().setOpaque(false);
	activeLoanTable.setGridColor(darkplainColor);
	activeLoanTable.getTableHeader().setDefaultRenderer(new headerRenderer());
	activeLoanTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    
	activeLoanScrollPane  = new JScrollPane();
	activeLoanScrollPane.setOpaque(false);
	activeLoanScrollPane.getViewport().setOpaque(false);
	activeLoanScrollPane.setBackground(new Color(255, 255, 255));
	activeLoanScrollPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	activeLoanScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	activeLoanScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    activeLoanScrollPane.setViewportView(activeLoanTable);
	
	lblhistoryLoan = new JLabel("Book Loan History");
	lblhistoryLoan.setBorder(new EmptyBorder(20, 20, 0, 0));
	lblhistoryLoan.setOpaque(false);
	lblhistoryLoan.setForeground(darkplainColor);
	
	// Setting up history loan table

	historyLoanTableModel = new DefaultTableModel();
	historyLoanTable = new JTable(historyLoanTableModel) {
    	/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		// Override isCellEditable method to make cells not editable
		@Override
		public boolean isCellEditable(int row, int column) {
		      return false;
		}
    };
    historyLoanTable.setBackground(lightplainColor);;
    historyLoanTable.setFillsViewportHeight(true);
    historyLoanTable.setOpaque(false);
    historyLoanTable.setShowVerticalLines(false);
    historyLoanTable.setRowHeight(45);
    activeLoanTable.getTableHeader().setOpaque(false);
    historyLoanTable.setGridColor(darkplainColor);
    historyLoanTable.getTableHeader().setDefaultRenderer(new headerRenderer());
    historyLoanTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    
	historyLoanScrollPane  = new JScrollPane();
	historyLoanScrollPane.setOpaque(false);
	historyLoanScrollPane.getViewport().setOpaque(false);
	historyLoanScrollPane.setBackground(new Color(255, 255, 255));
	historyLoanScrollPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	historyLoanScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	historyLoanScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    historyLoanScrollPane.setViewportView(historyLoanTable);
	
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
	gbl_mainPanel.columnWidths = new int[]{380, 0};
	gbl_mainPanel.rowHeights = new int[]{30, 46, 0};
	gbl_mainPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
	gbl_mainPanel.rowWeights = new double[]{0.0, 0.0, 0.0};
    
	gbc_accDetailPanel = new GridBagConstraints();
    gbc_accDetailPanel.fill = GridBagConstraints.BOTH;
    gbc_accDetailPanel.insets = new Insets(15, 0, 25, 0);
    gbc_accDetailPanel.gridx = 0;
    gbc_accDetailPanel.gridy = 0;  	
    

    gbc_reserveBookPanel = new GridBagConstraints();
    gbc_reserveBookPanel.fill = GridBagConstraints.BOTH;
    gbc_reserveBookPanel.insets = new Insets(15, 0, 25, 0);
    gbc_reserveBookPanel.gridx = 0;
    gbc_reserveBookPanel.gridy = 1; 
    
    gbc_activeLoanPanel = new GridBagConstraints();
    gbc_activeLoanPanel.fill = GridBagConstraints.BOTH;
    gbc_activeLoanPanel.insets = new Insets(15, 0, 25, 0);
    gbc_activeLoanPanel.gridx = 0;
    gbc_activeLoanPanel.gridy = 2; 
    
    //
    gbl_accDetailPanel = new GridBagLayout();
    gbl_accDetailPanel.columnWidths = new int[]{0, 0, 0};
    gbl_accDetailPanel.rowHeights = new int[]{66, 0};
    gbl_accDetailPanel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
    gbl_accDetailPanel.rowWeights = new double[]{0.0, 0.0};
    
    gbc_lblaccDetail = new GridBagConstraints();
    gbc_lblaccDetail.fill = GridBagConstraints.HORIZONTAL;
    gbc_lblaccDetail.insets = new Insets(0, 0, 5, 0);
    gbc_lblaccDetail.gridx = 0;
    gbc_lblaccDetail.gridy = 0;
	
    gbc_btnOptionDetail = new GridBagConstraints();
    gbc_btnOptionDetail.anchor = GridBagConstraints.EAST;
    gbc_btnOptionDetail.insets = new Insets(0, 0, 0, 0);
    gbc_btnOptionDetail.gridx = 1;
    gbc_btnOptionDetail.gridy = 0;

    gbc_firstNamePanel = new GridBagConstraints();
    gbc_firstNamePanel.fill = GridBagConstraints.HORIZONTAL;
    gbc_firstNamePanel.anchor = GridBagConstraints.NORTH;
    gbc_firstNamePanel.insets = new Insets(0, 0, 5, 0);
    gbc_firstNamePanel.gridx = 0;
    gbc_firstNamePanel.gridy = 1; 
    
    gbc_lastNamePanel = new GridBagConstraints();
    gbc_lastNamePanel.fill = GridBagConstraints.HORIZONTAL;
    gbc_lastNamePanel.anchor = GridBagConstraints.NORTH;
    gbc_lastNamePanel.insets = new Insets(0, 5, 5, 0);
    gbc_lastNamePanel.gridx = 1;
    gbc_lastNamePanel.gridy = 1 ;
    
    gbc_userIDPanel = new GridBagConstraints();
    gbc_userIDPanel.fill = GridBagConstraints.HORIZONTAL;
    gbc_userIDPanel.anchor = GridBagConstraints.NORTH;
    gbc_userIDPanel.insets = new Insets(0, 0, 5, 0);
    gbc_userIDPanel.gridx = 0;
    gbc_userIDPanel.gridy = 2; 
    
    gbc_contactNumberPanel = new GridBagConstraints();
    gbc_contactNumberPanel.fill = GridBagConstraints.HORIZONTAL;
    gbc_contactNumberPanel.anchor = GridBagConstraints.NORTH;
    gbc_contactNumberPanel.insets = new Insets(0, 5, 5, 0);
    gbc_contactNumberPanel.gridx = 1;
    gbc_contactNumberPanel.gridy = 2; 
    
    gbc_homeAddressPanel = new GridBagConstraints();
    gbc_homeAddressPanel.fill = GridBagConstraints.HORIZONTAL;
    gbc_homeAddressPanel.anchor = GridBagConstraints.NORTH;
    gbc_homeAddressPanel.insets = new Insets(0, 0, 5, 0);
    gbc_homeAddressPanel.gridx = 0;
    gbc_homeAddressPanel.gridy = 3; 
    
    gbc_emailPanel = new GridBagConstraints();
    gbc_emailPanel.fill = GridBagConstraints.HORIZONTAL;
    gbc_emailPanel.anchor = GridBagConstraints.NORTH;
    gbc_emailPanel.insets = new Insets(0, 5, 5, 0);
    gbc_emailPanel.gridx = 1;
    gbc_emailPanel.gridy = 3; 
    
    //
    gbl_firstNamePanel = new GridBagLayout();
    gbl_firstNamePanel.columnWidths = new int[]{491, 0};
    gbl_firstNamePanel.rowHeights = new int[]{30, 30};
    gbl_firstNamePanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
    gbl_firstNamePanel.rowWeights = new double[]{0.0, 0.0};
    
    gbc_lblFirstName = new GridBagConstraints();
    gbc_lblFirstName.fill = GridBagConstraints.BOTH;
    gbc_lblFirstName.insets = new Insets(0, 0, 0, 0);
	gbc_lblFirstName.gridx = 0;
	gbc_lblFirstName.gridy = 0; 
	
	gbc_txtFirstName = new GridBagConstraints();
	gbc_txtFirstName.fill = GridBagConstraints.BOTH;
	gbc_txtFirstName.insets = new Insets(0, 0, 0, 0);
	gbc_txtFirstName.gridx = 0;
	gbc_txtFirstName.gridy = 1; 
    
    //

	gbl_lastNamePanel = new GridBagLayout();
	gbl_lastNamePanel.columnWidths = new int[]{491, 0};
	gbl_lastNamePanel.rowHeights = new int[]{30, 30};
	gbl_lastNamePanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
	gbl_lastNamePanel.rowWeights = new double[]{0.0, 0.0};
    
	gbc_lblLastName = new GridBagConstraints();
	gbc_lblLastName.fill = GridBagConstraints.BOTH;
	gbc_lblLastName.insets = new Insets(0, 0, 0, 0);
	gbc_lblLastName.gridx = 0;
	gbc_lblLastName.gridy = 0; 
	
	gbc_txtLastName = new GridBagConstraints();
	gbc_txtLastName.fill = GridBagConstraints.BOTH;
	gbc_txtLastName.insets = new Insets(0, 0, 0, 0);
	gbc_txtLastName.gridx = 0;
	gbc_txtLastName.gridy = 1; 
    
    //
	
	gbl_userIDPanel = new GridBagLayout();
	gbl_userIDPanel.columnWidths = new int[]{491, 0};
	gbl_userIDPanel.rowHeights = new int[]{30, 30};
	gbl_userIDPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
	gbl_userIDPanel.rowWeights = new double[]{0.0, 0.0};
    
	gbc_lblUserID = new GridBagConstraints();
	gbc_lblUserID.fill = GridBagConstraints.BOTH;
	gbc_lblUserID.insets = new Insets(0, 0, 0, 0);
	gbc_lblUserID.gridx = 0;
	gbc_lblUserID.gridy = 0; 
	
	gbc_txtUserID = new GridBagConstraints();
	gbc_txtUserID.fill = GridBagConstraints.BOTH;
	gbc_txtUserID.insets = new Insets(0, 0, 0, 0);
	gbc_txtUserID.gridx = 0;
	gbc_txtUserID.gridy = 1; 
    
    //
	gbl_contactNumberPanel = new GridBagLayout();
	gbl_contactNumberPanel.columnWidths = new int[]{491, 0};
	gbl_contactNumberPanel.rowHeights = new int[]{30, 30};
	gbl_contactNumberPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
	gbl_contactNumberPanel.rowWeights = new double[]{0.0, 0.0};
    
	gbc_lblContactNumber = new GridBagConstraints();
	gbc_lblContactNumber.fill = GridBagConstraints.BOTH;
	gbc_lblContactNumber.insets = new Insets(0, 0, 0, 0);
	gbc_lblContactNumber.gridx = 0;
	gbc_lblContactNumber.gridy = 0; 
	
	gbc_txtContactNumber = new GridBagConstraints();
	gbc_txtContactNumber.fill = GridBagConstraints.BOTH;
	gbc_txtContactNumber.insets = new Insets(0, 0, 0, 0);
	gbc_txtContactNumber.gridx = 0;
	gbc_txtContactNumber.gridy = 1; 
    
    //
	gbl_homeAddressPanel = new GridBagLayout();
	gbl_homeAddressPanel.columnWidths = new int[]{491, 0};
	gbl_homeAddressPanel.rowHeights = new int[]{30, 30};
	gbl_homeAddressPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
	gbl_homeAddressPanel.rowWeights = new double[]{0.0, 0.0};
    
	gbc_lblHomeAddress = new GridBagConstraints();
	gbc_lblHomeAddress.fill = GridBagConstraints.BOTH;
	gbc_lblHomeAddress.insets = new Insets(0, 0, 0, 0);
	gbc_lblHomeAddress.gridx = 0;
	gbc_lblHomeAddress.gridy = 0; 
	
	gbc_txtHomeAddress = new GridBagConstraints();
	gbc_txtHomeAddress.fill = GridBagConstraints.BOTH;
	gbc_txtHomeAddress.insets = new Insets(0, 0, 0, 0);
	gbc_txtHomeAddress.gridx = 0;
	gbc_txtHomeAddress.gridy = 1; 
    
    //
	gbl_emailPanel = new GridBagLayout();
	gbl_emailPanel.columnWidths = new int[]{491, 0};
	gbl_emailPanel.rowHeights = new int[]{30, 30};
	gbl_emailPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
	gbl_emailPanel.rowWeights = new double[]{0.0, 0.0};
    
	gbc_lblEmailAddress = new GridBagConstraints();
	gbc_lblEmailAddress.fill = GridBagConstraints.BOTH;
	gbc_lblEmailAddress.insets = new Insets(0, 0, 0, 0);
	gbc_lblEmailAddress.gridx = 0;
	gbc_lblEmailAddress.gridy = 0; 
	
	gbc_txtEmailAddress = new GridBagConstraints();
	gbc_txtEmailAddress.fill = GridBagConstraints.BOTH;
	gbc_txtEmailAddress.insets = new Insets(0,0,0,0);
	gbc_txtEmailAddress.gridx = 0;
	gbc_txtEmailAddress.gridy = 1; 
    //
    gbl_reserveBookPanel = new GridBagLayout();
    gbl_reserveBookPanel.columnWidths = new int[]{316, 0};
    gbl_reserveBookPanel.rowHeights = new int[]{66, 0};
    gbl_reserveBookPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
    gbl_reserveBookPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};


    gbc_lblreserveBook = new GridBagConstraints();
    gbc_lblreserveBook.anchor = GridBagConstraints.WEST;
    gbc_lblreserveBook.insets = new Insets(0, 0, 5,5);
    gbc_lblreserveBook.gridx = 0;
    gbc_lblreserveBook.gridy = 0;

    gbc_reserveTable = new GridBagConstraints();
    gbc_reserveTable.fill = GridBagConstraints.BOTH;
    gbc_reserveTable.gridx = 0;
    gbc_reserveTable.gridy = 1;
    
    //
    
    gbl_activeLoanPanel = new GridBagLayout();
    gbl_activeLoanPanel.columnWidths = new int[]{316, 0};
    gbl_activeLoanPanel.rowHeights = new int[]{66, 0};
    gbl_activeLoanPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
    gbl_activeLoanPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
   
	gbc_lblactiveLoan = new GridBagConstraints();
	gbc_lblactiveLoan.fill = GridBagConstraints.BOTH;
	gbc_lblactiveLoan.insets = new Insets(0, 5, 5, 0);
	gbc_lblactiveLoan.gridx = 0;
	gbc_lblactiveLoan.gridy = 0;
	   
    gbc_activeLoanScrollPane = new GridBagConstraints();
    gbc_activeLoanScrollPane.fill = GridBagConstraints.BOTH;
    gbc_activeLoanScrollPane.gridx = 0;
    gbc_activeLoanScrollPane.gridy = 1;

    gbc_historyLoanPanel = new GridBagConstraints();
    gbc_historyLoanPanel.fill = GridBagConstraints.BOTH;
    gbc_historyLoanPanel.insets = new Insets(15, 0, 25, 0);
    gbc_historyLoanPanel.gridx = 0;
    gbc_historyLoanPanel.gridy = 3;
    
    gbl_historyLoanPanel = new GridBagLayout();
    gbl_historyLoanPanel.columnWidths = new int[]{316, 0};
    gbl_historyLoanPanel.rowHeights = new int[]{66, 0};
    gbl_historyLoanPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
    gbl_historyLoanPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
    
	gbc_lblhistoryLoan = new GridBagConstraints();
	gbc_lblhistoryLoan.fill = GridBagConstraints.BOTH;
	gbc_lblhistoryLoan.insets = new Insets(0, 5, 0, 5);
	gbc_lblhistoryLoan.gridx = 0;
	gbc_lblhistoryLoan.gridy = 0;
	   
    gbc_historyLoanScrollPane = new GridBagConstraints();
    gbc_historyLoanScrollPane.fill = GridBagConstraints.BOTH;
    gbc_historyLoanScrollPane.gridx = 0;
    gbc_historyLoanScrollPane.gridy = 1;
    
    // Set panel layouts
    mainPanel.setLayout(gbl_mainPanel);
    accDetailPanel.setLayout(gbl_accDetailPanel);
    firstNamePanel.setLayout(gbl_firstNamePanel);
	lastNamePanel.setLayout(gbl_lastNamePanel);
	userIDPanel.setLayout(gbl_userIDPanel);
	contactNumberPanel.setLayout(gbl_contactNumberPanel);
	homeAddressPanel.setLayout(gbl_homeAddressPanel);
	emailPanel.setLayout(gbl_emailPanel);
    headingPanel.setLayout(new BoxLayout(headingPanel, BoxLayout.X_AXIS));
    reserveBookPanel.setLayout(gbl_reserveBookPanel);
    activeLoanPanel.setLayout(gbl_activeLoanPanel);
    historyLoanPanel.setLayout(gbl_historyLoanPanel);
    activeLoanPanel.setLayout(gbl_activeLoanPanel);

    headingPanel.add(lblHeading1);
    headingPanel.add(lblHeading2);
    
    firstNamePanel.add(lblFirstName,gbc_lblFirstName);
    firstNamePanel.add(txtFirstName,gbc_txtFirstName);
	lastNamePanel.add(lblLastName,gbc_lblLastName);
	lastNamePanel.add(txtLastName,gbc_txtLastName);
	userIDPanel.add(lblUserID,gbc_lblUserID);
	userIDPanel.add(txtUserID,gbc_txtUserID);
	contactNumberPanel.add(lblContactNumber,gbc_lblContactNumber);
	contactNumberPanel.add(txtContactNumber,gbc_txtContactNumber);
	homeAddressPanel.add(lblHomeAddress,gbc_lblHomeAddress);
	homeAddressPanel.add(txtHomeAddress,gbc_txtHomeAddress);
	emailPanel.add(lblEmailAddress,gbc_lblEmailAddress);
	emailPanel.add(txtEmailAddress,gbc_txtEmailAddress);
	
	
	accDetailPanel.add(lblaccDetail, gbc_lblaccDetail);
	accDetailPanel.add(btnOptionDetail, gbc_btnOptionDetail);
    accDetailPanel.add(firstNamePanel, gbc_firstNamePanel);
	accDetailPanel.add(lastNamePanel, gbc_lastNamePanel);
	accDetailPanel.add(userIDPanel, gbc_userIDPanel);
	accDetailPanel.add(contactNumberPanel, gbc_contactNumberPanel);
	accDetailPanel.add(homeAddressPanel, gbc_homeAddressPanel);
	accDetailPanel.add(emailPanel, gbc_emailPanel);
    
	activeLoanPanel.add(lblactiveLoan, gbc_lblactiveLoan);
	activeLoanPanel.add(activeLoanScrollPane, gbc_activeLoanScrollPane);
	
	activeLoanPanel.add(activeLoanScrollPane, gbc_activeLoanScrollPane);
	activeLoanPanel.add(activeLoanScrollPane, gbc_activeLoanScrollPane);
	
	reserveBookPanel.add(lblreserveBook, gbc_lblreserveBook);    
    reserveBookPanel.add(reserveScrollPane, gbc_reserveTable);
    
    historyLoanPanel.add(lblhistoryLoan, gbc_lblhistoryLoan);
    historyLoanPanel.add(historyLoanScrollPane,gbc_historyLoanScrollPane);

    mainPanel.add(accDetailPanel,gbc_accDetailPanel);
    mainPanel.add(reserveBookPanel,gbc_reserveBookPanel);
    mainPanel.add(activeLoanPanel,gbc_activeLoanPanel);
    mainPanel.add(historyLoanPanel,gbc_historyLoanPanel);
    
    //Method call for table
    displayReservation(user.getUser_id());
    displayActiveBookLoans(user.getUser_id());
    displayBookHistory(user.getUser_id());
    
	add(headingPanel, BorderLayout.NORTH);
	add(settingScrollPane, BorderLayout.CENTER);

	addComponentListener(new ComponentAdapter() {
  	  @Override
        public void componentResized(ComponentEvent e) {
	  		titleTextSize = Math.min(getHeight() / 8, getWidth()/ 8) ;
	        subtitleTextSize =  Math.min(getHeight() / 36, getWidth()/ 36);
	        buttonTextSize =  Math.min(getHeight() / 50, getWidth()/ 50);
	        headerTextSize =   Math.min(getHeight() / 20, getWidth()/ 20);
	        plainTextsize=   Math.min(getHeight() / 60, getWidth()/ 60);
	        
	        titleFont = new Font("Montserrat", Font.BOLD, titleTextSize);
			subtitleFont = new Font("Montserrat", Font.BOLD, subtitleTextSize);
			plainFont = new Font("Montserrat", Font.ITALIC | Font.BOLD, plainTextsize);

	        lblaccDetail.setFont(subtitleFont);    
	        lblreserveBook.setFont(subtitleFont);    
	        lblactiveLoan.setFont(subtitleFont);    
	        lblhistoryLoan.setFont(subtitleFont);    
	        
	     	lblHeading1.setFont(new Font("Montserrat", Font.BOLD, headerTextSize));
	     	lblHeading2.setFont(new Font("Montserrat", Font.PLAIN, headerTextSize));
	            
			lblFirstName.setFont(plainFont);
			lblLastName.setFont(plainFont);
			lblUserID.setFont(plainFont);
			lblHomeAddress.setFont(plainFont);
			lblContactNumber.setFont(plainFont);
			lblEmailAddress.setFont(plainFont);
			
			reserveTable.setFont(plainFont);
			reserveTable.getTableHeader().setFont(new Font("Montserrat", Font.ITALIC  | Font.BOLD, plainTextsize));	            
			reserveTable.getTableHeader().setForeground(headerColor);
			
			activeLoanTable.setFont(plainFont);
			activeLoanTable.getTableHeader().setFont(new Font("Montserrat", Font.ITALIC  | Font.BOLD, plainTextsize));	            
			activeLoanTable.getTableHeader().setForeground(headerColor);
			
			historyLoanTable.setFont(plainFont);
			historyLoanTable.getTableHeader().setFont(new Font("Montserrat", Font.ITALIC  | Font.BOLD, plainTextsize));	            
			historyLoanTable.getTableHeader().setForeground(headerColor);
	     		     	
	     	
		}
    });
	
	//option for table
    option2 = new JMenuItem("View Book Information");
    option3 = new JMenuItem("Cancel Reservation");
//	menu.add(option2);
//	menu.add(option3);
    
    lblOverdue = new JLabel();
    lblOverdue.setToolTipText("Overdue");
	overdueIcon = new ImageIcon("img/DashboardFrame/Overdue.png");    
    overdueIcon = new ImageIcon(optionIcon.getImage().getScaledInstance(iconHeight, iconHeight, Image.SCALE_SMOOTH));
    lblOverdue.setIcon(overdueIcon);
    lblOverdue.setOpaque(false);
    
	//action Listeners
	btnOptionDetail.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent ev) {
	    	detailPopupMenu.show(btnOptionDetail, btnOptionDetail.getBounds().x, btnOptionDetail.getBounds().y
	           + btnOptionDetail.getBounds().height);
	    }
	});
	option1.addMouseListener(new MouseAdapter() {
	    public void mousePressed(MouseEvent e) {
	    	
	    	JFrame parentFrame = (JFrame) SwingUtilities.windowForComponent(option1);

	    	AccountInfoPanel panel = new AccountInfoPanel(user, parentFrame);
	    	showDialog(panel);
	    }
	});
 }
 public class headerRenderer implements TableCellRenderer {
		@Override
	    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,boolean hasFocus, int row, int column) {
		        JTableHeader header = table.getTableHeader();
		        JLabel label = new JLabel(value.toString());
		        label.setOpaque(false);
		        label.setFont(header.getFont());
		        label.setBackground(new Color(0, 0, 0, 0)); 
		        label.setForeground(header.getForeground());
		        label.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
		        return label;
		    }
		}
 
	 private void displayBookHistory(String id) {
	     try {
	         // Establish database connection
	     	//Rekta na kasi tinamad mag assign pa ng variables same lang naman kasi db na gagamitin HAHAHAHAA
	         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_keeper", "root", "");
	         String getQuery = "SELECT b.book_title, bb.borrowed_date" +
	                 " FROM book AS b " +
	                 "JOIN borrowed_book AS bb ON b.book_id = bb.book_id" +
	                 " WHERE bb.patron_id = '" + id + "' AND bb.borrow_status = 'returned' ORDER BY bb.borrowed_date";
	
	         // Execute the SQL query
	         Statement statement = connection.createStatement();
	         ResultSet resultSet = statement.executeQuery(getQuery); 
	
	         // Get the metadata for column information
	         ResultSetMetaData metaData = resultSet.getMetaData();
	         int columnCount = metaData.getColumnCount();
	
	         // Create an array to store column names
	         String[] columnNames ={"Book title", "Date Borrowed"};
	         
	
	         // Set the column names in the table model
	         historyLoanTableModel.setColumnIdentifiers(columnNames);
	         
	         //Retrieve all row data
	         while (resultSet.next()) {
	             Object[] rowData = new Object[columnCount];
	             for (int i = 1; i <= columnCount; i++) {
	                 rowData[i - 1] = resultSet.getObject(i);
	             }
	             historyLoanTableModel.addRow(rowData);
	         }
	
	         // Close the database connection
	         resultSet.close();
	         statement.close();
	         connection.close();
	     } catch (SQLException e) {
	         e.printStackTrace();
	     }
	 }
	 private void displayReservation(String id) {
	     try {
	         // Establish database connection
	     	//Rekta na kasi tinamad mag assign pa ng variables same lang naman kasi db na gagamitin HAHAHAHAA
	         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_keeper", "root", "");
	         String getQuery = "SELECT b.book_status, b.ISBN, b.book_title " +
	                 "FROM reserved_book AS rb " +
	                 "JOIN book AS b ON rb.book_id = b.book_id " +
	                 "WHERE rb.patron_id = '" + id + "' AND  rb.reservation_status = 'in que'";
	
	
	         // Execute the SQL query
	         Statement statement = connection.createStatement();
	         ResultSet resultSet = statement.executeQuery(getQuery); 
	
	         // Get the metadata for column information
	         ResultSetMetaData metaData = resultSet.getMetaData();
	         int columnCount = metaData.getColumnCount();
	
	         // Create an array to store column names
	         String[] columnNames = {"Book Status", "ISBN", "Book title"};
	         
	
	         // Set the column names in the table model
	         reserveTableModel.setColumnIdentifiers(columnNames);
	         
	         //Retrieve all row data
	         while (resultSet.next()) {
	             Object[] rowData = new Object[columnCount];
	             for (int i = 1; i <= columnCount; i++) {
	                 rowData[i - 1] = resultSet.getObject(i);
	             }
	             reserveTableModel.addRow(rowData);
	         }
	
	         // Close the database connection
	         resultSet.close();
	         statement.close();
	         connection.close();
	     } catch (SQLException e) {
	         e.printStackTrace();
	     }
	 }
	 private void displayActiveBookLoans(String id) {
	     try {
	         // Establish database connection
	     	//Rekta na kasi tinamad mag assign pa ng variables same lang naman kasi db na gagamitin HAHAHAHAA
	         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_keeper", "root", "");
	         String sqlQuery = "SELECT b.book_title, bb.borrowed_date, bb.borrow_status, bb.borrowed_due_date" +
	                 " FROM book AS b " +
	                 "JOIN borrowed_book AS bb ON b.book_id = bb.book_id" +
	                 " WHERE bb.patron_id = '" + id + "' AND (bb.borrow_status = 'out' OR bb.borrow_status = 'overdue') ORDER BY bb.borrowed_date";

	
	         // Execute the SQL query
	         Statement statement = connection.createStatement();
	         ResultSet resultSet = statement.executeQuery(sqlQuery); 
	
	         // Get the metadata for column information
	         ResultSetMetaData metaData = resultSet.getMetaData();
	         int columnCount = metaData.getColumnCount();
	
	         // Create an array to store column names
	         String[] columnNames ={"Book title", "Date Borrowed", "Status", "Due Date"};
	         
	
	         // Set the column names in the table model
	         activeLoanTableModel.setColumnIdentifiers(columnNames);
	         
	         //Retrieve all row data
	         while (resultSet.next()) {
	             Object[] rowData = new Object[columnCount];
	             for (int i = 1; i <= columnCount; i++) {
	                 rowData[i - 1] = resultSet.getObject(i);
	             }
	             activeLoanTableModel.addRow(rowData);
	         }
	
	         // Close the database connection
	         resultSet.close();
	         statement.close();
	         connection.close();
	     } catch (SQLException e) {
	         e.printStackTrace();
	     }
	 }
	 public void showDialog(AccountInfoPanel panel) {
			
		 panel.getBtnSave().addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		            closeDialog(e);
		    	}
		    });
		    
		JDialog dialog = new JDialog((Frame) SwingUtilities.getWindowAncestor(this), "Change Information", true);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.getContentPane().add(panel);
		dialog.setSize(855, 770);
		dialog.setUndecorated(true);
		dialog.setResizable(false);
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
