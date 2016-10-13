package Obstaculo;

import Mapa.*;
import Tanque.Enemy;
import Tanque.Player;

public class BrickWall extends Wall{
	
	public BrickWall(int x, int y, int posX, int posY, Map map){
		super("Ladrillo", x, y, posX, posY, map);
	}
	
	protected int kill(){
		map.deleteObstacle(posX, posY);
		return 1;
	}
	public int kill(Player pla){
		return kill();
	}
	public int kill(Enemy ene){
		return kill();
	}
/*	public boolean collide(Player jug){
	
	}
	public boolean collide(Enemy ene){
		
	}
	*/
}