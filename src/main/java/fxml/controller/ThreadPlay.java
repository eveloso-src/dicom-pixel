package fxml.controller;

import java.awt.image.BufferedImage;
import java.util.ArrayDeque;
import javafx.application.Platform;

import javafx.concurrent.Task;
import javafx.scene.control.Slider;

public class ThreadPlay extends Task<Void> {

	int index = 0;
	ArrayDeque<BufferedImage> aqImagenes;
	Slider sliderFrame;

	public ThreadPlay(ArrayDeque<BufferedImage> aqImagenes, Slider sliderFrame) {
		this.aqImagenes = aqImagenes;
		this.sliderFrame = sliderFrame;

	}

	@Override
	public Void call() throws Exception {
//		for (int i = 0; i < aqImagenes.size() - 1; i++) {
		while (index < aqImagenes.size() - 1) {
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					index++;
					if (index == aqImagenes.size() - 1) {
						sliderFrame.setValue(0);
						index = 0;
					} else {
						if (sliderFrame.getValue() + 1 != sliderFrame.getMax() - 1) {
							sliderFrame.setValue(sliderFrame.getValue() + 1);
						}
					}
				}
			});

			Thread.sleep(30);

		}
		return null;
	}
}
