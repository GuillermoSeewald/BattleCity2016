package Tanque;

import Mapa.*;

public class BasicTank extends Enemy{
	public BasicTank(int x, int y, Map map, int posE){
		super(12,1,"Basic tank","abajo", x, y, map, posE);
		points=100;
	}
	public void attack(){
		super.attack(10);
	}	
	public int kill(){
		map.deleteEnemy(posEnEnemies);
		return points;
	}
/*	public boolean collide(Player jug){
	
	}
	public boolean collide(Enemy ene){
		
	}
	*/
}