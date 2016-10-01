package Obstaculo;

import Mapa.*;

public class Water extends Obstacle{
	
	public Water(int x, int y, int posX, int posY, Map map){
		super("Agua", x, y, posX, posY, map);
	}
	
	public int kill(){
		map.deleteObstacle(posX, posY);
		return 0;
	}
/*	public boolean collide(Player jug){
	
	}
	public boolean collide(Enemy ene){
		
	}
	*/
}