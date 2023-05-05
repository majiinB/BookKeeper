package com.bookkeeper;

public class Book {
	private int Book_id;
	private String Book_title;
	private int Genre_id;
	private int Author_id;
	private String Book_publication_date;
	private int publisher_id;
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
	public int getGenre_id() {
		return Genre_id;
	}
	public void setGenre_id(int genre_id) {
		Genre_id = genre_id;
	}
	public int getAuthor_id() {
		return Author_id;
	}
	public void setAuthor_id(int author_id) {
		Author_id = author_id;
	}
	public String getBook_publication_date() {
		return Book_publication_date;
	}
	public void setBook_publication_date(String book_publication_date) {
		Book_publication_date = book_publication_date;
	}
	public int getPublisher_id() {
		return publisher_id;
	}
	public void setPublisher_id(int publisher_id) {
		this.publisher_id = publisher_id;
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
