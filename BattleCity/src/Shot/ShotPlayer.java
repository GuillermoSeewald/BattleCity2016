package Shot;

import Mapa.Map;
import Tanque.*;

public class ShotPlayer extends Shot{
	
	Player player;
	
	public ShotPlayer(String dir, int x, int y, Map map, int speed, Player pla){
		super(dir,x,y,map,speed);
		player=pla;
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