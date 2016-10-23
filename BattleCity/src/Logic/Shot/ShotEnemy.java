package Logic.Shot;

import Logic.Map.*;
import Logic.Tank.Enemy;
import Logic.Tank.Player;

public class ShotEnemy extends Shot implements Runnable{
	
	Enemy enemy;
	private volatile boolean execute;
	
	public ShotEnemy(String dir, int x, int y, Map map, int speed, Enemy ene, int posx, int posy){
		super(dir,x,y,map,speed,posx,posy);
		enemy=ene;
		this.execute=true;
	}
	public void terminate(){
		this.execute=false;
	}
	public void run(){
		while(execute){
			if(!move()){
				terminate();
				kill();
			}
			try {
				Thread.sleep(speed);
			} catch (InterruptedException e){
			}
		}
	}

	protected int kill(){
		enemy.enableShot();
		map.getGraphicMap().deleteShot(graphic.getPosInShots());
		return 0;
	}
	public int kill(Player pla){
		return 0;
	}
	public int kill(Enemy ene){
		return 0;
	}
/*	public boolean collide(Player pla){
	}
	public boolean collide(Enemy ene){
	}*/
}