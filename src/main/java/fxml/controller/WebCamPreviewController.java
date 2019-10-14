package fxml.controller;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.commons.lang3.StringUtils;

import com.github.sarxos.webcam.Webcam;

import fxml.entity.Configuracion;
import fxml.entity.WebCamInfo;
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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import laucher.AppLauncher;

@SuppressWarnings("restriction")
public class WebCamPreviewController implements Initializable {
	public static final String CONFIG_LAST_MONITOR = "config.last.monitor";

	public static int[][] matrix = { { 0, 0 }, { 0, 0 }, { 0, 0 }, { 0, 0 } };

	public static int nMonitor = 0;
	@FXML
	Button btnStartCamera;
	@FXML
	javafx.scene.control.ComboBox<String> cmbConfig;
	@FXML
	javafx.scene.control.TextField txtComo;
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
	javafx.scene.control.CheckBox checkFilter1;
	@FXML
	javafx.scene.control.CheckBox checkFilter2;
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
	BorderPane bpWebCamPaneHolder;
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
	ImageView imgWebCamCapturedImage5Main;
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
//	@FXML
//	ImageView miniFrame;
	@FXML
	public Slider sliderFrame;

//	public static boolean filter1Active = false;

	public BufferedImage[] lBuffered;
	public static int speed = 30;
	public ObservableList<WebCamInfo> options;
	public ArrayDeque<BufferedImage> aqImagenes;
	public ThreadSlider tslider;

	public TaskCamera task;

	public List<Stage> windows;

//	ImageView duplicatedCam;

	private BufferedImage grabbedImage;

	private CapturedImage[] arrayImg;
	private Webcam selWebCam = null;

	private List<Configuracion> monitorList = new ArrayList<Configuracion>();
	private List<CheckBox> controlesList = new ArrayList<CheckBox>();
	private Webcam webcamDefault = Webcam.getDefault();

	private boolean stopCamera = false;
	private ObjectProperty<Image> imageProperty = new SimpleObjectProperty<Image>();
	private ObjectProperty<Image> imageProperty2 = new SimpleObjectProperty<Image>();
	private ObjectProperty<Image> imageProperty3 = new SimpleObjectProperty<Image>();
	private ObjectProperty<Image> imageProperty4 = new SimpleObjectProperty<Image>();
	private ObjectProperty<Image> imageProperty5 = new SimpleObjectProperty<Image>();
	private ObjectProperty<Image> miniFramePreview = new SimpleObjectProperty<Image>();

	public javafx.scene.control.Label getLabelFPS() {
		return labelFPS;
	}

	public void setLabelFPS(String value) {
		labelFPS.setText(value);
	}

	public void initialize(URL arg0, ResourceBundle arg1) {
		this.cmbConfig.setItems(WindowUtil.getConfig());
		cmbConfig.getSelectionModel().selectFirst();
		monitorList.add(new Configuracion(radioImg1));
		monitorList.add(new Configuracion(radioImg2));
		monitorList.add(new Configuracion(radioImg3));
		monitorList.add(new Configuracion(radioImg4));

		options = FXCollections.observableArrayList();
		int webCamCounter = 0;
		for (Webcam webcam : Webcam.getWebcams()) {
			WebCamInfo webCamInfo = new WebCamInfo();
			webCamInfo.setWebCamIndex(webCamCounter);
			webCamInfo.setWebCamName(webcam.getName());
			webcam.setViewSize(new Dimension(640, 480));
			options.add(webCamInfo);
			webCamCounter++;
		}

		Platform.runLater(new Runnable() {
			// @Override
			public void run() {
				setImageViewSize();
			}
		});

		this.radioImg1.setSelected(true);

//		radioImg1.selectedProperty().addListener(new MonitorListener(checkFilter1, checkFilter2, monitorList, radioImg1));
//		radioImg2.selectedProperty().addListener(new MonitorListener(checkFilter1, checkFilter2, monitorList, radioImg2));
//		radioImg3.selectedProperty().addListener(new MonitorListener(checkFilter1, checkFilter2, monitorList, radioImg3));
//		radioImg4.selectedProperty().addListener(new MonitorListener(checkFilter1, checkFilter2, monitorList, radioImg4));

//		checkFilter1.selectedProperty().addListener(new CheckListener(monitorList, checkFilter1));
//		checkFilter2.selectedProperty().addListener(new CheckListener(monitorList, checkFilter2));

		controlesList.add(checkFilter1);
		controlesList.add(checkFilter2);
	}

	protected void setImageViewSize() {
		double height = Integer.valueOf(AppLauncher.getProp("width")).intValue(); // bpWebCamPaneHolder.getHeight();
		double width = Integer.valueOf(AppLauncher.getProp("height")).intValue();

		List<ImageView> listViews = new ArrayList();
		listViews.add(imgWebCamCapturedImage2);
		listViews.add(imgWebCamCapturedImage3);
		listViews.add(imgWebCamCapturedImage4);
		listViews.add(imgWebCamCapturedImage5Main);
		// pone tamaños a todas las pantallas segun los params deconfig
		WindowUtil.configurePreview(listViews, height, width);

		imgWebCamCapturedImage.setFitHeight(height / 2);
		imgWebCamCapturedImage.setFitWidth(width / 2);
		imgWebCamCapturedImage.prefHeight(height / 2);
		imgWebCamCapturedImage.prefWidth(width / 2);
		imgWebCamCapturedImage.setPreserveRatio(true);

//
//		imgWebCamCapturedImage5Main.setFitHeight(height / 2);
//		imgWebCamCapturedImage5Main.setFitWidth(width / 2);
//		imgWebCamCapturedImage5Main.prefHeight(height / 2);
//		imgWebCamCapturedImage5Main.prefWidth(width / 2);
//		imgWebCamCapturedImage5Main.setPreserveRatio(true);

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
		btnStartCamera.setDisable(true);
		windows = new WindowUtil().openWindows(imgWebCamCapturedImage2, imgWebCamCapturedImage3,
				imgWebCamCapturedImage4, imgWebCamCapturedImage5Main,
				this.cmbConfig.getSelectionModel().getSelectedItem());
	}

	protected void startWebCamStream() {
		stopCamera = false;
		task = new TaskCamera(stopCamera, grabbedImage, webcamDefault, arrayImg, imageProperty, imageProperty2,
				imageProperty3, imageProperty4, miniFramePreview, this);
		Thread th = new Thread(task);
		labelFPS.textProperty().bind(task.messageProperty());
		th.setDaemon(true);
		th.start();

		// imageProperty es la imagen color
		// imageProperty2 es una imagen con filtro
		// imageProperty3 es otra imagen blanco y negro
		imgWebCamCapturedImage.imageProperty().bind(imageProperty);
		imgWebCamCapturedImage2.imageProperty().bind(imageProperty2);
		imgWebCamCapturedImage3.imageProperty().bind(imageProperty3);
		imgWebCamCapturedImage4.imageProperty().bind(imageProperty4);
		imgWebCamCapturedImage5Main.imageProperty().bind(imageProperty2);

		imgPreview1.imageProperty().bind(imageProperty2);
		imgPreview2.imageProperty().bind(imageProperty2);
		imgPreview3.imageProperty().bind(imageProperty3);
		imgPreview4.imageProperty().bind(imageProperty4);
//		duplicatedCam.imageProperty().bind(imageProperty3);
		// imgWebCamCapturedImage3.imageProperty().bind(miniFramePreview);

		// miniFrame.imageProperty().bind(miniFramePreview);
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
		if (task != null) {
			task.stopCamera = false; // funciona este
			tslider.cancel();
		}
		initializeWebCam(0);
		startWebCamStream();
		btnStartCamera.setDisable(true);
		btnStopCamera.setDisable(false);
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

		this.cmbConfig.valueProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
				String value = cmbConfig.getValue();
				ObservableList<String> listConfigs = WindowUtil.getConfig();

				WindowUtil.closeMonitors(windows);
				for (int i = 0; i < listConfigs.size(); i++) {
					String itemcfg = listConfigs.get(i);
					if (itemcfg.contentEquals(value)) {
						// abrir monitores
//						AppLauncher.getProp("config." + value + ".monitor." + i);

						windows = new WindowUtil().openWindows(imgWebCamCapturedImage2, imgWebCamCapturedImage3,
								imgWebCamCapturedImage4, imgWebCamCapturedImage5Main,
//								this.cmbConfig.getSelectionModel().getSelectedItem()
								value);

					}
				}
			}

		});

		sliderFrame.setOnMouseClicked((event) -> {
			TaskCamera.autoPlay = !TaskCamera.autoPlay;
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
					if (posicion == (int) sliderFrame.getMax() - 1) {
						posicion = 0;
						System.out.println("reiniciar");
					}
					sliderFrame.setValue(posicion);
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

	public void stopClick(ActionEvent event) {
		TaskCamera.autoPlay = !TaskCamera.autoPlay;
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

	public void check1Click(ActionEvent event) {
		checkClick(0);
	}

	public void check2Click(ActionEvent event) {
		checkClick(1);
	}

	private void checkClick(int i) {
		matrix[nMonitor][i] = controlesList.get(i).isSelected() ? 1 : 0;
//		System.out.println("guarda monitor " + nMonitor + " check " + i +" " + matrix[nMonitor][i]);
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

	private void selectRadio(int iradio) {
		nMonitor = iradio - 1;
		Configuracion configMonitor;

//		System.out.println(iradio);
		for (int pos = 0; pos < monitorList.size(); pos++) {
			configMonitor = monitorList.get(pos);

			configMonitor.getRadio().setSelected(pos == iradio - 1);
			if (pos == iradio - 1) {
				for (int i = 0; i < controlesList.size(); i++) {
					CheckBox control = controlesList.get(i);
					
					control.setSelected(1 == WebCamPreviewController.matrix[pos][i]);
//					System.out.println("control: " + i + " " + control.isSelected());

				}
			}
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

	public void clickComo() {
		String newConfig = txtComo.getText();
		System.out.println("guardar como.." + newConfig);
		if (!StringUtils.isEmpty(newConfig)) {
			cmbConfig.getItems().add(newConfig);
			cmbConfig.setValue(newConfig);
			clickGuardar();
		}
	}

	public void clickGuardar() {
		String item = cmbConfig.getSelectionModel().getSelectedItem();
		System.out.println("guardar " + item);
		String value;
		for (int i = 1; i < 5; i++) {
			value = String.valueOf(windows.get(i - 1).getX()) + ";" + String.valueOf(windows.get(i - 1).getY());
			AppLauncher.setProp("config." + item + ".monitor." + i, value.replace(".0", ""));
		}

		AppLauncher.setProp(CONFIG_LAST_MONITOR, item);
	}

	public void cargarConfig() {

	}

}
