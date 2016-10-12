package Tanque;

import Mapa.*;
import Shot.ShotEnemy;

public class FastTank extends Enemy{
	public FastTank(int x, int y, Map map, int posE){
		super(8,1,"Fast tank","abajo", x, y, map, posE);
		points=200;
	}
	public void attack(){
		int[] pos=super.generatePosShot();
		new ShotEnemy(direction,pos[0],pos[1],map,9,this);
	}	
	protected int kill(){
		map.deleteEnemy(posEnEnemies);
		return points;		
	}
	public int kill(Player pla){
		return 0;
	}
	public int kill(Enemy ene){
		return 0;
	}
/*	public boolean collide(Player jug){
	
	}
	public boolean collide(Enemy ene){
		
	}
	*/
}