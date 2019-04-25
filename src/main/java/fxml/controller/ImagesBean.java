package fxml.controller;

import java.awt.image.BufferedImage;
import java.util.ArrayDeque;

public class ImagesBean {

	BufferedImage[] bImages;
	ArrayDeque<BufferedImage> imagenes;

	public ImagesBean(BufferedImage[] imagesArray, ArrayDeque<BufferedImage> imagenes2) {
		bImages = imagesArray;
		imagenes = imagenes2;
	}

	public BufferedImage[] getbImages() {
		return bImages;
	}

	public void setbImages(BufferedImage[] bImages) {
		this.bImages = bImages;
	}

	public ArrayDeque<BufferedImage> getImagenes() {
		return imagenes;
	}

	public void setImagenes(ArrayDeque<BufferedImage> imagenes) {
		this.imagenes = imagenes;
	}

}
