package main.java.models;

/** This class represents an Admin user in the library system with additional privileges
 * 
 */
public class Admin extends User {
	
	//Constructor to initialize admin details
	public Admin(String userID, String name) {
		super(userID, name);
	}
	// method to add a new book to the library 
	public void addBook(Library library, Book book) {
		library.addBook(book);
		
	}
	//method to remove a book from the Library
	public void removeBook(Library library, Book book) {
		library.removeBook(book);
		
	}
	
	//Add a user to the Library
	public void addUser(Library library, User user) {
		library.addUser(user);
		
	}
	//Remove a user from the library
	public void removeUser(Library library, User user) {
		library.removeUser(user);
	}

}
