package Tanque;

import Mapa.*;
import Shot.ShotEnemy;

public class BasicTank extends Enemy{
	public BasicTank(int x, int y, Map map, int posE){
		super(12,1,"Basic tank","abajo", x, y, map, posE);
		points=100;
	}
	public void attack(){
		int[] pos=super.generatePosShot();
		new ShotEnemy(direction,pos[0],pos[1],map,10,this);
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