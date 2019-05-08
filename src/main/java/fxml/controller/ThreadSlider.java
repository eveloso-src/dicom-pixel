package fxml.controller;

import javafx.concurrent.Task;
import javafx.scene.control.Slider;

@SuppressWarnings("restriction")
public class ThreadSlider extends Task<Void> {

	Slider slider;
	public int fps;

	public ThreadSlider(Slider sliderFrame) {
		// TODO Auto-generated constructor stub
		this.slider = sliderFrame;
		slider.setShowTickLabels(false);
		slider.setShowTickMarks(false);
		slider.setMajorTickUnit(1);
		slider.setMinorTickCount(1);
		slider.setBlockIncrement(1);
		
		this.fps = 30;
	}

	@Override
	protected Void call()
	// throws Exception
	{
		double nextVal = 0;
		while (TaskCamera.autoPlay) {

			try {
				Thread.sleep(fps);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			nextVal = slider.getValue() + 1;
			if (nextVal == this.slider.getMax() - 1) {
				nextVal = 0;
			}
			this.slider.setValue(nextVal);

		}
		 return null;
	}

};
