package Tanque;

import Mapa.*;

public class ArmoredTank extends Enemy{
	public ArmoredTank(int x, int y, Map map, int posE){
		super(12,4,"Armored tank","abajo", x, y, map, posE);
		points=400;
	}
	public void attack(){
		super.attack(9);
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