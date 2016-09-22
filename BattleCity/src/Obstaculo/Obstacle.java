package Obstaculo;

import Mapa.*;

public abstract class Obstacle extends Element{
	protected int posX;
	protected int posY;
	
	public Obstacle(String n, int x, int y, int posX, int posY, Map map){
		super(n,x,y,map);
		this.posX= posX;
		this.posY= posY;
	}
}