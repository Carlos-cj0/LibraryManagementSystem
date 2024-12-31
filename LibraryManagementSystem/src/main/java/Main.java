package main.java;
import java.util.List;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import main.java.models.Admin;
import main.java.models.Book;
import main.java.models.Library;
import main.java.models.User;
import main.java.utils.AlertClass;
import main.java.utils.InputValidator;

public class Main  extends Application {
	// Library instance to store books
	Library library = new Library();
	/**
	 * User login method that returns a User object.
	 * @param userID The user's ID.
	 * @param name The user's name.
	 * @return A new User object.
	 */
	public User loginUser(String userID, String name) {
		return new User(userID, name);
	}

	/**
	 * Admin login method that returns an Admin object.
	 * @param adminID The admin's ID.
	 * @param name The admin's name.
	 * @return A new Admin object.
	 */
	public Admin loginAdmin(String adminID, String name) {
		return new Admin(adminID, name);
	}

	@Override
	public void start(Stage primaryStage) {
		// Create a FlowPane to hold the main menu options
		FlowPane flowPane = new FlowPane(Orientation.VERTICAL, 10, 10);
		flowPane.setAlignment(Pos.CENTER);
		flowPane.setStyle("-fx-background-image: url(\"https://picsum.photos/id/24/4855/1803\");" +
				"-fx-background-repeat: no-repeat; " +
				"-fx-background-size: cover;");

		// Title label
		Label label = new Label("Sign In");
		label.setStyle("-fx-font-size: 20px; -fx-text-fill: darkblue; -fx-font-weight: bold;");

		// Admin Button
		Button bt1 = new Button("Admin");
		styleButton(bt1, "darkblue");
		bt1.setOnAction(e -> showAdminStage());

		// User Button
		Button bt2 = new Button("User");
		styleButton(bt2, "darkgreen");
		bt2.setOnAction(e -> showUserStage());

		// Exit Button
		Button bt3 = new Button("Exit");
		styleButton(bt3, "red");
		bt3.setOnAction(e -> primaryStage.close());

		// Add all buttons to the FlowPane
		flowPane.getChildren().addAll(label, bt1, bt2, bt3);

		// Create and set the main scene
		Scene scene = new Scene(flowPane, 900, 450);
		primaryStage.setTitle("Library Management System");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	/**
	 * Displays the Admin login stage.
	 */
	private void showAdminStage() {
		Stage adminStage = new Stage();
		GridPane gridPane = createLoginPane();

		// Input fields for admin ID and name
		Label adminIDLabel = new Label("Enter Admin ID: ");
		TextField adminIDField = new TextField();
		Label adminNameLabel = new Label("Enter Admin Name: ");
		TextField adminNameField = new TextField();

		// Login button for admin
		Button loginButton = new Button("Log in");
		loginButton.setOnAction(e -> {
			String adminID = adminIDField.getText();
			String adminName = adminNameField.getText();
			Admin admin = this.loginAdmin(adminID, adminName);
			showAdminMenu(admin);
			adminStage.close();
		});

		// Add components to the GridPane
		gridPane.add(adminIDLabel, 0, 0);
		gridPane.add(adminIDField, 1, 0);
		gridPane.add(adminNameLabel, 0, 1);
		gridPane.add(adminNameField, 1, 1);
		gridPane.add(loginButton, 1, 2);

		// Set the scene and display the admin stage
		adminStage.setScene(new Scene(gridPane, 400, 250));
		adminStage.show();
	}

	/**
	 * Displays the User login stage.
	 */
	private void showUserStage() {
		Stage userStage = new Stage();
		GridPane gridPane = createLoginPane();

		// Input fields for user ID and name
		Label userIDLabel = new Label("Enter User ID: ");
		TextField userIDField = new TextField();
		Label userNameLabel = new Label("Enter User Name: ");
		TextField userNameField = new TextField();

		// Login button for user
		Button loginButton = new Button("Log in");
		loginButton.setOnAction(e -> {
			String userID = userIDField.getText();
			String userName = userNameField.getText();
			User user = this.loginUser(userID, userName);
			showUserMenu(user);
			userStage.close();
		});

		// Add components to the GridPane
		gridPane.add(userIDLabel, 0, 0);
		gridPane.add(userIDField, 1, 0);
		gridPane.add(userNameLabel, 0, 1);
		gridPane.add(userNameField, 1, 1);
		gridPane.add(loginButton, 1, 2);

		// Set the scene and display the user stage
		userStage.setScene(new Scene(gridPane, 400, 250));
		userStage.show();
	}

	/**
	 * Creates a standardized GridPane for login forms.
	 */
	private GridPane createLoginPane() {
		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setPadding(new Insets(20));
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		return gridPane;
	}
	/**
	 * admin menu actions.
	 */
	private void showAdminMenu(Admin admin) {
		//creating a new stage for the admin menu
		Stage adminMenuStage = new Stage();

		//creating a borderPane layout
		BorderPane saBorderPane = new BorderPane();
		//creating a label to display the currently logged in admin
		Label saLabel = new Label("Hi " + admin.getName() + ", what would you like to do today?");
		saLabel.setStyle(
				"-fx-font-size: 20px;" +           // Larger font size
						"-fx-text-fill: black;" +          // White text color
						"-fx-font-weight: bold;" +         // Bold font weight
						"-fx-padding: 20px;"               // Padding around the text
				);


		//adding admin menu buttons
		//add book button
		Button adminbt1 = new Button("Add Book ");
		secondarystyleButton(adminbt1, "khaki");
		adminbt1.setOnAction(e -> showAddBookForm(admin));

		//remove book
		Button adminbt2 = new Button("Remove Book ");
		secondarystyleButton(adminbt2, "khaki");
		adminbt2.setOnAction(e -> showRemoveBookForm(admin));


		//add user 
		Button adminbt3 = new Button("Add User ");
		secondarystyleButton(adminbt3, "khaki");
		adminbt3.setOnAction(e -> showAddUserForm(admin));

		//Remove user
		Button adminbt4 = new Button("Remove User ");
		secondarystyleButton(adminbt4, "khaki");
		adminbt4.setOnAction(e -> showRemoveUserForm(admin));

		//Search books
		Button adminbt5 = new Button("Search Books ");
		secondarystyleButton(adminbt5, "khaki");
		adminbt5.setOnAction(e -> showSearchBooksForm(admin));

		//Books

		Button adminbt6 = new Button("Display Books");
		secondarystyleButton(adminbt6, "khaki");
		adminbt6.setOnAction(e -> showBookList(library));

		//Display users
		Button adminbt7 = new Button("Display Users");
		secondarystyleButton(adminbt7, "khaki");
		adminbt7.setOnAction(e ->  showUsersList(admin));


		// Back
		Button adminbt8 = new Button("Back");
		secondarystyleButton(adminbt8, "khaki");
		adminbt8 .setOnAction(e -> adminMenuStage.close());

		//adding the label to the borderPane
		saBorderPane.setStyle("-fx-background-image: url(\"https://picsum.photos/id/24/4855/1803\");" +
				"-fx-background-repeat: no-repeat; " +
				"-fx-background-size: cover;");

		VBox buttonBox = new VBox(10, saLabel,adminbt1, adminbt2,adminbt3,adminbt4,adminbt5,adminbt6, adminbt7 , adminbt8);
		buttonBox.setAlignment(Pos.CENTER);
		buttonBox.setPadding(new Insets(20));


		saBorderPane.setTop(saLabel);
		saBorderPane.setCenter(buttonBox);

		//setting the borderPane as the root of the scene 
		adminMenuStage.setScene( new Scene(saBorderPane, 600 , 450));
		adminMenuStage.setTitle("Admin Control Pannel");
		//showing the stage
		adminMenuStage.show();
	}

	/**
	 * user menu actions.
	 */
	private void showUserMenu(User user) {
		//creating a new stage for the user menu
		Stage userMenuStage = new Stage();

		//creating a borderPane layout
		BorderPane uBorderPane = new BorderPane();
		//creating a label to display the currently logged in user
		Label uLabel = new Label("Hi " + user.getName() + ", what would you like to do today?");
		uLabel.setStyle(
				"-fx-font-size: 20px;" +           // Larger font size
						"-fx-text-fill: black;" +          // White text color
						"-fx-font-weight: bold;" +         // Bold font weight
						"-fx-padding: 20px;"               // Padding around the text
				);


		//adding user menu buttons
		//borrow book
		Button userbt1 = new Button("Borrow Books");
		secondarystyleButton(userbt1, "crimson");
		userbt1.setOnAction(e -> {
			TextInputDialog dialog = new TextInputDialog();
			dialog.setTitle("Borrow Book");
			dialog.setHeaderText("Borrow a Book");
			dialog.setContentText("Enter ISBN of the book to borrow:");

			dialog.showAndWait().ifPresent(isbnString -> {
				//validate the ISBN using INputValidator
				if(!InputValidator.isValidISBN(isbnString)) {
					AlertClass.showAlert(Alert.AlertType.ERROR,"Invalid Input", "Please Enter a valid numeric ISBN.");
					return;
				}
				//convert the valid ISBN string to an integer
				int isbn = Integer.parseInt(isbnString);

				//Find the book by ISBN
				Book bookToBorrow = findBookByISBN(isbn);
				if(bookToBorrow != null) {
					//Borrow the book
					user.issueBook(bookToBorrow);
					
				}else {
					//Book not found
					AlertClass.showAlert(Alert.AlertType.ERROR,"Book not Found", "No Book Found with the given ISBN.");
				}

			});
		});
		//return book
		Button userbt2 = new Button("Return Books");
		secondarystyleButton(userbt2, "crimson");
		userbt2.setOnAction(e -> {
			TextInputDialog dialog = new TextInputDialog();
			dialog.setTitle("Return Book");
			dialog.setHeaderText("Return a Book");
			dialog.setContentText("Enter ISBN of the book to return:");

			dialog.showAndWait().ifPresent(isbnString -> {
				//validate the ISBN using INputValidator
				if(!InputValidator.isValidISBN(isbnString)) {
					AlertClass.showAlert(Alert.AlertType.ERROR,"Invalid Input", "Please Enter a valid numeric ISBN.");
					return;
				}
				//convert the valid ISBN string to an integer
				int isbn = Integer.parseInt(isbnString);

				//if isbn is valid
				Book bookToReturn = findBookByISBN(isbn);
				if(bookToReturn != null) {
					user.returnBook(bookToReturn);
				} else {
					AlertClass.showAlert(Alert.AlertType.ERROR,"Invalid Input", "The entered value is not recognized by this system. Contact admin for support");
				}

			});

		});
		//search books 
		Button userbt3 = new Button("Search Books");
		secondarystyleButton(userbt3, "crimson");
		userbt3.setOnAction(e -> showSearchBooksForm(user));

		//displaying books 
		Button userbt4 = new Button("Display Books");
		secondarystyleButton(userbt4, "crimson");
		userbt4.setOnAction(e -> showBookList(library));

		//view issued books
		Button userbt5 = new Button("View Issued Books");
		secondarystyleButton(userbt5, "crimson");
		userbt5.setOnAction(e -> {
			//Retrieving the list of issued books
			List<Book> issuedBooks = user.viewIssuedBooks();
			if(issuedBooks.isEmpty()) {
				//Show an alert
				AlertClass.showAlert(Alert.AlertType.INFORMATION,"No Books","No books currently borrowed");
			}else {
				//A new stage to display borrowed books 
				Stage issuedBooksStage = new Stage();
				issuedBooksStage.setTitle("Issued Books");
				//A ListView for the borrowed books
				ListView<Book> listView = new ListView<>();
				ObservableList<Book> booksObvservaleList = FXCollections.observableArrayList(issuedBooks);
				listView.setItems(booksObvservaleList);

				//Defining how each book is displayed in the listView
				listView.setCellFactory(param -> new ListCell<>(){
					@Override
					protected void updateItem(Book book, boolean empty) {
						super.updateItem(book,empty);
						if (empty || book == null) {
							setText(null);
						}else {
							//customize the display text for each book
							setText(book.getTitle() + " by " + book.getAuthor() + " ISBN: " + "(" + book.getISBN() + ")");
						}
					}

				});
				//Creating a layout 
				VBox layout = new VBox(listView);
				layout.setPadding(new Insets(10));
				//setting the scene and showing the stage
				Scene scene = new Scene(layout, 400, 300);
				issuedBooksStage.setScene(scene);
				issuedBooksStage.show();	

			}

		});
		// Back
		Button userbt6 = new Button("Back");
		secondarystyleButton(userbt6, "crimson");
		userbt6.setOnAction(e -> userMenuStage.close());

		//adding the label to the borderPane
		uBorderPane.setStyle("-fx-background-image: url(\"https://picsum.photos/id/24/4855/1803\");" +
				"-fx-background-repeat: no-repeat; " +
				"-fx-background-size: cover;");

		VBox ubuttonBox = new VBox(10, uLabel, userbt1, userbt2,userbt3,userbt4,userbt5,userbt6);
		ubuttonBox.setAlignment(Pos.CENTER);
		ubuttonBox.setPadding(new Insets(20));


		uBorderPane.setTop(uLabel);
		uBorderPane.setCenter(ubuttonBox);

		//setting the borderPane as the root of the scene 
		userMenuStage.setScene( new Scene(uBorderPane, 600 , 450));
		userMenuStage.setTitle("User Pannel");
		//showing the stage
		userMenuStage.show();

	}

	/**
	 * primary Utility method to style buttons
	 */
	private void styleButton(Button button, String color) {
		button.setStyle("-fx-font-size: 16px; -fx-text-fill: white; -fx-background-color: " + color + "; " +
				"-fx-padding: 5px 10px; -fx-border-radius: 5px; -fx-background-radius: 5px;");
	}
	//secondary Utility method to style buttons
	private void secondarystyleButton(Button button, String color) {
		button.setStyle("-fx-font-size: 16px; -fx-text-fill: black; -fx-background-color: " + color + "; " +
				"-fx-padding: 5px 10px; -fx-border-radius: 5px; -fx-background-radius: 5px;");
	}

	/**
	 * Allows an admin to add a new book to the library.
	 * @param admin The admin adding the book.
	 * @param title The title of the book.
	 * @param author The author of the book.
	 * @param isbn The ISBN of the book.
	 */
	private void showAddBookForm(Admin admin) {
		// Create a new stage for the Add Book form
		Stage addBookStage = new Stage();
		addBookStage.setTitle("Add New Book");
		// Create labels and text fields for book details
		Label titleLabel = new Label("Enter Book Title:");
		TextField titleField = new TextField();
		Label authorLabel = new Label("Enter Author:");
		TextField authorField = new TextField();
		Label isbnLabel = new Label("Enter ISBN (number):");
		TextField isbnField = new TextField();
		// Create a button to submit the form
		Button submitButton = new Button("Add Book");
		// Set an action for the submit button
		submitButton.setOnAction(e -> {
			String title = titleField.getText();
			String author = authorField.getText();
			String isbnText = isbnField.getText();
			//validating inputs
			if(!InputValidator.isValidTitle(title)) {
				AlertClass.showAlert(Alert.AlertType.ERROR, "Input Error", "Title cannot be empty.");
				return;
			}
			if(!InputValidator.isValidAuthor(author)) {
				AlertClass.showAlert(Alert.AlertType.ERROR, "Input Error", "Author cannot be empty. ");
			}
			if(!InputValidator.isValidISBN(isbnText)) {
				AlertClass.showAlert(Alert.AlertType.ERROR, "Input Error" , "Invalid ISBN. Please enter a valid number");
				return;
			}
			//if inputs are valid, add the book
			int isbn = Integer.parseInt(isbnText);
			Book newBook = new Book(title, author, isbn);
			admin.addBook(library, newBook);
			//display operation success message
			AlertClass.showAlert(Alert.AlertType.INFORMATION, "Success" , "Book added succesfully!!" );
			//clearing the fields after a successful operation
			titleField.clear();
			authorField.clear();
			isbnField.clear();
		});

		// Arrange the labels, text fields, and button in a grid pane
		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(10));
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		gridPane.setAlignment(Pos.CENTER);

		gridPane.add(titleLabel, 0, 0);
		gridPane.add(titleField, 1, 0);
		gridPane.add(authorLabel, 0, 1);
		gridPane.add(authorField, 1, 1);
		gridPane.add(isbnLabel, 0, 2);
		gridPane.add(isbnField, 1, 2);
		gridPane.add(submitButton, 1, 3);


		// Create a scene with the grid pane as the root node
		Scene scene = new Scene(gridPane, 400, 300);
		addBookStage.setScene(scene);
		addBookStage.show();
	}

	//method for display books function
	private void showBookList(Library library) {
		//new stage for displaying books
		Stage bookListStage = new Stage();
		bookListStage.setTitle("Library Books");

		// Create a ListView to display the books
		ListView<String> bookListView = new ListView<>();
		ObservableList<String> bookItems = FXCollections.observableArrayList();

		// Retrieve books from the library and add to the list
		List<Book> books = library.getBook();
		if (!books.isEmpty()) {
			for (Book book : books) {
				bookItems.add(book.toString()); //using Book class toString() method
			}
		} else {
			bookItems.add("oops.. looks like the library curently has no books.");
		}
		bookListView.setItems(bookItems);

		// Set up the scene and show the stage
		Scene scene = new Scene(new VBox(bookListView), 400, 300);
		bookListStage.setScene(scene);
		bookListStage.show();
	}

	private void showRemoveBookForm(Admin admin) {
		// Create a new stage for the remove book form
		Stage removeBookStage = new Stage();
		removeBookStage.setTitle("Remove Book");

		// Create layout and controls
		VBox layout = new VBox(10);
		layout.setPadding(new Insets(20));

		Label isbnLabel = new Label("Enter ISBN of the book to remove:");
		TextField isbnField = new TextField();
		Button removeButton = new Button("Remove Book");
		Label messageLabel = new Label();

		// Set action for the remove button
		removeButton.setOnAction(e -> {
			String isbnText = isbnField.getText();
			//Validate the ISBN 
			if (!InputValidator.isValidISBN(isbnText)) {
				AlertClass.showAlert(Alert.AlertType.ERROR, "Invalid Input", "Please enter a valid numeric ISBN");
				return;
			}
			//Converting ISBN to integer
			int isbn = Integer.parseInt(isbnText);

			//finding book by ISBN
			Book bookToRemove = findBookByISBN(isbn);
			if(bookToRemove != null) {
				//Remove Book
				admin.removeBook(library, bookToRemove);
				AlertClass.	showAlert(Alert.AlertType.INFORMATION,"Successful Operation", "Book removed!!");
				//clear field
				isbnField.clear();
			}else {
				//Book not found
				AlertClass.showAlert(Alert.AlertType.ERROR,"Book Not Found", "No Book found with the given ISBN.");
			}

		});

		// Add controls to layout
		layout.getChildren().addAll(isbnLabel, isbnField, removeButton, messageLabel);

		// Set scene and show stage
		Scene scene = new Scene(layout, 300, 200);
		removeBookStage.setScene(scene);
		removeBookStage.show();
	}

	//Add users
	private void showAddUserForm(Admin admin) {
		Stage addUserStage = new Stage();
		addUserStage.setTitle("Add User");

		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(10));
		gridPane.setVgap(10);
		gridPane.setHgap(10);

		Label userIdLabel = new Label("User ID:");
		TextField userIdField = new TextField();
		Label userNameLabel = new Label("User Name:");
		TextField userNameField = new TextField();
		Button addButton = new Button("Add User");

		gridPane.add(userIdLabel, 0, 0);
		gridPane.add(userIdField, 1, 0);
		gridPane.add(userNameLabel, 0, 1);
		gridPane.add(userNameField, 1, 1);
		gridPane.add(addButton, 1, 2);

		addButton.setOnAction(e -> {
			String userID = userIdField.getText();
			String name = userNameField.getText();
			if (!userID.isEmpty() && !name.isEmpty()) {
				User newUser = new User(userID, name);
				admin.addUser(library, newUser);
				addUserStage.close();
				AlertClass.showAlert(Alert.AlertType.INFORMATION, "Success", "User added successfully.");
			} else {
				AlertClass.showAlert(Alert.AlertType.ERROR, "Error", "Please fill in all fields.");
			}
		});



		Scene scene = new Scene(gridPane, 300, 200);
		addUserStage.setScene(scene);
		addUserStage.show();
	}
	//admin menu remove users method

	private void showRemoveUserForm(Admin admin) {
		Stage removeUserStage = new Stage();
		removeUserStage.setTitle("Remove User");

		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(10));
		gridPane.setVgap(10);
		gridPane.setHgap(10);

		Label userIdLabel = new Label("User ID:");
		TextField userIdField = new TextField();
		Button removeButton = new Button("Remove User");

		gridPane.add(userIdLabel, 0, 0);
		gridPane.add(userIdField, 1, 0);
		gridPane.add(removeButton, 1, 1);

		removeButton.setOnAction(e -> {
			String userID = userIdField.getText();
			if (!userID.isEmpty()) {
				User userToRemove = null;
				for (User user : library.getUsers()) {
					if (user.getUserID().equals(userID)) {
						userToRemove = user;
						break;
					}
				}
				if (userToRemove != null) {
					admin.removeUser(library, userToRemove);
					removeUserStage.close();
					AlertClass.showAlert(Alert.AlertType.INFORMATION, "Success", "User removed successfully.");
				} else {
					AlertClass.showAlert(Alert.AlertType.ERROR, "Error", "User not found.");
				}
			} else {
				AlertClass.showAlert(Alert.AlertType.ERROR, "Error", "Please enter a User ID.");
			}
		});

		Scene scene = new Scene(gridPane, 300, 150);
		removeUserStage.setScene(scene);
		removeUserStage.show();
	}

	//  Method to display all users to the administrator
	private void showUsersList(Admin admin) {
		// Creating a new stage for displaying the users list
		Stage usersListStage = new Stage();
		usersListStage.setTitle("Library Users");

		// Create a ListView to display user names and IDs
		ListView<String> userListView = new ListView<>();
		List<User> users = library.getUsers();
		ObservableList<String> userNames = FXCollections.observableArrayList();

		// Check if the library has users
		if (!users.isEmpty()) {
			for (User user : users) {
				userNames.add("User ID: " + user.getUserID() + " Name: " + user.getName());
			}
		} else {
			userNames.add( admin.getName() + ", there's nobody in here, add some users first");
		}

		// Add users to the ListView
		userListView.setItems(userNames);

		// Create a VBox to hold the ListView
		VBox vbox = new VBox(10, new Label("Library Users"), userListView);
		vbox.setPadding(new Insets(20));
		vbox.setAlignment(Pos.CENTER);

		// Setting the scene for the stage
		Scene scene = new Scene(vbox, 400, 300);
		usersListStage.setScene(scene);
		usersListStage.show();
	}
	// Method to search for books
	private void showSearchBooksForm(User user) {
		// Creating a new stage for the search book form
		Stage searchBooksStage = new Stage();
		searchBooksStage.setTitle("Search Books");

		// Create a GridPane layout for the search form
		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(10));
		gridPane.setVgap(10);
		gridPane.setHgap(10);

		// Create label and text field for the search term
		Label searchLabel = new Label("Search By Title or Author:");
		TextField searchField = new TextField();
		Button searchButton = new Button("Search");

		// Add components to the GridPane
		gridPane.add(searchLabel, 0, 0);
		gridPane.add(searchField, 1, 0);
		gridPane.add(searchButton, 1, 1);

		// Search button action
		searchButton.setOnAction(e -> {
			String searchTerm = searchField.getText();
			if (!searchTerm.isEmpty()) {
				// Perform search using admin's searchBooks method
				List<Book> results = user.searchBooks(library, searchTerm);

				// If books found, show them; otherwise, show no results message
				if (!results.isEmpty()) {
					// Display results in a ListView
					ListView<String> resultsListView = new ListView<>();
					ObservableList<String> bookDetails = FXCollections.observableArrayList();
					for (Book book : results) {
						bookDetails.add(book.toString()); //invoking book's toString to display its details
					}

					resultsListView.setItems(bookDetails);

					// Create VBox to display the search results
					VBox vbox = new VBox(10, new Label("Search Results"), resultsListView);
					vbox.setPadding(new Insets(20));
					vbox.setAlignment(Pos.CENTER);

					// Create scene for displaying the results
					Scene resultsScene = new Scene(vbox, 400, 300);
					searchBooksStage.setScene(resultsScene);
					searchBooksStage.show();
				} else {
					// Show an alert if no books match the search term
					AlertClass.showAlert(Alert.AlertType.INFORMATION, "No Results", "No books found matching the search term.");
				}
			} else {
				AlertClass.showAlert(Alert.AlertType.ERROR, "Error", "Please enter a search term.");
			}
		});

		// Set the scene for the search form window
		Scene searchScene = new Scene(gridPane, 500, 150);
		searchBooksStage.setScene(searchScene);
		searchBooksStage.show();
	}
	/**
	 * Finds a book in the library by its ISBN.
	 * @param isbn The ISBN of the book.
	 * @return The Book object if found, otherwise null.
	 */
	public Book findBookByISBN(int isbn) {
		for (Book book : this.library.getBook()) {
			if (book.getISBN() == isbn) {
				return book;
			}
		}
		return null;
	}


	public static void main(String[] args) {
		launch(args);
	}
}