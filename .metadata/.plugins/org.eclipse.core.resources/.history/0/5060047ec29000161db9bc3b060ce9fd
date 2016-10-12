package Obstaculo;

import Mapa.*;

public class BrickWall extends Wall{
	
	public BrickWall(int x, int y, int posX, int posY, Map map){
		super("Ladrillo", x, y, posX, posY, map);
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