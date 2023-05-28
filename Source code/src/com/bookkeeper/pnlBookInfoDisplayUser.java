package com.bookkeeper;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class pnlBookInfoDisplayUser extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtAuthorUser;
	private JTextField txtPublisherUser;
	private JTextField txtPublicationDateUser;
	private JTextField txtGenre;
	private JTextField txtShelfNumberUser;
	private JTextField txtAisleNumberUser;
	private JTextField txtTitleUser;
	private JTextField txtAvail;
	private JButton btnCancelUser;
	
public pnlBookInfoDisplayUser(Book book) {
	setLayout(null);
	txtTitleUser = new JTextField();
	txtTitleUser.setText(book.getBook_title());
	txtTitleUser.setOpaque(false);
	txtTitleUser.setForeground(new Color(23, 21, 77));
	txtTitleUser.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 30));
	txtTitleUser.setEditable(false);
	txtTitleUser.setColumns(10);
	txtTitleUser.setBorder(null);
	txtTitleUser.setBounds(28, 85, 528, 52);
	add(txtTitleUser);
	
	
	JPanel pnlBookDetailsUser = new JPanel();
	pnlBookDetailsUser.setLayout(null);
	pnlBookDetailsUser.setBounds(28, 164, 528, 147);
	add(pnlBookDetailsUser);
	
	JPanel pnlAuthorUser = new JPanel();
	pnlAuthorUser.setLayout(null);
	pnlAuthorUser.setBounds(0, 0, 528, 30);
	pnlBookDetailsUser.add(pnlAuthorUser);
	
	JLabel lblAuthorUser = new JLabel("Book Author:");
	lblAuthorUser.setFont(new Font("Verdana", Font.PLAIN, 13));
	lblAuthorUser.setBounds(0, 0, 116, 30);
	pnlAuthorUser.add(lblAuthorUser);
	
	txtAuthorUser = new JTextField();
	txtAuthorUser.setText(book.getBook_author());
	txtAuthorUser.setOpaque(false);
	txtAuthorUser.setFont(new Font("Verdana", Font.ITALIC, 13));
	txtAuthorUser.setEditable(false);
	txtAuthorUser.setColumns(10);
	txtAuthorUser.setBorder(null);
	txtAuthorUser.setBounds(128, 1, 400, 30);
	pnlAuthorUser.add(txtAuthorUser);
	
	JPanel pnlPublisherUser = new JPanel();
	pnlPublisherUser.setLayout(null);
	pnlPublisherUser.setBounds(0, 34, 528, 30);
	pnlBookDetailsUser.add(pnlPublisherUser);
	
	JLabel lblPublisherUser = new JLabel("Publisher:");
	lblPublisherUser.setFont(new Font("Verdana", Font.PLAIN, 13));
	lblPublisherUser.setBounds(0, 0, 116, 30);
	pnlPublisherUser.add(lblPublisherUser);
	
	txtPublisherUser = new JTextField();
	txtPublisherUser.setText(book.getBook_publisher());
	txtPublisherUser.setOpaque(false);
	txtPublisherUser.setFont(new Font("Verdana", Font.ITALIC, 13));
	txtPublisherUser.setEditable(false);
	txtPublisherUser.setColumns(10);
	txtPublisherUser.setBorder(null);
	txtPublisherUser.setBounds(128, 1, 400, 30);
	pnlPublisherUser.add(txtPublisherUser);
	
	JPanel pnlPublicationDateUser = new JPanel();
	pnlPublicationDateUser.setLayout(null);
	pnlPublicationDateUser.setBounds(0, 67, 528, 30);
	pnlBookDetailsUser.add(pnlPublicationDateUser);
	
	JLabel lblPublicationDateUser = new JLabel("Publication Date:");
	lblPublicationDateUser.setFont(new Font("Verdana", Font.PLAIN, 13));
	lblPublicationDateUser.setBounds(0, 0, 117, 30);
	pnlPublicationDateUser.add(lblPublicationDateUser);
	
	txtPublicationDateUser = new JTextField();
	txtPublicationDateUser.setText(book.getBook_publication_date());
	txtPublicationDateUser.setOpaque(false);
	txtPublicationDateUser.setFont(new Font("Verdana", Font.ITALIC, 13));
	txtPublicationDateUser.setEditable(false);
	txtPublicationDateUser.setColumns(10);
	txtPublicationDateUser.setBorder(null);
	txtPublicationDateUser.setBounds(128, 1, 400, 30);
	pnlPublicationDateUser.add(txtPublicationDateUser);
	
	JPanel pnlISBNUser = new JPanel();
	pnlISBNUser.setLayout(null);
	pnlISBNUser.setBounds(0, 100, 528, 30);
	pnlBookDetailsUser.add(pnlISBNUser);
	
	JLabel lblGenre = new JLabel("Genre:");
	lblGenre.setFont(new Font("Verdana", Font.PLAIN, 13));
	lblGenre.setBounds(0, 0, 117, 30);
	pnlISBNUser.add(lblGenre);
	
	txtGenre = new JTextField();
	txtGenre.setText(book.getBook_genre());
	txtGenre.setOpaque(false);
	txtGenre.setFont(new Font("Verdana", Font.ITALIC, 13));
	txtGenre.setEditable(false);
	txtGenre.setColumns(10);
	txtGenre.setBorder(null);
	txtGenre.setBounds(128, 1, 400, 30);
	pnlISBNUser.add(txtGenre);
	

	JSeparator separatorUser = new JSeparator();
	separatorUser.setOpaque(true);
	separatorUser.setBackground(new Color(23, 21, 77));
	separatorUser.setBounds(28, 348, 528, 12);
	add(separatorUser);
	
	
	JPanel pnlLocandStatusDetailsUser = new JPanel();
	pnlLocandStatusDetailsUser.setLayout(null);
	pnlLocandStatusDetailsUser.setBounds(28, 372, 528, 233);
	add(pnlLocandStatusDetailsUser);
	
	JLabel lblBookLocationUser = new JLabel("Location");
	lblBookLocationUser.setForeground(new Color(23, 21, 77));
	lblBookLocationUser.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 16));
	lblBookLocationUser.setBounds(0, 6, 120, 30);
	pnlLocandStatusDetailsUser.add(lblBookLocationUser);
	
	JPanel pnlShelfNumberUser = new JPanel();
	pnlShelfNumberUser.setBounds(0, 36, 528, 30);
	pnlLocandStatusDetailsUser.add(pnlShelfNumberUser);
	pnlShelfNumberUser.setLayout(null);
	
	JLabel lblShelfNumberUser = new JLabel("Shelf Number:");
	lblShelfNumberUser.setFont(new Font("Verdana", Font.PLAIN, 13));
	lblShelfNumberUser.setBounds(-1, 0, 117, 30);
	pnlShelfNumberUser.add(lblShelfNumberUser);
	
	txtShelfNumberUser = new JTextField();
	txtShelfNumberUser.setText(book.getShelf());
	txtShelfNumberUser.setOpaque(false);
	txtShelfNumberUser.setFont(new Font("Verdana", Font.ITALIC, 13));
	txtShelfNumberUser.setEditable(false);
	txtShelfNumberUser.setColumns(10);
	txtShelfNumberUser.setBorder(null);
	txtShelfNumberUser.setBounds(128, 1, 400, 30);
	pnlShelfNumberUser.add(txtShelfNumberUser);
	
	JPanel pnlAisleNumberUSer = new JPanel();
	pnlAisleNumberUSer.setBounds(0, 71, 528, 30);
	pnlLocandStatusDetailsUser.add(pnlAisleNumberUSer);
	pnlAisleNumberUSer.setLayout(null);
	
	JLabel lblAisleNumberUser = new JLabel("Aisle Number:");
	lblAisleNumberUser.setFont(new Font("Verdana", Font.PLAIN, 13));
	lblAisleNumberUser.setBounds(0, 0, 117, 30);
	pnlAisleNumberUSer.add(lblAisleNumberUser);
	
	txtAisleNumberUser = new JTextField();
	txtAisleNumberUser.setText(book.getAisle());
	txtAisleNumberUser.setOpaque(false);
	txtAisleNumberUser.setFont(new Font("Verdana", Font.ITALIC, 13));
	txtAisleNumberUser.setEditable(false);
	txtAisleNumberUser.setColumns(10);
	txtAisleNumberUser.setBorder(null);
	txtAisleNumberUser.setBounds(128, 1, 400, 30);
	pnlAisleNumberUSer.add(txtAisleNumberUser);
	
	JPanel pnlAvailabilityUser = new JPanel();
	pnlAvailabilityUser.setLayout(null);
	pnlAvailabilityUser.setBounds(0, 186, 528, 30);
	pnlLocandStatusDetailsUser.add(pnlAvailabilityUser);
	
	JLabel lblBookAvailableStatusUser = new JLabel("Availability:");
	lblBookAvailableStatusUser.setFont(new Font("Verdana", Font.PLAIN, 13));
	lblBookAvailableStatusUser.setBounds(0, 0, 117, 30);
	pnlAvailabilityUser.add(lblBookAvailableStatusUser);
	
	txtAvail = new JTextField();
	txtAvail.setEditable(false);
	txtAvail.setText(book.getBook_status());
	txtAvail.setOpaque(false);
	txtAvail.setFont(new Font("Verdana", Font.ITALIC, 13));
	txtAvail.setColumns(10);
	txtAvail.setBorder(null);
	txtAvail.setBounds(128, 0, 400, 30);
	pnlAvailabilityUser.add(txtAvail);
	
	JLabel lblAvailabilityUser = new JLabel("Availability");
	lblAvailabilityUser.setBounds(0, 142, 120, 30);
	pnlLocandStatusDetailsUser.add(lblAvailabilityUser);
	lblAvailabilityUser.setForeground(new Color(23, 21, 77));
	lblAvailabilityUser.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 16));
	
	JSeparator separator2User = new JSeparator();
	separator2User.setBounds(0, 117, 528, 12);
	pnlLocandStatusDetailsUser.add(separator2User);
	separator2User.setOpaque(true);
	separator2User.setBackground(new Color(23, 21, 77));
	
	
	
	btnCancelUser = new JButton("Cancel");

	btnCancelUser.setOpaque(true);
	btnCancelUser.setForeground(Color.WHITE);
	btnCancelUser.setFont(new Font("Verdana", Font.ITALIC, 13));
	btnCancelUser.setBorderPainted(false);
	btnCancelUser.setBackground(new Color(23, 22, 77));
	btnCancelUser.setBounds(302, 617, 250, 29);
	add(btnCancelUser);
	
	JButton btnReserveUser = new JButton("Reserve");
	btnReserveUser.setOpaque(true);
	btnReserveUser.setForeground(Color.WHITE);
	btnReserveUser.setFont(new Font("Verdana", Font.ITALIC, 13));
	btnReserveUser.setBorderPainted(false);
	btnReserveUser.setBackground(new Color(23, 22, 77));
	btnReserveUser.setBounds(26, 617, 250, 29);
	add(btnReserveUser);
	
	}
public JButton getCancelPatronDisplay() {
	return btnCancelUser;
}
}
