package fxml.controller;

import java.awt.image.BufferedImage;
import java.util.ArrayDeque;
import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.concurrent.Task;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;

public class ThreadBack extends BaseClipThread {

	public ThreadBack(ArrayDeque<BufferedImage> aqImagenes, Slider sliderFrame, ObjectProperty<Image> imageProperty3) {

		super(aqImagenes, sliderFrame, imageProperty3);
	}

	@Override
	public Void call() throws Exception {
//		for (int i = 0; i < aqImagenes.size() - 1; i++) {
		index = (int) sliderFrame.getMax() - 1;
		System.out.println("index " + index);
		while (index > -1 && TaskCamera.autoPlay) {
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					index--;
					if (index == -1) {
						sliderFrame.setValue(sliderFrame.getMax() - 1);
						index = (int) sliderFrame.getMax() - 1;
					} else {
						if (sliderFrame.getValue() - 1 != -1) {
							sliderFrame.setValue(sliderFrame.getValue() - 1);
						}
					}
					imageProperty3.setValue(SwingFXUtils.toFXImage(lBuffered[(int) sliderFrame.getValue()], null));

				}
				
			});

			Thread.sleep(30);

		}
		return null;
	}
}
