package main.java.utils;

import javafx.scene.control.Alert;

/*
 * This is a utility class for displaying alerts
 */
public class AlertClass {

    // method for displaying alerts
	public static void showAlert(Alert.AlertType alertType, String title, String message) {
		Alert alert = new Alert(alertType);
		alert.setTitle(title);
		alert.setContentText(message);
		alert.showAndWait();
	}

}
