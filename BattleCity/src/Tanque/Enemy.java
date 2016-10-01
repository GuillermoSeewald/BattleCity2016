package Tanque;

import Mapa.*;

public abstract class Enemy extends Character{
	protected int posEnEnemies;
	
	public Enemy(int speedMov,int res,String n,String dir, int x, int y, Map map, int posE){
		super(speedMov,res,n,dir,x,y,map);
		posEnEnemies=posE;
	}
	
	public int getPosInEnemies(){
		return posEnEnemies;
	}
}