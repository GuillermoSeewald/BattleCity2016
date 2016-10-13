package Shot;

import Mapa.Map;
import Tanque.*;

public class ShotPlayer extends Shot implements Runnable{
	
	Player player;
	private volatile boolean execute;
	
	public ShotPlayer(String dir, int x, int y, Map map, int speed, Player pla){
		super(dir,x,y,map,speed);
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
		map.deleteShot(posInShots);
		return 1;
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