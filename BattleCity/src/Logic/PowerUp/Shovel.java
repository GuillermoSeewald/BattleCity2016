package Logic.PowerUp;

import Logic.Map.*;
import Logic.Tank.*;
import Graphic.PowerUp.*;

public class Shovel extends PowerUp{
	
	protected GraphicShovel graphic;
	
	public Shovel(int x, int y, int posX, int posY, Map map){
		super(posX, posY, map);
		graphic= new GraphicShovel(x,y,"Pala");
	}
	public GraphicShovel getGraphic(){
		return graphic;
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
/*	public boolean collide(Player pla){
	
	}
	public boolean collide(Enemy ene){
		
	}
	*/
}