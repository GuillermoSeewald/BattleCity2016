package Tanque;

import Mapa.*;

public class BasicTank extends Enemy{
	public BasicTank(int x, int y, Map map, int posE){
		super(1,12,1,"Basic tank","abajo", x, y, map, posE);
		puntos=100;
	}
	
	public int kill(){
		map.deleteEnemy(posEnEnemies);
		return puntos;
	}
/*	public boolean collide(Player jug){
	
	}
	public boolean collide(Enemy ene){
		
	}
	*/
}