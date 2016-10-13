package Shot;

import Mapa.Map;
import Tanque.Enemy;
import Tanque.Player;

public class ShotEnemy extends Shot implements Runnable{
	
	Enemy enemy;
	private volatile boolean execute;
	
	public ShotEnemy(String dir, int x, int y, Map map, int speed, Enemy ene){
		super(dir,x,y,map,speed);
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
		map.deleteShot(posInShots);
		return 0;
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