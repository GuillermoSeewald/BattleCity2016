package Obstaculo;

import Mapa.*;

public abstract class Obstacle extends Element{
	protected int posX;
	protected int posY;
	
	public Obstacle(String n, int x, int y, int posX, int posY){
		super(n,x,y);
		this.posX= posX;
		this.posY= posY;
	}
}