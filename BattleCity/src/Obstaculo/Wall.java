package Obstaculo;

import Mapa.*;

public abstract class Wall extends Obstacle{
	public Wall(String n, int x, int y, int posX, int posY, Map map){
		super(n,x,y, posX, posY, map);
	}
}