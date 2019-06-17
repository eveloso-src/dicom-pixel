package fxml.controller;

import java.awt.image.BufferedImage;
import java.util.ArrayDeque;
import java.util.Iterator;

import javafx.beans.property.ObjectProperty;
import javafx.concurrent.Task;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;

public abstract class BaseClipThread extends Task<Void> {

	int index = 0;
	ArrayDeque<BufferedImage> aqImagenes;
	Slider sliderFrame;
	ObjectProperty<Image> imageProperty3;
	protected BufferedImage[] lBuffered;

	public BaseClipThread(ArrayDeque<BufferedImage> aqImagenes, Slider sliderFrame, ObjectProperty<Image> imageProperty3) {

		this.aqImagenes = aqImagenes;
		this.sliderFrame = sliderFrame;
		this.imageProperty3 = imageProperty3;
		lBuffered = new BufferedImage[aqImagenes.size()];

		Iterator<BufferedImage> it = aqImagenes.iterator();
		// List<BufferedImage>list = new ArrayList<BufferedImage>();
		int i = 0;
		while (it.hasNext()) {
			lBuffered[i] = (it.next());
			i++;
		}

	}

}
