package fxml.controller.handler;

import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MousePressedHandler implements javafx.event.EventHandler<MouseEvent>{
	
	private Stage stage;
	
	public MousePressedHandler(Stage stage) {
		this.stage = stage;
	}

	@Override
	public void handle(MouseEvent event) {
//		xOffset = event.getSceneX();
//		yOffset = event.getSceneY();
		stage.setX(event.getSceneX());
		stage.setY(event.getSceneY());
	}
	

}
