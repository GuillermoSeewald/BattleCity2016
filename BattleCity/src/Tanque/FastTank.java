package Tanque;

import Mapa.*;

public class FastTank extends Enemy{
	public FastTank(int x, int y, Map map, int posE){
		super(1,8,1,"Fast tank","abajo", x, y, map, posE);
		puntos=200;
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