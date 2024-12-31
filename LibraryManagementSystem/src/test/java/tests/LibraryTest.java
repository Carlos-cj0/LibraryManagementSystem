package test.java.tests;
import main.java.models.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;


 class LibraryTest {
	 
	 private Library library;
	 private Book book1;
	 private Book book2;
	 private User user1;
	 @BeforeEach
	 void setUp() {
		 //Initialize a new Library instance before each test
		 library = new Library();
		 
		 //Creating sample books
		 book1 = new Book("1984", "George Orwell", 12345);
		 book2 = new Book("Brave new World" , "Aldous Huxley", 67890);
		 //Creating sample users
		 user1 = new User ("U001", "Alice");
		 new User ("U002","Bob");
	 }
	 
	 @Test
	 void testAddBook() {
		 //Adding a book to the library
		 library.addBook(book1);
		 
		 //Verifying that the book is in the library's book list
		 assertTrue(library.getBook().contains(book1), "Library should contain the added book");
		 
	 }
	 
	 @Test
	 void testRemoveBook() {
		 //we first add a book to the library
		 library.addBook(book1);
		 //then we remove the book
		 library.removeBook(book1);
		 //Verifying that the book is no longer in the library's book list
		 assertFalse(library.getBook().contains(book1), "Library should not contain the removed book");
		
	 }
	 
	 @Test
	 void testSearchBooksByTitle() {
		 //Adding books to the library 
		 library.addBook(book1);
		 library.addBook(book2);
		 
		 //search for a book by title
		 List<Book> results = library.searchBooks("1984");
		 
		 //Verify that the correct book is found
		 assertEquals(1, results.size(), "There should be one matching book");
		 assertEquals(book1,results.get(0),"The search result should be the book titled '1984");  
	 }
	@Test
	void testSearchBooksByAuthor() {
		//Add books to the library
		library.addBook(book1);
		library.addBook(book2);
		
		//Search for a book by Author 
		List<Book> results = library.searchBooks("Aldous Huxley");
		
		//Verify that the correct book is found 
		assertEquals(1,results.size(), "There should be one matching book");
		assertEquals(book2,results.get(0), "The search result should be the book authoredby 'Aldous Huxley'");	
	}
	@Test
	void testAddUser() {
		//Add a User to the library
		library.addUser(user1);
		
		//Verify that the user is in the library's user list
		assertTrue(library.getUsers().contains(user1),"Library should contain the added user");
	}
	
	@Test
	void testRemoveUser() {
		//Adding a user to the library first
		library.addUser(user1);
		
		//Removing the user
		library.removeUser(user1);
		//verifying that the user is no longer in the library's user list
		assertFalse(library.getUsers().contains(user1),"Library should not contain the removed user");
	}
	
	 

}
