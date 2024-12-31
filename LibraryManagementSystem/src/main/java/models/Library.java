package main.java.models;

import java.util.ArrayList;
import java.util.List;
/**
 * This class manages the library's collection of books and users
 */
public class Library{
	private ArrayList<Book> books;
	private List<User> users;

	//constructor to initialize the library
	public Library() {
		books = new ArrayList<>();
		users = new ArrayList<>();
	}

	//method to add a new book

	public void addBook(Book book) {
		books.add(book);
	}
	//method to remove a book
	public void removeBook(Book book) {
		books.remove(book);
	}
	//method to search for books by title or author
	public List<Book> searchBooks(String searchTerm1){
		List<Book> result = new ArrayList<>();
		for(Book book : books) {
			if(book.getTitle().equalsIgnoreCase(searchTerm1) || book.getAuthor().equalsIgnoreCase(searchTerm1)) {
				result.add(book);
			}
		}
		return result;
	}
	//method to add a new user
	public void addUser(User user) {
		users.add(user);
	}

	//method to remove a user
	public void removeUser(User user) {
		users.remove(user);
	}

	//method to get all books
	public List<Book> getBook(){
		return books;
	}

	//method to get all users
	public List<User> getUsers() {
		return users;
	}
}
