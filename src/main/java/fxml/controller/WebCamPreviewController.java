package fxml.controller;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;

import com.github.sarxos.webcam.Webcam;

import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import laucher.AppLauncher;

@SuppressWarnings("restriction")
public class WebCamPreviewController implements Initializable {

	// public static final double IMAGE_WIDTH = 800;
	// public static final double IMAGE_HEIGTH = 800;
	@FXML
	Button btnStartCamera;
	@FXML
	BorderPane borderPane;
	@FXML
	javafx.scene.control.Label imgCounter;
	@FXML
	Button fps15;
	@FXML
	Button fps30;
	@FXML
	Button fps45;

	@FXML
	javafx.scene.layout.Pane panePreview1;
	@FXML
	javafx.scene.layout.Pane panePreview2;
	@FXML
	javafx.scene.layout.Pane panePreview3;
	@FXML
	javafx.scene.layout.Pane panePreview4;

	@FXML
	javafx.scene.control.RadioButton radioImg1;
	@FXML
	javafx.scene.control.RadioButton radioImg2;
	@FXML
	javafx.scene.control.RadioButton radioImg3;
	@FXML
	javafx.scene.control.RadioButton radioImg4;

	@FXML
	Button btnStopCamera;
	@FXML
	Button btnDisposeCamera;
	@FXML
	ComboBox<WebCamInfo> cbCameraOptions;
	@FXML
	BorderPane bpWebCamPaneHolder;
	// @FXML
	// FlowPane fpBottomPane;
	@FXML
	ImageView imgWebCamCapturedImage;

	@FXML
	javafx.scene.control.Label labelFPS;

	@FXML
	javafx.scene.control.ComboBox<String> comboSpeed;

	@FXML
	ImageView imgWebCamCapturedImage2;
	@FXML
	ImageView imgWebCamCapturedImage3;

	@FXML
	ImageView imgWebCamCapturedImage4;

	@FXML
	ImageView imgWebCamCapturedImage5;

	@FXML
	ImageView imgPreview1;
	@FXML
	ImageView imgPreview2;
	@FXML
	ImageView imgPreview3;
	@FXML
	ImageView imgPreview4;

	@FXML
	ImageView video1;

	@FXML
	ImageView miniFrame;
	@FXML
	public Slider sliderFrame;

	public BufferedImage[] lBuffered;
	public static int speed = 30;

	public ArrayDeque<BufferedImage> aqImagenes;
	public ThreadSlider tslider;

	public TaskCamera task;

	ImageView duplicatedCam;

	private BufferedImage grabbedImage;

	private CapturedImage[] arrayImg;
	// private WebcamPanel selWebCamPanel = null;
	private Webcam selWebCam = null;

	private List<javafx.scene.control.RadioButton> radioList = new ArrayList<javafx.scene.control.RadioButton>();
	private Webcam webcamDefault = Webcam.getDefault();

	private boolean stopCamera = false;
	private ObjectProperty<Image> imageProperty = new SimpleObjectProperty<Image>();
	private ObjectProperty<Image> imageProperty2 = new SimpleObjectProperty<Image>();
	private ObjectProperty<Image> imageProperty3 = new SimpleObjectProperty<Image>();
	private ObjectProperty<Image> miniFramePreview = new SimpleObjectProperty<Image>();

	private String cameraListPromptText = "Seleccion Camara";

	public javafx.scene.control.Label getLabelFPS() {
		return labelFPS;
	}

	public void setLabelFPS(String value) {
		labelFPS.setText(value);
	}

	// @Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		radioList.add(radioImg1);
		radioList.add(radioImg2);
		radioList.add(radioImg3);
		radioList.add(radioImg4);
		// fpBottomPane.setDisable(true);
		ObservableList<WebCamInfo> options = FXCollections.observableArrayList();
		int webCamCounter = 0;
		for (Webcam webcam : Webcam.getWebcams()) {
			WebCamInfo webCamInfo = new WebCamInfo();
			webCamInfo.setWebCamIndex(webCamCounter);
			webCamInfo.setWebCamName(webcam.getName());
			webcam.setViewSize(new Dimension(640, 480));
			options.add(webCamInfo);
			webCamCounter++;
		}
		cbCameraOptions.setItems(options);
		// cbCameraOptions.getSelectionModel().select(0);
		// initializeWebCam(webCamIndex);
		cbCameraOptions.setPromptText(cameraListPromptText);
		cbCameraOptions.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<WebCamInfo>() {

			// @Override
			public void changed(ObservableValue<? extends WebCamInfo> arg0, WebCamInfo arg1, WebCamInfo arg2) {
				if (arg2 != null) {
					System.out.println(
							"WebCam Index: " + arg2.getWebCamIndex() + ": WebCam Name:" + arg2.getWebCamName());
					initializeWebCam(arg2.getWebCamIndex());
				}
			}
		});

		Platform.runLater(new Runnable() {
			// @Override
			public void run() {
				setImageViewSize();
			}
		});
	}

	protected void setImageViewSize() {
		double height = Integer.valueOf(AppLauncher.getProp("width")).intValue(); // bpWebCamPaneHolder.getHeight();
		double width = Integer.valueOf(AppLauncher.getProp("height")).intValue();

		List<ImageView> listViews = new ArrayList();
		listViews.add(imgWebCamCapturedImage2);
		listViews.add(imgWebCamCapturedImage3);
		listViews.add(imgWebCamCapturedImage4);
		listViews.add(imgWebCamCapturedImage5);
		WindowUtil.configurePreview(listViews, height, width);

		imgWebCamCapturedImage.setFitHeight(height / 2);
		imgWebCamCapturedImage.setFitWidth(width / 2);
		imgWebCamCapturedImage.prefHeight(height / 2);
		imgWebCamCapturedImage.prefWidth(width / 2);
		imgWebCamCapturedImage.setPreserveRatio(true);

		List<ImageView> listPreview = new ArrayList();
		listPreview.add(imgPreview1);
		listPreview.add(imgPreview2);
		listPreview.add(imgPreview3);
		listPreview.add(imgPreview4);
		WindowUtil.configureSmallPreview(listPreview, height, width);
	}

	protected void initializeWebCam(final int webCamIndex) {

		Task<Void> webCamIntilizer = new Task<Void>() {

			@Override
			protected Void call() throws Exception {

				if (selWebCam == null) {
					selWebCam = Webcam.getWebcams().get(webCamIndex);
					selWebCam.open();
				} else {
					closeCamera();
					selWebCam = Webcam.getWebcams().get(webCamIndex);
					selWebCam.open();

				}
				startWebCamStream();
				return null;
			}

		};

		new Thread(webCamIntilizer).start();
		// fpBottomPane.setDisable(false);
		btnStartCamera.setDisable(true);

		new WindowUtil().openWindows(imgWebCamCapturedImage2, imgWebCamCapturedImage3, imgWebCamCapturedImage4,
				imgWebCamCapturedImage5);
	}

	protected void startWebCamStream() {

		stopCamera = false;
		task = new TaskCamera(stopCamera, grabbedImage, webcamDefault, arrayImg, imageProperty, imageProperty2,
				imageProperty3, imageProperty3, miniFramePreview, this);
		Thread th = new Thread(task);
		labelFPS.textProperty().bind(task.messageProperty());
		th.setDaemon(true);
		th.start();
		imgWebCamCapturedImage.imageProperty().bind(imageProperty);
		imgWebCamCapturedImage2.imageProperty().bind(imageProperty2);
		imgWebCamCapturedImage3.imageProperty().bind(imageProperty3);
		imgWebCamCapturedImage4.imageProperty().bind(imageProperty3);
		imgWebCamCapturedImage5.imageProperty().bind(imageProperty3);

		imgPreview1.imageProperty().bind(imageProperty3);
		imgPreview2.imageProperty().bind(imageProperty2);
		imgPreview3.imageProperty().bind(imageProperty3);
		imgPreview4.imageProperty().bind(imageProperty3);
//		duplicatedCam.imageProperty().bind(imageProperty3);
		// imgWebCamCapturedImage3.imageProperty().bind(miniFramePreview);
		miniFrame.imageProperty().bind(miniFramePreview);
	}

	private void closeCamera() {
		if (webcamDefault != null) {
			webcamDefault.close();
		}
	}

	public void stopCamera(ActionEvent event) {
//		stopCamera = true;
		task.stopCamera = true; // funciona este
		btnStartCamera.setDisable(false);
		btnStopCamera.setDisable(true);
	}

	public void startCamera(ActionEvent event) {
//		stopCamera = false;
		task.stopCamera = false; // funciona este
		tslider.cancel();
		startWebCamStream();

		btnStartCamera.setDisable(true);
		btnStopCamera.setDisable(false);

	}

	// public void disposeCamera(ActionEvent event) {
	// stopCamera = true;
	// closeCamera();
	// Webcam.shutdown();
	// btnStopCamera.setDisable(true);
	// btnStartCamera.setDisable(true);
	// }

	class WebCamInfo {
		private String webCamName;
		private int webCamIndex;

		public String getWebCamName() {
			return webCamName;
		}

		public void setWebCamName(String webCamName) {
			this.webCamName = webCamName;
		}

		public int getWebCamIndex() {
			return webCamIndex;
		}

		public void setWebCamIndex(int webCamIndex) {
			this.webCamIndex = webCamIndex;
		}

		@Override
		public String toString() {
			return webCamName;
		}

	}

	public void createSlider(final ArrayDeque<BufferedImage> imagenes) {
		// play images
		aqImagenes = imagenes;
		lBuffered = new BufferedImage[imagenes.size()];
		Iterator<BufferedImage> it = imagenes.iterator();
		// List<BufferedImage>list = new ArrayList<BufferedImage>();
		int i = 0;

		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				// Update UI here.
				imgCounter.setText(imagenes.size() + "");
			}
		});

		while (it.hasNext()) {
			lBuffered[i] = (it.next());
			i++;
		}
		final BufferedImage[] listImg = lBuffered;
		Platform.setImplicitExit(false);
		sliderFrame.setMax(imagenes.size());
		sliderFrame.valueProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
				imageProperty.set(SwingFXUtils.toFXImage(listImg[new_val.intValue()], null));
			}
		});

		sliderFrame.setOnMouseClicked((event) -> {
			// tslider.cancel();
			TaskCamera.autoPlay = !TaskCamera.autoPlay;
			if (TaskCamera.autoPlay) {
			}
		});

		tslider = new ThreadSlider(sliderFrame, this);
		try {

			tslider.call();
		} catch (Exception e) {
			e.printStackTrace();
		}

//		while (stopCamera) {
//			Iterator<BufferedImage> it1 = imagenes.iterator();
//
//			
//			while (it1.hasNext() && stopCamera) {
//				frame = it1.next();
//				imageProperty.set(SwingFXUtils.toFXImage(frame, null));
//				imageProperty2.set(SwingFXUtils.toFXImage(frame, null));
//				imageProperty3.set(SwingFXUtils.toFXImage(frame, null));
//				contProgress++;
//				if (contProgress == totalImg) {
//					contProgress = 0;
//				}
//
//			}

//		});

		// while (stopCamera) {
		// Iterator<BufferedImage> it1 = imagenes.iterator();
		//
		//
		// while (it1.hasNext() && stopCamera) {
		// frame = it1.next();
		// imageProperty.set(SwingFXUtils.toFXImage(frame, null));
		// imageProperty2.set(SwingFXUtils.toFXImage(frame, null));
		// imageProperty3.set(SwingFXUtils.toFXImage(frame, null));
		// contProgress++;
		// if (contProgress == totalImg) {
		// contProgress = 0;
		// }
		//
		// }
		// }

	}

	public long getSpeed() {
		// TODO Auto-generated method stub
		return speed;
	}

	public void fwdClick(ActionEvent event) {
		play(task.imagenes, "+");

	}

	private void play(ArrayDeque<BufferedImage> imagenes, String sign) {
		double valor = sliderFrame.getValue();
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				int posicion = (int) valor;

				if (sign.equals("+")) {

					posicion++;
					sliderFrame.setValue(posicion);
					if (posicion == (int) sliderFrame.getMax() - 1) {
						posicion = 0;
					}
				} else {
					posicion--;
					sliderFrame.setValue(posicion);
					if (posicion == 0) {
						posicion = (int) sliderFrame.getMax();
					}

				}

				imageProperty3.setValue(SwingFXUtils.toFXImage(lBuffered[(int) sliderFrame.getValue()], null));
				// Update UI here.
				imgCounter.setText((int) sliderFrame.getValue() + "");
			}
		});

	}

	public void backClick(ActionEvent event) {
		play(aqImagenes, "-");
	}

	public void playBtnClick(ActionEvent event) {
		TaskCamera.autoPlay = true;
		Task task = new ThreadPlay(aqImagenes, sliderFrame, imageProperty3);
		Thread th = new Thread(task);
		th.setDaemon(true);
		th.start();
	}

	public void backPlayClick(ActionEvent event) {
		TaskCamera.autoPlay = true;
		Task task = new ThreadBack(aqImagenes, sliderFrame, imageProperty3);
		Thread th = new Thread(task);
		th.setDaemon(true);
		th.start();
	}

	public void imgPreview1Clicked(ActionEvent event) {
		panePreview1.setStyle("-fx-border-color: #ff0000; -fx-border-width: 5px;");
	}

	public void imgPreview2Clicked(ActionEvent event) {
		panePreview2.setStyle("-fx-border-color: #ff0000; -fx-border-width: 5px;");
	}

	public void imgPreview3Clicked(ActionEvent event) {
		panePreview3.setStyle("-fx-border-color: #ff0000; -fx-border-width: 5px;");
	}

	public void imgPreview4Clicked(ActionEvent event) {
		panePreview4.setStyle("-fx-border-color: #ff0000; -fx-border-width: 5px;");
	}

	public void radioImg1Click(ActionEvent event) {
		selectRadio(1);
	}

	public void radioImg2Click(ActionEvent event) {
		selectRadio(2);
	}

	public void radioImg3Click(ActionEvent event) {
		selectRadio(3);
	}

	public void radioImg4Click(ActionEvent event) {
		selectRadio(4);
	}

	private void selectRadio(int i) {
		for (int pos = 0; pos < radioList.size(); pos++) {
			radioList.get(pos).setSelected(pos == i - 1);
		}
	}

	public static void selectImgPreview1() {

	}

	public void speed15() {
		WebCamPreviewController.speed = 60;
		fps15.setStyle("-fx-border-color: #ff0000; -fx-border-width: 2px;");
		fps45.setStyle(null);
		fps30.setStyle(null);

	}

	public void speed30() {
		WebCamPreviewController.speed = 33;
		fps30.setStyle("-fx-border-color: #ff0000; -fx-border-width: 2px;");
		fps15.setStyle(null);
		fps45.setStyle(null);

	}

	public void speed45() {
		WebCamPreviewController.speed = 16;
		fps45.setStyle("-fx-border-color: #ff0000; -fx-border-width: 2px;");
		fps15.setStyle(null);
		fps30.setStyle(null);
	}
}
