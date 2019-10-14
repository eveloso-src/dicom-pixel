package fxml.controller;

import java.util.List;

import fxml.entity.Configuracion;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;

public class MonitorListener implements ChangeListener<Boolean> {

	private javafx.scene.control.CheckBox checkFilter;
	private javafx.scene.control.CheckBox checkFilter2;
	private List<Configuracion> mList;
	private RadioButton element;

	public MonitorListener(CheckBox checkFilter1, CheckBox checkFilter2, List<Configuracion> monitorList,
			RadioButton radioImg2) {
		this.checkFilter = checkFilter1;
		this.checkFilter2 = checkFilter2;
		mList = monitorList;
		element = radioImg2;

	}

	public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
		// WebCamPreviewController.filter1Active =
		// !WebCamPreviewController.filter1Active;

		Configuracion configMonitor;
		for (int pos = 0; pos < mList.size(); pos++) {
			configMonitor = mList.get(pos);

			System.out.println("configMonitor.getRadio() == element " + (configMonitor.getRadio() == element));
			if (configMonitor.getRadio() == element) {

				element.setSelected(true);
//				configMonitor.setFilter1()
//				configMonitor.setFilter1(checkFilter.isSelected() == true ? 1 : 0);
//				System.out.println("checkFilter " + checkFilter.isSelected());
//				configMonitor.setFilter2(checkFilter2.isSelected() == true ? 1 : 0);
//				System.out.println("checkFilter2 " + checkFilter2.isSelected());

				List<CheckBox> filters = configMonitor.getFiltros();
//				for(int j=0;j<filters.size();j++) {
//					filters.get(j).setSelected(value);
//				}
				
			}
			else {
				element.setSelected(false);
			}
		}

	}
}
