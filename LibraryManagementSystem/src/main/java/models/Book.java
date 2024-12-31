package main.java.models;

/** This class represents a book in the library system
 *
 */

public class Book {

	//book attributes
	private String title;
	private String author;
	private int ISBN;
	private Boolean availability;

	//Book class constructor
	public Book(String title, String author, int ISBN) {
		this.title = title;
		this.author = author;
		this.ISBN = ISBN;
		this.availability = true;  // Default to available when a new book is added
	}
	//getter for title
	public String getTitle() {
		return title;
	}
	//getter for Author

	public String getAuthor() {
		return author;
	}
	//getter for ISBN
	public int getISBN() {
		return ISBN;
	}
	//getter for availability

	public boolean getAvailability() {
		return availability;
	}


	//method to borrow the book
	public boolean borrowBook() {
		if (availability) {
			availability = false; // sets the book to borrowed state
			return true;
		}else {
			return false; //Book is already borrowed
		}
	}

	//method for returning the book
	public boolean returnBook() {
		if(!availability) {
			availability = true; //sets the book to available state
			return true;
		}else {
			return false; // Book was not already borrowed

		}
	}
	//representation of the book
	@Override
	public String toString() {
		return "Book ISBN: " + ISBN + ", Title: " + title + ", Author: " + author + ", Availablity: " + (availability ? "Available for borrowing" : "Not Available for borrowing");
	}
}
