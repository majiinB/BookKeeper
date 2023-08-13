package com.bookkeeper;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.ArrayList;

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

import com.bookkeeper.AdminReportPanel.headerRenderer;


public class AdminReportPanel extends JPanel {
	/* 
	 * PANELS
	 */
	private JPanel mainPanel;
	private JPanel headingPanel;
	//main panel 
	private JPanel overviewPanel;
	private RoundedPanel bookLoanedPanel;
	private RoundedPanel overduePanel;
	//overview panel
	private RoundedPanel activeUserPanel;
	private RoundedPanel reserveBookPanel;
	private RoundedPanel loanPanel;
	private RoundedPanel returnBookPanel;
	private RoundedPanel bookCopyPanel;
	private RoundedPanel monthComparisonPanel;
	private RoundedPanel genreCopyPanel;
	//genre copy panel 
	private JPanel genreGraphPanel;
	//month comparison panel;
	private JPanel comparisonGraphPanel;
	//genre Graph Panel
	private RoundedPanel pieLegendPanel;
	//month Comparison Graph Panel
	private RoundedPanel lineLegendPanel;
	//pie and line legends
	private JPanel legendItemPanel1;
	private JPanel legendItemPanel2;
	//legend item
	private JPanel legendItemPanel;
	private JPanel square;
	/* 
	 * CHARTS
	 */
	private CreateLineChart createLineChart;
	private CreatePieChart createPieChart;
	private JFreeChart lineChart;
	private JFreeChart pieChart;	
	private ChartPanel lineChartPanel ;
	private ChartPanel pieChartPanel ;
	/* 
	 * LABELS
	 */
	private JLabel lblHeading1;
	private JLabel lblHeading2;
	//overview panel
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
	//chart legend
	private JLabel lblLegend;
	private JLabel lblLegend1;
	private JLabel lblLegend2;
	/* 
	 * TEXTFIELD
	 */
	private PlaceholderTextField txtActiveUser;
	private PlaceholderTextField txtReserveBook;
	private PlaceholderTextField txtLoan;	
	private PlaceholderTextField txtReturnBook;
	private PlaceholderTextField txtBookCopy;
	/* 
	 * LAYOUT
	 */
	private GridBagLayout gbl_mainPanel;
	private GridBagConstraints gbc_overviewPanel;
	private GridBagConstraints gbc_bookLoanedPanel;
	private GridBagConstraints gbc_overduePanel;
	//overview panel layout
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
	//loan table layout
	private GridBagLayout  gbl_bookLoanedPanel;
	private GridBagConstraints gbc_lblBookLoan	;
	private GridBagConstraints gbc_bookLoanedScrollPane;
	//overdue table layout
	private GridBagConstraints gbc_lblBookOverdue;
	private GridBagConstraints gbc_overdueScrollPane;
	private GridBagLayout  gbl_bookOverduePanel;
	//copies per genre panel layout
	private GridBagLayout  gbl_genreCopyPanel;
	private GridBagConstraints  gbc_lblGenreCopyComparison;
	private GridBagConstraints  gbc_genreGraphPanel;
	//montly comparison panel layout
	private GridBagLayout  gbl_monthComparisonPanel;
	private GridBagConstraints  gbc_lblMonthComparison;
	private GridBagConstraints  gbc_comparisonGraphPanel;
	//graph layouts
	private GridBagLayout  gbl_genreGraphPanel;
	private GridBagConstraints  gbc_pieChartPanel;
	private GridBagConstraints  gbc_pieLegendPanel;
	private GridBagLayout  gbl_comparisonGraphPanel;
	private GridBagConstraints  gbc_lineChartPanel;
	private GridBagConstraints  gbc_lineLegendPanel;
	//legend panel layouts
	private GridBagLayout  gbl_lineLegendPanel;
	private GridBagConstraints  gbc_lblLegend1;
	private GridBagConstraints  gbc_legendItemPanel1;
	private GridBagLayout  gbl_pieLegendPanel;
	private GridBagConstraints  gbc_lblLegend2;
	private GridBagConstraints  gbc_legendItemPanel2;
	//legend item layout
	private GridBagLayout  gbl_legendItemPanel;
    private GridBagConstraints gbc_lbl;
    private GridBagConstraints gbc_pnl;
	/* 
	 * SCROLLPANE
	 */
   	private JScrollPane reportScrollPane;
	private JScrollPane bookLoanedScrollPane;
	private JScrollPane overdueScrollPane;
	/* 
	 * TABLE	 
	 */
	private JTable bookLoanTable;
	private JTable overdueTable;
	private DefaultTableModel bookLoanTableModel;
	private DefaultTableModel overdueTableModel;
	/*
	 * BUTTON 
	 */
	private JButton btnOptionDetail;
	/*
	 * MENU 
	 */
	private JMenuItem option1;
	private JPopupMenu detailPopupMenu;
	/*
	 * images 
	 */
	private ImageIcon optionIcon;
	//image sizes
	private int iconHeight;
	private int iconWidth;
	/*
	 * TEXT 
	 */
	private  Font titleFont;
	private  Font subtitleFont;
	private  Font buttonFont;
	private  Font legendFont;
	private  Font plainFont;
	//font sizes
	private  int buttonTextSize;
	private  int legendTextsize;
	private  int titleTextSize;
	private  int subtitleTextSize;
	private  int headerTextSize;
	private  int plainTextsize;
	/*
	 * COLOR 
	 */
	private  Color headerColor = new Color(23, 21, 147);//blue
	private  Color darkplainColor = new Color(14, 14, 15);//black
	private  Color lightplainColor = new Color(250, 251, 255);//white
	private  Color middleplainColor = new Color(243, 243, 247);//dirty white
	public AdminReportPanel() {
		setBackground(lightplainColor);
		setBorder(new EmptyBorder(10, 20, 10, 0));
		setLayout(new BorderLayout(0, 0));
		
		//CREATE PANELS
		mainPanel = new JPanel();
		headingPanel = new JPanel();
		overviewPanel = new JPanel();
		bookLoanedPanel = new RoundedPanel(20);
		overduePanel = new RoundedPanel(20);
		 
			//overview panel
		activeUserPanel = new RoundedPanel(20);
		reserveBookPanel = new RoundedPanel(20);
		loanPanel = new RoundedPanel(20);
		returnBookPanel = new RoundedPanel(20);
		bookCopyPanel = new RoundedPanel(20);
		monthComparisonPanel = new RoundedPanel(20);
		genreCopyPanel = new RoundedPanel(20);
		
			//monthly comparison chart panels
		comparisonGraphPanel = new JPanel();
		lineLegendPanel = new RoundedPanel(20);
		legendItemPanel1 = new JPanel();
		
			//copies per genre chart panels
		genreGraphPanel = new JPanel();
		pieLegendPanel = new RoundedPanel(20);
		legendItemPanel2 = new JPanel();
		
		// SET PANEL PROPERTIES
		mainPanel.setOpaque(false);
		headingPanel.setOpaque(false);
		overviewPanel.setOpaque(false);
		bookLoanedPanel.setOpaque(false);
		overduePanel.setOpaque(false);
		
			//overview panels
		activeUserPanel.setOpaque(false);
		reserveBookPanel.setOpaque(false);
		loanPanel.setOpaque(false);
		returnBookPanel.setOpaque(false);
		bookCopyPanel.setOpaque(false);
		
			//monthly comparison chart panels
		monthComparisonPanel.setOpaque(false);
		comparisonGraphPanel.setOpaque(false);
		lineLegendPanel.setOpaque(false);
		legendItemPanel1.setOpaque(false);
		
			//copies per genre chart panels
		genreCopyPanel.setOpaque(false);
		genreGraphPanel.setOpaque(false);
		pieLegendPanel.setOpaque(false);
		legendItemPanel2.setOpaque(false);
			
		mainPanel.setBorder(new EmptyBorder(0, 0, 0, 30));
		headingPanel.setBorder(new EmptyBorder(10, 25, 10, 25));
		overviewPanel.setBorder(new EmptyBorder(10, 0, 15, 0));
		bookLoanedPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		overduePanel.setBorder(new EmptyBorder(0, 0, 0, 0));
			
		activeUserPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
		reserveBookPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
		loanPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
		returnBookPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
		bookCopyPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
		
		monthComparisonPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
	    comparisonGraphPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
	    lineLegendPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
	    
	    genreCopyPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
	    pieLegendPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
	    genreGraphPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
	    
	    bookLoanedPanel.setBorderWidth(2);
	    overduePanel.setBorderWidth(2);
	    
	    activeUserPanel.setBorderWidth(2);
	    reserveBookPanel.setBorderWidth(2);
	    loanPanel.setBorderWidth(2);
	    returnBookPanel.setBorderWidth(2);
	    bookCopyPanel.setBorderWidth(2);
	    
	    monthComparisonPanel.setBorderWidth(2);
		lineLegendPanel.setBorderWidth(2);

	    genreCopyPanel.setBorderWidth(2);
		pieLegendPanel.setBorderWidth(2);
		
		//COMPONENTS
		reportScrollPane  = new JScrollPane(mainPanel);
		reportScrollPane.setOpaque(false);
		reportScrollPane.getViewport().setOpaque(false);
		reportScrollPane.setBackground(new Color(255, 255, 255));
		reportScrollPane.setBorder(new EmptyBorder(0, 25, 0, 0));
		reportScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		reportScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		    
		//heading
		lblHeading1 = new JLabel("Dashboard ");
		lblHeading1.setOpaque(false);
			 
		lblHeading2 = new JLabel("/ Reports");
		lblHeading2.setOpaque(false);
			
		//main panel components
		lblMonthOverview = new JLabel("Monthly Overview");
		lblMonthOverview.setOpaque(false);
		lblMonthOverview.setForeground(darkplainColor);
		
		//button for printing report
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
	    
	    
	    //active User Panel components
	    lblActiveUser = new JLabel("Active Users");
		lblActiveUser.setOpaque(false);

		txtActiveUser = new PlaceholderTextField(Integer.toString(getCountOfUser()));
		txtActiveUser.setFocusable(false);
		txtActiveUser.setEditable(false);
		txtActiveUser.setOpaque(false);
		txtActiveUser.setBorder(null);
		txtActiveUser.setForeground(darkplainColor);
		
	    //Reservations Count Panel components
		lblReserveBook = new JLabel("Books Reserved");
		lblReserveBook.setOpaque(false);

		txtReserveBook = new PlaceholderTextField(Integer.toString(getCountOfReserved()));
		txtReserveBook.setFocusable(false);
		txtReserveBook.setEditable(false);
		txtReserveBook.setOpaque(false);
		txtReserveBook.setBorder(null);
		txtReserveBook.setForeground(darkplainColor);
		
	    //Borrow Count 
		lblLoan = new JLabel("Books Loaned");
		lblLoan.setOpaque(false);

		txtLoan = new PlaceholderTextField(Integer.toString(getCountOfBorrowed()));
		txtLoan.setFocusable(false);
		txtLoan.setEditable(false);
		txtLoan.setOpaque(false);
		txtLoan.setBorder(null);
		txtLoan.setForeground(darkplainColor);
		
	    //Return Count 
		lblReturnBook = new JLabel("Books Returned");
		lblReturnBook.setOpaque(false);

		txtReturnBook = new PlaceholderTextField(Integer.toString(getCountOfReturned()));
		txtReturnBook.setFocusable(false);
		txtReturnBook.setEditable(false);
		txtReturnBook.setOpaque(false);
		txtReturnBook.setBorder(null);
		txtReturnBook.setForeground(darkplainColor);
		
	    //Book Count 
		lblBookCopy = new JLabel("Book Copies");
		lblBookCopy.setOpaque(false);

		txtBookCopy = new PlaceholderTextField(Integer.toString(getCountOfBooks()));
		txtBookCopy.setFocusable(false);
		txtBookCopy.setEditable(false);
		txtBookCopy.setOpaque(false);
		txtBookCopy.setBorder(null);
		txtBookCopy.setForeground(darkplainColor);	
		
		//Month Comparison 
		lblMonthComparison = new JLabel("Monthly Comparison");
		lblMonthComparison.setOpaque(false);
		
		//create line chart 
	    createLineChart = new CreateLineChart("","Months","Number of Books");
	    
	    // Values for line chart
	    //loop for reserved
	    int[] reserved = new int[12];

	    for (int month = 1; month <= 12; month++) {
	        reserved[month - 1] = getCountOfReservedLine(month);
	    }
	    
	    //loop for borrowed
	    int[] borrowed = new int[12];

	    for (int month = 1; month <= 12; month++) {
	        borrowed[month - 1] = getCountOfBorrowedLine(month);
	    }
	    
	    //loop for returned
	    int[] returned = new int[12];

	    for (int month = 1; month <= 12; month++) {
	        returned[month - 1] = getCountOfReturnedLine(month);
	    }

	    String[] monthsArray = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
	    String[] seriesArray = {"Reserved","Borrowed","Returned"};
	    Color linecolor[] = { new Color(182, 32, 68), new Color(11, 130, 87), new Color(23, 21, 147)};
	    
	    //add datas into line chart
	    createLineChart.addData(monthsArray, reserved, "Reserved");
	    createLineChart.addData(monthsArray, borrowed, "Borrowed");
	    createLineChart.addData(monthsArray, returned, "Returned");

	    //set chart properties
	    createLineChart.setSeriesStroke("Reserved",new BasicStroke(3.0f));
	    createLineChart.setSeriesStroke("Borrowed",new BasicStroke(3.0f));
	    createLineChart.setSeriesStroke("Returned",new BasicStroke(3.0f));

	    createLineChart.setSeriesPaint("Reserved",new Color(182, 32, 68));
	    createLineChart.setSeriesPaint("Borrowed",new Color(11, 130, 87));
	    createLineChart.setSeriesPaint("Returned",new Color(23, 21, 147));

	    // get  line chart to be displayed	   
	    lineChart = createLineChart.getLineChart();

	    // create chart panel to hold the line chart
	    lineChartPanel = new ChartPanel(lineChart);
	    lineChartPanel.setEnforceFileExtensions(false);
	    lineChartPanel.setZoomTriggerDistance(1);
	    lineChartPanel.setZoomOutFactor(1);
	    lineChartPanel.setZoomInFactor(1);
	    lineChartPanel.setRangeZoomable(false);
	    lineChartPanel.setMouseZoomable(false);
	    lineChartPanel.setFillZoomRectangle(false);
	    lineChartPanel.setBorder(new EmptyBorder(0, 0, 0, 20));
	    lineChartPanel.setFocusable(false);
	    lineChartPanel.setOpaque(false);
	    lineChartPanel.setDisplayToolTips(false);
	    lineChartPanel.setPreferredSize(new Dimension(500,500));

	    //legend item of line chart
	    lblLegend1 = new JLabel("Legends");
	    lblLegend1.setOpaque(false);
	    lblLegend1.setBorder(new EmptyBorder(5, 5, 5, 5));
	    
	    legendItemPanel1.setLayout(new GridLayout(linecolor.length,1,10,10));

	    legendFont = new Font("Montserrat", Font.ITALIC, 14);
	    //create list to store legends
	    List<JPanel> legendPanels1 = new ArrayList<>();
	    
	    //create Legend items using for loop
	    for (int i = 0;i < linecolor.length; i++) {
	    	legendItemPanel = new JPanel();
	        legendItemPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	        legendItemPanel.setOpaque(false);
	        legendItemPanel.setLayout(new BorderLayout(10,0));

	        lblLegend = new JLabel(seriesArray[i]);
	        lblLegend.setFont(legendFont);
	        
	        square = new JPanel();
	        square.setBorder(new EmptyBorder(15,15,15,15));
	        square.setPreferredSize(new Dimension(25, 25));
	        square.setOpaque(true);
	        square.setBackground(linecolor[i]);
	        
	        //add components to panel
	        legendItemPanel.add(square,BorderLayout.WEST);
	        legendItemPanel.add(lblLegend,BorderLayout.CENTER);
	        legendPanels1.add(legendItemPanel); 
	    }
	    
	    for (JPanel legendItemPanel : legendPanels1) {
	    	legendItemPanel1.add(legendItemPanel);
	    }

	    //copies per genre
		lblGenreCopy = new JLabel("Copies Per Genre");
		lblGenreCopy.setOpaque(false);
		//create line chart 
	    createPieChart = new CreatePieChart("");

	    // Values for pie chart
	    //Names of genre
		String[] genresArray = {
				"Classic", 
				"Dystopian", 
				"Epic Poetry", 
				"Fantasy", 
				"Fiction", 
				"Gothic Fiction", 
				"Historical Fiction", 
				"Horror", 
				"Mystery", 
				"Novel",
				"Non-Fiction", 
				"Romance", 
				"Science", 
				"Science Fiction", 
				"Survival", 
				"Thriller", 
				"Young Adult"
				};
		
		//Initialize copy array 
		int[] copyArray = new int[genresArray.length];
		
		//loop to assign the values
		for (int i = 0; i < genresArray.length; i++) {
	        String genre = genresArray[i];
	        int count = countGenreInTable(genre); // Call the method to get the count
	        copyArray[i] = count; // Assign the count to the corresponding index
	    }
		
		Color piecolor[] = {
			    new Color(11, 130, 87),
			    new Color(182, 32, 68),
			    new Color(23, 21, 147),
			    new Color(245, 143, 26),
			    new Color(184, 124, 19),
			    new Color(118, 61, 25),
			    new Color(5, 92, 136),
			    new Color(118, 19, 107),
			    new Color(235, 59, 146),
			    new Color(183, 134, 132),
			    new Color(184, 43, 83),
			    new Color(88, 89, 128),
			    new Color(5, 81, 26),
			    new Color(146, 25, 5),
			    new Color(80, 150, 142),
			    new Color(100, 200, 50),  
			    new Color(70, 110, 190)
		};
		  
		//add datas into line chart
	    createPieChart.addData(genresArray, copyArray);

	    //set chart properties 
	    createPieChart.setSectionPaint(genresArray, piecolor);

		// get  line chart to be displayed	   
	    pieChart = createPieChart.getPieChart();
	    
	    // create chart panel to hold the line chart
	    pieChartPanel = new ChartPanel(pieChart);
	    pieChartPanel.setBorder(new EmptyBorder(0, 0, 0, 20));
	    pieChartPanel.setOpaque(false);
	    pieChartPanel.setDisplayToolTips(false);
	    pieLegendPanel.revalidate();
	    pieLegendPanel.repaint();
	    pieChartPanel.setPreferredSize(new Dimension(500,500));

	    //legend item of line chart
	    lblLegend2 = new JLabel("Legends");
	    lblLegend2.setOpaque(false);
	    lblLegend2.setBorder(new EmptyBorder(5, 5, 5, 5));
	    
	    legendItemPanel2.setLayout(new GridLayout(piecolor.length-6,20,20,20));
	    
	    //create list to store legends
	    List<JPanel> legendPanels2 = new ArrayList<>();

	    //create Legend items using for loop
	    for (int i = 0;i < piecolor.length; i++) {	        
	        legendItemPanel = new JPanel();
	        legendItemPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	        legendItemPanel.setOpaque(false);
	        legendItemPanel.setLayout(new BorderLayout(10,0));
	        
	        lblLegend = new JLabel(genresArray[i] + " - " + copyArray[i] + " copies");
	        lblLegend.setFont(legendFont);
	        
	        square = new JPanel();
	        square.setBorder(new EmptyBorder(15,15,15,15));
	        square.setPreferredSize(new Dimension(25, 25));
	        square.setOpaque(true);
	        square.setBackground(piecolor[i]);
	        
	        //add components to panel
	        legendItemPanel.add(square,BorderLayout.WEST);
	        legendItemPanel.add(lblLegend,BorderLayout.CENTER);
	        legendPanels2.add(legendItemPanel); 
	    }
	    for (JPanel legendItemPanel : legendPanels2) {
	    	legendItemPanel2.add(legendItemPanel);
	    }

	    //books loan table
		lblBookLoan = new JLabel("Books Loaned");
		lblBookLoan.setBorder(new EmptyBorder(20, 20, 0, 0));
		lblBookLoan.setOpaque(false);

		bookLoanTableModel = new DefaultTableModel();
		bookLoanTable = new JTable(bookLoanTableModel) {
			// Override isCellEditable method to make cells not editable
			@Override
			public boolean isCellEditable(int row, int column) {
			      return false;
			}
		};
		//set table properties
		bookLoanTable.setBackground(new Color(0, 0, 0, 0));;
		bookLoanTable.setFillsViewportHeight(true);
		bookLoanTable.setOpaque(false);
		bookLoanTable.setShowVerticalLines(false);
		bookLoanTable.setRowHeight(45);
		bookLoanTable.getTableHeader().setOpaque(false);
		bookLoanTable.setGridColor(darkplainColor);
		bookLoanTable.getTableHeader().setDefaultRenderer(new headerRenderer());
		bookLoanTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		bookLoanTable.setSelectionBackground(new Color(125, 147, 194));
		bookLoanTable.setSelectionForeground(lightplainColor);
		
		bookLoanedScrollPane  = new JScrollPane();
		bookLoanedScrollPane.setOpaque(false);
		bookLoanedScrollPane.getViewport().setOpaque(false);
		bookLoanedScrollPane.setBackground(new Color(255, 255, 255));
		bookLoanedScrollPane.setBorder(new EmptyBorder(0, 5, 5, 5));
		bookLoanedScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		bookLoanedScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		bookLoanedScrollPane.setViewportView(bookLoanTable);
	    
		//call method to display loaned books
		displayLoanedBooks();
		
		//overdue book table
		lblBookOverdue = new JLabel("Books Overdue");
		lblBookOverdue.setBorder(new EmptyBorder(20, 20, 0, 0));
		lblBookOverdue.setOpaque(false);

		overdueTableModel = new DefaultTableModel();
		overdueTable = new JTable(overdueTableModel) {
			// Override isCellEditable method to make cells not editable
			@Override
			public boolean isCellEditable(int row, int column) {
			      return false;
			}
		};
		
		//set table properties
		overdueTable.setBackground(new Color(0, 0, 0, 0));;
		overdueTable.setFillsViewportHeight(true);
		overdueTable.setOpaque(false);
		overdueTable.setShowVerticalLines(false);
		overdueTable.setRowHeight(45);
		overdueTable.getTableHeader().setOpaque(false);
		overdueTable.setGridColor(darkplainColor);
		overdueTable.getTableHeader().setDefaultRenderer(new headerRenderer());
		overdueTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		overdueTable.setSelectionBackground(new Color(125, 147, 194));
		overdueTable.setSelectionForeground(lightplainColor);
		
		overdueScrollPane  = new JScrollPane();
		overdueScrollPane.setOpaque(false);
		overdueScrollPane.getViewport().setOpaque(false);
		overdueScrollPane.setBackground(new Color(255, 255, 255));
		overdueScrollPane.setBorder(new EmptyBorder(0, 5, 5, 5));
		overdueScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		overdueScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		overdueScrollPane.setViewportView(overdueTable);
		
		//Call method to display overdue 
		displayOverdueBooks();
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
		
		//Overview panel Layout
		gbl_overviewPanel = new GridBagLayout();
		gbl_overviewPanel.columnWidths = new int[]{0,0,0,0,0};
		gbl_overviewPanel.rowHeights = new int[]{0, 0, 0,0};
		gbl_overviewPanel.columnWeights = new double[]{1.0, 1.0,1.0,1.0,1.0};
		gbl_overviewPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
			
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
		
		//Month comparison panel layout
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
			
		//graph panel layout
		gbl_comparisonGraphPanel = new GridBagLayout();
		gbl_comparisonGraphPanel.columnWidths = new int[]{0, 0};
		gbl_comparisonGraphPanel.rowHeights = new int[]{0, 0};
		gbl_comparisonGraphPanel.columnWeights = new double[]{1.0,0.0};
		gbl_comparisonGraphPanel.rowWeights = new double[]{0.0, 0.0};

		gbc_lineChartPanel = new GridBagConstraints();
		gbc_lineChartPanel.fill = GridBagConstraints.BOTH;
		gbc_lineChartPanel.gridheight = 2;
		gbc_lineChartPanel.insets = new Insets(0, 20, 0,0);
		gbc_lineChartPanel.gridx = 0;
		gbc_lineChartPanel.gridy = 0;

		gbc_lineLegendPanel = new GridBagConstraints();
		gbc_lineLegendPanel.anchor = GridBagConstraints.NORTHWEST;
		gbc_lineLegendPanel.gridx = 1;
		gbc_lineLegendPanel.gridy = 0;
		
		//line legend panel layout
		gbl_lineLegendPanel = new GridBagLayout();
		gbl_lineLegendPanel.columnWidths = new int[]{0};
		gbl_lineLegendPanel.rowHeights = new int[]{0, 0};
		gbl_lineLegendPanel.columnWeights = new double[]{1.0};
		gbl_lineLegendPanel.rowWeights = new double[]{0.0, 1.0};
			
		gbc_lblLegend1 = new GridBagConstraints();
		gbc_lblLegend1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblLegend1.insets = new Insets(0, 0, 5, 5);
		gbc_lblLegend1.gridx = 0;
		gbc_lblLegend1.gridy = 0;
		
		gbc_legendItemPanel1 = new GridBagConstraints();
		gbc_legendItemPanel1.fill = GridBagConstraints.BOTH;
		gbc_legendItemPanel1.insets = new Insets(0, 5, 5, 0);
		gbc_legendItemPanel1.gridx = 0;
		gbc_legendItemPanel1.gridy = 1;
		
		
		//copy per genre layout
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
		
		//graph panel layout
		gbl_genreGraphPanel = new GridBagLayout();
		gbl_genreGraphPanel.columnWidths = new int[]{0, 0};
		gbl_genreGraphPanel.rowHeights = new int[]{0, 0};
		gbl_genreGraphPanel.columnWeights = new double[]{1.0,0.0};
		gbl_genreGraphPanel.rowWeights = new double[]{0.0, 0.0};

		gbc_pieChartPanel = new GridBagConstraints();
		gbc_pieChartPanel.fill = GridBagConstraints.BOTH;
		gbc_pieChartPanel.gridheight = 2;
		gbc_pieChartPanel.insets = new Insets(0, 20, 0,0);
		gbc_pieChartPanel.gridx = 0;
		gbc_pieChartPanel.gridy = 0;

		gbc_pieLegendPanel = new GridBagConstraints();
		gbc_pieLegendPanel.fill = GridBagConstraints.BOTH;
		gbc_pieLegendPanel.gridx = 1;
		gbc_pieLegendPanel.gridy = 0;

		//pie legend panel layout
		gbl_pieLegendPanel = new GridBagLayout();
		gbl_pieLegendPanel.columnWidths = new int[]{0};
		gbl_pieLegendPanel.rowHeights = new int[]{0, 0};
		gbl_pieLegendPanel.columnWeights = new double[]{1.0};
		gbl_pieLegendPanel.rowWeights = new double[]{0.0, 1.0};
			
		gbc_lblLegend2 = new GridBagConstraints();
		gbc_lblLegend2.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblLegend2.insets = new Insets(0, 0, 5, 5);
		gbc_lblLegend2.gridx = 0;
		gbc_lblLegend2.gridy = 0;
		
		gbc_legendItemPanel2 = new GridBagConstraints();
		gbc_legendItemPanel2.fill = GridBagConstraints.BOTH;
		gbc_legendItemPanel2.insets = new Insets(0, 5, 5, 0);
		gbc_legendItemPanel2.gridx = 0;
		gbc_legendItemPanel2.gridy = 1;
		
	    //books loan layout
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
		
		//overdue book layout
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
		    
		//set layouts
		mainPanel.setLayout(gbl_mainPanel);
		headingPanel.setLayout(new BoxLayout(headingPanel, BoxLayout.X_AXIS));
		overviewPanel.setLayout(gbl_overviewPanel);
		overviewPanel.setLayout(gbl_overviewPanel);
		bookLoanedPanel.setLayout(gbl_bookLoanedPanel);
		overduePanel.setLayout(gbl_bookOverduePanel);
			
		//overview panel
		activeUserPanel.setLayout(new GridLayout(2,0,0,0));
		reserveBookPanel.setLayout(new GridLayout(2,0,0,0));
		loanPanel.setLayout(new GridLayout(2,0,0,0));
		returnBookPanel.setLayout(new GridLayout(2,0,0,0));
		bookCopyPanel.setLayout(new GridLayout(2,0,0,0));
		
		//month Comparison
	    monthComparisonPanel.setLayout(gbl_monthComparisonPanel);
	    comparisonGraphPanel.setLayout(gbl_comparisonGraphPanel);
	    lineLegendPanel.setLayout(gbl_lineLegendPanel);

	    //copy per genre
	    genreCopyPanel.setLayout(gbl_genreCopyPanel);
	    genreGraphPanel.setLayout(gbl_genreGraphPanel);
	    pieLegendPanel.setLayout(gbl_pieLegendPanel);

	    //add components to each panel
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
	    
	    //monthComparisonPanel
	    lineLegendPanel.add(lblLegend1,gbc_lblLegend1);
	    lineLegendPanel.add(legendItemPanel1,gbc_legendItemPanel1);
	    comparisonGraphPanel.add(lineChartPanel,gbc_lineChartPanel);
	    comparisonGraphPanel.add(lineLegendPanel,gbc_lineLegendPanel);
	    monthComparisonPanel.add(lblMonthComparison,gbc_lblMonthComparison);
	    monthComparisonPanel.add(comparisonGraphPanel,gbc_comparisonGraphPanel);

	    //copies per genre
	    pieLegendPanel.add(lblLegend2,gbc_lblLegend2);
	    pieLegendPanel.add(legendItemPanel2,gbc_legendItemPanel2);
	    genreGraphPanel.add(pieChartPanel,gbc_pieChartPanel);
	    genreGraphPanel.add(pieLegendPanel,gbc_pieLegendPanel);
	    genreCopyPanel.add(lblGenreCopy,gbc_lblGenreCopyComparison);
	    genreCopyPanel.add(genreGraphPanel,gbc_genreGraphPanel);
	    
	    //laon
	    bookLoanedPanel.add(lblBookLoan,gbc_lblBookLoan);
	    bookLoanedPanel.add(bookLoanedScrollPane,gbc_bookLoanedScrollPane);
	    
	    //overdue
	    overduePanel.add(lblBookOverdue,gbc_lblBookOverdue);
	    overduePanel.add(overdueScrollPane,gbc_overdueScrollPane);
	    
	    //overview
	    overviewPanel.add(lblMonthOverview,gbc_lblMonthOverview);
	    overviewPanel.add(activeUserPanel,gbc_activeUserPanel);
	    overviewPanel.add(reserveBookPanel,gbc_reserveBookPanel);
	    overviewPanel.add(loanPanel,gbc_loanPanel);
	    overviewPanel.add(returnBookPanel,gbc_returnBookPanel);
	    overviewPanel.add(bookCopyPanel,gbc_bookCopyPanel);
	    overviewPanel.add(monthComparisonPanel,gbc_monthComparisonPanel);
	    overviewPanel.add(genreCopyPanel,gbc_genreCopyPanel);
	    
	    //mainpanel
		mainPanel.add(overviewPanel,gbc_overviewPanel);
		mainPanel.add(bookLoanedPanel,gbc_bookLoanedPanel);
		mainPanel.add(overduePanel,gbc_overduePanel);

		
		add(headingPanel, BorderLayout.NORTH);
		add(reportScrollPane, BorderLayout.CENTER);
		
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
				buttonFont = new Font("Montserrat", Font.ITALIC, buttonTextSize);
				plainFont = new Font("Montserrat", Font.PLAIN, plainTextsize);
				
				lblHeading1.setFont(new Font("Montserrat", Font.BOLD, headerTextSize));
				lblHeading2.setFont(new Font("Montserrat", Font.PLAIN, headerTextSize));
				lblActiveUser.setFont(plainFont);    
				lblReserveBook.setFont(plainFont);
				lblLoan.setFont(plainFont);
				lblReturnBook.setFont(plainFont);
				lblBookCopy.setFont(plainFont);
				lblLegend1.setFont(plainFont);
				lblLegend2.setFont(plainFont);
				
				lblGenreCopy.setFont(subtitleFont);
				lblMonthComparison.setFont(subtitleFont);
				lblMonthOverview.setFont(subtitleFont);
				lblBookLoan.setFont(subtitleFont);
				lblBookOverdue.setFont(subtitleFont);
				overdueTable.setFont(plainFont);
				overdueTable.getTableHeader().setFont(new Font("Montserrat", Font.ITALIC  | Font.BOLD, plainTextsize));	            
				overdueTable.getTableHeader().setForeground(headerColor);
				bookLoanTable.setFont(plainFont);
				bookLoanTable.getTableHeader().setFont(new Font("Montserrat", Font.ITALIC  | Font.BOLD, plainTextsize));	            
				bookLoanTable.getTableHeader().setForeground(headerColor);
	            
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
	//Methods for table
	private void displayLoanedBooks() {
	    try {
	        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_keeper", "root", "");
	        String getQuery = "SELECT b.book_id, b.book_title, p.formatted_id, CONCAT(p.patron_fname, ' ', p.patron_lname) AS patron_name, bb.borrowed_date, bb.borrowed_due_date " +
	                          "FROM book AS b " +
	                          "JOIN borrowed_book AS bb ON b.book_id = bb.book_id " +
	                          "JOIN patron AS p ON bb.patron_id = p.formatted_id " +
	                          "WHERE bb.borrow_status = 'out' ORDER BY bb.borrowed_date, borrow_time DESC";

	        Statement statement = connection.createStatement();
	        ResultSet resultSet = statement.executeQuery(getQuery);

	        ResultSetMetaData metaData = resultSet.getMetaData();
	        int columnCount = metaData.getColumnCount();

	        String[] columnNames = {"Book ID", "Book Title", "Patron ID", "Patron Name", "Date Borrowed", "Due Date"};

	        bookLoanTableModel.setColumnIdentifiers(columnNames);

	        while (resultSet.next()) {
	            Object[] rowData = new Object[columnCount];
	            for (int i = 1; i <= columnCount; i++) {
	                rowData[i - 1] = resultSet.getObject(i);
	            }
	            bookLoanTableModel.addRow(rowData);
	        }

	        resultSet.close();
	        statement.close();
	        connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	private void displayOverdueBooks() {
	    try {
	        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_keeper", "root", "");
	        String getQuery = "SELECT b.book_id, b.book_title, p.formatted_id, CONCAT(p.patron_fname, ' ', p.patron_lname) AS patron_name, bb.borrowed_date, bb.borrowed_due_date " +
	                          "FROM book AS b " +
	                          "JOIN borrowed_book AS bb ON b.book_id = bb.book_id " +
	                          "JOIN patron AS p ON bb.patron_id = p.formatted_id " +
	                          "WHERE bb.borrow_status = 'Overdue' ORDER BY bb.borrowed_date, borrow_time DESC";

	        Statement statement = connection.createStatement();
	        ResultSet resultSet = statement.executeQuery(getQuery);

	        ResultSetMetaData metaData = resultSet.getMetaData();
	        int columnCount = metaData.getColumnCount();

	        String[] columnNames = {"Book ID", "Book Title", "Patron ID", "Patron Name", "Date Borrowed", "Due Date"};

	        overdueTableModel.setColumnIdentifiers(columnNames);

	        while (resultSet.next()) {
	            Object[] rowData = new Object[columnCount];
	            for (int i = 1; i <= columnCount; i++) {
	                rowData[i - 1] = resultSet.getObject(i);
	            }
	            overdueTableModel.addRow(rowData);
	        }

	        resultSet.close();
	        statement.close();
	        connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	//Method for line chart
	public static int getCountOfReturnedLine(int month) {
	    Connection conn = null;
	    int count = 0;
	    try {
	        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_keeper", "root", "");

	        // Get the current year
	        int year = YearMonth.now().getYear();

	        // Prepare the SQL query
	        String query = "SELECT COUNT(*) FROM borrowed_book WHERE MONTH(borrowed_date) = ? AND YEAR(borrowed_date) = ? AND borrow_status = 'returned' ";
	        PreparedStatement stmt = conn.prepareStatement(query);
	        stmt.setInt(1, month);
	        stmt.setInt(2, year);

	        // Execute the query and get the count
	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
	            count = rs.getInt(1);
	        }

	        // Close the resources
	        rs.close();
	        stmt.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        if (conn != null) {
	            try {
	                conn.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	    
	    return count;
	}
	public static int getCountOfBorrowedLine(int month) {
	    Connection conn = null;
	    int count = 0;
	    try {
	        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_keeper", "root", "");

	        // Get the current year
	        int year = YearMonth.now().getYear();

	        // Prepare the SQL query
	        String query = "SELECT COUNT(*) FROM borrowed_book WHERE MONTH(borrowed_date) = ? AND YEAR(borrowed_date) = ?";
	        PreparedStatement stmt = conn.prepareStatement(query);
	        stmt.setInt(1, month);
	        stmt.setInt(2, year);

	        // Execute the query and get the count
	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
	            count = rs.getInt(1);
	        }

	        // Close the resources
	        rs.close();
	        stmt.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        if (conn != null) {
	            try {
	                conn.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	    
	    return count;
	}
	public static int getCountOfReservedLine(int month) {
	    Connection conn = null;
	    int count = 0;
	    try {
	        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_keeper", "root", "");

	        // Get the current year
	        int year = LocalDate.now().getYear();

	        // Prepare the SQL query
	        String query = "SELECT COUNT(*) FROM reserved_book WHERE MONTH(reservation_date) = ? AND YEAR(reservation_date) = ? ";
	        PreparedStatement stmt = conn.prepareStatement(query);
	        stmt.setInt(1, month);
	        stmt.setInt(2, year);

	        // Execute the query and get the count
	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
	            count = rs.getInt(1);
	        }

	        // Close the resources
	        rs.close();
	        stmt.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        if (conn != null) {
	            try {
	                conn.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	    
	    return count;
	}
		// Method to count borrowed books for the month
		public int getCountOfBorrowed() {
	        Connection conn = null;
	        int count = 0;
	        try {
	            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_keeper", "root", "");
	            
	            // Get the current month and year
	            YearMonth currentMonth = YearMonth.now();
	            int year = currentMonth.getYear();
	            int month = currentMonth.getMonthValue();

	            // Prepare the SQL query
	            String query = "SELECT COUNT(*) FROM borrowed_book WHERE MONTH(borrowed_date) = ? AND YEAR(borrowed_date) = ?";
	            PreparedStatement stmt = conn.prepareStatement(query);
	            stmt.setInt(1, month);
	            stmt.setInt(2, year);

	            // Execute the query and get the count
	            ResultSet rs = stmt.executeQuery();
	            if (rs.next()) {
	                count = rs.getInt(1);
	            }

	            // Close the resources
	            rs.close();
	            stmt.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            if (conn != null) {
	                try {
	                    conn.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	        
	        return count;
	    }
		// Method that counts the number of books
		public static int getCountOfBooks() {
	        Connection conn = null;
	        int count = 0;
	        try {
	            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_keeper", "root", "");
	            
	            // Prepare the SQL query
	            String query = "SELECT COUNT(*) FROM book";
	            PreparedStatement stmt = conn.prepareStatement(query);

	            // Execute the query and get the count
	            ResultSet rs = stmt.executeQuery();
	            if (rs.next()) {
	                count = rs.getInt(1);
	            }

	            // Close the resources
	            rs.close();
	            stmt.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            if (conn != null) {
	                try {
	                    conn.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	        
	        return count;
	    }
		// Method that counts the number of books
			public static int getCountOfUser() {
		        Connection conn = null;
		        int count = 0;
		        try {
		            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_keeper", "root", "");
		            
		            // Prepare the SQL query
		            String query = "SELECT COUNT(*) FROM patron WHERE patron_status = 'Active'";
		            PreparedStatement stmt = conn.prepareStatement(query);

		            // Execute the query and get the count
		            ResultSet rs = stmt.executeQuery();
		            if (rs.next()) {
		                count = rs.getInt(1);
		            }

		            // Close the resources
		            rs.close();
		            stmt.close();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        } finally {
		            if (conn != null) {
		                try {
		                    conn.close();
		                } catch (SQLException e) {
		                    e.printStackTrace();
		                }
		            }
		        }
		        
		        return count;
		    }
	    public static int countGenreInTable(String genre) {
	        // SQL query
	        String query = "SELECT COUNT(*) AS genre_count " +
	                "FROM book" +
	                " WHERE genre_name LIKE ?";

	        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_keeper", "root", "");
	             PreparedStatement statement = connection.prepareStatement(query)) {

	            statement.setString(1, genre); // Set the genre as a parameter in the query
	            ResultSet resultSet = statement.executeQuery();

	            if (resultSet.next()) {
	                return resultSet.getInt("genre_count");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return 0; // Return 0 if an error occurs or no result is found
	    }
	    public static int getCountOfReserved() {
	        Connection conn = null;
	        int count = 0;
	        try {
	        	
	        	YearMonth currentMonth = YearMonth.now();
	            int year = currentMonth.getYear();
	            int month = currentMonth.getMonthValue();
	            
	            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_keeper", "root", "");
	            
	            // Prepare the SQL query
	            String query = "SELECT COUNT(*) FROM reserved_book WHERE MONTH(reservation_date) = ? AND YEAR(reservation_date) = ?";
	            PreparedStatement stmt = conn.prepareStatement(query);
	            stmt.setInt(1, month);
	            stmt.setInt(2, year);

	            // Execute the query and get the count
	            ResultSet rs = stmt.executeQuery();
	            if (rs.next()) {
	                count = rs.getInt(1);
	            }

	            // Close the resources
	            rs.close();
	            stmt.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            if (conn != null) {
	                try {
	                    conn.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	        
	        return count;
	    }
	    public static int getCountOfReturned() {
	    	Connection conn = null;
	        int count = 0;
	        try {
	            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_keeper", "root", "");
	            
	            // Get the current month and year
	            YearMonth currentMonth = YearMonth.now();
	            int year = currentMonth.getYear();
	            int month = currentMonth.getMonthValue();

	            // Prepare the SQL query
	            String query = "SELECT COUNT(*) FROM borrowed_book WHERE MONTH(returned_date) = ? AND YEAR(returned_date) = ? AND borrow_status = 'returned'";
	            PreparedStatement stmt = conn.prepareStatement(query);
	            stmt.setInt(1, month);
	            stmt.setInt(2, year);

	            // Execute the query and get the count
	            ResultSet rs = stmt.executeQuery();
	            if (rs.next()) {
	                count = rs.getInt(1);
	            }

	            // Close the resources
	            rs.close();
	            stmt.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            if (conn != null) {
	                try {
	                    conn.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	        
	        return count;
	    }
	    
}