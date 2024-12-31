package test.java.tests;
import main.java.models.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


 class AdminTest {
	 
	 private Admin admin;
	 private Library library;
	 private Book book;
	 private User user;
	 private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	 
	 @BeforeEach
	 void setUp() {
		 //Initializing an Admin, Library, Book, and User before each test case
		 admin = new Admin("A001","Bob");
		 library = new Library();
		 book = new Book("To Kill a MockingBird", "Harper Lee", 11111);
		 user = new User("U002", "Charlie");
		 
		 //capturing printed messages
		 System.setOut(new PrintStream(outContent));
	 }
	 @Test
	 void testAddBook() {
		 //Admin adds a book to the library
		 admin.addBook(library, book);
		 assertTrue(library.getBook().contains(book),"Library should contain the added book");
	 }
	 @Test
	 void testRemoveBook() {
		 //First we add a book to the library
		 admin.addBook(library, book);
		 
		 //Then remove the book
		 admin.removeBook(library, book);
		 assertFalse(library.getBook().contains(book), "Library should not contain the removed book");
	 }
	 @Test
	 void testAddUser() {
		 //Admin adds a user to the library
		 admin.addUser(library, user);
		 assertTrue(library.getUsers().contains(user),"Library should contain the added user");
	 }
	 
	 @Test
	 void testRemoveUser(){
		 //First we remove the user
		 admin.addUser(library, user);
		 
		 //Now we remove the user
		 
		 admin.removeUser(library, user);
		 assertFalse(library.getUsers().contains(user),"Library should not contain the removed user");	 
	 }
	 
}
