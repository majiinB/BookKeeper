
 package com.bookkeeper;
 import javax.swing.*;
 import java.sql.*;

 import javax.swing.border.EmptyBorder;
 import javax.swing.border.LineBorder;
 import javax.swing.table.DefaultTableModel;
 import java.awt.*;
 import java.awt.event.MouseAdapter;
 import java.awt.event.MouseEvent;
 import java.util.ArrayList;
 import java.awt.event.ActionListener;
 import java.awt.event.ActionEvent;

 public class pnlEmployee extends JPanel {
     private JPanel pnlSearchResults;
     private JPanel pnlSearchBtn;
     private JPanel pnlSearchBar;
     private JPanel pnlAddEmployee;
     private JPanel pnlWholeDisplay;
     private JLabel lblBookKeeper;
     private PlaceholderTextField txtSearchBar;
     private JButton btnSearch ;
     private JButton btnAddEmployee;
     private JTable table;
     private ImageIcon icnSearch;
     private Image imgSearch;
     private Image rsdImgSearch;
     private DefaultTableModel tableModel;
     private JScrollPane scrlSearchResults;
     private GridBagLayout gbl_pnlWholeDisplay;
     private GridBagConstraints gbc_pnlAddEmployee;
     private GridBagConstraints gbc_pnlSearchBar;
     private GridBagConstraints gbc_pnlSearchResults;
     
 	//USERMANAGEMENT
 	public pnlEmployee() {
         setLayout(new BorderLayout(0, 0));

         // panels
         pnlWholeDisplay= new JPanel();     //create panel to display whole dashboard
         pnlAddEmployee = new JPanel();		//create panel for add user button
         pnlSearchBar = new JPanel();	//create panel for search bar
         pnlSearchBtn = new JPanel(); //create panel for button
         pnlSearchResults = new JPanel(); //Create panel for result table
                               
         //Create main panel that will contain library panel
         lblBookKeeper = new JLabel("Book Keeper");    
         lblBookKeeper.setBorder(new EmptyBorder(15, 15, 15, 15));     
         lblBookKeeper.setOpaque(true);       
         lblBookKeeper.setHorizontalTextPosition(SwingConstants.CENTER);           
         lblBookKeeper.setHorizontalAlignment(SwingConstants.CENTER);            
         lblBookKeeper.setBounds(55, 46, 125, 38);              
         lblBookKeeper.setBackground(new Color(26, 24, 87));           
         lblBookKeeper.setForeground(new Color(232, 246, 239));            
         lblBookKeeper.setLabelFor(txtSearchBar);            

         //Search bar
         txtSearchBar = new PlaceholderTextField("Search Employee  ");
         txtSearchBar.setPreferredSize(new Dimension(109, 45));
         txtSearchBar.setHorizontalAlignment(SwingConstants.RIGHT);        
         txtSearchBar.setBorder(new LineBorder(new Color(26, 24, 87)));
         txtSearchBar.setBackground(new Color(255, 255, 255));
         txtSearchBar.setBounds(192, 46, 587, 38);
         txtSearchBar.setColumns(50);
          
         //icon of search button
         icnSearch = new ImageIcon("/Users/PANPAN/eclipse-workspace/Book_Keeper/img/searchIcon.png");//insert nyo path file nyo papuntang image
         //ImageIcon icnSearch = new ImageIcon("D:\\documents\\Final_Project\\img\\searchIcon.png");
         imgSearch = icnSearch.getImage();
         rsdImgSearch = imgSearch.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
       
         //create button
         btnSearch = new JButton("");
         btnSearch.setBounds(0, 0, 40, 38);
         btnSearch.setIcon(new ImageIcon(rsdImgSearch));
         btnSearch.setContentAreaFilled(false);
         btnSearch.setOpaque(false);
         btnSearch.setBorderPainted(false);
                                        
         //Action listener for search button
         btnSearch.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 tableModel.setRowCount(0);
                 scrlSearchResults.setViewportView(table);

                 try {
                     // Establish database connection
                     String getSearch = txtSearchBar.getText().trim();
                     Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_keeper", "root", "");
                     String getQuery = "";
                     
                     // Check for empty search
                     if (getSearch.isEmpty()||getSearch.equals("Search Employee  ") ) {
                         getQuery = "SELECT patron_id, patron_fname, patron_lname, patron_email, patron_contact, patron_address, patron_status "
         	            		+ "FROM patron "
         	            		+ "ORDER BY patron_lname ASC";
                     } else {
                         getQuery = searchQuery(getSearch);
                     }

                     // Execute the SQL query
                     Statement statement = connection.createStatement();
                     ResultSet resultSet = statement.executeQuery(getQuery);

                     // Get the metadata for column information
                     ResultSetMetaData metaData = resultSet.getMetaData();
                     int columnCount = metaData.getColumnCount();

                     // Create an array to store column names
                     String[] columnNames = new String[columnCount];
                     for (int i = 1; i <= columnCount; i++) {
                         columnNames[i - 1] = metaData.getColumnName(i);
                     }

                     // Set the column names in the table model
                     tableModel.setColumnIdentifiers(columnNames);

                     while (resultSet.next()) {
                         Object[] rowData = new Object[columnCount];
                         for (int i = 1; i <= columnCount; i++) {
                             rowData[i - 1] = resultSet.getObject(i);
                         }
                         tableModel.addRow(rowData);
                     }

                     // Close the database connection
                     resultSet.close();
                     statement.close();
                     connection.close();
                 } catch (SQLException e1) {
                     e1.printStackTrace();
                 }
             }
         });
         
         
         scrlSearchResults = new JScrollPane();//add scroll pane
       
         tableModel = new DefaultTableModel();     //add table           
         table = new JTable(tableModel) {
             // Override isCellEditable method to make cells not editable
             @Override
             public boolean isCellEditable(int row, int column) {
                 return false; 
             }
         };
         
        //listener for clicking cells in table
         table.addMouseListener(new MouseAdapter() {
             @Override
             public void mouseClicked(MouseEvent e) {
                 // Get the selected row and column
                 int selectedRow = table.getSelectedRow();
                 int selectedColumn = table.getSelectedColumn();

                 // Get the value from the selected cell
                 Object selectedValue = table.getValueAt(selectedRow, selectedColumn);

                 // Display the selected value
                 int option = JOptionPane.showOptionDialog(pnlEmployee.this,"Selected Value: " + selectedValue, "Cell Value", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[] {"Exit"}, "Exit");
                 if (option == 0) {
                     // User clicked "Exit"
                     JOptionPane.getRootFrame().dispose(); // Close the JOptionPane dialog
                 }
             }
         });
 		//set what's inside the scroll pane
 		scrlSearchResults.setViewportView(table);
 		
         //Create button for adding User
         btnAddEmployee = new JButton("Add User");
         btnAddEmployee.setBorder(new EmptyBorder(5, 5, 5, 5));
         btnAddEmployee.setOpaque(true);
         btnAddEmployee.setBorderPainted(false);
         btnAddEmployee.setForeground(new Color(255, 255, 255));
         btnAddEmployee.setBackground(new Color(26, 24, 87));
         btnAddEmployee.setBounds(55, 495, 764, 29); 
         
         //Action listener for add book to show pop up
         btnAddEmployee.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
                BookInfoFrame frame = new BookInfoFrame(1);
                frame.setVisible(true);
         	}
         });
  
         //method to display books prior to displaying the library admin panel
         displayAllBooks();
         
         //layout of dashboard
         gbl_pnlWholeDisplay = new GridBagLayout();
         gbl_pnlWholeDisplay.columnWidths = new int[]{475};
         gbl_pnlWholeDisplay.rowHeights = new int[]{90, 331, 30};
         gbl_pnlWholeDisplay.columnWeights = new double[]{1.0};
         gbl_pnlWholeDisplay.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
         
         
         gbc_pnlSearchBar = new GridBagConstraints();
         gbc_pnlSearchBar.fill = GridBagConstraints.HORIZONTAL;
         gbc_pnlSearchBar.insets = new Insets(0, 0, 5, 5);
         gbc_pnlSearchBar.gridx = 0;
         gbc_pnlSearchBar.gridy = 0;



         gbc_pnlSearchResults = new GridBagConstraints();
         gbc_pnlSearchResults.fill = GridBagConstraints.BOTH;
         gbc_pnlSearchResults.insets = new Insets(0, 0, 5, 0);
         gbc_pnlSearchResults.gridx = 0;
         gbc_pnlSearchResults.gridy = 1;

         
         gbc_pnlAddEmployee = new GridBagConstraints();
         gbc_pnlAddEmployee.fill = GridBagConstraints.BOTH;
         gbc_pnlAddEmployee.insets = new Insets(0, 0, 0, 5);
         gbc_pnlAddEmployee.gridx = 0;
         gbc_pnlAddEmployee.gridy = 2;
          
         //panel layout details?

         pnlWholeDisplay.setBorder(new EmptyBorder(20, 20, 20, 20));
         pnlWholeDisplay.setLayout(gbl_pnlWholeDisplay);
         pnlAddEmployee.setLayout(new BorderLayout(0, 0)); 
         pnlSearchBtn.setBackground(new Color(255, 255, 255));
         pnlSearchBtn.setBorder(new LineBorder(new Color(0, 0, 0)));
         pnlSearchBtn.setBounds(778, 46, 41, 38);
         pnlSearchBar.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 5));
         pnlSearchResults.setLayout(new BorderLayout(0, 0));

         //add panels
         pnlSearchBar.add(lblBookKeeper);
         pnlSearchBar.add(txtSearchBar);  
         pnlSearchBtn.add(btnSearch);
         pnlSearchBar.add(pnlSearchBtn);    
         pnlWholeDisplay.add(pnlSearchBar, gbc_pnlSearchBar);
         pnlSearchResults.add(scrlSearchResults);
         pnlWholeDisplay.add(pnlSearchResults, gbc_pnlSearchResults);
         pnlAddEmployee.add(btnAddEmployee);
         pnlWholeDisplay.add(pnlAddEmployee, gbc_pnlAddEmployee);
         add(pnlWholeDisplay, BorderLayout.CENTER);
          
  
      }
 	//Methods
 	 public String searchQuery(String search) {
 	       String query = "SELECT patron_id, patron_fname, patron_lname, patron_email, patron_contact, patron_address, patron_status "
 	       		+ "FROM patron "
 	       		+ "WHERE patron_id LIKE '" +search+"%' OR patron_fname LIKE '"+search+"%' OR patron_lname LIKE '"+search+"%' "
 	       		+ "ORDER BY patron_lname ASC";
 	       return query;
 	    }

 	    private void displayAllBooks() {
 	        try {
 	            // Establish database connection
 	        	//Rekta na kasi tinamad mag assign pa ng variables same lang naman kasi db na gagamitin HAHAHAHAA
 	            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_keeper", "root", "");
 	            String getQuery = "SELECT patron_id, patron_fname, patron_lname, patron_email, patron_contact, patron_address, patron_status "
 	            		+ "FROM patron "
 	            		+ "ORDER BY patron_lname ASC";

 	            // Execute the SQL query
 	            Statement statement = connection.createStatement();
 	            ResultSet resultSet = statement.executeQuery(getQuery); 

 	            // Get the metadata for column information
 	            ResultSetMetaData metaData = resultSet.getMetaData();
 	            int columnCount = metaData.getColumnCount();

 	            // Create an array to store column names
 	            String[] columnNames = new String[columnCount];
 	            for (int i = 1; i <= columnCount; i++) {
 	                columnNames[i - 1] = metaData.getColumnName(i);
 	            }

 	            // Set the column names in the table model
 	            tableModel.setColumnIdentifiers(columnNames);
 	            
 	            //Retrieve all row data
 	            while (resultSet.next()) {
 	                Object[] rowData = new Object[columnCount];
 	                for (int i = 1; i <= columnCount; i++) {
 	                    rowData[i - 1] = resultSet.getObject(i);
 	                }
 	                tableModel.addRow(rowData);
 	            }

 	            // Close the database connection
 	            resultSet.close();
 	            statement.close();
 	            connection.close();
 	        } catch (SQLException e) {
 	            e.printStackTrace();
 	        }
 	    }
 }
