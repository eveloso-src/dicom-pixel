package fxml.controller;

import java.util.List;

import fxml.entity.Configuracion;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.CheckBox;

public class MonitorListener implements ChangeListener<Boolean> {

	private javafx.scene.control.CheckBox checkFilter;
	private javafx.scene.control.CheckBox checkFilter2;
	private List<Configuracion> mList;


	public MonitorListener(CheckBox checkFilter1, CheckBox checkFilter2, List<Configuracion> monitorList) {
		checkFilter = checkFilter1;
		this.checkFilter2 = checkFilter2;
		mList = monitorList;
	}

	public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
		// WebCamPreviewController.filter1Active =
		// !WebCamPreviewController.filter1Active;

		Configuracion configMonitor;
		for (int pos = 0; pos < mList.size(); pos++) {
			configMonitor = mList.get(pos);

			if (configMonitor.getRadio().isSelected()) {
				configMonitor.setFilter1(checkFilter.isSelected() == true ? 1 : 0);
				configMonitor.setFilter2(checkFilter2.isSelected() == true ? 1 : 0);
			}
		}

	}
}
