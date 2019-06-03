package laucher;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
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
		int widthImg = Integer.valueOf( AppLauncher.getProp("width")).intValue();
		int heightImg = Integer.valueOf( AppLauncher.getProp("height")).intValue();
		Scene scene = new Scene(root, widthImg, heightImg);

		primaryStage.setMaximized(true);
		primaryStage.setTitle("WebCam Capture Sarxos API using JavaFx with FXML ");
		primaryStage.setScene(scene);
		primaryStage.centerOnScreen();
		primaryStage.show();
		
        
        // Hide this current window (if this is what you want)
//        ((Node)(event.getSource())).getScene().getWindow().hide();
    

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

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		return value;

	}

	public static void main(String[] args) {
		launch(args);
	}
}
