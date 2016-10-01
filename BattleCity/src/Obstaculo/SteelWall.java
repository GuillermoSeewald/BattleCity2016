package Obstaculo;

import Mapa.*;

public class SteelWall extends Wall{
	
	public SteelWall(int x, int y, int posX, int posY, Map map){
		super("Acero", x, y, posX, posY, map);
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