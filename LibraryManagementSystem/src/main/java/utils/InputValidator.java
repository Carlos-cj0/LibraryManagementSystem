package main.java.utils;

/**
 * This is a utility class for input validation
 */

public class InputValidator {

	/**
	 * this method Validates the book title
	 * A valid title should not be null or empty after trimming whitespace
	 * @param title the Book title to validate
	 * @return return true if the title is valid, false otherwise
	 */

	public static boolean isValidTitle(String title) {
		//checking whether the title is not null and contains non-whitespace characters
		return title != null && !title.trim().isEmpty();
	}
	
	/**
	 * this method validates authors name. A valid author name should:
	 * not be null
	 * not empty after trimming whitespace characters
	 * 
	 * @param author name to validate
	 * @return return true if the author name is valid, otherwise false 
	 */
	
	public static boolean isValidAuthor(String author) {
		//check if the author is not null and contains non-whitespace characters
		return author != null && !author.trim().isEmpty();
		
	}
	
	/**
	 * this method validates ISBN number. A valid ISBN  should:
	 * be a non-null string that can be parsed as an Integer
	 * 
	 * 
	 * @param isbnText the ISBN number to validate as a string
	 * @return return true if the ISBN is valid, false otherwise
	 */
	public static boolean isValidISBN(String isbnText) {
		//check if the ISBN text is null or empty
		if (isbnText == null || isbnText.trim().isEmpty()) {
			return false;
		}
		// parse the ISBN as an integer
		try {
			Integer.parseInt(isbnText);
			return true; //Successful parsing, ISBN is valid
		}catch (NumberFormatException e) {
			return false;
		}
	}

	
	
}
