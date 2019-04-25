package laucher;

import java.io.IOException;

import fxml.controller.WebCamPreviewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class WebCamAppLauncher extends Application {

	@Override
	public void start(Stage primaryStage) {

		Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getResource("/fxml/gui/WebCamPreview2.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int widthImg = (int) WebCamPreviewController.IMAGE_WIDTH;
		int heightImg = (int) WebCamPreviewController.IMAGE_HEIGTH;
		Scene scene = new Scene(root, widthImg, heightImg);

		primaryStage.setMaximized(true);
		primaryStage.setTitle("WebCam Capture Sarxos API using JavaFx with FXML ");
		primaryStage.setScene(scene);
		primaryStage.centerOnScreen();
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
