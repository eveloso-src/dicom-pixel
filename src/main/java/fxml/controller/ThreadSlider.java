package fxml.controller;

import javafx.concurrent.Task;
import javafx.scene.control.Slider;

@SuppressWarnings("restriction")
public class ThreadSlider extends Task<Void> {

	Slider slider;
	WebCamPreviewController controller;

	public ThreadSlider(Slider sliderFrame, WebCamPreviewController controller) {
		// TODO Auto-generated constructor stub
		this.slider = sliderFrame;
		this.controller = controller;
	}

	@Override
	protected Void call()
	// throws Exception
	{
		double nextVal = 0;
		while (true 
				&& controller.task.stopCamera
				&& !controller.btnStartCamera.isDisable()
				) {

			nextVal = slider.getValue() + 1;
			try {
				Thread.sleep(controller.getSpeed());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (nextVal == this.slider.getMax() - 1) {
				nextVal = 0;
			}
			this.slider.setValue(nextVal);

		}
		 return null;
	}

};
