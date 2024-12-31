package test.java.tests;

import main.java.models.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;


 class UserTest {
	 
	 private User user;
	 private Book book1;
	 private Book book2;
	 private List<Book> issuedBooks;
	 @BeforeEach
	 void setUp() {
		 //initializing a User and a Book before each test
		 
		 user = new User("U001" ,"Alice");
		 book1 = new Book("1984", "George Orwell", 12345);
		 book2 = new Book ("Gifted Hands", "Ben Carson", 52523);
	 }
	 
	 @Test
	 void testGetUserID() {
		 assertEquals("U001", user.getUserID(), "User ID should be 'U001'");
	 }
	 
	 @Test
	 void testGetName() {
		 assertEquals("Alice", user.getName(), "User name should be 'Alice");
	 }
	 
	 @Test
	 void testIssueBookWhenAvailable() {
		 user.issueBook(book1);
		 assertFalse(book1.getAvailability(), "Book borrowed and unavailable");
	 }
	 
	 @Test
	 void testIssueBookWhenNotAvailable() {
		 //First borrow the book to make it unavailable
		 user.issueBook(book1);
		 
		 //Try issuing the book again
		 user.issueBook(book1);
		 assertFalse(book1.getAvailability(),"Book should remain unavailable after being borrowed");
	 }
	 
	 @Test
	 void testReturnBookWhenBorrowed() {
		 user.issueBook(book1); //borrowing the book
		 user.returnBook(book1);
		 assertTrue(book1.getAvailability(), "Book should be available after being returned");
		 
	 }
	 
	 @Test
	 void testReturnBookWhenNotBorrowed() {
		 user.returnBook(book1);
		 assertTrue(book1.getAvailability(), "Book should remain available if not borrowed");
	 }
	 
	 @Test
	 void testGetIssuedBooks_WhenBooksAreIssued() {
		 //issue books to the user
		 user.issueBook(book1);
		 user.issueBook(book2);
		 
		 //Retrieve issued books
		 issuedBooks = user.viewIssuedBooks();
		 
		 //check if both books are issued correctly
		 assertEquals(2,issuedBooks.size(), "User should have 2 books issued. ");
		 assertTrue(issuedBooks.contains(book1), "Issued books should contan '1984'");
		 assertTrue(issuedBooks.contains(book2), "Issued books should contan 'Gifted Hands'");
		 
	 }
	 
	 @Test
	 void testGetIssuedBooks_WhenNoBooksAreIssued() {
		 //Retrieve issued books without issuing any
		 
		 issuedBooks = user.viewIssuedBooks();
		 
		 //check if the list is empty
		 assertTrue(issuedBooks.isEmpty(), "User should have no books issued. ");
	 }
	 
	 @Test
	 void testGetIssuedBooks_AfterReturningBook() {
		 //Issue and return a book
		 user.issueBook(book1);
		 user.returnBook(book1);
		 
		 //Retrieve the issued books
		 issuedBooks = user.viewIssuedBooks();
		 
		 //the list should be empty after returning the book
		 assertTrue(issuedBooks.isEmpty(), "User should have no books issued after returning the book");
	 }

}
