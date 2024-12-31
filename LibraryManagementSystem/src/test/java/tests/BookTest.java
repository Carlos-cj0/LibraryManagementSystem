package test.java.tests;

import main.java.models.Book;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

 class BookTest {
	@Test
	void testGetTitle() {
		Book book = new Book("The Great Gatsby", "F. Scott Fitzgerald", 12345);
		assertEquals("The Great Gatsby", book.getTitle(), "Title should be 'The Great Gatsby'");
	}
	
	@Test
	void testGetAuthor() {
		Book book = new Book("The Great Gatsby", "F. Scott Fitzgerald", 12345);
		assertEquals("F. Scott Fitzgerald", book.getAuthor(), "Author should be 'F. Scott Fitzgerald'");
	}
	@Test
	void testGetISBN() {
		Book book = new Book("The Great Gatsby", "F. Scott Fitzgerald", 12345);
		assertEquals(12345, book.getISBN(), "ISBN should be 12345");
	}
	
	@Test
	void testGetAvailability() {
		Book book = new Book("The Great Gatsby", "F. Scott Fitzgerald", 12345);
		assertTrue(book.getAvailability(), "Newly created book should be available");
	}
	
	@Test
	void testBorrowWhenAvailable() {
		Book book = new Book("The Great Gatsby", "F. Scott Fitzgerald", 12345);
		assertTrue(book.borrowBook(), "Borrowing an available book should succeed");
		assertFalse(book.getAvailability(), "Book should no longer be avaialable after being borrowed");
	}
	
	
	@Test
	void testBorrowWhenNotAvailable() {
		Book book = new Book("The Great Gatsby", "F. Scott Fitzgerald", 12345);
		book.borrowBook(); //Make the book borrowed
		assertFalse(book.borrowBook(), "Borrowing an unavailable book should fail");
	}
	
	@Test
	void testReturnBookWhenBorrowed() {
		Book book = new Book("The Great Gatsby", "F. Scott Fitzgerald", 12345);
		book.borrowBook(); //Make the book borrowed
		assertTrue(book.returnBook(), "Returning a borrowed book should succeed");
		assertTrue(book.getAvailability(),"Book should be available after being returned");
	}
	
	@Test
	void testReturnBookWhenNotBorrowed() {
		Book book = new Book("The Great Gatsby", "F. Scott Fitzgerald", 12345);
		assertFalse(book.returnBook(), "Return a book that was not borrowed should fail");
	}
}
