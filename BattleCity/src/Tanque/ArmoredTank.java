package Tanque;

import Mapa.*;

public class ArmoredTank extends Enemy{
	public ArmoredTank(int x, int y, Map map, int posE){
		super(1,12,4,"Armored tank","abajo", x, y, map, posE);
		puntos=400;
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