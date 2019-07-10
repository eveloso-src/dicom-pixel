package fxml.controller.handler;

import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;

public class MouseDraggedHandler implements javafx.event.EventHandler<MouseEvent> {

	private Stage stage;

	public MouseDraggedHandler(Stage stage) {
		this.stage = stage;
	}

	@Override
	public void handle(MouseEvent event) {
		stage.setX(event.getScreenX() - 0); // xOffset);
		stage.setY(event.getScreenY() - 0); // yOffset);
		System.out.println("x " + stage.getX() + " // y: " + stage.getY());
	}

}
