package main.java.models;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Alert;
import main.java.utils.AlertClass;

/** This class represents a user in the library system
 *
 */

public class User {
	//user class attributes
	protected String userID;
	protected String name;
	private List<Book> borrowedBooks; //List to track borrowed books

	//Constructor to initialize user details
	public User(String userID, String name) {
		this.userID = userID;
		this.name = name;
		this.borrowedBooks  = new ArrayList<>();
	}

	//getter method for userID
	public String getUserID() {
		return userID;
	}
	//getter method for name
	public String getName() {
		return name;
	}

	//method to issue book
	public void issueBook(Book book) {
		if (book.getAvailability()){
			book.borrowBook();
			borrowedBooks.add(book); //adding the borrowed book to the list of borrowed books
			AlertClass.showAlert(Alert.AlertType.INFORMATION,"Success","Book borrowed successfully!!");
		}else {
			AlertClass.showAlert(Alert.AlertType.ERROR,"Opps!! ", "Book is currently not available for borrowing");
		}

	}

	//method to return book
	public void returnBook(Book book) {
		if(!book.getAvailability()) {
			book.returnBook();
			borrowedBooks.remove(book); //remove the returned book from the list
			AlertClass.showAlert(Alert.AlertType.INFORMATION,"Success","Book returned Successfully!!");
		}else {
			AlertClass.showAlert(Alert.AlertType.ERROR,"Book is already available", "It looks like this books is already available, Contact admin for support");
		}

	}

	//method for searching books by title or author
	public List<Book> searchBooks(Library library, String searchTerm) {
		List<Book> results = library.searchBooks(searchTerm);
		return results;
	}

	//Method to view all books currently issued to the user
	public List<Book> viewIssuedBooks() {
		return borrowedBooks ;
	}

}
