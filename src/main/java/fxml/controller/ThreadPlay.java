package fxml.controller;

import java.awt.image.BufferedImage;
import java.util.ArrayDeque;
import java.util.Iterator;

import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.concurrent.Task;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;

public class ThreadPlay extends BaseClipThread {


	public ThreadPlay(ArrayDeque<BufferedImage> aqImagenes, Slider sliderFrame, ObjectProperty<Image> imageProperty3) {
		super(aqImagenes, sliderFrame, imageProperty3);
	}

	@Override
	public Void call() throws Exception {
//		for (int i = 0; i < aqImagenes.size() - 1; i++) {
		while (index < aqImagenes.size() - 1 && TaskCamera.autoPlay) {
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					index++;
					if (index == aqImagenes.size() - 1) {
						sliderFrame.setValue(0);
						index = 0;
					} else {
						if (sliderFrame.getValue() + 1 != sliderFrame.getMax() - 2) {
							sliderFrame.setValue(sliderFrame.getValue() + 1);
						}
						else {
							sliderFrame.setValue(0);
							index = 0;
						}
					}
					imageProperty3.setValue(SwingFXUtils.toFXImage(lBuffered[(int) sliderFrame.getValue()], null));
				}
			});

			Thread.sleep(WebCamPreviewController.speed);

		}
		return null;
	}
}
