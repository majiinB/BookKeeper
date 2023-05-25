package com.bookkeeper;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class pnlBookBorrowAdmin extends JPanel {
	private JPanel pnlButtons;
	private JPanel  pnlPatron;
	private JPanel pnlBorrowerInfo;
	private JPanel pnlHeader;
	private JPanel pnlPublisher;
	private JPanel pnlPublicationDate;
	private JPanel pnlAuthor;
	private JPanel pnlGenreAdmin;
	private JPanel pnlAvailability ;
	private JPanel pnlBorrowBook;
	private JButton btnSaveChangesEdit;
	private JButton btnCancelEdit;
	private JLabel lblEnterPatronID;
	private JLabel lblBorrow;
	private JLabel lblAuthor;
	private JLabel lblPublicationDate;
	private JLabel lblPublisher;
	private JLabel lblGenre;
	private JLabel lblAvailability;
	private PlaceholderTextField txtEnterPatronID;
	private PlaceholderTextField txtTitle;
	private PlaceholderTextField txtAuthor;
	private PlaceholderTextField txtBookPublisher;
	private PlaceholderTextField txtPublicationDate;
	private PlaceholderTextField txtGenre;
	private PlaceholderTextField txtAvail;
	
	public pnlBookBorrowAdmin() {
		setBorder(new EmptyBorder(20, 20, 20, 60));

		pnlBorrowerInfo = new JPanel();
		//pnlButtons = new JPanel();
		pnlButtons = new JPanel();
		pnlPatron = new JPanel();
		pnlHeader = new JPanel();
		pnlPublisher = new JPanel();
		pnlAuthor = new JPanel();
		pnlPublicationDate = new JPanel();
		pnlGenreAdmin = new JPanel();
		pnlAvailability = new JPanel();
		pnlBorrowBook = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
		
		lblBorrow = new JLabel("Borrow Books");
		lblBorrow.setForeground(new Color(26, 24, 87));
		lblBorrow.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 40));
		lblBorrow.setBounds(0, 0, 116, 30);
		
		txtTitle = new PlaceholderTextField("");
		txtTitle.setEditable(false);
		txtTitle.setOpaque(true);
		txtTitle.setColumns(10);
		
		lblEnterPatronID = new JLabel("Enter Patron ID:");
		lblEnterPatronID.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblEnterPatronID.setBounds(0, 0, 116, 30);
		
		txtEnterPatronID = new PlaceholderTextField("Patron ID");
		txtEnterPatronID.setColumns(15);
		txtEnterPatronID.setBounds(128, 1, 400, 30);
		
		
		
		//book info		
		pnlAuthor.setBounds(0, 11, 528, 30);
		pnlAuthor.setLayout(null);
		
		lblAuthor = new JLabel("Book Author:");
		lblAuthor.setBounds(0, 0, 116, 30);
		lblAuthor.setFont(new Font("Verdana", Font.PLAIN, 13));
		
		txtAuthor = new PlaceholderTextField("");
		txtAuthor.setEditable(false);
		txtAuthor.setBounds(128, 1, 400, 30);
		txtAuthor.setOpaque(false);
		txtAuthor.setColumns(10);
		txtAuthor.setBorder(null);
		
		pnlPublisher.setLayout(null);
		
		lblPublisher = new JLabel("Publisher:");
		lblPublisher.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblPublisher.setBounds(0, 0, 116, 30);
		
		txtBookPublisher = new PlaceholderTextField("");
		txtBookPublisher.setEditable(false);
		txtBookPublisher.setOpaque(false);
		txtBookPublisher.setColumns(10);
		txtBookPublisher.setBorder(null);
		txtBookPublisher.setBounds(128, 1, 400, 30);
		
		pnlPublicationDate.setBounds(0, 93, 528, 30);
		pnlPublicationDate.setLayout(null);
		
		lblPublicationDate = new JLabel("Publication Date:");
		lblPublicationDate.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblPublicationDate.setBounds(0, 0, 117, 30);
		
		txtPublicationDate = new PlaceholderTextField("");
		txtPublicationDate.setOpaque(false);
		txtPublicationDate.setEditable(false);
		txtPublicationDate.setColumns(10);
		txtPublicationDate.setBorder(null);
		txtPublicationDate.setBounds(128, 0, 400, 30);

		
		pnlGenreAdmin.setLayout(null);
		pnlGenreAdmin.setBounds(0, 209, 528, 30);
		
		lblGenre = new JLabel("Genre:");
		lblGenre.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblGenre.setBounds(0, 0, 117, 30);
		
		txtGenre = new PlaceholderTextField("");
		txtGenre.setText("");
		txtGenre.setOpaque(false);
		txtGenre.setEditable(false);
		txtGenre.setColumns(10);
		txtGenre.setBorder(null);
		txtGenre.setBounds(128, 1, 400, 30);
		
		pnlAvailability.setLayout(null);
		pnlAvailability.setBounds(0, 250, 528, 30);

		
		lblAvailability = new JLabel("Availability:");
		lblAvailability.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblAvailability.setBounds(0, 0, 117, 30);

		
		txtAvail = new PlaceholderTextField("");
		txtAvail.setText("");
		txtAvail.setOpaque(false);
		txtAvail.setEditable(false);
		txtAvail.setColumns(10);
		txtAvail.setBorder(null);
		txtAvail.setBounds(128, 1, 400, 30);
		
		txtPublicationDate = new PlaceholderTextField("");
		txtPublicationDate.setBounds(128, 93, 400, 30);
		txtPublicationDate.setText("");
		txtPublicationDate.setEditable(false);
		txtPublicationDate.setOpaque(false);
		txtPublicationDate.setColumns(10);
		txtPublicationDate.setBorder(null);
		
		btnSaveChangesEdit = new JButton("Save Changes");
		btnSaveChangesEdit.setOpaque(true);
		btnSaveChangesEdit.setBorderPainted(false);
		btnSaveChangesEdit.setForeground(Color.WHITE);
		btnSaveChangesEdit.setFont(new Font("Verdana", Font.ITALIC, 13));
		btnSaveChangesEdit.setBackground(new Color(23, 22, 77));
		
		btnCancelEdit = new JButton("Cancel");
		btnCancelEdit.setOpaque(true);
		btnCancelEdit.setBorderPainted(false);
		btnCancelEdit.setForeground(Color.WHITE);
		btnCancelEdit.setFont(new Font("Verdana", Font.ITALIC, 13));
		btnCancelEdit.setBackground(new Color(23, 22, 77));

		
		pnlButtons.add(btnSaveChangesEdit);
		pnlButtons.add(btnCancelEdit);
		
		
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		pnlBorrowBook.setLayout(new GridLayout(5, 2, 0, 0));
		pnlHeader.setLayout(new GridLayout(2, 1, 0, 0));
		

		pnlPatron.add(lblEnterPatronID);
		pnlPatron.add(txtEnterPatronID);
		
		pnlBorrowerInfo.add(pnlPatron);
		pnlAuthor.add(lblAuthor);
		pnlAuthor.add(txtAuthor);
		pnlPublisher.add(lblPublisher);
		pnlPublisher.add(txtBookPublisher);
		pnlPublicationDate.add(lblPublicationDate);
		pnlPublicationDate.add(txtPublicationDate);
		pnlGenreAdmin.add(lblGenre);
		pnlGenreAdmin.add(txtGenre);
		pnlAvailability.add(lblAvailability);
		pnlAvailability.add(txtAvail);
		
		pnlBorrowBook.add(pnlBorrowerInfo);
		pnlBorrowBook.add(pnlAuthor);
		pnlBorrowBook.add(pnlPublicationDate);
		pnlBorrowBook.add(pnlGenreAdmin);
		pnlBorrowBook.add(pnlAvailability);
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		pnlHeader.add(lblBorrow);
		pnlHeader.add(txtTitle);
		add(pnlHeader);
		add(pnlBorrowBook);
		add(pnlButtons);
	}
}
