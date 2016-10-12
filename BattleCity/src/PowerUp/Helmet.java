package PowerUp;

import Mapa.*;
import Tanque.Enemy;
import Tanque.Player;

public class Helmet extends PowerUp{
	public Helmet(int x, int y, int posX, int posY, Map map){
		super("Casco", x, y, posX, posY, map);
	}
	
	protected int kill(){
		map.deleteObstacle(posX, posY);
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