package fxml.controller;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JPanel;

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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import laucher.AppLauncher;

@SuppressWarnings("restriction")
public class WebCamPreviewController implements Initializable {

	// public static final double IMAGE_WIDTH = 800;
	// public static final double IMAGE_HEIGTH = 800;
	@FXML
	Button btnStartCamera;
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
	ImageView imgWebCamCapturedImage0;
	@FXML
	ImageView video1;

	@FXML
	ImageView miniFrame;
	@FXML
	public Slider sliderFrame;
	
	ImageView duplicatedCam;

	public TaskCamera task;
	private BufferedImage grabbedImage;

	private CapturedImage[] arrayImg;
	// private WebcamPanel selWebCamPanel = null;
	private Webcam selWebCam = null;
	
	private ThreadSlider tslider;

	private Webcam webcamDefault = Webcam.getDefault();

	private boolean stopCamera = false;
	private ObjectProperty<Image> imageProperty = new SimpleObjectProperty<Image>();
	private ObjectProperty<Image> imageProperty2 = new SimpleObjectProperty<Image>();
	private ObjectProperty<Image> imageProperty3 = new SimpleObjectProperty<Image>();
	private ObjectProperty<Image> miniFramePreview = new SimpleObjectProperty<Image>();

	private String cameraListPromptText = "Seleccion Camara";
	public long speed = 30;

	public javafx.scene.control.Label getLabelFPS() {
		return labelFPS;
	}

	public void setLabelFPS(String value) {
		labelFPS.setText(value);
	}

	// @Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		comboSpeed.getItems().add("15 FPS");
		comboSpeed.getItems().add("30 FPS");
		comboSpeed.getItems().add("45 FPS");
		comboSpeed.getSelectionModel().select(1);

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

		comboSpeed.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (newValue.equals("15 FPS")) {
					comboSpeed.getSelectionModel().select(0);
					speed = 60;
				} else if (newValue.equals("45 FPS")) {
					comboSpeed.getSelectionModel().select(2);
					speed = 15;
				} else {
					comboSpeed.getSelectionModel().select(1);
					speed = 30;
				}

			}
		});

		comboSpeed.getSelectionModel().select(1);
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
		; // bpWebCamPaneHolder.getWidth();
		imgWebCamCapturedImage.setFitHeight(height / 3);
		imgWebCamCapturedImage.setFitWidth(width / 3);
		imgWebCamCapturedImage.prefHeight(height / 3);
		imgWebCamCapturedImage.prefWidth(width / 3);
		imgWebCamCapturedImage.setPreserveRatio(true);

//		duplicatedCam = imgWebCamCapturedImage3;
		
//		video1.setFitHeight(height / 3);
//		video1.setFitWidth(width / 3);
//		video1.prefHeight(height / 3);
//		video1.prefWidth(width / 3);
//		video1.setPreserveRatio(true);

		imgWebCamCapturedImage0.setFitHeight(height / 5);
		imgWebCamCapturedImage0.setFitWidth(width / 5);
		imgWebCamCapturedImage0.prefHeight(height / 5);
		imgWebCamCapturedImage0.prefWidth(width / 5);
		imgWebCamCapturedImage0.setPreserveRatio(true);


		imgWebCamCapturedImage2.setFitHeight(height / 5);
		imgWebCamCapturedImage2.setFitWidth(width / 5);
		imgWebCamCapturedImage2.prefHeight(height / 5);
		imgWebCamCapturedImage2.prefWidth(width / 5);
		imgWebCamCapturedImage2.setPreserveRatio(true);

		imgWebCamCapturedImage3.setFitHeight(height / 5);
		imgWebCamCapturedImage3.setFitWidth(width / 5);
		imgWebCamCapturedImage3.prefHeight(height / 5);
		imgWebCamCapturedImage3.prefWidth(width / 5);
		imgWebCamCapturedImage3.setPreserveRatio(true);

//		JFrame video1 = new JFrame("Vent");
//		video1.setSize(600, 600);
//		JPanel jpane = new JPanel();
//		jpane.add(imgWebCamCapturedImag);
//		video1.add(jpane);

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
		
		FXMLLoader load  = new FXMLLoader();
		FXMLLoader load2  = new FXMLLoader();
		
		load.setLocation(getClass().getResource("/fxml/gui/window.fxml"));
		load2.setLocation(getClass().getResource("/fxml/gui/window.fxml"));

		Stage stage = new Stage();
        stage.setTitle("Monitor 1");
//        try {
//        	javafx.scene.Parent windowLoad = load.load();
        	 javafx.scene.layout.StackPane secondaryLayout = new javafx.scene.layout.StackPane();
             secondaryLayout.getChildren().add(imgWebCamCapturedImage2);
			stage.setScene(new Scene(secondaryLayout, 450, 450));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
        stage.initModality(javafx.stage.Modality.NONE);
//	    stage.initStyle(javafx.stage.StageStyle.UNDECORATED);
        stage.show();

        
		Stage stage2 = new Stage();
        stage2.setTitle("Monitor 2");
//        try {
//        	javafx.scene.Parent windowLoad = load.load();
        	 javafx.scene.layout.StackPane secondaryLayout2 = new javafx.scene.layout.StackPane();
             secondaryLayout2.getChildren().add(imgWebCamCapturedImage3);
			stage2.setScene(new Scene(secondaryLayout2, 450, 450));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
        stage2.initModality(javafx.stage.Modality.NONE);
//	    stage.initStyle(javafx.stage.StageStyle.UNDECORATED);
        stage2.show();

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
		imgWebCamCapturedImage0.imageProperty().bind(imageProperty3);
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
		BufferedImage[] lBuffered = new BufferedImage[imagenes.size()];
		Iterator<BufferedImage> it = imagenes.iterator();
		// List<BufferedImage>list = new ArrayList<BufferedImage>();
		int i = 0;
		while (it.hasNext()) {
			lBuffered[i] = (it.next());
			i++;
		}
		final BufferedImage[] listImg = lBuffered;
		sliderFrame.setMax(imagenes.size());
		sliderFrame.valueProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
				imageProperty.set(SwingFXUtils.toFXImage(listImg[new_val.intValue()], null));
//				System.out.println(new_val);
//				sliderFrame.setValue(new_val.intValue());
//				sliderFrame.increment();
			}
		});

		BufferedImage frame;
		int contProgress = 0;
		int totalImg = imagenes.size();
		tslider = new ThreadSlider(sliderFrame, this);
		try {

			tslider.call();
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
//		}

	}

	public long getSpeed() {
		// TODO Auto-generated method stub
		return speed;
	}

}
