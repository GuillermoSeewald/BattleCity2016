package Obstaculo;

import Mapa.*;

public abstract class Obstaculo extends Celda{
	
	public Obstaculo(String nom, int x, int y){
		super(nom);
		this.setX(x);
		this.setY(y);
	}
}