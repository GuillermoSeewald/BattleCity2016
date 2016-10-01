package Obstaculo;

import Mapa.*;

public class Tree extends Obstacle{
	
	public Tree(int x, int y, int posX, int posY, Map map){
		super("Arbol",x ,y, posX, posY, map);
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