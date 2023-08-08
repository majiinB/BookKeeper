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

import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminSettingsPanel extends JPanel {
	//panel
	private JPanel mainPanel;
	private JPanel contentPanel;
	private JPanel headingPanel;
	
	private RoundedPanel accDetailPanel;
	private RoundedPanel systemPanel;
	private RoundedPanel genreListPanel;
	
	private JPanel firstNamePanel;
	private JPanel lastNamePanel;
	private JPanel userIDPanel;
	private JPanel emailPanel;
	private JPanel homeAddressPanel;
	private JPanel contactNumberPanel;
	
	private JPanel CapacityLimitPanel;
	private JPanel DurationLimitPanel;
	private JPanel ReserveLimitPanel;
	private JPanel PenaltyLimitPanel;
	private JPanel genrePanel;
	
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

	private JLabel lblSystem;
	private JLabel lblCapacityLimit;
	private JLabel lblDurationLimit;
	private JLabel lblReserveLimit;
	private JLabel lblPenaltyLimit;
	private JLabel lblGenre;
	
	//textfield
	private PlaceholderTextField txtFirstName;
	private PlaceholderTextField txtLastName;
	private PlaceholderTextField txtHomeAddress;
	private PlaceholderTextField txtContactNumber;	
	private PlaceholderTextField txtUserID;
	private PlaceholderTextField txtEmailAddress;
	
	private PlaceholderTextField txtCapacityLimit;	
	private PlaceholderTextField txtDurationLimit;
	private PlaceholderTextField txtReserveLimit;
	private PlaceholderTextField txtPenaltyLimit;
	//icon

	private ImageIcon optionIcon;
	private Image optionImage;

	private int iconHeight; 
	private int iconWidth;
	//button
	private JButton btnOptionDetail;
	private JButton btnOptionSystem;
	
	//pop up menu
//	private PlaceholderPopupMenu detailPopupMenu;
	private JPopupMenu detailPopupMenu;
	private JPopupMenu systemPopupMenu;
	private JMenuItem optionDetailItem;
	private JMenuItem optionSystemItem;
	
	//scroll
	private JScrollPane  settingScrollPane;
	private JScrollPane  genreScrollPane;


	//List
	private DefaultListModel<String> listModel;
	private JList<String> genreList;
	//layout
	private GridBagLayout gbl_contentPanel;
	private GridBagConstraints gbc_accDetailPanel;
	private GridBagConstraints gbc_systemPanel;
	
	private GridBagLayout gbl_accDetailPanel;
	private GridBagConstraints gbc_lblaccDetail;
	private GridBagConstraints gbc_firstNamePanel;
	private GridBagConstraints gbc_lastNamePanel;
	private GridBagConstraints gbc_userIDPanel;
	private GridBagConstraints gbc_contactNumberPanel;
	private GridBagConstraints gbc_homeAddressPanel;
	private GridBagConstraints gbc_emailPanel;
	private GridBagConstraints gbc_btnOptionDetail;

	private GridBagLayout gbl_systemPanel;
	private GridBagConstraints gbc_lblSystem;
	private GridBagConstraints gbc_btnOptionSystem;
	private GridBagConstraints gbc_CapacityLimitPanel;
	private GridBagConstraints gbc_DurationLimitPanel;
	private GridBagConstraints gbc_ReserveLimitPanel;
	private GridBagConstraints gbc_PenaltyLimitPanel;
	private GridBagConstraints gbc_genrePanel;
	
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
	
	private GridBagLayout gbl_CapacityLimitPanel;
	private GridBagConstraints gbc_lblCapacityLimit;
	private GridBagConstraints gbc_txtCapacityLimit;
	
	private GridBagLayout gbl_DurationLimitPanel;
	private GridBagConstraints gbc_lblDurationLimit;
	private GridBagConstraints gbc_txtDurationLimit;
	
	private GridBagLayout gbl_ReserveLimitPanel;
	private GridBagConstraints gbc_lblReserveLimit;
	private GridBagConstraints gbc_txtReserveLimit;
	
	private GridBagLayout gbl_PenaltyLimitPanel;
	private GridBagConstraints gbc_lblPenaltyLimit;
	private GridBagConstraints gbc_txtPenaltyLimit;
	
	private GridBagLayout gbl_genrePanel;
	private GridBagConstraints gbc_lblGenre;
	private GridBagConstraints gbc_genreListPanel;
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

 public AdminSettingsPanel(Employee employee, Setting setting) {
	setBackground(lightplainColor);
	setBorder(new EmptyBorder(20, 20, 0, 0));
	setLayout(new BorderLayout(0, 0));
	 
	//create panels
	mainPanel = new JPanel();
//	mainPanel = new BackgroundPanel();
	contentPanel = new JPanel();
	headingPanel = new JPanel();
    accDetailPanel =  new RoundedPanel(20);
    systemPanel =  new RoundedPanel(20);
    genreListPanel =  new RoundedPanel(20);
    genreListPanel.setBorder(new EmptyBorder(5, 10, 0, 10));
    genreListPanel.setBorderWidth(1);
    firstNamePanel = new JPanel();
	lastNamePanel = new JPanel();
	userIDPanel = new JPanel();
	contactNumberPanel = new JPanel();
	homeAddressPanel = new JPanel();
	emailPanel = new JPanel();
	CapacityLimitPanel= new JPanel();
	DurationLimitPanel= new JPanel();
	ReserveLimitPanel= new JPanel();
	PenaltyLimitPanel= new JPanel();
	genrePanel= new JPanel();
    // Set panel properties
	
    mainPanel.setOpaque(false);
    headingPanel.setOpaque(false);
    contentPanel.setOpaque(false);
    accDetailPanel.setOpaque(false);
    systemPanel.setOpaque(false);
    genreListPanel.setOpaque(false);
    CapacityLimitPanel.setOpaque(false);
    DurationLimitPanel.setOpaque(false);
    ReserveLimitPanel.setOpaque(false);
    PenaltyLimitPanel.setOpaque(false);
    genrePanel.setOpaque(false);
    
    firstNamePanel.setOpaque(false);
	lastNamePanel.setOpaque(false);
	userIDPanel.setOpaque(false);
	contactNumberPanel.setOpaque(false);
	homeAddressPanel.setOpaque(false);
	emailPanel.setOpaque(false);
	
    accDetailPanel.setBorder(new EmptyBorder(10, 10, 15, 10));
    systemPanel.setBorder(new EmptyBorder(10, 10, 15, 10));
	mainPanel.setBorder(new EmptyBorder(0, 0, 0, 30));
	headingPanel.setBorder(new EmptyBorder(20, 25, 0, 45));
	contentPanel.setBorder(null);
    accDetailPanel.setBorderWidth(2);
    systemPanel.setBorderWidth(2);

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


	
	btnOptionDetail = new JButton();
	btnOptionDetail.setFocusPainted(false);
	btnOptionDetail.setBorderPainted(false);
	
    btnOptionSystem  = new JButton();
    btnOptionSystem.setFocusPainted(false);
    btnOptionSystem.setBorderPainted(false);
    
	optionDetailItem = new JMenuItem("Edit Information");
	optionSystemItem = new JMenuItem("Edit Information");

    detailPopupMenu = new JPopupMenu();
	detailPopupMenu.add(optionDetailItem);
	
	systemPopupMenu = new JPopupMenu();
	systemPopupMenu.add(optionSystemItem);


	optionIcon = new ImageIcon("img/DashboardFrame/Option.png");    
	iconHeight = (int) (btnOptionDetail.getPreferredSize().getHeight() * 0.5);
    iconWidth = (int) (btnOptionDetail.getPreferredSize().getHeight() * 0.2);
    
    optionIcon = new ImageIcon(optionIcon.getImage().getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH));
    
    btnOptionDetail.setIcon(optionIcon);
    btnOptionDetail.setOpaque(false);
    
    btnOptionSystem.setIcon(optionIcon);
    btnOptionSystem.setOpaque(false);
    
	lblaccDetail = new JLabel("My Details");
	lblaccDetail.setOpaque(false);
	lblaccDetail.setForeground(darkplainColor);
    
	lblFirstName = new JLabel("First Name");
	lblFirstName.setOpaque(false);
	lblFirstName.setForeground(darkplainColor);
	
	txtFirstName = new PlaceholderTextField(employee.getFname());
	txtFirstName.setFocusable(false);
	txtFirstName.setEditable(false);
	txtFirstName.setBorder(null);
	txtFirstName.setOpaque(false);
	txtFirstName.setForeground(darkplainColor);
	
	lblLastName = new JLabel("Last Name");
	lblLastName.setBorder(null);
	lblLastName.setOpaque(false);
	lblLastName.setForeground(darkplainColor);
	
	txtLastName = new PlaceholderTextField(employee.getLname());
	txtLastName.setFocusable(false);
	txtLastName.setEditable(false);
	txtLastName.setOpaque(false);
	txtLastName.setBorder(null);
	txtLastName.setForeground(darkplainColor);
	
	lblUserID = new JLabel("User ID");
	lblUserID.setOpaque(false);
	lblUserID.setForeground(darkplainColor);
	
	txtUserID = new PlaceholderTextField(employee.getEmployee_id());
	txtUserID.setFocusable(false);
	txtUserID.setBorder(null);
	txtUserID.setEditable(false);
	txtUserID.setOpaque(false);
	txtUserID.setForeground(darkplainColor);
	
	lblHomeAddress = new JLabel("Home Address");
	lblHomeAddress.setOpaque(false);
	lblHomeAddress.setForeground(darkplainColor);
	
	txtHomeAddress = new PlaceholderTextField(employee.getAddress());
	txtHomeAddress.setFocusable(false);
	txtHomeAddress.setBorder(null);
	txtHomeAddress.setEditable(false);
	txtHomeAddress.setOpaque(false);
	txtHomeAddress.setForeground(darkplainColor);
	
	lblContactNumber = new JLabel("Contact Number");
	lblContactNumber.setOpaque(false);
	lblContactNumber.setForeground(darkplainColor);
	
	txtContactNumber= new PlaceholderTextField(employee.getContactNum());
	txtContactNumber.setFocusable(false);
	txtContactNumber.setBorder(null);
	txtContactNumber.setEditable(false);
	txtContactNumber.setOpaque(false);
	txtContactNumber.setForeground(darkplainColor);
	
	lblEmailAddress = new JLabel("Email Address");
	lblEmailAddress.setOpaque(false);
	lblEmailAddress.setForeground(darkplainColor);
	
	txtEmailAddress = new PlaceholderTextField(employee.getEmail());
	txtEmailAddress.setFocusable(false);
	txtEmailAddress.setEditable(false);
	txtEmailAddress.setBorder(null);
	txtEmailAddress.setOpaque(false);
	txtEmailAddress.setForeground(darkplainColor);


	lblSystem = new JLabel("System");
	lblSystem.setMinimumSize(new Dimension(66, 16));
	lblSystem.setMaximumSize(new Dimension(66, 16));
	lblSystem.setOpaque(false);
	lblSystem.setForeground(darkplainColor);
	
	lblCapacityLimit = new JLabel("Borrowing Capacity Limit");
	lblCapacityLimit.setOpaque(false);
	lblCapacityLimit.setForeground(darkplainColor);
	
	txtCapacityLimit = new PlaceholderTextField(Integer.toString(setting.getBorrow_lim()));
	txtCapacityLimit.setFocusable(false);
	txtCapacityLimit.setEditable(false);
	txtCapacityLimit.setBorder(null);
	txtCapacityLimit.setOpaque(false);
	txtCapacityLimit.setForeground(darkplainColor);
	
	lblDurationLimit = new JLabel("Borrowing Duration Limit");
	lblDurationLimit.setOpaque(false);
	lblDurationLimit.setForeground(darkplainColor);
	
	txtDurationLimit = new PlaceholderTextField(Integer.toString(setting.getBorrow_duration_lim()));
	txtDurationLimit.setFocusable(false);
	txtDurationLimit.setEditable(false);
	txtDurationLimit.setBorder(null);
	txtDurationLimit.setOpaque(false);
	txtDurationLimit.setForeground(darkplainColor);

	lblReserveLimit = new JLabel("Reserve Limit");
	lblReserveLimit.setOpaque(false);
	lblReserveLimit.setForeground(darkplainColor);
	
	txtReserveLimit = new PlaceholderTextField(Integer.toString(setting.getReserve_lim()));
	txtReserveLimit.setFocusable(false);
	txtReserveLimit.setEditable(false);
	txtReserveLimit.setBorder(null);
	txtReserveLimit.setOpaque(false);
	txtReserveLimit.setForeground(darkplainColor);
	
	lblPenaltyLimit = new JLabel("Penalty Limit");
	lblPenaltyLimit.setOpaque(false);
	lblPenaltyLimit.setForeground(darkplainColor);
	
	txtPenaltyLimit = new PlaceholderTextField(Integer.toString(setting.getPenalty_lim()));
	txtPenaltyLimit.setFocusable(false);
	txtPenaltyLimit.setEditable(false);
	txtPenaltyLimit.setBorder(null);
	txtPenaltyLimit.setOpaque(false);
	txtPenaltyLimit.setForeground(darkplainColor);
	
	
	
	lblGenre = new JLabel("Genre");
	lblGenre.setOpaque(false);
	lblGenre.setForeground(darkplainColor);
	
	 String[] genresArray = {"Classic", "Dystopian", "Epic Poetry", "Fantasy", "Fiction", "Gothic Fiction", 
			"Historical Fiction", "Horror", "Mystery", "Novel","Non-Fiction", "Romance", "Science", "Science Fiction", "Survival", 
			"Thriller", "Young Adult"};

    listModel = new DefaultListModel<>();
    for (String genre : genresArray) {
        listModel.addElement(genre);
    };
    
    genreList = new JList<>(listModel);
    genreList.setVisibleRowCount(7);
    genreList.setBorder(null);
    genreList.setFocusable(false);
    genreList.setOpaque(false);
    genreList.setBackground(new Color(0, 0, 0, 0));;
    genreList.setSelectionModel(new DefaultListSelectionModel() {
        @Override
        public void setSelectionInterval(int index0, int index1) {

        }
    });
    
    
	genreScrollPane  = new JScrollPane(genreList);
	genreScrollPane.setOpaque(false);
	genreScrollPane.getViewport().setOpaque(false);
	genreScrollPane.setBackground(new Color(255, 255, 255));
	genreScrollPane.setBorder(new EmptyBorder(10, 10, 15, 5));
	genreScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	genreScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);


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
	gbl_contentPanel = new GridBagLayout();
	gbl_contentPanel.columnWidths = new int[]{0, 0};
	gbl_contentPanel.rowHeights = new int[]{30};
	gbl_contentPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
	gbl_contentPanel.rowWeights = new double[]{0.0};
    
	gbc_accDetailPanel = new GridBagConstraints();
    gbc_accDetailPanel.fill = GridBagConstraints.BOTH;
    gbc_accDetailPanel.insets = new Insets(15, 0, 25, 0);
    gbc_accDetailPanel.gridx = 0;
    gbc_accDetailPanel.gridy = 0;  	
    

    gbc_systemPanel = new GridBagConstraints();
    gbc_systemPanel.fill = GridBagConstraints.BOTH;
    gbc_systemPanel.insets = new Insets(15, 0, 25, 0);
    gbc_systemPanel.gridx = 0;
    gbc_systemPanel.gridy = 1; 
    
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
    gbc_btnOptionDetail.insets = new Insets(0, 5, 5, 0);
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
	gbl_systemPanel = new GridBagLayout();
	gbl_systemPanel.columnWidths = new int[]{0,0,0};
	gbl_systemPanel.rowHeights = new int[]{66, 0};
	gbl_systemPanel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
	gbl_systemPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
    
    gbc_lblSystem = new GridBagConstraints();
    gbc_lblSystem.fill = GridBagConstraints.HORIZONTAL;
    gbc_lblSystem.insets = new Insets(0, 0, 5, 0);
    gbc_lblSystem.gridx = 0;
    gbc_lblSystem.gridy = 0;
	
    gbc_btnOptionSystem = new GridBagConstraints();
    gbc_btnOptionSystem.anchor = GridBagConstraints.EAST;
    gbc_btnOptionSystem.insets = new Insets(0, 5, 5, 0);
    gbc_btnOptionSystem.gridx = 1;
    gbc_btnOptionSystem.gridy = 0;

    gbc_CapacityLimitPanel = new GridBagConstraints();
    gbc_CapacityLimitPanel.fill = GridBagConstraints.HORIZONTAL;
    gbc_CapacityLimitPanel.anchor = GridBagConstraints.NORTH;
    gbc_CapacityLimitPanel.insets = new Insets(0, 0, 5, 0);
    gbc_CapacityLimitPanel.gridx = 0;
    gbc_CapacityLimitPanel.gridy = 1; 
    
    gbc_DurationLimitPanel = new GridBagConstraints();
    gbc_DurationLimitPanel.fill = GridBagConstraints.HORIZONTAL;
    gbc_DurationLimitPanel.anchor = GridBagConstraints.NORTH;
    gbc_DurationLimitPanel.insets = new Insets(0, 5, 5, 0);
    gbc_DurationLimitPanel.gridx = 1;
    gbc_DurationLimitPanel.gridy = 1 ;
    
    gbc_ReserveLimitPanel = new GridBagConstraints();
    gbc_ReserveLimitPanel.fill = GridBagConstraints.HORIZONTAL;
    gbc_ReserveLimitPanel.anchor = GridBagConstraints.NORTH;
    gbc_ReserveLimitPanel.insets = new Insets(0, 0, 5, 0);
    gbc_ReserveLimitPanel.gridx = 0;
    gbc_ReserveLimitPanel.gridy = 2; 
    
    gbc_PenaltyLimitPanel = new GridBagConstraints();
    gbc_PenaltyLimitPanel.fill = GridBagConstraints.HORIZONTAL;
    gbc_PenaltyLimitPanel.anchor = GridBagConstraints.NORTH;
    gbc_PenaltyLimitPanel.insets = new Insets(0, 5, 5, 0);
    gbc_PenaltyLimitPanel.gridx = 1;
    gbc_PenaltyLimitPanel.gridy = 2; 
    
    gbc_genrePanel = new GridBagConstraints();
    gbc_genrePanel.gridwidth = 2;
    gbc_genrePanel.fill = GridBagConstraints.BOTH;
    gbc_genrePanel.insets = new Insets(15, 0, 25, 0);
    gbc_genrePanel.gridx = 0;
    gbc_genrePanel.gridy = 3;  
    
    //
    
	gbl_CapacityLimitPanel = new GridBagLayout();
	gbl_CapacityLimitPanel.columnWidths = new int[]{491, 0};
	gbl_CapacityLimitPanel.rowHeights = new int[]{30, 30};
	gbl_CapacityLimitPanel.columnWeights = new double[]{1.0};
	gbl_CapacityLimitPanel.rowWeights = new double[]{0.0, 0.0};

	gbc_lblCapacityLimit = new GridBagConstraints();
	gbc_lblCapacityLimit.fill = GridBagConstraints.BOTH;
	gbc_lblCapacityLimit.insets = new Insets(0, 0, 0, 0);
	gbc_lblCapacityLimit.gridx = 0;
	gbc_lblCapacityLimit.gridy = 0; 
	
	gbc_txtCapacityLimit = new GridBagConstraints();
	gbc_txtCapacityLimit.fill = GridBagConstraints.BOTH;
	gbc_txtCapacityLimit.insets = new Insets(0, 0, 0, 0);
	gbc_txtCapacityLimit.gridx = 0;
	gbc_txtCapacityLimit.gridy = 1; 
	
	//
	
	gbl_DurationLimitPanel = new GridBagLayout();
	gbl_DurationLimitPanel.columnWidths = new int[]{491, 0};
	gbl_DurationLimitPanel.rowHeights = new int[]{30, 30};
	gbl_DurationLimitPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
	gbl_DurationLimitPanel.rowWeights = new double[]{0.0, 0.0};
    
	gbc_lblDurationLimit = new GridBagConstraints();
	gbc_lblDurationLimit.fill = GridBagConstraints.BOTH;
	gbc_lblDurationLimit.insets = new Insets(0, 0, 0, 0);
	gbc_lblDurationLimit.gridx = 0;
	gbc_lblDurationLimit.gridy = 0; 
	
	gbc_txtDurationLimit = new GridBagConstraints();
	gbc_txtDurationLimit.fill = GridBagConstraints.BOTH;
	gbc_txtDurationLimit.insets = new Insets(0, 0, 0, 0);
	gbc_txtDurationLimit.gridx = 0;
	gbc_txtDurationLimit.gridy = 1; 
	
	//
	gbl_ReserveLimitPanel = new GridBagLayout();
	gbl_ReserveLimitPanel.columnWidths = new int[]{491, 0};
	gbl_ReserveLimitPanel.rowHeights = new int[]{30, 30};
	gbl_ReserveLimitPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
	gbl_ReserveLimitPanel.rowWeights = new double[]{0.0, 0.0};
    
	gbc_lblReserveLimit = new GridBagConstraints();
	gbc_lblReserveLimit.gridwidth = 4;
	gbc_lblReserveLimit.fill = GridBagConstraints.BOTH;
	gbc_lblReserveLimit.insets = new Insets(0, 0, 0, 0);
	gbc_lblReserveLimit.gridx = 0;
	gbc_lblReserveLimit.gridy = 0; 
	
	gbc_txtReserveLimit = new GridBagConstraints();
	gbc_txtReserveLimit.fill = GridBagConstraints.BOTH;
	gbc_txtReserveLimit.insets = new Insets(0, 0, 0, 0);
	gbc_txtReserveLimit.gridx = 0;
	gbc_txtReserveLimit.gridy = 1; 
	
	//
	
	gbl_PenaltyLimitPanel = new GridBagLayout();
	gbl_PenaltyLimitPanel.columnWidths = new int[]{380, 0};
	gbl_PenaltyLimitPanel.rowHeights = new int[]{30, 30};
	gbl_PenaltyLimitPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
	gbl_PenaltyLimitPanel.rowWeights = new double[]{0.0, 0.0};
    
	gbc_lblPenaltyLimit = new GridBagConstraints();
	gbc_lblPenaltyLimit.gridwidth = 4;
	gbc_lblPenaltyLimit.fill = GridBagConstraints.BOTH;
	gbc_lblPenaltyLimit.insets = new Insets(0,0,0,0);
	gbc_lblPenaltyLimit.gridx = 0;
	gbc_lblPenaltyLimit.gridy = 0; 
	
	gbc_txtPenaltyLimit = new GridBagConstraints();
	gbc_txtPenaltyLimit.fill = GridBagConstraints.BOTH;
	gbc_txtPenaltyLimit.insets = new Insets(0, 0, 0, 0);
	gbc_txtPenaltyLimit.gridx = 0;
	gbc_txtPenaltyLimit.gridy = 1; 
	
	//
	gbl_genrePanel = new GridBagLayout();
	gbl_genrePanel.columnWidths = new int[]{380, 0};
	gbl_genrePanel.rowHeights = new int[]{30, 30};
	gbl_genrePanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
	gbl_genrePanel.rowWeights = new double[]{0.0, 0.0};
	
	gbc_lblGenre = new GridBagConstraints();
	gbc_lblGenre.anchor = GridBagConstraints.WEST;
	gbc_lblGenre.insets = new Insets(0, 0, 5,5);	    
	gbc_lblGenre.gridx = 0;
	gbc_lblGenre.gridy = 0;

	gbc_genreListPanel = new GridBagConstraints();
	gbc_genreListPanel.fill = GridBagConstraints.BOTH;
	gbc_genreListPanel.gridx = 0;
	gbc_genreListPanel.gridy = 1;
	
    // Set panel layouts
    mainPanel.setLayout(new BorderLayout(0,0));
    headingPanel.setLayout(new BoxLayout(headingPanel, BoxLayout.X_AXIS));
    contentPanel.setLayout(gbl_contentPanel);
    accDetailPanel.setLayout(gbl_accDetailPanel);
    firstNamePanel.setLayout(gbl_firstNamePanel);
	lastNamePanel.setLayout(gbl_lastNamePanel);
	userIDPanel.setLayout(gbl_userIDPanel);
	contactNumberPanel.setLayout(gbl_contactNumberPanel);
	homeAddressPanel.setLayout(gbl_homeAddressPanel);
	emailPanel.setLayout(gbl_emailPanel);
	
    systemPanel.setLayout(gbl_systemPanel);
    CapacityLimitPanel.setLayout(gbl_CapacityLimitPanel);
    DurationLimitPanel.setLayout(gbl_DurationLimitPanel);
    ReserveLimitPanel.setLayout(gbl_ReserveLimitPanel);
    PenaltyLimitPanel.setLayout(gbl_PenaltyLimitPanel);
    genrePanel.setLayout(gbl_genrePanel);
	genreListPanel.setLayout(new BorderLayout(0, 0));

    
    //add panels
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
	
	CapacityLimitPanel.add(lblCapacityLimit,gbc_lblCapacityLimit);
	CapacityLimitPanel.add(txtCapacityLimit,gbc_txtCapacityLimit);
	DurationLimitPanel.add(lblDurationLimit,gbc_lblDurationLimit);
	DurationLimitPanel.add(txtDurationLimit,gbc_txtDurationLimit);
	ReserveLimitPanel.add(lblReserveLimit,gbc_lblReserveLimit);
	ReserveLimitPanel.add(txtReserveLimit,gbc_txtReserveLimit);
	PenaltyLimitPanel.add(lblPenaltyLimit,gbc_lblPenaltyLimit);
	PenaltyLimitPanel.add(txtPenaltyLimit,gbc_txtPenaltyLimit);
	genrePanel.add(lblGenre,gbc_lblGenre);
	genrePanel.add(genreListPanel,gbc_genreListPanel);
	genreListPanel.add(genreScrollPane);
	
	
	accDetailPanel.add(lblaccDetail, gbc_lblaccDetail);
	accDetailPanel.add(btnOptionDetail, gbc_btnOptionDetail);
    accDetailPanel.add(firstNamePanel, gbc_firstNamePanel);
	accDetailPanel.add(lastNamePanel, gbc_lastNamePanel);
	accDetailPanel.add(userIDPanel, gbc_userIDPanel);
	accDetailPanel.add(contactNumberPanel, gbc_contactNumberPanel);
	accDetailPanel.add(homeAddressPanel, gbc_homeAddressPanel);
	accDetailPanel.add(emailPanel, gbc_emailPanel);
    
	
    systemPanel.add(lblSystem,gbc_lblSystem);
    systemPanel.add(btnOptionSystem,gbc_btnOptionSystem);
    systemPanel.add(CapacityLimitPanel,gbc_CapacityLimitPanel);
    systemPanel.add(DurationLimitPanel,gbc_DurationLimitPanel);
    systemPanel.add(ReserveLimitPanel,gbc_ReserveLimitPanel);
    systemPanel.add(PenaltyLimitPanel,gbc_PenaltyLimitPanel);
    systemPanel.add(genrePanel,gbc_genrePanel);
    
    contentPanel.add(accDetailPanel,gbc_accDetailPanel);
    contentPanel.add(systemPanel,gbc_systemPanel);
    
    mainPanel.add(contentPanel, BorderLayout.NORTH);
	add(headingPanel, BorderLayout.NORTH);
	add(settingScrollPane, BorderLayout.CENTER);

	addComponentListener(new ComponentAdapter() {
  	  @Override
        public void componentResized(ComponentEvent e) {
	      	titleTextSize = Math.min(getHeight() / 12, getWidth()/ 14) ;
	        subtitleTextSize =  Math.min(getHeight() / 40, getWidth()/ 40);
	        buttonTextSize =  Math.min(getHeight() / 80, getWidth()/ 80);
	        headerTextSize =   Math.min(getHeight() / 30, getWidth()/ 35);
	        plainTextsize=   Math.min(getHeight() / 70, getWidth()/ 70);
	            
	        titleFont = new Font("Montserrat", Font.BOLD, titleTextSize);
			subtitleFont = new Font("Montserrat", Font.BOLD, subtitleTextSize);
	        buttonFont = new Font("Montserrat", Font.ITALIC, buttonTextSize);
	     	headerFont = new Font("Montserrat", Font.PLAIN, headerTextSize);
			plainFont = new Font("Montserrat", Font.ITALIC | Font.BOLD, plainTextsize);
			
	     	lblHeading1.setFont(new Font("Montserrat", Font.BOLD, headerTextSize));
	     	lblHeading2.setFont(new Font("Montserrat", Font.PLAIN, headerTextSize));
	        lblaccDetail.setFont(subtitleFont);    
	        lblSystem.setFont(subtitleFont);    
			lblFirstName.setFont(plainFont);
			lblLastName.setFont(plainFont);
			lblUserID.setFont(plainFont);
			lblHomeAddress.setFont(plainFont);
			lblContactNumber.setFont(plainFont);
			lblEmailAddress.setFont(plainFont);
			
			lblCapacityLimit.setFont(plainFont);
			lblReserveLimit.setFont(plainFont);
			lblDurationLimit.setFont(plainFont);
			lblPenaltyLimit.setFont(plainFont);
		    lblGenre.setFont(plainFont);
		    genreList.setFont(buttonFont);

			}
    });
	
	//action Listeners
	btnOptionDetail.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent ev) {
	    	detailPopupMenu.show(btnOptionDetail, btnOptionDetail.getBounds().x, btnOptionDetail.getBounds().y
	           + btnOptionDetail.getBounds().height);
	    }
	});
	optionDetailItem.addMouseListener(new MouseAdapter() {
	    public void mousePressed(MouseEvent e) {
	    	JFrame parentFrame = (JFrame) SwingUtilities.windowForComponent(optionDetailItem);

	    	AccountInfoPanel panel = new AccountInfoPanel(employee, parentFrame);
	    	showDialog(panel);
	    }
	});
	
	btnOptionSystem.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent ev) {
	    	systemPopupMenu.show(btnOptionSystem, btnOptionSystem.getBounds().x, btnOptionSystem.getBounds().y
	           + btnOptionSystem.getBounds().height);
	    }
	});
	optionSystemItem.addMouseListener(new MouseAdapter() {
	    public void mousePressed(MouseEvent e) {
	    	//punta info display frame, System Information
	    	System.out.println("Clicked UwU");
	    }
	});
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