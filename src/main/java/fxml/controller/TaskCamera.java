package fxml.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.imageio.ImageIO;

import com.github.sarxos.webcam.Webcam;

import javafx.beans.property.ObjectProperty;
import javafx.concurrent.Task;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

public class TaskCamera extends Task<Void> {

	private static long start;
	private static long ends;
	private boolean stopCamera = false;
	BufferedImage grabbedImage;
	Webcam webcamDefault;
	BufferedImage // 
	[] //CapturedImage
	arrayImg;
	private BufferedImage bwImage;
	private BufferedImage bwImage2;
	ObjectProperty<Image> imageProperty;
	ObjectProperty<Image> imageProperty2;
	ObjectProperty<Image> imageProperty3;

	public TaskCamera(boolean stopCam, BufferedImage grabbedImage, Webcam webcamDefault, CapturedImage[] arrayImg,
			ObjectProperty<Image> imageProperty, ObjectProperty<Image> imageProperty2,
			ObjectProperty<Image> imageProperty3) {
		this.stopCamera = stopCam;
		this.grabbedImage = grabbedImage;
		this.webcamDefault = webcamDefault;
		this.imageProperty = imageProperty;
		this.imageProperty2 = imageProperty2;
		this.imageProperty3 = imageProperty3;

//		this.arrayImg = arrayImg;
		
	}

	@Override
	protected Void call() throws Exception {

		ArrayDeque<BufferedImage> imagenes = new ArrayDeque<BufferedImage>(1000);

//		int nThreads = Runtime.getRuntime().availableProcessors();
		// System.out.println("procesadores: " + nThreads);
		ExecutorService executor = Executors.newSingleThreadExecutor();

		// SimpleDateFormat sdf = new SimpleDateFormat("ss");
		ToGray tg = new ToGray();
		String segundo = "";
		SimpleDateFormat ssdf = new SimpleDateFormat("ss");
		int contadorFPS = 0;
		Calendar inicio, fin;
		while (!stopCamera) {
			try {
				if ((grabbedImage = webcamDefault.getImage()) != null) {
					TaskCamera.timeStart(Calendar.getInstance().getTime().getTime());
					
					inicio = Calendar.getInstance();
					arrayImg = tg.convertBufferedImage(grabbedImage, imagenes);
					fin = Calendar.getInstance();
					long differ = fin.getTimeInMillis() - inicio.getTimeInMillis();

//					System.out.println(imagenes.size());
					
					contadorFPS++;
//					System.out.println(contadorFPS);
					if (!ssdf.format(new Date()).equals(segundo)) {
						segundo = ssdf.format(new Date());
//						System.out.println(contadorFPS + " " + imagenes.size());
						updateMessage(String.valueOf(contadorFPS));
//						contadorFPS = 0;
					}

					
					
					// System.out.println(String.valueOf(tg.getFps()));

//					label.setText(String.valueOf(tg.getFps()));
					bwImage = arrayImg[0];
					bwImage2 = arrayImg[1];

					executor.submit(new Runnable() {
						// @Override
						public void run() {
							final Image mainiamge = SwingFXUtils.toFXImage(grabbedImage, null);
							final Image mainiamge2 = SwingFXUtils.toFXImage(bwImage, null);
							final Image mainiamge3 = SwingFXUtils.toFXImage(bwImage2, null);
							imageProperty.set(mainiamge);
							imageProperty2.set(mainiamge2);
							imageProperty3.set(mainiamge3);
						}
					});
				}
			} catch (Exception e) {
			} finally {
			}
		}
		
		

//		TaskCamera.saveImages(imagenes);
		return null;
	}

	private static void timeStart(long time) {
		start = time;
		
	}

	public static void timeEnds(long time) {
		ends = time;
//		System.out.println(ends - start);
	}
	
//	public static void saveImages(ArrayDeque<BufferedImage> imagenes) {
//		try {
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_hh_mm__ss__SSS");
//
//			if (imagenes.size() == 200) {
//				System.out.println("guardando...");
//				TaskCamera.timeEnds(Calendar.getInstance().getTime().getTime());
//				for (int i = 0; i < imagenes.size(); i++) {
//					CapturedImage capImg = (CapturedImage)imagenes.poll();
//					
//					String fileOutput = "imgs/out" + sdf.format(capImg.getTime()) + ".gif";
//					File outputPhoto = new File(fileOutput);
//					ImageIO.write(capImg, "gif", outputPhoto);
//
//				
//				}
//			}
//
//		} catch (IOException e) {
//			e.printStackTrace();
//
//		}
//	}

};
