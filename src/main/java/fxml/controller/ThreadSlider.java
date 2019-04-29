package fxml.controller;

import javafx.concurrent.Task;
import javafx.scene.control.Slider;

@SuppressWarnings("restriction")
public class ThreadSlider extends Task<Void> {

	Slider slider;

	public ThreadSlider(Slider sliderFrame) {
		// TODO Auto-generated constructor stub
		this.slider = sliderFrame;
	}

	@Override
	protected Void call()
	// throws Exception
	{
		double nextVal = 0;
		while (true) {

			nextVal = slider.getValue() + 1;
			if (nextVal == this.slider.getMax() - 1) {
				nextVal = 0;
			}
			this.slider.setValue(nextVal);

		}
		// return null;
	}

};
