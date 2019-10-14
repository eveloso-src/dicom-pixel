package fxml.controller;

import java.util.List;

import fxml.entity.Configuracion;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.CheckBox;

public class CheckListener implements ChangeListener<Boolean> {

	private List<Configuracion> mList;
	private CheckBox check;

	public CheckListener(List<Configuracion> monitorList, CheckBox c) {
		mList = monitorList;
		check = c;
	}

	public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {

		Configuracion configMonitor;
		for (int pos = 0; pos < mList.size(); pos++) {
			configMonitor = mList.get(pos);

			if (configMonitor.getRadio().isSelected()) {

				List<CheckBox> filtros = configMonitor.getFiltros();

				for (int i = 0; i < filtros.size(); i++) {
//					if (filtros.get(i) == check) {

//					System.out.println(check.getId() + " " + newValue);
					check.setSelected(newValue);
					filtros.set(i, check);
					System.out.println("guarda valor " + pos + " " + i + " " + (newValue ? 1 : 0));
					WebCamPreviewController.matrix[pos][i] = (newValue ? 1 : 0);
//					}
				}

			}
		}

	}
}
