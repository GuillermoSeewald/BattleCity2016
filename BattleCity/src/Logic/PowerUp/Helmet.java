package Logic.PowerUp;

import Logic.Map.*;
import Logic.Tank.*;
import Graphic.PowerUp.*;

public class Helmet extends PowerUp{
	
	protected GraphicHelmet graphic;
	
	public Helmet(int x, int y, int posX, int posY, Map map){
		super(posX, posY, map);
		graphic= new GraphicHelmet(x,y,"Casco");
	}
	public GraphicHelmet getGraphic(){
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