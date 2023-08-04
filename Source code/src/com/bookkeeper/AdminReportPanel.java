package com.bookkeeper;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.DefaultXYDataset;


public class AdminReportPanel extends JPanel {
	//panel
	private JPanel mainPanel;
	private JPanel headingPanel;
	
	private JPanel overviewPanel;
	private RoundedPanel bookLoanedPanel;
	private RoundedPanel overduePanel;
	
	private RoundedPanel activeUserPanel;
	private RoundedPanel reserveBookPanel;
	private RoundedPanel loanPanel;
	private RoundedPanel returnBookPanel;
	private RoundedPanel bookCopyPanel;
	private RoundedPanel monthComparisonPanel;
	private RoundedPanel genreCopyPanel;
	
	private JPanel genreGraphPanel;
	private JPanel comparisonGraphPanel;

	//chart
	private CreateLineChart createLineChart;
	private CreatePieChart createPieChart;
	private ChartPanel lineChartPanel ;
	private ChartPanel pieChartPanel ;
	private JFreeChart lineChart;
	private JFreeChart pieChart;

	//label
	private JLabel lblHeading1;
	private JLabel lblHeading2;
	
	private JLabel lblMonthOverview;
	private JLabel lblActiveUser;
	private JLabel lblReserveBook;
	private JLabel lblLoan;
	private JLabel lblReturnBook;
	private JLabel lblBookCopy;
	private JLabel lblMonthComparison;
	private JLabel lblGenreCopy;
	private JLabel lblBookLoan;
	private JLabel lblBookOverdue;

	private JLabel lblLegend1;
	private JLabel lblLegend2;

	//textfield
	private PlaceholderTextField txtActiveUser;
	private PlaceholderTextField txtReserveBook;
	private PlaceholderTextField txtLoan;	
	private PlaceholderTextField txtReturnBook;
	private PlaceholderTextField txtBookCopy;
	
	//layout
	private GridBagLayout gbl_mainPanel;
	private GridBagConstraints gbc_overviewPanel;
	private GridBagConstraints gbc_bookLoanedPanel;
	private GridBagConstraints gbc_overduePanel;
	
	private GridBagLayout gbl_overviewPanel;
	private GridBagConstraints gbc_lblMonthOverview;
	private GridBagConstraints gbc_btnOptionDetail;
	private GridBagConstraints gbc_activeUserPanel;
	private GridBagConstraints gbc_reserveBookPanel;
	private GridBagConstraints gbc_loanPanel;
	private GridBagConstraints gbc_returnBookPanel;
	private GridBagConstraints gbc_bookCopyPanel;
	private GridBagConstraints gbc_monthComparisonPanel;
	private GridBagConstraints gbc_genreCopyPanel;
	
	private GridBagConstraints gbc_lblBookLoan	;
	private GridBagConstraints gbc_bookLoanedScrollPane;
	private GridBagLayout  gbl_bookLoanedPanel;
	
	private GridBagConstraints gbc_lblBookOverdue;
	private GridBagConstraints gbc_overdueScrollPane;
	private GridBagLayout  gbl_bookOverduePanel;
	
	private GridBagLayout  gbl_genreCopyPanel;
	private GridBagConstraints  gbc_lblGenreCopyComparison;
	private GridBagConstraints  gbc_genreGraphPanel;
	
	private GridBagLayout  gbl_monthComparisonPanel;
	private GridBagConstraints  gbc_lblMonthComparison;
	private GridBagConstraints  gbc_comparisonGraphPanel;

	//scrollpane
	private JScrollPane reportScrollPane;
	private JScrollPane bookLoanedScrollPane;
	private JScrollPane overdueScrollPane;
	
	//Table
	private JTable bookLoanTable;
	private JTable overdueTable;
	private DefaultTableModel bookLoanTableModel;
	private DefaultTableModel overdueTableModel;
	

	//button
	private JButton btnOptionDetail;
	
	//menu
	private JMenuItem option1;
	private JPopupMenu detailPopupMenu;
	
	private ImageIcon optionIcon;
	private int iconHeight;
	private int iconWidth;
	
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
	private  Color greenColor = new Color(11, 130, 87);//green
	private  Color redColor = new Color(182, 32, 68);//red
	private  Color headerColor = new Color(23, 21, 147);//blue
	private  Color darkplainColor = new Color(14, 14, 15);//black
	private  Color lightplainColor = new Color(250, 251, 255);//white
	private  Color middleplainColor = new Color(243, 243, 247);//dirty white

	public AdminReportPanel() {
	setBackground(lightplainColor);
	setBorder(new EmptyBorder(20, 20, 20, 0));
	setLayout(new BorderLayout(0, 0));
		 
	//create panels
	 mainPanel = new JPanel();
	 headingPanel = new JPanel();
	 overviewPanel = new JPanel();
	 bookLoanedPanel = new RoundedPanel(20);
	 overduePanel = new RoundedPanel(20);
	 
	activeUserPanel = new RoundedPanel(20);
	reserveBookPanel = new RoundedPanel(20);
	loanPanel = new RoundedPanel(20);
	returnBookPanel = new RoundedPanel(20);
	bookCopyPanel = new RoundedPanel(20);
	monthComparisonPanel = new RoundedPanel(20);
	genreCopyPanel = new RoundedPanel(20);
	
	comparisonGraphPanel = new JPanel();

	genreGraphPanel = new JPanel();

    // Set panel properties
    mainPanel.setOpaque(false);
    headingPanel.setOpaque(false);
    overviewPanel.setOpaque(false);
    bookLoanedPanel.setOpaque(false);
    overduePanel.setOpaque(false);
    activeUserPanel.setOpaque(false);
    reserveBookPanel.setOpaque(false);
    loanPanel.setOpaque(false);
    returnBookPanel.setOpaque(false);
    bookCopyPanel.setOpaque(false);
    monthComparisonPanel.setOpaque(false);
    genreCopyPanel.setOpaque(false);
    comparisonGraphPanel.setOpaque(false);
	genreGraphPanel.setOpaque(false);

	mainPanel.setBorder(new EmptyBorder(0, 0, 0, 30));
	headingPanel.setBorder(new EmptyBorder(20, 25, 0, 45));
	overviewPanel.setBorder(new EmptyBorder(10, 0, 15, 0));
	bookLoanedPanel.setBorder(new EmptyBorder(10, 10, 15, 10));
	overduePanel.setBorder(new EmptyBorder(10, 10, 15, 10));
	
	activeUserPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
	reserveBookPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
	loanPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
	returnBookPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
	bookCopyPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
	monthComparisonPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
	genreCopyPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

    activeUserPanel.setBorderWidth(2);
    reserveBookPanel.setBorderWidth(2);
    loanPanel.setBorderWidth(2);
    returnBookPanel.setBorderWidth(2);
    bookCopyPanel.setBorderWidth(2);
    monthComparisonPanel.setBorderWidth(2);
    genreCopyPanel.setBorderWidth(2);
    bookLoanedPanel.setBorderWidth(2);
    overduePanel.setBorderWidth(2);


    reportScrollPane  = new JScrollPane(mainPanel);
    reportScrollPane.setOpaque(false);
    reportScrollPane.getViewport().setOpaque(false);
    reportScrollPane.setBackground(new Color(255, 255, 255));
    reportScrollPane.setBorder(new EmptyBorder(0, 25, 0, 0));
    reportScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    reportScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    
	lblHeading1 = new JLabel("Dashboard ");
	lblHeading1.setOpaque(false);
	 
	lblHeading2 = new JLabel("/ Reports");
	lblHeading2.setOpaque(false);
	
	lblMonthOverview = new JLabel("Monthly Overview");
	lblMonthOverview.setOpaque(false);
	lblMonthOverview.setForeground(darkplainColor);

	
	btnOptionDetail = new JButton();
	btnOptionDetail.setFocusPainted(false);
	btnOptionDetail.setBorderPainted(false);
	
	option1 = new JMenuItem("Print Report");

    detailPopupMenu = new JPopupMenu();
	
	detailPopupMenu.add(option1);

	optionIcon = new ImageIcon("img/DashboardFrame/Option.png");    
	iconHeight = (int) (btnOptionDetail.getPreferredSize().getHeight() * 0.5);
    iconWidth = (int) (btnOptionDetail.getPreferredSize().getHeight() * 0.2);
    optionIcon = new ImageIcon(optionIcon.getImage().getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH));
    btnOptionDetail.setIcon(optionIcon);
    btnOptionDetail.setOpaque(false);
    
	
	lblActiveUser = new JLabel("Active Users");
	lblActiveUser.setOpaque(false);

	txtActiveUser = new PlaceholderTextField("000");
	txtActiveUser.setFocusable(false);
	txtActiveUser.setEditable(false);
	txtActiveUser.setOpaque(false);
	txtActiveUser.setBorder(null);
	txtActiveUser.setForeground(darkplainColor);
	
	
	lblReserveBook = new JLabel("Books Reserved");
	lblReserveBook.setOpaque(false);

	txtReserveBook = new PlaceholderTextField("000");
	txtReserveBook.setFocusable(false);
	txtReserveBook.setEditable(false);
	txtReserveBook.setOpaque(false);
	txtReserveBook.setBorder(null);
	txtReserveBook.setForeground(darkplainColor);
	
	lblLoan = new JLabel("Books Loaned");
	lblLoan.setOpaque(false);

	txtLoan = new PlaceholderTextField("000");
	txtLoan.setFocusable(false);
	txtLoan.setEditable(false);
	txtLoan.setOpaque(false);
	txtLoan.setBorder(null);
	txtLoan.setForeground(darkplainColor);
	
	lblReturnBook = new JLabel("Books Returned");
	lblReturnBook.setOpaque(false);

	txtReturnBook = new PlaceholderTextField("000");
	txtReturnBook.setFocusable(false);
	txtReturnBook.setEditable(false);
	txtReturnBook.setOpaque(false);
	txtReturnBook.setBorder(null);
	txtReturnBook.setForeground(darkplainColor);
	
	lblBookCopy = new JLabel("Book Copies");
	lblBookCopy.setOpaque(false);

	txtBookCopy = new PlaceholderTextField("000");
	txtBookCopy.setFocusable(false);
	txtBookCopy.setEditable(false);
	txtBookCopy.setOpaque(false);
	txtBookCopy.setBorder(null);
	txtBookCopy.setForeground(darkplainColor);	
	
	lblMonthComparison = new JLabel("Monthly Comparison");
	lblMonthComparison.setOpaque(false);
	
    createLineChart = new CreateLineChart("","Months","Number of Books");

	//add fixed values for now 
    int[] reserved = {0,5,0,3,0,2,0,3,0,4,0,2};
    int[] borrowed = {0,0,0,0,0,0,0,0,0,0,0,0};
    int[] returned = {0,0,6,0,1,0,0,0,9,0,0,0};

    String[] monthsArray = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
   
    createLineChart.addData(monthsArray, reserved, "Reserved");
    createLineChart.addData(monthsArray, borrowed, "Borrowed");
    createLineChart.addData(monthsArray, returned, "Returned");
    
    
    createLineChart.setSeriesPaint("Reserved",greenColor);
    createLineChart.setSeriesPaint("Borrowed",headerColor);
    createLineChart.setSeriesPaint("Returned",redColor);
    
    createLineChart.setSeriesStroke("Reserved",new BasicStroke(3.0f));
    createLineChart.setSeriesStroke("Borrowed",new BasicStroke(3.0f));
    createLineChart.setSeriesStroke("Returned",new BasicStroke(3.0f));

    lineChart = createLineChart.getLineChart();
    lineChartPanel = new ChartPanel(lineChart);
    lineChartPanel.setFocusable(false);
    lineChartPanel.setOpaque(false);
    lineChartPanel.setDisplayToolTips(false);

	
	lblGenreCopy = new JLabel("Copies Per Genre");
	lblGenreCopy.setOpaque(false);
	
    createPieChart = new CreatePieChart("");

	String[] genresArray = {"Classic", "Dystopian", "Epic Poetry", "Fantasy", "Fiction", "Gothic Fiction", 
			"Historical Fiction", "Horror", "Mystery", "Novel", "Science", "Science Fiction", "Survival", 
			"Thriller", "Young Adult"};
	
	//add fixed values for now 
    int[] copyArrray = {11,51,60,3,10,21,31,13,10,41,20,22,14,10,30};

	createPieChart.addData(genresArray,copyArrray);
	
    pieChart = createPieChart.getPieChart();
    pieChartPanel = new ChartPanel(pieChart);
    pieChartPanel.setOpaque(false);
    pieChartPanel.setDisplayToolTips(false);

	
	lblBookLoan = new JLabel("Books Loaned");
	lblBookLoan.setOpaque(false);

	bookLoanTableModel = new DefaultTableModel();
	bookLoanTable = new JTable(bookLoanTableModel) {
		// Override isCellEditable method to make cells not editable
		@Override
		public boolean isCellEditable(int row, int column) {
		      return false;
		}
	};
	bookLoanTable.setBackground(lightplainColor);;
	bookLoanTable.setFillsViewportHeight(true);
	bookLoanTable.setOpaque(false);
	bookLoanTable.setShowVerticalLines(false);
	bookLoanTable.setRowHeight(45);
	bookLoanTable.getTableHeader().setOpaque(false);
	bookLoanTable.setGridColor(darkplainColor);
	bookLoanTable.getTableHeader().setDefaultRenderer(new headerRenderer());
	bookLoanTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

	
	bookLoanedScrollPane  = new JScrollPane();
	bookLoanedScrollPane.setOpaque(false);
	bookLoanedScrollPane.getViewport().setOpaque(false);
	bookLoanedScrollPane.setBackground(new Color(255, 255, 255));
	bookLoanedScrollPane.setBorder(new EmptyBorder(0, 25, 0, 0));
	bookLoanedScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	bookLoanedScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	bookLoanedScrollPane.setViewportView(bookLoanTable);
    
	lblBookOverdue = new JLabel("Books Overdue");
	lblBookOverdue.setOpaque(false);

	overdueTableModel = new DefaultTableModel();
	overdueTable = new JTable(overdueTableModel) {
		// Override isCellEditable method to make cells not editable
		@Override
		public boolean isCellEditable(int row, int column) {
		      return false;
		}
	};
	overdueTable.setBackground(lightplainColor);;
	overdueTable.setFillsViewportHeight(true);
	overdueTable.setOpaque(false);
	overdueTable.setShowVerticalLines(false);
	overdueTable.setRowHeight(45);
	overdueTable.getTableHeader().setOpaque(false);
	overdueTable.setGridColor(darkplainColor);
	overdueTable.getTableHeader().setDefaultRenderer(new headerRenderer());
	overdueTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

	
	overdueScrollPane  = new JScrollPane();
	overdueScrollPane.setOpaque(false);
	overdueScrollPane.getViewport().setOpaque(false);
	overdueScrollPane.setBackground(new Color(255, 255, 255));
	overdueScrollPane.setBorder(new EmptyBorder(0, 25, 0, 0));
	overdueScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	overdueScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	overdueScrollPane.setViewportView(overdueTable);
	
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
	gbl_mainPanel.columnWidths = new int[]{0};
	gbl_mainPanel.rowHeights = new int[]{33, 33, 33};
	gbl_mainPanel.columnWeights = new double[]{1.0};
	gbl_mainPanel.rowWeights = new double[]{0.0, 0.0, 0.0};
	

	gbc_overviewPanel = new GridBagConstraints();
	gbc_overviewPanel.fill = GridBagConstraints.BOTH;
	gbc_overviewPanel.insets = new Insets(15, 0, 25, 0);
	gbc_overviewPanel.gridx = 0;
	gbc_overviewPanel.gridy = 0;  	
	    
	gbc_bookLoanedPanel = new GridBagConstraints();
	gbc_bookLoanedPanel.fill = GridBagConstraints.BOTH;
	gbc_bookLoanedPanel.insets = new Insets(15, 0, 25, 0);
	gbc_bookLoanedPanel.gridx = 0;
	gbc_bookLoanedPanel.gridy = 1; 
	
	gbc_overduePanel = new GridBagConstraints();
	gbc_overduePanel.fill = GridBagConstraints.BOTH;
	gbc_overduePanel.insets = new Insets(15, 0, 25, 0);
	gbc_overduePanel.gridx = 0;
	gbc_overduePanel.gridy = 2; 
	    
	//
	gbl_overviewPanel = new GridBagLayout();
	gbl_overviewPanel.columnWidths = new int[]{0,0,0, 0};
	gbl_overviewPanel.rowHeights = new int[]{0, 0, 0};
	gbl_overviewPanel.columnWeights = new double[]{1.0, 1.0,1.0,1.0,Double.MIN_VALUE};
	gbl_overviewPanel.rowWeights = new double[]{0.0, 0.0, 0.0};
		
	gbc_lblMonthOverview = new GridBagConstraints();
	gbc_lblMonthOverview.fill = GridBagConstraints.HORIZONTAL;
	gbc_lblMonthOverview.insets = new Insets(0, 0, 5, 5);
	gbc_lblMonthOverview.gridx = 0;
	gbc_lblMonthOverview.gridy = 0;
	
    gbc_btnOptionDetail = new GridBagConstraints();
    gbc_btnOptionDetail.anchor = GridBagConstraints.EAST;
    gbc_btnOptionDetail.insets = new Insets(0, 5, 5, 0);
    gbc_btnOptionDetail.gridx = 1;
    gbc_btnOptionDetail.gridy = 0;
	
	gbc_activeUserPanel = new GridBagConstraints();
	gbc_activeUserPanel.fill = GridBagConstraints.BOTH;
	gbc_activeUserPanel.insets = new Insets(15, 0, 25, 10);
	gbc_activeUserPanel.gridx = 0;
	gbc_activeUserPanel.gridy = 1;  	
	    
	gbc_reserveBookPanel = new GridBagConstraints();
	gbc_reserveBookPanel.fill = GridBagConstraints.BOTH;
	gbc_reserveBookPanel.insets = new Insets(15, 0, 25, 10);
	gbc_reserveBookPanel.gridx = 1;
	gbc_reserveBookPanel.gridy = 1; 
	
	gbc_loanPanel = new GridBagConstraints();
	gbc_loanPanel.fill = GridBagConstraints.BOTH;
	gbc_loanPanel.insets = new Insets(15, 0, 25, 10);
	gbc_loanPanel.gridx = 2;
	gbc_loanPanel.gridy = 1; 
	
	gbc_returnBookPanel = new GridBagConstraints();
	gbc_returnBookPanel.fill = GridBagConstraints.BOTH;
	gbc_returnBookPanel.insets = new Insets(15, 0, 25, 10);
	gbc_returnBookPanel.gridx = 3;
	gbc_returnBookPanel.gridy = 1; 
	
	gbc_bookCopyPanel = new GridBagConstraints();
	gbc_bookCopyPanel.fill = GridBagConstraints.BOTH;
	gbc_bookCopyPanel.insets = new Insets(15, 0, 25, 0);
	gbc_bookCopyPanel.gridx = 4;
	gbc_bookCopyPanel.gridy = 1; 
	
	gbc_monthComparisonPanel = new GridBagConstraints();
	gbc_monthComparisonPanel.gridwidth = 5;
	gbc_monthComparisonPanel.fill = GridBagConstraints.BOTH;
	gbc_monthComparisonPanel.insets = new Insets(15, 0, 25, 0);
	gbc_monthComparisonPanel.gridx = 0;
	gbc_monthComparisonPanel.gridy = 2; 
	
	gbc_genreCopyPanel = new GridBagConstraints();
	gbc_genreCopyPanel.gridwidth = 5;
	gbc_genreCopyPanel.fill = GridBagConstraints.BOTH;
	gbc_genreCopyPanel.insets = new Insets(15, 0, 25, 0);
	gbc_genreCopyPanel.gridx = 0;
	gbc_genreCopyPanel.gridy = 3; 
	
	//
	
	gbl_bookLoanedPanel = new GridBagLayout();
	gbl_bookLoanedPanel.columnWidths = new int[]{316, 0};
	gbl_bookLoanedPanel.rowHeights = new int[]{66, 0};
	gbl_bookLoanedPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
	gbl_bookLoanedPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};

	gbc_lblBookLoan = new GridBagConstraints();
	gbc_lblBookLoan.anchor = GridBagConstraints.WEST;
	gbc_lblBookLoan.insets = new Insets(0, 0, 5,5);
	gbc_lblBookLoan.gridx = 0;
	gbc_lblBookLoan.gridy = 0;

	gbc_bookLoanedScrollPane = new GridBagConstraints();
	gbc_bookLoanedScrollPane.fill = GridBagConstraints.BOTH;
	gbc_bookLoanedScrollPane.gridx = 0;
	gbc_bookLoanedScrollPane.gridy = 1;
	    
	 //
	
	gbl_bookOverduePanel = new GridBagLayout();
	gbl_bookOverduePanel.columnWidths = new int[]{316, 0};
	gbl_bookOverduePanel.rowHeights = new int[]{66, 0};
	gbl_bookOverduePanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
	gbl_bookOverduePanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};

	gbc_lblBookOverdue = new GridBagConstraints();
	gbc_lblBookOverdue.anchor = GridBagConstraints.WEST;
	gbc_lblBookOverdue.insets = new Insets(0, 0, 5,5);
	gbc_lblBookOverdue.gridx = 0;
	gbc_lblBookOverdue.gridy = 0;

	gbc_overdueScrollPane = new GridBagConstraints();
	gbc_overdueScrollPane.fill = GridBagConstraints.BOTH;
	gbc_overdueScrollPane.gridx = 0;
	gbc_overdueScrollPane.gridy = 1;
	    
	 //
	
	gbl_monthComparisonPanel = new GridBagLayout();
	gbl_monthComparisonPanel.columnWidths = new int[]{316, 0};
	gbl_monthComparisonPanel.rowHeights = new int[]{66, 0};
	gbl_monthComparisonPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
	gbl_monthComparisonPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};

	gbc_lblMonthComparison = new GridBagConstraints();
	gbc_lblMonthComparison.gridwidth = 2;
	gbc_lblMonthComparison.anchor = GridBagConstraints.WEST;
	gbc_lblMonthComparison.insets = new Insets(0, 0, 5,5);
	gbc_lblMonthComparison.gridx = 0;
	gbc_lblMonthComparison.gridy = 0;

	gbc_comparisonGraphPanel = new GridBagConstraints();
	gbc_comparisonGraphPanel.fill = GridBagConstraints.BOTH;
	gbc_comparisonGraphPanel.gridx = 0;
	gbc_comparisonGraphPanel.gridy = 1;
	


    
 //

	gbl_genreCopyPanel = new GridBagLayout();
	gbl_genreCopyPanel.columnWidths = new int[]{316, 0};
	gbl_genreCopyPanel.rowHeights = new int[]{66, 0};
	gbl_genreCopyPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
	gbl_genreCopyPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};

	gbc_lblGenreCopyComparison = new GridBagConstraints();
	gbc_lblGenreCopyComparison.gridwidth = 2;
	gbc_lblGenreCopyComparison.anchor = GridBagConstraints.WEST;
	gbc_lblGenreCopyComparison.insets = new Insets(0, 0, 5,5);
	gbc_lblGenreCopyComparison.gridx = 0;
	gbc_lblGenreCopyComparison.gridy = 0;

	gbc_genreGraphPanel = new GridBagConstraints();
	gbc_genreGraphPanel.fill = GridBagConstraints.BOTH;
	gbc_genreGraphPanel.gridx = 0;
	gbc_genreGraphPanel.gridy = 1;




	// Set panel layouts
    mainPanel.setLayout(gbl_mainPanel);
    headingPanel.setLayout(new BoxLayout(headingPanel, BoxLayout.X_AXIS));
	overviewPanel.setLayout(gbl_overviewPanel);
	overviewPanel.setLayout(gbl_overviewPanel);
	bookLoanedPanel.setLayout(gbl_bookLoanedPanel);
	overduePanel.setLayout(gbl_bookOverduePanel);
	
	
	activeUserPanel.setLayout(new GridLayout(2,0,0,0));
	reserveBookPanel.setLayout(new GridLayout(2,0,0,0));
	loanPanel.setLayout(new GridLayout(2,0,0,0));
	returnBookPanel.setLayout(new GridLayout(2,0,0,0));
	bookCopyPanel.setLayout(new GridLayout(2,0,0,0));
	comparisonGraphPanel.setLayout(new BorderLayout(0,0));
	genreCopyPanel.setLayout(new BorderLayout(0,0));
    monthComparisonPanel.setLayout(gbl_monthComparisonPanel);
    genreCopyPanel.setLayout(gbl_genreCopyPanel);

	headingPanel.add(lblHeading1);
	headingPanel.add(lblHeading2);
    activeUserPanel.add(lblActiveUser);
    activeUserPanel.add(txtActiveUser);
    reserveBookPanel.add(lblReserveBook);
    reserveBookPanel.add(txtReserveBook);
    loanPanel.add(lblLoan);
    loanPanel.add(txtLoan);
    returnBookPanel.add(lblReturnBook);
    returnBookPanel.add(txtReturnBook);
    bookCopyPanel.add(lblBookCopy);
    bookCopyPanel.add(txtBookCopy);
    
    comparisonGraphPanel.add(lineChartPanel, BorderLayout.CENTER);
   
    genreGraphPanel.add(pieChartPanel, BorderLayout.CENTER);
    
    monthComparisonPanel.add(lblMonthComparison,gbc_lblMonthComparison);
    monthComparisonPanel.add(comparisonGraphPanel,gbc_comparisonGraphPanel);

    genreCopyPanel.add(lblGenreCopy,gbc_lblGenreCopyComparison);
    genreCopyPanel.add(genreGraphPanel,gbc_genreGraphPanel);
    
    bookLoanedPanel.add(lblBookLoan,gbc_lblBookLoan);
    bookLoanedPanel.add(bookLoanedScrollPane,gbc_bookLoanedScrollPane);
    overduePanel.add(lblBookOverdue,gbc_lblBookOverdue);
    overduePanel.add(overdueScrollPane,gbc_overdueScrollPane);
    
    overviewPanel.add(lblMonthOverview,gbc_lblMonthOverview);
    overviewPanel.add(activeUserPanel,gbc_activeUserPanel);
    overviewPanel.add(reserveBookPanel,gbc_reserveBookPanel);
    overviewPanel.add(loanPanel,gbc_loanPanel);
    overviewPanel.add(returnBookPanel,gbc_returnBookPanel);
    overviewPanel.add(bookCopyPanel,gbc_bookCopyPanel);
    overviewPanel.add(monthComparisonPanel,gbc_monthComparisonPanel);
    overviewPanel.add(genreCopyPanel,gbc_genreCopyPanel);
    
	mainPanel.add(overviewPanel,gbc_overviewPanel);
	mainPanel.add(bookLoanedPanel,gbc_bookLoanedPanel);
	mainPanel.add(overduePanel,gbc_overduePanel);

	add(headingPanel, BorderLayout.NORTH);
	add(reportScrollPane, BorderLayout.CENTER);
	addComponentListener(new ComponentAdapter() {
	  	  @Override
	        public void componentResized(ComponentEvent e) {
		      	titleTextSize = Math.min(getHeight() / 12, getWidth()/ 14) ;
		        subtitleTextSize =  Math.min(getHeight() / 40, getWidth()/ 40);
		        buttonTextSize =  Math.min(getHeight() / 80, getWidth()/ 80);
		        headerTextSize =   Math.min(getHeight() / 30, getWidth()/ 35);
		        plainTextsize=   Math.min(getHeight() / 60, getWidth()/ 60);
		            
		        titleFont = new Font("Montserrat", Font.BOLD, titleTextSize);
				subtitleFont = new Font("Montserrat", Font.BOLD, subtitleTextSize);
		        buttonFont = new Font("Montserrat", Font.ITALIC, buttonTextSize);
		     	headerFont = new Font("Montserrat", Font.BOLD, headerTextSize);
				plainFont = new Font("Montserrat", Font.PLAIN, plainTextsize);
				
		     	lblHeading1.setFont(new Font("Montserrat", Font.BOLD, headerTextSize));
		     	lblHeading2.setFont(new Font("Montserrat", Font.PLAIN, headerTextSize));
		     	lblActiveUser.setFont(plainFont);    
		        lblReserveBook.setFont(plainFont);
				lblLoan.setFont(plainFont);
				lblReturnBook.setFont(plainFont);
				lblBookCopy.setFont(plainFont);
				lblMonthComparison.setFont(plainFont);
				lblGenreCopy.setFont(plainFont);

				lblMonthOverview.setFont(subtitleFont);
				lblBookLoan.setFont(subtitleFont);
				lblBookOverdue.setFont(subtitleFont);

				}
	    });
	
	//action Listeners
	btnOptionDetail.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent ev) {
	    	detailPopupMenu.show(btnOptionDetail, btnOptionDetail.getBounds().x, btnOptionDetail.getBounds().y
	           + btnOptionDetail.getBounds().height);
	    }
	});
	detailPopupMenu.addMouseListener(new MouseAdapter() {
	    public void mousePressed(MouseEvent e) {
	    	//punta info display frmae Account Information
	    	System.out.println("Clicked UwU");
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
	 
}
