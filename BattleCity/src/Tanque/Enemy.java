package Tanque;

import Mapa.*;

public abstract class Enemy extends Character{
	protected int posEnEnemies;
	
	public Enemy(int v,int velM,int golpes,String nom,String dir, int x, int y, Map map, int posE){
		super(v,velM,golpes,nom,dir,x,y,map);
		posEnEnemies=posE;
	}
	
	public int getPosEnEnemies(){
		return posEnEnemies;
	}
}