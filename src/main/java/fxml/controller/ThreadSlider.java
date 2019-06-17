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
		slider.setShowTickLabels(false);
		slider.setMajorTickUnit(1);
		slider.setMinorTickCount(1);
		slider.setBlockIncrement(1);
		
	}

	@Override
	protected Void call()
	// throws Exception
	{
		double nextVal = 0;
		System.out.println("autoplay " + TaskCamera.autoPlay);
		while (TaskCamera.autoPlay) {

			try {
				Thread.sleep(WebCamPreviewController.speed);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			nextVal = this.controller.sliderFrame.getValue() +1;

			if (nextVal == this.controller.sliderFrame.getMax() - 1) {
				nextVal = 0;
			}
			this.controller.sliderFrame.setValue(nextVal);

		}
		 return null;
	}

};
