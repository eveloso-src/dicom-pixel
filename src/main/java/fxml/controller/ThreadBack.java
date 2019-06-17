package fxml.controller;

import java.awt.image.BufferedImage;
import java.util.ArrayDeque;
import javafx.application.Platform;

import javafx.concurrent.Task;
import javafx.scene.control.Slider;

public class ThreadBack extends Task<Void> {

	int index = 0;
	ArrayDeque<BufferedImage> aqImagenes;
	Slider sliderFrame;

	public ThreadBack(ArrayDeque<BufferedImage> aqImagenes, Slider sliderFrame) {
		this.aqImagenes = aqImagenes;
		this.sliderFrame = sliderFrame;

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
				}
			});

			Thread.sleep(30);

		}
		return null;
	}
}
