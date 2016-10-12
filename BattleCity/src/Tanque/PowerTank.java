package Tanque;

import Mapa.*;
import Shot.*;

public class PowerTank extends Enemy{
	public PowerTank(int x, int y, Map map, int posE){
		super(12,1,"Power tank","abajo", x, y, map, posE);
		points=300;
	}
	public void attack(){
		int[] pos=super.generatePosShot();
		new ShotEnemy(direction,pos[0],pos[1],map,8,this);
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
/*	public boolean collide(Jugador jug){
	
	}
	public boolean collide(Enemigo ene){
		
	}
	*/
}