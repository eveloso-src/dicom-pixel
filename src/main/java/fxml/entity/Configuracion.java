package fxml.entity;

import java.awt.Dimension;

public class Configuracion {

	private String name;
	private Dimension dim;
	private int posX;
	private int posY;

	public Configuracion(String string, Dimension dim, int i, int j) {
		this.name = string;
		this.dim = dim;
		posX = i;
		posY = j;
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

}
