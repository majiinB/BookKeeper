package com.bookkeeper;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class pnlBookInfoDisplayAdmin extends JPanel{
	private JTextField txtTitleAdmin;
	private JTextField txtAuthorAdmin;
	private JLabel lblAuthorAdmin;
	private JButton btnCancelAdmin;
	private JButton btnEditInfoAdmin;
	private JTextField txtBookPublisherAdmin;
	private JTextField txtPublicationDateAdmin;
	private JTextField txtIsbnAdmin;
	private JTextField txtShelfNumberAdmin;
	private JTextField txtAisleNumberAdmin;
	private JTextField txtNameOfBorrowerAdmin;
	private JTextField txtDateLoanedAdmin;
	private JTextField txtDueDateAdmin;
	private JTextField txtContactNumberAdmin;
	private JTextField txtEmailAddressAdmin;
	private JTextField txtAddressAdmin;
public pnlBookInfoDisplayAdmin() {
	setLayout(null);
	
	
	txtTitleAdmin = new JTextField();
	txtTitleAdmin.setForeground(new Color(23, 21, 77));
	txtTitleAdmin.setEditable(false);
	txtTitleAdmin.setText("Book Title Book Title Book ");
	txtTitleAdmin.setOpaque(false);
	txtTitleAdmin.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 30));
	txtTitleAdmin.setColumns(10);
	txtTitleAdmin.setBorder(null);
	txtTitleAdmin.setBounds(30, 6, 528, 46);
	add(txtTitleAdmin);
	
	JPanel pnlBookDetailsAdmin = new JPanel();
	pnlBookDetailsAdmin.setBounds(30, 49, 528, 334);
	add(pnlBookDetailsAdmin);
	pnlBookDetailsAdmin.setLayout(null);
	
	JPanel pnlAuthorAdmin = new JPanel();
	pnlAuthorAdmin.setBounds(0, 0, 528, 30);
	pnlBookDetailsAdmin.add(pnlAuthorAdmin);
	pnlAuthorAdmin.setLayout(null);
	
	lblAuthorAdmin = new JLabel("Book Author:");
	lblAuthorAdmin.setBounds(0, 0, 116, 30);
	pnlAuthorAdmin.add(lblAuthorAdmin);
	lblAuthorAdmin.setFont(new Font("Verdana", Font.PLAIN, 13));
	
	txtAuthorAdmin = new JTextField();
	txtAuthorAdmin.setEditable(false);
	txtAuthorAdmin.setBounds(128, 1, 400, 30);
	pnlAuthorAdmin.add(txtAuthorAdmin);
	txtAuthorAdmin.setText("Book Author");
	txtAuthorAdmin.setOpaque(false);
	txtAuthorAdmin.setFont(new Font("Verdana", Font.ITALIC, 13));
	txtAuthorAdmin.setColumns(10);
	txtAuthorAdmin.setBorder(null);
	
	JPanel pnlPublisherAdmin = new JPanel();
	pnlPublisherAdmin.setBounds(0, 34, 528, 30);
	pnlBookDetailsAdmin.add(pnlPublisherAdmin);
	pnlPublisherAdmin.setLayout(null);
	
	JLabel lblPublisherAdmin = new JLabel("Publisher:");
	lblPublisherAdmin.setFont(new Font("Verdana", Font.PLAIN, 13));
	lblPublisherAdmin.setBounds(0, 0, 116, 30);
	pnlPublisherAdmin.add(lblPublisherAdmin);
	
	txtBookPublisherAdmin = new JTextField();
	txtBookPublisherAdmin.setEditable(false);
	txtBookPublisherAdmin.setText("Book Publisher");
	txtBookPublisherAdmin.setOpaque(false);
	txtBookPublisherAdmin.setFont(new Font("Verdana", Font.ITALIC, 13));
	txtBookPublisherAdmin.setColumns(10);
	txtBookPublisherAdmin.setBorder(null);
	txtBookPublisherAdmin.setBounds(128, 1, 400, 30);
	pnlPublisherAdmin.add(txtBookPublisherAdmin);
	
	JPanel pnlPublicationDateAdmin = new JPanel();
	pnlPublicationDateAdmin.setBounds(0, 67, 528, 30);
	pnlBookDetailsAdmin.add(pnlPublicationDateAdmin);
	pnlPublicationDateAdmin.setLayout(null);
	
	JLabel lblPublicationDateAdmin = new JLabel("Publication Date:");
	lblPublicationDateAdmin.setFont(new Font("Verdana", Font.PLAIN, 13));
	lblPublicationDateAdmin.setBounds(0, 0, 117, 30);
	pnlPublicationDateAdmin.add(lblPublicationDateAdmin);
	
	txtPublicationDateAdmin = new JTextField();
	txtPublicationDateAdmin.setEditable(false);
	txtPublicationDateAdmin.setText("Publication Date");
	txtPublicationDateAdmin.setOpaque(false);
	txtPublicationDateAdmin.setFont(new Font("Verdana", Font.ITALIC, 13));
	txtPublicationDateAdmin.setColumns(10);
	txtPublicationDateAdmin.setBorder(null);
	txtPublicationDateAdmin.setBounds(128, 1, 400, 30);
	pnlPublicationDateAdmin.add(txtPublicationDateAdmin);
	
	JPanel pnlISBNAdmin = new JPanel();
	pnlISBNAdmin.setBounds(0, 100, 528, 30);
	pnlBookDetailsAdmin.add(pnlISBNAdmin);
	pnlISBNAdmin.setLayout(null);
	
	JLabel lblISBNAdmin = new JLabel("ISBN:");
	lblISBNAdmin.setFont(new Font("Verdana", Font.PLAIN, 13));
	lblISBNAdmin.setBounds(0, 0, 117, 30);
	pnlISBNAdmin.add(lblISBNAdmin);
	
	txtIsbnAdmin = new JTextField();
	txtIsbnAdmin.setEditable(false);
	txtIsbnAdmin.setText("ISBN");
	txtIsbnAdmin.setOpaque(false);
	txtIsbnAdmin.setFont(new Font("Verdana", Font.ITALIC, 13));
	txtIsbnAdmin.setColumns(10);
	txtIsbnAdmin.setBorder(null);
	txtIsbnAdmin.setBounds(128, 1, 400, 30);
	pnlISBNAdmin.add(txtIsbnAdmin);
	
	JPanel pnlShelfNumberAdmin = new JPanel();
	pnlShelfNumberAdmin.setBounds(0, 134, 528, 30);
	pnlBookDetailsAdmin.add(pnlShelfNumberAdmin);
	pnlShelfNumberAdmin.setLayout(null);
	
	JLabel lblShelfNumberAdmin = new JLabel("Shelf Number:");
	lblShelfNumberAdmin.setFont(new Font("Verdana", Font.PLAIN, 13));
	lblShelfNumberAdmin.setBounds(0, 0, 117, 30);
	pnlShelfNumberAdmin.add(lblShelfNumberAdmin);
	
	txtShelfNumberAdmin = new JTextField();
	txtShelfNumberAdmin.setEditable(false);
	txtShelfNumberAdmin.setText("Shelf Number");
	txtShelfNumberAdmin.setOpaque(false);
	txtShelfNumberAdmin.setFont(new Font("Verdana", Font.ITALIC, 13));
	txtShelfNumberAdmin.setColumns(10);
	txtShelfNumberAdmin.setBorder(null);
	txtShelfNumberAdmin.setBounds(128, 1, 400, 30);
	pnlShelfNumberAdmin.add(txtShelfNumberAdmin);
	
	JPanel pnlAisleNumberAdmin = new JPanel();
	pnlAisleNumberAdmin.setBounds(0, 168, 528, 30);
	pnlBookDetailsAdmin.add(pnlAisleNumberAdmin);
	pnlAisleNumberAdmin.setLayout(null);
	
	JLabel lblAisleNumberAdmin = new JLabel("Aisle Number:");
	lblAisleNumberAdmin.setFont(new Font("Verdana", Font.PLAIN, 13));
	lblAisleNumberAdmin.setBounds(0, 0, 117, 30);
	pnlAisleNumberAdmin.add(lblAisleNumberAdmin);
	
	txtAisleNumberAdmin = new JTextField();
	txtAisleNumberAdmin.setEditable(false);
	txtAisleNumberAdmin.setText("Aisle Number");
	txtAisleNumberAdmin.setOpaque(false);
	txtAisleNumberAdmin.setFont(new Font("Verdana", Font.ITALIC, 13));
	txtAisleNumberAdmin.setColumns(10);
	txtAisleNumberAdmin.setBorder(null);
	txtAisleNumberAdmin.setBounds(128, 1, 400, 30);
	pnlAisleNumberAdmin.add(txtAisleNumberAdmin);
	
	JPanel pnlAvailabilityAdmin = new JPanel();
	pnlAvailabilityAdmin.setLayout(null);
	pnlAvailabilityAdmin.setBounds(0, 205, 528, 36);
	pnlBookDetailsAdmin.add(pnlAvailabilityAdmin);
	
	JLabel lblAvailabilityAdmin = new JLabel("Availability:");
	lblAvailabilityAdmin.setFont(new Font("Verdana", Font.PLAIN, 13));
	lblAvailabilityAdmin.setBounds(0, 0, 117, 30);
	pnlAvailabilityAdmin.add(lblAvailabilityAdmin);
	
	JComboBox cmbAvailabilityAdmin = new JComboBox();
	cmbAvailabilityAdmin.setBounds(120, 4, 158, 27);
	cmbAvailabilityAdmin.addItem("Reserved");
	cmbAvailabilityAdmin.addItem("Available");
	cmbAvailabilityAdmin.addItem("Unavailable");
    
    JSeparator separator2User = new JSeparator();
    separator2User.setOpaque(true);
    separator2User.setBackground(new Color(23, 21, 77));
    separator2User.setBounds(0, 113, 528, 12);
    add(separator2User);
	pnlAvailabilityAdmin.add(cmbAvailabilityAdmin);
	
	JPanel pnlGenreAdmin = new JPanel();
	pnlGenreAdmin.setLayout(null);
	pnlGenreAdmin.setBounds(0, 245, 528, 89);
	pnlBookDetailsAdmin.add(pnlGenreAdmin);
	
	JLabel lblGenreAdmin = new JLabel("Genre:");
	lblGenreAdmin.setFont(new Font("Verdana", Font.PLAIN, 13));
	lblGenreAdmin.setBounds(0, 0, 117, 30);
	pnlGenreAdmin.add(lblGenreAdmin);
	
	JList lstGenreAdmin = new JList();
	lstGenreAdmin.setBounds(10, 30, 512, 50);
	pnlGenreAdmin.add(lstGenreAdmin);
	
	
	JSeparator separator = new JSeparator();
	separator.setOpaque(true);
	separator.setBackground(new Color(23, 21, 77));
	separator.setBounds(30, 334, 528, 12);
	add(separator);
	
	
	JPanel pnlBorrowerDetailsAdmin = new JPanel();
	pnlBorrowerDetailsAdmin.setLayout(null);
	pnlBorrowerDetailsAdmin.setBounds(30, 384, 528, 239);
	add(pnlBorrowerDetailsAdmin);
	
	JLabel lblBorrowersInformationAdmin = new JLabel("Borrower's Information");
	lblBorrowersInformationAdmin.setForeground(new Color(23, 21, 77));
	lblBorrowersInformationAdmin.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 14));
	lblBorrowersInformationAdmin.setBounds(0, 0, 241, 30);
	pnlBorrowerDetailsAdmin.add(lblBorrowersInformationAdmin);
	
	JPanel pnlBNameAdmin = new JPanel();
	pnlBNameAdmin.setLayout(null);
	pnlBNameAdmin.setBounds(0, 25, 528, 30);
	pnlBorrowerDetailsAdmin.add(pnlBNameAdmin);
	
	JLabel lblBNameAdmin = new JLabel("Name:");
	lblBNameAdmin.setFont(new Font("Verdana", Font.PLAIN, 13));
	lblBNameAdmin.setBounds(0, 0, 116, 30);
	pnlBNameAdmin.add(lblBNameAdmin);
	
	txtNameOfBorrowerAdmin = new JTextField();
	txtNameOfBorrowerAdmin.setEditable(false);
	txtNameOfBorrowerAdmin.setText("Name of borrower");
	txtNameOfBorrowerAdmin.setOpaque(false);
	txtNameOfBorrowerAdmin.setFont(new Font("Verdana", Font.ITALIC, 13));
	txtNameOfBorrowerAdmin.setBorder(null);
	txtNameOfBorrowerAdmin.setColumns(10);
	txtNameOfBorrowerAdmin.setBounds(128, 1, 400, 30);
	pnlBNameAdmin.add(txtNameOfBorrowerAdmin);
	
	JPanel pnlDateLoanedAdmin = new JPanel();
	pnlDateLoanedAdmin.setLayout(null);
	pnlDateLoanedAdmin.setBounds(0, 60, 528, 30);
	pnlBorrowerDetailsAdmin.add(pnlDateLoanedAdmin);
	
	JLabel lblDateLoanedAdmin = new JLabel("Date Loaned:");
	lblDateLoanedAdmin.setFont(new Font("Verdana", Font.PLAIN, 13));
	lblDateLoanedAdmin.setBounds(0, 0, 116, 30);
	pnlDateLoanedAdmin.add(lblDateLoanedAdmin);
	
	txtDateLoanedAdmin = new JTextField();
	txtDateLoanedAdmin.setText("Date Loaned");
	txtDateLoanedAdmin.setOpaque(false);
	txtDateLoanedAdmin.setFont(new Font("Verdana", Font.ITALIC, 13));
	txtDateLoanedAdmin.setEditable(false);
	txtDateLoanedAdmin.setColumns(10);
	txtDateLoanedAdmin.setBorder(null);
	txtDateLoanedAdmin.setBounds(128, 1, 400, 30);
	pnlDateLoanedAdmin.add(txtDateLoanedAdmin);
	
	JPanel pnlDueDateAdmin = new JPanel();
	pnlDueDateAdmin.setLayout(null);
	pnlDueDateAdmin.setBounds(0, 95, 528, 30);
	pnlBorrowerDetailsAdmin.add(pnlDueDateAdmin);
	
	JLabel lblDueDateAdmin = new JLabel("Due Date:");
	lblDueDateAdmin.setFont(new Font("Verdana", Font.PLAIN, 13));
	lblDueDateAdmin.setBounds(0, 0, 117, 30);
	pnlDueDateAdmin.add(lblDueDateAdmin);
	
	txtDueDateAdmin = new JTextField();
	txtDueDateAdmin.setEditable(false);
	txtDueDateAdmin.setText("Due Date");
	txtDueDateAdmin.setOpaque(false);
	txtDueDateAdmin.setFont(new Font("Verdana", Font.ITALIC, 13));
	txtDueDateAdmin.setColumns(10);
	txtDueDateAdmin.setBorder(null);
	txtDueDateAdmin.setBounds(128, 1, 400, 30);
	pnlDueDateAdmin.add(txtDueDateAdmin);
	
	JPanel pnlBcontactNumberAdmin = new JPanel();
	pnlBcontactNumberAdmin.setLayout(null);
	pnlBcontactNumberAdmin.setBounds(0, 130, 528, 30);
	pnlBorrowerDetailsAdmin.add(pnlBcontactNumberAdmin);
	
	JLabel lblContactNumberAdmin = new JLabel("Contact Number:");
	lblContactNumberAdmin.setFont(new Font("Verdana", Font.PLAIN, 13));
	lblContactNumberAdmin.setBounds(0, 0, 117, 30);
	pnlBcontactNumberAdmin.add(lblContactNumberAdmin);
	
	txtContactNumberAdmin = new JTextField();
	txtContactNumberAdmin.setEditable(false);
	txtContactNumberAdmin.setText("Contact Number");
	txtContactNumberAdmin.setOpaque(false);
	txtContactNumberAdmin.setFont(new Font("Verdana", Font.ITALIC, 13));
	txtContactNumberAdmin.setBorder(null);
	txtContactNumberAdmin.setColumns(10);
	txtContactNumberAdmin.setBounds(128, 1, 400, 30);
	pnlBcontactNumberAdmin.add(txtContactNumberAdmin);
	
	JPanel pnlEmailAddressAdmin = new JPanel();
	pnlEmailAddressAdmin.setLayout(null);
	pnlEmailAddressAdmin.setBounds(0, 166, 528, 30);
	pnlBorrowerDetailsAdmin.add(pnlEmailAddressAdmin);
	
	JLabel lblEmailAddressAdmin = new JLabel("Email Address:");
	lblEmailAddressAdmin.setFont(new Font("Verdana", Font.PLAIN, 13));
	lblEmailAddressAdmin.setBounds(0, 0, 117, 30);
	pnlEmailAddressAdmin.add(lblEmailAddressAdmin);
	
	txtEmailAddressAdmin = new JTextField();
	txtEmailAddressAdmin.setEditable(false);
	txtEmailAddressAdmin.setText("Email Address");
	txtEmailAddressAdmin.setOpaque(false);
	txtEmailAddressAdmin.setFont(new Font("Verdana", Font.ITALIC, 13));
	txtEmailAddressAdmin.setColumns(10);
	txtEmailAddressAdmin.setBorder(null);
	txtEmailAddressAdmin.setBounds(128, 1, 400, 30);
	pnlEmailAddressAdmin.add(txtEmailAddressAdmin);
	
	JPanel pnlAddressAdmin = new JPanel();
	pnlAddressAdmin.setLayout(null);
	pnlAddressAdmin.setBounds(0, 204, 528, 30);
	pnlBorrowerDetailsAdmin.add(pnlAddressAdmin);
	
	JLabel lblAddressAdmin = new JLabel("Address:");
	lblAddressAdmin.setFont(new Font("Verdana", Font.PLAIN, 13));
	lblAddressAdmin.setBounds(0, 0, 117, 30);
	pnlAddressAdmin.add(lblAddressAdmin);
	
	txtAddressAdmin = new JTextField();
	txtAddressAdmin.setEditable(false);
	txtAddressAdmin.setText("Address");
	txtAddressAdmin.setOpaque(false);
	txtAddressAdmin.setFont(new Font("Verdana", Font.ITALIC, 13));
	txtAddressAdmin.setColumns(10);
	txtAddressAdmin.setBorder(null);
	txtAddressAdmin.setBounds(128, 1, 400, 30);
	pnlAddressAdmin.add(txtAddressAdmin);	
	
	
	btnCancelAdmin = new JButton("Cancel");
	btnCancelAdmin.setOpaque(true);
	btnCancelAdmin.setForeground(Color.WHITE);
	btnCancelAdmin.setFont(new Font("Verdana", Font.ITALIC, 13));
	btnCancelAdmin.setBorderPainted(false);
	btnCancelAdmin.setBackground(new Color(23, 22, 77));
	btnCancelAdmin.setBounds(308, 624, 250, 29);
	add(btnCancelAdmin);
	
	btnEditInfoAdmin = new JButton("Edit Info");
	btnEditInfoAdmin.setOpaque(true);
	btnEditInfoAdmin.setForeground(Color.WHITE);
	btnEditInfoAdmin.setFont(new Font("Verdana", Font.ITALIC, 13));
	btnEditInfoAdmin.setBorderPainted(false);
	btnEditInfoAdmin.setBackground(new Color(23, 22, 77));
	btnEditInfoAdmin.setBounds(30, 624, 250, 29);
	add(btnEditInfoAdmin);
}
}
