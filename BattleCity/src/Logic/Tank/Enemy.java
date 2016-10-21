package Logic.Tank;

import Logic.Map.*;

public abstract class Enemy extends Character{
	
	protected int posInEnemies;
	protected boolean haveShot;
	
	
	public Enemy(int speedMov,int res,String dir, Map map, int posE, int posx, int posy){
		super(speedMov,res,dir,map,posx,posy);
		posInEnemies=posE;
	}
	public abstract void terminate();
	public abstract void enableShot();
	public int getPosInEnemies(){
		return posInEnemies;
	}
}