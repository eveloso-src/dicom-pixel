package fxml.entity;

import java.awt.Dimension;

import javafx.scene.control.RadioButton;

public class Configuracion {

	private String name;
	private Dimension dim;
	private int posX;
	private int posY;
	private int filter1;
	private int filter2;
	private javafx.scene.control.RadioButton radio;
	

	public Configuracion(String string, Dimension dim, int i, int j) {
		this.name = string;
		this.dim = dim;
		posX = i;
		posY = j;
	}

	public Configuracion(RadioButton radioImg1) {
		radio = radioImg1;
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

	public int getFilter1() {
		return filter1;
	}

	public void setFilter1(int filter1) {
		this.filter1 = filter1;
	}

	public int getFilter2() {
		return filter2;
	}

	public void setFilter2(int filter2) {
		this.filter2 = filter2;
	}

	public javafx.scene.control.RadioButton getRadio() {
		return radio;
	}

	public void setRadio(javafx.scene.control.RadioButton radio) {
		this.radio = radio;
	}

	
	
}
