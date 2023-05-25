package com.bookkeeper;

public class Book {
	private int Book_id;
	private String Book_title;
	private String Book_genre;
	private String Book_author;
	private String Book_publication_date;
	private String Book_publisher;
	private String Book_status;
	private int aisle;
	private int shelf;
	
	//Constructor
	public Book(int Book_id, String Book_title, String Book_genre, String Book_author, String Book_publication_date, String Book_publisher, String Book_status, int aisle, int shelf ) {
		this.Book_title = Book_title;
		this.Book_id = Book_id;
		this.Book_genre = Book_genre;
		this.Book_author = Book_author;
		this.Book_publication_date = Book_publication_date;
		this.Book_publisher = Book_publisher;
		this.Book_status = Book_status;
		this.aisle = aisle;
		this.shelf = shelf;
	}
	//Mutator and accessor
	public int getBook_id() {
		return Book_id;
	}
	public void setBook_id(int book_id) {
		Book_id = book_id;
	}
	public String getBook_title() {
		return Book_title;
	}
	public void setBook_title(String book_title) {
		Book_title = book_title;
	}
	public String getBook_publication_date() {
		return Book_publication_date;
	}
	public void setBook_publication_date(String book_publication_date) {
		Book_publication_date = book_publication_date;
	}
	
	//Methods
	
	public void addBooks() {
		
	}
	public void deleteBooks() {
		
	}
	public void editBooks() {
		
	}
	public String getBook_genre() {
		return Book_genre;
	}
	public void setBook_genre(String book_genre) {
		Book_genre = book_genre;
	}
	public String getBook_author() {
		return Book_author;
	}
	public void setBook_author(String book_author) {
		Book_author = book_author;
	}
	public String getBook_publisher() {
		return Book_publisher;
	}
	public void setBook_publisher(String book_publisher) {
		Book_publisher = book_publisher;
	}
	public String getBook_status() {
		return Book_status;
	}
	public void setBook_status(String book_status) {
		Book_status = book_status;
	}
	public String getAisle() {
		return Integer.toString(aisle);
	}
	public void setAisle(int aisle) {
		this.aisle = aisle;
	}
	public String getShelf() {
		return Integer.toString(shelf);
	}
	public void setShelf(int shelf) {
		this.shelf = shelf;
	}
}
