package fxml.entity;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;

public class Configuracion {

	private String name;
	private Dimension dim;
	private int posX;
	private int posY;
	
	private List<CheckBox> filtros;
	private javafx.scene.control.RadioButton radio;
	

	public Configuracion(String string, Dimension dim, int i, int j) {
		this.name = string;
		this.dim = dim;
		posX = i;
		posY = j;
	}

	public Configuracion(RadioButton radioImg1) {
		radio = radioImg1;
		filtros = new ArrayList();
		filtros.add(new CheckBox());
		filtros.add(new CheckBox());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Dimension getDim() {
		return dim;
	}

	public void setDim(Dimension dim) {
		this.dim = dim;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}


	public List<CheckBox> getFiltros() {
		return filtros;
	}

	public void setFiltros(List<CheckBox> filtros) {
		this.filtros = filtros;
	}

	public javafx.scene.control.RadioButton getRadio() {
		return radio;
	}

	public void setRadio(javafx.scene.control.RadioButton radio) {
		this.radio = radio;
	}

	
	
}
