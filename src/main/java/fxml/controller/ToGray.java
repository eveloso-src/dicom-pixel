package fxml.controller;

import java.awt.AWTException;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.Date;

import javax.imageio.ImageIO;

public class ToGray {

	public static BufferedImage[] convertBufferedImage(BufferedImage img, ArrayDeque<BufferedImage> imagenes)
			throws AWTException {
		int width = img.getWidth();
		int height = img.getHeight();

		int[][] pixel = new int[width][height];
		byte[][] pixelBW = new byte[width][height];

		Raster raster = img.getData();
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				pixel[i][j] = raster.getSample(i, j, 0);
				// pixelBW[i][j] = new Double(raster.getSample(i, j, 0) * 0.21 +
				// raster.getSample(i, j, 1) * 0.71
				// + raster.getSample(i, j, 2) * 0.07).byteValue();
			}
		}

		BufferedImage theImage = new BufferedImage(1000, 1000, BufferedImage.TYPE_BYTE_GRAY);
		BufferedImage theImage2 = new BufferedImage(1000, 1000, BufferedImage.TYPE_BYTE_GRAY);

		BufferedImage [] imagesArray = new BufferedImage[2];
		
		// conversion automatica a grises
		Graphics2D graphic = theImage.createGraphics();
		graphic.drawImage(img, 0, 0, null, null);
		graphic.dispose();

		graphic = theImage2.createGraphics();
		graphic.drawImage(img, 0, 0, null, null);
		graphic.dispose();

		
		// retocar la imagen por bytes
		int value = 255;
//		for (int i = 0; i < width; i++) {
//			for (int j = 0; j < height; j++) {
//				value = pixel[i][j] << 16 | pixel[i][j] << 8 | pixel[i][j];
//				if (i > 0) {
//					value = value - (pixel[i - 1][j] << 16 | pixel[i - 1][j] << 8 | pixel[i - 1][j]);
//				}
//				if (i == 3 || j == 3) {
//					value = 255 << 16 | 255 << 8 | 255;
//				}
//				theImage.setRGB(i, j, value);
//			}
//		}

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_hh_mm__ss__SSS");

			imagenes.add(theImage);

			if (imagenes.size() == 200) {
				for (int i = 0; i < imagenes.size(); i++) {
					String fileOutput = "imgs/out" + sdf.format(new Date()) + ".gif";
					File outputPhoto = new File(fileOutput);
					ImageIO.write(imagenes.poll(), "gif", outputPhoto);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();

		}
		imagesArray[0] = theImage;
		imagesArray[1] = theImage2;
		return imagesArray;
	}

}
