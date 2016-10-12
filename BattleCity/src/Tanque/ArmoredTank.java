package Tanque;

import Mapa.*;
import Shot.ShotEnemy;

public class ArmoredTank extends Enemy{
	public ArmoredTank(int x, int y, Map map, int posE){
		super(12,4,"Armored tank","abajo", x, y, map, posE);
		points=400;
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