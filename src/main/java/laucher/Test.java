package laucher;

import java.io.IOException;
import java.util.Calendar;

import fxml.controller.WebCamPreviewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Test {


	public static void main(String[] args) throws InterruptedException {
		Calendar inicio = Calendar.getInstance();
		Calendar fin;
		for (int i=0; i < 100; i++) {
//			System.out.println(((double)1/35)*1000);
			fin = Calendar.getInstance();
			Thread.sleep(20);
			System.out.println(" " + i + " " + ((fin.getTimeInMillis() - inicio.getTimeInMillis())*1000));
			inicio = fin;
		}
	}
}
