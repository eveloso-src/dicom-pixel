package fxml.controller.handler;

import java.util.List;

import fxml.entity.Configuracion;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class ConfigCheckListener implements ChangeListener<Boolean> {

	List<Configuracion> monitorList;

	public ConfigCheckListener(List<Configuracion> monits) {
		monitorList = monits;
	}

	public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
		// WebCamPreviewController.filter1Active =
		// !WebCamPreviewController.filter1Active;

		Configuracion configMonitor;
		for (int pos = 0; pos < monitorList.size(); pos++) {
			configMonitor = monitorList.get(pos);

			if (configMonitor.getRadio().isSelected()) {
				configMonitor.setFilter1(configMonitor.getFilter1());
			}
		}

	}

}
