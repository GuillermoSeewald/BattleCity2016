package Tanque;

import Mapa.*;
import java.awt.Image;

public abstract class Enemy extends Character{
	
	protected int posInEnemies;
	protected boolean haveShot;
	
	protected Image[][] images;
	
	public Enemy(int speedMov,int res,String n,String dir, int x, int y, Map map, int posE){
		super(speedMov,res,n,dir,x,y,map);
		posInEnemies=posE;
	}
	public abstract void terminate();
	public abstract void enableShot();
	public abstract void moveEnemy();
	public int getPosInEnemies(){
		return posInEnemies;
	}
}