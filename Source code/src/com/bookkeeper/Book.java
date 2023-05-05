package com.bookkeeper;

public class Book {
	private int Book_id;
	private String Book_title;
	private int Book_genre_id;
	private int Book_author_id;
	private String Book_publication_date;
	private int Book_publisher_id;
	private String Book_ISBN;
	
	//Constructor
	public Book() {
		// TODO Auto-generated constructor stub
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
	public int getBookGenre_id() {
		return Book_genre_id;
	}
	public void setBookGenre_id(int genre_id) {
		Book_genre_id = genre_id;
	}
	public int getBookAuthor_id() {
		return Book_author_id;
	}
	public void setBookAuthor_id(int author_id) {
		Book_author_id = author_id;
	}
	public String getBook_publication_date() {
		return Book_publication_date;
	}
	public void setBook_publication_date(String book_publication_date) {
		Book_publication_date = book_publication_date;
	}
	public int getBookPublisher_id() {
		return Book_publisher_id;
	}
	public void setBookPublisher_id(int publisher_id) {
		this.Book_publisher_id = publisher_id;
	}
	public String getBook_ISBN() {
		return Book_ISBN;
	}
	public void setBook_ISBN(String book_ISBN) {
		Book_ISBN = book_ISBN;
	}
	
	//Methods
	
	public void addBooks() {
		
	}
	public void deleteBooks() {
		
	}
	public void editBooks() {
		
	}
}
