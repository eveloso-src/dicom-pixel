package fxml.controller;

import java.util.List;

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
		
		/*
		Stage stage3 = new Stage();
		stage3.setTitle("Monitor 3");
//        try {
//        	javafx.scene.Parent windowLoad = load.load();
		javafx.scene.layout.StackPane secondaryLayout3 = new javafx.scene.layout.StackPane();
		secondaryLayout3.getChildren().add(imgWebCamCapturedImage3);
		stage3.setScene(new Scene(secondaryLayout3, 450, 450));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		stage3.initModality(javafx.stage.Modality.NONE);
//	    stage.initStyle(javafx.stage.StageStyle.UNDECORATED);
		stage3.show();
		
		Stage stage4 = new Stage();
		stage4.setTitle("Monitor 4");
//        try {
//        	javafx.scene.Parent windowLoad = load.load();
		javafx.scene.layout.StackPane secondaryLayout4 = new javafx.scene.layout.StackPane();
		secondaryLayout4.getChildren().add(imgWebCamCapturedImage3);
		stage4.setScene(new Scene(secondaryLayout4, 450, 450));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		stage4.initModality(javafx.stage.Modality.NONE);
//	    stage.initStyle(javafx.stage.StageStyle.UNDECORATED);
		stage4.show();
*/
	}

	public static void configureSmallPreview(List<ImageView> listPreview, double height, double width) {
		// TODO Auto-generated method stub

		for (ImageView imgPreview1 : listPreview) {

			imgPreview1.setFitHeight(height / 5);
			imgPreview1.setFitWidth(width / 5);
			imgPreview1.prefHeight(height / 5);
			imgPreview1.prefWidth(width / 5);
			imgPreview1.setPreserveRatio(true);
		}

		/*
		 * imgPreview2.setFitHeight(height / 5); imgPreview2.setFitWidth(width / 5);
		 * imgPreview2.prefHeight(height / 5); imgPreview2.prefWidth(width / 5);
		 * imgPreview2.setPreserveRatio(true);
		 * 
		 * imgPreview3.setFitHeight(height / 5); imgPreview3.setFitWidth(width / 5);
		 * imgPreview3.prefHeight(height / 5); imgPreview3.prefWidth(width / 5);
		 * imgPreview3.setPreserveRatio(true);
		 * 
		 * imgPreview4.setFitHeight(height / 5); imgPreview4.setFitWidth(width / 5);
		 * imgPreview4.prefHeight(height / 5); imgPreview4.prefWidth(width / 5);
		 * imgPreview4.setPreserveRatio(true);
		 * 
		 */
	}

	public static void configurePreview(List<ImageView> listViews, double height, double width) {

		for (ImageView imgWebCamCapturedImage2 : listViews) {

			imgWebCamCapturedImage2.setFitHeight(height / 1);
			imgWebCamCapturedImage2.setFitWidth(width / 1);
			imgWebCamCapturedImage2.prefHeight(height / 1);
			imgWebCamCapturedImage2.prefWidth(width / 1);
			imgWebCamCapturedImage2.setPreserveRatio(true);
		}

	}

}
