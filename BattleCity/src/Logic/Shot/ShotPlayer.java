package Logic.Shot;

import Logic.Map.*;
import Logic.Tank.*;

public class ShotPlayer extends Shot implements Runnable{
	
	Player player;
	private volatile boolean execute;
	
	public ShotPlayer(String dir, int x, int y, Map map, int speed, Player pla, int posx, int posy){
		super(dir,x,y,map,speed,posx,posy);
		player=pla;
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
		player.setSimultaneousShots(player.getSimultaneousShots()+1);
		map.getGraphicMap().deleteShot(graphic.getPosInShots());
		return 1;
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
		
	}
	*/
}