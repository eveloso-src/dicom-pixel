package laucher;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import fxml.controller.WebCamPreviewController;
import javafx.application.Application;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class AppLauncher extends Application {

	@SuppressWarnings("restriction")
	@Override
	public void start(Stage primaryStage) throws IOException {

		@SuppressWarnings("restriction")
		Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getResource("/fxml/gui/WebCamPreview2.fxml"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int widthImg = Integer.valueOf(AppLauncher.getProp("width")).intValue();
		int heightImg = Integer.valueOf(AppLauncher.getProp("height")).intValue();
		Scene scene = new Scene(root, widthImg, heightImg);

		final BooleanProperty spacePressed = new SimpleBooleanProperty(false);
		final BooleanProperty rightPressed = new SimpleBooleanProperty(false);
		final BooleanBinding spaceAndRightPressed = spacePressed.and(rightPressed);

		// How to respond to both keys pressed together:
		spaceAndRightPressed.addListener(new ChangeListener<Boolean>() {
//		    @Override
//		    public void changed(ObservableValue<Boolean> obs, Boolean werePressed, Boolean arePressed) {
//		    }

			@Override
			public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2) {
				// TODO Auto-generated method stub
				System.out.println("Space and right pressed together");

			}
		});

		EventHandler<KeyEvent> eventHandler = new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent ke) {
				// TODO Auto-generated method stub
				if (ke.getCode() == KeyCode.DIGIT1) {
					WebCamPreviewController.selectImgPreview1();
				}
			}
		};
		// Wire up properties to key events:
		scene.setOnKeyPressed(eventHandler);

		/*
		 * 
		 * (new EventHandler<KeyEvent>() {
		 * 
		 * @Override public void handle(KeyEvent ke) { if (ke.getCode() ==
		 * KeyCode.SPACE) { spacePressed.set(true); } else if (ke.getCode() ==
		 * KeyCode.RIGHT) { rightPressed.set(true); } } });
		 * 
		 */

		primaryStage.setMaximized(true);
		primaryStage.setTitle("WebCam Capture Sarxos API using JavaFx with FXML ");
		primaryStage.setScene(scene);
		primaryStage.centerOnScreen();
		primaryStage.show();

		// Hide this current window (if this is what you want)
//        ((Node)(event.getSource())).getScene().getWindow().hide();

	}

	public static void setProp(String propName, String value) {
		String file = "src/main/resources/params.properties";
		PropertiesConfiguration prop;
		try {
			prop = new PropertiesConfiguration(file);
			prop.setProperty(propName, value);
			prop.save();
		} catch (ConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static String getProp(String propName) {
		Properties prop = new Properties();
		String value = null;
		try {
			InputStream input = new FileInputStream("src/main/resources/params.properties");

			// load a properties file
			prop.load(input);

			// get the property value and print it out
			value = prop.getProperty(propName);
			prop.clear();

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return value;

	}

	public static void main(String[] args) {
		launch(args);
	}
}
