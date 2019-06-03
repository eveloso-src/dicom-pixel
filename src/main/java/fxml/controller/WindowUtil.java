package fxml.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class WindowUtil {

	public void openWindows(ImageView imgWebCamCapturedImage2, ImageView imgWebCamCapturedImage3) {
		
		FXMLLoader load = new FXMLLoader();
		FXMLLoader load2 = new FXMLLoader();
		FXMLLoader load3 = new FXMLLoader();
		FXMLLoader load4 = new FXMLLoader();

		load.setLocation(getClass().getResource("/fxml/gui/window.fxml"));
		load2.setLocation(getClass().getResource("/fxml/gui/window.fxml"));
		load3.setLocation(getClass().getResource("/fxml/gui/window.fxml"));
		load4.setLocation(getClass().getResource("/fxml/gui/window.fxml"));

		Stage stage = new Stage();
		stage.setTitle("Monitor 1");
//        try {
//        	javafx.scene.Parent windowLoad = load.load();
		javafx.scene.layout.StackPane secondaryLayout = new javafx.scene.layout.StackPane();
		BorderPane pane = new BorderPane();
		pane.setCenter(imgWebCamCapturedImage2);
		stage.setScene(new Scene(secondaryLayout, 450, 450));

		secondaryLayout.getChildren().add(imgWebCamCapturedImage2);

		imgWebCamCapturedImage2.fitWidthProperty().bind(secondaryLayout.widthProperty());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		stage.initModality(javafx.stage.Modality.NONE);
//	    stage.initStyle(javafx.stage.StageStyle.UNDECORATED);
		stage.show();

		Stage stage2 = new Stage();
		stage2.setTitle("Monitor 2");
//        try {
//        	javafx.scene.Parent windowLoad = load.load();
		javafx.scene.layout.StackPane secondaryLayout2 = new javafx.scene.layout.StackPane();
		secondaryLayout2.getChildren().add(imgWebCamCapturedImage3);
		stage2.setScene(new Scene(secondaryLayout2, 450, 450));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		stage2.initModality(javafx.stage.Modality.NONE);
//	    stage.initStyle(javafx.stage.StageStyle.UNDECORATED);
		stage2.show();
		
	}

}
