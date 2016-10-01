package PowerUp;

import Mapa.*;

public class Helmet extends PowerUp{
	public Helmet(int x, int y, int posX, int posY, Map map){
		super("Casco", x, y, posX, posY, map);
	}
	
	public int kill(){
		map.deleteObstacle(posX, posY);
		return 0;
	}
/*	public boolean collide(Player jug){
	
	}
	public boolean collide(Enemy ene){
		
	}
	*/
}