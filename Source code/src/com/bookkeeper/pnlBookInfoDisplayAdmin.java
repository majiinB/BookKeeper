package com.bookkeeper;

import java.awt.Color;
import java.awt.Font;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class pnlBookInfoDisplayAdmin extends JPanel{
	private JTextField txtTitleAdmin;
	private JTextField txtAuthorAdmin;
	private JLabel lblAuthorAdmin;
	private JButton btnCancelAdmin;
	private JButton btnEditInfoAdmin;
	private JTextField txtBookPublisherAdmin;
	private JTextField txtPublicationDateAdmin;
	private JTextField txtShelfNumberAdmin;
	private JTextField txtAisleNumberAdmin;
	private JTextField txtNameOfBorrowerAdmin;
	private JTextField txtDateLoanedAdmin;
	private JTextField txtDueDateAdmin;
	private JTextField txtContactNumberAdmin;
	private JTextField txtEmailAddressAdmin;
	private JTextField txtAddressAdmin;
	private JTextField txtGenre;
	private JTextField textField_Avail;
	private JTextField txtPublicationDate;
	private JButton btnBorrowBook;
	
public pnlBookInfoDisplayAdmin(Book book) {
	setLayout(null);
	
	txtTitleAdmin = new JTextField();
	txtTitleAdmin.setForeground(new Color(23, 21, 77));
	txtTitleAdmin.setEditable(false);
	txtTitleAdmin.setText(book.getBook_title());
	txtTitleAdmin.setOpaque(true);
	txtTitleAdmin.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 20));
	txtTitleAdmin.setColumns(10);
	txtTitleAdmin.setBorder(null);
	txtTitleAdmin.setBounds(30, 43, 528, 46);
	add(txtTitleAdmin);
	
	JPanel pnlBookDetailsAdmin = new JPanel();
	pnlBookDetailsAdmin.setBounds(30, 76, 528, 282);
	add(pnlBookDetailsAdmin);
	pnlBookDetailsAdmin.setLayout(null);
	
	JPanel pnlAuthorAdmin = new JPanel();
	pnlAuthorAdmin.setBounds(0, 11, 528, 30);
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
	txtAuthorAdmin.setText(book.getBook_author());
	txtAuthorAdmin.setOpaque(false);
	txtAuthorAdmin.setFont(new Font("Verdana", Font.ITALIC, 13));
	txtAuthorAdmin.setColumns(10);
	txtAuthorAdmin.setBorder(null);
	
	JPanel pnlPublisherAdmin = new JPanel();
	pnlPublisherAdmin.setBounds(0, 52, 528, 30);
	pnlBookDetailsAdmin.add(pnlPublisherAdmin);
	pnlPublisherAdmin.setLayout(null);
	
	JLabel lblPublisherAdmin = new JLabel("Publisher:");
	lblPublisherAdmin.setFont(new Font("Verdana", Font.PLAIN, 13));
	lblPublisherAdmin.setBounds(0, 0, 116, 30);
	pnlPublisherAdmin.add(lblPublisherAdmin);
	
	txtBookPublisherAdmin = new JTextField();
	txtBookPublisherAdmin.setEditable(false);
	txtBookPublisherAdmin.setText(book.getBook_publisher());
	txtBookPublisherAdmin.setOpaque(false);
	txtBookPublisherAdmin.setFont(new Font("Verdana", Font.ITALIC, 13));
	txtBookPublisherAdmin.setColumns(10);
	txtBookPublisherAdmin.setBorder(null);
	txtBookPublisherAdmin.setBounds(128, 1, 400, 30);
	pnlPublisherAdmin.add(txtBookPublisherAdmin);
	
	JPanel pnlPublicationDateAdmin = new JPanel();
	pnlPublicationDateAdmin.setBounds(0, 93, 528, 30);
	pnlBookDetailsAdmin.add(pnlPublicationDateAdmin);
	pnlPublicationDateAdmin.setLayout(null);
	
	JLabel lblPublicationDateAdmin = new JLabel("Publication Date:");
	lblPublicationDateAdmin.setFont(new Font("Verdana", Font.PLAIN, 13));
	lblPublicationDateAdmin.setBounds(0, 0, 117, 30);
	pnlPublicationDateAdmin.add(lblPublicationDateAdmin);
	
	txtPublicationDate = new JTextField();
	txtPublicationDate.setText(book.getBook_publication_date());
	txtPublicationDate.setOpaque(false);
	txtPublicationDate.setFont(new Font("Verdana", Font.ITALIC, 13));
	txtPublicationDate.setEditable(false);
	txtPublicationDate.setColumns(10);
	txtPublicationDate.setBorder(null);
	txtPublicationDate.setBounds(128, 0, 400, 30);
	pnlPublicationDateAdmin.add(txtPublicationDate);
	
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
	txtShelfNumberAdmin.setText(book.getShelf());
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
	txtAisleNumberAdmin.setText(book.getAisle());
	txtAisleNumberAdmin.setOpaque(false);
	txtAisleNumberAdmin.setFont(new Font("Verdana", Font.ITALIC, 13));
	txtAisleNumberAdmin.setColumns(10);
	txtAisleNumberAdmin.setBorder(null);
	txtAisleNumberAdmin.setBounds(128, 1, 400, 30);
	pnlAisleNumberAdmin.add(txtAisleNumberAdmin);
	
	JPanel pnlGenreAdmin = new JPanel();
	pnlGenreAdmin.setLayout(null);
	pnlGenreAdmin.setBounds(0, 209, 528, 30);
	pnlBookDetailsAdmin.add(pnlGenreAdmin);
	
	JLabel lblGenre = new JLabel("Genre:");
	lblGenre.setFont(new Font("Verdana", Font.PLAIN, 13));
	lblGenre.setBounds(0, 0, 117, 30);
	pnlGenreAdmin.add(lblGenre);
	
	txtGenre = new JTextField();
	txtGenre.setText(book.getBook_genre());
	txtGenre.setOpaque(false);
	txtGenre.setFont(new Font("Verdana", Font.ITALIC, 13));
	txtGenre.setEditable(false);
	txtGenre.setColumns(10);
	txtGenre.setBorder(null);
	txtGenre.setBounds(128, 1, 400, 30);
	pnlGenreAdmin.add(txtGenre);
	
	JPanel pnlAvailabilityAdmin_1 = new JPanel();
	pnlAvailabilityAdmin_1.setLayout(null);
	pnlAvailabilityAdmin_1.setBounds(0, 250, 528, 30);
	pnlBookDetailsAdmin.add(pnlAvailabilityAdmin_1);
	
	JLabel lblAvailability = new JLabel("Availability:");
	lblAvailability.setFont(new Font("Verdana", Font.PLAIN, 13));
	lblAvailability.setBounds(0, 0, 117, 30);
	pnlAvailabilityAdmin_1.add(lblAvailability);
	
	textField_Avail = new JTextField();
	textField_Avail.setText(book.getBook_status());
	textField_Avail.setOpaque(false);
	textField_Avail.setFont(new Font("Verdana", Font.ITALIC, 13));
	textField_Avail.setEditable(false);
	textField_Avail.setColumns(10);
	textField_Avail.setBorder(null);
	textField_Avail.setBounds(128, 1, 400, 30);
	pnlAvailabilityAdmin_1.add(textField_Avail);
	
	txtPublicationDateAdmin = new JTextField();
	txtPublicationDateAdmin.setBounds(128, 93, 400, 30);
	txtPublicationDateAdmin.setText(book.getBook_publication_date());
	txtPublicationDateAdmin.setEditable(false);
	txtPublicationDateAdmin.setOpaque(false);
	txtPublicationDateAdmin.setFont(new Font("Verdana", Font.ITALIC, 13));
	txtPublicationDateAdmin.setColumns(10);
	txtPublicationDateAdmin.setBorder(null);
    
    JSeparator separator2User = new JSeparator();
    separator2User.setOpaque(true);
    separator2User.setBackground(new Color(23, 21, 77));
    separator2User.setBounds(30, 358, 528, 12);
    add(separator2User);
	
	
	JSeparator separator = new JSeparator();
	separator.setOpaque(true);
	separator.setBackground(new Color(23, 21, 77));
	separator.setBounds(30, 334, 528, 12);
	add(separator);
	
	
	JPanel pnlBorrowerDetailsAdmin = new JPanel();
	pnlBorrowerDetailsAdmin.setLayout(null);
	pnlBorrowerDetailsAdmin.setBounds(30, 373, 528, 239);
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
	btnCancelAdmin.setBounds(380, 612, 178, 29);
	add(btnCancelAdmin);
	
	btnEditInfoAdmin = new JButton("Edit Info");
	btnEditInfoAdmin.setOpaque(true);
	btnEditInfoAdmin.setForeground(Color.WHITE);
	btnEditInfoAdmin.setFont(new Font("Verdana", Font.ITALIC, 13));
	btnEditInfoAdmin.setBorderPainted(false);
	btnEditInfoAdmin.setBackground(new Color(23, 22, 77));
	btnEditInfoAdmin.setBounds(206, 612, 162, 29); 
	add(btnEditInfoAdmin);
	
	btnBorrowBook = new JButton("Borrow Book");
	btnBorrowBook.setOpaque(true);
	btnBorrowBook.setForeground(Color.WHITE);
	btnBorrowBook.setFont(new Font("Verdana", Font.ITALIC, 13));
	btnBorrowBook.setBorderPainted(false);
	btnBorrowBook.setBackground(new Color(23, 22, 77));
	btnBorrowBook.setBounds(30, 612, 170, 29);
	add(btnBorrowBook);
	}
	//Method
	public JButton getEditbtn() {
		return btnEditInfoAdmin;
	}
	public JButton getCancel() {
		return btnCancelAdmin;
	}
	public JButton getBorrowbtn() {
		return btnBorrowBook;
	}
}