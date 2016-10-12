package Shot;

import Mapa.Map;
import Tanque.Enemy;
import Tanque.Player;

public class ShotEnemy extends Shot{
	
	Enemy enemy;
	
	public ShotEnemy(String dir, int x, int y, Map map, int speed, Enemy ene){
		super(dir,x,y,map,speed);
		enemy=ene;
	}
	
	

	protected int kill(){
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