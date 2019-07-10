package fxml.controller;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import laucher.AppLauncher;

public class WindowUtil {

	public List<Stage> openWindows(ImageView imgWebCamCapturedImage2, ImageView imgWebCamCapturedImage3,
			ImageView imgWebCamCapturedImage4, ImageView imgWebCamCapturedImage5, String configName) {

		FXMLLoader load = new FXMLLoader();
		FXMLLoader load2 = new FXMLLoader();
		FXMLLoader load3 = new FXMLLoader();
		FXMLLoader load4 = new FXMLLoader();

		load.setLocation(getClass().getResource("/fxml/gui/window.fxml"));
		load2.setLocation(getClass().getResource("/fxml/gui/window.fxml"));
		load3.setLocation(getClass().getResource("/fxml/gui/window.fxml"));
		load4.setLocation(getClass().getResource("/fxml/gui/window.fxml"));

		List<Stage> result = new ArrayList<Stage>();

		result.add(createWindow(imgWebCamCapturedImage2, 1, configName));
		result.add(createWindow(imgWebCamCapturedImage3, 2, configName));
		result.add(createWindow(imgWebCamCapturedImage4, 3, configName));
		result.add(createWindow(imgWebCamCapturedImage5, 4, configName));
		return result;

	}

	private Stage createWindow(ImageView imgWebCam, int i, String configName) {

		Stage stage = new Stage();
		stage.setTitle("Monitor " + i);
		javafx.scene.layout.StackPane secondaryLayout = new javafx.scene.layout.StackPane();
		BorderPane pane = new BorderPane();
		pane.setCenter(imgWebCam);
		stage.setScene(new Scene(secondaryLayout, 450, 450));

//		quita barra superior
//		stage.initStyle(javafx.stage.StageStyle.UNDECORATED);

		fxml.controller.handler.MousePressedHandler value = new fxml.controller.handler.MousePressedHandler(stage);
		secondaryLayout.setOnMousePressed(value);

		secondaryLayout.setOnMouseDragged(new fxml.controller.handler.MouseDraggedHandler(stage));
		secondaryLayout.getChildren().add(imgWebCam);
		imgWebCam.fitWidthProperty().bind(secondaryLayout.widthProperty());
		stage.initModality(javafx.stage.Modality.NONE);
		stage.show();
		javafx.geometry.Rectangle2D primScreenBounds = javafx.stage.Screen.getPrimary().getVisualBounds();
		stage.setX(Double.valueOf(AppLauncher.getProp(configName + ".monitor" + i + ".x"))); // primScreenBounds.getWidth() - stage4.getWidth()) / 2);
		stage.setY(Double.valueOf(AppLauncher.getProp(configName + ".monitor" + i + ".y"))); // (primScreenBounds.getHeight() - stage4.getHeight()) /
																// 2);

		return stage;
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

	public static ObservableList<String> getConfig() {
		ObservableList<String> options = FXCollections.observableArrayList();

		options.add("default");

		return options;
	}

}
